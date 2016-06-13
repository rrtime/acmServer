/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtHoldFunctionMapper;
import com.rrtimes.acm.serviceI.AtHoldFunctionService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtHoldFunctionServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 系统功能操作权限 Service 接口实现类
 * 
 * <p>
 * 	系统功能操作权限 Service 接口实现类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtHoldFunctionServiceImpl implements AtHoldFunctionService {

	@Resource
	private AtHoldFunctionMapper atHoldFunctionMapper;
	
	/**
	 * 系统功能操作权限新增
	 * @param funIds 功能字典ID数组
	 * @param actorId 所要授权的用户或用户组
	 * @param operator 操作员ID
	 */
	@Override
	public int addAtHoldFunction(String[] funIds,int actorId,int operator) throws Exception{
		int result = 0;
		//根据funId查询功能详细操作字典
		List<AtModelFunction> modelFunctionList = atHoldFunctionMapper.getModelFunctionListByIdArray(funIds);
		//循环插入
		if(StringUtil.isListNotNull(modelFunctionList)){//功能操作字典不为空
			int insertResult = 0;
			AtHoldFunction atHoldFunction = new AtHoldFunction();
			for(int i=0;i<modelFunctionList.size();i++){//循环插入
				//封装对象
				atHoldFunction.setMenuCode(modelFunctionList.get(i).getMenuCode());
				atHoldFunction.setFunName(modelFunctionList.get(i).getFname());
				atHoldFunction.setFunId(modelFunctionList.get(i).getId());
				atHoldFunction.setActorId(actorId);
				atHoldFunction.setOperator(String.valueOf(operator));
				atHoldFunction.setRemark("");
				//插入
				insertResult = atHoldFunctionMapper.insert(atHoldFunction);
				if(insertResult <= 0){//插入失败
					result = 1;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 系统功能操作权限修改
	 * @param funIds 功能字典ID数组
	 * @param actorId 所要授权的用户或用户组
	 * @param operator 操作员ID
	 */
	@Override
	public int modAtHoldFunction(String[] funIds,int actorId,int operator) throws Exception {
		int result = 0;
		//首先删除该用户或者组已有功能操作权限
		this.delHoldFunctionByFunIdsAndActorId(funIds, actorId);
		//根据funId查询功能详细操作字典
		List<AtModelFunction> modelFunctionList = atHoldFunctionMapper.getModelFunctionListByIdArray(funIds);
		//再重新插入
		if(StringUtil.isListNotNull(modelFunctionList)){
			int insertResult = 0;
			AtHoldFunction atHoldFunction = new AtHoldFunction();
			for(int i=0;i<modelFunctionList.size();i++){
				//封装对象
				atHoldFunction.setMenuCode(modelFunctionList.get(i).getMenuCode());
				atHoldFunction.setFunName(modelFunctionList.get(i).getFname());
				atHoldFunction.setFunId(modelFunctionList.get(i).getId());
				atHoldFunction.setActorId(actorId);
				atHoldFunction.setOperator(String.valueOf(operator));
				atHoldFunction.setUpdateTime(new Date());
				atHoldFunction.setRemark("");
				//插入
				insertResult = atHoldFunctionMapper.insert(atHoldFunction);
				if(insertResult <= 0){//插入失败
					result = 1;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 根据用户或用户组以及菜单树ID删除系统功能操作权限
	 * @param actorId 用户或用户组ID
	 * @param treeId 菜单树ID
	 */
	@Override
	public int delHoldFunctionByActorIdAndTreeId(int actorId,int treeId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("actorId", actorId);
		map.put("treeId", treeId);
		return atHoldFunctionMapper.delHoldFunctionByActorIdAndTreeId(map)>0?0:1;
	}

	/**
	 * 查询详细信息
	 * @param id 系统功能操作权限ID
	 */
	@Override
	public AtHoldFunction queryDetailInfo(int id) throws Exception {
		return atHoldFunctionMapper.findById(id);
	}

	/**
	 * 分页查询
	 * @param atHoldFunction 筛选条件对象
	 * @param page 分页对象
	 */
	@Override
	public List<AtHoldFunction> queryListByPage(AtHoldFunction atHoldFunction, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atHoldFunction.getMenuCode())){
			map.put("menuCode", atHoldFunction.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atHoldFunction.getFunName())){
			map.put("funName", atHoldFunction.getFunName());
		}
		if(atHoldFunction.getFunId() > 0){
			map.put("funId", atHoldFunction.getFunId());
		}
		if(atHoldFunction.getActorId() > 0){
			map.put("actorId", atHoldFunction.getActorId());
		}
		if(!StringUtil.isEmtryStr(atHoldFunction.getOperator())){
			map.put("operator", atHoldFunction.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atHoldFunction.getRemark())){
			map.put("remark", atHoldFunction.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atHoldFunctionMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atHoldFunctionMapper.findByPage(map);
	}

	/**
	 * 根据menuCode查询系统功能操作权限
	 * @param menuCode
	 */
	@Override
	public List<AtHoldFunction> findHoldFunctionByMenuCode(String menuCode) throws Exception {
		return atHoldFunctionMapper.findHoldFunctionByMenuCode(menuCode);
	}

	/**
	 * 根据funId查询系统功能操作权限
	 * @param id
	 * @return
	 */
	@Override
	public List<AtHoldFunction> findHoldFunctionByFunId(int funId) throws Exception {
		return atHoldFunctionMapper.findHoldFunctionByFunId(funId);
	}

	/**
	 * 根据用户或者用户组ID查询功能详细操作字典
	 * @return
	 */
	@Override
	public List<AtModelFunction> findModelFunctionByActorId(int actorId) throws Exception {
		return atHoldFunctionMapper.findModelFunctionByActorId(actorId);
	}

	/**
	 * 根据用户或者用户组ID查询菜单附属功能字典
	 * @return
	 */
	@Override
	public List<AtSysModel> findAtSysModelByActorId(int actorId) throws Exception {
		return atHoldFunctionMapper.findAtSysModelByActorId(actorId);
	}

	/**
	 * 根据用户或者用户组ID查询菜单树字典
	 * @return
	 */
	public List<AtSysMenu> findAtSysMenuByActorId(int actorId) throws Exception {
		return atHoldFunctionMapper.findAtSysMenuByActorId(actorId);
	}

	/**
	 * 根据actorId和菜单树ID查询功能详细操作字典
	 * @param actorId
	 * @param treeId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getModelFunctionByActorIdAndTreeId(int actorId, int treeId) throws Exception {
		//参数
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("actorId", actorId);
		map.put("treeId", treeId);
		return atHoldFunctionMapper.getModelFunctionByActorIdAndTreeId(map);
	}

	/**
	 * 根据功能详细操作字典IDS删除字体功能操作权限
	 * @param funIds
	 * @return
	 */
	@Override
	public int delHoldFunctionByFunIdsAndActorId(String[] funIds,int actorId) throws Exception {
		//根据ID查询属于哪一个菜单树
		Map<String,Object> map = new HashMap<String,Object>();
		int result = 0;
		List<AtSysModel> treeIdList = atHoldFunctionMapper.getTreeIdByFunIdArray(funIds);
		for(int i=0;i<treeIdList.size();i++){//将该用户或用户组在每一个菜单树下的功能权限删除
			map.put("actorId", actorId);
			map.put("treeId", treeIdList.get(i).getTreeId());
			result = atHoldFunctionMapper.delHoldFunctionByActorIdAndTreeId(map);
		}
		return result;
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<AtHoldFunction> findAll() {
		return atHoldFunctionMapper.findAll();
	}

	/**
	 * 根据用户或用户组ID查询功能操作权限
	 * @param actorId
	 * @return
	 */
	@Override
	public List<AtHoldFunction> getHoldFunctionListByActorId(int actorId) {
		return atHoldFunctionMapper.getHoldFunctionListByActorId(actorId);
	}

}
