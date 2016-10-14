package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.definition.Certificate;
import cn.com.sinoi.zyqyh.definition.Education;
import cn.com.sinoi.zyqyh.definition.Gangwei;
import cn.com.sinoi.zyqyh.definition.MajorEnum;
import cn.com.sinoi.zyqyh.definition.YonggType;
import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.vo.Permission;
import cn.com.sinoi.zyqyh.vo.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    IRoleService roleService;

    @Autowired
    IPermissionService permissionService;

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

    @RequestMapping("addModifyRole.do")
    public String addModifyRole(String roleId, String roleName, String perIds, Model model) throws Exception {
        model.addAttribute("roleId", roleId);
        model.addAttribute("roleName", new String(roleName.getBytes("ISO-8859-1"), "utf-8"));
        if (StringUtils.isEmpty(perIds)) {
            model.addAttribute("perIds", "''");
        } else {
            String perIdArray = "['" + perIds + "']";
            perIdArray = perIdArray.replaceAll("\\,", "'\\,'").replaceAll(" ", "");
            model.addAttribute("perIds", perIdArray);
        }
        return "system/addModifyRole";
    }

    @RequestMapping("findPerList.do")
    @ResponseBody
    public PageModel<Permission> findPerList() throws Exception {
        List<Permission> permissons = permissionService.findAll();
        return new PageModel<>(permissons, permissons.size());
    }
}
