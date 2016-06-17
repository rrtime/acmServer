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

import com.rrtimes.acm.domain.DevApp;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.DevAppMapper;
import com.rrtimes.acm.serviceI.OcsDevAppService;

/**
 * @Title:       OcsDevAppServiceImpl.java
 * @Package:     com.tstar.charge.service.impl
 * @Description: 开发者应用服务接口实现类
 * 
 * <p>
 * 	开发者应用服务接口实现
 * </p> 
 * 
 * @author liht
 * 
 */
@Service
public class OcsDevAppServiceImpl implements OcsDevAppService {
	
	@Resource
	private DevAppMapper devAppMapper;
	
	private Map<String, Object> map;

	@Override
	public List<DevApp> queryApp(DevApp devApp, PageObject page) {
		map = new HashMap<String, Object>();
		if( devApp.getAppName()!=null && !"".equals(devApp.getAppName()) )
			map.put("appName", devApp.getAppName());
		if( devApp.getAppType() >= 0 )
			map.put("appType", devApp.getAppType());
		if( devApp.getAppStatus() >= 0 )
			map.put("appStatus", devApp.getAppStatus());
		// 数据总量查询
		page.setSumCloum(devAppMapper.findByCount(map));
		// 分页
		map.put("page", page);
		return devAppMapper.findByPage(map);
	}

	@Override
	public DevApp queryAppDetail(int id) {
		return devAppMapper.findById(id);
	}

}
