package com.skynet.ssm.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class UserTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserTest.class);

	@Autowired
	private IUserService userSercice;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@Test
	public void test() {
/*		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("admin");
		user.setPassWord("admin");
		user.setIsLocked(0);
		user.setRoleId("");
		user.setCreateDate(new Date());
		userSercice.save(user);*/
//		try {
//			List<Role> roleList = this.roleService.selectRolesByRoleId("51f91d81-cffa-449d-b0a4-4740de53b9eb");
//			List<Permission> perList = this.permissionService.selectPermissionsByRoleId("51f91d81-cffa-449d-b0a4-4740de53b9eb");
//			logger.info(perList.size());
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
	}

}
