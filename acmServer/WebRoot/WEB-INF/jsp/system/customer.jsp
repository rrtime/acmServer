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


</head>
<body>
	<!--total-role start-->
		<div class="total-role">
			<div class="role-definite">
				<h2 class="role-word">部门管理</h2>
				<div class="opera">
					<!--tree-modal start-->
					<div class="tree-modal">
						<div class="system-role">
							<a href="#">系统角色</a>
						</div>
						<div class="tree-box easy-tree">
							<ul class="tree-list">
								<li>
									<ul class="sort-a">
										<li><a href="#">管理员</a>
											<ul>
												<li><a href="#">员工</a>
													<ul>
														<li><a href="#">1</a></li>
														<li><a href="#">2</a></li>
														<li><a href="#">3</a></li>
													</ul>
												</li>
												<li><a href="#">经理</a></li>
												<li><a href="#">出纳</a></li>
												<li><a href="#">记账员</a></li>
											</ul>
										</li>
										<li><a href="#">经理</a></li>
										<li><a href="#">出纳</a></li>
										<li><a href="#">记账员</a></li>
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
					<input type="button" value="派工" />
					<input type="button" value="停止服务" />
					<input type="button" value="导入导出" />
					<div class="search search1">
						<ul>
							<li><input type="text" /></li>
							<li><input type="button" value="搜索" placeholder="请输入用户名或编号" /></li>
						</ul>
					</div>
				</div>
				<div style="clear:both;"></div>
				<div class="w_mian">
					<ul class="ul">
						<li class="current">常用操作</li>
						<li>收费</li>
					</ul>
					<table id="table" class="table">
						<tr class="tab-title">
							<th width="5%" align="center"><input type="checkbox" /></th>
							<th width="5%" align="center">编号</th>
							<th width="20%" align="center">客户名称</th>
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
						<tr>
							<td align="center"><input type="checkbox" checked="checked" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change">
									<input class="w_input wq_input" type="button" value="记账" />
									<input class="w_input w_input1" type="button" value="跟进" />
									<input class="w_input" type="button" value="报税" />
								</div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;background:#0088CC;color:#fff;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" checked="checked" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" checked="checked" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" checked="checked" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" checked="checked" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" /></td>
							<td align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
						<tr>
							<td align="center"><input type="checkbox" /></td>
							<td w align="center">001</td>
							<td align="center">张天明</td>
							<td align="right">
								<div class="tab-change"><span>会记时间：2015-6</span></div>
								<div class="tab-change1 charge-box mr8">
									<input style="float:right;margin-right:23px;margin-left:5px;" type="button" value="合同" class="click" />
									<input style="float:right;margin-left:20px;" type="button" value="收费" class="click1" />
									<div class="num">
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
					</table>
				</div>
				<div style="clear:both;"></div>
				<div class="footer">
					<input type="button" value="首页">
					<input type="button" value="上一页">
					<span class="span">1</span>
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
		<!--total-role end-->
		<!--售后管理-->
		<div class="total total1">
			<div class="lways">
				<h1 class="h1">
					售后管理
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<ul class="w_ul w_l">
					<li class="current">回访</li>
					<li>投诉</li>
					<li>质量赔付</li>
				</ul>
				<div>
					<div class="w_con w_cone">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>所属代账机构：</th>
									<td><input type="text" /></td>
									<th align="right">所属客户编号：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>回访客户来源：</th>
									<td><input type="text" /></td>
									<th align="right">回放方式：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">回访联系方式：</th>
									<td class="td">
										<select class="sele-box" name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
									<th align="right">回访时间：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">回放内容：</th>
									<td><input type="text" /></td>
									<th align="right">回放结果：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
					<div class="w_con w_cone" style="display: none">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>所属代账机构：</th>
									<td><input type="text" /></td>
									<th align="right">所属客户编号：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>投诉来源：</th>
									<td><input type="text" /></td>
									<th align="right">投诉方式：</th>
									<td class="td">
										<select name="">
										<option value="">123</option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">投诉主题：</th>
									<td>
										<input type="text" />
									</td>
									<th align="right">投诉内容：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">投诉当前处理人：</th>
									<td><input type="text" /></td>
									<th align="right">调查处理结果：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">被投诉责任人：</th>
									<td><input type="text" /></td>
									<th align="right">投诉记录状态：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
					<div class="w_con w_cone" style="display: none">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>所属代账机构：</th>
									<td><input type="text" /></td>
									<th align="right">所属客户编号：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>赔付信息来源：</th>
									<td><input type="text" /></td>
									<th align="right">投诉记录ID：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">赔付记录状态：</th>
									<td class="td">
										<select name="">
											<option value="">456</option>
											<option value=""></option>
											<option value=""></option>
										</select>
									</td>
									<th align="right">赔付审核结果：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">赔付沟通结果：</th>
									<td>
										<input type="text" />
									</td>
									<th align="right">赔付金额：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">赔付支付方式：</th>
									<td class="td">
										<select name="">
											<option value="">456</option>
											<option value=""></option>
											<option value=""></option>
										</select>
									</td>
									<th align="right">赔付支付时间：</th>
									<td>
										<input type="text" />
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
				</div>
			</div>
		</div>
		<!--合同-->
		<div class="total total2 total6">
			<div class="lways lwaysa">
				<h1 class="h1 hh">
					代理记账服务合同
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<h2 class="h2">北京万科股份有限公司</h2>
				<div>
					<div class="w_con w_cone">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span style="color:red">*</span>所属代账机构：</th>
									<td><input type="text" /></td>
									<th align="right">所属客户编号：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span style="color:red">*</span>回访客户来源：</th>
									<td><input type="text" /></td>
									<th align="right">回放方式：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">回访联系方式：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
									<th align="right">回访时间：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">回放内容：</th>
									<td><input type="text" /></td>
									<th align="right">回放结果：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
					<table class="table table-condensed">
						<tr>
							<th align="left">签约时间</th>
							<th align="left">合同期限</th>
							<th align="left">月服务费</th>
							<th align="left">年帐本费</th>
							<th align="left">付款方式</th>
							<th align="left">附件</th>
							<th align="left">记录人</th>
							<th align="left">操作</th>
						</tr>
						<tr>
							<td align="left">2016-07-08</td>
							<td align="left">2017.1-2017.12</td>
							<td align="left">12300.00</td>
							<td align="left">14000.00</td>
							<td align="left">按月收费</td>
							<td align="left"></td>
							<td align="left">小美</td>
							<td align="left"><img src="<%=path%>/images/pic15.png" /><img src="<%=path%>/images/pic16.png" /><img src="<%=path%>/images/pic17.png" /></td>
						</tr>
						<tr>
							<td align="left">2016-07-08</td>
							<td align="left">2017.1-2017.12</td>
							<td align="left">12300.00</td>
							<td align="left">14000.00</td>
							<td align="left">按月收费</td>
							<td align="left"></td>
							<td align="left">小美</td>
							<td align="left"><img src="<%=path%>/images/pic15.png" /><img src="<%=path%>/images/pic16.png" /><img src="<%=path%>/images/pic17.png" /></td>
						</tr>
						<tr>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
						</tr>
						<tr>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
						</tr>
						<tr>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
							<td align="left"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--历史-->
		<div class="total total3">
			<div class="lways lwaysa">
				<h1 class="h1 hh ha">
					收费历史-北京市阳光照明股份有限公司
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<div>
					<div class="w_con w_cone">
						<table class="table table-condensed table-cond">
							<tr>
								<th align="left">日期</th>
								<th align="left">收费时段</th>
								<th align="left">账本表</th>
								<th align="left">其他收费</th>
								<th align="left">收费金额</th>
								<th align="left">收款人</th>
								<th align="left">说明</th>
								<th align="left">操作</th>
							</tr>
							<tr>
								<td align="left">2016-07-08</td>
								<td align="left">2017.1，2月</td>
								<td align="left">0.00</td>
								<td align="left">0.00</td>
								<td align="left">4464.00</td>
								<td align="left">小美</td>
								<td align="left"></td>
								<td align="left"><input type="button" value="查看" /></td>
							</tr>
							<tr>
								<td align="left">2016-07-08</td>
								<td align="left">2017.1，2月</td>
								<td align="left">0.00</td>
								<td align="left">0.00</td>
								<td align="left">4464.00</td>
								<td align="left">小美</td>
								<td align="left"></td>
								<td align="left"><input type="button" value="查看" /></td>
							</tr>
							<tr>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
							</tr>
							<tr>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
							</tr>
							<tr>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
								<td align="left"></td>
							</tr>
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
					<li class="current">基本资料</li>
					<li>税务信息</li>
				</ul>
				<div>
					<div class="w_con w_cone w_conen">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>客户编码：</th>
									<td><input style="width:173px;" type="text" /></td>
									<th align="right">客户名称：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span>*</span>公司简称：</th>
									<td><input type="text" /></td>
									<th align="right">客户分类：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">所在行业：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
									<th align="right">所在地：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
								<tr>
									<th align="right">法人代表：</th>
									<td><input type="text" /></td>
									<th align="right">身份证号：</th>
									<td>
										<input type="text" />
									</td>
								</tr>
								<tr>
									<th align="right">营业执照号：</th>
									<td><input type="text" /></td>
									<th align="right">组织机构代码：</th>
									<td>
										<input type="text" />
									</td>
								</tr>
								<tr>
									<th align="right">成立时间：</th>
									<td><input type="text" /></td>
									<th align="right">开放代账日期：</th>
									<td>
										<input type="text" />
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea" style="margin-left:95px;">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
					<div class="w_con w_cone w_conen" style="display: none">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span>*</span>所属客户编号：</th>
									<td><input type="text" /></td>
									<th align="right">会记准则制度：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">
										<lable>财务报表：</lable>
									</th>
									<td colspan="3">
										<input style="margin-left:5px;margin-right:5px;" type="checkbox" />资产负债表
										<input style="margin-left:5px;margin-right:5px;" type="checkbox" />利润表
										<input style="margin-left:5px;margin-right:5px;" type="checkbox" />现金流量表
										<input style="margin-left:5px;margin-right:5px;" type="checkbox" />其他管理报表
									</td>
								</tr>
								<tr>
									<th align="right"><span>*</span>得税所属税局：</th>
									<td>
										<select name="">
											<option value=""></option>
										</select>
									</td>
									<th align="right">得税申报时间：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">所属税局：</th>
									<td class="td">
										<select name="">
											<option value=""></option>
										</select>
									</td>
									<th align="right">申报时间：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">征收方式：</th>
									<td class="td">
										<select name="">
											<option value=""></option>
										</select>
									</td>
									<th align="right">申报方式：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">税率或征收率：</th>
									<td class="td">
										<select name="">
											<option value=""></option>
										</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
				</div>
			</div>
		</div>
		<div class="total total2 total5">
			<div class="lways lwaysa">
				<h1 class="h1 hh gg">
					代理记账收费
					<img src="<%=path%>/images/delete.png"/>
				</h1>
				<h2 class="h2">北京万科股份有限公司</h2>
				<div>
					<div class="w_con w_cone">
						<table class="table1">
							<tbody>
								<tr>
									<th align="right"><span style="color:red">*</span>姓名：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right"><span style="color:red">*</span>合同编号：</th>
									<td><input style="background:#e6f3f9;border:1px solid #32a3ce;" type="text" /></td>
								</tr>
								<tr>
									<th align="right">收费时间：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">收费金额：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">服务起始时间：</th>
									<td><input type="text" /></td>
									<th align="right">至：</th>
									<td><input type="text" /></td>
								</tr>
								<tr>
									<th align="right">支付方式：</th>
									<td class="td">
										<select name="">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="textarea" style="margin-left:130px;">
							<lable>备注：</lable>
							<textarea name="" rows="" cols=""></textarea>
						</div>
						<input class="w_btn" type="button" value="保存" />
						<input class="w_btn w_bt" type="button" value="取消" />
					</div>
				</div>
			</div>
		</div>
</body>
<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
<script src="<%=path%>/js/easyTree.js"></script>
<script src='<%=path%>/js/customer.js'></script>
<script src='<%=path%>/js/anagement.js'></script>
<script src="<%=path%>/js/dialog.js"></script>
</html>