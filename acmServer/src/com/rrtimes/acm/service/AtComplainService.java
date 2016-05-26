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

import com.rrtimes.acm.domain.AtComplain;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtComplainService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 客户投诉信息 Service 接口类
 * 
 * <p>
 * 	客户投诉信息 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtComplainService {
	
	/**
	 * 新增客户投诉信息
	 * 
	 * */
	public int addAtComplain(AtComplain atComplain);
	
	/**
	 * 修改客户投诉信息
	 * 
	 * */
	public int modAtComplain(AtComplain atComplain);
	
	/**
	 * 删除客户投诉信息
	 * 
	 * */
	public int delAtComplain(int id);
	
	/**
	 * 查询客户投诉信息详情
	 * 
	 * */
	public AtComplain queryDetailInfo(int id);
	
	/**
	 * 查询客户投诉信息列表(分页)
	 * 
	 * */
	public List<AtComplain> queryListByPage(AtComplain atComplain, PageObject page);
	
	/**
	 * 改变投诉记录状态
	 */
	public int changeCnStatus(AtComplain atComplain);
	
}
