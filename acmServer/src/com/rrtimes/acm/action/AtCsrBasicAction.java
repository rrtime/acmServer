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
import com.rrtimes.acm.service.AtCsrBasicService;

/**
 * @Title:       AtCsrBasicAction.java
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
public class AtCsrBasicAction extends ActionSupport{
	
	public AtCsrBasic getAso() {
		return aso;
	}

	public void setAso(AtCsrBasic aso) {
		this.aso = aso;
	}
	@Resource
	private AtCsrBasicService asoservice;
	
	private static final long serialVersionUID = 1L;
	
    private AtCsrBasic aso = new AtCsrBasic();
    
    private PageObject page = new PageObject();
    
    private List<AtCsrBasic> asoList = new ArrayList<AtCsrBasic>();
	
	private String file;
	
	private AtUser atUser = new AtUser();          //用户Id
	
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
				List<AtCsrBasic> list = new ArrayList<AtCsrBasic>();
				br = new BufferedReader(new FileReader(filepath));
	            String stemp;
	            while ((stemp = br.readLine()) != null) {
	            	   String[] str = stemp.split(",");
	            	   AtCsrBasic acb = new AtCsrBasic();
	            	   acb.setCsrType(Integer.parseInt(str[0]));
	            	   acb.setCsrIdentifer(str[1]);
	            	   acb.setCsrCode(str[2]);
	            	   acb.setRegAddress(str[3]);
	            	   acb.setOfficeAddress(str[4]);
	            	   acb.setFinanceLeader(str[5]);
	            	   acb.setTaxLeader(str[6]);
	            	   acb.setOperator(str[7]);
	            	   acb.setRemark(str[8]);
	                   list.add(acb);
	            }
				asoservice.importUser(list,Integer.parseInt(aso.getCpCode()));
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
		
		//新增客户信息
		@SuppressWarnings("unused")
		public String add(){
			int i = asoservice.addUser(aso);
			return "add";
		}
		
		//修改客户信息
		@SuppressWarnings("unused")
		public String update(){
			int i = asoservice.updateUser(aso);
			return "update";
		}
		
		//删除客户信息
		@SuppressWarnings("unused")
		public String delete(){
			int i = asoservice.deleteUser(aso.getId());
			return "delete";
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
		
		//根据用户Id查询需要跟进的客户
		public String getListByUserId(){
			asoList = asoservice.queryBasicByUserId(atUser.getId());
			return "getListByUserId";
		}

		public AtUser getAtUser() {
			return atUser;
		}

		public void setAtUser(AtUser atUser) {
			this.atUser = atUser;
		}
}
