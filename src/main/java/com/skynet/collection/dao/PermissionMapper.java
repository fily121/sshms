package com.skynet.collection.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.skynet.collection.vo.Permission;

@Repository
public interface PermissionMapper {
	
    int deleteByPrimaryKey(String perId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String perId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> findAllByRoleId(String roleId);
    
    List<Permission> selectPermissionsByRoleId(String roleId);
    
}