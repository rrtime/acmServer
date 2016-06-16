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
 * @Title:       AtUserDsektop.java
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
public class AtUserDesktop implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4453609641466406560L;
	
	private int id;              //主键id
	private String userId;       //用户ID
	private int dtype;           //定制类型
	private int mid;             //定制功能ID
	private int viewSort;        //显示顺序
	private Timestamp createTime;//创建时间
	private String operator;     //操作员
	private String remark;       //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getDtype() {
		return dtype;
	}
	public void setDtype(int dtype) {
		this.dtype = dtype;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getViewSort() {
		return viewSort;
	}
	public void setViewSort(int viewSort) {
		this.viewSort = viewSort;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
