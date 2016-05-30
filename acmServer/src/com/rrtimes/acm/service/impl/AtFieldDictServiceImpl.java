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

import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtFieldDictMapper;
import com.rrtimes.acm.service.AtFieldDictService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtFieldDictServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 系统权限字段字典 Service 接口实现类
 * 
 * <p>
 * 	系统权限字段字典 Service 接口实现类
 * </p> 
 * 
 * @author yanxbAtFieldDict
 * 
 */
public class AtFieldDictServiceImpl implements AtFieldDictService {

	@Resource
	private AtFieldDictMapper atFieldDictMapper;
	
	@Override
	public int addAtFieldDict(AtFieldDict atFieldDict) {
		return atFieldDictMapper.insert(atFieldDict)>0?0:1;
	}

	@Override
	public int modAtFieldDict(AtFieldDict atFieldDict) {
		return atFieldDictMapper.update(atFieldDict)>0?0:1;
	}

	@Override
	public int delAtFieldDict(int id) {
		return atFieldDictMapper.delete(id)>0?0:1;
	}

	@Override
	public AtFieldDict queryDetailInfo(int id) {
		return atFieldDictMapper.findById(id);
	}

	@Override
	public List<AtFieldDict> queryListByPage(AtFieldDict atFieldDict, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atFieldDict.getMenuCode())){
			map.put("menuCode", atFieldDict.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atFieldDict.getFname())){
			map.put("fname", atFieldDict.getFname());
		}
		if(!StringUtil.isEmtryStr(atFieldDict.getFtitle())){
			map.put("ftitle", atFieldDict.getFtitle());
		}
		if(!StringUtil.isEmtryStr(atFieldDict.getRemark())){
			map.put("remark", atFieldDict.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atFieldDictMapper.findByCount(map));
		map.put("page", page);
		// 分页查询结果
		return atFieldDictMapper.findByPage(map);
	}

	@Override
	public List<Map<String, Object>> findAtFieldDictByTreeId(int treeId) {
		return atFieldDictMapper.findAtFieldDictByTreeId(treeId);
	}


}
