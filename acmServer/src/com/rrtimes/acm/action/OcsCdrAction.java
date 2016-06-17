/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.CdrResource;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.CdrResourceService;

/**
 * @Title:       OcsCdrAction.java
 * @Package:     com.tstar.charge.action
 * @Description: 分拣源管理 Action
 * 
 * <p>
 * 	分拣源管理业务控制层
 * </p> 
 * 
 * @author liht
 * 
 */
public class OcsCdrAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private CdrResourceService cdrResourceService;
	
	private List<CdrResource> cdrList = new ArrayList<CdrResource>();
	
	private CdrResource cdrResource = new CdrResource();
	
	private PageObject page = new PageObject();
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	
	private String msg = "";
	
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	
	/**
	 * 跳转至分拣源新增页面
	 * */
	public String addCdrPage()
	{
		
		this.setCmd(0);
		return "addCdr";
	}
	
	/**
	 * 分拣源新增业务
	 * */
	public String addCdr()
	{
		rst = cdrResourceService.insert(cdrResource) > 0?0:1;
		// 设置界面提示信息
		if( rst == 0 )
			msg = "新增操作已成功。";
		else
			msg = "新增操作未成功。";
		this.page.setCurrentPage(1);
		return queryCdrList();
	}
	
	/**
	 * 跳转至分拣源修改页面
	 * */
	public String modCdrPage()
	{
		this.setCmd(1);
		this.setCdrResource(cdrResourceService.queryDetail(cdrResource.getId()));
		return "modCdr";
	}
	
	/**
	 * 分拣源修改业务
	 * */
	public String modCdr()
	{
		rst = cdrResourceService.update(cdrResource) > 0?0:1;
		// 设置界面提示信息
		if( rst == 0 )
			msg = "修改操作已成功。";
		else
			msg = "修改操作未成功。";
		return queryCdrList();
	}
	
	/**
	 * 分拣源记录状态修改
	 * */
	public String modCdrFlag()
	{
		rst = cdrResourceService.updateFlag(cdrResource.getId(), cdrResource.getFlag()) > 0?0:1;
		// 设置界面提示信息
		if( rst == 0 )
			msg = "修改操作已成功。";
		else
			msg = "修改操作未成功。";
		return queryCdrList();
	}
	
	/**
	 * 查询当前分拣源列表
	 * */
	public String queryCdrList()
	{
		this.setCdrList(cdrResourceService.queryAll(cdrResource, page));
		return "cdrList";
	}
	
	/**
	 * 查询当前分拣源详情
	 * */
	public String cdrDetail()
	{
		this.setCmd(2);
		this.setCdrResource(cdrResourceService.queryDetail(cdrResource.getId()));
		return "cdrDetail";
	}

	/**
	 * 删除当前分拣源信息
	 * */
	public String cdrDelete()
	{
		rst = cdrResourceService.delete(cdrResource.getId()) > 0?0:1;
		// 设置界面提示信息
		if( rst == 0 )
			msg = "删除操作已成功。";
		else
			msg = "删除操作未成功。";
		return queryCdrList();
	}
	
	
	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public List<CdrResource> getCdrList() {
		return cdrList;
	}


	public void setCdrList(List<CdrResource> cdrList) {
		this.cdrList = cdrList;
	}


	public CdrResource getCdrResource() {
		return cdrResource;
	}


	public void setCdrResource(CdrResource cdrResource) {
		this.cdrResource = cdrResource;
	}


	public PageObject getPage() {
		return page;
	}


	public void setPage(PageObject page) {
		this.page = page;
	}


	public int getRst() {
		return rst;
	}


	public void setRst(int rst) {
		this.rst = rst;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
