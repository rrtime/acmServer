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

import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.AtSysModel;

/**
 * @Title:       AtFieldRelMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 用户字段权限关系  Dao 接口类
 * 
 * <p>
 * 	用户字段权限关系  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtFieldRelMapper {
	
	/**
	 * 
	 * 新增用户字段权限关系
	 * 
	 * */
	public int insert(AtFieldRel atFieldRel);

	/**
	 * 
	 * 用户字段权限关系修改
	 * 
	 * */
	public int update(AtFieldRel atFieldRel);
	
	/**
	 * 
	 * 用户字段权限关系删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 用户字段权限关系详细信息查询
	 * 
	 * */
	public AtFieldRel findById(int id);
	
	/**
	 * 
	 * 用户字段权限关系查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtFieldRel> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 用户字段权限关系查询
	 * 
	 * */
	public List<AtFieldRel> findAll();
	
	/**
	 * 
	 * 用户字段权限关系数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);
	
	/**
	 * 根据用户或组ID和menuCode查询用户字段权限关系
	 * @param map
	 * @return
	 */
	public List<AtFieldRel> findAtFieldRelByUidAndMenuCode(Map<String, Object> map);

	/**
	 * 删除用户字段权限关系
	 * @param map
	 */
	public int delAtFieldRelByUidAndTreeId(Map<String, Object> map);
	
	/**
	 * 根据用户或组ID和treeId查询用户字段权限关系
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> findAtFieldRelByUidAndTreeId(Map<String, Object> map);

	/**
	 * 根据dictIds查询系统权限字段字典
	 * @param dictIds
	 * @return
	 */
	public List<AtFieldDict> getFieldDictListByIdArray(String[] dictIds);

	/**
	 * 根据字典ID查询所属菜单树
	 * @param dictIds
	 * @return
	 */
	public List<AtSysModel> getTreeIdByDictIdArray(String[] dictIds);

	/**
	 * 根据用户或用户组ID查询字段权限关系
	 * @return
	 */
	public List<AtFieldRel> getAtFieldRelListByUid(int uid);
	
	/**
	 * 根据角色ID删除字段权限关系
	 * @param actorId
	 * @return
	 */
	public int delAllByActorId(int actorId);

	/**
	 * 根据IDS查询权限字段字典列表
	 * @param ids
	 * @return
	 */
	public List<AtFieldDict> getFieldDictByIdArray(String[] fieldIds);


	
}
