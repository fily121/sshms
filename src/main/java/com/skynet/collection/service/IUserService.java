package com.skynet.collection.service;

import java.util.List;

import com.skynet.collection.utils.Pagination;
import com.skynet.collection.utils.SearchParams;
import com.skynet.collection.vo.User;

public interface IUserService extends IBaseService<User> {
	
	int save(User record) throws Exception;
	
	int delete(String id) throws Exception;
	
	int update(User record) throws Exception;
	
	User get(User record) throws Exception;
	
	User selectById(String id) throws Exception;
	
	User selectByUserName(String userName) throws Exception;
	
	List<User> findAll() throws Exception;
	
	Pagination<User> findByCondication(SearchParams params) throws Exception;
}
