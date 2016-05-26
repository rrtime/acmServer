package com.rrtimes.acm.domain;

import java.util.Date;
/**
 * 套餐业务类型
 * @author Administrator
 *
 */
public class OcsPackageBusiness {
	private int id;

	private int bid;// 业务分类id

	private int cid;// 呼叫类型id

	private int status;

	private Date createTime;

	private Date updateTime;

	private String remark;
	
	private String pbName;
	
	private String businessTypeName;
	
	private String callTypeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getPbName() {
		return pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}

	public String getCallTypeName() {
		return callTypeName;
	}

	public void setCallTypeName(String callTypeName) {
		this.callTypeName = callTypeName;
	}
	

}
