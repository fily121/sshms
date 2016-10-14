package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Role;
import cn.com.sinoi.zyqyh.vo.relate.RolePermission;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectRolesByRoleId(Map<String, String> parameter);

    List<Role> findAll();

    List<RolePermission> findAllRole(String roleId);
}
