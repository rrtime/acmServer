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

import com.rrtimes.acm.domain.AtSysNotice;

/**
 * @Title:       AtSysNoticeMapper.java
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
public interface AtSysNoticeMapper {

	public int insert(AtSysNotice asn);
	
	public int update(AtSysNotice asn);
	
	public int delete(int id);
	
	public AtSysNotice findById(int id);
	
	public int findCountByMap(Map<String,Object> map);
	
	public List<AtSysNotice> findByPage(Map<String,Object> map);
	
	
	public List<AtSysNotice> findCGnoticeByUserId(Map<String,Object> map);
	
	public List<AtSysNotice> findTnoticeByUserId(Map<String,Object> map);
	
	public List<AtSysNotice> findCTnoticeByUserId(Map<String,Object> map);
	
	public List<AtSysNotice> findNoticeByGUserId(Map<String,Object> map);
	
	public List<AtSysNotice> findNoticeByTUserId(Map<String,Object> map);

	public List<AtSysNotice> findGnoticeByUserId(Map<String, Object> map);
}
