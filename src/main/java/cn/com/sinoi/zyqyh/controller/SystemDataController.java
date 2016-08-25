package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.utils.ShiroUtils;
import cn.com.sinoi.zyqyh.vo.Permission;
import cn.com.sinoi.zyqyh.vo.Role;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.UserDetail;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
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
@RequestMapping("data/system")
public class SystemDataController {

    private static final Logger logger = Logger.getLogger(SystemDataController.class);

    @Autowired
    IPermissionService permissionService;

    @Autowired
    ISgdxxService sgdxxService;

    @Autowired
    IRoleService roleService;

    @Autowired
    private IUserService userService;

    @RequestMapping("getMenuList.do")
    @ResponseBody
    public PageModel<Permission> getMenuList() {
        List<Permission> permissionList = null;
        try {
            permissionList = permissionService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (permissionList != null) {
            PageModel<Permission> result = new PageModel<>(permissionList, permissionList.size());
            return result;
        }
        return null;
    }

    @RequestMapping("getSgdList.do")
    @ResponseBody
    public PageModel<Sgdxx> getSgdList(Integer page, Integer rows) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        List<Sgdxx> sgdList = null;
        try {
            sgdList = sgdxxService.findAllForPage(page, rows);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sgdList != null) {
            PageModel<Sgdxx> result = new PageModel<>(sgdList, sgdList.size());
            result.setPage(page);
            return result;
        }
        return null;
    }

    @RequestMapping("getUserList.do")
    @ResponseBody
    public PageModel<UserDetail> getUserList(Integer page, Integer rows) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        List<UserDetail> userList = null;
        try {
            userList = userService.findAllForPage(page, rows);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (userList != null) {
            PageModel<UserDetail> result = new PageModel<>(userList, userList.size());
            result.setPage(page);
            return result;
        }
        return null;
    }

    /**
     * 修改 密码
     *
     * @return
     */
    @RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> changePassword(String password1, String password2, String password3, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        User loginUser = ShiroUtils.getUserBySubject(userService);
        Map<String, String> result = new HashMap<>();
        if (!loginUser.getUserPwd().equals(password1)) {
            result.put("code", "false");
            result.put("message", "原密码不正确，请重试。");
            return result;
        }
        loginUser.setUserPwd(password3);
        userService.update(loginUser);
        result.put("code", "true");
        result.put("message", "修改成功，请重新登录。");
        return result;
    }

    @RequestMapping(value = "getAllRole.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Role> getAllRole() {
        List<Role> result = Collections.EMPTY_LIST;
        try {
            result = roleService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @RequestMapping(value = "getAllSgd.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Sgdxx> getAllSgd() {
        List<Sgdxx> result = Collections.EMPTY_LIST;
        try {
            result = sgdxxService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
