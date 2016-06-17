// JavaScript Document
$(function(){
	//$(".tree-list li ul").hide();
	$(".tree-list li a").click(function(){
		//$(this).children("ul").slideToggle();
		//alert("aa")
		$(this).siblings("ul").toggleClass("none");
	});
	$(".easy-tree").find('li:has(ul)').addClass('parent_li');
	$(".tree-box .tree-list .parent_li>a").click(function(){
		//alert("aa")
		$(this).parent().toggleClass("open-file");
	});
});