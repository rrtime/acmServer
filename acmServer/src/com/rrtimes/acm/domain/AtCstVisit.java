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
 * @Title:       AtCstVisit.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 客户回访记录实体
 * 
 * <p>
 * 	客户回访记录实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstVisit implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2137942211679846585L;

	private int id;//主键ID
	
	private String cpCode;//所属代账机构
	
	private String cnIdentifer;//所属客户编号
	
	private String cnCustomer;//回访客户人员
	
	private int cnType;//回访方式
	
	private String cnContact;//回访联系方式
	
	private Date cnTime;//回访时间
	
	private String cnContent;//回访内容
	
	private int cnResult;//回访结果
	
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

	public String getCnCustomer() {
		return cnCustomer;
	}

	public void setCnCustomer(String cnCustomer) {
		this.cnCustomer = cnCustomer;
	}

	public int getCnType() {
		return cnType;
	}

	public void setCnType(int cnType) {
		this.cnType = cnType;
	}

	public String getCnContact() {
		return cnContact;
	}

	public void setCnContact(String cnContact) {
		this.cnContact = cnContact;
	}

	public Date getCnTime() {
		return cnTime;
	}

	public void setCnTime(Date cnTime) {
		this.cnTime = cnTime;
	}

	public String getCnContent() {
		return cnContent;
	}

	public void setCnContent(String cnContent) {
		this.cnContent = cnContent;
	}

	public int getCnResult() {
		return cnResult;
	}

	public void setCnResult(int cnResult) {
		this.cnResult = cnResult;
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
