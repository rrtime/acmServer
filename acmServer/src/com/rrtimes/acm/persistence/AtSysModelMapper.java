/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.persistence;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtSysModel;

/**
 * @Title:       AtSysModelMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 菜单附属功能字典  Dao 接口类
 * 
 * <p>
 * 	菜单附属功能字典  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtSysModelMapper {
	
	/**
	 * 
	 * 新增菜单附属功能字典
	 * 
	 * */
	public int insert(AtSysModel atSysModel);

	/**
	 * 
	 * 菜单附属功能字典修改
	 * 
	 * */
	public int update(AtSysModel atSysModel);
	
	/**
	 * 
	 * 菜单附属功能字典删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 菜单附属功能字典详细信息查询
	 * 
	 * */
	public AtSysModel findById(int id);
	
	/**
	 * 
	 * 菜单附属功能字典查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtSysModel> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 菜单附属功能字典查询
	 * 
	 * */
	public List<AtSysModel> findAll();
	
	/**
	 * 
	 * 菜单附属功能字典数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);
	
	/**
	 * 根据菜单树ID查询菜单附属功能
	 * @param treeId
	 * @return
	 */
	public List<AtSysModel> getAtSysModelByTreeId(int treeId);

}
