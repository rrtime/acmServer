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

import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.AtUser;
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
	 * 
	 * */
	public int addAtFieldRel(String idInfos,AtUser atUser,String operator);
	
	/**
	 * 修改用户字段权限关系
	 * 
	 * */
	public int modAtFieldRel(String idInfos,AtUser atUser,String operator,int treeId);
	
	/**
	 * 删除用户字段权限关系
	 * 
	 * */
	public int delAtFieldRel(int id);
	
	/**
	 * 删除用户字段权限关系
	 * 
	 * */
	public int delAtFieldRelByUidAndTreeId(int uid,int treeId);
	
	/**
	 * 查询用户字段权限关系详情
	 * 
	 * */
	public AtFieldRel queryDetailInfo(int id);
	
	/**
	 * 查询用户字段权限关系列表(分页)
	 * 
	 * */
	public List<AtFieldRel> queryListByPage(AtFieldRel atFieldRel, PageObject page);
	
	/**
	 * 根据用户或组ID和menuCode查询用户字段权限关系
	 * @param uid
	 * @param menuCode
	 * @return
	 */
	public List<AtFieldRel> findAtFieldRelByUidAndMenuCode(int uid,String menuCode);
	
	/**
	 * 
	 * 用户字段权限关系查询
	 * 
	 * */
	public List<AtFieldRel> findAll();
	
	/**
	 * 根据用户或组ID和treeId查询用户字段权限关系
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> findAtFieldRelByUidAndTreeId(int uid,int treeId);
	
}
