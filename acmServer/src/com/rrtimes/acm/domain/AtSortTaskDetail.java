/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtSortTaskDetail.java
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
public class AtSortTaskDetail implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1171789731264009463L;
	private int id;                     //主键ID
	private int cid;                    //客户月理票任务ID
	private int szType;                 //收支分类
	private int bsType;                 //业务类型
	private int rtType;                 //发票类型
	private int isIf;                   //是否认证
	private int isDk;                   //是否抵扣
	private String dept;                //部门
	private String employee;            //员工
	private String wlCompany;           //往来单位
	private int stock;                  //存货
	private String project;             //项目
	private String sortUser;            //理票人
	private Date createTime;            //创建时间
	private Date updateTime;            //最后更新时间
	private String remark;              //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSzType() {
		return szType;
	}
	public void setSzType(int szType) {
		this.szType = szType;
	}
	public int getBsType() {
		return bsType;
	}
	public void setBsType(int bsType) {
		this.bsType = bsType;
	}
	public int getRtType() {
		return rtType;
	}
	public void setRtType(int rtType) {
		this.rtType = rtType;
	}
	public int getIsIf() {
		return isIf;
	}
	public void setIsIf(int isIf) {
		this.isIf = isIf;
	}
	public int getIsDk() {
		return isDk;
	}
	public void setIsDk(int isDk) {
		this.isDk = isDk;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getWlCompany() {
		return wlCompany;
	}
	public void setWlCompany(String wlCompany) {
		this.wlCompany = wlCompany;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getSortUser() {
		return sortUser;
	}
	public void setSortUser(String sortUser) {
		this.sortUser = sortUser;
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
