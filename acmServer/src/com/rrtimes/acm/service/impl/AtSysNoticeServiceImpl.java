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

import com.alibaba.dubbo.config.annotation.Service;
import com.rrtimes.acm.domain.AtSysNotice;
import com.rrtimes.acm.persistence.AtSysNoticeMapper;
import com.rrtimes.acm.persistence.AtUserMapper;
import com.rrtimes.acm.service.AtSysNoticeService;

/**
 * @Title:       AtSysNoticeServiceImpl.java
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
@Service
public class AtSysNoticeServiceImpl implements AtSysNoticeService{
	
    @Resource
    private AtSysNoticeMapper asnm;
    @Resource
    private AtUserMapper aum;
    
	
	@Override
	public List<AtSysNotice> queryGnoticeByUserId(int userId) {
		// TODO Auto-generated method stub
		return asnm.findGnoticeByUserId(userId);
	}

	@Override
	public List<AtSysNotice> queryTnoticeByUserId(int userId) {
		// TODO Auto-generated method stub
		return asnm.findTnoticeByUserId(userId);
	}

	@Override
	public List<AtSysNotice> queryNoticeByGUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("oid", "%"+aum.findById(userId).getOid()+"%");
		map.put("userId", "%"+userId+"%");
		return asnm.findNoticeByGUserId(map);
	}

	@Override
	public List<AtSysNotice> queryNoticeByTUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("oid", "%"+aum.findById(userId).getOid()+"%");
		map.put("userId", "%"+userId+"%");
		return asnm.findNoticeByTUserId(map);
	}

	@Override
	public List<AtSysNotice> queryCGnoticeByUserId(int userId) {
		// TODO Auto-generated method stub
		return asnm.findCGnoticeByUserId(userId);
	}

	@Override
	public List<AtSysNotice> queryCTnoticeByUserId(int userId) {
		// TODO Auto-generated method stub
		return asnm.findCTnoticeByUserId(userId);
	}

	@Override
	public int insert(AtSysNotice asn) {
		// TODO Auto-generated method stub
		return asnm.insert(asn)>0?0:1;
	}

	@Override
	public int update(AtSysNotice asn) {
		// TODO Auto-generated method stub
		return asnm.update(asn)>0?0:1;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return asnm.delete(id)>0?0:1;
	}

	@Override
	public AtSysNotice queryById(int id) {
		// TODO Auto-generated method stub
		return asnm.findById(id);
	}

}
