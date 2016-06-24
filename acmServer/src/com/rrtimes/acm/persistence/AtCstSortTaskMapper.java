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

import com.rrtimes.acm.domain.AtCstSortTask;

/**
 * @Title:       AtCstSortTaskMapper.java
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
public interface AtCstSortTaskMapper {

	public int insert(AtCstSortTask ast);
	
	public int update(AtCstSortTask ast);
	
	public int delete(int id);
	
	public AtCstSortTask findById(int id);
	
	public int findByCount(Map<String,Object> map);
	
	public List<AtCstSortTask> findByPage(Map<String,Object> map);
}
