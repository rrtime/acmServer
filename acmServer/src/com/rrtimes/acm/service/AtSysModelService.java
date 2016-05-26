/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service;

import java.util.List;

import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtSysModelService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 菜单附属功能字典 Service 接口类
 * 
 * <p>
 * 	菜单附属功能字典 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtSysModelService {
	
	/**
	 * 新增菜单附属功能字典
	 * 
	 * */
	public int addAtSysModel(AtSysModel atSysModel);
	
	/**
	 * 修改菜单附属功能字典
	 * 
	 * */
	public int modAtSysModel(AtSysModel atSysModel);
	
	/**
	 * 删除菜单附属功能字典
	 * 
	 * */
	public int delAtSysModel(AtSysModel atSysModel);
	
	/**
	 * 查询菜单附属功能字典详情
	 * 
	 * */
	public AtSysModel queryDetailInfo(int id);
	
	/**
	 * 查询菜单附属功能字典列表(分页)
	 * 
	 * */
	public List<AtSysModel> queryListByPage(AtSysModel atSysModel, PageObject page);
	
	/**
	 * 根据菜单树ID查询菜单附属功能
	 * @param treeId
	 * @return
	 */
	public List<AtSysModel> getAtSysModelByTreeId(int treeId);
	
}
