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
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtCstVisit;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCstVisitService;

/**
 * @Title:       AtCstVisitAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 客户回访记录Action
 * 
 * <p>
 * 	客户回访记录Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstVisitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816396458785170132L;

	@Resource
	private AtCstVisitService atCstVisitService;
	
	private List<AtCstVisit> atCstVisitList = new ArrayList<AtCstVisit>();
	
	private AtCstVisit atCstVisit = new AtCstVisit();
	
	private PageObject page = new PageObject();
	
	//要删除的回访记录IDS
	private int[] ids;
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	
	/**
	 * 跳转至客户回访记录新增页面
	 * */
	public String toAddAtCstVisitPage()
	{
		this.setCmd(0);
		return "addAtCstVisit";
	}
	
	/**
	 * 客户回访记录业务新增
	 * @throws Exception 
	 * */
	public String addAtCstVisitInfo() throws Exception
	{
		atCstVisit.setCnTime(new Date());
		rst = atCstVisitService.addAtCstVisit(atCstVisit);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtCstVisitList();
	}
	
	/**
	 * 跳转至客户回访记录修改页面
	 * @throws Exception 
	 * */
	public String toModAtCstVisitPage() throws Exception
	{
		this.setCmd(1);
		this.setAtCstVisit(atCstVisitService.queryDetailInfo(atCstVisit.getId()));
		return "modAtCstVisit";
	}
	
	/**
	 * 客户回访记录修改业务
	 * @throws Exception 
	 * */
	public String modAtCstVisitInfo() throws Exception
	{
		rst = atCstVisitService.modAtCstVisit(atCstVisit);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtCstVisitList();
	}

	/**
	 * 查询当前客户回访记录列表
	 * @throws Exception 
	 * */
	public String queryAtCstVisitList() throws Exception
	{
		this.setAtCstVisitList(atCstVisitService.queryListByPage(atCstVisit, page));
		return "atCstVisitList";
	}
	
	/**
	 * 查询当前客户回访记录详情
	 * @throws Exception 
	 * */
	public String atCstVisitDetail() throws Exception
	{
		this.setCmd(2);
		this.setAtCstVisit(atCstVisitService.queryDetailInfo(atCstVisit.getId()));
		return "atCstVisitDetail";
	}

	/**
	 * 删除当前客户回访记录
	 * @throws Exception 
	 * */
	public String delAtCstVisitInfo() throws Exception
	{
		rst = atCstVisitService.delAtCstVisit(atCstVisit.getId());
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtCstVisitList();
	}
	
	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public String batchDeleteAtCstVisit() throws Exception{
		rst = atCstVisitService.batchDeleteAtCstVisit(ids);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtCstVisitList();
	}

	/**
	 * 分页查询
	 * @return
	 * @throws Exception 
	 */
	public List<AtCstVisit> queryAtCstVisitListForPage() throws Exception{
		return atCstVisitService.queryListByPage(atCstVisit, page);
	}

	/**
	 * 查询所有数据
	 * @return
	 */
	public String findAll() throws Exception {
//		this.setAtCstVisitList(atCstVisitService.findAll());
//		return "atCstVisitList";
		return queryAtCstVisitList();
	}
	
	
	public AtCstVisitService getAtCstVisitService() {
		return atCstVisitService;
	}

	public void setAtCstVisitService(AtCstVisitService atCstVisitService) {
		this.atCstVisitService = atCstVisitService;
	}

	public List<AtCstVisit> getAtCstVisitList() {
		return atCstVisitList;
	}

	public void setAtCstVisitList(List<AtCstVisit> atCstVisitList) {
		this.atCstVisitList = atCstVisitList;
	}

	public AtCstVisit getAtCstVisit() {
		return atCstVisit;
	}

	public void setAtCstVisit(AtCstVisit atCstVisit) {
		this.atCstVisit = atCstVisit;
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

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
}
