/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-12		| 	    liht			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * 
 * CaaS 计费系统  费率套餐计划主表实体类
 * 
 * <p>
 * 	费率套餐计划主表实体
 * </p> 
 * 
 * @author liht
 * 
 */
public class RatePackageMain {
	
	private int id;
	
	private String packageName;
	
	private int packageType;
	
	// 界面显示时用
	private String pagType;
	
	private double packageFee;
	
	private int packageStatus;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;
	
	// 存储费率套餐计划详细费率列表 JSON
	private String json;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPackageType() {
		return packageType;
	}

	public void setPackageType(int packageType) {
		this.packageType = packageType;
	}

	public String getPagType() {
		return pagType;
	}

	public void setPagType(String pagType) {
		this.pagType = pagType;
	}

	public double getPackageFee() {
		return packageFee;
	}

	public void setPackageFee(double packageFee) {
		this.packageFee = packageFee;
	}

	public int getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(int packageStatus) {
		this.packageStatus = packageStatus;
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

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	

}