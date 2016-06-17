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
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtSysModelService;

/**
 * @Title:       AtSysModelAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 菜单附属功能字典Action
 * 
 * <p>
 * 	菜单附属功能字典Action
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtSysModelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7876249535771971554L;
	
	@Resource
	private AtSysModelService atSysModelService;
	
	private List<AtSysModel> atSysModelList = new ArrayList<AtSysModel>();
	
	private AtSysModel atSysModel = new AtSysModel();
	
	private PageObject page = new PageObject();
	
	//要删除的IDS
	private int[] ids;
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst = 1;
	//消息
	private String msg = "";
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	/**
	 * 跳转至菜单附属功能字典新增页面
	 * 
	 * */
	public String toAddAtSysModelPage(){
		this.setCmd(0);
		return "addAtSysModel";
	}
	
	/**
	 * 菜单附属功能字典新增
	 * @throws Exception 
	 * */
	public String addAtCstFeeInfo() throws Exception
	{
		rst = atSysModelService.addAtSysModel(atSysModel);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "新增操作已成功。";
		}else{
			msg = "新增操作未成功。";
		}
		this.page.setCurrentPage(1);
		return queryAtSysModelList();
	}
	
	
	/**
	 * 跳转至菜单附属功能字典修改页面
	 * @throws Exception 
	 * 
	 * */
	public String toModAtSysModelPage() throws Exception{
		this.setCmd(1);
		this.setAtSysModel(atSysModelService.queryDetailInfo(atSysModel.getId()));
		return "modAtSysModel";
	}
	
	/**
	 * 修改菜单附属功能字典
	 * @throws Exception 
	 * */
	public String modAtSysModelInfo() throws Exception
	{
		rst = atSysModelService.modAtSysModel(atSysModel);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "修改操作已成功。";
		}else{
			msg = "修改操作未成功。";
		}
		return queryAtSysModelList();
	}
	
	/**
	 * 根据主键ID删除菜单附属功能
	 * @return
	 * @throws Exception 
	 */
	public int delAtSysModelById() throws Exception{
		return atSysModelService.delAtSysModel(atSysModel);
	}
	
	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	public String batchDeleteAtSysModel() throws Exception{
		rst = atSysModelService.batchDeleteAtSysModel(ids);
		// 设置界面提示信息
		if( rst == 0 ){
			msg = "删除操作已成功。";
		}else{
			msg = "删除操作未成功。";
		}
		return queryAtSysModelList();
	}
	
	/**
	 * 查询菜单附属功能字典详情
	 * @throws Exception 
	 * 
	 * */
	public AtSysModel queryDetailInfo() throws Exception{
		return atSysModelService.queryDetailInfo(atSysModel.getId());
	}
	
	/**
	 * 查询当前菜单附属功能字典列表
	 * @throws Exception 
	 * */
	public String queryAtSysModelList() throws Exception
	{
		this.setAtSysModelList(atSysModelService.queryListByPage(atSysModel, page));
		return "atSysModelList";
	}
	
	/**
	 * 根据菜单树ID查询菜单附属功能
	 * @param treeId
	 * @return
	 * @throws Exception 
	 */
	public List<AtSysModel> getAtSysModelByTreeId() throws Exception{
		return atSysModelService.getAtSysModelByTreeId(atSysModel.getTreeId());
	}
	
	/**
	 * 查询所有数据
	 * @return
	 * @throws Exception 
	 */
	public String findAll() throws Exception{
//		this.setAtSysModelList(atSysModelService.findAll());
//		return "atSysModelList";
		return queryAtSysModelList();
	}
	
	
	
	public AtSysModelService getAtSysModelService() {
		return atSysModelService;
	}

	public void setAtSysModelService(AtSysModelService atSysModelService) {
		this.atSysModelService = atSysModelService;
	}

	public List<AtSysModel> getAtSysModelList() {
		return atSysModelList;
	}

	public void setAtSysModelList(List<AtSysModel> atSysModelList) {
		this.atSysModelList = atSysModelList;
	}

	public AtSysModel getAtSysModel() {
		return atSysModel;
	}

	public void setAtSysModel(AtSysModel atSysModel) {
		this.atSysModel = atSysModel;
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
