/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.io.BufferedReader;
import java.util.List;

import com.rrtimes.acm.domain.AtCsrBasic;
import com.rrtimes.acm.domain.AtCstFt;
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
public interface AtCsrBasicService {
    //按条件查询并分页
	public List<AtCsrBasic> queryUser(AtCsrBasic aso, PageObject page);
	
	//新增用户
	public int addUser(AtCsrBasic aso);
	
	//修改用户
	public int updateUser(AtCsrBasic aso);
	
	//删除用户
	public int deleteUser(int id);
	
	//通过id查询用户信息 
	public AtCsrBasic queryUserById(int id);
	
	//初始化通过excel导入用户
	public void importUser(BufferedReader br,int oid);
	
	//根据部门用户查询客户信息
	public List<AtCsrBasic> queryBasicByUser(int userAccount,AtCsrBasic aso,PageObject page);
	
	//根据代账公司查询客户信息
	public List<AtCsrBasic> queryBasicByAgent(String agentCode,AtCsrBasic aso,PageObject page);
	
	//根据部门查询客户信息
	public List<AtCsrBasic> queryBasicByOrg(int orgid,AtCsrBasic aso,PageObject page);
	
	//根据客户id查询客户信息、合同信息、客户财税信息
	public AtCsrBasic queryBasicById(int id);
	
	//根据用户Id查询需要跟进的客户并设置预警时间
	public List<AtCsrBasic> queryBasicByUserId(int userId,PageObject page); 
	
	//根据用户Id查询需要跟进的客户的个数并设置预警时间
	public int queryCountByUserId(int userId);
	
	//验证客户是否存在
	public boolean isexistbasic(String csrIdentifer);
	
	//同时新增客户和财税信息
	public int addbasicAndcsrft(AtCsrBasic ab);
}
