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

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.AtCompanyAgent;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.AtUserGroupRel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AcmSysOrgService;
import com.rrtimes.acm.serviceI.AtUserGroupRelService;
import com.rrtimes.acm.serviceI.AtUserService;

/**
 * @Title:       SysUserAction.java
 * @Package:     com.rrtimes.acm.action
 * @Description: 用户组、用户综合信息表
 * 
 * <p>
 * 	用户组、用户综合信息表
 * </p> 
 * 
 * @author lil
 * 
 */
public class SysUserAction extends ActionSupport{
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954363164266848728L;
	@Resource
	private AtUserService aus;
	
	@Resource 
	private AtUserGroupRelService augrs;
	
	@Resource
	private AcmSysOrgService asoservice;
	
	@Resource
	private AtUserGroupRelService augls;
	
	@Resource
	private AcmSysOrgService asos;

	private AtUser atUser = new AtUser();
	
	private AtCompanyAgent aca = new AtCompanyAgent();
	
	private AcmSysOrg aso = new AcmSysOrg();
	
	private AtUserGroupRel augl = new AtUserGroupRel();
	
	private PageObject page = new PageObject();
	
	private List<AtUser> list = new ArrayList<AtUser>();
	
	private List<AcmSysOrg> orglist = new ArrayList<AcmSysOrg>();
	
	private AcmSysOrg org = new AcmSysOrg();
	
	private int rst;
	
	private int cmd;
	
	private String msg;
	
    private String oldpwd;
    
    private String ids;
    

	private String atUserId;
	
	private String orgId;
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	//登录
	public String login(){
		int resultint = aus.queryByUser(atUser).getResult();
		
		if(resultint==1){
			return "error";
		}else{
			return "success";
		}
	}
    
	//根据用户账号查询所属部门的人员信息
	public String findUserByMap(){
		list = aus.queryUserByMap(atUser);
		return "list";
	}
	
	//新增用户
	public String insertUser(){
		if(StringUtils.isEmpty(atUserId)){
			boolean result = aus.queryByInameToinsert(atUser.getIname());
			if(result){//不存在相同登录账号
				AtUser au = (AtUser)session.getAttribute("atUser");
				atUser.setCpCode(au.getCpCode());
				atUser.setIsUsed(0);
				atUser.setItype(1);
				atUser.setIsAdmin(0);
				atUser.setStatus(0);
				atUser.setOperator(String.valueOf(au.getId()));
				rst = aus.addUser(atUser);
				int id = aus.queryByIname(atUser.getIname());
				augl.setUid(id);
				augls.insert(augl);
				if(rst==0){
					msg="新增成功";
				}else{
					msg="新增失败";
				}
			}else{
				msg="新增失败";
			}
			return queryBycpCode();
		}else{
			return update();
		}
	}
	
	//新增组织机构
		public String insertOrg(){
				AtUser au = (AtUser)session.getAttribute("atUser");
				org.setCpCode(au.getCpCode());
				org.setOperator(String.valueOf(au.getId()));
				if(org.getId()>0){
					rst=asos.updateOrg(org);
					if(rst==0){
						msg="修改成功";
					}else{
						msg="修改失败";
					}
				}else{
					rst=asos.addOrg(org);
					if(rst==0){
						msg="新增成功";
					}else{
						msg="新增失败";
					}
				}
				return queryBycpCode();
		}
	//删除org
		public String deleteOrg(){
			rst=asos.deleteOrg(org.getId());
			List<AcmSysOrg> alist = asos.queryOrgByOid(org.getId());
			if(alist!=null&&alist.size()!=0){//存在下级部门
				for(int i=0;i<alist.size();i++){
					asos.deleteOrg(alist.get(i).getId());
				}
			}
			if(rst==0){
				msg="删除成功";
			}else{
				msg="删除失败";
			}
			return queryBycpCode();
		}
	//新增用户校验用户名I_NAME
	public void validateforinsert(){
		boolean result = aus.queryByInameToinsert(atUser.getIname());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			int i = 0;
			if(result){
				i=1;
			}
			jo.put("status", i );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改用户
	public String update(){
		atUser.setId(Integer.parseInt(atUserId));
		AtUser au = aus.queryUserById(atUser.getId());
		au.setUserName(atUser.getUserName());
		au.setSex(atUser.getSex());
		au.setEmail(atUser.getEmail());
		au.setTelno(atUser.getTelno());
		au.setOid(atUser.getOid());
		au.setIname(atUser.getIname());
		au.setWorkerNo(atUser.getWorkerNo());
		au.setJobDuty(atUser.getJobDuty());
		au.setLoginPwd(atUser.getLoginPwd());
		au.setRemark(atUser.getRemark());
		rst=aus.updateUser(au);
		augl.setUid(atUser.getId());
		augls.updateByUid(augl);
		if(rst==0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		return queryBycpCode();
	}
	
	//修改用户校验用户名I_NAME
	public void validateforupdate(){
		boolean result = aus.queryByInameToupdate(atUser.getIname(), atUser.getId());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			int i = 0;
			if(result){
				i=1;
			}
			jo.put("status", i );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//删除用户
	public String delete(){
			rst= aus.deleteUser(atUser.getId());
			augrs.delete(atUser.getId());
			if(rst==0){
				msg="删除成功";
			}else{
				msg="删除失败";
			}
			return queryBycpCode();
	}
	
	//批量删除用户
	public String deletemore(){
		String[] id = ids.split(",");
		for(int i=0;i<id.length;i++){
			rst= aus.deleteUser(Integer.parseInt(id[i]));
			augrs.delete(Integer.parseInt(id[i]));
			if(rst==0){
				msg="删除成功";
			}else{
				msg="删除失败";
			}
		}
		return queryBycpCode();
	}
	
	//按Id查询用户
	public void findById(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			setCmd(1);
			setAtUser(aus.queryUserById(atUser.getId()));
			jo.put("atUserId", atUser.getId());
			jo.put("username", atUser.getUserName() );
			jo.put("sex", atUser.getSex());
			jo.put("email", atUser.getEmail());
			jo.put("telno", atUser.getTelno());
			jo.put("oid", atUser.getOid());
			jo.put("iname", atUser.getIname());
			jo.put("loginPwd", atUser.getLoginPwd());
			jo.put("remark", atUser.getRemark());
			jo.put("parentId", augls.queryByUserId(atUser.getId()).getGid());
			jo.put("workerNo", atUser.getWorkerNo());
			jo.put("jobDuty", atUser.getJobDuty());
			list = aus.queryjsBycpCode(atUser.getCpCode());
			JSONArray jsonArray = new JSONArray();
			for(int i=0;i<list.size();i++){
				JSONObject obj = new JSONObject();
				obj.put("id", list.get(i).getId());
				obj.put("iname", list.get(i).getIname());
				jsonArray.add(i, obj);
			}
			jo.put("orglist", jsonArray );
//			orglist = asoservice.queryAll(atUser.getCpCode());
			List<Map<String,Object>> alist = asoservice.queryAllBycpCode(atUser.getCpCode());
			JSONArray jsonArray1 = new JSONArray();
			for(int i=0;i<alist.size();i++){
				JSONObject obj = new JSONObject();
				obj.put("id", alist.get(i).get("id"));
				obj.put("orgName", alist.get(i).get("orgName"));
				obj.put("rname", alist.get(i).get("rname")==null?"":alist.get(i).get("rname"));
				obj.put("gname", alist.get(i).get("gname")==null?"":alist.get(i).get("gname"));
				jsonArray1.add(i, obj);
			}
			jo.put("deptlist", jsonArray1 );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//打开新增页面
	public String add(){
		setCmd(0);
		return "add";
	}
	
	//根据代账公司查询员工信息
	public String queryBycpCode(){
		AtUser atUser = (AtUser)session.getAttribute("atUser");
		list = aus.queryBycpCode(atUser, page);
		orglist = asos.queryAll(atUser.getCpCode());
		return "queryBycpCode";
	}
	
	//根据代账公司的一个部门Id查询员工信息
		public String findByOrgId(){
			AtUser au = (AtUser)session.getAttribute("atUser");
			list = aus.queryByOrgId(atUser.getOid(), page);
			orglist = asos.queryAll(au.getCpCode());
			//ServletActionContext.getRequest().setAttribute("orgId", atUser.getOid());
			orgId = String.valueOf(atUser.getOid());
			ServletActionContext.getRequest().setAttribute("oid", org.getOid());
			return "queryBycpCode";
		}
	
	//根据员工名称查询员工信息
		public String queryByUsername(){
			AtUser au = (AtUser)session.getAttribute("atUser");
			atUser.setCpCode(au.getCpCode());
			list = aus.queryByUsername(atUser, page);
			orglist = asos.queryAll(au.getCpCode());
			return "queryBycpCode";
		}
	
	//根据cpCode查询当前代账公司的组
	public void queryzuBycpCode(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			AtUser atUser = (AtUser)session.getAttribute("atUser");
			list = aus.queryjsBycpCode(atUser.getCpCode());
			JSONArray jsonArray = new JSONArray();
			for(int i=0;i<list.size();i++){
				JSONObject obj = new JSONObject();
				obj.put("id", list.get(i).getId());
				obj.put("iname", list.get(i).getIname());
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
	
	//根据部门查询员工信息
	public String queryByOrgId(){
		list = aus.queryByOrgId(aso.getId(), page);
		return "queryByOrgId";
	}
	
	//根据所在的代账公司查询所有角色
	public String queryjsBycpCode(){
		list = aus.queryjsBycpCode(atUser.getCpCode());
		return "queryjsBycpCode";
	}
	
	/**
	 * 首页我的桌面模块
	 * */
	public String userSet()
	{
		atUser = (AtUser)session.getAttribute("loginUser");
		org=asoservice.queryOrgById(atUser.getOid());
		return "userset";
	}
	
	//校验原始密码是否正确
	public void checkpwd(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			AtUser au = (AtUser)session.getAttribute("loginUser");
			if(oldpwd.equals(au.getLoginPwd())){//如果输入的旧密码和原始密码相同
				msg="0";
			}else{
				msg="1";
			}
			jo.put("status", msg );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改登录用户的基本信息
	public String updateuser(){
		AtUser au = (AtUser)session.getAttribute("loginUser");
		au.setIname(atUser.getIname());
		au.setSex(atUser.getSex());
		au.setEmail(atUser.getEmail());
		au.setTelno(atUser.getTelno());
		au.setOid(atUser.getOid());
		au.setRemark(atUser.getRemark());
		boolean result = aus.queryByInameToupdate(au.getIname(), au.getId());
		if(result){//如果当前用户名不重复
			int i = aus.updateUser(au);
			if(i==0){
				msg="修改成功";
			}else{
				msg="修改失败";
			}
		}
		return userSet();
	}
	
	//修改密码
	public void updatepassword(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out;
			JSONObject jo = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			AtUser au = (AtUser)session.getAttribute("loginUser");
			au.setLoginPwd(atUser.getLoginPwd());
			int i = aus.updateUser(au);
			if(i==0){//修改成功
				msg="0";
			}else{
				msg="1";
			}
			jo.put("status", msg );
			out = response.getWriter();
			out.print(jo);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AtUser getAtUser() {
		return atUser;
	}

	public void setAtUser(AtUser atUser) {
		this.atUser = atUser;
	}
	public List<AtUser> getList() {
		return list;
	}

	public void setList(List<AtUser> list) {
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

	public AtCompanyAgent getAca() {
		return aca;
	}

	public void setAca(AtCompanyAgent aca) {
		this.aca = aca;
	}

	public AcmSysOrg getAso() {
		return aso;
	}

	public void setAso(AcmSysOrg aso) {
		this.aso = aso;
	}

	public PageObject getPage() {
		return page;
	}

	public void setPage(PageObject page) {
		this.page = page;
	}

	public AcmSysOrg getOrg() {
		return org;
	}

	public void setOrg(AcmSysOrg org) {
		this.org = org;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public AtUserGroupRel getAugl() {
		return augl;
	}

	public void setAugl(AtUserGroupRel augl) {
		this.augl = augl;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<AcmSysOrg> getOrglist() {
		return orglist;
	}

	public void setOrglist(List<AcmSysOrg> orglist) {
		this.orglist = orglist;
	}
	
    public String getAtUserId() {
		return atUserId;
	}

	public void setAtUserId(String atUserId) {
		this.atUserId = atUserId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
