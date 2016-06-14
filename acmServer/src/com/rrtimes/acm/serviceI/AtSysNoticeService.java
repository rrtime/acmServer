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

import com.rrtimes.acm.domain.AtSysNotice;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AtSysNoticeService.java
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
public interface AtSysNoticeService {

	//查询当前用户创建并已发布的通知公告
	public List<AtSysNotice> queryGnoticeByUserId(int userId);
	
	//查询当前用户创建的通知
	public List<AtSysNotice> queryTnoticeByUserId(int userId);
	
	//查询已发布的通知公告中当前用户可以查看的
	public List<AtSysNotice> queryNoticeByGUserId(int userId);
	
	//查询已发布的通知中当前用户可以查看的
	public List<AtSysNotice> queryNoticeByTUserId(int userId);
	
	//查询撤回的通知公告
	public List<AtSysNotice> queryCGnoticeByUserId(int userId);
	
	//查询撤回的通知
	public List<AtSysNotice> queryCTnoticeByUserId(int userId);
	
	public int insert(AtSysNotice asn);
	
	public int update(AtSysNotice asn);
	
	public int delete(int id);
	
	public AtSysNotice queryById(int id);
	
	//根据userId和status查询通知公告
	public List<AtSysNotice> queryNoticeByUserIdAndStatus(int userId,int nstatus,PageObject page);
	
}
