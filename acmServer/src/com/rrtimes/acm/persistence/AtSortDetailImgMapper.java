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

import com.rrtimes.acm.domain.AtSortDetailImg;

/**
 * @Title:       AtSortDetailImgMapper.java
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
public interface AtSortDetailImgMapper {

	public int insert(AtSortDetailImg asdi);
	
	public int update(AtSortDetailImg asdi);
	
	public int delete(int id);
	
	public AtSortDetailImg findById(int id);
	
	public int findByCount(Map<String,Object> map);
	
	public List<AtSortDetailImg> findByPage(Map<String,Object> map);
}
