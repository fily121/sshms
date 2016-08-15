package com.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserDaoI;
import com.user.model.PubUsers;
import com.user.pageModel.UsersPageModel;

import framework.base.dao.BaseDaoI;
import framework.base.model.DataGrid;
import framework.base.model.GridModel;
import framework.base.model.User;
import framework.util.MD5Utils;

@Service("userService")
//@Transactional 使用注解配置事务
public class UserService {

	private BaseDaoI<PubUsers> userDao;//BaseDaoI中使用了泛型参数，BaseDaoI的实现类里面基本上都实现了增、删、修改、查
	
	private UserDaoI userDaoi;//BaseDaoI里面没有的才使用这个dao，一般都不用了
	
	private MD5Utils md5;
	
	public List<PubUsers> login(Map<String, Object> params) {

		String hql="from PubUsers users where userAccount = :account and userPassword= :password";
		
		return userDao.find(hql, params);
		
	}
	
	public UsersPageModel save(UsersPageModel user) {
		PubUsers t = new PubUsers();
		// t.setName(user.getName());
		// t.setPwd(user.getPwd());
		BeanUtils.copyProperties(user, t);		
		
		t.setUserPassword(md5.MD5Encode(user.getUserPassword().trim()));	
		
		System.out.println(userDaoi.findMaxId());
		
		t.setUserId(userDaoi.findMaxId()+2);
		t.setEnabled(1);
		t.setIssys(1);
			
		userDao.save(t);
		
		BeanUtils.copyProperties(t, user);		
		
		return user;//返回user的作用是给前台easyUI显示更新的数据用
	}

	//下面3个注解都是用来配置事务的，只要在这个类的头部加上事务注解，就能保存数据进数据库，无论使用那个，都不会影响数据是提交
	/*
	 * 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
	 * @Transactional(propagation=Propagation.REQUIRED) 	
	*/
	
	/*不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
	 * 	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	 */

    /*容器不为这个方法开启事务
     * @Transactional(propagation=Propagation.NOT_SUPPORTED)
     */	
	/*这个方法是用来测试的，写在了UserDaoI里面了
	 * public User save(User user) throws Exception {
		PubUsers t = new PubUsers();
		
		BeanUtils.copyProperties(user, t);
		
		t.setUserId(88);
		t.setEnabled(1);
		t.setIssys(1);
		

		userDaoi.save(t);
	
		//throw new RuntimeException();//用来测试事务回滚
	
		return user;
	}
	*/
		
	public DataGrid datagrid(GridModel gridModel,UsersPageModel userMode, Map<String, String> param) {
		DataGrid dg = new DataGrid();
		String hql = "from PubUsers t ";
		
		//Map<String, Object> params = new HashMap<String, Object>();
		hql = addWhere(userMode, hql, param);
		
		String totalHql = "select count(*) " + hql;
		hql = addOrder(gridModel, hql);
		
		List<PubUsers> l = userDao.find(hql, param, gridModel.getPage(), gridModel.getRows());
		List<UsersPageModel> nl = new ArrayList<UsersPageModel>();
		
		changeModel(l, nl);
		
		dg.setTotal(userDao.count(totalHql, param));
		dg.setRows(nl);
		
		return dg;
	}

	

	private void changeModel(List<PubUsers> l, List<UsersPageModel> nl) {
		if (l != null && l.size() > 0) {
			for (PubUsers t : l) {
				UsersPageModel u = new UsersPageModel();
				BeanUtils.copyProperties(t, u);
				nl.add(u);
			}
		}
	}

	private String addOrder(GridModel gridModel, String hql) {
		if (gridModel.getSort() != null) {
			hql += " order by " + gridModel.getSort() + " " + gridModel.getOrder();
		}
		return hql;
	}

	private String addWhere(UsersPageModel userMode, String hql, Map<String, String> param) {
		
		hql += " where 1=1 ";
	
		if (userMode != null) {
			for (String key : param.keySet()) {
				
				//主键对应的值不能进行查找，否则会报错
				if(!param.get(key).equals("") && param.get(key)!=null){
				    hql+=" and "+ key +" like:"+key;
				}
			}
		}
	
		return hql;
	}

	
	public BaseDaoI<PubUsers> getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(BaseDaoI<PubUsers> userDao) {
		this.userDao = userDao;
	}

	public void delete(Map<String,String> param) {
		
		String hql = null;
		Map<String, Object> params = new HashMap<String, Object>();
	
		hql = "delete from pub_users  where user_id in ("+ param.get("keys") +") ";
				
		userDao.deleteBySql(hql);	

	}

	public UserDaoI getUserDaoi() {
		return userDaoi;
	}

	@Autowired
	public void setUserDaoi(UserDaoI userDaoi) {
		this.userDaoi = userDaoi;
	}

	public MD5Utils getMd5() {
		return md5;
	}

	public void setMd5(MD5Utils md5) {
		this.md5 = md5;
	}

	public PubUsers update(UsersPageModel user) {
		
		/*PubUsers u = new PubUsers();
	
		//BeanUtils.copyProperties(user, u, new String[] { "userPassword" });
		
		BeanUtils.copyProperties(user, u);
		
		u.setUserPassword("123456");
		u.setEnabled(1);
		u.setIssys(1);*/
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("userId", user.getUserId());
		params.put("userAccount", user.getUserAccount());
		params.put("userName", user.getUserName());
		params.put("userDesc", user.getUserDesc());		
		
		String hql="update from PubUsers set userAccount= :userAccount,userName=:userName,userDesc=:userDesc where userId=:userId";
		
	    userDao.executeHql(hql,params);
		
	    //用来返回数据给前台更新行数据
	    PubUsers u = new PubUsers();
	    BeanUtils.copyProperties(user, u);
	    
		return u;
	}

	
    public List<String> findAuthByUsername(String username){
    	return userDaoi.findAuthByUsername(username);
    }
	
	public PubUsers userInfo(String username){
		return userDaoi.userInfo(username);
	}
	
	public int changePassWord(Map<String, String> param) throws SQLException{
		
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("userPassword", param.get("password"));
        params.put("userAccount", param.get("account"));
	
		String hql="update from PubUsers set userPassword= :userPassword where userAccount=:userAccount";
		
	   return userDao.executeHql(hql,params);

	}
			
}
