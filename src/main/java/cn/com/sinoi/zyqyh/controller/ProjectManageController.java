package cn.com.sinoi.zyqyh.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Title: 基础管理管理控制器
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
@RequestMapping("projectManage")
public class ProjectManageController {

    private static final Logger logger = Logger.getLogger(ProjectManageController.class);

    @RequestMapping("projectManage.do")
    public String projectManage(String menuId, HttpSession session) {
        session.setAttribute("menuId", menuId);
        return "projectManage/projectManage";
    }
}
