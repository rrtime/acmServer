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
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtHoldFunctionMapper;
import com.rrtimes.acm.persistence.AtModelFunctionMapper;
import com.rrtimes.acm.persistence.AtSysModelMapper;
import com.rrtimes.acm.serviceI.AtSysModelService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtSysModelServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 菜单附属功能字典 Service 接口实现类
 * 
 * <p>
 * 	菜单附属功能字典 Service 接口实现类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtSysModelServiceImpl implements AtSysModelService {

	@Resource
	private AtSysModelMapper atSysModelMapper;
	@Resource
	private AtModelFunctionMapper atModelFunctionMapper;
	@Resource
	private AtHoldFunctionMapper atHoldFunctionMapper;
	
	/**
	 * 新增菜单附属功能字典
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int addAtSysModel(AtSysModel atSysModel) throws Exception {
		return atSysModelMapper.insert(atSysModel)>0?0:1;
	}

	/**
	 * 修改菜单附属功能字典
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int modAtSysModel(AtSysModel atSysModel) throws Exception {
		atSysModel.setUpdateTime(new Date());
		return atSysModelMapper.update(atSysModel)>0?0:1;
	}

	/**
	 * 删除菜单附属功能字典
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int delAtSysModel(AtSysModel atSysModel) throws Exception {
		//首先需要查询功能详细操作表和系统功能操作权限表是否有引用到该附属功能，如果有，则提示
		if(atSysModel != null){
			List<AtModelFunction> atModelFunctionList = atModelFunctionMapper.findModelFunctionByMenuCode(atSysModel.getMenuCode());
			//如果功能详细操作表有引用该附属功能，则返回失败
			if(atModelFunctionList != null && atModelFunctionList.size() > 0){
				return 1;
			}
			List<AtHoldFunction> atHoldFunctionList = atHoldFunctionMapper.findHoldFunctionByMenuCode(atSysModel.getMenuCode());
			//如果系统功能操作权限表有引用该附属功能，则返回失败
			if(atHoldFunctionList != null && atHoldFunctionList.size() > 0){
				return 1;
			}
		}
		return atSysModelMapper.delete(atSysModel.getId())>0?0:1;
	}

	/**
	 * 查询菜单附属功能字典详情
	 * @throws Exception 
	 * 
	 * */
	@Override
	public AtSysModel queryDetailInfo(int id) throws Exception {
		return atSysModelMapper.findById(id);
	}

	/**
	 * 查询菜单附属功能字典列表(分页)
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtSysModel> queryListByPage(AtSysModel atSysModel, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(atSysModel.getTreeId() > 0){
			map.put("treeId", atSysModel.getTreeId());
		}
		if(!StringUtil.isEmtryStr(atSysModel.getMenuCode())){
			map.put("menuCode", atSysModel.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atSysModel.getMname())){
			map.put("mname", atSysModel.getMname());
		}
		if(atSysModel.getIsConShownum() > 0){
			map.put("isConShownum", atSysModel.getIsConShownum());
		}
		if(!StringUtil.isEmtryStr(atSysModel.getRemark())){
			map.put("remark", atSysModel.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atSysModelMapper.findByCount(map));
		map.put("page", page);
		return atSysModelMapper.findByPage(map);
	}

	/**
	 * 根据菜单树ID查询菜单附属功能
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<AtSysModel> getAtSysModelByTreeId(int treeId) throws Exception {
		return atSysModelMapper.getAtSysModelByTreeId(treeId);
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	@Override
	public List<AtSysModel> findAll() throws Exception {
		return atSysModelMapper.findAll();
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int batchDeleteAtSysModel(int[] ids) throws Exception {
		return atSysModelMapper.batchDeleteAtSysModel(ids)>0?0:1;
	}

}
