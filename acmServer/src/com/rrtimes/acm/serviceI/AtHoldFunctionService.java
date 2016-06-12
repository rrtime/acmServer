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

import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtHoldFunctionService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 系统功能操作权限 Service 接口类
 * 
 * <p>
 * 	系统功能操作权限 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtHoldFunctionService {
	
	/**
	 * 新增系统功能操作权限
	 * @throws Exception 
	 * 
	 * */
	public int addAtHoldFunction(String[] funIds,int actorId,int operator) throws Exception;
	
	/**
	 * 修改系统功能操作权限
	 * 
	 * */
	public int modAtHoldFunction(String[] funIds,int actorId,int operator) throws Exception;
	
	/**
	 * 根据ActorId和treeId删除功能操作权限数据
	 * @param actorId
	 * @throws Exception 
	 */
	public int delHoldFunctionByActorIdAndTreeId(int actorId,int treeId) throws Exception;
	
	/**
	 * 查询系统功能操作权限详情
	 * @throws Exception 
	 * 
	 * */
	public AtHoldFunction queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询系统功能操作权限列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtHoldFunction> queryListByPage(AtHoldFunction atHoldFunction, PageObject page) throws Exception;
	
	/**
	 * 根据menuCode查询系统功能操作权限
	 * @param menuCode
	 * @throws Exception 
	 */
	public List<AtHoldFunction> findHoldFunctionByMenuCode(String menuCode) throws Exception;

	/**
	 * 根据funId查询系统功能操作权限
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public List<AtHoldFunction> findHoldFunctionByFunId(int funId) throws Exception;
	
	/**
	 * 根据用户或者用户组ID查询功能详细操作字典
	 * @return
	 * @throws Exception 
	 */
	public List<AtModelFunction> findModelFunctionByActorId(int actorId) throws Exception;
	
	/**
	 * 根据用户或者用户组ID查询菜单附属功能字典
	 * @return
	 * @throws Exception 
	 */
	public List<AtSysModel> findAtSysModelByActorId(int actorId) throws Exception;
	
	/**
	 * 根据用户或者用户组ID查询菜单树字典
	 * @return
	 * @throws Exception 
	 */
	public List<AtSysMenu> findAtSysMenuByActorId(int actorId) throws Exception;
	
	/**
	 * 根据actorId和菜单树ID查询功能详细操作字典
	 * @param actorId
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> getModelFunctionByActorIdAndTreeId(int actorId,int treeId) throws Exception;

	/**
	 * 根据功能详细操作字典IDS删除字体功能操作权限
	 * @param funIds
	 * @return
	 * @throws Exception 
	 */
	public int delHoldFunctionByFunIdsAndActorId(String[] funIds,int actorId) throws Exception;

	/**
	 * 查询所有数据
	 * @return
	 */
	public List<AtHoldFunction> findAll();
	
}
