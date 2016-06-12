/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.rrtimes.acm.domain.AtCstVisit;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCstVisitMapper;
import com.rrtimes.acm.serviceI.AtCstVisitService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtCstVisitServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 客户回访记录 Service 实现类
 * 
 * <p>
 * 	客户回访记录 Service 实现类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstVisitServiceImpl implements AtCstVisitService {

	@Resource
	private AtCstVisitMapper atCstVisitMapper;
	
	/**
	 * 新增客户回访记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int addAtCstVisit(AtCstVisit atCstVisit) throws Exception {
		return atCstVisitMapper.insert(atCstVisit)>0?0:1;
	}

	/**
	 * 修改客户回访记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int modAtCstVisit(AtCstVisit atCstVisit) throws Exception {
		atCstVisit.setUpdateTime(new Date());
		return atCstVisitMapper.update(atCstVisit)>0?0:1;
	}

	/**
	 * 删除客户回访记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int delAtCstVisit(int id) throws Exception {
		return atCstVisitMapper.delete(id)>0?0:1;
	}

	/**
	 * 查询客户回访记录详情
	 * @throws Exception 
	 * 
	 * */
	@Override
	public AtCstVisit queryDetailInfo(int id) throws Exception {
		return atCstVisitMapper.findById(id);
	}

	/**
	 * 查询客户回访记录列表(分页)
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtCstVisit> queryListByPage(AtCstVisit atCstVisit, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atCstVisit.getCpCode())){
			map.put("cpCode", atCstVisit.getCpCode());
		}
		if(!StringUtil.isEmtryStr(atCstVisit.getCnIdentifer())){
			map.put("cnIdentifer", atCstVisit.getCnIdentifer());
		}
		if(!StringUtil.isEmtryStr(atCstVisit.getCnCustomer())){
			map.put("cnCustomer", atCstVisit.getCnCustomer());
		}
		if(atCstVisit.getCnType() > 0){
			map.put("cnType", atCstVisit.getCnType());
		}
		if(atCstVisit.getCnResult() >= 0){
			map.put("cnResult", atCstVisit.getCnResult());
		}
		if(!StringUtil.isEmtryStr(atCstVisit.getOperator())){
			map.put("operator", atCstVisit.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atCstVisit.getRemark())){
			map.put("remark", atCstVisit.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atCstVisitMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atCstVisitMapper.findByPage(map);
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	@Override
	public List<AtCstVisit> findAll(){
		return atCstVisitMapper.findAll();
	}

}
