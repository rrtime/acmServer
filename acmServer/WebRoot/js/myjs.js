// JavaScript Document
$(function(){
	$('#tabs').addtabs({monitor:'.topbar'});
	$('#save').click(function(){
		Addtabs.add({
		   id: $(this).attr('addtabs'),
		   title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
		   content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
		   url: $(this).attr('url'),
		   ajax: $(this).attr('ajax') ? true : false
		})
	});
	
	$(".btn-group li a").click(function(){
		$(this).find(".arrow").toggleClass("turn-clicked");
		$(this).find(".blue-arrow").toggleClass("second-clicked");
		$(this).parent().siblings().find("ul").slideUp();
		$(this).parent().siblings().find(".arrow").removeClass("turn-clicked");
		$(this).parent().siblings().find(".blue-arrow").removeClass("second-clicked");
		$(this).siblings("ul").slideToggle();
	});
	$(".btn-group .second-level .line").click(function(){
		$(this).siblings().find(".grey-square").removeClass("blue-square");
		$(this).find(".grey-square").addClass("blue-square");	
	});
	$(".information .welcome").mouseover(function(){
		$(this).find(".set-menu").css("display","block");
	}).mouseout(function(){
		$(this).find(".set-menu").css("display","none");
	});
	
	$(".btn-group>li .same").mouseover(function(){
		$(this).parent().siblings().removeClass("hover");
		$(this).parent().addClass("hover");
	}).mouseout(function(){
		$(".btn-group>li").removeClass("hover");
		});
		$(".btn-group>li .same").click(function(){
			$(this).parent().siblings().removeClass("click-hover");
			$(this).parent().addClass("click-hover");
		});
	/*function iFrameHeight() {   
		var ifm= document.getElementById("iframepage");   
		var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight;
		   ifm.width = subWeb.body.scrollWidth;
		} 
		}*/ 
		
})
 