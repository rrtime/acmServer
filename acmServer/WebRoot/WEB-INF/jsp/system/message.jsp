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
<title>消息公告</title>
<link rel="stylesheet" href="<%=path%>/css/rest.css" />
<link rel="stylesheet" href="<%=path%>/css/easyTree.css" />
<link rel="stylesheet" href="<%=path%>/css/anagement.css" />
<link rel="stylesheet" href="<%=path%>/css/public.css" />
<link rel="stylesheet" href="<%=path%>/css/customer.css" />
<link rel="stylesheet" href="<%=path%>/css/dialog.css" />
<link rel="stylesheet" href="<%=path%>/css/message.css" />

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
							<a href="#">站内信息</a>
						</div>
						<div class="tree-box easy-tree">
							<ul class="tree-list">
								<li>
									<ul class="sort-a">
										<li><a href="#">未读</a>
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
										<li><a href="#">已读</a></li>
										<li><a href="#">全部</a></li>
										<li><a href="#">记账二部</a></li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
					<!--tree-modal end-->
				</div>
			</div>
			<div class="role-list role-list1 role-list2">
				<div class="find-opera find-opera1 find-opera2">
					<input type="button" value="近一周" />
					<input type="button" value="本月" />
					<input type="button" value="上月" />
					<input type="button" value="今年" />
					<input class="laydate-icon w_text" id="date1" type="text" />
					<input type="text" class="laydate-icon w_text1" id="date2" />
					<input class="w_button" type="button" value="查询" />
				</div>
				<div style="clear:both;"></div>
				<div class="w_mian find-opera find-opera2">
					<input type="button" value="发送消息" />
					<input type="button" value="删除" />
					<input type="button" value="设为已读" />
				</div>
				<table id="table" class="table">
					<tr class="tab-title">
						<th width="10%" align="center"><input style=""type="checkbox" /></th>
						<th width="20%" align="center">来源</th>
						<th width="30%" align="center">标题</th>
						<th class="last-child" width="40%" align="center">
							<span>时间</span>
						</th>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
					<tr>
						<td align="center"><input type="checkbox" checked="checked" /></td>
						<td align="center">张天明</td>
						<td align="center">派工通知</td>
						<td align="center">
							1026-07-08
						</td>
					</tr>
				</table>
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
</body>
<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
<script src="<%=path%>/js/easyTree.js"></script>
<script src='<%=path%>/js/customer.js'></script>
<script src='<%=path%>/js/anagement.js'></script>
<script src="<%=path%>/js/dialog.js"></script>
<script src="<%=path%>/js/mpage.js"></script>
<script src="<%=path%>/date/laydate.js"></script>
<script src="<%=path%>/date/date.js"></script>
<s:if test="null != msg && msg.length() > 0">
<script>
$("#opTipText").text('<s:property value="msg"/>');
$(".shadow-bg").css("display","block");
$(".mainTip").css("display","block");
</script>
</s:if>
</html>