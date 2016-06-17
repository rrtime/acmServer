	function checkParam()
	{
		if($("#userName").val() == "")
		{
			$("#userName").focus();
			hideAll();
			$("#logDiv").show();
			return false; 
		}
		if($("#passWord").val() == "")
		{
			$("#passWord").focus();
			hideAll();
			$("#logDiv1").show();
			return false;
		}
		var cde = $("#valicode").val();
		if( cde == "" )
		{
			$("#valicode").focus();
			hideAll();
			$("#logCodeNull").show();
			return false;
		}
		return true;
	}
	
	// 提交函数
	function mSub()
	{
		//var checkRes = checkParam();
		//if(!checkRes){
		//	return false;
		//}
		
		// 登录口令密文处理
		var passd=$("#passWord").val();
		$("#passWord").val(CryptoJS.SHA256(passd));
		hideAll();
		document.mfrm.submit();
	}
	
  	//用户名输入框按下回车时
  	function userEnter()
	{
  		if(event.keyCode==13)
  		{
  			identifyingCode();
		}
  	}
  	
  	//密码输入框按下回车操作
	function pwdEnter()
	{
  		if(event.keyCode==13)
  		{
			identifyingCode();
		}
  	}
  	
  	// 验证码按下回车操作
  	function codeEnter()
	{
  		if(event.keyCode==13)
  		{
			identifyingCode();
		}
  	}
  	
  	
  	