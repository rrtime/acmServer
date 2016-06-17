/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtFieldDictService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 系统权限字段字典 Service 接口类
 * 
 * <p>
 * 	系统权限字段字典 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtFieldDictService {
	
	/**
	 * 新增系统权限字段字典
	 * @throws Exception 
	 * 
	 * */
	public int addAtFieldDict(AtFieldDict atFieldDict) throws Exception;
	
	/**
	 * 修改系统权限字段字典
	 * @throws Exception 
	 * 
	 * */
	public int modAtFieldDict(AtFieldDict atFieldDict) throws Exception;
	
	/**
	 * 删除系统权限字段字典
	 * @throws Exception 
	 * 
	 * */
	public int delAtFieldDict(int id) throws Exception;
	
	/**
	 * 查询系系统权限字段字典详情
	 * @throws Exception 
	 * 
	 * */
	public AtFieldDict queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询系统权限字段字典列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtFieldDict> queryListByPage(AtFieldDict atFieldDict, PageObject page) throws Exception;
	
	/**
	 * 根据菜单树ID查询系统权限字段字典
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> findAtFieldDictByTreeId(int treeId) throws Exception;

	/**
	 * 查询所有数据
	 * @return
	 */
	public List<AtFieldDict> findAll() throws Exception;

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtFieldDict(int[] ids) throws Exception;
	
}
