package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.vo.Message;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import cn.com.sinoi.zyqyh.weixin.MessageUtil;
import cn.com.sinoi.zyqyh.weixin.WeixinUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * Title: 系统管理控制器
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
@RequestMapping("data/xcgl")
public class XcglDataController {

    private static final Logger logger = Logger.getLogger(XcglDataController.class);
    @Autowired
    IMessageService messageService;
    @Autowired
    IUserService userService;
    @Autowired
    ISgdxxService sgdxxService;

    @Value("#{readProperties['wechat.corpId']}")
    private String corpId;
    @Value("#{readProperties['wechat.secret']}")
    private String secret;

    /**
     * 接受浏览器的消息
     *
     * @return
     */
    @RequestMapping(value = "reciveMessage.do", method = RequestMethod.POST)
    @ResponseBody
    public String reciveMessage(String msg, DateTime datetime, String gcdId) {
        if ("&nbsp;".equals(msg)) {
            return "false";
        }
        Subject currentUser = SecurityUtils.getSubject();
        String userName = ((UsernamePasswordToken) currentUser.getPrincipal()).getUsername();
        Message message = new Message();
        message.setId(java.util.UUID.randomUUID().toString());
        message.setContent(msg);
        message.setTosgdid(gcdId);
        message.setFromuser(userName);
        message.setTime(datetime.toDate());
        messageService.insert(message);
        String access_token = WeixinUtil.getAccessToken(corpId, secret).getToken();

        try {
            Sgdxx sgdxx = sgdxxService.selectByPrimaryKey(gcdId);
            User user = userService.selectById(sgdxx.getDuizhang());
            String jsonString = MessageUtil.getYichangMessage(user.getOpenid(), "操作隐患提醒", "操作提醒", msg);
            WeixinUtil.PostMessage(access_token, "POST", MessageUtil.MB_SEND_URL, jsonString);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(XcglDataController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "true";
    }

    /**
     * 接受浏览器的消息
     *
     * @return
     */
    @RequestMapping(value = "getCheduiXX.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getCheduiXX(String cph) {
        Map<String, String> result = new HashMap<>();
        SgdxxDetail sgdxx = sgdxxService.selectByCph(cph);
        if (sgdxx == null || sgdxx.getSgdxx() == null) {
            result.put("sgdxx", "根据车牌号没有找到车队信息。");
            result.put("sgdId", "");
            return result;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("施工队名称：");
        builder.append(sgdxx.getSgdxx().getSgdmc());
        builder.append("<br/>");
        builder.append("施工队长：");
        builder.append(sgdxx.getUser().getName());
        builder.append("<br/>");
        builder.append("施工队详情：");
        builder.append(sgdxx.getSgdxx().getDetail());
        result.put("sgdxx", builder.toString());
        result.put("sgdId", sgdxx.getSgdxx().getId());
        return result;
    }
}
