// JavaScript Document
function aa (){
	
	var aa = document.getElementById("username");
	if (aa.value =='请输入您的用户名'){aa.value =''}
	
}

function bb(){
	var bb = document.getElementById("username");
	if (bb.value ==''){bb.value='请输入您的用户名'}
}

function cc(){
	var cc = document.getElementById("pw");
	if (cc.value =='请输入您的登录密码'){cc.value=''}
}
function dd(){
	var dd = document.getElementById("pw");
	if (dd.value ==''){dd.value='请输入您的登录密码'}
}

function ee (){
	var ee = document.getElementById("identifCode");
	if (ee.value =='请输入图中验证码')
	{ee.value =''}
	
}
function ff (){
	var ff = document.getElementById("identifCode");
	if (ff.value ==''){ff.value='请输入图中验证码'}
	
}

$(function(){
	$(".rememberPwd").click(function(){
		$(this).toggleClass("checked");
	})
})
function login(){
	if (event.keyCode == 13){
		check();
	}
}
	function check(){
		//alert("0000");
		var nameVal = $("#username").val();
		//var pwdVal = $("#pw").val();
		// 登录口令密文处理
		var passd = $("#pw").val();
		var pwdVal = $("#pw").val(CryptoJS.SHA256(passd));
		var numVal = $("#identifCode").val();	
		var tip = $(".tip");
		if(nameVal == '' || nameVal == '请输入您的用户名'){
			tip.text("请输入用户名");
			return false;
		}
		if(pwdVal == '' || pwdVal == '请输入您的登录密码'){
			tip.text("请输入密码");
			return false;
		}
		if(numVal == '' || numVal== '请输入图中验证码'){
			tip.text("请输入验证码");
			return false;
		}
		document.frm.submit();
	}
	/*$.ajax({
		 type: "get",
		 url: "test.html",
		 success: function(data){
			 if(data.state == 0){
				window.location.href=""; 
			 }
			 if(data.state == 1){
				tip.text(data.msg); 
				return false;
			}
		}
	});*/
