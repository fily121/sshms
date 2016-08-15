package cn.com.sinoi.zyqyh.service;

import java.util.List;

import cn.com.sinoi.zyqyh.vo.Permission;

public interface IPermissionService extends IBaseService<Permission> {

	List<Permission> selectPermissionsByRoleId(String roleId) throws Exception;
}
