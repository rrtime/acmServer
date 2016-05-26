/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtModelFunctionService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 功能详细操作字典 Service 接口类
 * 
 * <p>
 * 	功能详细操作字典 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtModelFunctionService {
	
	/**
	 * 新增功能详细操作字典
	 * 
	 * */
	public int addAtModelFunction(AtModelFunction atModelFunction);
	
	/**
	 * 修改功能详细操作字典
	 * 
	 * */
	public int modAtModelFunction(AtModelFunction atModelFunction);
	
	/**
	 * 删除功能详细操作字典
	 * 
	 * */
	public int delAtModelFunction(AtModelFunction atModelFunction);
	
	/**
	 * 查询功能详细操作字典详情
	 * 
	 * */
	public AtModelFunction queryDetailInfo(int id);
	
	/**
	 * 查询功能详细操作字典列表(分页)
	 * 
	 * */
	public List<AtModelFunction> queryListByPage(AtModelFunction atModelFunction, PageObject page);
	
	/**
	 * 根据menuCode查询功能详细操作字典
	 * @param menuCode
	 */
	public List<AtModelFunction> findModelFunctionByMenuCode(String menuCode);
	
	/**
	 * 根据treeId查询功能详细操作字典
	 * @param treeId
	 */
	public List<Map<String,Object>> findModelFunctionByTreeId(int treeId);
	
}
