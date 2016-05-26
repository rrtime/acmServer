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

import com.rrtimes.acm.domain.BusinessDict;

/**
 * @Title:       BusinessDictMapper.java
 * @Package:     com.tstar.charge.persistence
 * @Description: 业务类型字典表 Dao 接口类
 * 
 * <p>
 * 	业务类型字典表 Dao 接口
 * </p> 
 * 
 * @author liht
 * 
 */
public interface BusinessDictMapper {
	
	/**
	 * 
	 * 新增业务类型信息
	 * 
	 * */
	public int insert(BusinessDict businessDict);

	/**
	 * 
	 * 业务类型信息修改
	 * 
	 * */
	public int update(BusinessDict businessDict);
	
	/**
	 * 
	 * 业务类型信息删除
	 * 
	 * */
	public int delete(int id);
	
	
	/**
	 * 
	 * 业务类型详细信息查询
	 * 
	 * */
	public BusinessDict findById(int id);
	
	/**
	 * 
	 * 业务类型信息查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<BusinessDict> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 业务类型信息查询
	 * 
	 * */
	public List<BusinessDict> findAll();
	
	/**
	 * 
	 * 业务类型数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);

}
