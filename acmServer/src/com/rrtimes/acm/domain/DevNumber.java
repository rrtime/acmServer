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
 * CaaS 计费系统 开发者号码信息表实体类(预留)
 * 
 * <p>
 * 	开发者号码信息表实体(预留)
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class DevNumber {
	
	private int id;
	
	private String devNumber;
	
	private int numType;
	
	private String bingAppKey;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDevNumber() {
		return devNumber;
	}

	public void setDevNumber(String devNumber) {
		this.devNumber = devNumber;
	}

	public int getNumType() {
		return numType;
	}

	public void setNumType(int numType) {
		this.numType = numType;
	}

	public String getBingAppKey() {
		return bingAppKey;
	}

	public void setBingAppKey(String bingAppKey) {
		this.bingAppKey = bingAppKey;
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
