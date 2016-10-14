package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Role;
import cn.com.sinoi.zyqyh.vo.relate.RolePermission;
import java.util.List;

public interface IRoleService extends IBaseService<Role> {

    List<Role> selectRolesByRoleId(String roleId) throws Exception;

    List<RolePermission> findAllRole(String roleId);

    void updateByPrimaryKeySelective(Role role);

    void insert(Role role);

}
