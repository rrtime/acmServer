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

import com.rrtimes.acm.domain.AtFieldDict;

/**
 * @Title:       AtFieldDictMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 系统权限字段字典  Dao 接口类
 * 
 * <p>
 * 	系统权限字段字典  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtFieldDictMapper {
	
	/**
	 * 
	 * 新增系统权限字段字典
	 * 
	 * */
	public int insert(AtFieldDict atFieldDict);

	/**
	 * 
	 * 系统权限字段字典修改
	 * 
	 * */
	public int update(AtFieldDict atFieldDict);
	
	/**
	 * 
	 * 系统权限字段字典删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 系统权限字段字典详细信息查询
	 * 
	 * */
	public AtFieldDict findById(int id);
	
	/**
	 * 
	 * 系统权限字段字典查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtFieldDict> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 系统权限字段字典查询
	 * 
	 * */
	public List<AtFieldDict> findAll();
	
	/**
	 * 
	 * 系统权限字段字典数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);
	
	/**
	 * 根据菜单树ID查询系统权限字段字典
	 * @param treeId
	 * @return
	 */
	public List<Map<String, Object>> findAtFieldDictByTreeId(int treeId);

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtFieldDict(int[] ids);

}
