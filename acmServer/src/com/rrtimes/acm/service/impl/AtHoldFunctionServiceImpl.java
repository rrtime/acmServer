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
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtHoldFunctionMapper;
import com.rrtimes.acm.service.AtHoldFunctionService;
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
	
	@Override
	public int addAtHoldFunction(String idInfos,AtUser atUser,String operator) {
		int result = 0;
		try{
			if(!StringUtil.isEmtryStr(idInfos)){
				String[] infos = idInfos.split(",");
				for(int i=0;i<infos.length;i++){
					AtHoldFunction atHoldFunction = new AtHoldFunction();
					atHoldFunction.setMenuCode(infos[i].split(":")[0]);
					atHoldFunction.setFunName(infos[i].split(":")[1]);
					atHoldFunction.setFunId(Integer.valueOf(infos[i].split(":")[2]));
					atHoldFunction.setActorId(atUser.getId());
					atHoldFunction.setOperator(operator);
					atHoldFunction.setRemark("");
					int insertResult = atHoldFunctionMapper.insert(atHoldFunction);
					if(insertResult <= 0){//插入失败
						result = 1;
						break;
					}
				}
			}
		}catch(Exception e){
			result = 1;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int modAtHoldFunction(String idInfos,AtUser atUser,int treeId,String operator) {
		int result = 0;
		try{
			//首先查询该用户或者组是否已有功能操作权限
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("actorId", atUser.getId());
			map.put("treeId", treeId);
			List<Map<String, Object>> holdFunctionList = atHoldFunctionMapper.getModelFunctionByActorIdAndTreeId(map);
			//如果有，则先删除
			if(StringUtil.isListNotNull(holdFunctionList)){
				atHoldFunctionMapper.delHoldFunctionByActorIdAndTreeId(map);
			}
			//再重新插入
			if(!StringUtil.isEmtryStr(idInfos)){
				String[] infos = idInfos.split(",");
				for(int i=0;i<infos.length;i++){
					AtHoldFunction atHoldFunction = new AtHoldFunction();
					atHoldFunction.setMenuCode(infos[i].split(":")[0]);
					atHoldFunction.setFunName(infos[i].split(":")[1]);
					atHoldFunction.setFunId(Integer.valueOf(infos[i].split(":")[2]));
					atHoldFunction.setActorId(atUser.getId());
					atHoldFunction.setOperator(operator);
					atHoldFunction.setUpdateTime(new Date());
					atHoldFunction.setRemark("");
					int insertResult = atHoldFunctionMapper.insert(atHoldFunction);
					if(insertResult <= 0){//插入失败
						result = 1;
						break;
					}
				}
			}
		}catch(Exception e){
			result = 1;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delHoldFunctionByActorIdAndTreeId(int actorId,int treeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("actorId", actorId);
		map.put("treeId", treeId);
		return atHoldFunctionMapper.delHoldFunctionByActorIdAndTreeId(map)>0?0:1;
	}

	@Override
	public AtHoldFunction queryDetailInfo(int id) {
		return atHoldFunctionMapper.findById(id);
	}

	@Override
	public List<AtHoldFunction> queryListByPage(AtHoldFunction atHoldFunction, PageObject page) {
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

	@Override
	public List<AtHoldFunction> findHoldFunctionByMenuCode(String menuCode) {
		return atHoldFunctionMapper.findHoldFunctionByMenuCode(menuCode);
	}

	@Override
	public List<AtHoldFunction> findHoldFunctionByFunId(int funId) {
		return atHoldFunctionMapper.findHoldFunctionByFunId(funId);
	}

	@Override
	public List<AtModelFunction> findModelFunctionByActorId(int actorId) {
		return atHoldFunctionMapper.findModelFunctionByActorId(actorId);
	}

	@Override
	public List<AtSysModel> findAtSysModelByActorId(int actorId) {
		return atHoldFunctionMapper.findAtSysModelByActorId(actorId);
	}

	public List<AtSysMenu> findAtSysMenuByActorId(int actorId){
		return atHoldFunctionMapper.findAtSysMenuByActorId(actorId);
	}

	@Override
	public List<Map<String, Object>> getModelFunctionByActorIdAndTreeId(int actorId, int treeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("actorId", actorId);
		map.put("treeId", treeId);
		return atHoldFunctionMapper.getModelFunctionByActorIdAndTreeId(map);
	}

}
