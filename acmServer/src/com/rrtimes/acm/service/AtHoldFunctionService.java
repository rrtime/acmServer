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
	 * 
	 * */
	public int addAtHoldFunction(List<AtHoldFunction> atHoldFunctionList);
	
	/**
	 * 修改系统功能操作权限
	 * 
	 * */
	public int modAtHoldFunction(List<AtHoldFunction> atHoldFunctionList,int actorId,int treeId);
	
	/**
	 * 根据ActorId和treeId删除功能操作权限数据
	 * @param actorId
	 */
	public int delHoldFunctionByActorIdAndTreeId(int actorId,int treeId);
	
	/**
	 * 查询系统功能操作权限详情
	 * 
	 * */
	public AtHoldFunction queryDetailInfo(int id);
	
	/**
	 * 查询系统功能操作权限列表(分页)
	 * 
	 * */
	public List<AtHoldFunction> queryListByPage(AtHoldFunction atHoldFunction, PageObject page);
	
	/**
	 * 根据menuCode查询系统功能操作权限
	 * @param menuCode
	 */
	public List<AtHoldFunction> findHoldFunctionByMenuCode(String menuCode);

	/**
	 * 根据funId查询系统功能操作权限
	 * @param id
	 * @return
	 */
	public List<AtHoldFunction> findHoldFunctionByFunId(int funId);
	
	/**
	 * 根据用户或者用户组ID查询功能详细操作字典
	 * @return
	 */
	public List<AtModelFunction> findModelFunctionByActorId(int actorId);
	
	/**
	 * 根据用户或者用户组ID查询菜单附属功能字典
	 * @return
	 */
	public List<AtSysModel> findAtSysModelByActorId(int actorId);
	
	/**
	 * 根据用户或者用户组ID查询菜单树字典
	 * @return
	 */
	public List<AtSysMenu> findAtSysMenuByActorId(int actorId);
	
	/**
	 * 根据actorId和菜单树ID查询功能详细操作字典
	 * @param actorId
	 * @param treeId
	 * @return
	 */
	public List<Map<String, Object>> getModelFunctionByActorIdAndTreeId(int actorId,int treeId);
	
}
