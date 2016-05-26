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
public class AcmSysMenu {
    private int Id;                  //主键ID
    private String MenuName;         //菜单名称
    private String MenuDesc;         //菜单描述
    private String MenuIco;          //菜单图标
    private String MenuUrl;          //菜单URL
    private int ParentId;            //父级菜单ID
    private int MenuStatus;          //菜单状态
    private int MenuSort;            //菜单顺序
    private Timestamp CreateTime;    //菜单创建时间
    private Date UpdateTime;         //菜单修改时间
    private String Remark;           //备注
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMenuName() {
		return MenuName;
	}
	public void setMenuName(String menuName) {
		MenuName = menuName;
	}
	public String getMenuDesc() {
		return MenuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		MenuDesc = menuDesc;
	}
	public String getMenuIco() {
		return MenuIco;
	}
	public void setMenuIco(String menuIco) {
		MenuIco = menuIco;
	}
	public String getMenuUrl() {
		return MenuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		MenuUrl = menuUrl;
	}
	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		ParentId = parentId;
	}
	public int getMenuStatus() {
		return MenuStatus;
	}
	public void setMenuStatus(int menuStatus) {
		MenuStatus = menuStatus;
	}
	public int getMenuSort() {
		return MenuSort;
	}
	public void setMenuSort(int menuSort) {
		MenuSort = menuSort;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
}
