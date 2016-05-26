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

import com.rrtimes.acm.domain.AtCstVisit;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtCstVisitService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 客户回访记录 Service 接口类
 * 
 * <p>
 * 	客户回访记录 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtCstVisitService {
	
	/**
	 * 新增客户回访记录
	 * 
	 * */
	public int addAtCstVisit(AtCstVisit atCstVisit);
	
	/**
	 * 修改客户回访记录
	 * 
	 * */
	public int modAtCstVisit(AtCstVisit atCstVisit);
	
	/**
	 * 删除客户回访记录
	 * 
	 * */
	public int delAtCstVisit(int id);
	
	/**
	 * 查询客户回访记录详情
	 * 
	 * */
	public AtCstVisit queryDetailInfo(int id);
	
	/**
	 * 查询客户回访记录列表(分页)
	 * 
	 * */
	public List<AtCstVisit> queryListByPage(AtCstVisit atCstVisit, PageObject page);
	
}
