package cn.com.sinoi.zyqyh.controller.mobile;

import cn.com.sinoi.zyqyh.controller.dataController.SystemDataController;
import cn.com.sinoi.zyqyh.definition.Certificate;
import cn.com.sinoi.zyqyh.definition.Education;
import cn.com.sinoi.zyqyh.definition.Gangwei;
import cn.com.sinoi.zyqyh.definition.MajorEnum;
import cn.com.sinoi.zyqyh.definition.YonggType;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.service.IWechatService;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * Title: 手机端施工队管理控制器
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
@RequestMapping("mobile")
public class MobileSgdxxController {

    private static final Logger logger = Logger.getLogger(MobileSgdxxController.class);
    @Autowired
    private IWechatService wechatService;

    @Autowired
    IUserService userService;

    @Autowired
    ISgdxxService sgdxxService;

    @RequestMapping(value = "addModifySgdxx.do", method = RequestMethod.GET)
    public String addModifySgdxx(Model model, String id) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                Sgdxx sgdxx = sgdxxService.selectByPrimaryKey(id);
                User user = userService.selectById(sgdxx.getDuizhang());
                if (user != null) {
                    model.addAttribute("duizhang", user.getName());
                }
                model.addAttribute("sgdxx", sgdxx);
            } catch (Exception ex) {
                logger.error(ex.getMessage());
            }
        }
        return "mobile/addModifySgdxx";
    }

    @RequestMapping(value = "searchSgd.do", method = RequestMethod.GET)
    public String searchSgd(String code, String keywords, Model model) throws Exception {
        //        if (StringUtils.isEmpty(code)) {
//            model.addAttribute("errorMessage", "请从微信菜单打开");
//            return "mobile/noauthorized";
//        }
        String result = wechatService.loginWithCode(code);
        if (StringUtils.isNotEmpty(result)) {
            model.addAttribute("errorMessage", result);
            return "mobile/noauthorized";
        }
        return "mobile/searchSgd";
    }

    @RequestMapping(value = "findSgdxx.do", method = RequestMethod.GET)
    @RequiresPermissions("sgd:edit")
    public String findSgdxx(String keywords, Model model) throws Exception {
        List<SgdxxDetail> result = Collections.EMPTY_LIST;
        try {
            result = sgdxxService.findAllForPage(1, 1000, keywords);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute("error", "查询失败");
        }
        model.addAttribute("sgdxxList", result);
        return "mobile/sgdxxList";
    }

    @RequestMapping("sgdxxDetail.do")
    public String sgdxxDetail(String id, Model model, boolean view) {
        if (StringUtils.isNotEmpty(id)) {
            Sgdxx sgdxx = sgdxxService.selectByPrimaryKey(id);
            model.addAttribute("sgdxx", sgdxx);
            if (sgdxx != null) {
                User user = userService.selectById(sgdxx.getDuizhang());
                if (user != null) {
                    model.addAttribute("duizhang", user.getName());
                }
                List<User> users = userService.findUsersBySgdId(sgdxx.getId());
                for (User u : users) {
                    u.setMajor(MajorEnum.getNameByCode(u.getMajor()));
                    u.setGangwei(Gangwei.getNameByCode(u.getGangwei()));
                    u.setYongglx(YonggType.getNameByCode(u.getYongglx()));
                    u.setZhengsmc(Certificate.getNameByCode(u.getZhengsmc()));
                    u.setGender(u.getGender() != null ? ("0".equals(u.getGender()) ? "男" : "女") : "");
                    u.setEducation(Education.getNameByCode(u.getEducation()));
                }
                model.addAttribute("users", users);
                model.addAttribute("major", userService.selectNumOfType("major", sgdxx.getId()));
                model.addAttribute("gangwei", userService.selectNumOfType("gangwei", sgdxx.getId()));
                model.addAttribute("yongglx", userService.selectNumOfType("yongglx", sgdxx.getId()));
                model.addAttribute("zhengsmc", userService.selectNumOfType("zhengsmc", sgdxx.getId()));
            }
            model.addAttribute("view", view);
            return "mobile/sgdxxDetail";
        }
        model.addAttribute("errorMessage", "施工队不存在");
        return "mobile/noauthorized";
    }
}
