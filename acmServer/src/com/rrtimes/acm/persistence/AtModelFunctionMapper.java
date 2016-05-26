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

import com.rrtimes.acm.domain.AtModelFunction;

/**
 * @Title:       AtModelFunctionMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 功能详细操作字典  Dao 接口类
 * 
 * <p>
 * 	功能详细操作字典  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtModelFunctionMapper {
	
	/**
	 * 
	 * 新增功能详细操作字典
	 * 
	 * */
	public int insert(AtModelFunction atModelFunction);

	/**
	 * 
	 * 功能详细操作字典修改
	 * 
	 * */
	public int update(AtModelFunction atModelFunction);
	
	/**
	 * 
	 * 功能详细操作字典删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 功能详细操作字典详细信息查询
	 * 
	 * */
	public AtModelFunction findById(int id);
	
	/**
	 * 
	 * 功能详细操作字典字典查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtModelFunction> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 功能详细操作字典字典查询
	 * 
	 * */
	public List<AtModelFunction> findAll();
	
	/**
	 * 
	 * 功能详细操作字典数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);

	/**
	 * 根据menuCode查询功能详细操作字典
	 * @param menuCode
	 */
	public List<AtModelFunction> findModelFunctionByMenuCode(String menuCode);
	
	/**
	 * 根据treeId查询功能详细操作字典
	 * @param map
	 */
	public List<Map<String,Object>> findModelFunctionByTreeId(int treeId);

}
