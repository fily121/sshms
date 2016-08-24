package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.service.IPermissionService;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("system")
public class SystemController {

    private static final Logger logger = Logger.getLogger(SystemController.class);

    @Autowired
    IPermissionService permissionService;

    /**
     * 菜单管理
     *
     * @param model
     * @return
     */
    @RequestMapping("menuManage.do")
    public String menuManage(String menuId, HttpSession session) {
        session.setAttribute("menuId", menuId);
        return "system/menuManage";
    }

    /**
     * 用户管理
     *
     * @param model
     * @return
     */
    @RequestMapping("userManage.do")
    public String userManage(String menuId, HttpSession session) {
        session.setAttribute("menuId", menuId);
        return "system/userManage";
    }

    /**
     * 角色管理
     *
     * @param model
     * @return
     */
    @RequestMapping("roleManage.do")
    public String roleManage(String menuId, HttpSession session) {
        session.setAttribute("menuId", menuId);
        return "system/roleManage";
    }
}
