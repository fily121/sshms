package cn.com.sinoi.zyqyh.weixin;

import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import org.xml.sax.InputSource;

/**
 * @author Daniel Qian
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WxMpXMLInMemoryConfigStorage extends WxMpInMemoryConfigStorage {

    @Override
    public String toString() {
        return "SimpleWxConfigProvider [appId=" + appId + ", secret=" + secret + ", accessToken=" + accessToken
                + ", expiresIn=" + expiresIn + ", token=" + token + ", aesKey=" + aesKey + "]";
    }

    public static WxMpXMLInMemoryConfigStorage fromXml(InputStream is) throws JAXBException {
        Unmarshaller um = JAXBContext.newInstance(WxMpXMLInMemoryConfigStorage.class).createUnmarshaller();
        InputSource inputSource = new InputSource(is);
        inputSource.setEncoding("utf-8");
        return (WxMpXMLInMemoryConfigStorage) um.unmarshal(inputSource);
    }

}
