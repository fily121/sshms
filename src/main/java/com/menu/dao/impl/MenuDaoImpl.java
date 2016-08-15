package com.menu.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.menu.dao.MenuDaoI;
import com.menu.model.Tmenu;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDaoI {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void getMenu() {
		
		Tmenu root = new Tmenu();
		root.setId("0");
		root.setText("首页");
		root.setUrl("");
		this.sessionFactory.getCurrentSession().saveOrUpdate(root);
	}

}
