package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.controller.XcglController;
import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.utils.ShiroUtils;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.MessageExt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Title: 现场管理控制器
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
@RequestMapping("div/xcgl")
public class XcglDivController {

    private static final Logger logger = Logger.getLogger(XcglDivController.class);

    @Autowired
    ISgdxxService sgdxxService;

    @Autowired
    IMessageService messageService;

    @Autowired
    IUserService userService;

    /**
     * 施工队位置信息
     *
     * @return
     */
    @RequestMapping("sgdwzxx.do")
    public String xcglManage() {
        return "xcgl/sgdwzxx";
    }

    /**
     * 施工队位置信息
     *
     * @return
     */
    @RequestMapping("sgdlianxi.do")
    public String sgdlianxi() {
        return "xcgl/sgdlianxi";
    }

    /**
     * 现场联系
     *
     * @param model
     * @return
     */
    @RequestMapping("xclx.do")
    public String xclx(Model model, String id, String datetime) {
        model.addAttribute("gcdId", id);
        User user = ShiroUtils.getUserBySubject(userService);
        if (user != null) {
            model.addAttribute("userName", user.getUserName());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("tosgdid", id);
        Date now = new Date();
        if (StringUtils.isEmpty(datetime)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            datetime = dateFormat.format(now);
        }
        map.put("time", datetime);
        model.addAttribute("datetime", datetime);
        try {
            List<MessageExt> messageList = messageService.findRelateByCondition(map);
            model.addAttribute("messageList", messageList);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(XcglController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "xcgl/sgdgl";
    }
}
