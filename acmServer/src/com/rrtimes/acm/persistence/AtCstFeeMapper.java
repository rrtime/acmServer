/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.persistence;

import java.util.List;
import java.util.Map;

import com.rrtimes.acm.domain.AtCstFee;

/**
 * @Title:       AtCstFeeMapper.java
 * @Package:     com.rrtimes.acm.persistence
 * @Description: 客户收费记录  Dao 接口类
 * 
 * <p>
 * 	客户收费记录  Dao 接口类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public interface AtCstFeeMapper {
	
	/**
	 * 
	 * 新增客户收费记录
	 * 
	 * */
	public int insert(AtCstFee atCstFee);

	/**
	 * 
	 * 客户收费记录修改
	 * 
	 * */
	public int update(AtCstFee atCstFee);
	
	/**
	 * 
	 * 客户收费记录删除
	 * 
	 * */
	public int delete(int id);
	
	/**
	 * 
	 * 客户收费记录信息查询
	 * 
	 * */
	public AtCstFee findById(int id);
	
	/**
	 * 
	 * 客户收费记录查询
	 * 		map 中查询条件: 分页对象 page
	 * 
	 * */
	public List<AtCstFee> findByPage(Map<String, Object> map);
	
	/**
	 * 
	 * 客户收费记录查询
	 * 
	 * */
	public List<AtCstFee> findAll();
	
	/**
	 * 
	 * 客户收费记录数量查询(分页专用)
	 * 		map 中查询条件,与 findByPage 查询接口中一样
	 * 
	 * */
	public int findByCount(Map<String, Object> map);
	
	/**
	 * 提醒客户缴费或续费列表
	 * @return
	 */
	public List<AtCstFee> getRemindFeeList(Map<String,Object> paramMap);
	
	/**
	 * 统计收费提醒数量
	 * @param paramMap
	 * @return
	 */
	public int getRemindFeeCount(Map<String,Object> paramMap);

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public int batchDeleteAtCstFee(int[] ids);
	
	
}
