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
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtHoldFunctionMapper;
import com.rrtimes.acm.persistence.AtModelFunctionMapper;
import com.rrtimes.acm.service.AtModelFunctionService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtModelFunctionServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 功能详细操作字典 Service 接口实现类
 * 
 * <p>
 * 	功能详细操作字典 Service 接口实现类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtModelFunctionServiceImpl implements AtModelFunctionService {

	@Resource
	private AtModelFunctionMapper atModelFunctionMapper;
	
	@Resource
	private AtHoldFunctionMapper atHoldFunctionMapper;
	
	@Override
	public int addAtModelFunction(AtModelFunction atModelFunction) {
		return atModelFunctionMapper.insert(atModelFunction)>0?0:1;
	}

	@Override
	public int modAtModelFunction(AtModelFunction atModelFunction) {
		atModelFunction.setUpdateTime(new Date());
		return atModelFunctionMapper.update(atModelFunction)>0?0:1;
	}

	@Override
	public int delAtModelFunction(AtModelFunction atModelFunction) {
		//首先需要查询功能详细操作表和系统功能操作权限表是否有引用到该附属功能，如果有，返回1
		List<AtHoldFunction> atHoldFunctionList = atHoldFunctionMapper.findHoldFunctionByFunId(atModelFunction.getId());
		if(atHoldFunctionList != null && atHoldFunctionList.size() > 0){
			return 1;
		}
		return atModelFunctionMapper.delete(atModelFunction.getId())>0?0:1;
	}

	@Override
	public AtModelFunction queryDetailInfo(int id) {
		return atModelFunctionMapper.findById(id);
	}

	@Override
	public List<AtModelFunction> queryListByPage(AtModelFunction atModelFunction, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atModelFunction.getMenuCode())){
			map.put("menuCode", atModelFunction.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atModelFunction.getFname())){
			map.put("fname", atModelFunction.getFname());
		}
		if(atModelFunction.getControlType() > 0){
			map.put("controlType", atModelFunction.getControlType());
		}
		if(atModelFunction.getIsHastag() > 0){
			map.put("isHastag", atModelFunction.getIsHastag());
		}
		if(atModelFunction.getIsConShownum() > 0){
			map.put("isConShownum", atModelFunction.getIsConShownum());
		}
		if(!StringUtil.isEmtryStr(atModelFunction.getOperator())){
			map.put("operator", atModelFunction.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atModelFunction.getRemark())){
			map.put("remark", atModelFunction.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atModelFunctionMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atModelFunctionMapper.findByPage(map);
	}

	@Override
	public List<AtModelFunction> findModelFunctionByMenuCode(String menuCode){
		return atModelFunctionMapper.findModelFunctionByMenuCode(menuCode);
	}

	@Override
	public List<Map<String,Object>> findModelFunctionByTreeId(int treeId) {
		return atModelFunctionMapper.findModelFunctionByTreeId(treeId);
	}
}
