/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtSysMenuService;

/**
 * @Title:       GroupJigouAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 系统菜单树字典表
 * 
 * <p>
 * 	系统菜单树字典表
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

	private List<AtSysMenu> asoList = new ArrayList<AtSysMenu>();
	
	private static final long serialVersionUID = 1L;
	
	private int cmd;
	
	private int rst;
	
	private String msg;
	
	//组织机构分页查询
	public String menuList(){
		asoList = asoservice.queryMenu(aso, page);
		return "list";
	}
	
	//打开新增页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//新增机构用户
	public String insertMenu(){
		rst = asoservice.addMenu(aso);
		if(rst == 0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		return menuList();
	}
	//修改机构用户
	public String updateMenu(){
		rst = asoservice.updateMenu(aso);
		if(rst == 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return menuList();
	}
	//删除机构用户
	public String deleteMenu(){
		rst= asoservice.deleteMenu(aso.getId());
		if(rst == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		return menuList();
	}
	//编辑页面
	public String editMenu(){
		setCmd(1);
		setAso(asoservice.queryMenuById(aso.getId()));
		return "add";
	}
	//根据用户Id查询当前用户的菜单权限
	public String findByUserId(){
		asoList = asoservice.queryByUserId(atUser.getId());
		return "findByUserId";
	}
	
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

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getRst() {
		return rst;
	}

	public void setRst(int rst) {
		this.rst = rst;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
