package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.service.IClglService;
import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.Clxx;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Title: 材料管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 杜保军
 *
 * <pre>
 *         修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
@RequestMapping("div/cllqgl")
public class CllqglDivController {

    private static final Logger logger = Logger.getLogger(CllqglDivController.class);
    @Autowired
    IClglService clglService;

    @RequestMapping("addModifyCllqgl.do")
    public String addModifyCllqgl(String id, Model model) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                CllqGl cllqGl = clglService.selectByPrimaryKey(id);
                model.addAttribute("cllqGl", cllqGl);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "system/addModifyCllqgl";
    }

    @RequestMapping("addModifyClxx.do")
    public String addModifyClxx(String id, Model model) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                Clxx clxx = clglService.selectClxxByPrimaryKey(id);
                model.addAttribute("clxx", clxx);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "system/addModifyClxx";
    }
}
