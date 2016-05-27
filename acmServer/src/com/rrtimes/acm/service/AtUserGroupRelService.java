/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtUserGroupRel;

/**
 * @Title:       AtUserGroupRel.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public interface AtUserGroupRelService {

	public int insert(AtUserGroupRel augr);
	
	public int update(AtUserGroupRel augr);
	
	public int delete(int userId);
	
	public List<AtUserGroupRel> queryByMap(Map<String,Object> map);
	
}
