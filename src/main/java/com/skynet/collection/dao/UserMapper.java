package com.skynet.collection.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.skynet.collection.utils.SearchParams;
import com.skynet.collection.vo.User;

@Repository
public interface UserMapper {
	
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> findAll();
    
    List<User> findByCondication(SearchParams params);
    
    User selectByUserName(String userName);
}