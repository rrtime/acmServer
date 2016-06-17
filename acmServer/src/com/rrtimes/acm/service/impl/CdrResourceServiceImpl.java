/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.CdrResource;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.CdrResourceMapper;
import com.rrtimes.acm.serviceI.CdrResourceService;

/**
 * @Title:       CdrResourceServiceImpl.java
 * @Package:     com.tstar.charge.service.impl
 * @Description: 分拣源管理服务接口实现类
 * 
 * <p>
 * 	分拣源管理服务接口实现
 * </p> 
 * 
 * @author liht
 * 
 */
@Service
public class CdrResourceServiceImpl implements CdrResourceService {
	
	@Resource
	private CdrResourceMapper cdrResourceMapper;
	
	private Map<String, Object> map;

	@Override
	public int delete(int id) {
		return cdrResourceMapper.delete(id);
	}

	@Override
	public int insert(CdrResource cdrResource) {
		return cdrResourceMapper.insert(cdrResource);
	}

	@Override
	public List<CdrResource> queryAll(CdrResource cdrResource, PageObject page) {
		map = new HashMap<String, Object>();
		// 数据总量查询
		page.setSumCloum(cdrResourceMapper.findByCount(map));
		// 分页
		map.put("page", page);
		return cdrResourceMapper.findByPage(map);
	}

	@Override
	public CdrResource queryDetail(int id) {
		return cdrResourceMapper.findById(id);
	}

	@Override
	public int update(CdrResource cdrResource) {
		return cdrResourceMapper.update(cdrResource);
	}

	@Override
	public int updateFlag(int id, int flag) {
		return cdrResourceMapper.updateStatus(id, flag);
	}

}
