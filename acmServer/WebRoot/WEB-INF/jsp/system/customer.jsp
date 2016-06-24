<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="utf-8">
<!doctype html>
<title>客户管理</title>
<link rel="stylesheet" href="<%=path%>/css/rest.css" />
<link rel="stylesheet" href="<%=path%>/css/easyTree.css" />

<link rel="stylesheet" href="<%=path%>/css/anagement.css" />
<link rel="stylesheet" href="<%=path%>/css/public.css" />
<link rel="stylesheet" href="<%=path%>/css/customer.css" />

<link rel="stylesheet" href="<%=path%>/css/dialog.css" />

</head>
<body>
	<!--total-role start-->
		<div class="total-role">
			<div class="role-definite">
				<h2 class="role-word">部门</h2>
				<div class="opera">
					<!--tree-modal start-->
					<div class="tree-modal">
						<div class="system-role">
							<a href="#">部门</a>
						</div>
						<div class="tree-box easy-tree">
							<ul class="tree-list">
								<li>
									<ul class="sort-a">
										<s:iterator value="#request.orgList" id="orgList">
										<li>
											<s:if test="#orgList.id==orgId">
												<a class="se" href="customer!list.do?orgId=<s:property value="#orgList.id"/>"><s:property value="#orgList.orgName"/></a>
											</s:if>
											<s:else>
												<a href="customer!list.do?orgId=<s:property value="#orgList.id"/>"><s:property value="#orgList.orgName"/></a>
											</s:else>
										</li>
										</s:iterator>
									</ul>
								</li>
							</ul>
						</div>
					</div>
					<!--tree-modal end-->
				</div>
			</div>
			<div class="role-list role-list1">
				<div class="find-opera find-opera1">
					<input class="bunt" type="button" value="新建客户" />
					<input type="button" value="导入导出" />
					<form id="searchFrom" method="post" />
					<input type="hidden" name="orgId" value='<s:property value="orgId"/>' />
					<div class="search search1">
						<ul>
							<li><input type="text" id="keyword" name="keyword" value='<s:property value="keyword"/>' /></li>
							<li><input id="searchBtn" type="button" value="搜索" placeholder="请输入用户名或编号" /></li>
						</ul>
					</div>
					</form>
				</div>
				<div style="clear:both;"></div>
				<div class="w_mian">
					<ul class="ul">
						<li class="current">常用操作</li>
						<li>收费</li>
					</ul>
					<table id="table" class="table">
						<tr class="tab-title">
							<th width="5%" align="center">ID</th>
							<th width="10%" align="center">客户编号</th>
							<th width="35%" align="center">客户名称</th>
							<th class="last-child" width="65%" align="right">
								<div class="tab-change">
									<span>进度</span>
								</div>
								<div class="tab-change tab-bottom">
									<ul class="examine">
										<li>
											<span class="blue-squ"></span>已审核收费
										</li>
										<li>
											<span class="orange-squ"></span> 未审核收费
										</li>
										<li class="last-li">
											<span class="grey-squ"></span>未收费
										</li>
									</ul>
								</div>
							</th>
						</tr>
						<s:iterator value="#request.csrList" id="csrList" status="st">
						<tr>
							<td align="center"><s:property value="#st.index+1"/></td>
							<td align="center"><s:property value="#csrList.csrIdentifer"/></td>
							<td align="center"><s:property value="#csrList.csrName"/></td>
							<td style="display:none">
							<select id='cst_ac_<s:property value="#csrList.id"/>'>
							<option value="0">无投诉</option>
							<s:iterator value="#csrList.ac" id="acList">
							<option value='<s:property value="#acList.id"/>'><s:property value="#acList.cnTheme"/></option>
							</s:iterator>
							</select>
							</td>
							<td align="right">
								<div class="tab-change">
									<input type="hidden" id="cst_csrName_<s:property value="#csrList.id"/>" value='<s:property value="#csrList.csrName"/>' />
									<input type="hidden" id="cst_csrOwner_<s:property value="#csrList.id"/>" value='<s:property value="#csrList.csrOwner"/>' />
									<input type="hidden" id="cst_csrIdentifer_<s:property value="#csrList.id"/>" value='<s:property value="#csrList.csrIdentifer"/>' />
									<input onclick="visit(<s:property value="#csrList.id"/>)" class="w_input w_input" type="button" value="回访" />
									<input onclick="complain(<s:property value="#csrList.id"/>)" class="w_input w_input" type="button" value="投诉" />
									<input onclick="imy(<s:property value="#csrList.id"/>)" class="w_input w_input" type="button" value="质量赔付" />
								</div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" onclick='fee_his(<s:property value="#csrList.id"/>)' type="button" value="收费历史" class="click1" />
									<s:if test="#csrList.acc.size() > 0">
										<input type="hidden" id="cst_acc_<s:property value="#csrList.id"/>" value='<s:property value="#csrList.acc[0].id"/>' />
										<input style="float:right;margin-left:5px;" onclick="fee(<s:property value="#csrList.id"/>)" class="click" type="button" value="收费" />
									</s:if>
									<input style="float:right;margin-left:5px;background:#0088CC;color:#fff;" onclick="contract_his(<s:property value="#csrList.id"/>,<s:property value="#csrList.csrIdentifer"/>)" type="button" value="合同" class="click" />
									<div class="num" style="float:left;">
										<ul class="tab-ul" style="min-width:265px;">
											<li class="tab1-pic2 right"><img class="w_li" src="<%=path%>/images/tab-pic2.png" alt="" /></li>
											<li class="tabl-pic1 right"><img src="<%=path%>/images/tab-pic1.png" alt="" /></li>
											<li><a href="#">12</a></li>
											<li><a href="#">11</a></li>
										</ul>
										<ul class="tab-copy">
											<li><a href="#">10</a></li>
											<li><a href="#">9</a></li>
											<li><a href="#">8</a></li>
											<li><a href="#">7</a></li>
											<li><a href="#">6</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">1</a></li>
										</ul>
									</div>
								</div>
							</td>
						</tr>
						</s:iterator>
						
						
						
					</table>
				</div>
				<div style="clear:both;"></div>
				<!--底部-->
				<form id="queryfrom" method="post" action="customer!list.do">
				<input type="hidden" name="orgId" value='<s:property value="orgId"/>' />
				<input type="hidden" name="keyword" value='<s:property value="keyword"/>' />
				<input type="hidden" id="currentPage" name="page.currentPage" value="<s:property value="#request.page.currentPage"/>"/>
    			<input type="hidden" id="totalPage" value="<s:property value="#request.page.totalPage"/>"/>
		        <div class="footer">
		            <input type="button" value="首页" onclick="mSub('index')">
		            <input type="button" value="上一页" onclick="mSub('pr')">
		            <span class="span">${page.currentPage }</span>
		            <input type="button" value="下一页" onclick="mSub('next')">
		            <input type="button" value="尾页" onclick="mSub('end')">
		            <b>总${page.sumCloum}条，共${page.totalPage }页，每页</b>
		            <select name="">
		                <option value="">25</option>
		                <option value="">50</option>
		                <option value="">100</option>
		            </select>
		            <b>到第</b>
		            <span>2</span>
		            <input class="button"type="button" value="确定">
		        </div>
		        </form>
			</div>
		</div>
		<!--total-role end-->
		<!--售后管理-->
		<div class="total total1">
			<div class="lways">
				<h1 class="h1">
					售后管理
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<ul class="w_ul w_l">
					<li id="tab_hf" class="current">回访</li>
					<li id="tab_ts">投诉</li>
					<li id="tab_zlpf">质量赔付</li>
				</ul>
				<div>
					<div class="w_con w_cone">
						<form id="visitAddForm" method="post">
						<input type="hidden" name="cstVisit.cnIdentifer" id="visit_cnIdentifer" value="" />
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>回访客户人员：</th>
									<td><input type="text" id="visit_customer" name="cstVisit.cnCustomer" /></td>
									<th align="right">回访方式：</th>
									<td class="td">
										<select name="cstVisit.cnType">
										<option value="1">微信</option>
										<option value="2">电话</option>
										<option value="3">QQ</option>
										<option value="4">其它</option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">回访联系方式：</th>
									<td><input type="text" name="cstVisit.cnContact" /></td>
									<th align="right">回访时间：</th>
									<td><input type="text" name="cstVisit.cnTime" value="2016-06-20 12:20:01" /></td>
								</tr>
								<tr>
									<th align="right">回放结果：</th>
									<td class="td">
										<select name="cstVisit.cnResult">
										<option value="0">满意</option>
										<option value="1">一般</option>
										<option value="2">不满意</option>
									</select>
									</td>
									<th align="right"></th>
									<td class="td">
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>回访内容：</lable>
							<textarea name="cstVisit.cnContent" rows="" cols=""></textarea>
						</div>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="cstVisit.remark" rows="" cols=""></textarea>
						</div>
						<input id="visitAddBtn" class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
						</form>
					</div>
					<div class="w_con w_cone" style="display: none">
						<form id="complainAddForm" method="post">
						<input type="hidden" name="complain.csrIdentifer" id="complain_cnIdentifer" value="" />
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>投诉来源：</th>
									<td class="td">
										<select name="complain.cnFrom">
										<option value="1">主动投诉</option>
										<option value="2">回访时投诉</option>
									</select>
									</td>
									<th align="right">投诉方式：</th>
									<td class="td">
										<select name="complain.cnType">
										<option value="1">微信</option>
										<option value="2">电话</option>
										<option value="3">QQ</option>
										<option value="4">其它</option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right"><span>*</span>投诉主题：</th>
									<td>
										<input type="text" id="complain_cnTheme" name="complain.cnTheme" />
									</td>
									<th align="right">投诉当前处理人：</th>
									<td><input type="text" name="complain.cnOpt" /></td>
								</tr>
								<tr>
									<td colspan="4">
									<div class="textarea" style="margin-left:32px;">
										<lable>投诉内容：</lable>
										<textarea name="complain.cnContent" rows="" cols=""></textarea>
									</div>
									</td>
								</tr>
								<tr>
									<td colspan="4">
									<div class="textarea" style="margin-left:32px;">
										<lable>投诉调查内容：</lable>
										<textarea name="complain.cnInquire" rows="" cols=""></textarea>
									</div>
									</td>
								</tr>
								<tr>
									<td colspan="4">
									<div class="textarea" style="margin-left:32px;">
										<lable>调查处理结果：</lable>
										<textarea name="complain.cnResult" rows="" cols=""></textarea>
									</div>
									</td>
								</tr>
								<tr>
									<th align="right">被投诉责任人：</th>
									<td><input type="text" name="complain.cnPrincipal" /></td>
									<th align="right">投诉记录状态：</th>
									<td class="td">
										<select name="complain.cnStatus">
										<option value="1">接收信息</option>
										<option value="2">投诉调查</option>
										<option value="3">调查处理</option>
										<option value="4">质量赔付</option>
										<option value="5">结束</option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="complain.remark" rows="" cols=""></textarea>
						</div>
						<input id="complainAddBtn" class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
						</form>
					</div>
					<div class="w_con w_cone" style="display: none">
						<form id="imyAddForm" method="post">
						<input type="hidden" name="cstImy.cnIdentifer" id="imy_cnIdentifer" value="" />
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>赔付信息来源：</th>
									<td class="td">
										<select name="cstImy.imyForm">
											<option value="1">客户投诉</option>
											<option value="2">质控总监业务审核、质量检查</option>
										</select>
									</td>
									<th align="right">投诉记录ID：</th>
									<td>
									<select  id="cstImy_cid" name="cstImy.cid">
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">赔付记录状态：</th>
									<td class="td">
										<select name="cstImy.imyStatus">
											<option value="1">赔付记录创建</option>
											<option value="2">客户损失审核确认</option>
											<option value="3">赔付沟通</option>
											<option value="4">赔付执行</option>
											<option value="5">赔付结束</option>
										</select>
									</td>
									<th align="right">赔付当前处理人：</th>
									<td><input type="text" name="cstImy.imyOpt" /></td>
								</tr>
								<tr>
									<td colspan="4">
									<div class="textarea" style="margin-left:2px;">
										<lable>赔付产生原因：</lable>
										<textarea name="cstImy.imyReason" rows="" cols=""></textarea>
									</div>
									</td>
								</tr>
								<tr>
									<td colspan="4">
									<div class="textarea" style="margin-left:2px;">
										<lable>赔付审核结果：</lable>
										<textarea name="cstImy.imyAuditRst" rows="" cols=""></textarea>
									</div>
									</td>
								</tr>
								<tr>
									<td colspan="4">
									<div class="textarea" style="margin-left:2px;">
										<lable>赔付沟通结果：</lable>
										<textarea name="cstImy.imyResult" rows="" cols=""></textarea>
									</div>
									</td>
								</tr>
								<tr>
									<th align="right">赔付金额：</th>
									<td>
										<input type="text" name="cstImy.imySum" />
									</td>
									<th align="right">赔付支付方式：</th>
									<td class="td">
										<select name="cstImy.payType">
											<option value="1">转帐</option>
											<option value="2">支票</option>
											<option value="3">现金</option>
											<option value="4">其它</option>
										</select>
									</td>
								</tr>
								<tr>
									<th align="right">赔付支付时间：</th>
									<td colspan="3">
										<input type="text" name="cstImy.payTime" value="2016-06-20 12:20:01" />
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="cstImy.remark" rows="" cols=""></textarea>
						</div>
						<input id="imyAddBtn" class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--合同-->
		<div class="total total2 total6">
			<form id="contractAddForm" method="post">
			<input type="hidden" name="cstContract.csrIdentifer" id="contract_cnIdentifer" value="" />
			<input type="hidden" name="cstContract.id" id="contract_id" value="" />
			<div class="lways lwaysa">
				<h1 class="h1 hh">
					代理记账服务合同
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<h2 class="h2"><span id="contract_csrName"></span></h2>
				<div>
					<div class="w_con w_cone">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span style="color:red">*</span>业务类别：</th>
									<td class="td">
										<select id="contract_serviceType" name="cstContract.serviceType">
										<option value="1">代理计帐、纳税申报</option>
										<option value="2">所得税汇算</option>
										<option value="3">咨询筹划</option>
										<option value="4">税务局沟通</option>
										<option value="5">上市服务</option>
										<option value="6">企业清算</option>
										<option value="7">企业重组</option>
										<option value="8">财产损失</option>
									</select>
									</td>
									<th align="right"><span style="color:red">*</span>服务费：</th>
									<td><input id="contract_serviceFee" name="cstContract.serviceFee" type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span style="color:red">*</span>服务起始时间：</th>
									<td><input type="text" id="contract_startTime" name="cstContract.startTime" value="2016-01-20 12:20:01" /></td>
									<th align="right"><span style="color:red">*</span>服务截止时间：</th>
									<td><input type="text" id="contract_endTime" name="cstContract.endTime" value="2016-12-20 12:20:01" /></td>
								</tr>
								<tr>
									<th align="right"><span style="color:red">*</span>付款模式：</th>
									<td class="td">
										<select id="contract_payCycle" name="cstContract.payCycle">
										<option value="1">月付</option>
										<option value="2">季付</option>
										<option value="3">年付</option>
									</select>
									</td>
									<th align="right">付款时间点：</th>
									<td><input id="contract_payDay" name="cstContract.payDay" type="text" /></td>
								</tr>
								<tr>
									<th align="right">理票约定：</th>
									<td class="td" colspan="3">
										<select id="contract_sortType" name="cstContract.sortType">
										<option value="1">自行理票</option>
										<option value="2">我方理票</option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea id="contract_remark" name="cstContract.remark" rows="" cols=""></textarea>
						</div>
						<input id="contractAddBtn" class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
					</form>
					<table id="contractHisTable" class="table table-condensed">
						
					</table>
				</div>
			</div>
		</div>
		<!--历史-->
		<div class="total total3">
			<div class="lways lwaysa">
				<h1 class="h1 hh ha">
					收费历史-<spna id="feeHisName"></spna>
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<div>
					<div class="w_con w_cone">
						<table id="feeHisTable" class="table table-condensed table-cond">
							
						</table>
						<div style="clear:both;"></div>
						<div class="footer">
							<input type="button" value="首页">
							<input type="button" value="上一页">
							<span class="span">1</span>
							<span>2</span>
							<input type="button" value="下一页">
							<input type="button" value="尾页">
							<b>总1条，共1页，每页</b>
							<select name="">
								<option value="">25</option>
								<option value="">50</option>
								<option value="">100</option>
							</select>
							<b>到第</b>
							<span>2</span>
							<input class="button" type="button" value="确定">
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--新增-->
		<div class="total total4">
			<div class="lways">
				<h1 class="h1 hg">
					新增用户
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<ul class="w_ul w_l w_ool">
					<li id="tab1" class="current">基本资料</li>
					<li id="tab2">税务信息</li>
				</ul>
				<div>
					<form id="csrAddForm" method="post">
						<input type="hidden" name="orgId" value='<s:property value="orgId"/>' />
					<div class="w_con w_cone w_conen">					
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>客户编码：</th>
									<td><input id="csrIdentifer" name="csrBasic.csrIdentifer" style="width:173px;" type="text" /></td>
									<th align="right"><span>*</span>客户名称：</th>
									<td><input id="csrName" name="csrBasic.csrName" type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>客户分类：</th>
									<td class="td">
										<select id="csrType" name="csrBasic.csrType">
										<option value="1">待开发</option>
										<option value="2">开发受挫</option>
										<option value="3">需跟进</option>
										<option value="4">已签约</option>
										<option value="5">服务已终止</option>
									</select>
									</td>
									<th align="right">信用代码或纳税人识别号：</th>
									<td class="td">
										<input name="csrBasic.csrCode" type="text" />
									</td>
								</tr>
								<tr>
									<th align="right">注册地址：</th>
									<td class="td">
										<input name="csrBasic.regAddress" type="text" />
									</td>
									<th align="right">办公地址：</th>
									<td class="td">
										<input name="csrBasic.officeAddress" type="text" />
									</td>
								</tr>
								<tr>
									<th align="right">法人代表：</th>
									<td><input name="csrBasic.csrOwner" type="text" /></td>
									<th align="right">财务负责人：</th>
									<td>
										<input name="csrBasic.financeLeader" type="text" />
									</td>
								</tr>
								<tr>
									<th align="right">税务负责人：</th>
									<td><input name="csrBasic.taxLeader" type="text" /></td>
									<th align="right"></th>
									<td>
										
									</td>
								</tr>
								
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="csrBasic.remark" rows="" cols=""></textarea>
						</div>
						<input id="cstAddBtn" class="w_btn" type="button" value="保存" />
						<input class="reset" type="button" value="取消" />
					</div>				
					<div class="w_con w_cone w_conen" style="display: none">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>会记准则制度：</th>
									<td>
										<select name="cstFt.ftInst">
										<option value="1">企业会计准则</option>
										<option value="2">小企业会计准则</option>
										</select>
									</td>
									<th align="right"><span>*</span>每月票据量：</th>
									<td>
										<select name="cstFt.recepitCount">
										<option value="1"><=50</option>
										<option value="2">50~100</option>
										<option value="3">100~200</option>
										<option value="4">200~300</option>
										<option value="5">>=300</option>
										</select>
									</td>
								</tr>
								<tr>
									<th align="right">
										<lable>财务报表：</lable>
									</th>
									<td colspan="3">
										<input name="rids" style="margin-left:5px;margin-right:5px;" type="checkbox" />资产负债表
										<input name="rids" style="margin-left:5px;margin-right:5px;" type="checkbox" />利润表
										<input name="rids" style="margin-left:5px;margin-right:5px;" type="checkbox" />现金流量表
										<input name="rids" style="margin-left:5px;margin-right:5px;" type="checkbox" />其他管理报表
									</td>
								</tr>
								<tr>
									<th align="right"><span>*</span>所得税所属税局：</th>
									<td>
										<select name="cstFt.ownTaxStation">
										<option value="1">国税</option>
										<option value="2">地税</option>
										</select>
									</td>
									<th align="right"><span>*</span>所得税申报时间：</th>
									<td><input id="ownDeclareTime" name="cstFt.ownDeclareTime" type="text" value="2016-6-20 12:20:01" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>征收方式：</th>
									<td class="td">
										<select name="cstFt.ownLevyType">
										<option value="1">查账征收</option>
										<option value="2">核定征收</option>
										</select>
									</td>
									<th align="right"><span>*</span>纳税申报方式：</th>
									<td class="td">
										<select name="cstFt.ownTaxType">
										<option value="1">汇总纳税申报</option>
										<option value="2">合并纳税申报</option>
										</select>
									</td>
								</tr>
								<tr>
									<th align="right"><span>*</span>税率：</th>
									<td><input id="ownTaxRate" name="cstFt.ownTaxRate" type="text" /></td>
									<th align="right"><span>*</span>增值税纳税人身份：</th>
									<td class="td">
										<select name="cstFt.addTaxOwner">
										<option value="1">增值税一般纳税人</option>
										<option value="2">增值税小规模纳税人</option>
										</select>
									</td>
								</tr>
								<tr>
									<th align="right"><span>*</span>增值税所属税局：</th>
									<td>
										<select name="cstFt.addTaxStation">
										<option value="1">国税</option>
										<option value="2">地税</option>
										</select>
									</td>
									<th align="right"><span>*</span>增值税申报时间：</th>
									<td><input id="addTaxDeclareTime" name="cstFt.addTaxDeclareTime" type="text" value="2016-6-20 12:20:01" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>增值税征收方式：</th>
									<td>
										<select name="cstFt.addTaxLevyType">
										<option value="1">查账征收</option>
										<option value="2">核定征收</option>
										</select>
									</td>
									<th align="right"><span>*</span>增值税纳税申报方式：</th>
									<td>
										<select name="cstFt.addTaxType">
										<option value="1">汇总纳税申报</option>
										<option value="2">合并纳税申报</option>
										</select>
									</td>
								</tr>
								<tr>
									<th align="right"><span>*</span>税率或征收率：</th>
									<td class="td">
										<td><input id="addTaxRate" name="cstFt.addTaxRate" type="text" /></td>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="cstFt.remark" rows="" cols=""></textarea>
						</div>
						<input id="ftAddBtn" class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
					</form>
				</div>
			</div>
		</div>
		<div class="total total2 total5">
			<form id="feeAddForm" method="post">
			<input type="hidden" name="cstFee.cid" id="fee_cid" value="" />
			<input type="hidden" name="cstFee.nid" id="fee_nid" value="" />
			<div class="lways lwaysa">
				<h1 class="h1 hh gg">
					代理记账收费
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<h2 class="h2"><span id="fee_csrName"></span></h2>
				<div>
					<div class="w_con w_cone">
						<table class="table1">
							<tbody>
								<tr style="display:none">
									<th align="right"><span style="color:red">*</span>姓名：</th>
									<td><span id="fee_csrOwner"></span></td>
								</tr>
								<tr style="display:none">
									<th align="right"><span style="color:red">*</span>合同编号：</th>
									<td><span id="fee_htbh"></span>							
									</td>
								</tr>
								<tr>
									<th align="right">收费时间：</th>
									<td><input type="text" name="cstFee.feeTime" value="2016-06-23 12:20:01" /></td>
								</tr>
								<tr>
									<th align="right">收费金额：</th>
									<td><input type="text" name="cstFee.feeSum" /></td>
								</tr>
								<tr>
									<th align="right">服务起始时间：</th>
									<td><input type="text" name="cstFee.startTime" value="2016-01-23 12:20:01" /></td>
									<th align="right">至：</th>
									<td><input type="text" name="cstFee.endTime" value="2016-12-23 12:20:01" /></td>
								</tr>
								<tr>
									<th align="right">支付方式：</th>
									<td class="td">
										<select name="cstFee.payType">
										<option value="1">转帐</option>
										<option value="2">支票</option>
										<option value="3">现金</option>
										<option value="4">其它</option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea" style="margin-left:130px;">
							<lable>备注：</lable>
							<textarea name="cstFee.remark" rows="" cols=""></textarea>
						</div>
						<input id="feeAddBtn" class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
				</div>
			</div>
			</form>
		</div>
		<!-- 提示 -->
		<div class="shadow-bg"></div>
		<div class="mainTip" style="display:none;">
			<h1 class="mian-title">
				提示<span class="close-button right"></span>
			</h1>
			<div class="delete">
				<img src="<%=path%>/images/pic14.png" />
				<p id="opTipText">操作成功！</p>
			</div>
			<input class="button" type="button" value="确定" />
		</div>
</body>
<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
<script src="<%=path%>/js/easyTree.js"></script>
<script src='<%=path%>/js/customer.js'></script>
<script src='<%=path%>/js/anagement.js'></script>
<script src="<%=path%>/js/dialog.js"></script>
<script src="<%=path%>/js/mpage.js"></script>
<s:if test="null != msg && msg.length() > 0">
<script>
$("#opTipText").text('<s:property value="msg"/>');
$(".shadow-bg").css("display","block");
$(".mainTip").css("display","block");
</script>
</s:if>
</html>