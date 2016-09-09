package cn.com.sinoi.zyqyh.controller.mobile;

import cn.com.sinoi.zyqyh.service.IWechatService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class MobileController {

    private static final Logger logger = Logger.getLogger(MobileController.class);
    @Autowired
    private IWechatService wechatService;

    @RequestMapping("orderManage.do")
    public String projectManage(String code, Model model) {
        String result = wechatService.loginWithCode(code);
        if (StringUtils.isNotEmpty(result)) {
            model.addAttribute("errorMessage", result);
            return "mobile/error";
        }
        return "mobile/orderManage";
    }

}
