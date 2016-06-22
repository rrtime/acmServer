//$(function(){
////	tap切换
////	$(".w_mian .ul li").click(function(){
////		var idx = $(this).index();
////		$(this).addClass("current").siblings("li").removeClass('current');
////		$('.ol').eq(idx).show().siblings('.ol').hide();
////	})
////	
//	
//})
$(function(){
//	tap切换
	$(".w_mian .ul li").click(function(){
		var idx = $(this).index();
		//$("#table tr td").find(".tab-change1").css("display","none");
		$(this).addClass("current").siblings("li").removeClass('current');
		//$('.ol').eq(idx).show().siblings('.ol').hide();
		$("#table tr th").find(".tab-change").css("display","none");
		$("#table tr th").find(".tab-change").eq(idx).css("display","block");
		
		
		//$("#table tr td").find(".tab-change1").css("display","block");
		
		
		
	})
	$(".w_mian .ul li:first").click(function(){
		$("#table tr td").find(".tab-change1").css("display","none");
		$("#table tr td").find(".tab-change").css("display","block");
	});
	$(".w_mian .ul li:last").click(function(){
		$("#table tr td").find(".tab-change").css("display","none");
		$("#table tr td").find(".tab-change1").css("display","block");
	});
	
	$(".num").mouseover(function(){
			$(this).find(".tab-copy").css("display","block");
		}).mouseout(function(){
			$(this).find(".tab-copy").css("display","none");	
			});
			
	$(".total4 .w_ool li").click(function(){
		var idx = $(this).index();
		$(this).addClass("current").siblings("li").removeClass('current');
		$('.w_conen').eq(idx).show().siblings('.w_conen').hide();
	})
})