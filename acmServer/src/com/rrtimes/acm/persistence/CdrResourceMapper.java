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

import org.apache.ibatis.annotations.Param;

import com.rrtimes.acm.domain.CdrResource;

/**
 * @Title:       CdrResourceMapper.java
 * @Package:     com.tstar.charge.persistence
 * @Description: 话单分拣源 Dao 接口类
 * 
 * <p>
 * 	话单分拣源 Dao 接口
 * </p> 
 * 
 * @author liht
 * 
 */
public interface CdrResourceMapper {

	/**
	 * 
	 * 新增分拣源
	 * 
	 * */
	public int insert(CdrResource cdrResource);

	/**
	 * 
	 * 分拣源信息修改
	 * 
	 * */
	public int update(CdrResource cdrResource);
	
	/**
	 * 
	 * 分拣源信息删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 分拣源配置信息停用/启用
	 * 		分拣源状态标志 flag		0 停用, 1 启用
	 * 
	 * */
	public int updateStatus(@Param("id")int id, @Param("flag")int flag);
	
	/**
	 * 
	 * 分拣源详细信息查询
	 * 
	 * */
	public CdrResource findById(int id);
	
	/**
	 * 
	 * 分拣源信息查询(通用组合查询,支持分页功能)
	 * 		map 中参数名：
	 * 
	 * */
	public List<CdrResource> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 开发者数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);
	
}
