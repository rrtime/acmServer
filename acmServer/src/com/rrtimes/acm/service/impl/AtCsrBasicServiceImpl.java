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

import com.rrtimes.acm.domain.AtCsrBasic;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCsrBasicMapper;
import com.rrtimes.acm.persistence.AtCstContractMapper;
import com.rrtimes.acm.persistence.AtCstFtMapper;
import com.rrtimes.acm.service.AtCsrBasicService;

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
@Service
public class AtCsrBasicServiceImpl implements AtCsrBasicService{
	
	@Resource
	private AtCsrBasicMapper asom;
	@Resource
	private AtCstContractMapper accm;
	@Resource
	private AtCstFtMapper acfm;

	@Override
	public List<AtCsrBasic> queryUser(AtCsrBasic aso, PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(aso.getCpCode())){
			map.put("cpCode", aso.getCpCode());
		}
		if(aso.getCsrType()>0){
			map.put("csrType", aso.getCsrType());
		}
		if(!StringUtils.isEmpty(aso.getCsrIdentifer())){
			map.put("csrIdentifer", aso.getCsrIdentifer());
		}
		if(!StringUtils.isEmpty(aso.getCsrCode())){
			map.put("csrCode", aso.getCsrCode());
		}
		if(!StringUtils.isEmpty(aso.getRegAddress())){
			map.put("regAddress", aso.getRegAddress());
		}
		if(!StringUtils.isEmpty(aso.getOfficeAddress())){
			map.put("officeAddress", aso.getOfficeAddress());
		}
		if(!StringUtils.isEmpty(aso.getCsrOwner())){
			map.put("csrOwner", aso.getCsrOwner());
		}
		if(!StringUtils.isEmpty(aso.getFinanceLeader())){
			map.put("finaceLeader", aso.getFinanceLeader());
		}
		if(!StringUtils.isEmpty(aso.getTaxLeader())){
			map.put("taxLeader", aso.getTaxLeader());
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
		List<AtCsrBasic> list = asom.findByPage(map);
		return list;
	}
	@Override
	public int addUser(AtCsrBasic aso){
		return asom.insert(aso);
	}
	@Override
	public int updateUser(AtCsrBasic aso) {
		// TODO Auto-generated method stub
		return asom.update(aso);
	}
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return asom.delete(id)>0?0:1;
	}
	@Override
	public AtCsrBasic queryUserById(int id) {
		// TODO Auto-generated method stub
		return asom.findById(id);
	}
	
	@Override
	public void importUser(List<AtCsrBasic> list,int oid) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			list.get(i).setCpCode(String.valueOf(oid));
			asom.insert(list.get(i));
		}
	}
	@Override
	public List<AtCsrBasic> queryBasicByUser(String userAccount) {
		// TODO Auto-generated method stub
		return asom.findByUser(userAccount);
	}
	@Override
	public List<AtCsrBasic> queryBasicByAgent(String agentCode) {
		// TODO Auto-generated method stub
		return asom.findByAgent(agentCode);
	}
	@Override
	public List<AtCsrBasic> queryBasicByOrg(int orgid) {
		// TODO Auto-generated method stub
		return asom.findByOrg(orgid);
	}
	@Override
	public AtCsrBasic queryBasicById(int id) {
		// TODO Auto-generated method stub
		AtCsrBasic aso = asom.findById(id);
		aso.setAcc(accm.findByCsrIdentifer(aso.getCsrIdentifer()));
		aso.setAcf(acfm.findByCsrIdentifer(aso.getCsrIdentifer()));
		return aso;
	}
	@Override
	public List<AtCsrBasic> queryBasicByUserId(int userId) {
		// TODO Auto-generated method stub
		return asom.findByUserId(userId);
	}
	@Override
	public int queryCountByUserId(int userId) {
		// TODO Auto-generated method stub
		return asom.findCountByUserId(userId);
	}
}
