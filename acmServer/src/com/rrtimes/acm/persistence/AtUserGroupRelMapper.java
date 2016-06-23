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

import com.rrtimes.acm.domain.AtUserGroupRel;

/**
 * @Title:       AtUserGroupRelMapper.java
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
public interface AtUserGroupRelMapper {
    
	public int insert(AtUserGroupRel asu);
    
    public int update(AtUserGroupRel asu);
    
    public int updateByUid(AtUserGroupRel asu);
    
    public int delete(int userId);
    
    public AtUserGroupRel findById(int id);
    
    public List<AtUserGroupRel> findByPage(Map<String,Object> map);
    
    public int findByCount(Map<String,Object> map);
    
    public  List<AtUserGroupRel> findByMap(Map<String,Object> map);
    
    public AtUserGroupRel findByUserId(Map<String,Object> map);
    
    public void delByRoleId(int gid);
    
    public int delByUId(int uid);
    
    public List<AtUserGroupRel> findlistByUserId(Map<String,Object> map);

}
