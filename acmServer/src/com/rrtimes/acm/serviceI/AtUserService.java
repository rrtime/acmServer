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
import java.util.Map;

import com.rrtimes.acm.domain.AtUser;
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
public interface AtUserService {
    //按条件查询并分页
	public List<AtUser> queryUser(AtUser aso, PageObject page);
	
	//新增用户
	public int addUser(AtUser aso);
	
	//修改用户
	public int updateUser(AtUser aso);
	
	//删除用户
	public int deleteUser(int id);
	
	//通过id查询用户信息 
	public AtUser queryUserById(int id);
	
	//根据用户账号查询所属部门的人员信息
	public List<AtUser> queryUserByMap(AtUser aUser);
	
	//新增用户或组时，i_name不能重复
	public boolean queryByInameToinsert(String Iname);
		
	//修改时，i_name不能重复
	public boolean queryByInameToupdate(String Iname,int id);
	
	//根据用户名和密码查询用户对象信息
	public AtUser queryByUser(AtUser user);
	
	//根据代账公司查询当前公司的人员信息
	public List<AtUser> queryBycpCode(String cpCode,PageObject page);
	
	//根据部门查询当前部门的人员信息
	public List<AtUser> queryByOrgId(int orgId,PageObject page);
}
