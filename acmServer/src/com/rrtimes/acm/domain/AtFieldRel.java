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
 * @Title:       AtFieldRel.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 用户字段权限关系实体
 * 
 * <p>
 * 	用户字段权限关系实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtFieldRel implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6726432072079922123L;

	private int id;//主键ID
	
	private String menuCode;//所属功能编码
	
	private String rname;//名称
	
	private int privilegeType;//权限码
	
	private int fid;//权限字段字典ID
	
	private int uid;//用户或用户组ID
	
	private int isUserGroup;//
	
	private String operator;//操作员
	
	private Timestamp createTime;//创建时间
	
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

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public int getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(int privilegeType) {
		this.privilegeType = privilegeType;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getIsUserGroup() {
		return isUserGroup;
	}

	public void setIsUserGroup(int isUserGroup) {
		this.isUserGroup = isUserGroup;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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
