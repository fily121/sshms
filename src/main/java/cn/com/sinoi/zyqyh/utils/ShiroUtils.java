package cn.com.sinoi.zyqyh.utils;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import cn.com.sinoi.zyqyh.controller.UserController;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.vo.User;

public class ShiroUtils {
	private static final Logger logger = Logger.getLogger(UserController.class);
	/**
	 * 根据Shiro的登录用户名查询用户
	 * 
	 * @return
	 */
	public static User getUserBySubject(IUserService userService) {
		User user = null;
		try {
			UsernamePasswordToken token = (UsernamePasswordToken) SecurityUtils.getSubject().getPrincipal();
			user = userService.selectByUserName(token.getUsername());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	}
}
