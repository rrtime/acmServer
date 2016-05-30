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
 * @Title:       AtFieldDict.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 系统权限字段字典实体
 * 
 * <p>
 * 	系统权限字段字典实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtFieldDict implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4564022528926994708L;

	private int id;//主键ID
	
	private String menuCode;//所属功能编码
	
	private String fname;//对应字段名
	
	private String ftitle;//字段显示名称
	
	private String fdesc;//描述
	
	private int orderIndex;//显示顺序
	
	private int isSystem;//
	
	private int isInauth;//
	
	private int isHasread;//
	
	private int isHasupdate;//
	
	private int viewType;//
	
	private int cateGory;//
	
	private int idParent;//
	
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(int isSystem) {
		this.isSystem = isSystem;
	}

	public int getIsInauth() {
		return isInauth;
	}

	public void setIsInauth(int isInauth) {
		this.isInauth = isInauth;
	}

	public int getIsHasread() {
		return isHasread;
	}

	public void setIsHasread(int isHasread) {
		this.isHasread = isHasread;
	}

	public int getIsHasupdate() {
		return isHasupdate;
	}

	public void setIsHasupdate(int isHasupdate) {
		this.isHasupdate = isHasupdate;
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getCateGory() {
		return cateGory;
	}

	public void setCateGory(int cateGory) {
		this.cateGory = cateGory;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
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
