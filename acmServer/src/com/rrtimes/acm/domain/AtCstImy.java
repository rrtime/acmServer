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
 * @Title:       AtCstImy.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 客户质量赔付记录实体
 * 
 * <p>
 * 	客户质量赔付记录实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstImy implements ISerializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6775548202798372971L;

	private int id;//主键ID
	
	private String cpCode;//所属代账机构
	
	private String cnIdentifer;//所属客户编号
	
	private int imyForm;//赔付信息来源
	
	private int cid;//投诉记录ID
	
	private int imyStatus;//赔付记录状态
	
	private String imyOpt;//赔付当前处理人
	
	private String imyReason;//赔付产生原因
	
	private String imyAuditRst;//赔付审核结果
	
	private String imyResult;//赔付沟通结果
	
	private double imySum;//赔付金额
	
	private int payType;//赔付支付方式
	
	private Date payTime;//赔付支付时间
	
	private String operator;//操作员
	
	private Timestamp createTime;//创建时间
	
	private Date updateTime;//修改时间
	
	private String remark;//备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpCode() {
		return cpCode;
	}

	public void setCpCode(String cpCode) {
		this.cpCode = cpCode;
	}

	public String getCnIdentifer() {
		return cnIdentifer;
	}

	public void setCnIdentifer(String cnIdentifer) {
		this.cnIdentifer = cnIdentifer;
	}

	public int getImyForm() {
		return imyForm;
	}

	public void setImyForm(int imyForm) {
		this.imyForm = imyForm;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getImyStatus() {
		return imyStatus;
	}

	public void setImyStatus(int imyStatus) {
		this.imyStatus = imyStatus;
	}

	public String getImyOpt() {
		return imyOpt;
	}

	public void setImyOpt(String imyOpt) {
		this.imyOpt = imyOpt;
	}

	public String getImyReason() {
		return imyReason;
	}

	public void setImyReason(String imyReason) {
		this.imyReason = imyReason;
	}

	public String getImyAuditRst() {
		return imyAuditRst;
	}

	public void setImyAuditRst(String imyAuditRst) {
		this.imyAuditRst = imyAuditRst;
	}

	public String getImyResult() {
		return imyResult;
	}

	public void setImyResult(String imyResult) {
		this.imyResult = imyResult;
	}

	public double getImySum() {
		return imySum;
	}

	public void setImySum(double imySum) {
		this.imySum = imySum;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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
