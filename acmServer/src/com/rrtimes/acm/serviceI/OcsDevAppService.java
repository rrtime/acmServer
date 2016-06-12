/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;

import com.rrtimes.acm.domain.DevApp;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       OcsDevAppService.java
 * @Package:     com.tstar.charge.service
 * @Description: 开发者应用管理接口类
 * 
 * <p>
 * 	开发者应用管理接口定义
 * </p> 
 * 
 * @author liht
 * 
 */
public interface OcsDevAppService {
	
	/**
	 * 应用详情查询
	 * */
	public DevApp queryAppDetail(int id);
	
	/**
	 * 开发者列表查询
	 * */
	public List<DevApp> queryApp(DevApp devApp, PageObject page);
	
}
