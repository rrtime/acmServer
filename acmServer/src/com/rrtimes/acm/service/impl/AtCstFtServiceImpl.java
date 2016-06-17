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

import com.rrtimes.acm.domain.AtCstFt;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCstFtMapper;
import com.rrtimes.acm.serviceI.AtCstFtService;

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
public class AtCstFtServiceImpl implements AtCstFtService{
	
	@Resource
	private AtCstFtMapper asom;

	@Override
	public List<AtCstFt> queryUser(AtCstFt aso, PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(aso.getCsrIdentifer())){
			map.put("csrIdentifer", aso.getCsrIdentifer());
		}
		if(aso.getFtInst()>0){
			map.put("ftInst", aso.getFtInst());
		}
		if(!StringUtils.isEmpty(aso.getRids())){
			map.put("rids", aso.getRids());
		}
		if(aso.getRecepitCount()>0){
			map.put("recepitCount", aso.getRecepitCount());
		}
		if(aso.getOwnTaxStation()>0){
			map.put("ownTaxStation",aso.getOwnTaxStation());
		}
		if(aso.getOwnDeclareTime()!=null){
			map.put("ownDeclareTime", aso.getOwnDeclareTime());
		}
		if(aso.getOwnLevyType()>0){
			map.put("ownLevyType", aso.getOwnLevyType());
		}
		if(aso.getOwnTaxType()>0){
			map.put("ownTaxType", aso.getOwnTaxType());
		}
		if(!StringUtils.isEmpty(aso.getOwnTaxRate())){
			map.put("ownTaxRate", aso.getOwnTaxRate());
		}
		if(aso.getAddTaxOwner()>0){
			map.put("addTaxOwner", aso.getAddTaxOwner());
		}
		if(aso.getAddTaxStation()>0){
			map.put("addTaxStation", aso.getAddTaxStation());
		}
		if(aso.getAddTaxDeclareTime()!=null){
			map.put("addTaxDeclareTime", aso.getAddTaxDeclareTime());
		}
		if(aso.getAddTaxLevyType()>0){
			map.put("addTaxLevyType", aso.getAddTaxLevyType());
		}
		if(aso.getAddTaxType()>0){
			map.put("addTaxType", aso.getAddTaxType());
		}
		if(!StringUtils.isEmpty(aso.getAddTaxRate())){
			map.put("addTaxRate", aso.getAddTaxRate());
		}
		if(!StringUtils.isEmpty(aso.getOperator())){
			map.put("operator", aso.getOperator());
		}
		if(!StringUtils.isEmpty(aso.getRemark())){
			map.put("remark", aso.getRemark());
		}
		int size = asom.findByCount(map);
		page.setSumCloum(size);
		map.put("page", page);
		List<AtCstFt> list = asom.findByPage(map);
		return list;
	}
	@Override
	public int addUser(AtCstFt aso){
		return asom.insert(aso)>0?0:1;
	}
	@Override
	public int updateUser(AtCstFt aso) {
		// TODO Auto-generated method stub
		return asom.update(aso)>0?0:1;
	}
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return asom.delete(id)>0?0:1;
	}
	@Override
	public AtCstFt queryUserById(int id) {
		// TODO Auto-generated method stub
		return asom.findById(id);
	}
	@Override
	public List<AtCstFt> queryByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return asom.findByUserId(map);
	}
	
	
}
