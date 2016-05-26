/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-22		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * @Title:       SystemOperHistory.java
 * @Package:     com.tstar.charge.domain
 * @Description: 系统用户操作日志实体类
 * 
 * <p>
 * 	系统用户操作日志实体
 * </p> 
 * 
 * @author liht
 * 
 */
public class SystemOperHistory {
	
	private int id;
	
	private String operUser;
	
	private String operModule;
	
	private String operDetail;
	
	private int logType = -1;
	
	private String operIp;
	
	private Date createTime;
	
	private String remark;
	
	// 查询条件
	private Date startTime;
	
	private Date endTime;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperUser() {
		return operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public String getOperModule() {
		return operModule;
	}

	public void setOperModule(String operModule) {
		this.operModule = operModule;
	}

	public String getOperDetail() {
		return operDetail;
	}

	public void setOperDetail(String operDetail) {
		this.operDetail = operDetail;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
