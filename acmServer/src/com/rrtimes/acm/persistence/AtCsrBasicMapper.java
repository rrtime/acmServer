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

import com.rrtimes.acm.domain.AtCsrBasic;


/**
 * @Title:       AtCsrBasicMapper.java
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
public interface AtCsrBasicMapper {

	public int insert(AtCsrBasic acb);
    
    public int update(AtCsrBasic acb);
    
    public int delete(int id);
    
    public AtCsrBasic findById(int id);
    
    public List<AtCsrBasic> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    
    public List<AtCsrBasic> findByUser(String userAccount);
    
    public List<AtCsrBasic> findByAgent(String agentCode);
    
    public List<AtCsrBasic> findByOrg(int id);
    
    public AtCsrBasic findAllById(int id);
    
    public List<AtCsrBasic> findByUserId(int userId);
    
    public int findCountByUserId(int userId);
}
