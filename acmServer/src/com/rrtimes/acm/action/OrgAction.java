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
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.serviceI.AcmSysOrgService;
import com.rrtimes.acm.serviceI.AtUserService;

/**
 * @Title:       OrgAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 组织机构表
 * 
 * <p>
 * 	组织机构表
 * </p> 
 * 
 * @author lil
 * 
 */
public class OrgAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3516230737058979706L;
	@Resource
	private AcmSysOrgService asos;
	
	private AcmSysOrg aso = new AcmSysOrg();
	
	private AtUser atUser = new AtUser();
	
	private List<AcmSysOrg> list = new ArrayList<AcmSysOrg>();
	
	private int cmd;
	
	private int rsd;
	
	private String msg;
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	//查询（查询当前代账公司的组织机构）
	public String list(){
		list = asos.queryAll(aso.getCpCode());
		return "list";
	}
	
	//查询当前代账公司的组织机构
	public void querydeptBycpCode(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			AtUser atUser = (AtUser)session.getAttribute("atUser");
			//list = asos.queryAll(atUser.getCpCode());
			List<Map<String,Object>> alist = asos.queryAllBycpCode(atUser.getCpCode());
			JSONArray jsonArray = new JSONArray();
			for(int i=0;i<alist.size();i++){
				JSONObject obj = new JSONObject();
				obj.put("id", alist.get(i).get("id"));
				obj.put("orgName", alist.get(i).get("orgName"));
				obj.put("rname", alist.get(i).get("rname")==null?"":alist.get(i).get("rname"));
				obj.put("gname", alist.get(i).get("gname")==null?"":alist.get(i).get("gname"));
				jsonArray.add(i, obj);
			}
			jo.put("jsonlist", jsonArray );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//通过组织机构oid查询当前的下级
	public void juniorlist(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			JSONArray jsonArray = new JSONArray();
			if(aso.getOid()>0){
				//需要查询上一级是否是第二级
				AcmSysOrg orgn = asos.queryOrgById(aso.getOid());
				if(orgn.getOid()==0){
					list = asos.queryOrgByOid(0);
					for(int i=0;i<list.size();i++){
						JSONObject obj = new JSONObject();
						obj.put("id", list.get(i).getId());
						obj.put("orgName", list.get(i).getOrgName());
						jsonArray.add(i, obj);
					}
					jo.put("jsonlist", jsonArray );
					jo.put("status", 0);
				}else{
					AtUser atUser = (AtUser)session.getAttribute("atUser");
					list = asos.querysecondlevel(atUser.getCpCode());
					for(int i=0;i<list.size();i++){
						JSONObject obj = new JSONObject();
						obj.put("id", list.get(i).getId());
						obj.put("orgName", list.get(i).getOrgName());
						jsonArray.add(i, obj);
					}
					jo.put("jsonlist", jsonArray );
					jo.put("status", 0);
				}
			}else if(aso.getOid()==0){
				jo.put("jsonlist", "公司组织架构" );
				jo.put("status", 1);
			}
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//新增组织机构页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//新增组织机构
	public String insert(){
		rsd = asos.addOrg(aso);
		if(rsd==0){
			msg="新增成功";
		}else{
			msg="新增失败";
		}
		return list();
	}
	
	//删除组织机构
	public String delete(){
		rsd = asos.deleteOrg(aso.getId());
		if(rsd == 0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		return list();
	}
	
	//查询to修改
	public void orgDetail(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			aso = asos.queryOrgById(aso.getId());
			jo.put("orgName", aso.getOrgName() );
			jo.put("orgDesc", aso.getOrgDesc() );
			jo.put("orgId", aso.getId() );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改自治机构
	public String update(){
		rsd = asos.updateOrg(aso);
		if(rsd==0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return list();
	}
	
	public AcmSysOrg getAso() {
		return aso;
	}

	public void setAso(AcmSysOrg aso) {
		this.aso = aso;
	}

	public List<AcmSysOrg> getList() {
		return list;
	}

	public void setList(List<AcmSysOrg> list) {
		this.list = list;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}

	public int getRsd() {
		return rsd;
	}

	public void setRsd(int rsd) {
		this.rsd = rsd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
