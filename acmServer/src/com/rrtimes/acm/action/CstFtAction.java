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
import com.rrtimes.acm.domain.AtCstFt;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AtCstFtService;

/**
 * @Title:       CstFtAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 代账客户财税信息表
 * 
 * <p>
 * 	代账客户财税信息表
 * </p> 
 * 
 * @author lil
 * 
 */
public class CstFtAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6971725650803784366L;

	@Resource
	private AtCstFtService acfs;
	
	private AtCstFt acf = new AtCstFt();
	
	private AtUser atUser = new AtUser();
	
	private List<AtCstFt> list = new ArrayList<AtCstFt>();
	
	private PageObject page = new PageObject();
	
	private int rst;
	
	private int cmd;
	
	private String msg;
	
	//分页
	public String listpage(){
		list = acfs.queryUser(acf, page);
		return "listpage";
	}
	
	//打开新增页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//打开修改页面
	public String modify(){
		setCmd(1);
		setAcf(acfs.queryUserById(acf.getId()));
		return "add";
	}
	
	//新增
	public String insertCstft(){
		rst = acfs.addUser(acf);
		if(rst == 0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		return listpage();
	}
	
	//修改
	public String updateCstft(){
		rst = acfs.updateUser(acf);
		if(rst == 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return listpage();
	}
	
	//删除
	public String deleteCstft(){
		rst = acfs.deleteUser(acf.getId());
		if(rst == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		return listpage();
	}

	//根据用户查看该用户下的客户的财税信息
	public String findByUserId(){
		list = acfs.queryByUserId(atUser.getId());
		return "list";
	}
	
	public AtCstFt getAcf() {
		return acf;
	}

	public void setAcf(AtCstFt acf) {
		this.acf = acf;
	}

	public List<AtCstFt> getList() {
		return list;
	}

	public void setList(List<AtCstFt> list) {
		this.list = list;
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

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}
}
