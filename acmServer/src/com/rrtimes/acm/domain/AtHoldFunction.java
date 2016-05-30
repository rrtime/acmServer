/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtHoldFunction.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 系统功能操作权限实体
 * 
 * <p>
 * 	系统功能操作权限实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtHoldFunction implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -852707643755879353L;

	private int id;//主键ID
	
	private String menuCode;//所属功能编码
	
	private String funName;//描述
	
	private int isUserGroup;//
	
	private int funId;//FUN_ID
	
	private int actorId;//用户或用户组ID
	
	private Timestamp createTime;//创建时间
	
	private String operator;//更新操作员
	
	private Date updateTime;//修改时间
	
	private String remark;//备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public int getIsUserGroup() {
		return isUserGroup;
	}

	public void setIsUserGroup(int isUserGroup) {
		this.isUserGroup = isUserGroup;
	}

	public int getFunId() {
		return funId;
	}

	public void setFunId(int funId) {
		this.funId = funId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
