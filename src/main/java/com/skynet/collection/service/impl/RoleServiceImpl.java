package com.skynet.collection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skynet.collection.dao.RoleMapper;
import com.skynet.collection.service.IRoleService;
import com.skynet.collection.utils.SearchParams;
import com.skynet.collection.vo.Role;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findByCondition(SearchParams params) throws Exception {
		return null;
	}

	@Override
	public List<Role> findAll() throws Exception {
		return null;
	}

	@Override
	public List<Role> selectRolesByRoleId(String roleId) {
		return this.roleMapper.selectRolesByRoleId(roleId);
	}

}
