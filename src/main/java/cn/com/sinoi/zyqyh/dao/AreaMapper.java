package cn.com.sinoi.zyqyh.dao;

import org.springframework.stereotype.Repository;

import cn.com.sinoi.zyqyh.vo.Area;

@Repository
public interface AreaMapper {
	
    int deleteByPrimaryKey(String areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}