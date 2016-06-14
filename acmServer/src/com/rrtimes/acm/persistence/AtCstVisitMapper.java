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

import com.rrtimes.acm.domain.AtCstVisit;

/**
 * @Title:       AtCstVisitMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 客户回访记录  Dao 接口类
 * 
 * <p>
 * 	客户回访记录  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtCstVisitMapper {
	
	/**
	 * 
	 * 新增客户回访记录
	 * 
	 * */
	public int insert(AtCstVisit atCstVisit);

	/**
	 * 
	 * 客户回访记录修改
	 * 
	 * */
	public int update(AtCstVisit atCstVisit);
	
	/**
	 * 
	 * 客户回访记录删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 客户回访记录信息查询
	 * 
	 * */
	public AtCstVisit findById(int id);
	
	/**
	 * 
	 * 客户回访记录查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtCstVisit> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 客户回访记录查询
	 * 
	 * */
	public List<AtCstVisit> findAll();
	
	/**
	 * 
	 * 客户回访记录数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtCstVisit(int[] ids);

}
