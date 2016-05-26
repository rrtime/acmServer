/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.service;

import java.util.List;

import com.rrtimes.acm.domain.AtSysMenu;
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
public interface AtSysMenuService {

	public List<AtSysMenu> queryMenu(AtSysMenu aso, PageObject page);
	
	public int addMenu(AtSysMenu aso);
	
	public int updateMenu(AtSysMenu aso);
	
	public int deleteMenu(int id);
	
	public AtSysMenu queryMenuById(int id);
	
	//根据用户Id查询当前用户的菜单权限
	public List<AtSysMenu> queryByUserId(int userId);
}
