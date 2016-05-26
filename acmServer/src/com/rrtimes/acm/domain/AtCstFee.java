/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtCstFee.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 客户收费记录实体
 * 
 * <p>
 * 	客户收费记录实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstFee implements ISerializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 952270914211607109L;

	private int id;//主键ID
	
	private int nid;//合同ID
	
	private int cid;//客户ID
	
	private int payType;//支付方式
	
	private Date feeTime;//收费时间
	
	private double feeSum;//收费金额
	
	private Date startTime;//服务起始时间
	
	private Date endTime;//服务截止时间
	
	private String operator;//操作员
	
	private Timestamp createTime;//创建世界
	
	private Date updateTime;//修改时间
	
	private String remark;//备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public Date getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}

	public double getFeeSum() {
		return feeSum;
	}

	public void setFeeSum(double feeSum) {
		this.feeSum = feeSum;
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
	
	

}
