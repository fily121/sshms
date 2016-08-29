package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.utils.ShiroUtils;
import cn.com.sinoi.zyqyh.vo.Message;
import cn.com.sinoi.zyqyh.vo.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpSession;
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
@RequestMapping("xcgl")
public class XcglController {

    private static final Logger logger = Logger.getLogger(XcglController.class);

    @Autowired
    ISgdxxService sgdxxService;

    @Autowired
    IMessageService messageService;

    @Autowired
    IUserService userService;

    /**
     * 现场管理
     *
     * @return
     */
    @RequestMapping("xcglManage.do")
    public String xcglManage(String menuId, HttpSession session) {
        session.setAttribute("menuId", menuId);
        return "xcgl/xcglManage";
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
        List<String> userIdList = sgdxxService.findUserIdByGcdId(id);
        model.addAttribute("userIdList", userIdList);
        User user = ShiroUtils.getUserBySubject(userService);
        if (user != null) {
            model.addAttribute("userId", user.getUserId());
        }
        SearchParams params = new SearchParams();
        Map<String, Object> map = new HashMap<>();
        map.put("toSgdId", id);
        Date now = new Date();
        if (StringUtils.isEmpty(datetime)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            datetime = dateFormat.format(now);
            map.put("datetime", datetime);
            params.setSearchParams(map);
        }
        model.addAttribute("datetime", datetime);
        try {
            List<Message> messageList = messageService.findByCondition(params);
            model.addAttribute("messageList", messageList);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(XcglController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "xcgl/sgdgl";
    }

    /**
     * 现场检查
     *
     * @param model
     * @return
     */
    @RequestMapping("sgdgl.do")
    public String sgdgl(Model model) {
        return "xcgl/sgdgl";
    }

    /**
     * 现场检查
     *
     * @param model
     * @return
     */
    @RequestMapping("xcjcManage.do")
    public String xcjcManage(String menuId, HttpSession session) {
        session.setAttribute("menuId", menuId);
        return "xcgl/xcjcManage";
    }
}
