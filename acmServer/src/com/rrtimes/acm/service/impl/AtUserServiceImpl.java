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

import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtUserMapper;
import com.rrtimes.acm.service.AtUserService;

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
public class AtUserServiceImpl implements AtUserService{
	
	@Resource
	private AtUserMapper asom;

	@Override
	public List<AtUser> queryUser(AtUser aso, PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(aso.getCpCode())){
			map.put("cpCode", aso.getCpCode());
		}
		if(aso.getOid()>0){
			map.put("oid", aso.getOid());
		}
		if(aso.getItype()>0){
			map.put("iType", aso.getItype());
		}
		if(!StringUtils.isEmpty(aso.getIname())){
		    map.put("iName", aso.getIname());	
		}
		if(!StringUtils.isEmpty(aso.getLoginPwd())){
			map.put("loginPwd", aso.getLoginPwd());
		}
		if(!StringUtils.isEmpty(aso.getUserName())){
			map.put("userName", aso.getUserName());
		}
		if(aso.getSex()>0){
			map.put("sex", aso.getSex());
		}
		if(!StringUtils.isEmpty(aso.getWorkerNo())){
			map.put("workerNo", aso.getWorkerNo());
		}
		if(!StringUtils.isEmpty(aso.getJobDuty())){
			map.put("jobDuty", aso.getJobDuty());
		}
		if(!StringUtils.isEmpty(aso.getTelno())){
			map.put("telno", aso.getTelno());
		}
		if(!StringUtils.isEmpty(aso.getEmail())){
			map.put("email", aso.getEmail());
		}
		if(aso.getIsUsed()>0){
			map.put("isUsed", aso.getIsUsed());
		}
		if(aso.getIsAdmin()>0){
			map.put("isAdmin", aso.getIsAdmin());
		}
		if(aso.getOrderNum()>0){
			map.put("orderNum", aso.getOrderNum());
		}
		if(aso.getAuthState()>0){
			map.put("authState", aso.getAuthState());
		}
		if(aso.getLastLoginDate()!=null){
			map.put("lastLoginDate", aso.getLastLoginDate());
		}
		if(aso.getStatus()>0){
			map.put("status", aso.getStatus());
		}
		if(!StringUtils.isEmpty(aso.getLoginIp())){
			map.put("loginIp", aso.getLoginIp());
		}
		if(!StringUtils.isEmpty(aso.getLoginTime())){
			map.put("loginTime", aso.getLoginTime());
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
		List<AtUser> list = asom.findByPage(map);
		return list;
	}
	
	@Override
	public int addUser(AtUser aso){
		return asom.insert(aso);
	}
	
	@Override
	public int updateUser(AtUser aso) {
		// TODO Auto-generated method stub
		return asom.update(aso);
	}
	
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return asom.delete(id);
	}
	
	@Override
	public AtUser queryUserById(int id) {
		// TODO Auto-generated method stub
		return asom.findById(id);
	}
	
	@Override
	public List<AtUser> queryUserByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return asom.findByMap(map);
	}

	@Override
	public boolean queryByInameToinsert(String Iname) {
		// TODO Auto-generated method stub
		boolean result = false;
		AtUser au = asom.findByINameToinsert(Iname);
		if(au==null){
			result = true;
		}
		return result;
	}

	@Override
	public boolean queryByInameToupdate(String Iname,int id) {
		// TODO Auto-generated method stub
		boolean result = false;
		AtUser user = asom.findByINameToupdate(Iname);
		if(user==null){
			result = true;
		}else{
			if(id==user.getId()){
				result = true;
			}
		}
		return result;
	}

	@Override
	public AtUser queryByUser(AtUser user) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("iName", user.getIname());
		map.put("loginPwd", user.getLoginPwd());
		map.put("status", 0);
		
		AtUser atuser = asom.findByUser(map);
		if(atuser!=null){
			atuser.setResult(0);
		}else{
			atuser = new AtUser();
			atuser.setResult(-1);
		}
		System.out.println("result======"+atuser.getResult());
		return atuser;
	}
}
