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
 * Title: 用户管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author Liujian
 * @version 1.00.00
 * 
 *          <pre>
 *          修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
@RequestMapping("user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private ICollectionInfoService collectionInfoService;

	@RequestMapping("login.do")
	public String login(Model model, String message_login) {
		if (message_login != null) {
			try {
				model.addAttribute("message_login", new String(message_login.getBytes("ISO-8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			}
		}
		return "user/login";
	}

	@RequestMapping("index.do")
	public String index(Model model, @ModelAttribute("params") SearchParams params) {
		Pagination<User> pageList = null;
		String resultPageURL = "user/index";
		try {
			User loginUser = getUserBySubject();
			if (loginUser.getIsGuest() == 1) { // 如果是来宾用户，则直接跳转到信息录入界面，已录入过信息的跳转到录入详情界面
				CollectionInfo collectionInfo = this.collectionInfoService.selectByIdCardNo(loginUser.getUserId());
				if (collectionInfo == null) { // 没有采集信息则跳转到新增页面，有则跳转详情页
					resultPageURL = "collection/add";
				} else {
					model.addAttribute("collectionInfo", collectionInfo);
					resultPageURL = "collection/view";
				}
			} else { // 系统用户展示列表
				pageList = this.userService.findByCondication(params);
				model.addAttribute("pageList", pageList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return resultPageURL;
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(User user, Model model, HttpServletRequest request) {
		String resultPageURL = InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/user/login.do";
		String username = user.getUserName();
		String password = user.getUserPwd();
		// 获取HttpSession中的验证码
		String verifyCode = (String) request.getSession().getAttribute("verifyCode");
		// 获取用户请求表单中输入的验证码
		String submitCode = user.getVerifyCode();
		logger.info("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");
		if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())) {
			model.addAttribute("message_login", "验证码不正确");
			return resultPageURL;
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		logger.info("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			// 尝试登录
			token.setRememberMe(true);
			currentUser.login(token);
			logger.info("对用户[" + username + "]进行登录验证..验证开始");
			logger.info("对用户[" + username + "]进行登录验证..验证通过");
			// 验证是否登录成功
			if (currentUser.isAuthenticated()) {
				resultPageURL = InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/user/index.do";
				logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
			} else {
				token.clear();
			}
		} catch (UnknownAccountException uae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
			model.addAttribute("message_login", "用户名或密码错误");
		} catch (IncorrectCredentialsException ice) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
			model.addAttribute("message_login", "用户名或密码错误");
		} catch (LockedAccountException lae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
			model.addAttribute("message_login", "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
			model.addAttribute("message_login", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			logger.error(ae.getMessage());
			model.addAttribute("message_login", "用户名或密码不正确");
		}
		return resultPageURL;
	}

	/**
	 * 获取验证码图片和文本(验证码保存在HttpSession中)
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getVerifyCodeImage.do")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) {
		// 设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		// 将验证码放到HttpSession里面
		request.getSession().setAttribute("verifyCode", verifyCode);
		logger.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 20, true, Color.WHITE,
				Color.BLACK, null);
		// 写给浏览器
		try {
			ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 注销登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/user/login.do";
	}

	/**
	 * 根据Shiro的登录用户名查询用户
	 * 
	 * @return
	 */
	public User getUserBySubject() {
		User user = null;
		try {
			UsernamePasswordToken token = (UsernamePasswordToken) SecurityUtils.getSubject().getPrincipal();
			user = this.userService.selectByUserName(token.getUsername());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	}

}
