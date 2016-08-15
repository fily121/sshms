package com.menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menu.model.Menu;
import com.menu.model.Tmenu;
import com.user.model.PubResources;
import com.user.pageModel.ResourcesMenu;

import framework.base.dao.BaseDaoI;

@Service("menuService")
public class MenuService {

	private BaseDaoI<Tmenu> menuDao;
	
	private BaseDaoI<PubResources> treeDao;

	public BaseDaoI<PubResources> getTreeDao() {
		return treeDao;
	}

	@Autowired
	public void setTreeDao(BaseDaoI<PubResources> treeDao) {
		this.treeDao = treeDao;
	}

	public BaseDaoI<Tmenu> getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(BaseDaoI<Tmenu> menuDao) {
		this.menuDao = menuDao;
	}

	public List<Menu> getTreeNode(String id) {
		List<Menu> nl = new ArrayList<Menu>();
		String hql = null;
		Map<String, Object> params = new HashMap<String, Object>();
		if (id == null || id.equals("")) {
			// 查询所有根节点
			hql = "from Tmenu t where t.tmenu is null";
		} else {
			// 异步加载当前id下的子节点
			hql = "from Tmenu t where t.tmenu.id = :id ";
			params.put("id", id);
		}
		List<Tmenu> l = menuDao.find(hql, params);
		if (l != null && l.size() > 0) {
			for (Tmenu t : l) {
				Menu m = new Menu();
				BeanUtils.copyProperties(t, m);
				Set<Tmenu> set = t.getTmenus();
				if (set != null && !set.isEmpty()) {
					m.setState("closed");// 节点以文件夹的形式体现
				} else {
					m.setState("open");// 节点以文件的形式体现
				}
				nl.add(m);
			}
		}
		return nl;
	}

	public List<Menu> getAllTreeNode() {

		List<Menu> nl = new ArrayList<Menu>();
		String hql = "from Tmenu t";
		List<Tmenu> l = menuDao.find(hql);
	
		if (l != null && l.size() > 0) {
			for (Tmenu t : l) {
				Menu m = new Menu();
				//将t中和m中相同的属性复制进m中，因为t中的pid属性封装为了类，所以要另外给m赋值
				BeanUtils.copyProperties(t, m);
				
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", t.getUrl());
				m.setAttributes(attributes);
				Tmenu tm = t.getTmenu();// 获得当前节点的父节点对象
				if (tm != null) {
					m.setPid(tm.getId());//将pid赋值给m
				}
				nl.add(m);
			}
		}
	
		return nl;
	}
	
	/*
	 *封闭树数据
	 *下面只不过是在数据库中取出数据，封装为前台树需要的数据格式  
	 */
	public List<ResourcesMenu> getTreeMenu() {
		
		//用来封闭树数据返回给前台的list
		List<ResourcesMenu> menu=new ArrayList<ResourcesMenu>();
		
		//用来设置查找参数的map
		Map<String, Object> params = new HashMap<String, Object>();
		
		//只查找jsp类型的数据
		params.put("resourceType", "jsp");
		
		//查找数据库中的树数据
		List<PubResources> listTree=treeDao.find("from PubResources t where t.resourceType = :resourceType", params);
		
		//遍历树数据
		for(PubResources resources:listTree){
			
			//每次新建一个对象，用来封装每个树节点
			ResourcesMenu resourcesMenu=new ResourcesMenu();
			
			//BeanUtils.copyProperties(resources, resourcesMenu);//因为两个类的成员变量不同，不能进行复制
			
			resourcesMenu.setId(resources.getResourceId());
			resourcesMenu.setText(resources.getResourceName());
		
			//这个对象封装url，必须返回attributes，前台树封装格式要求
			Map<String, Object> attributes = new HashMap<String, Object>();
			
			attributes.put("url", resources.getResourceString());
			
			resourcesMenu.setAttributes(attributes);
			
			PubResources res=resources.getPubResources();
			
			
			if(res!=null){
				//设置节点的父节点
				resourcesMenu.setPid(res.getResourceId());
				
			}
		
			menu.add(resourcesMenu);
		}
	
		return menu;
	}
	
}
