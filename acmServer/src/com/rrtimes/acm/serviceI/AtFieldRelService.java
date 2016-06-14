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


import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtFieldDictService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 用户字段权限关系 Service 接口类
 * 
 * <p>
 * 	用户字段权限关系 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtFieldRelService {
	
	/**
	 * 新增用户字段权限关系
	 * @throws Exception 
	 * 
	 * */
	public int grantToUserOrRole(String jsonStr,int uid,int operator) throws Exception;
	
	/**
	 * 删除用户字段权限关系
	 * @throws Exception 
	 * 
	 * */
	public int delAtFieldRel(int id) throws Exception;
	
	/**
	 * 删除用户字段权限关系
	 * @throws Exception 
	 * 
	 * */
	public int delAtFieldRelByUidAndTreeId(int uid,int treeId) throws Exception;
	
	/**
	 * 查询用户字段权限关系详情
	 * @throws Exception 
	 * 
	 * */
	public AtFieldRel queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询用户字段权限关系列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtFieldRel> queryListByPage(AtFieldRel atFieldRel, PageObject page) throws Exception;
	
	/**
	 * 根据用户或组ID和menuCode查询用户字段权限关系
	 * @param uid
	 * @param menuCode
	 * @return
	 * @throws Exception 
	 */
	public List<AtFieldRel> findAtFieldRelByUidAndMenuCode(int uid,String menuCode) throws Exception;
	
	/**
	 * 
	 * 用户字段权限关系查询
	 * 
	 * */
	public List<AtFieldRel> findAll() throws Exception;
	
	/**
	 * 根据用户或组ID和treeId查询用户字段权限关系
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String,Object>> findAtFieldRelByUidAndTreeId(int uid,int treeId) throws Exception;

	/**
	 * 根据系统权限字段IDS删除用户字段权限关系
	 * @param dictIds
	 * @return
	 * @throws Exception 
	 */
	public int delFieldRelByDictIdsAndUid(String[] dictIds, int id) throws Exception;

	/**
	 * 根据用户或用户组ID查询字段权限关系
	 * @return
	 */
	public List<AtFieldRel> getAtFieldRelListByUid(int uid);
	
}
