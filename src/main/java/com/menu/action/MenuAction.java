package com.menu.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.menu.model.Menu;
import com.menu.service.MenuService;
import com.menu.service.RepairServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

import framework.base.action.BaseAction;


public class MenuAction extends BaseAction implements ModelDriven<Menu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7477336195534905325L;
	@Autowired
	private MenuService menuService;

	private Menu menu = new Menu();
	
	private RepairServiceImpl repairService;

	public RepairServiceImpl getRepairService() {
		return repairService;
	}

	public void setRepairService(RepairServiceImpl repairService) {
		this.repairService = repairService;
	}

	/*
	 * 一次加载树所有节点，这里用的表对象是Tmenu
	 */
	public void getAllTreeNode() {				
		super.writeJson(menuService.getAllTreeNode());
	}
	
	/**
	 * 异步获取树节点
	 */
	public void getTreeNode() {
		super.writeJson(menuService.getTreeNode(menu.getId()));
	}
	
	/*
	 * 一次加载树所有节点
	 */
	public void getTree(){
		super.writeJson(menuService.getTreeMenu());
	}

	@Override
	public Menu getModel() {
		return menu;
	}

}
