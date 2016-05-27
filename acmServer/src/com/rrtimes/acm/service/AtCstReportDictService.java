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

import com.rrtimes.acm.domain.AtCstReportDict;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtCstReportDictService.java
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
public interface AtCstReportDictService {

	public int insert(AtCstReportDict acrd);
	
	public int update(AtCstReportDict acrd);
	
	public int delete(int id);
	
	public AtCstReportDict queryById(int id);
	
	public List<AtCstReportDict> queryByMap(AtCstReportDict acrd,PageObject page);
}
