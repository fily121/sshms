package me.chanjar.weixin.common.util.crypto;

import java.io.StringReader;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class WxCryptUtil {

    private static final Base64 base64 = new Base64();
    private static final Charset CHARSET = Charset.forName("utf-8");

    private static final ThreadLocal<DocumentBuilder> builderLocal = new ThreadLocal() {
        protected DocumentBuilder initialValue() {
            try {
                return DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException exc) {
                throw new IllegalArgumentException(exc);
            }
        }
    };
    protected byte[] aesKey;
    protected String token;
    protected String appidOrCorpid;

    public WxCryptUtil() {
    }

    public WxCryptUtil(String token, String encodingAesKey, String appidOrCorpid) {
        this.token = token;
        this.appidOrCorpid = appidOrCorpid;
        this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
    }

    public String encrypt(String plainText) {
        String encryptedXml = encrypt(genRandomStr(), plainText);

        String timeStamp = timeStamp = Long.toString(System.currentTimeMillis() / 1000L);
        String nonce = genRandomStr();
        try {
            String signature = SHA1.gen(new String[]{this.token, timeStamp, nonce, encryptedXml});
            return generateXml(encryptedXml, signature, timeStamp, nonce);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    protected String encrypt(String randomStr, String plainText) {
        ByteGroup byteCollector = new ByteGroup();
        byte[] randomStringBytes = randomStr.getBytes(CHARSET);
        byte[] plainTextBytes = plainText.getBytes(CHARSET);
        byte[] bytesOfSizeInNetworkOrder = number2BytesInNetworkOrder(plainTextBytes.length);
        byte[] appIdBytes = this.appidOrCorpid.getBytes(CHARSET);

        byteCollector.addBytes(randomStringBytes);
        byteCollector.addBytes(bytesOfSizeInNetworkOrder);
        byteCollector.addBytes(plainTextBytes);
        byteCollector.addBytes(appIdBytes);

        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);

        byte[] unencrypted = byteCollector.toBytes();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(this.aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(this.aesKey, 0, 16);
            cipher.init(1, keySpec, iv);

            byte[] encrypted = cipher.doFinal(unencrypted);

            return base64.encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String msgSignature, String timeStamp, String nonce, String encryptedXml) {
        String cipherText = extractEncryptPart(encryptedXml);
        try {
            String signature = SHA1.gen(new String[]{this.token, timeStamp, nonce, cipherText});
            if (!signature.equals(msgSignature)) {
                throw new RuntimeException("加密消息签名校验失败");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        String result = decrypt(cipherText);
        return result;
    }

    public String decrypt(String cipherText) {
        byte[] original;
        String xmlContent;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec key_spec = new SecretKeySpec(this.aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(this.aesKey, 0, 16));
            cipher.init(2, key_spec, iv);

            byte[] encrypted = Base64.decodeBase64(cipherText);

            original = cipher.doFinal(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String from_appid;
        try {
            byte[] bytes = PKCS7Encoder.decode(original);

            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);

            int xmlLength = bytesNetworkOrder2Number(networkOrder);

            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
            from_appid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length),
                    CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!from_appid.equals(this.appidOrCorpid)) {
            throw new RuntimeException("AppID不正确");
        }

        return xmlContent;
    }

    private byte[] number2BytesInNetworkOrder(int number) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = ((byte) (number & 0xFF));
        orderBytes[2] = ((byte) (number >> 8 & 0xFF));
        orderBytes[1] = ((byte) (number >> 16 & 0xFF));
        orderBytes[0] = ((byte) (number >> 24 & 0xFF));
        return orderBytes;
    }

    private int bytesNetworkOrder2Number(byte[] bytesInNetworkOrder) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= bytesInNetworkOrder[i] & 0xFF;
        }
        return sourceNumber;
    }

    private String genRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    private String generateXml(String encrypt, String signature, String timestamp, String nonce) {
        String format
                = "<xml>\n<Encrypt><![CDATA[%1$s]]></Encrypt>\n<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n<TimeStamp>%3$s</TimeStamp>\n<Nonce><![CDATA[%4$s]]></Nonce>\n</xml>";

        return String.format(format, new Object[]{encrypt, signature, timestamp, nonce});
    }

    static String extractEncryptPart(String xml) {
        try {
            DocumentBuilder db = (DocumentBuilder) builderLocal.get();
            Document document = db.parse(new InputSource(new StringReader(xml)));

            Element root = document.getDocumentElement();
            return root.getElementsByTagName("Encrypt").item(0).getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
