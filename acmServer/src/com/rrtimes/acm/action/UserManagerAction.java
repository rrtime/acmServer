/*      						
 * Copyright 2016 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-20		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtUser;
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
	
	private AtUser atUser = new AtUser();
	
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
		}catch(Exception ex)
		{
			ex.printStackTrace();
			ex.toString();
		}
		// 判定是否为登录成功( 0 登录成功, -1 失败)
		if( atUser.getResult() != -1 )
		{
			// 登录成功后更新用户最后登录平台时间信息
			
			session.setAttribute("username", atUser.getIname());
			session.setAttribute("loginUser", atUser);
			url = "index";
			System.out.println("===================:"+atUser.getEmail());
		}
		// 存储 url
		session.setAttribute("sysPath", ServletActionContext.getRequest().getContextPath());
		return url;
	}
	
	/**
	 * 跳转到退出界面
	 * @return
	 */
	public String logoutPage(){
		return "logoutPage";
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
		}else if (this.getCmd() == 7){
			//"系统License已过期,自动拦截、注销登录定向至登录页面"
			this.setRst(7);
		}
		else
		{
			//"用户"+"["+alias+"]注销登录已成功。"
			this.setRst(99);
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
	


}
