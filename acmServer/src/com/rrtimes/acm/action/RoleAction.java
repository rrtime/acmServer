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
	 * 根据用户账号查询所在代账公司的所有角色
	 * @return
	 * @throws Exception
	 */
	public String getRole() throws Exception {
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//判断当前是否有选择角色 选择有角色时加载所有功能列表及和角色的关系 否则只加载功能列表
		if (roleId > 0) {
			//取得角色列表
			userList = userService.queryjsBycpCode(loginUser.getCpCode());
			//取得菜单列表
			menuList = menuService.queryByUserId(loginUser.getId());
			//取得菜单所属功能列表
			functionList = atSysModelService.findAll();
			//取得功能详细操作字典列表
			modelFunctionList = atSysModelFunctionService.findAll();
			//取得系统功能操作权限列表
			holdFunctionList = atHoldFunctionService.getHoldFunctionListByActorId(roleId);
			//取得系统权限字段字典
			fieldDictList = atFieldDictService.findAll();
			//取得用户字段权限关系列表
			fieldRelList = atFieldRelService.getAtFieldRelListByUid(roleId);
			//设置当前选中角色ID
			this.setRoleId(roleId);
			//设置当前选中角色对象
			this.setAtUser(userService.queryUserById(roleId));
		}else{
			//取得角色列表
			userList = userService.queryjsBycpCode(loginUser.getCpCode());
			//取得菜单列表
			menuList = menuService.queryByUserId(loginUser.getId());
			//取得菜单所属功能列表
			functionList = atSysModelService.findAll();
			//取得功能详细操作字典列表
			modelFunctionList = atSysModelFunctionService.findAll();
			//取得系统权限字段字典
			fieldDictList = atFieldDictService.findAll();
			//如果存在一个以上角色则选中第一个
			if(null != userList && userList.size() > 0){
				//设置角色ID
				roleId=userList.get(0).getId();
				//设置角色对象
				this.setAtUser(userList.get(userList.size()-1));
				//取得系统功能操作权限列表
				holdFunctionList = atHoldFunctionService.getHoldFunctionListByActorId(roleId);
				//取得用户字段权限关系列表
				fieldRelList = atFieldRelService.getAtFieldRelListByUid(roleId);
			}
		}
		
		//返回前台页面
		return "list";
	}
	
	
	/**
	 * 保存权限信息
	 * @return
	 * @throws Exception
	 */
	public String saveRoleStatus() throws Exception {
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//判断当前是否有选择角色 选中角色的场合才能更新
		if(roleId > 0){
			//更新功能权限
			atHoldFunctionService.modAtHoldFunction(funIds,roleId,loginUser.getId());
			//更新字段权限
			atFieldRelService.modifyFieldRel(fieldIds,roleId,loginUser.getId());
			//设置返回信息
			msg="保存成功!";
		}else{
			//设置返回信息
			msg="请选择角色!";
		}
		//重新加载权限
		getRole();
		
		//返回前台页面
		return "list";
	}
	
	
	/**
	 * 新增角色
	 * @return
	 * @throws Exception
	 */
	public String addRole() throws Exception{
		//验证名称是否存在
		boolean validateResult = userService.queryByInameToinsert(atUser.getIname());
		//判断验证结果
		if(!validateResult){
			//设置返回信息
			msg="新增角色失败，角色名称已经存在!";
		}else{
			//取得当前登录用户信息
			AtUser loginUser = (AtUser) session.getAttribute("loginUser");
			//完善角色对象的其它字段以方便入库
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
			//返回新增的角色ID
			roleId = userService.addRole(atUser);
			//判断返回结果－如果插入成功则返回的ID一定大于1
			if(roleId > 1){
				//设置返回信息
				msg="新增角色成功";
			}else{
				//设置返回信息
				msg="新增失败";
			}
		}
		//重新加载权限
		getRole();
		
		//返回前台页面
		return "list";
	}
	
	/**
	 * ajax新增角色校验角色名I_NAME
	 */
	public void validateforinsert(){
		//取得判断结果
		boolean result = userService.queryByInameToinsert(atUser.getIname());
		try{
			//构建返回对象
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
	
	
	/**
	 * 修改角色
	 * @return
	 * @throws Exception
	 */
	public String updateRole() throws Exception{
		//判断前台提交过来的角色对象是否为空
		if(null != atUser){
			//验证名称是否存在
			boolean validateResult = userService.queryByInameToinsert(atUser.getIname());
			//重新保存角色ID
			this.setRoleId(roleId);
			//判断验证结果
			if(!validateResult){
				//设置返回信息
				msg="修改角色失败，角色名称已经存在!";
			}else{
				//取得当前登录用户信息
				AtUser loginUser = (AtUser) session.getAttribute("loginUser");
				//完善角色对象的其它字段以方便入库
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
				//定义取得修改结果
				int rst = userService.updateUser(atUser);
				//判断修改结果
				if(rst==0){
					//设置返回信息
					msg="修改角色成功";
				}else{
					//设置返回信息
					msg="新增失败";
				}
			}
			//重新加载权限
			getRole();
		}
		
		//返回前台页面
		return "list";
	}
	
	
	/**
	 * 删除角色
	 * @return
	 * @throws Exception
	 */
	public String deleteRole() throws Exception{
		//判断当前是否有选择角色 选中角色的场合才能删除
		if(roleId > 0){
			//取得删除结果
			int rst= userService.deleteRole(roleId);
			//判断删除结果
			if(rst==0){
				//设置返回信息
				msg="删除成功";
			}else{
				//设置返回信息
				msg="删除失败";
			}
			//重新加载权限
			getRole();
			//删除后保证选中最后一个
			if(null != userList && userList.size() > 0){
				//设置角色ID
				roleId=userList.get(userList.size()-1).getId();
				//设置角色对象
				this.setAtUser(userList.get(userList.size()-1));
			}
		}
		
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
