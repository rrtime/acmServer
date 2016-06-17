/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-12		| 	 lihaitao 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * 
 * CaaS 计费系统 系统功能菜单字典表实体类
 * 
 * <p>
 * 	系统功能菜单字典表实体
 * </p> 
 * 
 * @author lihaitao
 * 
 */
public class SystemMenuDict {
	
	private int id;
	
	private String menuName;
	
	private String menuDesc;
	
	private String menuIco;
	
	private String menuUrl;
	
	private int parentId;
	
	private int menuStatus;
	
	private int menuSort;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String remark;
	
	// 是否勾选( 0 不勾选，1 勾选)，角色授权修改管理时使用
	private int isCheck = 0;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuIco() {
		return menuIco;
	}

	public void setMenuIco(String menuIco) {
		this.menuIco = menuIco;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getMenuStatus() {
		return menuStatus;
	}

	public int getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(int menuSort) {
		this.menuSort = menuSort;
	}

	public void setMenuStatus(int menuStatus) {
		this.menuStatus = menuStatus;
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

	public int getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}
	
	
	

}
