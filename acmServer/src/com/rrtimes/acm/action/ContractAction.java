/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtCstContract;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.service.AtCstContractService;

/**
 * @Title:       ContractAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public class ContractAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7320042623097266831L;
	
	@Resource 
	private AtCstContractService accs;
	
	private AtCstContract acc = new AtCstContract();
	
	private List<AtCstContract> list = new ArrayList<AtCstContract>();
	
	private PageObject page = new PageObject();
	
	private AtUser atUser;
	
	private int day;
	
	//分页查询
	public String pagelist(){
		list = accs.queryUser(acc, page);
		return "pagelist";
	}

	//新增合同
	@SuppressWarnings("unused")
	public String add(){
		int i = accs.addUser(acc);
		return "add";
	}
	
	//修改合同
	@SuppressWarnings("unused")
	public String update(){
		int i = accs.updateUser(acc);
		return "update";
	}
	
	//删除合同
	@SuppressWarnings("unused")
	public String delete(){
		int i = accs.deleteUser(acc.getId());
		return "delete";
	}
	
	//根据Id查询合同
	public String findById(){
		acc = accs.queryUserById(acc.getId());
		return "findById";
	}
	
	//通过用户Id查询需要预警的合同信息
	public String findContractByUserIdAndDay(){
		list = accs.queryContractByUserIdAndDay(atUser.getId(), day);
		return "findContractByUserIdAndDay";
	}
	
	//通过用户Id查询到期的合同
	public String findContractByUserId(){
		list = accs.queryContractByUserId(atUser.getId());
		return "findContractByUserId";
	}
	
	//通过用户Id查询欠费的合同信息
	public String findQFByUserId(){
		list = accs.queryQFByUserId(atUser.getId());
		return "findQFByUserId";
	}
		
	//通过用户Id查询将要付费的合同（月付）
	public String findMonthContractByUserId(){
		list = accs.queryMonthContractByUserId(atUser.getId(), day);
		return "findMonthContractByUserId";
	}
	
	//通过用户Id查询需要预警的合同信息的个数
	public void findContractCountByUserIdAndDay(){
		int count = accs.queryContractCountByUserIdAndDay(atUser.getId(), day);
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("count", count );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//通过用户Id查询到期的合同的个数
	public void findContractCountByUserId(){
		int count = accs.queryContractCountByUserId(atUser.getId());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("count", count );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//通过用户Id查询将要付费的合同（月付）的个数
	public void queryMonthContractCountByUserId(){
		int count = accs.queryMonthContractCountByUserId(atUser.getId(), day);
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("count", count );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//通过用户Id查询欠费的合同信息的个数
	public void queryQFCountByUserId(){
		int count = accs.queryQFCountByUserId(atUser.getId());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("count", count );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AtCstContract getAcc() {
		return acc;
	}

	public void setAcc(AtCstContract acc) {
		this.acc = acc;
	}

	public List<AtCstContract> getList() {
		return list;
	}

	public void setList(List<AtCstContract> list) {
		this.list = list;
	}

	public PageObject getPage() {
		return page;
	}

	public void setPage(PageObject page) {
		this.page = page;
	}

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
