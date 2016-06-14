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

import com.rrtimes.acm.domain.AtComplain;

/**
 * @Title:       AtComplainMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 客户投诉信息  Dao 接口类
 * 
 * <p>
 * 	客户投诉信息  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtComplainMapper {
	
	/**
	 * 
	 * 新增客户投诉信息
	 * 
	 * */
	public int insert(AtComplain atComplain);

	/**
	 * 
	 * 客户投诉信息修改
	 * 
	 * */
	public int update(AtComplain atComplain);
	
	/**
	 * 
	 * 客户投诉信息删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 客户投诉信息查询
	 * 
	 * */
	public AtComplain findById(int id);
	
	/**
	 * 
	 * 客户投诉信息查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtComplain> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 客户投诉信息查询
	 * 
	 * */
	public List<AtComplain> findAll();
	
	/**
	 * 
	 * 客户投诉信息数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);

	/**
	 * 批量删除
	 * @return
	 */
	public int batchDeleteAtComplain(int[] ids);

}
