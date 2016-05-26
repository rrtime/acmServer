/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.service.AtSysMenuService;

/**
 * @Title:       GroupJigouAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public class SysMenuAction extends ActionSupport{
	
	@Resource
	private AtSysMenuService asoservice;
	
	private PageObject page = new PageObject();

	private AtSysMenu aso = new AtSysMenu();
	
	private AtUser atUser = new AtUser();
	
	public PageObject getPage() {
		return page;
	}

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

	public AtSysMenu getAso() {
		return aso;
	}

	public void setAso(AtSysMenu aso) {
		this.aso = aso;
	}

	public List<AtSysMenu> getAsoList() {
		return asoList;
	}

	public void setAsoList(List<AtSysMenu> asoList) {
		this.asoList = asoList;
	}

	public void setPage(PageObject page) {
		this.page = page;
	}

	

	private List<AtSysMenu> asoList = new ArrayList<AtSysMenu>();
	
	private static final long serialVersionUID = 1L;
	
	//组织机构分页查询
	public String menuList(){
		asoList = asoservice.queryMenu(aso, page);
		return "list";
	}
	
	//新增机构用户
	@SuppressWarnings("unused")
	public String insertMenu(){
		int i = asoservice.addMenu(aso);
		return "insertMenu";
	}
	//修改机构用户
	@SuppressWarnings("unused")
	public String updateMenu(){
		int i = asoservice.updateMenu(aso);
		return "updateMenu";
	}
	//删除机构用户
	public String deleteMenu(){
		asoservice.deleteMenu(aso.getId());
		return menuList();
	}
	//新增页面
	public String addMenu(){
		return "edit";
	}
	//编辑页面
	public String editMenu(){
		aso = asoservice.queryMenuById(aso.getId());
		return "edit";
	}
	//根据用户Id查询当前用户的菜单权限
	public String findByUserId(){
		asoList = asoservice.queryByUserId(atUser.getId());
		return "findByUserId";
	}
}
