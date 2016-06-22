/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.io.BufferedReader;
import java.util.ArrayList;
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
import com.rrtimes.acm.serviceI.AtCsrBasicService;

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
		if(!StringUtils.isEmpty(aso.getCsrName())){
			map.put("csrName", aso.getCsrName());
		}
		int size = asom.findByCount(map);
		page.setSumCloum(size);
		map.put("page", page);
		List<AtCsrBasic> list = asom.findByPage(map);
		return list;
	}
	@Override
	public int addUser(AtCsrBasic aso){
		return asom.insert(aso)>0?0:1;
	}
	@Override
	public int updateUser(AtCsrBasic aso) {
		// TODO Auto-generated method stub
		return asom.update(aso)>0?0:1;
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
	public void importUser(BufferedReader br,int oid) {
		// TODO Auto-generated method stub
		try {
			String stemp;
	        while ((stemp = br.readLine()) != null) {
	            String[] str = stemp.split(",");
	            AtCsrBasic acb = new AtCsrBasic();
	            acb.setCsrType(Integer.parseInt(str[0]));
	            acb.setCsrIdentifer(str[1]);
	            acb.setCsrCode(str[2]);
	            acb.setRegAddress(str[3]);
	            acb.setOfficeAddress(str[4]);
	            acb.setFinanceLeader(str[5]);
	            acb.setTaxLeader(str[6]);
	            acb.setOperator(str[7]);
	            acb.setRemark(str[8]);
	            acb.setCpCode(String.valueOf(oid));
	            asom.insert(acb);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<AtCsrBasic> queryBasicByUser(int userAccount,AtCsrBasic aso,PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userAccount);
		if(!StringUtils.isEmpty(aso.getCsrIdentifer())){
			map.put("csrIdentifer", aso.getCsrIdentifer());
		}
		page.setSumCloum(asom.findByUserCount(map));
		map.put("page", page);
		return asom.findByUser(map);
	}
	@Override
	public List<AtCsrBasic> queryBasicByAgent(String agentCode,AtCsrBasic aso,PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cpCode", agentCode);
		if(!StringUtils.isEmpty(aso.getCsrIdentifer())){
			map.put("csrIdentifer", aso.getCsrIdentifer());
		}
		page.setSumCloum(asom.findByAgentCount(map));
		map.put("page", page);
		return asom.findByAgent(map);
	}
	@Override
	public List<AtCsrBasic> queryBasicByOrg(int orgId,AtCsrBasic aso,PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orgId", orgId);
		if(!StringUtils.isEmpty(aso.getCsrIdentifer())){
			map.put("csrIdentifer", aso.getCsrIdentifer());
		}
		page.setSumCloum(asom.findByOrgCount(map));
		map.put("page", page);
		return asom.findByOrg(map);
	}
	@Override
	public AtCsrBasic queryBasicById(int id) {
		// TODO Auto-generated method stub
		AtCsrBasic aso = asom.findById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("csrIdentifer", aso.getCsrIdentifer());
		aso.setAcc(accm.findByCsrIdentifer(map));
		aso.setAcf(acfm.findByCsrIdentifer(aso.getCsrIdentifer()));
		return aso;
	}
	@Override
	public List<AtCsrBasic> queryBasicByUserId(int userId,PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		page.setSumCloum(asom.findCountByUserId(map));
		map.put("page", page);
		return asom.findByUserId(map);
	}
	@Override
	public int queryCountByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return asom.findCountByUserId(map);
	}
}
