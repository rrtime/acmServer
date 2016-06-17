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
 * CaaS 计费系统 开发者、应用或用户与费率套餐计划关系表实体类
 * 
 * <p>
 * 	开发者、应用或用户与费率套餐计划关系表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class DevPackageRln {
	
	private int id;
	
	private int pType;
	
	private String devOrAppId;
	
	private int pid;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;
	
	private Date updateTime;

	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPType() {
		return pType;
	}

	public void setPType(int type) {
		pType = type;
	}

	public String getDevOrAppId() {
		return devOrAppId;
	}

	public void setDevOrAppId(String devOrAppId) {
		this.devOrAppId = devOrAppId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
