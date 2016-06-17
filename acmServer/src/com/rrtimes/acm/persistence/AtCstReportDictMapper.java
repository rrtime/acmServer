/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.persistence;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtCstReportDict;


/**
 * @Title:       AtCstReportDictMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public interface AtCstReportDictMapper {

	public int insert(AtCstReportDict acrd);
    
    public int update(AtCstReportDict acrd);
    
    public int delete(int id);
    
    public AtCstReportDict findById(int id);
    
    public List<AtCstReportDict> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
}
