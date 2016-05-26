/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

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
import com.rrtimes.acm.service.AtSysModelService;
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
	
	@Override
	public int addAtSysModel(AtSysModel atSysModel) {
		return atSysModelMapper.insert(atSysModel)>0?0:1;
	}

	@Override
	public int modAtSysModel(AtSysModel atSysModel) {
		return atSysModelMapper.update(atSysModel);
	}

	@Override
	public int delAtSysModel(AtSysModel atSysModel) {
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

	@Override
	public AtSysModel queryDetailInfo(int id) {
		return atSysModelMapper.findById(id);
	}

	@Override
	public List<AtSysModel> queryListByPage(AtSysModel atSysModel, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(atSysModel.getTreeId() >= 0){
			map.put("treeId", atSysModel.getTreeId());
		}
		if(!StringUtil.isEmtryStr(atSysModel.getMenuCode())){
			map.put("menuCode", atSysModel.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atSysModel.getMname())){
			map.put("mname", "%" + atSysModel.getMname() + "%");
		}
		if(atSysModel.getIsConShownum() >= 0){
			map.put("isConShownum", atSysModel.getIsConShownum());
		}
		if(!StringUtil.isEmtryStr(atSysModel.getRemark())){
			map.put("remark", "%" + atSysModel.getRemark() + "%");
		}
		// 数据总量查询
		page.setSumCloum(atSysModelMapper.findByCount(map));
		map.put("page", page);
		return atSysModelMapper.findByPage(map);
	}

	@Override
	public List<AtSysModel> getAtSysModelByTreeId(int treeId){
		return atSysModelMapper.getAtSysModelByTreeId(treeId);
	}

}
