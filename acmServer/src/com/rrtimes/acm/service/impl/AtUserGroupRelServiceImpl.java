/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.AtUserGroupRel;
import com.rrtimes.acm.persistence.AtUserGroupRelMapper;
import com.rrtimes.acm.serviceI.AtUserGroupRelService;

/**
 * @Title:       AtUserGroupRelServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public class AtUserGroupRelServiceImpl implements AtUserGroupRelService{

	@Resource AtUserGroupRelMapper augrm;
	
	@Override
	public int insert(AtUserGroupRel augr) {
		// TODO Auto-generated method stub
		return augrm.insert(augr);
	}

	@Override
	public int update(AtUserGroupRel augr) {
		// TODO Auto-generated method stub
		return augrm.update(augr);
	}

	@Override
	public int delete(int userId) {
		// TODO Auto-generated method stub
		return augrm.delete(userId);
	}

	@Override
	public List<AtUserGroupRel> queryByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return augrm.findByMap(map);
	}

	@Override
	public AtUserGroupRel queryByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return augrm.findByUserId(map);
	}

}
