/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtHoldFunctionService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 系统功能操作权限 Service 接口类
 * 
 * <p>
 * 	系统功能操作权限 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtHoldFunctionService {
	
	/**
	 * 修改系统功能操作权限
	 * 
	 * */
	public int modAtHoldFunction(String[] funIds,int actorId,int operator) throws Exception;

	/**
	 * 根据用户或用户组ID查询功能操作权限
	 * @param actorId
	 * @return
	 */
	public List<AtHoldFunction> getHoldFunctionListByActorId(int actorId) throws Exception;
	
}
