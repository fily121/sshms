package cn.com.sinoi.zyqyh.dao;

import org.springframework.stereotype.Repository;

import cn.com.sinoi.zyqyh.vo.Race;

@Repository
public interface RaceMapper {
	
    int deleteByPrimaryKey(String raceId);

    int insert(Race record);

    int insertSelective(Race record);

    Race selectByPrimaryKey(String raceId);

    int updateByPrimaryKeySelective(Race record);

    int updateByPrimaryKey(Race record);
}