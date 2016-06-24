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

import com.rrtimes.acm.domain.AtSysMenu;

/**
 * @Title:       AcmSysMenuMapper.java
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
public interface AtSysMenuMapper {
	
    public int insert(AtSysMenu asm);
     
    public int update(AtSysMenu asm);
    
    public int delete(int id);
    
    public AtSysMenu findById(int id);
    
    public List<AtSysMenu> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    

	public List<AtSysMenu> findByUserId(Map<String, Object> map);
	
	public List<AtSysMenu> findAll();
}
