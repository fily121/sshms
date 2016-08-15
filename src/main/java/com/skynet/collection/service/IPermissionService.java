package com.skynet.collection.service;

import java.util.List;
import com.skynet.collection.vo.Permission;

public interface IPermissionService extends IBaseService<Permission> {

	List<Permission> selectPermissionsByRoleId(String roleId) throws Exception;
}
