/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtUserGroupRel;
import com.rrtimes.acm.serviceI.AtUserGroupRelService;

/**
 * @Title:       UserGroupRelAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 用户和用户组关系表
 * 
 * <p>
 * 	用户和用户组关系表
 * </p> 
 * 
 * @author lil
 * 
 */
public class UserGroupRelAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 729134527168739877L;
	
	@Resource 
	private AtUserGroupRelService augrs;
	
	private AtUserGroupRel augr = new AtUserGroupRel();
	
	private int rst;
	
	private int cmd;
	
	private String msg;
	
    
	
	public AtUserGroupRel getAugr() {
		return augr;
	}

	public void setAugr(AtUserGroupRel augr) {
		this.augr = augr;
	}

	public int getRst() {
		return rst;
	}

	public void setRst(int rst) {
		this.rst = rst;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
