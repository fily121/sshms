package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.definition.Certificate;
import cn.com.sinoi.zyqyh.definition.Education;
import cn.com.sinoi.zyqyh.definition.Gangwei;
import cn.com.sinoi.zyqyh.definition.MajorEnum;
import cn.com.sinoi.zyqyh.definition.YonggType;
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
    public String addModifyUser(String userId, Model model, boolean view) {
        if (StringUtils.isNotEmpty(userId)) {
            try {
                User user = userService.selectById(userId);
                model.addAttribute("user", user);
                model.addAttribute("education", Education.getList());
                model.addAttribute("major", MajorEnum.getList());
                model.addAttribute("certificate", Certificate.getList());
                model.addAttribute("gangwei", Gangwei.getList());
                model.addAttribute("yongglx", YonggType.getList());
            } catch (Exception ex) {
                Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        model.addAttribute("view", view);
        return "system/addModifyUser";
    }

}
