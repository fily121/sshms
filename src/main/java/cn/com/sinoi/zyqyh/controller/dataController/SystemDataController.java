package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.controller.SystemController;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.utils.FileUtil;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.utils.ShiroUtils;
import cn.com.sinoi.zyqyh.utils.UrlDownloadFile;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.Permission;
import cn.com.sinoi.zyqyh.vo.Role;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.UserDetail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @Autowired
    IPermissionService permissionService;

    @Autowired
    IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAttachmentService attachmentService;

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

    @RequestMapping("getUserList.do")
    @ResponseBody
    public PageModel<UserDetail> getUserList(Integer page, Integer rows, String searchKey) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        List<UserDetail> userList = null;
        try {
            userList = userService.findAllForPage(page, rows, searchKey);
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

    /**
     * 增加修改用户
     *
     * @param user
     * @param response
     * @return
     */
    @RequestMapping(value = "addModifyUser.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addModifyUser(User user, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> result = new HashMap<>();
        try {
            if (StringUtils.isEmpty(user.getUserId())) {
                User existUser = userService.selectByUserName(user.getUserName());
                if (existUser != null) {
                    result.put("code", "false");
                    result.put("message", "用户名已存在。");
                    return result;
                }
                user.setUserId(java.util.UUID.randomUUID().toString());
                if (StringUtils.isEmpty(user.getUserPwd())) {
                    user.setUserPwd(user.getUserName());
                }
                userService.save(user);
                result.put("code", "true");
                result.put("message", "保存成功。");
            } else {
                userService.update(user);
                result.put("code", "true");
                result.put("message", "修改成功。");
            }
        } catch (Exception ex) {
            result.put("code", "false");
            result.put("message", ex.getMessage());
        }
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

    @RequestMapping(value = "getAllUser.do", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getAllUser() {
        List<User> result = Collections.EMPTY_LIST;
        try {
            result = userService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @RequestMapping(value = "deleteUser.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(String userId) {
        try {
            userService.delete(userId);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Boolean.TRUE.toString();
    }

    @RequestMapping(value = "downloadFile.do")
    @ResponseBody
    public void downloadFile(String attachmentId, HttpServletResponse response) throws IOException, Exception {
        if (StringUtils.isEmpty(attachmentId)) {
            return;
        }
        Attachment attachment = attachmentService.findbyId(attachmentId);
        if (attachment == null) {
            response.getWriter().print("附件id:" + attachmentId + ",对应的文件数据库中不存在。");
            return;
        }
        UrlDownloadFile.downLoadFileLocal(path + attachment.getUri() + "/" + attachment.getFileName(), response, false);
    }

    @RequestMapping(value = "uploadUserFile.do", method = RequestMethod.POST)
    @ResponseBody
    public String uploadUserFile(@RequestParam(value = "userFile", required = false) MultipartFile userFile, HttpServletResponse response) throws IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        List<String[]> list = FileUtil.parseExlToList(userFile);
        StringBuilder errorMessage = new StringBuilder();
        List<User> userList = new ArrayList<>();
        Map<String, Integer> userNameMap = new HashMap<>();
        Map<String, Integer> wechatMap = new HashMap<>();
        for (int i = 1; i < list.size(); i++) {
            User user = new User();
            String[] str = list.get(i);
            if (str.length != 5) {
                errorMessage.append((i + 1) + "行有空字段。<br/>");
            } else {
                user.setUserName(str[1]);
                user.setUserPwd(str[2]);
                user.setName(str[3]);
                user.setWechatNo(str[4]);
                if (StringUtils.isEmpty(user.getUserName())) {
                    errorMessage.append((i + 1) + "行用户名不能为空。<br/>");
                }
                User userExists = userService.selectByUserName(user.getUserName());
                if (userExists != null) {
                    errorMessage.append((i + 1) + "行用户名已存在。<br/>");
                }
                if (userNameMap.containsKey(str[1])) {
                    errorMessage.append((i + 1) + "行与" + userNameMap.get(str[1]) + "行，用户名重复。<br/>");
                } else {
                    userNameMap.put(user.getUserName(), i + 1);
                }
                if (wechatMap.containsKey(user.getWechatNo())) {
                    errorMessage.append((i + 1) + "行与" + wechatMap.get(user.getWechatNo()) + "行，微信号重复。<br/>");
                } else {
                    wechatMap.put(user.getWechatNo(), i + 1);
                }
                userList.add(user);
            }
        }
        if (StringUtils.isEmpty(errorMessage.toString())) {
            if (userList.isEmpty()) {
                errorMessage.append("导入文件为空。");
                return errorMessage.toString();
            }

            for (User user : userList) {
                user.setUserId(java.util.UUID.randomUUID().toString());
                userService.save(user);
            }
            errorMessage.append("导入用户成功。");
            return errorMessage.toString();
        }

        return errorMessage.toString();
    }
}
