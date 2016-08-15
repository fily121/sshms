package com.skynet.collection.dao;

import org.springframework.stereotype.Repository;

import com.skynet.collection.vo.Race;

@Repository
public interface RaceMapper {
	
    int deleteByPrimaryKey(String raceId);

    int insert(Race record);

    int insertSelective(Race record);

    Race selectByPrimaryKey(String raceId);

    int updateByPrimaryKeySelective(Race record);

    int updateByPrimaryKey(Race record);
}