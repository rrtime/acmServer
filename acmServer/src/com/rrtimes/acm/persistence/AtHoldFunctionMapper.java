/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.persistence;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;

/**
 * @Title:       AtHoldFunctionMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 系统功能操作权限  Dao 接口类
 * 
 * <p>
 * 	系统功能操作权限  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtHoldFunctionMapper {
	
	/**
	 * 
	 * 新增系统功能操作权限
	 * 
	 * */
	public int insert(AtHoldFunction atHoldFunction);

	/**
	 * 
	 * 系统功能操作权限修改
	 * 
	 * */
	public int update(AtHoldFunction atHoldFunction);
	
	/**
	 * 
	 * 系统功能操作权限详细信息查询
	 * 
	 * */
	public AtHoldFunction findById(int id);
	
	/**
	 * 
	 * 系统功能操作权限字典查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtHoldFunction> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 系统功能操作权限字典查询
	 * 
	 * */
	public List<AtHoldFunction> findAll();
	
	/**
	 * 
	 * 系统功能操作权限数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);

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
	 * 根据actorId和treeId查询功能操作权限数据
	 * @param map
	 * @return
	 */
	public List<AtHoldFunction> findHoldFunctionByActorIdAndMenuCode(Map<String, Object> map);

	/**
	 * 根据ActorId和treeId删除功能操作权限数据
	 * @param map
	 */
	public int delHoldFunctionByActorIdAndTreeId(Map<String, Object> map);
	
	/**
	 * 根据用户或者用户组ID查询菜单树字典
	 * @return
	 */
	public List<AtSysMenu> findAtSysMenuByActorId(int actorId);
	
	/**
	 * 根据actorId和菜单树ID查询功能详细操作字典
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getModelFunctionByActorIdAndTreeId(Map<String, Object> map);

	/**
	 * 根据IDS查询功能详细操作字典列表
	 * @param ids
	 * @return
	 */
	public List<AtModelFunction> getModelFunctionListByIdArray(String[] funIds);

	/**
	 * 根据功能操作字典ID查询所属菜单树
	 * @param funIds
	 * @return
	 */
	public List<AtSysModel> getTreeIdByFunIdArray(String[] funIds);
	
	/**
	 * 根据用户或用户组ID查询功能操作权限
	 * @param actorId
	 * @return
	 */
	public List<AtHoldFunction> getHoldFunctionListByActorId(int actorId);


}
