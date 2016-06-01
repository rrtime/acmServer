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
import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.service.AtHoldFunctionService;

/**
 * @Title:       AtHoldFunctionAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 系统功能操作权限Action
 * 
 * <p>
 * 	系统功能操作权限Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtHoldFunctionAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5062151660583538120L;

	@Resource
	private AtHoldFunctionService atHoldFunctionService;
	
	private List<AtHoldFunction> atHoldFunctionList = new ArrayList<AtHoldFunction>();
	
	private AtHoldFunction atHoldFunction = new AtHoldFunction();
	//要授权的用户或用户组
	private AtUser atUser = new AtUser();
	
	private AtSysMenu atSysMenu = new AtSysMenu();
	
	private PageObject page = new PageObject();
	
	//格式是“menuCode:funName:funId,menuCode:funName:funId,menuCode:funName::funId”
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
	 * 跳转至功能详细操作字典新增页面
	 * 
	 * */
	public String toAddAtHoldFunctionPage(){
		this.setCmd(0);
		return "addAtHoldFunction";
	}
	
	/**
	 * 系统功能操作权限新增
	 * */
	public String addAtHoldFunctionInfo()
	{
		rst = atHoldFunctionService.addAtHoldFunction(idInfos,atUser,atUser1.getUserName());
//		rst = atHoldFunctionService.addAtHoldFunction(idInfos,atUser,"y");
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtHoldFunctionList();
	}
	
	/**
	 * 跳转至功能详细操作字典修改页面
	 * 
	 * */
	public String toModAtHoldFunctionPage(){
		this.setCmd(1);
		this.setAtHoldFunction(atHoldFunctionService.queryDetailInfo(atHoldFunction.getId()));
		return "modAtHoldFunction";
	}
	
	/**
	 * 修改系统功能操作权限
	 * 
	 * */
	public String modAtHoldFunction()
	{
		rst = atHoldFunctionService.modAtHoldFunction(idInfos, atUser, atSysMenu.getId(),atUser1.getUserName());
//		rst = atHoldFunctionService.modAtHoldFunction(idInfos, atUser, atSysMenu.getId(),"y");
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtHoldFunctionList();
	}
	
	/**
	 * 查询当前系统功能操作权限列表
	 * */
	public String queryAtHoldFunctionList()
	{
		this.setAtHoldFunctionList(atHoldFunctionService.queryListByPage(atHoldFunction, page));
		return "atHoldFunctionList";
	}

	/**
	 * 根据ActorId和treeId删除功能操作权限数据
	 * @param actorId
	 * @param treeId
	 */
	public int delAtHoldFunction(){
		return atHoldFunctionService.delHoldFunctionByActorIdAndTreeId(atUser.getId(), atSysMenu.getId());
	}
	
	/**
	 * 根据actorId和菜单树ID查询功能详细操作字典
	 * @param actorId
	 * @param treeId
	 * @return
	 */
	public List<Map<String, Object>> getModelFunctionByActorIdAndTreeId(){
		return atHoldFunctionService.getModelFunctionByActorIdAndTreeId(atUser.getId(), atSysMenu.getId());
	}
	
	/**
	 * 根据用户或者用户组ID查询菜单树字典
	 * @return
	 */
	public List<AtSysMenu> findAtSysMenuByActorId(){
		return atHoldFunctionService.findAtSysMenuByActorId(atUser.getId());
	}
	
	/**
	 * 根据用户或者用户组ID查询菜单附属功能字典
	 * @return
	 */
	public List<AtSysModel> findAtSysModelByActorId(){
		return atHoldFunctionService.findAtSysModelByActorId(atUser.getId());
	}
	
	/**
	 * 根据用户或者用户组ID查询功能详细操作字典
	 * @return
	 */
	public List<AtModelFunction> findModelFunctionByActorId(){
		return atHoldFunctionService.findModelFunctionByActorId(atUser.getId());
	}
	
	/**
	 * 根据menuCode查询系统功能操作权限
	 * @param menuCode
	 */
	public List<AtHoldFunction> findHoldFunctionByMenuCode(){
		return atHoldFunctionService.findHoldFunctionByMenuCode(atHoldFunction.getMenuCode());
	}
	
	
	public AtHoldFunctionService getAtHoldFunctionService() {
		return atHoldFunctionService;
	}

	public void setAtHoldFunctionService(AtHoldFunctionService atHoldFunctionService) {
		this.atHoldFunctionService = atHoldFunctionService;
	}

	public List<AtHoldFunction> getAtHoldFunctionList() {
		return atHoldFunctionList;
	}

	public void setAtHoldFunctionList(List<AtHoldFunction> atHoldFunctionList) {
		this.atHoldFunctionList = atHoldFunctionList;
	}

	public AtHoldFunction getAtHoldFunction() {
		return atHoldFunction;
	}

	public void setAtHoldFunction(AtHoldFunction atHoldFunction) {
		this.atHoldFunction = atHoldFunction;
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
