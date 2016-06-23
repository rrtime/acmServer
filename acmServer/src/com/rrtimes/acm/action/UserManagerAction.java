/*      						
 * Copyright 2016 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-20		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtCompanyAgent;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.serviceI.AtCompanyAgentService;
import com.rrtimes.acm.serviceI.AtSysMenuService;
import com.rrtimes.acm.serviceI.AtSysModelService;
import com.rrtimes.acm.serviceI.AtUserService;

/**
 * @Title:       UserManagerAction.java
 * @Package:     com.tstar.charge.action
 * @Description: 平台登录管理控制层
 * 
 * <p>
 * 	系统用户管理业务控制
 * </p> 
 * 
 * @author liht
 * 
 */
public class UserManagerAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	
	@Resource
	private AtUserService atUserServcie;
	
	@Resource
	private AtSysMenuService asoservice;
	
	@Resource
	private AtCompanyAgentService acas;
	
	@Resource
	private AtSysModelService asm;
	
	private AtUser atUser = new AtUser();
	
	private AtCompanyAgent atCompanyAgent = new AtCompanyAgent();
	
	private List<AtSysMenu> asoList = new ArrayList<AtSysMenu>();
	
	private  List<AtSysModel> asmList = new  ArrayList<AtSysModel>();
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	// 登录结果 0 成功, 1 失败(-1 表示首次登录)
	private int rst = 0;
	
	private String msg;
	
	// 操作类型: 1 新增, 2 修改, 3 详情, 4 会话过期自动注销
	private int cmd = 0;
	
	public String firstLogin(){
		// -1
		this.setRst(-1);
		return "login";
	}
	
	public String index(){
		return "index";
	}
	
	/**
	 * 用户登录
	 * */
	public String login()
	{
		String url = "login";
		try
		{
			this.setAtUser(atUserServcie.queryByUser(atUser));
			// 判定是否为登录成功( 0 登录成功, -1 失败)
			if( atUser.getResult() != -1 )
			{
				// 登录成功后更新用户最后登录平台时间信息
				session.setAttribute("username", atUser.getIname());
				session.setAttribute("loginUser", atUser);
				session.setAttribute("atUser", this.getAtUser());
				url = "index";
				System.out.println("===================:"+atUser.getEmail());
				// 获取当前用户权限信息
				try
				{
					setAsoList(asoservice.queryByUserId(atUser.getId()));
					// 获取当前用户三级菜单权限列表
					this.setAsmList(asm.queryAtSysModelByUserId(atUser.getId()));
				}catch(Exception ex)
				{
					ex.printStackTrace();
					ex.toString();
				}
				// 获取用户的所在代账机构信息
				this.setAtCompanyAgent(acas.queryBycpCode(atUser.getCpCode()));
			}
			else
			{
				this.setRst(1);
				this.setMsg("用户名或密码有误");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			ex.toString();
		}
		// 存储 url
		session.setAttribute("sysPath", ServletActionContext.getRequest().getContextPath());
		return url;
	}
	
	/**
	 * 首页我的桌面模块
	 * */
	public String content()
	{
		
		return "content";
	}
	
	/**
	 * 用户管理
	 * */
	public String userList()
	{
		
		return "userMag";
	}
	
	/**
	 * 角色管理
	 * */
	public String roleList()
	{
		
		return "roleMag";
	}
	
	/**
	 * 跳转到退出界面
	 * @return
	 */
	public String logoutPage(){
		return firstLogin();
	}
	
	/**
	 * 用户注销登录
	 * */
	public String logout()
	{
		atUser = (AtUser)session.getAttribute("loginUser");
		// 拦截器会话过期自动注销
		if( this.getCmd() == 5 )
		{
			//"系统当前登录用户会话已过期,自动拦截、注销登录定向至登录页面"
			this.setRst(5);
		}else
		{
			//"用户"+"["+alias+"]注销登录已成功。"
			this.setRst(6);
		}
		session.removeAttribute("sysPath");
		session.removeAttribute("loginUser");
		return "login";
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

	public int getRst() {
		return rst;
	}

	public void setRst(int rst) {
		this.rst = rst;
	}

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

	public List<AtSysMenu> getAsoList() {
		return asoList;
	}

	public void setAsoList(List<AtSysMenu> asoList) {
		this.asoList = asoList;
	}

	public AtCompanyAgent getAtCompanyAgent() {
		return atCompanyAgent;
	}

	public void setAtCompanyAgent(AtCompanyAgent atCompanyAgent) {
		this.atCompanyAgent = atCompanyAgent;
	}

	public List<AtSysModel> getAsmList() {
		return asmList;
	}

	public void setAsmList(List<AtSysModel> asmList) {
		this.asmList = asmList;
	}
	


}
