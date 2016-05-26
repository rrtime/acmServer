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
	 * 
	 * */
	public int addAtFieldDict(AtFieldDict atFieldDict);
	
	/**
	 * 修改系统权限字段字典
	 * 
	 * */
	public int modAtFieldDict(AtFieldDict atFieldDict);
	
	/**
	 * 删除系统权限字段字典
	 * 
	 * */
	public int delAtFieldDict(int id);
	
	/**
	 * 查询系系统权限字段字典详情
	 * 
	 * */
	public AtFieldDict queryDetailInfo(int id);
	
	/**
	 * 查询系统权限字段字典列表(分页)
	 * 
	 * */
	public List<AtFieldDict> queryListByPage(AtFieldDict atFieldDict, PageObject page);
	
	/**
	 * 根据菜单树ID查询系统权限字段字典
	 * @param treeId
	 * @return
	 */
	public List<Map<String, Object>> findAtFieldDictByTreeId(int treeId);
	
}
