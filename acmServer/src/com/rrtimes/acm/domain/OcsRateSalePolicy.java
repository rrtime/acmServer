package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * @author Administrator
 * 费率优惠策略表
 *
 */
public class OcsRateSalePolicy {
	
	private int id;
	
	private String saleName;
	
	private int saleArea;
	
	private String dateCode;
	
	private int saleType;
	
	private Date saleStartTime;
	
	private Date saleEndTime;
	
	private int level;
	
	private int status;
	
	private double saleAmount;
	
	private String saleRatio;
	
	private Date validStartTime;
	
	private Date validEndTime;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	public int getSaleArea() {
		return saleArea;
	}
	public void setSaleArea(int saleArea) {
		this.saleArea = saleArea;
	}
	public String getDateCode() {
		return dateCode;
	}
	public void setDateCode(String dateCode) {
		this.dateCode = dateCode;
	}
	public int getSaleType() {
		return saleType;
	}
	public void setSaleType(int saleType) {
		this.saleType = saleType;
	}
	public Date getSaleStartTime() {
		return saleStartTime;
	}
	public void setSaleStartTime(Date saleStartTime) {
		this.saleStartTime = saleStartTime;
	}
	public Date getSaleEndTime() {
		return saleEndTime;
	}
	public void setSaleEndTime(Date saleEndTime) {
		this.saleEndTime = saleEndTime;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}
	public String getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(String saleRatio) {
		this.saleRatio = saleRatio;
	}
	public Date getValidStartTime() {
		return validStartTime;
	}
	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}
	public Date getValidEndTime() {
		return validEndTime;
	}
	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
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
