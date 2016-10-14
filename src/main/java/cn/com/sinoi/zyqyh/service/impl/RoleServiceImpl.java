package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.RoleMapper;
import cn.com.sinoi.zyqyh.service.IRoleService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Role;
import cn.com.sinoi.zyqyh.vo.relate.RolePermission;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.roleMapper.findAll();
    }

    @Override
    public List<Role> selectRolesByRoleId(String roleId) {
        Map<String, String> parameter = new HashMap<>();
        parameter.put("roleId", roleId);
        return this.roleMapper.selectRolesByRoleId(parameter);
    }

    @Override
    public List<RolePermission> findAllRole(String roleId) {
        return this.roleMapper.findAllRole(roleId);
    }

    @Override
    public void updateByPrimaryKeySelective(Role role) {
        this.roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void insert(Role role) {
        this.roleMapper.insert(role);
    }

}
