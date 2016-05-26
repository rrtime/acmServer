/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.AtCstReportDict;
import com.rrtimes.acm.persistence.AtCstReportDictMapper;
import com.rrtimes.acm.service.AtCstReportDictService;

/**
 * @Title:       AtCstReportDictServiceImpl.java
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
@Service
public class AtCstReportDictServiceImpl implements AtCstReportDictService{

	@Resource AtCstReportDictMapper acrdm;
	
	@Override
	public int insert(AtCstReportDict acrd) {
		// TODO Auto-generated method stub
		return acrdm.insert(acrd);
	}

	@Override
	public int update(AtCstReportDict acrd) {
		// TODO Auto-generated method stub
		return acrdm.update(acrd);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return acrdm.delete(id)>0?0:1;
	}

	@Override
	public AtCstReportDict queryById(int id) {
		// TODO Auto-generated method stub
		return acrdm.findById(id);
	}

	@Override
	public List<AtCstReportDict> queryByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return acrdm.findByPage(map);
	}

}
