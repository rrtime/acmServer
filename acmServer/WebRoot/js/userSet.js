$(function(){
//	tap切换
	$(".main ul li").click(function(){
		var idx = $(this).index();
		$(this).addClass("current").siblings("li").removeClass('current');
		$('.xinxi').eq(idx).show().siblings('.xinxi').hide();
	})
//	个人信息设置tap切换
	$(".grxxsz ul li").click(function(){
		var idx = $(this).index();
		$(this).addClass("current").siblings("li").removeClass('current');
		$('.con').eq(idx).show().siblings('.con').hide();
	})

})
