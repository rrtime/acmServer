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
import com.rrtimes.acm.serviceI.AtCstFeeService;
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
	
	/**
	 * 新增客户收费记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int addAtCstFee(AtCstFee atCstFee) throws Exception {
		return atCstFeeMapper.insert(atCstFee)>0?0:1;
	}

	/**
	 * 修改客户收费记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int modAtCstFee(AtCstFee atCstFee) throws Exception {
		atCstFee.setUpdateTime(new Date());
		return atCstFeeMapper.update(atCstFee)>0?0:1;
	}

	/**
	 * 删除客户收费记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int delAtCstFee(int id) throws Exception {
		return atCstFeeMapper.delete(id)>0?0:1;
	}

	/**
	 * 查询客户收费记录详情
	 * @throws Exception 
	 * 
	 * */
	@Override
	public AtCstFee queryDetailInfo(int id) throws Exception {
		return atCstFeeMapper.findById(id);
	}

	/**
	 * 查询客户收费记录列表(分页)
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtCstFee> queryListByPage(AtCstFee atCstFee, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(atCstFee.getNid() > 0){//客户合同ID
			map.put("nid", atCstFee.getNid());
		}
		if(atCstFee.getCid() > 0){//客户ID
			map.put("cid", atCstFee.getCid());
		}
		if(atCstFee.getPayType() > 0){//支付方式
			map.put("payType", atCstFee.getPayType());
		}
		if(!StringUtil.isEmtryStr(atCstFee.getOperator())){//操作员
			map.put("operator", atCstFee.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atCstFee.getRemark())){//备注
			map.put("remark", atCstFee.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atCstFeeMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atCstFeeMapper.findByPage(map);
	}

	/**
	 * 提醒客户缴费或续费列表
	 * @param days
	 * @param operator
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<AtCstFee> getRemindFeeList(int days,String operator) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//从当前时间到days天后
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dateTime = sdf.format(cal.getTime());
		//参数
		paramMap.put("dateTime", dateTime);
		paramMap.put("operator", operator);
		return atCstFeeMapper.getRemindFeeList(paramMap);
	}

	/**
	 * 统计收费提醒数量
	 * @param days
	 * @param operator
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int countRemindFee(int days,String operator) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//从当前时间到days天后
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dateTime = sdf.format(cal.getTime());
		//参数Map
		paramMap.put("dateTime", dateTime);
		paramMap.put("operator", operator);
		return atCstFeeMapper.getRemindFeeCount(paramMap);
	}

	/**
	 * 
	 * 客户收费记录查询
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtCstFee> findAll() throws Exception {
		return atCstFeeMapper.findAll();
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int batchDeleteAtCstFee(int[] ids) throws Exception {
		return atCstFeeMapper.batchDeleteAtCstFee(ids)>0?0:1;
	}

}
