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

import com.rrtimes.acm.domain.AtCstFt;


/**
 * @Title:       AtCstFtMapper.java
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
public interface AtCstFtMapper {

	public int insert(AtCstFt acf);
    
    public int update(AtCstFt acf);
    
    public int delete(int id);
    
    public AtCstFt findById(int id);
    
    public List<AtCstFt> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    
    public AtCstFt findByCsrIdentifer(String csrIdentifer);
    

	public List<AtCstFt> findByUserId(Map<String, Object> map);
}
