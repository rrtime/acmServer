/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-11		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.persistence;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.DevApp;

/**
 * @Title:       DevAppMapper.java
 * @Package:     com.tstar.charge.persistence
 * @Description: 应用信息 Dao 接口
 * 
 * <p>
 * 	应用信息 Dao
 * </p> 
 * 
 * @author liht
 * 
 */
public interface DevAppMapper {
	
	/**
	 * 
	 * 新增应用
	 * 
	 * */
	public int insert(DevApp devApp);

	/**
	 * 
	 * 应用信息修改
	 * 
	 * */
	public int update(DevApp devApp);
	
	/**
	 * 
	 * 应用信息删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 应用详细信息查询
	 * 
	 * */
	public DevApp findById(int id);
	
	/**
	 * 
	 * 应用信息查询(通用组合查询,支持分页功能)
	 * 		map 中参数名：
	 * 
	 * */
	public List<DevApp> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 开发者数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);

}
