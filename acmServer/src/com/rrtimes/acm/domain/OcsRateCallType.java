package com.rrtimes.acm.domain;

import java.util.Date;
/**
 * 呼叫类型
 * @author Administrator
 *
 */
public class OcsRateCallType {
	private int id;
	
	private String callType;
	
	private String callerPrefix;
	
	private String calleePrefix;
	
	private String superLen;
	
	private int status;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCallerPrefix() {
		return callerPrefix;
	}

	public void setCallerPrefix(String callerPrefix) {
		this.callerPrefix = callerPrefix;
	}

	public String getCalleePrefix() {
		return calleePrefix;
	}

	public void setCalleePrefix(String calleePrefix) {
		this.calleePrefix = calleePrefix;
	}

	public String getSuperLen() {
		return superLen;
	}

	public void setSuperLen(String superLen) {
		this.superLen = superLen;
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

}
