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
 * @Title:       AtSysNotice.java
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
public class AtSysNotice implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4338361808385412743L;
	private int id;                //主键ID
	private String cpCode;         //所属代账机构
	private int ntype;             //通知类型
	private String ntitle;         //标题
	private String nkey;           //关键字
	private String ncontent;       //内容
	private int nstatus;           //通知公告状态
	private String nhistory;       //撤回说明
	private String oids;           //发布部门范围
	private String uids;           //发布用户列表
	private int uid;               //操作员
	private Timestamp createTime;  //创建时间
	private int lastUid;           //最后修改人
	private Date updateTime;       //修改时间
	private String remark;         //备注
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
	
	public String getOids() {
		return oids;
	}
	public void setOids(String oids) {
		this.oids = oids;
	}
	public String getUids() {
		return uids;
	}
	public void setUids(String uids) {
		this.uids = uids;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getLastUid() {
		return lastUid;
	}
	public void setLastUid(int lastUid) {
		this.lastUid = lastUid;
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
	public int getNtype() {
		return ntype;
	}
	public void setNtype(int ntype) {
		this.ntype = ntype;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNkey() {
		return nkey;
	}
	public void setNkey(String nkey) {
		this.nkey = nkey;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public int getNstatus() {
		return nstatus;
	}
	public void setNstatus(int nstatus) {
		this.nstatus = nstatus;
	}
	public String getNhistory() {
		return nhistory;
	}
	public void setNhistory(String nhistory) {
		this.nhistory = nhistory;
	}
}
