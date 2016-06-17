/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtCstReportDict;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCstReportDictService;

/**
 * @Title:       CstReportDictAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 财务报表字典表
 * 
 * <p>
 * 	财务报表字典表
 * </p> 
 * 
 * @author lil
 * 
 */
public class CstReportDictAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7742011831117189203L;
	
	@Resource
	private AtCstReportDictService acrds;
	
	private AtCstReportDict acrd = new AtCstReportDict();
	
	private List<AtCstReportDict> list = new ArrayList<AtCstReportDict>();
	
	private PageObject page = new PageObject();
	
	private int rst;
	
	private int cmd;
	
	private String msg;
	
	//分页查询
	public String listpage(){
		list = acrds.queryByMap(acrd, page);
		return "listpage";
	}
	
	//打开新增财税报表字典表页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//新增财税字典信息
	public String insertReport(){
		rst = acrds.insert(acrd);
		if(rst==0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		return listpage();
	}

	//打开修改财税报表页面
	public String modify(){
		setCmd(1);
		setAcrd(acrds.queryById(acrd.getId()));
		return "add";
	}
	
	//修改财税报表信息
	public String update(){
		rst = acrds.update(acrd);
		if(rst == 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return listpage();
	}
	
	//删除财税报表信息
	public String delete(){
		rst = acrds.delete(acrd.getId());
		if(rst == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		return listpage();
	}
	
	public AtCstReportDict getAcrd() {
		return acrd;
	}

	public void setAcrd(AtCstReportDict acrd) {
		this.acrd = acrd;
	}

	public List<AtCstReportDict> getList() {
		return list;
	}

	public void setList(List<AtCstReportDict> list) {
		this.list = list;
	}

	public int getRst() {
		return rst;
	}

	public void setRst(int rst) {
		this.rst = rst;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public PageObject getPage() {
		return page;
	}

	public void setPage(PageObject page) {
		this.page = page;
	}
}
