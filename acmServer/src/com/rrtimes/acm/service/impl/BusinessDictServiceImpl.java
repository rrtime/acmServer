/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.BusinessDict;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.BusinessDictMapper;
import com.rrtimes.acm.serviceI.BusinessDictService;

/**
 * @Title:       BusinessDictServiceImpl.java
 * @Package:     com.tstar.charge.service.impl
 * @Description: 费率业务字典接口实现类
 * 
 * <p>
 * 	费率业务字典接口实现
 * </p> 
 * 
 * @author liht
 * 
 */
@Service
public class BusinessDictServiceImpl implements BusinessDictService {
	
	@Resource
	private BusinessDictMapper businessDictMapper;


	@Override
	public int insert(BusinessDict businessDict) {
		return businessDictMapper.insert(businessDict)>0?0:1;
	}

	@Override
	public List<BusinessDict> queryByPage(BusinessDict businessDict,
			PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 数据总量查询
		page.setSumCloum(businessDictMapper.findByCount(map));
		map.put("page", page);
		return businessDictMapper.findByPage(map);
	}

	@Override
	public BusinessDict queryDetail(int id) {
		return businessDictMapper.findById(id);
	}

	@Override
	public int update(BusinessDict businessDict) {
		businessDict.setUpdateTime(new Date());
		return businessDictMapper.update(businessDict);
	}

	@Override
	public int delete(int id) {
		// 成功返回 0
		return businessDictMapper.delete(id)>0?0:1;
	}

}
