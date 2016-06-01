/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.AtCompanyAgent;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCompanyAgentMapper;
import com.rrtimes.acm.service.AtCompanyAgentService;

/**
 * @Title:       AtCompanyAgentServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public class AtCompanyAgentServiceImpl implements AtCompanyAgentService{
    
	@Resource
	private AtCompanyAgentMapper acam;
	
	@Override
	public int insert(AtCompanyAgent aca) {
		// TODO Auto-generated method stub
		return acam.insert(aca)>0?0:1;
	}

	@Override
	public int update(AtCompanyAgent aca) {
		// TODO Auto-generated method stub
		return acam.update(aca)>0?0:1;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return acam.delete(id)>0?0:1;
	}

	@Override
	public List<AtCompanyAgent> queryByPage(AtCompanyAgent aca,PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		page.setSumCloum(acam.findByCount(map));
		map.put("page", page);
		return acam.findByPage(map);
	}

	@Override
	public AtCompanyAgent queryById(int id) {
		// TODO Auto-generated method stub
		return acam.findById(id);
	}

}
