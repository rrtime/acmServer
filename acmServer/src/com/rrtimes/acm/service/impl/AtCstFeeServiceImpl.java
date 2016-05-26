/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.rrtimes.acm.domain.AtCstFee;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCstFeeMapper;
import com.rrtimes.acm.service.AtCstFeeService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtCstFeeServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 客户收费记录 Service 接口实现类
 * 
 * <p>
 * 	客户收费记录 Service 接口实现类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstFeeServiceImpl implements AtCstFeeService {

	@Resource
	private AtCstFeeMapper atCstFeeMapper;
	
	@Override
	public int addAtCstFee(AtCstFee atCstFee) {
		return atCstFeeMapper.insert(atCstFee)>0?0:1;
	}

	@Override
	public int modAtCstFee(AtCstFee atCstFee) {
		return atCstFeeMapper.update(atCstFee);
	}

	@Override
	public int delAtCstFee(int id) {
		return atCstFeeMapper.delete(id)>0?0:1;
	}

	@Override
	public AtCstFee queryDetailInfo(int id) {
		return atCstFeeMapper.findById(id);
	}

	@Override
	public List<AtCstFee> queryListByPage(AtCstFee atCstFee, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(atCstFee.getNid() >= 0){
			map.put("nid", atCstFee.getNid());
		}
		if(atCstFee.getCid() >= 0){
			map.put("cid", atCstFee.getCid());
		}
		if(atCstFee.getPayType() >= 0){
			map.put("payType", atCstFee.getPayType());
		}
		if(!StringUtil.isEmtryStr(atCstFee.getOperator())){
			map.put("operator", atCstFee.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atCstFee.getRemark())){
			map.put("remark", "%" + atCstFee.getRemark() + "%");
		}
		// 数据总量查询
		page.setSumCloum(atCstFeeMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atCstFeeMapper.findByPage(map);
	}

	@SuppressWarnings("finally")
	@Override
	public List<AtCstFee> getRemindFeeList(int days,String operator) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		try{
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			System.out.println(sdf.format(cal.getTime()));
			String dateTime = sdf.format(cal.getTime());
			paramMap.put("dateTime", dateTime);
			paramMap.put("operator", operator);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return atCstFeeMapper.getRemindFeeList(paramMap);
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int countRemindFee(int days,String operator) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		try{
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			System.out.println(sdf.format(cal.getTime()));
			String dateTime = sdf.format(cal.getTime());
			//参数Map
			paramMap.put("dateTime", dateTime);
			paramMap.put("operator", operator);
		}catch(Exception e){ 
			e.printStackTrace();
		}finally{
			return atCstFeeMapper.getRemindFeeCount(paramMap);
		}
	}

	@Override
	public List<AtCstFee> findAll() {
		return atCstFeeMapper.findAll();
	}

}
