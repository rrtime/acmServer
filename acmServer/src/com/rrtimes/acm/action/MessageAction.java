/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    zl 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.serviceI.AtFieldDictService;
import com.rrtimes.acm.serviceI.AtFieldRelService;
import com.rrtimes.acm.serviceI.AtHoldFunctionService;
import com.rrtimes.acm.serviceI.AtModelFunctionService;
import com.rrtimes.acm.serviceI.AtSysMenuService;
import com.rrtimes.acm.serviceI.AtSysModelService;
import com.rrtimes.acm.serviceI.AtUserService;

/**
 * @Title: RoleAction.java
 * @Package: com.rrtimes.acm.action
 * @Description: 消息公告
 * 
 * @author zl
 * 
 */
public class MessageAction extends ActionSupport {

	private static final long serialVersionUID = 2954363164266848728L;
	@Resource
	private AtUserService userService;

	@Resource
	private AtSysMenuService menuService;
	
	@Resource
	private AtSysModelService atSysModelService;
	
	@Resource
	private AtModelFunctionService atSysModelFunctionService;
	
	@Resource
	private AtHoldFunctionService atHoldFunctionService;
	
	@Resource
	private AtFieldDictService atFieldDictService;
	
	@Resource
	private AtFieldRelService atFieldRelService;
	
	//角色对象
	private AtUser atUser = new AtUser();

	// 用户和用户组列表
	private List<AtUser> userList = new ArrayList<AtUser>();
	// 系统菜单列表
	private List<AtSysMenu> menuList = new ArrayList<AtSysMenu>();
	// 系统功能列表
	private List<AtSysModel> functionList = new ArrayList<AtSysModel>();
	// 系统功能操作字典列表
	private List<AtModelFunction> modelFunctionList = new ArrayList<AtModelFunction>();
	// 系统功能操作权限列表
	private List<AtHoldFunction> holdFunctionList = new ArrayList<AtHoldFunction>();
	// 系统权限字段列表
	private List<AtFieldDict> fieldDictList = new ArrayList<AtFieldDict>();
	// 用户字段权限关系列表
	private List<AtFieldRel> fieldRelList = new ArrayList<AtFieldRel>();

	//返回前台字段串
	private String msg;
	
	//角色ID
	private int roleId;
	
	//功能权限ID
	private String[] funIds;
	//字段权限ID
	private String[] fieldIds;

	//定义并取得会话对象
	HttpSession session = ServletActionContext.getRequest().getSession();

	/**
	 * 获取所有消息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		
		//返回前台页面
		return "list";
	}
	

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

	public List<AtUser> getUserList() {
		return userList;
	}

	public void setUserList(List<AtUser> userList) {
		this.userList = userList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<AtSysModel> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<AtSysModel> functionList) {
		this.functionList = functionList;
	}

	public List<AtSysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<AtSysMenu> menuList) {
		this.menuList = menuList;
	}

	public List<AtModelFunction> getModelFunctionList() {
		return modelFunctionList;
	}

	public void setModelFunctionList(List<AtModelFunction> modelFunctionList) {
		this.modelFunctionList = modelFunctionList;
	}

	public List<AtHoldFunction> getHoldFunctionList() {
		return holdFunctionList;
	}

	public void setHoldFunctionList(List<AtHoldFunction> holdFunctionList) {
		this.holdFunctionList = holdFunctionList;
	}

	public List<AtFieldDict> getFieldDictList() {
		return fieldDictList;
	}

	public void setFieldDictList(List<AtFieldDict> fieldDictList) {
		this.fieldDictList = fieldDictList;
	}

	public List<AtFieldRel> getFieldRelList() {
		return fieldRelList;
	}

	public void setFieldRelList(List<AtFieldRel> fieldRelList) {
		this.fieldRelList = fieldRelList;
	}

	public String[] getFunIds() {
		return funIds;
	}

	public void setFunIds(String[] funIds) {
		this.funIds = funIds;
	}

	public String[] getFieldIds() {
		return fieldIds;
	}

	public void setFieldIds(String[] fieldIds) {
		this.fieldIds = fieldIds;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
