package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.vo.Permission;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public PageModel<Sgdxx> getSgdList() {
        List<Sgdxx> sgdList = null;
        try {
            sgdList = sgdxxService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sgdList != null) {
            PageModel<Sgdxx> result = new PageModel<>(sgdList, sgdList.size());
            return result;
        }
        return null;
    }
}
