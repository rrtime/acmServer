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

import com.rrtimes.acm.domain.AtCompanyAgent;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtCompanyAgentService.java
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
public interface AtCompanyAgentService {

	public int insert(AtCompanyAgent aca);
	
	public int update(AtCompanyAgent aca);
	
	public int delete(int id);
	
	public List<AtCompanyAgent> queryByPage(AtCompanyAgent aca,PageObject page);
	
	public AtCompanyAgent queryById(int id);
}
