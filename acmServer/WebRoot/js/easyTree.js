// JavaScript Document
$(function(){
	$(".tree-list li a").click(function(){
		$(this).siblings("ul").toggleClass("none");
	});
	$(".easy-tree").find('li:has(ul)').addClass('parent_li');
	$(".tree-box .tree-list .parent_li>a").click(function(){
		$(this).parent().toggleClass("open-file");
	});
	$(".sort-a li a").click(function(){
		$(this).parents("li").siblings().find("a").removeClass("se");	
		$(this).addClass("se");
	});
});