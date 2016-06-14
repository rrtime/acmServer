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
	 * @throws Exception 
	 * 
	 * */
	public int addAtComplain(AtComplain atComplain) throws Exception;
	
	/**
	 * 修改客户投诉信息
	 * @throws Exception 
	 * 
	 * */
	public int modAtComplain(AtComplain atComplain) throws Exception;
	
	/**
	 * 删除客户投诉信息
	 * @throws Exception 
	 * 
	 * */
	public int delAtComplain(int id) throws Exception;
	
	/**
	 * 查询客户投诉信息详情
	 * @throws Exception 
	 * 
	 * */
	public AtComplain queryDetailInfo(int id) throws Exception;
	
	/**
	 * 查询客户投诉信息列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtComplain> queryListByPage(AtComplain atComplain, PageObject page) throws Exception;
	
	/**
	 * 改变投诉记录状态
	 * @throws Exception 
	 */
	public int changeCnStatus(AtComplain atComplain) throws Exception;

	/**
	 * 查询所有数据
	 * @return
	 */
	public List<AtComplain> findAll() throws Exception;

	/**
	 * 批量删除
	 * @return
	 */
	public int batchDeleteAtComplain(int[] ids) throws Exception;
	
}
