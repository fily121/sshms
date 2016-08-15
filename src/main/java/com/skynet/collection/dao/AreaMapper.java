package com.skynet.collection.dao;

import org.springframework.stereotype.Repository;

import com.skynet.collection.vo.Area;

@Repository
public interface AreaMapper {
	
    int deleteByPrimaryKey(String areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}