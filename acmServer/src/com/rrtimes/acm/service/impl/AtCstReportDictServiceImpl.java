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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.AtCstReportDict;
import com.rrtimes.acm.domain.PageObject;
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
public class AtCstReportDictServiceImpl implements AtCstReportDictService{

	@Resource AtCstReportDictMapper acrdm;
	
	@Override
	public int insert(AtCstReportDict acrd) {
		// TODO Auto-generated method stub
		return acrdm.insert(acrd)>0?0:1;
	}

	@Override
	public int update(AtCstReportDict acrd) {
		// TODO Auto-generated method stub
		return acrdm.update(acrd)>0?0:1;
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
	public List<AtCstReportDict> queryByMap(AtCstReportDict acrd,PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(acrd.getReportName())){
			map.put("reportName", acrd.getReportName());
		}
		if(!StringUtils.isEmpty(acrd.getReportDesc())){
			map.put("reportDesc", acrd.getReportDesc());
		}
		if(!StringUtils.isEmpty(acrd.getOperator())){
			map.put("operator", acrd.getOperator());
		}
		if(!StringUtils.isEmpty(acrd.getRemark())){
			map.put("remark", acrd.getRemark());
		}
		page.setSumCloum(acrdm.findByCount(map));
		map.put("page", page);
		return acrdm.findByPage(map);
	}

}
