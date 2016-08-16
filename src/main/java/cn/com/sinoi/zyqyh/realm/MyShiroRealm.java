package cn.com.sinoi.zyqyh.realm;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.vo.Permission;
import cn.com.sinoi.zyqyh.vo.Role;
import cn.com.sinoi.zyqyh.vo.User;

/**
 * <p>Title: 自定义的系统ShrioRealm</p>
 * <p>Description: </p>
 *
 * @author 强成西
 * 
 * <pre>
 * 修改记录:
 * 版本号    修改人        修改日期       修改内容
 */
public class MyShiroRealm extends AuthorizingRealm {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MyShiroRealm.class);

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		UsernamePasswordToken token = (UsernamePasswordToken) principal.getPrimaryPrincipal();
		//角色集合
		Set<String> roles = new HashSet<String>();
		//权限集合
		Set<String> permissions = new HashSet<String>();
		try {
			User user = this.userService.selectByUserName(token.getUsername());
			List<Role> roleList = this.roleService.selectRolesByRoleId(user.getRoleId());
			for (Role role : roleList) {
				roles.add(role.getRoleName());
			}
			List<Permission> permissionList = this.permissionService.selectPermissionsByRoleId(user.getRoleId());
			for (Permission permission : permissionList) {
				permissions.add(permission.getPerName());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    authorizationInfo.addRoles(roles);
	    authorizationInfo.addStringPermissions(permissions);
	    return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		String username = (String) token.getPrincipal();
		try {
			User user = this.userService.selectByUserName(username);
			if (user == null) {
				throw new UnknownAccountException("用户名或密码错误");
			}
			info = new SimpleAuthenticationInfo(token, user.getUserPwd(), this.getName());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		/* if(Boolean.TRUE.equals(user.getIsLocked())) {  
	        throw new LockedAccountException(); //帐号锁定  
	    } */
		return info;
	}

}
