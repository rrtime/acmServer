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
import com.rrtimes.acm.service.AtCstVisitService;

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
	 * */
	public String addAtCstVisitInfo()
	{
		try{
			atCstVisit.setCnTime(new Date());
			rst = atCstVisitService.addAtCstVisit(atCstVisit);
			// 设置界面提示信息
			if( rst == 0 ){
				msg = "新增操作已成功。";
			}else{
				msg = "新增操作未成功。";
			}
			this.page.setCurrentPage(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return queryAtCstVisitList();
	}
	
	/**
	 * 跳转至客户回访记录修改页面
	 * */
	public String toModAtCstVisitPage()
	{
		this.setCmd(1);
		this.setAtCstVisit(atCstVisitService.queryDetailInfo(atCstVisit.getId()));
		return "modAtCstVisit";
	}
	
	/**
	 * 客户回访记录修改业务
	 * */
	public String modAtCstVisitInfo()
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
	 * */
	public String queryAtCstVisitList()
	{
		this.setAtCstVisitList(atCstVisitService.queryListByPage(atCstVisit, page));
		return "atCstVisitList";
	}
	
	/**
	 * 查询当前客户回访记录详情
	 * */
	public String atCstVisitDetail()
	{
		this.setCmd(2);
		this.setAtCstVisit(atCstVisitService.queryDetailInfo(atCstVisit.getId()));
		return "atCstVisitDetail";
	}

	/**
	 * 删除当前客户回访记录
	 * */
	public String delAtCstVisitInfo()
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
	 * 分页查询
	 * @return
	 */
	public List<AtCstVisit> queryAtCstVisitListForPage(){
		return atCstVisitService.queryListByPage(atCstVisit, page);
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
	
}
