/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service;

import java.util.List;

import com.rrtimes.acm.domain.AtCstFee;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtCstFeeService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 客户收费记录 Service 接口类
 * 
 * <p>
 * 	客户收费记录 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtCstFeeService {
	
	/**
	 * 新增客户收费记录
	 * 
	 * */
	public int addAtCstFee(AtCstFee atCstFee);
	
	/**
	 * 修改客户收费记录
	 * 
	 * */
	public int modAtCstFee(AtCstFee atCstFee);
	
	/**
	 * 删除客户收费记录
	 * 
	 * */
	public int delAtCstFee(int id);
	
	/**
	 * 查询客户收费记录详情
	 * 
	 * */
	public AtCstFee queryDetailInfo(int id);
	
	/**
	 * 查询客户收费记录列表(分页)
	 * 
	 * */
	public List<AtCstFee> queryListByPage(AtCstFee atCstFee, PageObject page);
	
	/**
	 * 提醒客户缴费或续费列表
	 * @param days
	 * @param operator
	 * @return
	 */
	public List<AtCstFee> getRemindFeeList(int days,String operator);
	
	/**
	 * 统计收费提醒数量
	 * @param days
	 * @param operator
	 * @return
	 */
	public int countRemindFee(int days,String operator);
	
	/**
	 * 
	 * 客户收费记录查询
	 * 
	 * */
	public List<AtCstFee> findAll();
	
}
