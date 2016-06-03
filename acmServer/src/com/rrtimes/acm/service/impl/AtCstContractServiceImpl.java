/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.rrtimes.acm.domain.AtCstContract;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCstContractMapper;
import com.rrtimes.acm.service.AtCstContractService;

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
public class AtCstContractServiceImpl implements AtCstContractService{
	
	@Resource
	private AtCstContractMapper asom;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM");
	Calendar calendar = new GregorianCalendar();
	Calendar c = Calendar.getInstance();
	
	@Override
	public List<AtCstContract> queryUser(AtCstContract aso, PageObject page) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(aso.getCsrIdentifer())){
			map.put("csrIdentifer", aso.getCsrIdentifer());
		}
		if(aso.getServiceType()>0){
			map.put("serviceType", aso.getServiceType());
		}
		if(!StringUtils.isEmpty(aso.getStartTime())){
			map.put("startTime", aso.getStartTime());
		}
		if(!StringUtils.isEmpty(aso.getEndTime())){
			map.put("endTime", aso.getEndTime());
		}
		if(aso.getServiceFee()>0){
			map.put("serviceFee", aso.getServiceFee());
		}
		if(aso.getPayCycle()>0){
			map.put("payCycle", aso.getPayCycle());
		}
		if(aso.getPayDay()>0){
			map.put("payDay", aso.getPayDay());
		}
		if(aso.getSortType()>0){
			map.put("sortType", aso.getSortType());
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
		List<AtCstContract> list = asom.findByPage(map);
		return list;
	}
	@Override
	public int addUser(AtCstContract aso){
		return asom.insert(aso)>0?0:1;
	}
	@Override
	public int updateUser(AtCstContract aso) {
		// TODO Auto-generated method stub
		return asom.update(aso)>0?0:1;
	}
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return asom.delete(id)>0?0:1;
	}
	@Override
	public AtCstContract queryUserById(int id) {
		// TODO Auto-generated method stub
		return asom.findById(id);
	}
	@Override
	public List<AtCstContract> queryContractByUserIdAndDay(int userId,int day) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map.put("userId", userId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date); 
		    calendar.add(calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动 
		    date=calendar.getTime();   //这个时间就是日期往后推一天的结果
			map.put("day", sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asom.findByUserIdAndDay(map);
	}
	@Override
	public List<AtCstContract> queryContractByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return asom.findByUserId(map);
	}
	@Override
	public List<AtCstContract> queryMonthContractByUserId(int userId,int day) {
		// TODO Auto-generated method stub
		List<AtCstContract> newlist = new ArrayList<AtCstContract>();
		try {
			Date date = sdf.parse(sdf.format(new Date()));
			Map<String,Object> maparam = new HashMap<String,Object>();
			maparam.put("userId", userId);
			List<AtCstContract> acclist = asom.findPaydayByUserId(maparam);
			for(int i=0;i<acclist.size();i++){
				Date newdate = sdf.parse(sdfm.format(new Date())+"-"+acclist.get(i).getPayDay());
				if(date.before(newdate)){//当前日期如果是本月$(day)之前，则要查询上个月$(day)之后到今天，当前合同是否有收费记录，没有就提醒
				    c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
				    Map<String,Object> mapparam = new HashMap<String,Object>();
				    mapparam.put("contractId", acclist.get(i).getId());
				    mapparam.put("date", sdf.format(sdf.parse(sdfm.format(c.getTime())+"-"+acclist.get(i).getPayDay()+"")));
					Map<String,Object> map = asom.findByContractIdAndDaybefore(mapparam);
					if(map==null){
						calendar.setTime(date);  
					    calendar.add(calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动 
					    Date datenew=calendar.getTime();   //这个时间就是日期往后推一天的结果
					    if(datenew.getDay()>=newdate.getDay() && sdf.parse(sdf.format(new Date())).getDay()<=newdate.getDay()){
					    	newlist.add(acclist.get(i));
					    }
					}
				}else if(date.after(newdate)){//当前日期如果大于本月$(day)，则要查询本月$(day)到下个月$(day)，当前合同是否有收费记录，没有就提醒
					c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
				    Map<String,Object> mapparam = new HashMap<String,Object>();
				    mapparam.put("contractId", acclist.get(i).getId());
				    mapparam.put("datebegin", sdf.format(sdf.parse(sdfm.format(new Date())+"-"+acclist.get(i).getPayDay()+"")));
				    mapparam.put("datend", sdf.format(sdf.parse(sdfm.format(c.getTime())+"-"+acclist.get(i).getPayDay()+"")));
					Map<String,Object> map = asom.findByContractIdAndDayaffer(mapparam);
					if(map==null){
					    c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
					    c.set(Calendar.DAY_OF_MONTH, 1);
					    Date afferdate = sdf.parse(sdfm.format(c.getTime())+"-"+acclist.get(i).getPayDay());
					    calendar.setTime(date); 
					    calendar.add(calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动 
					    Date datenew=calendar.getTime();   //这个时间就是日期往后推一天的结果
					    if(datenew.getDay()>=afferdate.getDay() && sdf.parse(sdf.format(new Date())).getDay()<=afferdate.getDay()){
					    	newlist.add(acclist.get(i));
					    }
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newlist;
	}
	@Override
	public int queryContractCountByUserIdAndDay(int userId,
			int day) {
		// TODO Auto-generated method stub
		return queryContractByUserIdAndDay(userId,day).size();
	}
	@Override
	public int queryContractCountByUserId(int userId) {
		// TODO Auto-generated method stub
		return queryContractByUserId(userId).size();
	}
	@Override
	public int queryMonthContractCountByUserId(
			int userId, int day) {
		// TODO Auto-generated method stub
		return queryMonthContractByUserId(userId,day).size();
	}
	@Override
	public List<AtCstContract> queryQFByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return asom.findQFByUserId(map);
	}
	@Override
	public int queryQFCountByUserId(int userId) {
		// TODO Auto-generated method stub
		return queryQFByUserId(userId).size();
	}
	
}
