/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-11		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * @Title:       OcsCdrs.java
 * @Package:     com.tstar.charge.domain
 * @Description: 话单详细信息表实体类
 * 
 * <p>
 * 	话单详细信息表实体
 * </p> 
 * 
 * @author liht
 * 
 */
public class OcsCdrs {
	
	private String id;
	
	private String developerid;
	
	private String appKey;
	
	private int businessId;
	
	private String domainName;
	
	private String sessionId;
	
	private String callerNumber;
	
	private String calleeNumber;
	
	private Date startTime;
	
	private Date endTime;
	
	private int duration;
	
	private int freeDuration;
	
	private int chargingDuration;
	
	private int chargingCount;
	
	private double carrieFree;
	
	private double developerFee;
	
	private double userFee;
	
	private int voucherFlag;
	
	private String vercherid;
	
	private String collectid;
	
	private int abnormalFlag;
	
	private String abnormalDesc;
	
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeveloperid() {
		return developerid;
	}

	public void setDeveloperid(String developerid) {
		this.developerid = developerid;
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

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCallerNumber() {
		return callerNumber;
	}

	public void setCallerNumber(String callerNumber) {
		this.callerNumber = callerNumber;
	}

	public String getCalleeNumber() {
		return calleeNumber;
	}

	public void setCalleeNumber(String calleeNumber) {
		this.calleeNumber = calleeNumber;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFreeDuration() {
		return freeDuration;
	}

	public void setFreeDuration(int freeDuration) {
		this.freeDuration = freeDuration;
	}

	public int getChargingDuration() {
		return chargingDuration;
	}

	public void setChargingDuration(int chargingDuration) {
		this.chargingDuration = chargingDuration;
	}

	public int getChargingCount() {
		return chargingCount;
	}

	public void setChargingCount(int chargingCount) {
		this.chargingCount = chargingCount;
	}

	public double getCarrieFree() {
		return carrieFree;
	}

	public void setCarrieFree(double carrieFree) {
		this.carrieFree = carrieFree;
	}

	public double getDeveloperFee() {
		return developerFee;
	}

	public void setDeveloperFee(double developerFee) {
		this.developerFee = developerFee;
	}

	public double getUserFee() {
		return userFee;
	}

	public void setUserFee(double userFee) {
		this.userFee = userFee;
	}

	public int getVoucherFlag() {
		return voucherFlag;
	}

	public void setVoucherFlag(int voucherFlag) {
		this.voucherFlag = voucherFlag;
	}

	public String getVercherid() {
		return vercherid;
	}

	public void setVercherid(String vercherid) {
		this.vercherid = vercherid;
	}

	public String getCollectid() {
		return collectid;
	}

	public void setCollectid(String collectid) {
		this.collectid = collectid;
	}

	public int getAbnormalFlag() {
		return abnormalFlag;
	}

	public void setAbnormalFlag(int abnormalFlag) {
		this.abnormalFlag = abnormalFlag;
	}

	public String getAbnormalDesc() {
		return abnormalDesc;
	}

	public void setAbnormalDesc(String abnormalDesc) {
		this.abnormalDesc = abnormalDesc;
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
