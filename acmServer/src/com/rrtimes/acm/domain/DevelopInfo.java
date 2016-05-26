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
 * CaaS 计费系统 开发者信息表实体类
 * 
 * <p>
 * 	开发者信息表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class DevelopInfo {
	
	private int id;
	
	private String devId;
	
	private String devAlias;
	
	private String devName;
	
	private String devEmail;
	
	private int appCount;
	
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

	public String getDevAlias() {
		return devAlias;
	}

	public void setDevAlias(String devAlias) {
		this.devAlias = devAlias;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevEmail() {
		return devEmail;
	}

	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}

	public int getAppCount() {
		return appCount;
	}

	public void setAppCount(int appCount) {
		this.appCount = appCount;
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
