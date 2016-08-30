package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("div/xcgl")
public class XcglDivController {

    private static final Logger logger = Logger.getLogger(XcglDivController.class);

    @Autowired
    ISgdxxService sgdxxService;

    @Autowired
    IMessageService messageService;

    @Autowired
    IUserService userService;

    /**
     * 施工队位置信息
     *
     * @return
     */
    @RequestMapping("sgdwzxx.do")
    public String xcglManage() {
        return "xcgl/sgdwzxx";
    }
}
