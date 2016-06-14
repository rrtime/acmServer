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

import com.rrtimes.acm.domain.AtUser;

/**
 * @Title:       AcmSysUser.java
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
public interface AtUserMapper {

	public int insert(AtUser asu);
    
    public int update(AtUser asu);
    
    public int delete(int id);
    
    public AtUser findById(int id);
    
    public List<AtUser> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    
    public List<AtUser> findByMap(Map<String,Object> map);
    
    public AtUser findByINameToinsert(String iName);
    
    public AtUser findCountByINameToupdate(String iName);
    
    public AtUser findByINameToupdate(String iName);
    
    public AtUser findByUser(Map<String,Object> map);
    
    public List<AtUser> findByCpCode(Map<String,Object> map);
    
    public int findCountByCpCode(Map<String,Object> map);
    
    public List<AtUser> findByOrgId(Map<String,Object> map);
    
    public int findCountByOrgId(Map<String,Object> map);
    
    public List<AtUser> findjsBycpCode(Map<String,Object> map);
}
