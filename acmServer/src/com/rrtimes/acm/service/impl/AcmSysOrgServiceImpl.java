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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AcmSysOrgMapper;
import com.rrtimes.acm.serviceI.AcmSysOrgService;

/**
 * @Title:       AcmSysOrgServiceImpl.java
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
public class AcmSysOrgServiceImpl implements AcmSysOrgService{
	
	@Resource
	private AcmSysOrgMapper asom;

	@Override
	public List<AcmSysOrg> queryOrg(AcmSysOrg aso, PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(aso.getOrgName())){
			map.put("orgName", aso.getOrgName());
		}
		if(aso.getOid()>-1){
			map.put("oid", aso.getOid());
		}
		page.setSumCloum(asom.findByCount(map));
		map.put("page", page);
		return asom.findByPage(map);
	}
	
	@Override
	public int addOrg(AcmSysOrg aso){
		return asom.insert(aso)>0?0:1;
	}
	
	@Override
	public int updateOrg(AcmSysOrg aso) {
		// TODO Auto-generated method stub
		return asom.update(aso)>0?0:1;
	}
	
	@Override
	public int deleteOrg(int id) {
		// TODO Auto-generated method stub
		return asom.delete(id)>0?0:1;
	}
	
	@Override
	public AcmSysOrg queryOrgById(int id) {
		// TODO Auto-generated method stub
		return asom.findById(id);
	}
	
	@Override
	public List<AcmSysOrg> queryOrgByOid(int oid) {
		// TODO Auto-generated method stub
		return asom.findOrgByOid(oid);
	}
	
	@Override
	public List<AcmSysOrg> queryAll(String cpCode) {
		// TODO Auto-generated method stub
		return asom.findAll(cpCode);
	}

}
