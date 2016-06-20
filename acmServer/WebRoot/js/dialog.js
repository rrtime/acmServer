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
			$("#orgName").val("");
			$("#orgDesc").val("");
		});
		$(".reset").click(function(){
			$(".shadow-bg").css("display","none");
			$(".add-word").css("display","none");	
		});
		
		$(".opera-button .edit-bg").click(function(){
			$(".shadow-bg").css("display","block");
			$(".add-word").css("display","block");
			editorg();
		});
		$(".reset").click(function(){
			$(".shadow-bg").css("display","none");
			$(".add-word").css("display","none");	
		});
		
		$(".find-opera .del-button").click(function(){
			$(".shadow-bg").css("display","block");
			$(".mian").css("display","block");
		});
		
		
		$(".reset1").click(function(){
			$(".shadow-bg").css("display","none");
			$(".mian").css("display","none");	
		});
		$(".close-button").click(function(){
			$(".shadow-bg").css("display","none");
			$(this).parents("div").css("display","none");
		});
		$(".find-opera .add-button").click(function(){
			$(".shadow-bg").css("display","block");
			$(".grxxsz").css("display","block");
			findzu();
			finddept();
		});
		
		//个人信息设置tap切换
	$(".grxxsz ul li").click(function(){
		var idx = $(this).index();
		$(this).addClass("current").siblings("li").removeClass('current');
		$('.con').eq(idx).show().siblings('.con').hide();
	})
	
	$(".opera-button .del-bg").click(function(){
			$(".shadow-bg").css("display","block");
			//$(".mian").css("display","block");
			$("#mian").css("display","block");
		});
	
});