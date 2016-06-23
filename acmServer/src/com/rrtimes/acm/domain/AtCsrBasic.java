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
import java.util.List;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtCsrBasic.java
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
public class AtCsrBasic implements ISerializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = -8991268209704809515L;
	private int id;                  //主键ID          
      private String cpCode;           //所属代账机构
      private int csrType;             //客户分类
      private String csrIdentifer;     //客户编号
      private String csrCode;          //信用代码或纳税人识别号
      private String regAddress;       //注册地址
      private String officeAddress;    //办公地址
      private String csrOwner;         //公司法人代表
      private String financeLeader;    //财务负责人
      private String taxLeader;        //税务负责人
      private String operator;         //操作员
      private Timestamp createTime;    //创建时间
      private Date updateTime;         //修改时间
      private String remark;           //备注
      private String csrName;
      private List<AtCstContract> acc;       //合同信息表关联---------一对多
      private List<AtComplain> ac;
      
	public AtCstFt getAcf() {
		return acf;
	}
	public void setAcf(AtCstFt acf) {
		this.acf = acf;
	}
	private AtCstFt acf;             //客户财税信息表---------一对一
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
	public int getCsrType() {
		return csrType;
	}
	public void setCsrType(int csrType) {
		this.csrType = csrType;
	}
	public String getCsrIdentifer() {
		return csrIdentifer;
	}
	public void setCsrIdentifer(String csrIdentifer) {
		this.csrIdentifer = csrIdentifer;
	}
	public String getCsrCode() {
		return csrCode;
	}
	public void setCsrCode(String csrCode) {
		this.csrCode = csrCode;
	}
	public String getRegAddress() {
		return regAddress;
	}
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getCsrOwner() {
		return csrOwner;
	}
	public void setCsrOwner(String csrOwner) {
		this.csrOwner = csrOwner;
	}
	public String getFinanceLeader() {
		return financeLeader;
	}
	public void setFinanceLeader(String financeLeader) {
		this.financeLeader = financeLeader;
	}
	public String getTaxLeader() {
		return taxLeader;
	}
	public void setTaxLeader(String taxLeader) {
		this.taxLeader = taxLeader;
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
	public List<AtCstContract> getAcc() {
		return acc;
	}
	public void setAcc(List<AtCstContract> acc) {
		this.acc = acc;
	}
	public String getCsrName() {
		return csrName;
	}
	public void setCsrName(String csrName) {
		this.csrName = csrName;
	}
	public List<AtComplain> getAc() {
		return ac;
	}
	public void setAc(List<AtComplain> ac) {
		this.ac = ac;
	}
} 
