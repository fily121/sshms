package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.service.IOrderService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("div/baseManage")
public class BaseDivController {

    private static final Logger logger = Logger.getLogger(BaseDivController.class);
    @Autowired
    ISgdxxService sgdxxService;
    @Autowired
    IOrderService orderService;

    @RequestMapping("addModifyOrder.do")
    public String addModifyOrder(String id, Model model) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                OrderDetail order = orderService.selectByOrderId(id);
                model.addAttribute("order", order);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "baseManage/addModifyOrder";
    }

    @RequestMapping("addModifySgdxx.do")
    public String addModifySgdw(String id, Model model) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                Sgdxx sgdxx = sgdxxService.selectByPrimaryKey(id);
                model.addAttribute("sgdxx", sgdxx);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "system/addModifySgdxx";
    }
}
