/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AtCsrBasic;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCsrBasicService;

/**
 * @Title:       AtCsrBasicAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 代账客户基本信息表
 * 
 * <p>
 * 	代账客户基本信息表
 * </p> 
 * 
 * @author lil
 * 
 */
public class AtCsrBasicAction extends ActionSupport{
	
	
	@Resource
	private AtCsrBasicService asoservice;
	
	private static final long serialVersionUID = 1L;
	
    private AtCsrBasic aso = new AtCsrBasic();
    
    private PageObject page = new PageObject();
    
    private List<AtCsrBasic> asoList = new ArrayList<AtCsrBasic>();
	
	private String file;
	
	private AtUser atUser = new AtUser();          //用户Id
	
	private AtCsrBasic acb = new AtCsrBasic();
	
	private int cmd;
	
	private int rst;

	private String msg;
	
	
	//组织机构分页查询
	public String userList(){
		asoList = asoservice.queryUser(aso, page);
		return "list";
	}
		
	//导入用户
	public String importUser(){
		try {
			String filepath = new String( file.getBytes("ISO8859-1"), "UTF-8" );
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(filepath));
			asoservice.importUser(br,Integer.parseInt(aso.getCpCode()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "suc";
	} 
		
		//根据客户信息表id查询客户信息、合同信息、客户财税信息
		public String query(){
			aso = asoservice.queryBasicById(aso.getId());
			return "query";
		}
		
		//打开新增页面
		public String add(){
			setCmd(0);
			return "add";
		}
		
		//打开修改页面
		public String modify(){
			setCmd(1);
			setAcb(asoservice.queryUserById(acb.getId()));
			return "add";
		}
		
		//新增客户信息
		public String insertUser(){
			rst = asoservice.addUser(aso);
			if(rst == 0){
				setMsg("新增成功");
			}else{
				setMsg("新增失败");
			}
			return userList();
		}
		
		//修改客户信息
		public String update(){
			rst = asoservice.updateUser(aso);
			if(rst == 0){
				setMsg("修改成功");
			}else{
				setMsg("修改失败");
			}
			return userList();
		}
		
		//删除客户信息
		public String delete(){
			rst = asoservice.deleteUser(aso.getId());
			if(rst == 0){
				setMsg("删除成功");
			}else{
				setMsg("删除失败");
			}
			return userList();
		}
		
		//根据用户Id查询需要跟进的客户的个数
		public void getCountByUserId(){
			int count = asoservice.queryCountByUserId(atUser.getId());
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
		
       
		//根据部门用户查询客户信息
		public String findBasicByUser(){
			asoList = asoservice.queryBasicByUser(atUser.getId(),page);
			return "queryBasicByUser";
		}
		
		//根据代账公司查询客户信息
		public String findBasicByAgent(){
			asoList = asoservice.queryBasicByAgent(atUser.getCpCode(),page);
			return "queryBasicByAgent";
		}
		
		//根据部门查询客户信息
		public String findBasicByOrg(){
			asoList = asoservice.queryBasicByOrg(atUser.getOid(),page);
			return "queryBasicByOrg";
		}
		
		
		public AtUser getAtUser() {
			return atUser;
		}

		public void setAtUser(AtUser atUser) {
			this.atUser = atUser;
		}
		public PageObject getPage() {
			return page;
		}

		public void setPage(PageObject page) {
			this.page = page;
		}

		public List<AtCsrBasic> getAsoList() {
			return asoList;
		}

		public void setAsoList(List<AtCsrBasic> asoList) {
			this.asoList = asoList;
		}
		

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}
		
		public AtCsrBasic getAso() {
			return aso;
		}

		public void setAso(AtCsrBasic aso) {
			this.aso = aso;
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
		public int getRst() {
			return rst;
		}

		public void setRst(int rst) {
			this.rst = rst;
		}

		public AtCsrBasic getAcb() {
			return acb;
		}

		public void setAcb(AtCsrBasic acb) {
			this.acb = acb;
		}
}
