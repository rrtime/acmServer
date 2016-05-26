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
 * CaaS 计费系统 费率套餐计划免费资源表实体类
 * 
 * <p>
 * 	费率套餐计划免费资源表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class PackageFreeRes {
	
	private int id;
	
	private int pid;
	
	private int bid;
	
	private int bnUnit;
	
	private double freeResVolume;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;

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

	public double getFreeResVolume() {
		return freeResVolume;
	}

	public void setFreeResVolume(double freeResVolume) {
		this.freeResVolume = freeResVolume;
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
