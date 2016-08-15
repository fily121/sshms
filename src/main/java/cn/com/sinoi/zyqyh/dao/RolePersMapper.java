package cn.com.sinoi.zyqyh.dao;

import org.springframework.stereotype.Repository;

import cn.com.sinoi.zyqyh.vo.RolePersKey;

@Repository
public interface RolePersMapper {
	
    int deleteByPrimaryKey(RolePersKey key);

    int insert(RolePersKey record);

    int insertSelective(RolePersKey record);
    
}