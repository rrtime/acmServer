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

import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtFieldDictMapper;
import com.rrtimes.acm.serviceI.AtFieldDictService;
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
	
	/**
	 * 新增系统权限字段字典
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int addAtFieldDict(AtFieldDict atFieldDict) throws Exception {
		return atFieldDictMapper.insert(atFieldDict)>0?0:1;
	}

	/**
	 * 修改系统权限字段字典
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int modAtFieldDict(AtFieldDict atFieldDict) throws Exception {
		atFieldDict.setUpdateTime(new Date());
		return atFieldDictMapper.update(atFieldDict)>0?0:1;
	}

	/**
	 * 删除系统权限字段字典
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int delAtFieldDict(int id) throws Exception {
		return atFieldDictMapper.delete(id)>0?0:1;
	}

	/**
	 * 查询系系统权限字段字典详情
	 * @throws Exception 
	 * 
	 * */
	@Override
	public AtFieldDict queryDetailInfo(int id) throws Exception {
		return atFieldDictMapper.findById(id);
	}

	/**
	 * 查询系统权限字段字典列表(分页)
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtFieldDict> queryListByPage(AtFieldDict atFieldDict, PageObject page) throws Exception {
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

	/**
	 * 根据菜单树ID查询系统权限字段字典
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Map<String, Object>> findAtFieldDictByTreeId(int treeId) throws Exception {
		return atFieldDictMapper.findAtFieldDictByTreeId(treeId);
	}

	/**
	 * 查询所有数据
	 * @return
	 */
	@Override
	public List<AtFieldDict> findAll() throws Exception {
		return atFieldDictMapper.findAll();
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int batchDeleteAtFieldDict(int[] ids) throws Exception {
		return atFieldDictMapper.batchDeleteAtFieldDict(ids)>0?0:1;
	}


}
