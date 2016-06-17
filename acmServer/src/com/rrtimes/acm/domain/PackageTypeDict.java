/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-12		| 	 lihaitao 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * 
 * 套餐计划类型字典表实体类
 * 
 * <p>
 * 	套餐计划类型字典表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class PackageTypeDict {

	private int id;
	
	private String pagShort;
	
	private String pagDepict;
	
	private String operator;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPagShort() {
		return pagShort;
	}

	public void setPagShort(String pagShort) {
		this.pagShort = pagShort;
	}

	public String getPagDepict() {
		return pagDepict;
	}

	public void setPagDepict(String pagDepict) {
		this.pagDepict = pagDepict;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
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