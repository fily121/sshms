package com.skynet.collection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.skynet.collection.dao.UserMapper;
import com.skynet.collection.service.IUserService;
import com.skynet.collection.utils.Pagination;
import com.skynet.collection.utils.SearchParams;
import com.skynet.collection.vo.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int save(User record) {
		return this.userMapper.insert(record);
	}

	@Override
	public int delete(String id) {
		return this.userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(User record) {
		return this.userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public User get(User record) {
		return null;
	}

	@Override
	public User selectById(String id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> findAll() {
		return this.userMapper.findAll();
	}

	@Override
	public Pagination<User> findByCondication(SearchParams params) {
		PageHelper.startPage(params.getPage(), params.getRows());
		List<User> list = this.userMapper.findByCondication(params);
		return new Pagination<User>(list);
	}

	@Override
	public User selectByUserName(String userName) {
		return this.userMapper.selectByUserName(userName);
	}

	@Override
	public List<User> findByCondition(SearchParams params) throws Exception {
		return this.userMapper.findByCondication(params);
	}
}
