/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.service.AtFieldRelService;

/**
 * @Title:       AtFieldRelAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 用户字段权限关系Action
 * 
 * <p>
 *  用户字段权限关系Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtFieldRelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1864190238276459565L;

	@Resource
	private AtFieldRelService atFieldRelService;
	
	private List<AtFieldRel> atFieldRelList = new ArrayList<AtFieldRel>();
	
	private AtFieldRel atFieldRel = new AtFieldRel();
	
	private AtUser atUser = new AtUser();
	
	private AtSysMenu atSysMenu = new AtSysMenu();
	
	private PageObject page = new PageObject();
	
	//格式是“menuCode:rname:privilegeType:fid,menuCode:rname:privilegeType:fid,menuCode:rname:privilegeType:fid”
	private String idInfos;
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	//操作员即当前登陆人
	AtUser atUser1 = (AtUser) session.getAttribute("user");
	
	
	/**
	 * 跳转至系统权限字段字典新增页面
	 * 
	 * */
	public String toAddAtFieldRelPage(){
		this.setCmd(0);
		return "addAtFieldRel";
	}
	
	/**
	 * 用户字段权限关系新增
	 * */
	public String addAtFieldRelInfo()
	{
		rst = atFieldRelService.addAtFieldRel(idInfos,atUser,atUser1.getUserName());
//		rst = atFieldRelService.addAtFieldRel(idInfos,atUser,"y");
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtFieldRelList();
	}
	
	/**
	 * 跳转至系统权限字段字典修改页面
	 * 
	 * */
	public String toModAtFieldRelPage(){
		this.setCmd(1);
		this.setAtFieldRel(atFieldRelService.queryDetailInfo(atFieldRel.getId()));
		return "modAtFieldRel";
	}
	
	/**
	 * 修改用户字段权限关系
	 * 
	 * */
	public String modAtFieldRel()
	{
		rst = atFieldRelService.modAtFieldRel(idInfos,atUser,atUser1.getUserName(),atSysMenu.getId());
//		rst = atFieldRelService.modAtFieldRel(idInfos,atUser,"y",atSysMenu.getId());
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtFieldRelList();
	}
	
	/**
	 * 查询当前用户字段权限关系列表
	 * */
	public String queryAtFieldRelList()
	{
		this.setAtFieldRelList(atFieldRelService.queryListByPage(atFieldRel, page));
		return "atFieldRelList";
	}

	/**
	 * 根据uid和treeId删除用户字段权限关系
	 * @param uid
	 * @param treeId
	 */
	public int delAtFieldRel(){
		return atFieldRelService.delAtFieldRelByUidAndTreeId(atUser.getId(), atSysMenu.getId());
	}
	
	/**
	 * 
	 * 用户字段权限关系查询
	 * 
	 * */
	public List<AtFieldRel> findAll(){
		return atFieldRelService.findAll();
	}
	
	/**
	 * 根据用户或组ID和treeId查询用户字段权限关系
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> findAtFieldRelByUidAndTreeId(){
		return atFieldRelService.findAtFieldRelByUidAndTreeId(atUser.getId(), atSysMenu.getId());
	}
	
	/**
	 * 根据用户或组ID和menuCode查询用户字段权限关系
	 * @param uid
	 * @param menuCode
	 * @return
	 */
	public List<AtFieldRel> findAtFieldRelByUidAndMenuCode(){
		return atFieldRelService.findAtFieldRelByUidAndMenuCode(atUser.getId(), atFieldRel.getMenuCode());
	}
	
	/**
	 * 查询用户字段权限关系列表(分页)
	 * 
	 * */
	public List<AtFieldRel> queryListByPage(){
		return atFieldRelService.queryListByPage(atFieldRel, page);
	}
	
	/**
	 * 查询用户字段权限关系详情
	 * 
	 * */
	public AtFieldRel queryDetailInfo(){
		return atFieldRelService.queryDetailInfo(atFieldRel.getId());
	}
	
	

	public AtFieldRelService getAtFieldRelService() {
		return atFieldRelService;
	}

	public void setAtFieldRelService(AtFieldRelService atFieldRelService) {
		this.atFieldRelService = atFieldRelService;
	}

	public List<AtFieldRel> getAtFieldRelList() {
		return atFieldRelList;
	}

	public void setAtFieldRelList(List<AtFieldRel> atFieldRelList) {
		this.atFieldRelList = atFieldRelList;
	}

	public AtFieldRel getAtFieldRel() {
		return atFieldRel;
	}

	public void setAtFieldRel(AtFieldRel atFieldRel) {
		this.atFieldRel = atFieldRel;
	}

	public PageObject getPage() {
		return page;
	}

	public void setPage(PageObject page) {
		this.page = page;
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

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

	public AtSysMenu getAtSysMenu() {
		return atSysMenu;
	}

	public void setAtSysMenu(AtSysMenu atSysMenu) {
		this.atSysMenu = atSysMenu;
	}

	public String getIdInfos() {
		return idInfos;
	}

	public void setIdInfos(String idInfos) {
		this.idInfos = idInfos;
	}

	
}
