/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtSysModel.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 菜单附属功能字典实体
 * 
 * <p>
 * 	菜单附属功能字典实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtSysModel implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4142733037928706758L;

	private int id;//主键ID
	
	private int treeId;//所属菜单树ID
	
	private String menuCode;//功能编码
	
	private String mname;//功能名称
	
	private String mdesc;//功能描述
	
	private int isSystem;//
	
	private int category;//
	
	private int isConShownum;//是否控制显示个数
	
	private int controlNum;//控制个数
	
	private String controlPage;//控制页面
	
	private int showIndex;//菜单显示顺序
	
	private Timestamp createTime;//创建世界
	
	private Date updateTime;//修改时间
	
	private String remark;//备注
	
	private String showClass;
	
    private String murl;
    
    private String micon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTreeId() {
		return treeId;
	}

	public void setTreeId(int treeId) {
		this.treeId = treeId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public int getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(int isSystem) {
		this.isSystem = isSystem;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getIsConShownum() {
		return isConShownum;
	}

	public void setIsConShownum(int isConShownum) {
		this.isConShownum = isConShownum;
	}

	public int getControlNum() {
		return controlNum;
	}

	public void setControlNum(int controlNum) {
		this.controlNum = controlNum;
	}

	public String getControlPage() {
		return controlPage;
	}

	public void setControlPage(String controlPage) {
		this.controlPage = controlPage;
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

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getShowClass() {
		return showClass;
	}

	public void setShowClass(String showClass) {
		this.showClass = showClass;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public String getMicon() {
		return micon;
	}

	public void setMicon(String micon) {
		this.micon = micon;
	}
	
	
}
