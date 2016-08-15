package cn.com.sinoi.zyqyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinoi.zyqyh.dao.RoleMapper;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Role;

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
