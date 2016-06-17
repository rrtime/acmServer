/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;

import com.rrtimes.acm.domain.BusinessDict;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       BusinessDictService.java
 * @Package:     com.tstar.charge.service
 * @Description: 费率业务字典接口类
 * 
 * <p>
 * 	费率业务字典接口定义
 * </p> 
 * 
 * @author liht
 * 
 */
public interface BusinessDictService {
	
	/**
	 * 新增费率业务字典
	 * 
	 * */
	public int insert(BusinessDict businessDict);
	
	/**
	 * 修改费率业务字典
	 * 
	 * */
	public int update(BusinessDict businessDict);
	
	/**
	 * 删除费率业务字典
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 查询费率业务字典详情
	 * 
	 * */
	public BusinessDict queryDetail(int id);
	
	/**
	 * 查询费率业务字典列表(分页)
	 * 
	 * */
	public List<BusinessDict> queryByPage(BusinessDict businessDict, PageObject page);
	
}
