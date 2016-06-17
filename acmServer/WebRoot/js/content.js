// JavaScript Document
$(function(){
	/*工作台管理*/
	var t=1
	$(".workbench .title-right").click(function(){
		if(t==0){
			$(this).html("管理");
			$(".work-list .sort-close").css("display","none");
			t=1
		}else{
			$(this).html("完成");
			$(".work-list .sort-close").css("display","block");
			t=0
		}
			
	});
	
	$(".work-list .sort-close").click(function(){
		$(this).parent("dl").hide();	
	});
	
	$(".modules .grey-close").click(function(){
		$(this).parents(".modules").hide();
	});
	/*面板拖动*/
	$('.jq22').dad({
		draggable: '.work-title'
	});
});