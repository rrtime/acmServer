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
import com.rrtimes.acm.domain.AtSysNotice;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.service.AtSysNoticeService;

/**
 * @Title:       NoticeAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 系统通知公告表
 * 
 * <p>
 * 	系统通知公告表
 * </p> 
 * 
 * @author lil
 * 
 */
public class NoticeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5574417888196705136L;
	
	@Resource
	private AtSysNoticeService asns;
	
	private AtSysNotice atSysNotice = new AtSysNotice();
	
	private AtUser atUser = new AtUser();
	
	private List<AtSysNotice> list = new ArrayList<AtSysNotice>();
	
	private int rst;
	
	private int cmd;
	
	private String msg;
	
	//查询当前用户创建并已发布的通知公告
	public String findGnoticeByUserId(){
		list = asns.queryGnoticeByUserId(atUser.getId());
		return "glist";
	}
    
	//查询当前用户创建的通知
	public String findTnoticeByUserId(){
		list = asns.queryTnoticeByUserId(atUser.getId());
		return "tlist";
	}
	
	//查询已发布的通知公告中当前用户可以查看的
	public String findNoticeByGUserId(){
		list = asns.queryNoticeByGUserId(atUser.getId());
		return "listg";
	}
	
	//查询已发布的通知中当前用户可以查看的
	public String findNoticeByTUserId(){
		list = asns.queryNoticeByTUserId(atUser.getId());
		return "listt";
	}
	
	//查询撤回的通知公告
	public String findCGnoticeByUserId(){
		list = asns.queryCGnoticeByUserId(atUser.getId());
		return "cglist";
	}
	
	//查询撤回的通知
	public String findCTnoticeByUserId(){
		list = asns.queryCTnoticeByUserId(atUser.getId());
		return "ctlist";
	}
	
	//打开新增页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//新增
	public void addNotice(){
		rst = asns.insert(atSysNotice);
		if(rst == 0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("msg", msg );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改通知、公告
	public void updateNotice(){
		rst = asns.update(atSysNotice);
		if(rst == 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("msg", msg );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//打开修改页面
	public String modify(){
		setCmd(1);
		setAtSysNotice(asns.queryById(atSysNotice.getId()));
		return "add";
	}
	
	//删除通知、公告
	public void deleteNotice(){
		rst = asns.delete(atSysNotice.getId());
		if(rst == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			jo.put("msg", msg );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AtSysNotice getAtSysNotice() {
		return atSysNotice;
	}

	public void setAtSysNotice(AtSysNotice atSysNotice) {
		this.atSysNotice = atSysNotice;
	}

	public List<AtSysNotice> getList() {
		return list;
	}

	public void setList(List<AtSysNotice> list) {
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

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

}
