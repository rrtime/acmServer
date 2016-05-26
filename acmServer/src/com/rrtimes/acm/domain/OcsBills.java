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
 * @Title:       OcsBills.java
 * @Package:     com.tstar.charge.domain
 * @Description: 账单主表实体类
 * 
 * <p>
 * 	账单主表实体
 * </p> 
 * 
 * @author liht
 * 
 */
public class OcsBills {

	private String id;
	
	private String developerId;
	
	private String cycleId;
	
	private Date startTime;
	
	private Date endTime;
	
	private double totalFee;
	
	private int billFlag;
	
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public String getCycleId() {
		return cycleId;
	}

	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
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

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public int getBillFlag() {
		return billFlag;
	}

	public void setBillFlag(int billFlag) {
		this.billFlag = billFlag;
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
	
}
