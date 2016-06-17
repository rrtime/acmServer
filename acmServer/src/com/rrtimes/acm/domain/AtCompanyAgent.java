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
 * @Title:       AtCompanyAgent.java
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
public class AtCompanyAgent implements ISerializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2807087552845887955L;
	private int id;                        //主键ID
    private String cpCode;                 //代账公司编码
    private String cpName;                 //代账公司简称
    private String cpNameAll;              //代账公司全称
    private String rgAddress;              //注册地址
    private String officeAddress;          //办公地址
    private String cpOwner;                //公司法人代表
    private String cpAgenter;              //代账业务负责人
    private String cpTel;                  //公司联系电话
    private String cpEmail;                //联系邮箱
    private int useType;                   //可用服务类型
    private Timestamp createTime;          //创建时间
    private Date updateTime;               //修改时间
    private String remark;                 //备注
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
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getCpNameAll() {
		return cpNameAll;
	}
	public void setCpNameAll(String cpNameAll) {
		this.cpNameAll = cpNameAll;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getCpOwner() {
		return cpOwner;
	}
	public void setCpOwner(String cpOwner) {
		this.cpOwner = cpOwner;
	}
	public String getCpAgenter() {
		return cpAgenter;
	}
	public void setCpAgenter(String cpAgenter) {
		this.cpAgenter = cpAgenter;
	}
	public String getCpTel() {
		return cpTel;
	}
	public void setCpTel(String cpTel) {
		this.cpTel = cpTel;
	}
	public String getCpEmail() {
		return cpEmail;
	}
	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}
	public int getUseType() {
		return useType;
	}
	public void setUseType(int useType) {
		this.useType = useType;
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
	public String getRgAddress() {
		return rgAddress;
	}
	public void setRgAddress(String rgAddress) {
		this.rgAddress = rgAddress;
	}
	
}
