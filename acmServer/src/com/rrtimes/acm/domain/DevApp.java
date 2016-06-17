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
 * CaaS 计费系统 开发者应用信息表实体类
 * 
 * <p>
 * 	开发者应用信息表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class DevApp {
	
	private int id;
	
	private String devId;
	
	private String appKey;
	
	private String appName;
	
	private int appType;
	
	private double divideScale;
	
	private int appStatus;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;
	
	// 套餐关系 ID
	private int rid;
	
	private String pagName;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getAppType() {
		return appType;
	}

	public void setAppType(int appType) {
		this.appType = appType;
	}

	public double getDivideScale() {
		return divideScale;
	}

	public void setDivideScale(double divideScale) {
		this.divideScale = divideScale;
	}

	public int getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(int appStatus) {
		this.appStatus = appStatus;
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

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getPagName() {
		return pagName;
	}

	public void setPagName(String pagName) {
		this.pagName = pagName;
	}

}
