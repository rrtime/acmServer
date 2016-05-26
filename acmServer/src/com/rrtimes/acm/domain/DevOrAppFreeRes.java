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
 * CaaS 计费系统 开发者或应用免费资源表实体类
 * 
 * <p>
 * 	开发者或应用免费资源表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class DevOrAppFreeRes {
	
	private int id;
	
	private int fType;
	
	private String devOrAppId;
	
	private int bid;
	
	private int bnUnit;
	
	private double freeResVolume;
	
	private double freeResBalance;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFType() {
		return fType;
	}

	public void setFType(int type) {
		fType = type;
	}

	public String getDevOrAppId() {
		return devOrAppId;
	}

	public void setDevOrAppId(String devOrAppId) {
		this.devOrAppId = devOrAppId;
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

	public double getFreeResVolume() {
		return freeResVolume;
	}

	public void setFreeResVolume(double freeResVolume) {
		this.freeResVolume = freeResVolume;
	}

	public double getFreeResBalance() {
		return freeResBalance;
	}

	public void setFreeResBalance(double freeResBalance) {
		this.freeResBalance = freeResBalance;
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
