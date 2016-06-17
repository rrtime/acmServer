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
 * @Title:       OcsVouchers.java
 * @Package:     com.tstar.charge.domain
 * @Description: 账单明细表实体类
 * 
 * <p>
 * 	账单明细表实体
 * </p> 
 * 
 * @author liht
 * 
 */
public class OcsBillDetails {

	private String id;
	
	private String billId;
	
	private String appKey;
	
	private int businessId;
	
	// 数量
	private int duration;
	
	private int chargingDuration;
	
	private double fee;
	
	private Date createTime;
	
	private Date updateTime;
	
	// 开发者名
	private String devName;
	
	private String appName;
	
	// 账期
	private String cycleId;
	
	// 业务类型
	private String businessName;
	
	// 账单发送状态：0 累账, 7 等待发送, 8 已发送, 9 已销账
	private int billFlag;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getChargingDuration() {
		return chargingDuration;
	}

	public void setChargingDuration(int chargingDuration) {
		this.chargingDuration = chargingDuration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
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

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCycleId() {
		return cycleId;
	}

	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}

	public int getBillFlag() {
		return billFlag;
	}

	public void setBillFlag(int billFlag) {
		this.billFlag = billFlag;
	}
	
	
	
}
