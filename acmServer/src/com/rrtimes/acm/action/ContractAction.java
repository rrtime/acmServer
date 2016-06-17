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
import com.rrtimes.acm.domain.AtCsrBasic;
import com.rrtimes.acm.domain.AtCstContract;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCstContractService;

/**
 * @Title:       ContractAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 代账客户合同信息表
 * 
 * <p>
 * 	代账客户合同信息表
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
	
	private AtCsrBasic acb = new AtCsrBasic();
	
	private List<AtCstContract> list = new ArrayList<AtCstContract>();
	
	private PageObject page = new PageObject();
	
	private AtUser atUser;
	
	private int day;
	
	private int cmd;
	
	private int rst;
	
	private String msg;
	
	//分页查询
	public String pagelist(){
		list = accs.queryUser(acc, page);
		return "pagelist";
	}

	//新增合同
	public String insertContract(){
		rst = accs.addUser(acc);
		if(rst == 0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		return pagelist();
	}
	
	//修改合同
	public String update(){
		rst = accs.updateUser(acc);
		if(rst == 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return pagelist();
	}
	
	//删除合同
	public String delete(){
		rst = accs.deleteUser(acc.getId());
		if(rst == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		return pagelist();
	}
	
	//打开新增页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//根据Id查询合同
	public String findById(){
		setCmd(1);
		setAcc(accs.queryUserById(acc.getId()));
		return "add";
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
	//根据客户编号查询合同记录
	public String queryByBasicId(){
		list = accs.queryByBasicId(acb.getCsrIdentifer());
		return "suc";
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

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
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

	public AtCsrBasic getAcb() {
		return acb;
	}

	public void setAcb(AtCsrBasic acb) {
		this.acb = acb;
	}
}
