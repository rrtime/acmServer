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

import com.rrtimes.acm.domain.AtCstContract;


/**
 * @Title:       AtCstContractMapper.java
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
public interface AtCstContractMapper {

	public int insert(AtCstContract acc);
    
    public int update(AtCstContract acc);
    
    public int delete(int id);
    
    public AtCstContract findById(int id);
    
    public List<AtCstContract> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    
    public List<AtCstContract> findByUserIdAndDay(Map<String,Object> map);
    
    
    public List<AtCstContract> findPaydayByUserId(Map<String,Object> map);
    
    public Map<String,Object> findByContractIdAndDaybefore(Map<String,Object> map);
    
    public Map<String,Object> findByContractIdAndDayaffer(Map<String,Object> map);
    
    public List<AtCstContract> findByCsrIdentifer(Map<String,Object> map);
    
    public List<AtCstContract> findQFByUserId(Map<String,Object> map);

	public List<AtCstContract> findByUserId(Map<String, Object> map);

	public List<AtCstContract> findByCsrIdentiferAndCurdate(Map<String, Object> paramap);
	
}
