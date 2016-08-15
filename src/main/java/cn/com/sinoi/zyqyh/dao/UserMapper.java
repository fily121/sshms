package cn.com.sinoi.zyqyh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.User;

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