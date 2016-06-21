/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    zl 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtFieldDictService;
import com.rrtimes.acm.serviceI.AtFieldRelService;
import com.rrtimes.acm.serviceI.AtHoldFunctionService;
import com.rrtimes.acm.serviceI.AtModelFunctionService;
import com.rrtimes.acm.serviceI.AtSysMenuService;
import com.rrtimes.acm.serviceI.AtSysModelService;
import com.rrtimes.acm.serviceI.AtUserService;

import net.sf.json.JSONObject;

/**
 * @Title: RoleAction.java
 * @Package: com.rrtimes.acm.action
 * @Description: 角色权限管理
 * 
 * @author zl
 * 
 */
public class RoleAction extends ActionSupport {

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

	private int rst;

	private String msg;
	
	//角色ID
	private int roleId;
	
	//功能权限ID
	private String[] funIds;
	//字段权限ID
	private String[] fieldIds;

	HttpSession session = ServletActionContext.getRequest().getSession();

	// 根据用户账号查询所在代账公司的所有角色
	public String getRole() throws Exception {
		//取得当前
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		if (roleId > 0) {
			userList = userService.queryjsBycpCode(loginUser.getCpCode());
			menuList = menuService.queryByUserId(loginUser.getId());
			functionList = atSysModelService.findAll();
			modelFunctionList = atSysModelFunctionService.findAll();
			holdFunctionList = atHoldFunctionService.getHoldFunctionListByActorId(roleId);
			fieldDictList = atFieldDictService.findAll();
			fieldRelList = atFieldRelService.getAtFieldRelListByUid(roleId);
			this.setRoleId(roleId);
			this.setAtUser(userService.queryUserById(roleId));
		}else{
			userList = userService.queryjsBycpCode(loginUser.getCpCode());
			menuList = menuService.queryByUserId(loginUser.getId());
			functionList = atSysModelService.findAll();
			modelFunctionList = atSysModelFunctionService.findAll();
			fieldDictList = atFieldDictService.findAll();
		}
		return "list";
	}
	
	
	/// 保存权限信息
	public String saveRoleStatus() throws Exception {
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		if(null != loginUser){
			if(roleId > 0){
				//更新功能权限
				atHoldFunctionService.modAtHoldFunction(funIds,roleId,loginUser.getId());
				//更新字段权限
				atFieldRelService.modifyFieldRel(fieldIds,roleId,loginUser.getId());
				msg="保存成功!";
			}else{
				msg="请选择角色!";
			}
			//重新加载权限
			getRole();
		}
		return "list";
	}
	
	//新增角色
	public String addRole() throws Exception{
		if(null != atUser){
			//验证名称是否存在
			boolean validateResult = userService.queryByInameToinsert(atUser.getIname());
			if(!validateResult){
				msg="新增角色失败，角色名称已经存在!";
			}else{
				AtUser loginUser = (AtUser) session.getAttribute("loginUser");
				atUser.setCpCode(loginUser.getCpCode());
				atUser.setOid(loginUser.getOid());
				atUser.setItype(2);
				atUser.setLoginPwd("");
				atUser.setUserName("");
				atUser.setSex(0);
				atUser.setWorkerNo("");
				atUser.setJobDuty("");
				atUser.setTelno("");
				atUser.setEmail("");
				atUser.setIsUsed(0);
				atUser.setIsAdmin(0);
				atUser.setOrderNum(0);
				atUser.setAuthState(0);
				atUser.setLastLoginDate(new Date());
				atUser.setStatus(0);
				atUser.setLoginIp("");
				atUser.setLoginTime("");
				atUser.setOperator(loginUser.getIname());
				atUser.setLastOperator(loginUser.getIname());
				
				rst = userService.addRole(atUser);
				if(rst > 1){
					msg="新增角色成功";
				}else{
					msg="新增失败";
				}
				//返回新增的角色ID
				roleId = rst;
			}
			//重新加载权限
			getRole();
		}
		return "list";
	}
	
	//新增角色校验角色名I_NAME
	public void validateforinsert(){
		boolean result = userService.queryByInameToinsert(atUser.getIname());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			int i = 0;
			if(result){
				i=1;
			}
			jo.put("status", i );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改角色
	public String updateRole() throws Exception{
		if(null != atUser){
			//验证名称是否存在
			boolean validateResult = userService.queryByInameToinsert(atUser.getIname());
			//重新保存角色ID
			this.setRoleId(roleId);
			if(!validateResult){
				msg="修改角色失败，角色名称已经存在!";
			}else{
				AtUser loginUser = (AtUser) session.getAttribute("loginUser");
				atUser.setCpCode(loginUser.getCpCode());
				atUser.setOid(loginUser.getOid());
				atUser.setItype(2);
				atUser.setLoginPwd("");
				atUser.setUserName("");
				atUser.setSex(0);
				atUser.setWorkerNo("");
				atUser.setJobDuty("");
				atUser.setTelno("");
				atUser.setEmail("");
				atUser.setIsUsed(0);
				atUser.setIsAdmin(0);
				atUser.setOrderNum(0);
				atUser.setAuthState(0);
				atUser.setLastLoginDate(new Date());
				atUser.setStatus(0);
				atUser.setLoginIp("");
				atUser.setLoginTime("");
				atUser.setOperator(loginUser.getIname());
				atUser.setLastOperator(loginUser.getIname());
				
				rst = userService.updateUser(atUser);
				if(rst==0){
					msg="修改角色成功";
				}else{
					msg="新增失败";
				}
			}
			//重新加载权限
			getRole();
		}
		return "list";
	}
	
	//修改角色校验角色名I_NAME
	public void validateforupdate(){
		boolean result = userService.queryByInameToupdate(atUser.getIname(), atUser.getId());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			int i = 0;
			if(result){
				i=1;
			}
			jo.put("status", i );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//删除角色
	public String deleteRole() throws Exception{
		if(roleId > 0){
			rst= userService.deleteRole(roleId);
			if(rst==0){
				msg="删除成功";
			}else{
				msg="删除失败";
			}
			//重新加载权限
			getRole();
			//删除后保证选中最后一个
			if(null != userList && userList.size() > 0){
				roleId=userList.get(userList.size()-1).getId();
				this.setAtUser(userList.get(userList.size()-1));
			}
		}
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
