package com.skynet.collection.dao;

import org.springframework.stereotype.Repository;
import com.skynet.collection.vo.RolePersKey;

@Repository
public interface RolePersMapper {
	
    int deleteByPrimaryKey(RolePersKey key);

    int insert(RolePersKey record);

    int insertSelective(RolePersKey record);
    
}