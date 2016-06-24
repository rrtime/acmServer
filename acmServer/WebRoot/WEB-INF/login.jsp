<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>平台登录</title>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/sha256.js"></script>
	<script type="text/javascript" src="<%=path%>/js/login.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/rest.css"/>
	<LINK href="<%=path%>/css/login.css" type="text/css" rel="stylesheet">
</head>
<body onload="autoHeight('<s:property value="#request.rst"/>','<s:property value="#request.msg"/>');">
<!--title start-->
	<div class="title">
    	<div class="wrapper">
        	<a class="logo" href="#"></a>
        </div>
    </div>	
<!--title end-->
<!--login-box start-->
	<div id="mdiv" class="wrapper" style="">
	<div id="tmp"></div>
    	<span id="mspan" class="login-logo"></span>
    	
        <form class="login-box" name="frm" id="frm" action="<%=path%>/lg/login!login.do" method="POST">
        <div class="user-box">
            <span class="user-icon"></span>
        		<input class="text-box" id="username" name="atUser.iname" value="用户名" type="text" onFocus="Nfocus()" onBlur="Nblur()" />
        </div>
        <div class="user-box">
            <span class="pw-icon"></span>
            	<input class="text-box" id="pw" name="atUser.loginPwd" value="密码" type="text" onFocus="Pfocus()" onBlur="Pblur()"/>
        </div>
            <div class="remeber clearfix">
                <span class="reme-word">记住我</span>
                <span class="empty-radio reme-radio"></span>
            </div>
            <input class="login-btn" type="button" value="立即登录" onClick="check()" onKeyDown="login()"/>	
            <div class="infor clearfix">
            	<a class="left forget" href="#">忘记密码？</a>
                <a class="right" href="#">没有账号？快速注册</a>
            </div>
            <div class="tip" id="msg">用户名或密码有误</div>
            <div class="tip" id="m1">会话超期请重新登录</div>
            <div class="tip" id="m2">注销成功</div>	
        </form>
    </div>
<!--login-box end-->
<!--footer start-->
	<div class="footer">北京人人时代科技有限公司</div>
<!--footer end-->
</body>
</html>