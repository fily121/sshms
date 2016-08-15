package com.skynet.collection.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skynet.collection.vo.Role;

@Repository
public interface RoleMapper {
	
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectRolesByRoleId(String roleId);
}