<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<script src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/sha256.js"></script>
<script type="text/javascript">
//修改密码
function updatepwd(){
        // 登录口令密文处理
		var passd = $("#oldpwd").val();
		var oldpwd = CryptoJS.SHA256(passd);
        var newPwd = $("#loginPwd").val();
	    $.ajax({
						type : "POST",
						url : "../xl/user!checkpwd.do?oldpwd="+oldpwd,
						data : {},
						async : false,
						success : function(json) {//调用成功的话
								var jsonData = JSON.parse(json); 
								if(jsonData.status=="0"){//旧密码和新密码相同
								       var loginPwd = CryptoJS.SHA256(newPwd);
									   $.ajax({
											type : "POST",
											url : "../xl/user!updatepassword.do?atUser.loginPwd="+loginPwd,
											data : {},
											async : false,
											success : function(json) {//调用成功的话
													var jsonData = JSON.parse(json); 
													if(jsonData.status=="0"){//修改成功
													   rest();
													}
											}
										});
								}
						}
					});
	}
	
	function rest(){
	   $("#oldpwd").val("");
	   $("#loginPwd").val("");
	   $("#newpwd").val("");
	}
</script>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/rest.css" />
		<link rel="stylesheet" href="../css/userSet.css" />
	</head>
	<body>
		<div class="wrap">
			<div class="main">
				<ul>
					<!--个人信息-->
					<li class="current"><img src="../images/icon1.png"/><span>个人信息</span>
						
					</li>
					<!--密码-->
					<li><img src="../images/icon2.png"/><span>密码</span>
						
					</li>
				</ul>
				<!--个人信息-->
				<div class="xinxi" style="display: block;">
						<form name="mfrm" id="mfrm" action="../xl/user!updateuser.do" >
								<table>
									<tbody>
										
										<tr>
											<th align="left"><span style="color:#ff0000;">*</span>姓名：</th>
											<td ><input id="atUser.iname" name="atUser.iname" class="xm" type="text" value="${atUser.iname} " /></td>
										</tr>
										<tr>
											<th align="left">性别：</th>
											<td class="td"><input type="radio" name="atUser.sex" value="1" <c:if test="${atUser.sex eq '1'}">checked="checked"</c:if>/><span>男</span><input type="radio" name="atUser.sex" value="2" <c:if test="${atUser.sex eq '2'}">checked="checked"</c:if>><span>女</span></td>					
										</tr>
										<tr>
											<th align="left">E-mail：</th>
											<td><input id="atUser.email" name="atUser.email" class="email"type="text" value="${atUser.email}" /></td>
										</tr>
										<tr>
											<th align="left">联系电话：</th>
											<td><input class="tel"type="text" id="atUser.telno" name="atUser.telno" value="${atUser.telno}"/></td>
										</tr>
										<tr>
											<th align="left">部门：</th>
											<td><input class="email"type="text" readonly="readonly" value="${org.orgName }" /><input type="hidden" id="atUser.oid" name="atUser.oid" value="${atUser.oid }"/></td>
										</tr>
										<tr>
											<th align="left">联系地址：</th>
											<td><input class="dz" type="text" /></td>
										</tr>
										<tr>
											<th align="left" >备注：</th>
											<td><input class="bz"type="text" name="atUser.remark" id="atUser.remark" value="${atUser.remark}"/></td>
										</tr>
									</tbody>
								</table>
								<input class="submit" type="submit" value="保存"/>
								<input type="reset" value="重置"/>
							</form>
						</div>
						<!--密码-->
						<div class=" xinxi mima">
								<table>
									<tbody>
										<tr>
											<th align="left">旧密码：</th>
											<td><input class="password" type="password" id="oldpwd" name="oldpwd" value=""/></td>
										</tr>
										<tr>
											<th align="left">新密码：</th>
											<td><input class="password"type="password" id="loginPwd" name="loginPwd" value=""/></td>
										</tr>
										<tr>
											<th align="left">确认密码：</th>
											<td><input class="password"type="password" id="newpwd" name="newpwd" value=""/></td>
										</tr>
									</tbody>
								</table>
								<input calss="submit" type="button" value="保存" onclick="updatepwd()"/>
								<input type="reset" value="重置"/>
						</div>
				
				
				
				
		</div>
	</body>
	<!--<script src="js/jquery-1.8.3.min.js"></script>-->
<script src="../js/jquery-1.11.1.min.js"></script>
	<script src='../js/userSet.js'></script>
</html>

