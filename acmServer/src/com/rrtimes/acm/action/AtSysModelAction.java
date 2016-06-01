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
import com.rrtimes.acm.service.AtSysModelService;

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
	 * */
	public String addAtCstFeeInfo()
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
	 * 
	 * */
	public String toModAtSysModelPage(){
		this.setCmd(1);
		this.setAtSysModel(atSysModelService.queryDetailInfo(atSysModel.getId()));
		return "modAtSysModel";
	}
	
	/**
	 * 修改菜单附属功能字典
	 * */
	public String modAtSysModelInfo()
	{
		try{
			rst = atSysModelService.modAtSysModel(atSysModel);
			// 设置界面提示信息
			if( rst == 0 ){
				msg = "修改操作已成功。";
			}else{
				msg = "修改操作未成功。";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return queryAtSysModelList();
	}
	
	/**
	 * 根据主键ID删除菜单附属功能
	 * @return
	 */
	public int delAtSysModelById(){
		return atSysModelService.delAtSysModel(atSysModel);
	}
	
	/**
	 * 查询菜单附属功能字典详情
	 * 
	 * */
	public AtSysModel queryDetailInfo(){
		return atSysModelService.queryDetailInfo(atSysModel.getId());
	}
	
	/**
	 * 查询当前菜单附属功能字典列表
	 * */
	public String queryAtSysModelList()
	{
		this.setAtSysModelList(atSysModelService.queryListByPage(atSysModel, page));
		return "atSysModelList";
	}
	
	/**
	 * 根据菜单树ID查询菜单附属功能
	 * @param treeId
	 * @return
	 */
	public List<AtSysModel> getAtSysModelByTreeId(){
		return atSysModelService.getAtSysModelByTreeId(atSysModel.getTreeId());
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

	
}
