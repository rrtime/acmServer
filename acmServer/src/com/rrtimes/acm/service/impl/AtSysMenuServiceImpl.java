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

import com.rrtimes.acm.domain.AtSysMenu;
import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.AtUserGroupRel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtSysMenuMapper;
import com.rrtimes.acm.persistence.AtUserGroupRelMapper;
import com.rrtimes.acm.serviceI.AcmSysOrgService;
import com.rrtimes.acm.serviceI.AtSysMenuService;
import com.rrtimes.acm.persistence.AcmSysOrgMapper;

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
public class AtSysMenuServiceImpl implements AtSysMenuService{
	
	@Resource
	private AtSysMenuMapper asom;
	@Resource
	private AtUserGroupRelMapper augrm;

	@Override
	public List<AtSysMenu> queryMenu(AtSysMenu aso, PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(aso.getId()>0){
			map.put("id", aso.getId());
		}
		if(!StringUtils.isEmpty(aso.getMtitle())){
			map.put("mTitle", aso.getMtitle());
		}
		if(!StringUtils.isEmpty(aso.getMdesc())){
			map.put("mDesc", aso.getMdesc());
		}
		if(aso.getParentId()>0){
			map.put("parentId",aso.getParentId());
		}
		if(aso.getTflag()>0){
			map.put("tflag", aso.getTflag());
		}
		if(!StringUtils.isEmpty(aso.getInid())){
			map.put("inid", aso.getInid());
		}
		if(aso.getIsSystem()>0){
			map.put("isSystem", aso.getIsSystem());
		}
		if(aso.getCategory()>0){
			map.put("category", aso.getCategory());
		}
		if(aso.getIsEndnode()>0){
			map.put("isEndnode", aso.getIsEndnode());
		}
		if(aso.getShowIndex()>0){
			map.put("showIndex", aso.getShowIndex());
		}
		if(!StringUtils.isEmpty(aso.getRemark())){
			map.put("remark", aso.getRemark());
		}
		int size = asom.findByCount(map);
		page.setSumCloum(size);
		map.put("page", page);
		List<AtSysMenu> list = asom.findByPage(map);
		return list;
	}
	@Override
	public int addMenu(AtSysMenu aso){
		return asom.insert(aso)>0?0:1;
	}
	@Override
	public int updateMenu(AtSysMenu aso) {
		// TODO Auto-generated method stub
		return asom.update(aso)>0?0:1;
	}
	@Override
	public int deleteMenu(int id) {
		// TODO Auto-generated method stub
		return asom.delete(id)>0?0:1;
	}
	@Override
	public AtSysMenu queryMenuById(int id) {
		// TODO Auto-generated method stub
		return asom.findById(id);
	}
	@Override
	public List<AtSysMenu> queryByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		AtUserGroupRel augr = augrm.findByUserId(map);
		if(augr!=null){
			map.put("userId", augr.getGid());
		}
		return asom.findByUserId(map);
	}
}
