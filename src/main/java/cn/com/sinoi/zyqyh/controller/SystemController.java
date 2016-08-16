package cn.com.sinoi.zyqyh.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.com.sinoi.zyqyh.service.ICollectionInfoService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.utils.VerifyCodeUtil;
import cn.com.sinoi.zyqyh.vo.CollectionInfo;
import cn.com.sinoi.zyqyh.vo.User;

/**
 * <p>
 * Title: 系统管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 强成西
 *          <pre>
 *          修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
@RequestMapping("system")
public class SystemController {

	private static final Logger logger = Logger.getLogger(SystemController.class);
	/**
	 * 菜单管理
	 * @param model
	 * @return
	 */
	@RequestMapping("menuManage.do")
	public String menuManage(Model model) {
		return "system/menuManage";
	}
	/**
	 * 用户管理
	 * @param model
	 * @return
	 */
	@RequestMapping("userManage.do")
	public String userManage(Model model) {
		return "system/userManage";
	}
	
	/**
	 * 角色管理
	 * @param model
	 * @return
	 */
	@RequestMapping("roleManage.do")
	public String roleManage(Model model) {
		return "system/roleManage";
	}
}
