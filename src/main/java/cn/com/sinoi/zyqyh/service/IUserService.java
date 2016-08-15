package cn.com.sinoi.zyqyh.service;

import java.util.List;

import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.User;

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
