<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%
	String path = request.getContextPath();
%>
<HTML>
<HEAD><TITLE>System Charge Login</TITLE>
<LINK href="<%=path%>/css/Default.css" type="text/css" rel="stylesheet">
<LINK href="<%=path%>/css/xtree.css" type="text/css"rel="stylesheet">
<LINK href="<%=path%>/css/User_Login.css" type="text/css" rel="stylesheet">
<script src="<%=path%>/js/sha256.js" type="text/javascript"></script>
<script src="<%=path%>/js/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/login.js" type="text/javascript"></script>
<script src="<%=path%>/js/identifyingCode.js" type="text/javascript"></script>



<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<script type="text/javascript">
	<!--
		function login(){
			identifyingCode();
		}
		
		function mLoad()
		{
			changeCode();
			hideAll();
			var rst = "<s:property value="#request.loginRst"/>";
			if( rst == 1 )
			{
				$("#logErr").show();
			}
			else if( rst == 2 )
			{
				$("#logDiv2").show();
			}
			else if( rst == 3 )
			{
				$("#logLock").show();
			}
			else if( rst == 4 )
			{
				$("#logDiv4").show();
			}
			// 会话过期
			else if( rst == 5 )
			{
				$("#logDiv5").show();
			}
			// 账户停用状态
			else if( rst == 6 )
			{
				$("#logDiv5").show();
			}
			$("#userName").focus();
		}
	
		function hideAll()
		{
			$("#logDiv").hide();
			$("#logDiv1").hide();
			$("#logDiv2").hide();
			$("#logLock").hide();
			$("#logDiv4").hide();
			$("#logDiv5").hide();
			$("#logDiv6").hide();
			$("#logErr").hide();
			$("#logCodeNull").hide();
			$("#logCodeErr").hide();
		}
	
		function isFF()
		{          
			return navigator.userAgent.indexOf("Firefox")!=-1;
		}
		
		// 验证码校验
		function identifyingCode()
		{
			var checkRes = checkParam();
			if(!checkRes)
			{
				return false;
			}
			var valicode = $("#valicode").val();
			var rst = "<s:property value="#request.loginRst"/>";
			var url ;
			// 拼接验证码校验地址 url
			if(rst==null||rst=="")
			{
				url="IdentifyingCode";
			}
			else if(rst>0)
			{
				url="../IdentifyingCode";
			}
			else
			{
				alert('验证码路径');
			}
			url+="?valicode="+valicode;
			$.ajax({
				url:url,
				datatype:'xml',
				type:'post',
				cache:false,
				timeout: 1000,
				async: false ,//同步方式
				success:function(res){
					//alert(res+"---"+$(res).find("row").text());
					// 是否为火狐
					if( isFF() )
					{
						if( $(res).find("row").text()==0 )
						{
							mSub();	
						}
						else
						{
							hideAll();
							$("#logCodeErr").show();
							changeCode();
						}
					}
					// IE 或其它
					else
					{
						var tmp = res.substr(43,1);
						if( tmp == 0 )
						{
							mSub();	
						}
						else
						{
							hideAll();
							$("#logCodeErr").show();
							changeCode();
						}
					}
				}
			});
				
		}
		
	//-->
	</script>
</HEAD>
<BODY id=userlogin_body onload="mLoad()">

<s:form name="mfrm" id="mfrm" action="login!login.do" namespace="/lg" method="POST">

<table style="margin-top:0%;" width="766" height="346" border="0" valign="center" align="center" cellpadding="0" cellspacing="0" background="<%=path%>/images/login.png">
<tr>
<td width="785" height="346" align="center">
<br/>
<table width="100%" height="124" border="0" cellpadding="0" cellspacing="0" align="center">
<td align="" colspan="3" width="75%" height="6"></td>
<tr align="center">
<td width="31%" height="30" align="right"><font color="white"><b>Username</b></font>&nbsp;&nbsp;</td>
<td width="41%" align="left"><input class="" type="text" id="userName" name="systemLoginUser.userAlias" onkeydown="userEnter()" style="width:183px;height:17px;" size="25" maxlength="20" onkeydown="mEnter()"></td>
<td rowspan="5" width="217px" align="left"><a href="javascript:login();" onfocus="this.blur();" title="click login"><img src="<%=path%>/images/glass.png" style="border:0;"></a></td>
</tr>
<td align="" colspan="3" height="5"></td>
<tr>
<td align="right" height="19"><font color="white"><b>Password</b></font>&nbsp;&nbsp;</td>
<td align="left"><input class="" type="password" id="passWord" name="systemLoginUser.userPwd" size="25" maxlength="20" onkeydown="userEnter()" style="width:183px;height:17px;" onkeydown="mEnterI()"></td>
</tr>

<tr>
<td align="right"><font color="white"><b>Code</b></font>&nbsp;&nbsp;</td>
<td align="left">
<s:if test="#request.loginRst==null"><INPUT id="valicode" type="text" style="width:84px;height:17px;" onkeydown="pwdEnter()" maxLength="4" />
		<a onclick="javascript:changeCode();"><img id="checkCodeImage" src="CreateImage" style="cursor: pointer" />
		</a>
	</s:if>
	<s:if test="#request.loginRst>0"><INPUT id="valicode" type="text" style="width:84px;height:17px;" onkeydown="codeEnter()" maxLength="4" /><a onclick="javascript:changeCode();">
		<img id="checkCodeImage" src="../CreateImage" style="cursor: pointer" /></a>
	</s:if>
<input type="hidden" id="cod" value="1">
</td>

</tr>
<tr><td align="center" colspan="3" height="7"></td></tr>
<tr>
<td align="center" colspan="2" width="">
	<div id="logErr" style="display:none;"><font size="2" color="yellow">Username or password error.</font></div>
	<div id="logDiv" style="display:none;"><font size="2" color="yellow">Please enter username.</font></div>
	<div id="logDiv1" style="display:none;"><font size="2" color="yellow">Please enter password.</font></div>
	<div id="logDiv2" style="display:none;"><font size="2" color="yellow">Login IP is not consistent.</font></div>
	<div id="logLock" style="display:none;"><font size="2" color="yellow">Users will be locked.</font></div>
	<div id="logDiv4" style="display:none;"><font size="2" color="yellow">Current user lock.</font></div>
	<div id="logDiv5" style="display:none;"><font size="2" color="yellow">Session timeout.</font></div>
	<div id="logDiv6" style="display:none;"><font size="2" color="yellow">User status is stop.</font></div>
	<div id="logCodeNull" style="display:none;"><font size="2" color="yellow">Please enter code.</font></div>
	<div id="logCodeErr" style="display:none;"><font size="2" color="yellow">Code error.</font></div>
</td>
<td width="53%" align="left">&nbsp;</td>

</tr>

</table></td>
</tr>
</table>


</s:form>
</BODY>


</HTML>