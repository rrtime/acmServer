// JavaScript Document
jQuery(function($){
	/*$('#tree2').ace_tree({
		dataSource: treeDataSource2 ,
		loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
		'open-icon' : 'icon-folder-open',
		'close-icon' : 'icon-folder-close',
		'selectable' : false,
		'selected-icon' : null,
		'unselected-icon' : null
	});*/
	
	$(".data-item .empty-box").click(function(){
			$(this).toggleClass("check-bg");
		});
		
		/*弹窗*/
		$(".opera-button .add-bg").click(function(){
			$(".shadow-bg").css("display","block");
			$(".add-word").css("display","block");
			$("#roleAddForm").attr("action","role!addRole.do");
			$("#roleName").val('');
			$("#roleDesc").val('');
			$("#addTip").css("display","none");
			$("#orgName").val("");
            $("#orgDesc").val("");
            $("#orgId").val("");
			var obj1 = $("#sysorgId").val();
			var obj = $("#sysoId").val();
			queryorgId(obj,obj1,'0');
		});
		$(".reset").click(function(){
			$(".shadow-bg").css("display","none");
			$(".add-word").css("display","none");	
		});
		
		$(".opera-button .edit-bg").click(function(){
			$(".shadow-bg").css("display","block");
			$(".add-word").css("display","block");
			$("#roleAddForm").attr("action","role!updateRole.do");
			$("#addTip").css("display","none");
			var obj1 = $("#sysorgId").val();
			var obj = $("#sysoId").val();
			queryorgId(obj,obj1,'1');
			editorg();
		});
		
		$(".button").click(function(){
			$(".shadow-bg").css("display","none");
			$(".mainTip").css("display","none");	
		});
		
		$(".find-opera .del-button").click(function(){
			$(".shadow-bg").css("display","block");
			$(".mian").css("display","block");
		});
		
		
		$(".reset1").click(function(){
			$(".shadow-bg").css("display","none");
			$(".mainDel").css("display","none");	
		});
		$(".close-button").click(function(){
			$(".shadow-bg").css("display","none");
			$(this).parents("div").css("display","none");
		});
		$(".find-opera .add-button").click(function(){
			$(".shadow-bg").css("display","block");
			$(".grxxsz").css("display","block");
			$("#atUserId").val("");
            $("#username").val("");
            $("#email").val("");
            $("#telno").val("");
            $("#iname").val("");
            $("#workerNo").val("");
            $("#jobDuty").val("");
            $("#loginPwd").val("");
            $("#remark").val("");
			findzu();
			finddept();
		});
		
		$(".w_input1").click(function(){
			$(".total1").css("display","block");	
		});
		$(".w_li").click(function(){
			$(".total3").css("display","block");	
		});
		$(".click").click(function(){
			$(".total6").css("display","block");	
		});
		$(".bunt").click(function(){alert();
			$(".total4").css("display","block");	
		});
		$(".wq_input").click(function(){
			$(".total5").css("display","block");	
		});
		$(".h1 img").click(function(){
			$(".total1").css("display","none");	
		});
		$(".hh img").click(function(){
			$(".total6").css("display","none");	
		});
		$(".ha img").click(function(){
			$(".total3").css("display","none");	
		});
		$(".hg img").click(function(){
			$(".total4").css("display","none");	
		});
		$(".gg img").click(function(){
			$(".total5").css("display","none");	
		});
		$(".h1 img").click(function(){
			$(".grxxsz").css("display","block");
		});
		
		//个人信息设置tap切换
	$(".grxxsz ul li").click(function(){
		var idx = $(this).index();
		$(this).addClass("current").siblings("li").removeClass('current');
		$('.con').eq(idx).show().siblings('.con').hide();
	})
	
	$(".opera-button .del-bg").click(function(){
			$(".shadow-bg").css("display","block");
			$(".mainDel").css("display","block");
		});
	
});