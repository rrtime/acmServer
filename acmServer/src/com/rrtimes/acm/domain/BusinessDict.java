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
 * CaaS 计费系统 费率业务类型字典表实体类
 * 
 * <p>
 * 	费率业务类型字典表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class BusinessDict {

	private int id;
	
	private String businessShort;
	
	private String businessAll;
	
	private String businessDepict;
	
	private int businessUnit;
	
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

	public String getBusinessShort() {
		return businessShort;
	}

	public void setBusinessShort(String businessShort) {
		this.businessShort = businessShort;
	}

	public String getBusinessAll() {
		return businessAll;
	}

	public void setBusinessAll(String businessAll) {
		this.businessAll = businessAll;
	}

	public String getBusinessDepict() {
		return businessDepict;
	}

	public void setBusinessDepict(String businessDepict) {
		this.businessDepict = businessDepict;
	}

	public int getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(int businessUnit) {
		this.businessUnit = businessUnit;
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
