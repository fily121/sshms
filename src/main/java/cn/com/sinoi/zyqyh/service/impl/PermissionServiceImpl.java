package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.PermissionMapper;
import cn.com.sinoi.zyqyh.service.IPermissionService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Permission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.permissionMapper.findAll();
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(String roleId) {
        return this.permissionMapper.selectPermissionsByRoleId(roleId);
    }

}
