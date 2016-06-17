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
 * @Title:       AtComplain.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 客户投诉信息实体
 * 
 * <p>
 * 	客户投诉信息实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtComplain implements ISerializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4738651486470370241L;

	private int id;//主键ID
	
	private String cpCode;//所属代账机构
	
	private String csrIdentifer;//所属客户编号
	
	private int cnFrom;//投诉来源
	
	private int cnType;//投诉方式
	
	private String cnTheme;//投诉主题
	
	private String cnContent;//投诉内容
	
	private String cnOpt;//投诉当前处理人
	
	private String cnInquire;//投诉调查内容
	
	private String cnResult;//投诉调查处理结果
	
	private String cnPrincipal;//投诉主要责任人
	
	private int cnStatus;//投诉记录状态
	
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

	public String getCsrIdentifer() {
		return csrIdentifer;
	}

	public void setCsrIdentifer(String csrIdentifer) {
		this.csrIdentifer = csrIdentifer;
	}

	public int getCnFrom() {
		return cnFrom;
	}

	public void setCnFrom(int cnFrom) {
		this.cnFrom = cnFrom;
	}

	public int getCnType() {
		return cnType;
	}

	public void setCnType(int cnType) {
		this.cnType = cnType;
	}

	public String getCnTheme() {
		return cnTheme;
	}

	public void setCnTheme(String cnTheme) {
		this.cnTheme = cnTheme;
	}

	public String getCnContent() {
		return cnContent;
	}

	public void setCnContent(String cnContent) {
		this.cnContent = cnContent;
	}

	public String getCnOpt() {
		return cnOpt;
	}

	public void setCnOpt(String cnOpt) {
		this.cnOpt = cnOpt;
	}

	public String getCnInquire() {
		return cnInquire;
	}

	public void setCnInquire(String cnInquire) {
		this.cnInquire = cnInquire;
	}

	public String getCnResult() {
		return cnResult;
	}

	public void setCnResult(String cnResult) {
		this.cnResult = cnResult;
	}

	public String getCnPrincipal() {
		return cnPrincipal;
	}

	public void setCnPrincipal(String cnPrincipal) {
		this.cnPrincipal = cnPrincipal;
	}

	public int getCnStatus() {
		return cnStatus;
	}

	public void setCnStatus(int cnStatus) {
		this.cnStatus = cnStatus;
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
