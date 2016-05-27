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
import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.service.AcmSysOrgService;
import com.rrtimes.acm.service.AtUserService;

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
	
	//分页查询（查询当前代账公司的组织机构）
	public String list(){
		list = asos.queryAll(aso.getCpCode());
		return "list";
	}
	
	//通过组织机构oid查询当前的下级
	public String juniorlist(){
		list = asos.queryOrgByOid(aso.getOid());
		return "juniorlist";
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
	public String orgDetail(){
		setCmd(1);
		aso = asos.queryOrgById(aso.getId());
		return "add";
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
