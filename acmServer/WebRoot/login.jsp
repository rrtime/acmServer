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
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/md5.js"></script>	
	<script type="text/javascript" src="<%=path%>/js/login.js"></script>
	<script src="<%=path%>/js/identifyingCode.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=path%>/js/sha256.js"></script>
	<LINK href="<%=path%>/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<!--title start-->
	<div class="title">
    	<div class="wrapper">
        	<a class="logo" href="#"></a>
            <div class="clear"></div>
        </div>
    </div>
<!--title end-->
<!--login-con start-->
<div class="login-con wrapper">
    	<img class="fl left-pic" src="<%=path%>/images/Group 2 Copy.png" alt=""/>
        <form name="frm" id="frm" action="<%=path%>/lg/login!login.do" method="POST" class="fr form-login">
        	<div class="head"><img  src="<%=path%>/images/head.jpg" alt=""/></div>
            <div class="box username">
            	<span></span>
                <input id="username" name="atUser.iname" type="text" value="请输入您的用户名" onfocus="aa()" onblur="bb()"/>
            </div>
            <div class="box pw">
            	<span></span>
                <input id="pw" name="atUser.loginPwd" type="password"  value="请输入您的登录密码" onfocus="cc()" onblur="dd()"/>
            </div>
            <div class="box yz">
            	<span></span>
                <input id="identifCode" class="short-input " type="text" value="请输入图中验证码" onfocus="ee()" onblur="ff()"/>
                <a onclick="javascript:changeCode();"><img id="checkCodeImage" class="fr" src="<%=path%>/CreateImage" style="cursor: pointer" /></a>
                
            </div>
            <div class="opera-box">
                	<span class="cbox rememberPwd checked"></span>
                    <span>记住用户名</span>
                    <a href="#">忘记密码?</a>
                    <div class="clear"></div>
             </div>
             <input class="login-btn" type="button" value="登 录" onClick="check()" onKeyDown="login()"/>
             <p class="tip"></p>
             <span class="dimension"></span>
        </form>
        <div class="clear"></div>	
    </div>
<!--login-con end-->
	<p class="foot">北京人人时代科技有限公司</p>	
</body>
</html>