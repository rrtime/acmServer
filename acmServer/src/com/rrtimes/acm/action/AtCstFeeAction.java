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
import com.rrtimes.acm.domain.AtCstFee;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCstFeeService;

/**
 * @Title:       AtCstFeeAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 客户收费记录Action
 * 
 * <p>
 * 	客户收费记录Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstFeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6381869100144104364L;

	@Resource
	private AtCstFeeService atCstFeeService;
	
	private List<AtCstFee> atCstFeeList = new ArrayList<AtCstFee>();
	
	private AtCstFee atCstFee = new AtCstFee();
	
	private PageObject page = new PageObject();
	
	//要删除的收费记录IDS
	private int[] ids;
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	//提前提醒天数
	private int days;
	
	
	/**
	 * 跳转至客户收费记录新增页面
	 * */
	public String toAddAtCstFeePage()
	{
		this.setCmd(0);
		return "addAtCstFee";
	}
	
	/**
	 * 客户收费记录业务新增
	 * @throws Exception 
	 * */
	public String addAtCstFeeInfo() throws Exception
	{
		rst = atCstFeeService.addAtCstFee(atCstFee);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtCstFeeList();
	}
	
	/**
	 * 跳转至客户收费记录修改页面
	 * @throws Exception 
	 * */
	public String toModAtCstFeePage() throws Exception
	{
		this.setCmd(1);
		this.setAtCstFee(atCstFeeService.queryDetailInfo(atCstFee.getId()));
		return "modAtCstFee";
	}
	
	/**
	 * 客户收费记录修改业务
	 * @throws Exception 
	 * */
	public String modAtCstFeeInfo() throws Exception
	{
		rst = atCstFeeService.modAtCstFee(atCstFee);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtCstFeeList();
	}

	/**
	 * 查询当前收费记录列表
	 * @throws Exception 
	 * */
	public String queryAtCstFeeList() throws Exception
	{
		this.setAtCstFeeList(atCstFeeService.queryListByPage(atCstFee, page));
		return "atCstFeeList";
	}
	
	/**
	 * 查询当前收费记录详情
	 * @throws Exception 
	 * */
	public String atCstFeeDetail() throws Exception
	{
		this.setCmd(2);
		this.setAtCstFee(atCstFeeService.queryDetailInfo(atCstFee.getId()));
		return "atCstFeeDetail";
	}

	/**
	 * 删除当前收费记录
	 * @throws Exception 
	 * */
	public String delAtCstFeeInfo() throws Exception
	{
		rst = atCstFeeService.delAtCstFee(atCstFee.getId());
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtCstFeeList();
	}
	
	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public String batchDeleteAtCstFee() throws Exception{
		rst = atCstFeeService.batchDeleteAtCstFee(ids);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtCstFeeList();
	}

	/**
	 * 分页查询
	 * @return
	 * @throws Exception 
	 */
	public List<AtCstFee> queryAtCstFeeListForPage() throws Exception{
		return atCstFeeService.queryListByPage(atCstFee, page);
	}
	
	/**
	 * 查询所有的客户收费记录
	 * @return
	 * @throws Exception 
	 */
	public String queryAllFeeList() throws Exception{
//		return atCstFeeService.findAll();
		return queryAtCstFeeList();
	}
	
	/**
	 * 提醒客户缴费或续费列表
	 * @return
	 * @throws Exception 
	 */
	public List<AtCstFee> getRemindFeeList() throws Exception{
		return atCstFeeService.getRemindFeeList(days, atCstFee.getOperator());
	}
	
	/**
	 * 统计收费提醒数量
	 * @return
	 * @throws Exception 
	 */
	public int countRemindFee() throws Exception{
		return atCstFeeService.countRemindFee(days, atCstFee.getOperator());
	}
	
	public AtCstFeeService getAtCstFeeService() {
		return atCstFeeService;
	}

	public void setAtCstFeeService(AtCstFeeService atCstFeeService) {
		this.atCstFeeService = atCstFeeService;
	}

	public AtCstFee getAtCstFee() {
		return atCstFee;
	}

	public void setAtCstFee(AtCstFee atCstFee) {
		this.atCstFee = atCstFee;
	}

	public List<AtCstFee> getAtCstFeeList() {
		return atCstFeeList;
	}

	public void setAtCstFeeList(List<AtCstFee> atCstFeeList) {
		this.atCstFeeList = atCstFeeList;
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
}
