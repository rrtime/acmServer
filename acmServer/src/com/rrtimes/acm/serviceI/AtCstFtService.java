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
public interface AtCstFtService {
    //按条件查询并分页
	public List<AtCstFt> queryUser(AtCstFt aso, PageObject page);
	
	//新增用户
	public int addUser(AtCstFt aso);
	
	//修改用户
	public int updateUser(AtCstFt aso);
	
	//删除用户
	public int deleteUser(int id);
	
	//通过id查询用户信息 
	public AtCstFt queryUserById(int id);
	
	//根据用户查看该用户下的客户的财税信息
	public List<AtCstFt> queryByUserId(int userId);
}
