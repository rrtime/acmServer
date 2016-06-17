/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;

import com.rrtimes.acm.domain.AtCstContract;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AcmSysOrgService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public interface AtCstContractService {
    //按条件查询并分页
	public List<AtCstContract> queryUser(AtCstContract aso, PageObject page);
	
	//新增用户
	public int addUser(AtCstContract aso);
	
	//修改用户
	public int updateUser(AtCstContract aso);
	
	//删除用户
	public int deleteUser(int id);
	
	//通过id查询用户信息 
	public AtCstContract queryUserById(int id);
	
	//通过用户Id查询需要预警的合同信息
	public List<AtCstContract> queryContractByUserIdAndDay(int userId,int day);
	
	//通过用户Id查询需要预警的合同信息的个数
	public int queryContractCountByUserIdAndDay(int userId,int day);
	
	//通过用户Id查询到期的合同
	public List<AtCstContract> queryContractByUserId(int userId);
	
	//通过用户Id查询到期的合同的个数
	public int queryContractCountByUserId(int userId);
	
	//通过用户Id查询将要付费的合同（月付）
	public List<AtCstContract> queryMonthContractByUserId(int userId,int day);
	
	//通过用户Id查询将要付费的合同（月付）的个数
	public int queryMonthContractCountByUserId(int userId,int day);
	
	//通过用户Id查询欠费的合同信息
	public List<AtCstContract> queryQFByUserId(int userId);
	
	//通过用户Id查询欠费的合同信息的个数
	public int queryQFCountByUserId(int userId); 
	
	//根据客户id查询合同记录
	public List<AtCstContract> queryByBasicId(String csrIdentifer);
	
}
