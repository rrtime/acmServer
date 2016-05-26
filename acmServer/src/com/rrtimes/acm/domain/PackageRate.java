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
 * CaaS 计费系统 费率套餐计划详细费率表实体类
 * 
 * <p>
 * 	费率套餐计划详细费率表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class PackageRate {
	
	private int id;
	
	private int pid;
	
	private int bid;
	
	private int bnUnit;
	
	private double bnRatePrice;
	
	private String bnRatePrefix;
	
	private int rateStatus;
	
	private double costPrice;
	
	private int isTestQuota;
	
	private int testQuotaUnit;
	
	private double testQuotaValue;
	
	private int isComQuota;
	
	private double comQuotaValue;
	
	private int comQuotaUnit;
	
	private Date createTime;
	
	private Date updateTime;

	// 拼接后的 json 临时存储在这里
	private String remark;
	
	// 是否包含免费资源( 0 不包含, 1 包含)
	private int isFree = 0;
	
	// 免费资源临时存储
	private Double freeResVolume;
	
	private String pbName;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBnUnit() {
		return bnUnit;
	}

	public void setBnUnit(int bnUnit) {
		this.bnUnit = bnUnit;
	}

	public double getBnRatePrice() {
		return bnRatePrice;
	}

	public void setBnRatePrice(double bnRatePrice) {
		this.bnRatePrice = bnRatePrice;
	}

	public String getBnRatePrefix() {
		return bnRatePrefix;
	}

	public void setBnRatePrefix(String bnRatePrefix) {
		this.bnRatePrefix = bnRatePrefix;
	}

	public int getRateStatus() {
		return rateStatus;
	}

	public void setRateStatus(int rateStatus) {
		this.rateStatus = rateStatus;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public int getIsTestQuota() {
		return isTestQuota;
	}

	public int getTestQuotaUnit() {
		return testQuotaUnit;
	}

	public void setTestQuotaUnit(int testQuotaUnit) {
		this.testQuotaUnit = testQuotaUnit;
	}

	public void setIsTestQuota(int isTestQuota) {
		this.isTestQuota = isTestQuota;
	}

	public double getTestQuotaValue() {
		return testQuotaValue;
	}

	public void setTestQuotaValue(double testQuotaValue) {
		this.testQuotaValue = testQuotaValue;
	}

	public int getIsComQuota() {
		return isComQuota;
	}

	public void setIsComQuota(int isComQuota) {
		this.isComQuota = isComQuota;
	}

	public double getComQuotaValue() {
		return comQuotaValue;
	}

	public void setComQuotaValue(double comQuotaValue) {
		this.comQuotaValue = comQuotaValue;
	}

	public int getComQuotaUnit() {
		return comQuotaUnit;
	}

	public void setComQuotaUnit(int comQuotaUnit) {
		this.comQuotaUnit = comQuotaUnit;
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

	public int getIsFree() {
		return isFree;
	}

	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}

	public Double getFreeResVolume() {
		return freeResVolume;
	}

	public void setFreeResVolume(Double freeResVolume) {
		this.freeResVolume = freeResVolume;
	}

	public String getPbName() {
		return pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}
	

}
