package cn.com.sinoi.zyqyh.controller.mobile;

import cn.com.sinoi.zyqyh.controller.dataController.SystemDataController;
import cn.com.sinoi.zyqyh.definition.RoleEnum;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IOrderProjectService;
import cn.com.sinoi.zyqyh.service.IOrderService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.service.IWechatService;
import cn.com.sinoi.zyqyh.utils.ShiroUtils;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * Title: 现场管理控制器
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
public class MobileOrderController {

    private static final Logger logger = Logger.getLogger(MobileOrderController.class);
    @Autowired
    private IWechatService wechatService;

    @Autowired
    IOrderService orderService;
    @Autowired
    ISgdxxService sgdxxService;
    @Autowired
    IUserService userService;
    @Autowired
    IAttachmentService attachmentService;
    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @Autowired
    IOrderProjectService orderProjectService;

    @RequestMapping("orderManage.do")
    public String orderManage(String code, Model model) {
//        if (StringUtils.isEmpty(code)) {
//            model.addAttribute("errorMessage", "请从微信菜单打开");
//            return "mobile/error";
//        }
        String result = wechatService.loginWithCode(code);
        if (StringUtils.isNotEmpty(result)) {
            model.addAttribute("errorMessage", result);
            return "mobile/error";
        }
        return "mobile/orderManage";
    }

    public String viewOrder(String keywords, Model model) throws Exception {
        return "mobile/viewOrder";
    }

    @RequestMapping(value = "findOrder.do", method = RequestMethod.GET)
    public String findOrder(String keywords, Model model) throws Exception {
        User user = ShiroUtils.getUserBySubject(userService);
        String userId = null;
        if (RoleEnum.fromCode(user.getRoleId()) != RoleEnum.管理员用户) {
            userId = user.getOrgId();
        }
        List<OrderDetail> result = Collections.EMPTY_LIST;
        try {
            result = orderService.findAllForLimit(keywords, userId);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute("error", "查询失败");
        }
        model.addAttribute("orderList", result);
        return "mobile/orderList";
    }

    @RequestMapping("orderDetail.do")
    public String orderDetail(String orderId, Model model, boolean modify) {
        if (StringUtils.isNotEmpty(orderId)) {
            OrderDetail order = orderService.selectByOrderId(orderId);
            String attachmentId = order.getOrder().getAttachmentId();
            if (StringUtils.isNotEmpty(attachmentId)) {
                Attachment atta = attachmentService.findbyId(attachmentId);
                File file = new File(path + atta.getUri());
                if (file.exists()) {
                    model.addAttribute("files", file.listFiles());
                }
            }
            model.addAttribute("order", order);
            model.addAttribute("modify", modify);
        }
        return "mobile/orderDetail";
    }
}
