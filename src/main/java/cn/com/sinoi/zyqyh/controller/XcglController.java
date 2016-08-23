package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.service.ISgdxxService;
import java.util.List;
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
@RequestMapping("xcgl")
public class XcglController {

    private static final Logger logger = Logger.getLogger(XcglController.class);

    @Autowired
    ISgdxxService sgdxxService;

    /**
     * 现场管理
     *
     * @return
     */
    @RequestMapping("xcglManage.do")
    public String xcglManage() {
        return "xcgl/xcglManage";
    }

    /**
     * 现场联系
     *
     * @param model
     * @return
     */
    @RequestMapping("xclx.do")
    public String xclx(Model model, String id) {
        model.addAttribute("gcdId", id);
        List<String> userIdList = sgdxxService.findUserIdByGcdId(id);
        model.addAttribute("userIdList", userIdList);
        return "xcgl/sgdgl";
    }

    /**
     * 现场检查
     *
     * @param model
     * @return
     */
    @RequestMapping("sgdgl.do")
    public String sgdgl(Model model) {
        return "xcgl/sgdgl";
    }

    /**
     * 现场检查
     *
     * @param model
     * @return
     */
    @RequestMapping("xcjcManage.do")
    public String xcjcManage(Model model) {
        return "xcgl/xcjcManage";
    }
}
