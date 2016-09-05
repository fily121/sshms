package cn.com.sinoi.zyqyh.controller.wechatController;

import cn.com.sinoi.zyqyh.service.IWechatService;
import cn.com.sinoi.zyqyh.weixin.WxMpServiceInstance;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IWechatService wechatService;

    @RequestMapping(value = "sendMessage.do", method = RequestMethod.GET)
    public void sendMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        WxMpServiceInstance.getInstance().doResponse(request, response, null);
    }

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public void sendMessagePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        WxMpServiceInstance.getInstance().doResponse(request, response, wechatService);
    }
}
