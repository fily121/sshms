package com.user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.user.model.PubUsers;

public interface UserDaoI {

	public List<String> findAuthByUsername(String username);
	
	public PubUsers userInfo(String username);

	public void save(PubUsers t);
	
	public int findMaxId();
	
	
}
