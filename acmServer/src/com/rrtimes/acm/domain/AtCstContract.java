/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtCstContract.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public class AtCstContract implements ISerializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 8052590831172093925L;
	private int id;                       //主键ID
     private String csrIdentifer;          //所属客户编号
     private int serviceType;              //业务类别
     private String startTime;             //服务开始时间
     private String endTime;             //服务结束时间
     private Double serviceFee;            //服务费
     private int payCycle;                 //付款模式
     private int payDay;                   //付款时间节点
     private int sortType;                 //理票约定
     private String operator;              //操作员
     private Timestamp createTime;         //创建时间
     private Date updateTime;              //修改时间
     private String remark;                //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCsrIdentifer() {
		return csrIdentifer;
	}
	public void setCsrIdentifer(String csrIdentifer) {
		this.csrIdentifer = csrIdentifer;
	}
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	
	public Double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public int getPayCycle() {
		return payCycle;
	}
	public void setPayCycle(int payCycle) {
		this.payCycle = payCycle;
	}
	public int getPayDay() {
		return payDay;
	}
	public void setPayDay(int payDay) {
		this.payDay = payDay;
	}
	public int getSortType() {
		return sortType;
	}
	public void setSortType(int sortType) {
		this.sortType = sortType;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
     
}
