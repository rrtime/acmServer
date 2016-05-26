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
 * @Title:       AcmSysMenu.java
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
public class AtSysMenu implements ISerializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4616334747141037634L;
	private int id;                              //主键ID
    private String mtitle;                       //菜单名称
    private String mdesc;                        //菜单描述
    private int parentId;                        //上级菜单ID
    private int tflag;
    private String inid;                         //菜单编码
    private int isSystem;
    private int category;          
    private int isEndnode;                       //是否最后节点
    private int showIndex;                       //菜单显示顺序
    private Timestamp createTime;                //创建时间
    private Date updateTime;                     //修改时间
    private String remark;                       //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getTflag() {
		return tflag;
	}
	public void setTflag(int tflag) {
		this.tflag = tflag;
	}
	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	public int getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(int isSystem) {
		this.isSystem = isSystem;
	}
	public int getIsEndnode() {
		return isEndnode;
	}
	public void setIsEndnode(int isEndnode) {
		this.isEndnode = isEndnode;
	}
	public int getShowIndex() {
		return showIndex;
	}
	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
}
