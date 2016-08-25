package cn.com.sinoi.zyqyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Title: 系统管理子页面控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 强成西
 */
@Controller
@RequestMapping("div/system")
public class SystemDivController {

    @RequestMapping("addUser.do")
    public String addUser() {
        return "system/addUser";
    }

}
