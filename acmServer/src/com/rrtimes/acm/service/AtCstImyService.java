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

import com.rrtimes.acm.domain.AtCstImy;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtCstImyService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 客户质量赔付记录 Service 接口类
 * 
 * <p>
 * 	客户质量赔付记录 Service 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtCstImyService {
	
	/**
	 * 新增客户质量赔付记录
	 * 
	 * */
	public int addAtCstImy(AtCstImy atCstImy);
	
	/**
	 * 修改客户质量赔付记录
	 * 
	 * */
	public int modAtCstImy(AtCstImy atCstImy);
	
	/**
	 * 删除客户质量赔付记录
	 * 
	 * */
	public int delAtCstImy(int id);
	
	/**
	 * 查询客户质量赔付记录详情
	 * 
	 * */
	public AtCstImy queryDetailInfo(int id);
	
	/**
	 * 查询客户质量赔付记录列表(分页)
	 * 
	 * */
	public List<AtCstImy> queryListByPage(AtCstImy atCstImy, PageObject page);
	
	/**
	 * 
	 * @return
	 */
	public int changeImyStatus(AtCstImy atCstImy);
}
