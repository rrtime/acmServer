/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    zl 			| 	create the file                       
 */
package com.rrtimes.acm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.AtComplain;
import com.rrtimes.acm.domain.AtCsrBasic;
import com.rrtimes.acm.domain.AtCstContract;
import com.rrtimes.acm.domain.AtCstFee;
import com.rrtimes.acm.domain.AtCstFt;
import com.rrtimes.acm.domain.AtCstImy;
import com.rrtimes.acm.domain.AtCstVisit;
import com.rrtimes.acm.domain.AtUser;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.serviceI.AcmSysOrgService;
import com.rrtimes.acm.serviceI.AtComplainService;
import com.rrtimes.acm.serviceI.AtCsrBasicService;
import com.rrtimes.acm.serviceI.AtCstContractService;
import com.rrtimes.acm.serviceI.AtCstFeeService;
import com.rrtimes.acm.serviceI.AtCstFtService;
import com.rrtimes.acm.serviceI.AtCstImyService;
import com.rrtimes.acm.serviceI.AtCstVisitService;

import net.sf.json.JSONArray;

/**
 * @Title: RoleAction.java
 * @Package: com.rrtimes.acm.action
 * @Description: 客户综合管理
 * 
 * @author zl
 * 
 */
public class CustomerAction extends ActionSupport {

	private static final long serialVersionUID = 2954363164266848728L;
	
	@Resource
	private AcmSysOrgService orgService;

	@Resource
	private AtCsrBasicService csrBasicService;
	
	@Resource
	private AtCstFtService cstFtService;
	
	@Resource
	private AtCstFeeService cstFeeService;
	
	@Resource
	private AtCstVisitService cstVisitService;
	
	@Resource
	private AtComplainService complainService;
	
	@Resource
	private AtCstImyService cstImyService;
	
	@Resource
	private AtCstContractService cstContractService;
	
	//分页对象
	private PageObject page = new PageObject();
	
	//部门对象
	private AcmSysOrg sysOrg = new AcmSysOrg();
	
	//客户对象
	private AtCsrBasic csrBasic = new AtCsrBasic();
	
	//财税对象
	private AtCstFt cstFt = new AtCstFt();
	
	//收费对象
	private AtCstFee cstFee = new AtCstFee();
	
	//合同对象
	private AtCstContract cstContract = new AtCstContract();
	
	//回访对象
	private AtCstVisit cstVisit = new AtCstVisit();
	
	//投诉对象
	private AtComplain complain = new AtComplain();
	
	//质量赔付对象
	private AtCstImy cstImy = new AtCstImy();

	// 部门列表
	private List<AcmSysOrg> orgList = new ArrayList<AcmSysOrg>();
	
	// 客户列表
	private List<AtCsrBasic> csrList = new ArrayList<AtCsrBasic>();

	//返回前台字段串
	private String msg;
	
	//部门ID
	private int orgId;
	
	//客户ID
	private int cstId;
	
	//搜索关键字
	private String keyword;
	
	//财务报表ID数组
	private int[] rids;

	//定义并取得会话对象
	HttpSession session = ServletActionContext.getRequest().getSession();

	
	/**
	 * 客户管理首页
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");		
		//根据当前用户所在公司编码取得部门列表
		orgList = orgService.queryAll(loginUser.getCpCode());		
		//设置人员编码查询条件
		if(keyword != null){
			csrBasic.setCsrIdentifer(keyword);
		}
		//判断当前是否有选择的部门取得客户列表
		if(orgId > 0){
			//根据部门ID取得客户列表
			csrList = csrBasicService.queryBasicByOrg(orgId, csrBasic, page);
		}else{
			//根据代帐公司ID取得客户列表
			csrList = csrBasicService.queryBasicByAgent(loginUser.getCpCode(), csrBasic , page);
		}
		
		//返回前台页面
		return "list";
	}
	
	/**
	 * 新增客户及财税信息
	 * @return
	 * @throws Exception
	 */
	public String addCustomer() throws Exception{
		//验证名称是否存在 不存在返回false 存在返回true
		boolean validateResult = csrBasicService.isexistbasic(csrBasic.getCsrIdentifer());
		//判断验证结果
		if(validateResult == true){
			//设置返回信息
			msg="新客户失败，客户编码已经存在!";
		}else{
			//取得当前登录用户信息
			AtUser loginUser = (AtUser) session.getAttribute("loginUser");
			//完善客户对象的其它字段以方便入库
			csrBasic.setCpCode(loginUser.getCpCode());
			csrBasic.setOperator(String.valueOf(loginUser.getId()));
			//完善财税对象的其它字段以方便入库
			//判断前台是否提交报表ID
			if(null != rids && rids.length > 0){
				StringBuilder sb = new StringBuilder();
				for(int id : rids){
					sb.append(id);
					sb.append(":");
				}
				sb.replace(sb.length()-1, sb.length(), "");
				cstFt.setRids(sb.toString());
			}else{
				cstFt.setRids("");
			}
			cstFt.setCsrIdentifer(csrBasic.getCsrIdentifer());
			cstFt.setOperator(String.valueOf(loginUser.getId()));
			//设置财税对象
			csrBasic.setAcf(cstFt);
			//返回新增的角色ID
			int rst = csrBasicService.addbasicAndcsrft(csrBasic);
			
			//判断返回结果
			if(rst == 0){
				msg="新增客户成功";
			}else{
				//设置返回信息
				msg="新增失败";
			}
		}
		//刷新信息
		list();
		//返回前台页面
		return "list";
	}
	
	/**
	 * 新增收费信息
	 * @return
	 * @throws Exception
	 */
	public String addFee() throws Exception{
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//完善收费对象的其它字段以方便入库
		cstFee.setOperator(String.valueOf(loginUser.getId()));
		//取得操作结果
		int rst = cstFeeService.addAtCstFee(cstFee);
		
		//判断返回结果
		if(rst == 0){
			msg="新增收费信息成功";
		}else{
			//设置返回信息
			msg="新增失败";
		}
		
		//刷新信息
		list();
		//返回前台页面
		return "list";
	}
	
	/**
	 * ajax保存合同信息
	 * @return
	 * @throws Exception
	 */
	public void updContract() throws Exception{
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//完善合同对象的其它字段以方便入库
		cstContract.setOperator(String.valueOf(loginUser.getId()));
		//判断是新增还是修改 id大于0是修改否则是新增
		if(cstContract.getId() > 0){
			//取得操作结果
			int rst = cstContractService.updateContract(cstContract);
			//判断返回结果
			if(rst == 0){
				msg="修改合同成功";
			}else{
				//设置返回信息
				msg="修改失败";
			}
		}else{
			//取得操作结果
			int rst = cstContractService.addContract(cstContract);
			//判断返回结果
			if(rst == 0){
				msg="新增合同成功";
			}else{
				//设置返回信息
				msg="新增失败";
			}
		}	
		
		//返回JSON对象  
        HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(msg);
	}
	
	/**
	 * 新增回访信息
	 * @return
	 * @throws Exception
	 */
	public String addVisit() throws Exception{
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//完善合同对象的其它字段以方便入库
		cstVisit.setCpCode(loginUser.getCpCode());
		cstVisit.setOperator(String.valueOf(loginUser.getId()));
		//取得操作结果
		int rst = cstVisitService.addAtCstVisit(cstVisit);
		
		//判断返回结果
		if(rst == 0){
			msg="新增回访信息成功";
		}else{
			//设置返回信息
			msg="新增失败";
		}
		
		//刷新信息
		list();
		//返回前台页面
		return "list";
	}
	
	/**
	 * 新增投诉信息
	 * @return
	 * @throws Exception
	 */
	public String addComplain() throws Exception{
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//完善投诉对象的其它字段以方便入库
		complain.setCpCode(loginUser.getCpCode());
		complain.setOperator(String.valueOf(loginUser.getId()));
		//取得操作结果
		int rst = complainService.addAtComplain(complain);
		
		//判断返回结果
		if(rst == 0){
			msg="新增投诉信息成功";
		}else{
			//设置返回信息
			msg="新增失败";
		}
		
		//刷新信息
		list();
		//返回前台页面
		return "list";
	}
	
	/**
	 * 新增质量赔付信息
	 * @return
	 * @throws Exception
	 */
	public String addImy() throws Exception{
		//取得当前登录用户信息
		AtUser loginUser = (AtUser) session.getAttribute("loginUser");
		//完善质量赔付对象的其它字段以方便入库
		cstImy.setCpCode(loginUser.getCpCode());
		cstImy.setOperator(String.valueOf(loginUser.getId()));
		//取得操作结果
		int rst = cstImyService.addAtCstImy(cstImy);
		
		//判断返回结果
		if(rst == 0){
			msg="新增质量赔付信息成功";
		}else{
			//设置返回信息
			msg="新增失败";
		}
		
		//刷新信息
		list();
		//返回前台页面
		return "list";
	}
	
	/**
	 * ajax获取收费历史信息
	 * @return
	 * @throws Exception
	 */
	public void getFeeHis() throws Exception{
		//取得收费历史列表
		List<AtCstFee> feeList = cstFeeService.queryListByPage(cstFee, page);
		//将list转化成JSON对象  
        JSONArray jsonArray = JSONArray.fromObject(feeList);  
        HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jsonArray);

	}
	
	/**
	 * ajax获取合同历史信息
	 * @return
	 * @throws Exception
	 */
	public void getContractHis() throws Exception{
		//取得合同列表
		List<AtCstContract> contractList = cstContractService.queryByBasicId(csrBasic.getCsrIdentifer());
		//将list转化成JSON对象  
        JSONArray jsonArray = JSONArray.fromObject(contractList);  
        HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jsonArray);

	}
	
	/**
	 * ajax根据合同ID查询合同信息
	 * @return
	 * @throws Exception
	 */
	public void getContractById() throws Exception{
		//取得合同信息
		AtCstContract contract = cstContractService.queryContractById(cstContract.getId());
		//将list转化成JSON对象  
        JSONArray jsonArray = JSONArray.fromObject(contract);  
        HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jsonArray);

	}


	public AtCsrBasic getCsrBasic() {
		return csrBasic;
	}


	public void setCsrBasic(AtCsrBasic csrBasic) {
		this.csrBasic = csrBasic;
	}


	public List<AtCsrBasic> getCsrList() {
		return csrList;
	}


	public void setCsrList(List<AtCsrBasic> csrList) {
		this.csrList = csrList;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getOrgId() {
		return orgId;
	}


	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}


	public int getCstId() {
		return cstId;
	}


	public void setCstId(int cstId) {
		this.cstId = cstId;
	}


	public AcmSysOrg getSysOrg() {
		return sysOrg;
	}


	public void setSysOrg(AcmSysOrg sysOrg) {
		this.sysOrg = sysOrg;
	}


	public List<AcmSysOrg> getOrgList() {
		return orgList;
	}


	public void setOrgList(List<AcmSysOrg> orgList) {
		this.orgList = orgList;
	}


	public PageObject getPage() {
		return page;
	}


	public void setPage(PageObject page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public AtCstFt getCstFt() {
		return cstFt;
	}

	public void setCstFt(AtCstFt cstFt) {
		this.cstFt = cstFt;
	}

	public AtCstFee getCstFee() {
		return cstFee;
	}

	public void setCstFee(AtCstFee cstFee) {
		this.cstFee = cstFee;
	}

	public AtCstVisit getCstVisit() {
		return cstVisit;
	}

	public void setCstVisit(AtCstVisit cstVisit) {
		this.cstVisit = cstVisit;
	}

	public AtComplain getComplain() {
		return complain;
	}

	public void setComplain(AtComplain complain) {
		this.complain = complain;
	}

	public AtCstImy getCstImy() {
		return cstImy;
	}

	public void setCstImy(AtCstImy cstImy) {
		this.cstImy = cstImy;
	}

	public int[] getRids() {
		return rids;
	}

	public void setRids(int[] rids) {
		this.rids = rids;
	}

	public AtCstContract getCstContract() {
		return cstContract;
	}

	public void setCstContract(AtCstContract cstContract) {
		this.cstContract = cstContract;
	}
	
}
