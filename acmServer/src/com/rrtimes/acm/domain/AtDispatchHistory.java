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

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtDispatchHistory.java
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
public class AtDispatchHistory implements ISerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5982259234180292933L;
	private int id;                  //主键ID
	private int cid;                 //合同ID
	private int lasUid;              //派工人员
	private int currentDept;         //派工任务部门
	private String currentUids;      //派工任务人员集合
	private String operator;         //派工管理员
	private Timestamp createTime;    //派工时间
	private String remark;           //备注
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
	public int getLasUid() {
		return lasUid;
	}
	public void setLasUid(int lasUid) {
		this.lasUid = lasUid;
	}
	public int getCurrentDept() {
		return currentDept;
	}
	public void setCurrentDept(int currentDept) {
		this.currentDept = currentDept;
	}
	public String getCurrentUids() {
		return currentUids;
	}
	public void setCurrentUids(String currentUids) {
		this.currentUids = currentUids;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
