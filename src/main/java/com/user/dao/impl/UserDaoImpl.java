package com.user.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.dao.UserDaoI;
import com.user.model.PubUsers;

@Repository(value="userDao")
public class UserDaoImpl implements UserDaoI {
           
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<String> findAuthByUsername(String username) {
		
		
		Session session=this.sessionFactory.openSession();
		
		Query userQuery = session
				.createSQLQuery(
						" SELECT role_name FROM pub_roles WHERE role_id IN(SELECT role_id FROM pub_users_roles WHERE user_id IN( SELECT user_id FROM pub_users  WHERE user_name='"+username+"' ) )");
		
		List userList = userQuery.list();
		
		session.close();

	/*	for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
		       Object oo = (Object) iterator.next();
		       
		      System.out.println(oo.toString());
		}*/		
		return userList;
	}

	@Override
	public PubUsers userInfo(String username) {
		PubUsers user = new PubUsers();
		
		Session session=this.sessionFactory.openSession();
		
		Query userQuery = session.createQuery("from PubUsers users where users.userAccount=?");
		
		userQuery.setString(0, username);
		
		List<PubUsers> userList=(List<PubUsers>)userQuery.list();
			
		session.close();
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
		
			user=(PubUsers) iterator.next();
			//System.out.println(user.getUserName());
			//System.out.println(user.getUserPassword());
		}
	
		return user;
	}

	//配置事务后，直接使用，就可保存数据进数据库了
	@Override
	public void save(PubUsers t) {
	
        Session session=this.sessionFactory.getCurrentSession();
	
		session.save(t);	
	}
	
	
	//这个方法是在没有配置spring事务时使用的测试，这里我已经测试过了，在UserDaoI中已经删除了这个接口
	public void saveTest(PubUsers t){
		
		//方法1，不能成功
		 /* Session session=this.sessionFactory.getCurrentSession();
		  session.save(t);	*/
		  
		 //2，不成功
	/*	Session session=this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();		
		session.save(t);
		tx.commit();//这里一提交，数据就保存进数据库了
		*/
		
		 //方法3，不成功
		/* Session session=this.sessionFactory.openSession();
		 session.save(t);	*/
	
		 //方法4，事务提交后，成功保存数据到数据库
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();		
		session.save(t);
		tx.commit();//这里一提交，数据就保存进数据库了       		 
	}

	@Override
	public int findMaxId() {
		
		Session session=this.sessionFactory.getCurrentSession();
		
		Query q=session.createSQLQuery("SELECT MAX(user_id) AS userId FROM pub_users");
		
		List list=q.list();
	
		Integer maxId=0;
		 
		Integer size=list.size();//size就为1，因为查出来应该只有一个数，如果为0，就代表为空了
	
	    if(size==1){
	
			maxId=(Integer) list.get(0);
		}	
	    
		return maxId;
	}

}
