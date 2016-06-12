/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;

import com.rrtimes.acm.domain.CdrResource;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       CdrResourceService.java
 * @Package:     com.tstar.charge.service
 * @Description: 分拣源管理服务接口类
 * 
 * <p>
 * 	分拣源管理服务接口
 * </p> 
 * 
 * @author liht
 * 
 */
public interface CdrResourceService {
	
	/**
	 * 新增分拣源
	 * 
	 * */
	public int insert(CdrResource cdrResource);
	
	/**
	 * 修改分拣源
	 * 
	 * */
	public int update(CdrResource cdrResource);
	
	/**
	 * 修改分拣源
	 * 		flag	0 启用, 1 停用
	 * 
	 * */
	public int updateFlag(int id, int flag);
	
	/**
	 * 删除分拣源
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 查询分拣源详情
	 * 
	 * */
	public CdrResource queryDetail(int id);
	
	/**
	 * 查询分拣源列表(分页)
	 * 
	 * */
	public List<CdrResource> queryAll(CdrResource cdrResource, PageObject page);
	
}
