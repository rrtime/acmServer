	// JavaScript Document
	function Nfocus (){
		
		var aa = document.getElementById("username");
		if (aa.value =='用户名'){aa.value =''}
		
	}
	
	function Nblur(){
		var bb = document.getElementById("username");
		if (bb.value ==''){bb.value='用户名'}
	}
	
	function Pfocus(){
		var cc = document.getElementById("pw");
		if (cc.value =='密码'){
			cc.value=''
			cc.type="password"
			}
	}
	
	function Pblur(){
		var dd = document.getElementById("pw");
		if (dd.value ==''){
			dd.type = "text"
			dd.value='密码'
			}
	}
	$(".remeber span").click(function(){
		$(".remeber .empty-radio").toggleClass("reme-radio");
	});

	function check(){
		//alert("0000");
		var nameVal = $("#username").val();
		var pwdVal = $("#pw").val();	
		if(nameVal == '' || nameVal == '用户名'){
			hideAll();
			$("#msg").text("请输入用户名");
			$("#msg").show();
			$("#username").focus();
			return;
		}
		if(pwdVal == '' || pwdVal == '密码'){
			hideAll();
			$("#msg").text("请输入密码");
			$("#msg").show();
			$("#pw").focus();
			return;
		}
		// 登录口令密文处理
		var passd = $("#pw").val();
		$("#pw").val(CryptoJS.SHA256(passd));
		document.frm.submit();
	}

	function autoHeight(rst, msg)
	{
		// 动态获取屏幕高度
		var ht = $(window).height() - 160;
		var mm = ht;
		
		// 计算登录模块与顶部的间隔
		var mg = ht*0.22;
		//alert(mm+"----"+mg);
		//document.getElementById('mspan').style.marginTop = mg + 'px';
		document.getElementById('tmp').style.height = mg + 'px';
		ht -= mg;
		//alert('margin: '+mg+'; div: '+ht);
		//获得元素
		var mdiv = document.getElementById('mdiv');
		mdiv.style.height = mm+'px';
		// 提示信息
		mLoad(rst, msg);
	}
	
	function mLoad(rst, msg)
	{
		hideAll();
		if( typeof(rst) != "undefined" )
		{
			// 用户名密码有误
			if( rst == 1 )
			{
				$("#msg").show();
			}
			// 会话超时
			else if( rst == 5 )
			{
				$("#m1").show();
			}
			// 注销成功
			else if( rst == 6 )
			{
				$("#m2").show();
			}
		}
		$("#username").focus();
	}

	function hideAll()
	{
		$("#msg").hide();
		$("#m1").hide();
		$("#m2").hide();
	}
	
	$(function(){
			//检测回车
			$(document).keypress(function(event){  
			    var keycode = (event.keyCode ? event.keyCode : event.which);  
			    if(keycode == '13'){  
			       check();
			    }  
			});  
		});