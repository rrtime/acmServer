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
 * @Title:       AtCstFt.java
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
public class AtCstFt implements ISerializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = -4966708709461285525L;
	private int id;                             //主键id
      private String csrIdentifer;                //所属客户编号
      private int ftInst;                         //使用会计准则、制度
      private String rids;                        //财务报表
      private int recepitCount;                   //每月票据量
      private int ownTaxStation;                  //企业所得税所属税局
      private Date ownDeclareTime;                //企业所得税申报时间
      private int ownLevyType;                    //征收方式
      private int ownTaxType;                     //纳税申报方式
      private String ownTaxRate;                  //税率
      private int addTaxOwner;                    //增值税纳税人身份
      private int addTaxStation;                  //增值税所属税局
      private Date addTaxDeclareTime;             //增值税申报时间
      private int addTaxLevyType;                 //增值税征收方式
      private int addTaxType;                     //增值税纳税申报方式
      private String addTaxRate;                  //税率或征收率
      private String operator;                    //操作员
      private Timestamp createTime;               //创建时间
      private Date updateTime;                    //修改时间
      private String remark;                      //备注
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
	public int getFtInst() {
		return ftInst;
	}
	public void setFtInst(int ftInst) {
		this.ftInst = ftInst;
	}
	public String getRids() {
		return rids;
	}
	public void setRids(String rids) {
		this.rids = rids;
	}
	public int getRecepitCount() {
		return recepitCount;
	}
	public void setRecepitCount(int recepitCount) {
		this.recepitCount = recepitCount;
	}
	public int getOwnTaxStation() {
		return ownTaxStation;
	}
	public void setOwnTaxStation(int ownTaxStation) {
		this.ownTaxStation = ownTaxStation;
	}
	public Date getOwnDeclareTime() {
		return ownDeclareTime;
	}
	public void setOwnDeclareTime(Date ownDeclareTime) {
		this.ownDeclareTime = ownDeclareTime;
	}
	public int getOwnLevyType() {
		return ownLevyType;
	}
	public void setOwnLevyType(int ownLevyType) {
		this.ownLevyType = ownLevyType;
	}
	public int getOwnTaxType() {
		return ownTaxType;
	}
	public void setOwnTaxType(int ownTaxType) {
		this.ownTaxType = ownTaxType;
	}
	public String getOwnTaxRate() {
		return ownTaxRate;
	}
	public void setOwnTaxRate(String ownTaxRate) {
		this.ownTaxRate = ownTaxRate;
	}
	public int getAddTaxOwner() {
		return addTaxOwner;
	}
	public void setAddTaxOwner(int addTaxOwner) {
		this.addTaxOwner = addTaxOwner;
	}
	public int getAddTaxStation() {
		return addTaxStation;
	}
	public void setAddTaxStation(int addTaxStation) {
		this.addTaxStation = addTaxStation;
	}
	public Date getAddTaxDeclareTime() {
		return addTaxDeclareTime;
	}
	public void setAddTaxDeclareTime(Date addTaxDeclareTime) {
		this.addTaxDeclareTime = addTaxDeclareTime;
	}
	public int getAddTaxLevyType() {
		return addTaxLevyType;
	}
	public void setAddTaxLevyType(int addTaxLevyType) {
		this.addTaxLevyType = addTaxLevyType;
	}
	public int getAddTaxType() {
		return addTaxType;
	}
	public void setAddTaxType(int addTaxType) {
		this.addTaxType = addTaxType;
	}
	public String getAddTaxRate() {
		return addTaxRate;
	}
	public void setAddTaxRate(String addTaxRate) {
		this.addTaxRate = addTaxRate;
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
