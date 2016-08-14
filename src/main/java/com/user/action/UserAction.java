package com.user.action;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ModelDriven;
import com.user.model.PubUsers;
import com.user.pageModel.UsersPageModel;
import com.user.service.UserService;

import framework.base.action.BaseAction;
import framework.base.model.Json;
import framework.util.MD5Utils;

//public class UserAction extends BaseAction implements ModelDriven<User>{

public class UserAction extends BaseAction implements ModelDriven<UsersPageModel> {
	@Autowired
	private UserService userService;
	private MD5Utils md5;
	private UsersPageModel user;

	// 这里登录方法实际上没有用了，因为登录时已经被spring security拦截了进行验证，不再执行这个登录方法了
	public String login() {

		/*
		 * String passWord=md5.MD5Encode(users.getUserPassword());
		 * 
		 * params.put("password",passWord );
		 * 
		 * params.put("account",users.getUserAccount());
		 * 
		 * List<PubUsers> list= userService.login(params);
		 * 
		 * 
		 * if(list!=null && list.size()>0){ return SUCCESS; }
		 * 
		 * return ERROR;
		 */

		return null;

	}

	public void ajaxList() {

		super.writeJson(userService.datagrid(gridModel, user, param));

	}

	public void save() {

		Json j = new Json();
		try {

			UsersPageModel userModel = userService.save(user);

			j.setSuccess(true);
			j.setMsg("保存成功！");

			j.setObj(userModel);// userModel的作用是给前台easyUI显示更新的数据用
		} catch (Exception e) {
			j.setMsg(e.getMessage());

			logger.error(e.getMessage());
		}

		super.writeJson(j);

	}

	public void delete() {

		Json j = new Json();
		try {

			logger.warn(user.getUserId());

			userService.delete(param);

			j.setSuccess(true);
			j.setMsg("删除成功！");

		} catch (Exception e) {
			j.setMsg(e.getMessage());

			logger.error(e.getMessage());
		}

		super.writeJson(j);
	}

	public void update() {

		Json j = new Json();
		try {

			PubUsers userModel = userService.update(user);

			j.setSuccess(true);
			j.setMsg("保存成功！");

			j.setObj(userModel);// userModel的作用是给前台easyUI显示更新的数据用
		} catch (Exception e) {
			j.setMsg(e.getMessage());

			logger.error(e.getMessage());
		}

		super.writeJson(j);

	}

	// 修改密码
	public void changePassword() {
		Json j = new Json();

		String newPassword = param.get("newPassword");
		String oldPassword = param.get("oldPassword");

		// 从security中取出用户，
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String account = principal.toString();

		if (principal instanceof UserDetails) {
			account = ((UserDetails) principal).getUsername();

			if (account == "" || account == null) {
				j.setMsg("你可能登录已经超时，请重新登录后再操作！");
				j.setSuccess(false);

				super.writeJson(j);
				return;
			}

			// 根据账号取出用户信息，主要取密码出来跟输入的“原密码”比较是否正确
			PubUsers userInfo = userService.userInfo(account);

			if (userInfo.getUserPassword().equals(md5.MD5Encode(oldPassword))) {

				param.put("account", account);

				param.put("password", md5.MD5Encode(newPassword));

				try {

					if (userService.changePassWord(param) > 0) {

						j.setMsg("密码修改成功");
						j.setSuccess(false);

						super.writeJson(j);
					}

				} catch (SQLException e) {

					j.setMsg("数据异常，请重试 ！");
					j.setSuccess(false);

					super.writeJson(j);

					logger.error(e.getMessage());

				} catch (Exception e) {

					j.setMsg("服务器遇到未知异常，请联系管理员 ！");
					j.setSuccess(false);

					super.writeJson(j);

					logger.error(e.getMessage());
				}
			} else {

				j.setMsg("原密码不正确，请重试 ！");
				j.setSuccess(false);

				super.writeJson(j);

			}

		}

	}

	public UsersPageModel getUser() {
		return user;
	}

	public void setUser(UsersPageModel user) {
		this.user = user;
	}

	@Override
	public UsersPageModel getModel() {
		if (user == null) {
			user = new UsersPageModel();
		}
		return user;
	}

	public MD5Utils getMd5() {
		return md5;
	}

	public void setMd5(MD5Utils md5) {
		this.md5 = md5;
	}

}
