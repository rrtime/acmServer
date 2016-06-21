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
	 * 系统功能操作权限修改
	 * @param funIds 功能字典ID数组
	 * @param actorId 所要授权的用户或用户组
	 * @param operator 操作员ID
	 */
	@Override
	public int modAtHoldFunction(String[] funIds,int actorId,int operator) throws Exception {
		int result = 0;
		//首先删除该用户或者组已有功能操作权限
		this.delAllByActorId(actorId);
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
	 * 根据用户或用户组ID查询功能操作权限
	 * @param actorId
	 * @return
	 */
	@Override
	public List<AtHoldFunction> getHoldFunctionListByActorId(int actorId) throws Exception {
		return atHoldFunctionMapper.getHoldFunctionListByActorId(actorId);
	}
	
	/**
	 * 根据角色ID删除功能操作权限
	 * @param funIds
	 * @return
	 */
	public int delAllByActorId(int actorId) throws Exception {
		return atHoldFunctionMapper.delAllByActorId(actorId);
	} 

}
