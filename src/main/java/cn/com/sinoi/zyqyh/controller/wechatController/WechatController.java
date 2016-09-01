package cn.com.sinoi.zyqyh.controller.wechatController;

import cn.com.sinoi.wechat.encryption.AesException;
import cn.com.sinoi.wechat.encryption.WXBizMsgCrypt;
import cn.com.sinoi.zyqyh.service.CoreService;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * Title: 基础管理管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 强成西
 *
 * <pre>
 *         修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
public class WechatController {

    @Value("#{readProperties['wechat.token']}")
    private String token;
    @Value("#{readProperties['wechat.encodingAESKey']}")
    private String encodingAESKey;
    @Value("#{readProperties['wechat.corpId']}")
    private String corpId;
    @Value("#{readProperties['wechat.secret']}")
    private String secret;

    @Autowired
    private CoreService wechatService;

    @RequestMapping(value = "sendMessage.do", method = RequestMethod.GET)
    public void sendMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 打印请求地址
        System.out.println("request=" + request.getRequestURL());
        // 流
        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        String result = null;
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(this.token, this.encodingAESKey, this.corpId);
            // 验证URL函数
            result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
        } catch (AesException e) {
            e.printStackTrace();
        }
        if (result == null) {
            // result为空，赋予token
            result = this.token;
        }
        // 拼接请求参数
        String str = msg_signature + " " + timestamp + " " + nonce + " " + echostr;
        // 打印参数+地址+result
        System.out.println("Exception:" + result + " " + request.getRequestURL() + " " + "FourParames:" + str);
        out.print(result);
        out.close();
        out = null;

    }

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public void sendMessagePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        // 从请求中读取整个post数据
        InputStream inputStream = request.getInputStream();
        // commons.io.jar 方法
        String Post = IOUtils.toString(inputStream, "UTF-8");
        // Post打印结果
        System.out.println(Post);

        String Msg = "";
        WXBizMsgCrypt wxcpt = null;
        try {
            wxcpt = new WXBizMsgCrypt(this.token, this.encodingAESKey, this.corpId);
            // 解密消息
            Msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, Post);
        } catch (AesException e) {
            e.printStackTrace();
        }
        // Msg打印结果
        System.out.println("Msg打印结果：" + Msg);

        // 调用核心业务类接收消息、处理消息
        String respMessage = wechatService.processRequest(Msg);

//        // respMessage打印结果
//        System.out.println("respMessage打印结果：" + respMessage);
//        String encryptMsg = "";
//        try {
//            // 加密回复消息
//            encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
//        } catch (AesException e) {
//            e.printStackTrace();
//        }
//
//        // 响应消息
//        PrintWriter out = response.getWriter();
//        out.print(encryptMsg);
//        out.close();
    }
}
