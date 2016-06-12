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
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtModelFunctionService;

/**
 * @Title:       AtModelFunctionAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 功能详细操作字典Action
 * 
 * <p>
 * 	功能详细操作字典Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtModelFunctionAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7428694998849140835L;

	@Resource
	private AtModelFunctionService atModelFunctionService;
	
	private List<AtModelFunction> atModelFunctionList = new ArrayList<AtModelFunction>();
	
	private AtModelFunction atModelFunction = new AtModelFunction();
	
	private PageObject page = new PageObject();
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	/**
	 * 跳转至功能详细操作字典新增页面
	 * 
	 * */
	public String toAddAtModelFunctionPage(){
		this.setCmd(0);
		return "addAtModelFunction";
	}
	
	/**
	 * 功能详细操作字典新增
	 * @throws Exception 
	 * */
	public String addAtModelFunctionInfo() throws Exception
	{
		rst = atModelFunctionService.addAtModelFunction(atModelFunction);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtModelFunctionList();
	}
	
	/**
	 * 跳转至功能详细操作字典修改页面
	 * @throws Exception 
	 * 
	 * */
	public String toModAtModelFunctionPage() throws Exception{
		this.setCmd(1);
		this.setAtModelFunction(atModelFunctionService.queryDetailInfo(atModelFunction.getId()));
		return "modAtModelFunction";
	}
	
	/**
	 * 修改功能详细操作字典
	 * @throws Exception 
	 * 
	 * */
	public String modAtModelFunctionInfo() throws Exception
	{
		rst = atModelFunctionService.modAtModelFunction(atModelFunction);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtModelFunctionList();
	}
	
	/**
	 * 查询当前功能详细操作字典列表
	 * @throws Exception 
	 * */
	public String queryAtModelFunctionList() throws Exception
	{
		this.setAtModelFunctionList(atModelFunctionService.queryListByPage(atModelFunction, page));
		return "atModelFunctionList";
	}

	/**
	 * 删除功能详细操作字典
	 * @throws Exception 
	 * 
	 * */
	public int delAtModelFunction() throws Exception{
		return atModelFunctionService.delAtModelFunction(atModelFunction);
	}
	
	/**
	 * 查询功能详细操作字典详情
	 * @throws Exception 
	 * 
	 * */
	public AtModelFunction queryDetailInfo() throws Exception{
		return atModelFunctionService.queryDetailInfo(atModelFunction.getId());
	}
	
	/**
	 * 查询功能详细操作字典列表(分页)
	 * @throws Exception 
	 * 
	 * */
	public List<AtModelFunction> queryListByPage() throws Exception{
		return atModelFunctionService.queryListByPage(atModelFunction,page);
	}
	
	/**
	 * 根据menuCode查询功能详细操作字典
	 * @param menuCode
	 * @throws Exception 
	 */
	public List<AtModelFunction> findModelFunctionByMenuCode() throws Exception{
		return atModelFunctionService.findModelFunctionByMenuCode(atModelFunction.getMenuCode());
	}
	
	/**
	 * 根据treeId查询功能详细操作字典
	 * @param treeId
	 * @throws Exception 
	 */
	public List<Map<String,Object>> findModelFunctionByTreeId() throws Exception{
		return atModelFunctionService.findModelFunctionByTreeId(atModelFunction.getTreeId());
	}
	
	/**
	 * 查找所有数据
	 * @return
	 */
	public String findAll(){
		this.setAtModelFunctionList(atModelFunctionService.findAll());
		return "atModelFunctionList";
	}
	

	public AtModelFunctionService getAtModelFunctionService() {
		return atModelFunctionService;
	}

	public void setAtModelFunctionService(
			AtModelFunctionService atModelFunctionService) {
		this.atModelFunctionService = atModelFunctionService;
	}

	public List<AtModelFunction> getAtModelFunctionList() {
		return atModelFunctionList;
	}

	public void setAtModelFunctionList(List<AtModelFunction> atModelFunctionList) {
		this.atModelFunctionList = atModelFunctionList;
	}

	public AtModelFunction getAtModelFunction() {
		return atModelFunction;
	}

	public void setAtModelFunction(AtModelFunction atModelFunction) {
		this.atModelFunction = atModelFunction;
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
