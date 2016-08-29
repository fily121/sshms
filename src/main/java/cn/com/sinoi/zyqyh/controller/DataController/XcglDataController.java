package cn.com.sinoi.zyqyh.controller.DataController;

import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.vo.Message;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
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
        Message message = new Message();
        message.setId(java.util.UUID.randomUUID().toString());
        message.setContent(msg);
        message.setTosgdid(gcdId);
        message.setFromuser(((UsernamePasswordToken) currentUser.getPrincipal()).getUsername());
        message.setTime(datetime.toDate());
        messageService.insert(message);
        return "true";
    }
}
