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

import com.rrtimes.acm.domain.AcmSysOrg;

/**
 * @Title:       AcmSysOrgMapper.java
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
public interface AcmSysOrgMapper {
	
    public int insert(AcmSysOrg aso);
    
    public int update(AcmSysOrg aso);
    
    public int delete(int id);
    
    public AcmSysOrg findById(int id);
    
    public List<AcmSysOrg> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    
    public List<AcmSysOrg> findOrgByOid(int oid);
    
    public List<AcmSysOrg> findAll(String cpCode);
}
