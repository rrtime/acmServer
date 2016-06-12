/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtComplain;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtComplainService;

/**
 * @Title:       AtComplainAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 客户投诉信息Action
 * 
 * <p>
 * 	客户投诉信息Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtComplainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816396458785170132L;

	@Resource
	private AtComplainService atComplainService;
	
	private List<AtComplain> atComplainList = new ArrayList<AtComplain>();
	
	private AtComplain atComplain = new AtComplain();
	
	private PageObject page = new PageObject();
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	
	/**
	 * 跳转至客户投诉信息新增页面
	 * */
	public String toAddAtComplainPage()
	{
		this.setCmd(0);
		return "addAtComplain";
	}
	
	/**
	 * 客户投诉信息业务新增
	 * @throws Exception 
	 * */
	public String addAtComplainInfo() throws Exception
	{
		rst = atComplainService.addAtComplain(atComplain);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtComplainList();
	}
	
	/**
	 * 跳转至客户投诉信息修改页面
	 * @throws Exception 
	 * */
	public String toModAtComplainPage() throws Exception
	{
		this.setCmd(1);
		this.setAtComplain(atComplainService.queryDetailInfo(atComplain.getId()));
		return "modAtComplain";
	}
	
	/**
	 * 客户投诉信息修改业务
	 * @throws Exception 
	 * */
	public String modAtComplainInfo() throws Exception
	{
		rst = atComplainService.modAtComplain(atComplain);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtComplainList();
	}

	/**
	 * 查询当前客户投诉信息列表
	 * @throws Exception 
	 * */
	public String queryAtComplainList() throws Exception
	{
		this.setAtComplainList(atComplainService.queryListByPage(atComplain, page));
		return "atComplainList";
	}
	
	/**
	 * 查询当前客户投诉信息详情
	 * @throws Exception 
	 * */
	public String atComplainDetail() throws Exception
	{
		this.setCmd(2);
		this.setAtComplain(atComplainService.queryDetailInfo(atComplain.getId()));
		return "atComplainDetail";
	}

	/**
	 * 删除当前客户投诉信息
	 * @throws Exception 
	 * */
	public String delAtComplainInfo() throws Exception
	{
		rst = atComplainService.delAtComplain(atComplain.getId());
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtComplainList();
	}

	/**
	 * 改变投诉记录状态
	 * @throws Exception 
	 */
	public int changeCnStatus() throws Exception{
		return atComplainService.changeCnStatus(atComplain);
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public String findAll(){
		this.setAtComplainList(atComplainService.findAll());
		return "atComplainList";
	}

	
	public AtComplainService getAtComplainService() {
		return atComplainService;
	}

	public void setAtComplainService(AtComplainService atComplainService) {
		this.atComplainService = atComplainService;
	}

	public List<AtComplain> getAtComplainList() {
		return atComplainList;
	}

	public void setAtComplainList(List<AtComplain> atComplainList) {
		this.atComplainList = atComplainList;
	}

	public AtComplain getAtComplain() {
		return atComplain;
	}

	public void setAtComplain(AtComplain atComplain) {
		this.atComplain = atComplain;
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

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

}
