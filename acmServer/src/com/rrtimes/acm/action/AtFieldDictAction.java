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
import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtFieldDictService;

/**
 * @Title:       AtFieldDictAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 系统权限字段字典Action
 * 
 * <p>
 * 	系统权限字段字典Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtFieldDictAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 888506304636319670L;

	@Resource
	private AtFieldDictService atFieldDictService;
	
	private List<AtFieldDict> atFieldDictList = new ArrayList<AtFieldDict>();
	
	private AtFieldDict atFieldDict = new AtFieldDict();
	
	private AtSysModel atSysModel = new AtSysModel();
	
	private PageObject page = new PageObject();
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	/**
	 * 跳转至系统权限字段字典新增页面
	 * 
	 * */
	public String toAddAtFieldDict(){
		this.setCmd(0);
		return "addAtFieldDict";
	}
	
	/**
	 * 系统权限字段字典新增
	 * @throws Exception 
	 * */
	public String addAtFieldDictInfo() throws Exception
	{
		rst = atFieldDictService.addAtFieldDict(atFieldDict);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtFieldDictList();
	}
	
	
	/**
	 * 跳转至系统权限字段字典修改页面
	 * @throws Exception 
	 * 
	 * */
	public String toModAtFieldDictPage() throws Exception{
		this.setCmd(1);
		this.setAtFieldDict(atFieldDictService.queryDetailInfo(atFieldDict.getId()));
		return "modAtFieldDict";
	}
	
	/**
	 * 修改系统权限字段字典
	 * @throws Exception 
	 * */
	public String modAtFieldDictInfo() throws Exception
	{
		rst = atFieldDictService.modAtFieldDict(atFieldDict);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtFieldDictList();
	}
	
	/**
	 * 根据主键ID删除系统权限字段字典
	 * @return
	 * @throws Exception 
	 */
	public int delAtFieldDictById() throws Exception{
		return atFieldDictService.delAtFieldDict(atFieldDict.getId());
	}
	
	/**
	 * 查询系统权限字段字典详情
	 * @throws Exception 
	 * 
	 * */
	public AtFieldDict queryDetailInfo(int id) throws Exception{
		return atFieldDictService.queryDetailInfo(atFieldDict.getId());
	}
	
	/**
	 * 查询当前系统权限字段字典列表
	 * @throws Exception 
	 * */
	public String queryAtFieldDictList() throws Exception
	{
		this.setAtFieldDictList(atFieldDictService.queryListByPage(atFieldDict, page));
		return "atFieldDictList";
	}
	
	/**
	 * 根据菜单树ID查询系统权限字段字典
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> findAtFieldDictByTreeId() throws Exception{
		return atFieldDictService.findAtFieldDictByTreeId(atSysModel.getTreeId());
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public String findAll(){
		this.setAtFieldDictList(atFieldDictService.findAll());
		return "atFieldDictList";
	}
	

	public AtFieldDictService getAtFieldDictService() {
		return atFieldDictService;
	}

	public void setAtFieldDictService(AtFieldDictService atFieldDictService) {
		this.atFieldDictService = atFieldDictService;
	}

	public List<AtFieldDict> getAtFieldDictList() {
		return atFieldDictList;
	}

	public void setAtFieldDictList(List<AtFieldDict> atFieldDictList) {
		this.atFieldDictList = atFieldDictList;
	}

	public AtFieldDict getAtFieldDict() {
		return atFieldDict;
	}

	public void setAtFieldDict(AtFieldDict atFieldDict) {
		this.atFieldDict = atFieldDict;
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
