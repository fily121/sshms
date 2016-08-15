package com.skynet.collection.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skynet.collection.dao.PermissionMapper;
import com.skynet.collection.service.IPermissionService;
import com.skynet.collection.utils.SearchParams;
import com.skynet.collection.vo.Permission;

@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> findByCondition(SearchParams params) throws Exception {
		return null;
	}

	@Override
	public List<Permission> findAll() throws Exception {
		return null;
	}

	@Override
	public List<Permission> selectPermissionsByRoleId(String roleId) {
		return this.permissionMapper.selectPermissionsByRoleId(roleId);
	}

}
