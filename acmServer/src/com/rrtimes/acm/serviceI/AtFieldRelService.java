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
	 * 根据用户或用户组ID查询字段权限关系
	 * @return
	 */
	public List<AtFieldRel> getAtFieldRelListByUid(int uid);
	
	/**
	 * 根据角色ID删除字段权限关系
	 * @return
	 */
	public int delAllByActorId(int uid);
	
	/**
	 * 修改权限
	 * @return
	 * @throws Exception 
	 */
	public int modifyFieldRel(String[] fieldIds,int actorId,int operator) throws Exception;
	
}
