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
	 * @throws Exception 
	 * 
	 * */
	public int addAtCstImy(AtCstImy atCstImy) throws Exception;
	
	/**
	 * 修改客户质量赔付记录
	 * @throws Exception 
	 * 
	 * */
	public int modAtCstImy(AtCstImy atCstImy) throws Exception;
	
	/**
	 * 删除客户质量赔付记录
	 * @throws Exception 
	 * 
	 * */
	public int delAtCstImy(int id) throws Exception;
	
	/**
	 * 查询客户质量赔付记录详情
	 * @throws Exception 
	 * 
	 * */
	public AtCstImy queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询客户质量赔付记录列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtCstImy> queryListByPage(AtCstImy atCstImy, PageObject page) throws Exception;
	
	/**
	 * 修改质量赔付状态
	 * @return
	 * @throws Exception 
	 */
	public int changeImyStatus(AtCstImy atCstImy) throws Exception;
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<AtCstImy> findAll() throws Exception;

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtCstImy(int[] ids) throws Exception;
}
