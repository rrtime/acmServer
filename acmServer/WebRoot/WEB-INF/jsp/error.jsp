<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7;IE=9;IE=8">
<title>System Index TOP</title>
<link rel="stylesheet" type="text/css" href="../css/myStyle.css" />
<script language="JavaScript">
<!--
	// 自动刷新监测会话
	function myrefresh()
	{
		var sos = "${sessionScope.loginUser}";
		if( sos == null || sos == "" )
		{
			this.top.location.href = "userMag!logout.do?cmd=4";
		}
		else
		{
			alert("---");
		}
	    //window.location.reload();
	}
	//setTimeout('myrefresh()',3000); 
	//setInterval('myrefresh()',3000);	// 指定每  60  秒刷新一次
//-->
</script>
</head>

<body onLoad="">
	Login User:&nbsp;${sessionScope.loginUser.iname}<br/>
	Error infos:<br/>
	<s:property value="exception.Message"/><br>
	<s:property value="exception.exceptionStack"/>  
</body>
</html>