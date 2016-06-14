/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

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
	 * @throws Exception 
	 * 
	 * */
	public int addAtCstVisit(AtCstVisit atCstVisit) throws Exception;
	
	/**
	 * 修改客户回访记录
	 * @throws Exception 
	 * 
	 * */
	public int modAtCstVisit(AtCstVisit atCstVisit) throws Exception;
	
	/**
	 * 删除客户回访记录
	 * @throws Exception 
	 * 
	 * */
	public int delAtCstVisit(int id) throws Exception;
	
	/**
	 * 查询客户回访记录详情
	 * @throws Exception 
	 * 
	 * */
	public AtCstVisit queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询客户回访记录列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtCstVisit> queryListByPage(AtCstVisit atCstVisit, PageObject page) throws Exception;
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<AtCstVisit> findAll() throws Exception;

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtCstVisit(int[] ids) throws Exception;
	
}
