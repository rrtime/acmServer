$(function(){
//	tap切换
	$(".w_ul li").click(function(){
		var idx = $(this).index();
		$(this).addClass("current").siblings("li").removeClass('current');
		$('.w_con').eq(idx).show().siblings('.w_con').hide();
	})
})