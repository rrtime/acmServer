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
 * @Title:       AtModelFunction.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 功能详细操作字典实体
 * 
 * <p>
 * 	功能详细操作字典实体
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtModelFunction implements ISerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 179648123643643247L;

	private int id;//主键ID
	
	private int treeId;//所属菜单树ID
	
	private String menuCode;//功能编码
	
	private String fname;//操作名称
	
	private String ftitle;//操作显示名称
	
	private int tableIndex;//
	
	private int isSystem;//
	
	private String funCode;//操作编码
	
	private String funDesc;//操作描述
	
	private int idParent;//控制个数
	
	private int controlId;//控制权限ID
	
	private int controlType;//控制类型
	
	private int isHastag;//是否有说明
	
	private int category;//类型
	
	private int showIndex;//功能显示顺序
	
	private int isConShownum;//是否控制显示个数
	
	private int controlNum;//控制个数
	
	private String controlPage;//控制页面
	
	private Timestamp createTime;//创建时间
	
	private String operator;//更新操作员
	
	private Date updateTime;//修改时间
	
	private String remark;//备注

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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public int getTableIndex() {
		return tableIndex;
	}

	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}

	public int getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(int isSystem) {
		this.isSystem = isSystem;
	}

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}

	public String getFunDesc() {
		return funDesc;
	}

	public void setFunDesc(String funDesc) {
		this.funDesc = funDesc;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public int getControlId() {
		return controlId;
	}

	public void setControlId(int controlId) {
		this.controlId = controlId;
	}

	public int getControlType() {
		return controlType;
	}

	public void setControlType(int controlType) {
		this.controlType = controlType;
	}

	public int getIsHastag() {
		return isHastag;
	}

	public void setIsHastag(int isHastag) {
		this.isHastag = isHastag;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
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
