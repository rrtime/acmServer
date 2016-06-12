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
import com.rrtimes.acm.domain.AtCstImy;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCstImyService;

/**
 * @Title:       AtCstImyAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 客户质量赔付记录Action
 * 
 * <p>
 * 	客户质量赔付记录Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstImyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816396458785170132L;

	@Resource
	private AtCstImyService atCstImyService;
	
	private List<AtCstImy> atCstImyList = new ArrayList<AtCstImy>();
	
	private AtCstImy atCstImy = new AtCstImy();
	
	private PageObject page = new PageObject();
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	
	/**
	 * 跳转至客户质量赔付记录新增页面
	 * */
	public String toAddAtCstImyPage()
	{
		this.setCmd(0);
		return "addAtCstImy";
	}
	
	/**
	 * 客户客户质量赔付记录业务新增
	 * @throws Exception 
	 * */
	public String addAtCstImyInfo() throws Exception
	{
		rst = atCstImyService.addAtCstImy(atCstImy);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtCstImyList();
	}
	
	/**
	 * 跳转至客户质量赔付记录修改页面
	 * @throws Exception 
	 * */
	public String toModAtCstImyPage() throws Exception
	{
		this.setCmd(1);
		this.setAtCstImy(atCstImyService.queryDetailInfo(atCstImy.getId()));
		return "modAtCstImy";
	}
	
	/**
	 * 客户质量赔付记录修改业务
	 * @throws Exception 
	 * */
	public String modAtCstImyInfo() throws Exception
	{
		rst = atCstImyService.modAtCstImy(atCstImy);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtCstImyList();
	}

	/**
	 * 查询当前客户质量赔付记录列表
	 * @throws Exception 
	 * */
	public String queryAtCstImyList() throws Exception
	{
		this.setAtCstImyList(atCstImyService.queryListByPage(atCstImy, page));
		return "atCstVisitList";
	}
	
	/**
	 * 查询当前客户质量赔付记录详情
	 * @throws Exception 
	 * */
	public String atCstImyDetail() throws Exception
	{
		this.setCmd(2);
		this.setAtCstImy(atCstImyService.queryDetailInfo(atCstImy.getId()));
		return "atCstImyDetail";
	}

	/**
	 * 删除当前客户质量赔付记录
	 * @throws Exception 
	 * */
	public String delAtCstImyInfo() throws Exception
	{
		rst = atCstImyService.delAtCstImy(atCstImy.getId());
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtCstImyList();
	}

	/**
	 * 分页查询
	 * @return
	 * @throws Exception 
	 */
	public List<AtCstImy> queryAtCstImyListForPage() throws Exception{
		return atCstImyService.queryListByPage(atCstImy, page);
	}

	/**
	 * 改变质量赔付的状态
	 * @return
	 * @throws Exception 
	 */
	public int changeImyStatus() throws Exception{
		return atCstImyService.changeImyStatus(atCstImy);
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public String findAll(){
		this.setAtCstImyList(atCstImyService.findAll());
		return "atCstVisitList";
	}
	
	public AtCstImyService getAtCstImyService() {
		return atCstImyService;
	}

	public void setAtCstImyService(AtCstImyService atCstImyService) {
		this.atCstImyService = atCstImyService;
	}

	public List<AtCstImy> getAtCstImyList() {
		return atCstImyList;
	}

	public void setAtCstImyList(List<AtCstImy> atCstImyList) {
		this.atCstImyList = atCstImyList;
	}

	public AtCstImy getAtCstImy() {
		return atCstImy;
	}

	public void setAtCstImy(AtCstImy atCstImy) {
		this.atCstImy = atCstImy;
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
