package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.vo.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Title: 系统管理子页面控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 强成西
 */
@Controller
@RequestMapping("div/system")
public class SystemDivController {

    @Autowired
    IUserService userService;

    @RequestMapping("addModifyUser.do")
    public String addModifyUser(String userId, Model model) {
        if (StringUtils.isNotEmpty(userId)) {
            try {
                User user = userService.selectById(userId);
                model.addAttribute("user", user);
            } catch (Exception ex) {
                Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "system/addModifyUser";
    }

}
