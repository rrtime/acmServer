/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

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
	 * @throws Exception 
	 * 
	 * */
	public int addAtSysModel(AtSysModel atSysModel) throws Exception;
	
	/**
	 * 修改菜单附属功能字典
	 * @throws Exception 
	 * 
	 * */
	public int modAtSysModel(AtSysModel atSysModel) throws Exception;
	
	/**
	 * 删除菜单附属功能字典
	 * @throws Exception 
	 * 
	 * */
	public int delAtSysModel(AtSysModel atSysModel) throws Exception;
	
	/**
	 * 查询菜单附属功能字典详情
	 * @throws Exception 
	 * 
	 * */
	public AtSysModel queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询菜单附属功能字典列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtSysModel> queryListByPage(AtSysModel atSysModel, PageObject page) throws Exception;
	
	/**
	 * 根据菜单树ID查询菜单附属功能
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	public List<AtSysModel> getAtSysModelByTreeId(int treeId) throws Exception;

	/**
	 * 查询所有数据
	 * @return
	 */
	public List<AtSysModel> findAll() throws Exception;

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtSysModel(int[] ids) throws Exception;
	
	/**
	 * 根据功能id查询model
	 * @return
	 * @throws Exception 
	 */
	public List<AtSysModel> queryAtSysModelByUserId(int userId);
}
