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
	<script type="text/javascript" src="<%=path%>/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/md5.js"></script>
	<script type="text/javascript" src="<%=path%>/js/login.js"></script>
	<script type="text/javascript" src="<%=path%>/js/identifyingCode.js"></script>
	
	<LINK href="<%=path%>/css/User_Login.css" type="text/css" rel="stylesheet">
	<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<script type="text/javascript">
	<!--
		function mLoad()
		{
			changeCode();
			$("#logDiv").hide();
			$("#logDiv1").hide();
			$("#logErr").hide();
			$("#logCodeNull").hide();
			$("#logCodeErr").hide();
			var rst = "<s:property value="#request.loginRst"/>";
			if( rst == 1 )
			{
				$("#logErr").show();
			}
			$("#userName").focus();
		}
		
		function login(){
			identifyingCode();
		}
		
		function identifyingCode(){
			var checkRes = checkParam();
			if(!checkRes){
				return false;
			}
			var valicode=$("#valicode").val();
			var rst = "<s:property value="#request.loginRst"/>";
			var url ;
			
			if(rst==null||rst==""){
				url="IdentifyingCode";
			}else if(rst>0){
				url="../IdentifyingCode";
			}
			url+="?valicode="+valicode;
			$.ajax({
				url:url,
				datatype:'json',
				type:'post',
				cache:false,
				timeout: 1000,
				async: false ,//同步方式
				success:function(res){
					if(res=="true"){
						mSub();
					}else{
						$("#logDiv").hide();
						$("#logDiv1").hide();
						$("#logErr").hide();
						$("#logCodeNull").hide();
						$("#logCodeErr").show();
						changeCode();
					}
					
				}
			});
				
		}
	//-->
	</script>
</HEAD>
<BODY id=userlogin_body onload="mLoad()">

<s:form name="mfrm" id="mfrm" action="/sm/userMag!login.do" method="POST">
<DIV id=user_login>
	<DL>
		<DD id=user_top>
			<UL>
				<LI class=user_top_l></LI>
				<LI class=user_top_c></LI>
				<LI class=user_top_r></LI>
			</UL>
		</DD>
		<DD id=user_main>
			<UL >
				<LI class=user_main_l></LI>
				<LI class=user_main_c>
					<DIV class=user_main_box>
					<UL>
						<LI class=user_main_text><b>Username</b>&nbsp;&nbsp;</LI>
						<LI class=user_main_input><INPUT id="userName" type="text" class=TxtUserNameCssClass name="systemLoginUser.userAlias" onkeydown="userEnter()" maxLength="16" /></LI>
					</UL>
					<UL>
						<LI class=user_main_text><b>Password</b>&nbsp;&nbsp;</LI>
						<LI class=user_main_input>
						<INPUT id="passWord" type="password" class=TxtPasswordCssClass name="systemLoginUser.userPwd" onkeydown="userEnter()" maxLength="12"/>
						</LI>
					</UL>		
					<UL>
						<LI class=user_main_text><b>Code</b>&nbsp;&nbsp;</LI>	
						<LI class=user_main_input>				
						
						<s:if test="#request.loginRst==null"> 
							<INPUT id="valicode" type="text" class="TxtCode" onkeydown="pwdEnter()" maxLength="4" />
							<a onclick="javascript:changeCode();"><img id="checkCodeImage" src="CreateImage" style="cursor: pointer" />
							</a>
							
						</s:if>
						<s:if test="#request.loginRst>0"> 
							<INPUT id="valicode" type="text" class="TxtCode" maxLength="4" /><a onclick="javascript:changeCode();">
							<img id="checkCodeImage" src="../CreateImage" style="cursor: pointer" /></a>
						</s:if>
					</LI></UL>
					<UL>
						<LI class=user_main_text></LI>
						<LI class=user_main_input>
						<div id="logErr"style="display:none;"><font size="2" color="red">Username or password error.</font></div>
						<div id="logDiv"style="display:none;"><font size="2" color="red">Please enter username.</font></div>
						<div id="logDiv1"style="display:none;"><font size="2" color="red">Please enter password.</font></div>
						<div id="logCodeNull"style="display:none;"><font size="2" color="red">Please enter code.</font></div>
						<div id="logCodeErr"style="display:none;"><font size="2" color="red">Code error.</font></div></LI>
					</UL>
					</DIV>
				</LI>
				<LI class=user_main_r><a href="javascript:login();" onFocus="this.blur()"><img style="border:0;" src="<%=path%>/images/user_botton.gif"></a></LI>
			</UL>
		</DD>
		<DD id=user_bottom>
			<UL>
				<LI class=user_bottom_l></LI>
				<LI class=user_bottom_c> </LI>
				<LI class=user_bottom_r></LI>
			</UL>
		</DD>
	</DL>
</DIV>
    <SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
    <SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
    <SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
</s:form>
</BODY>
<DIV></DIV>
</HTML>