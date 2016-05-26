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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.service.AtUserService;

/**
 * @Title:       SysUserAction.java
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
public class SysUserAction extends ActionSupport{
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954363164266848728L;
	@Resource
	private AtUserService aus;
	private AtUser atUser = new AtUser();
	
	//登录
	public String login(){
		int resultint = aus.queryByUser(atUser).getResult();
		
		if(resultint==1){
			return "error";
		}else{
			return "success";
		}
	}
    
	//新增用户
	public String add(){
		aus.addUser(atUser);
		return "add";
	}
	
	//新增用户校验用户名I_NAME
	public void validateforinsert(){
		boolean result = aus.queryByInameToinsert(atUser.getIname());
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
	
	//修改用户
	public String update(){
		aus.updateUser(atUser);
		return "update";
	}
	
	//修改用户校验用户名I_NAME
	public void validateforupdate(){
		boolean result = aus.queryByInameToupdate(atUser.getIname(), atUser.getId());
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
	
	//删除用户
	public String delete(){
		aus.deleteUser(atUser.getId());
		return "delete";
	}
	
	//按Id查询用户
	public String findById(){
		atUser = aus.queryUserById(atUser.getId());
		return "findById";
	}

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}
	

	
}
