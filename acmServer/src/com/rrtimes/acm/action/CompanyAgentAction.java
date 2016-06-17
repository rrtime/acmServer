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
import com.rrtimes.acm.domain.AtCompanyAgent;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCompanyAgentService;

/**
 * @Title:       CompanyAgentAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 代账机构信息表
 * 
 * <p>
 * 	代账机构信息表
 * </p> 
 * 
 * @author lil
 * 
 */
public class CompanyAgentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134175154403750461L;
	
	@Resource
	private AtCompanyAgentService acas;
	
	private AtCompanyAgent atCompanyAgent = new AtCompanyAgent();
	
	private PageObject page = new PageObject();
	
	private List<AtCompanyAgent> list = new ArrayList<AtCompanyAgent>();
	
	// 插入、修改、删除业务处理结果( 0 成功, 1 失败 )
	private int rst;
	
	private String msg = "";
	
	// 0 新增  1 修改  2 查看详情
	private int cmd = 0;
	
	
	
	//分页查询
	public String page(){
		list = acas.queryByPage(atCompanyAgent, page);
		return "page";
	}
    
	//新增代账机构
	public String add(){
		rst = acas.insert(atCompanyAgent);
		if(rst == 0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		return page();
	}
	
	//修改代账机构
	public String update(){
		rst = acas.update(atCompanyAgent);
		if(rst == 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return page();
	}
	
	//删除代账机构
	public String delete(){
		rst = acas.delete(atCompanyAgent.getId());
		if(rst == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		return page();
	}
	
	//按Id查询代账机构
	public String companyDetail(){
		cmd=1;
		atCompanyAgent = acas.queryById(atCompanyAgent.getId());
		return "findById";
	}
	
	public String queryBycpCode(){
		atCompanyAgent = acas.queryBycpCode(atCompanyAgent.getCpCode());
		return "queryBycpCode";
	}
	public AtCompanyAgent getAtCompanyAgent() {
		return atCompanyAgent;
	}

	public void setAtCompanyAgent(AtCompanyAgent atCompanyAgent) {
		this.atCompanyAgent = atCompanyAgent;
	}

	public PageObject getPage() {
		return page;
	}

	public void setPage(PageObject page) {
		this.page = page;
	}

	public List<AtCompanyAgent> getList() {
		return list;
	}

	public void setList(List<AtCompanyAgent> list) {
		this.list = list;
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
