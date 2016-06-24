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
	
		$(".w_li").click(function(){
			$(".total3").css("display","block");	
		});
		$(".click").click(function(){
			$(".total6").css("display","block");	
		});
		$(".bunt").click(function(){
			$(".total4").css("display","block");	
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
		
	/**新增客户**/
	$("#cstAddBtn").click(function(){
		cstSubmit();
		
	})
	$("#ftAddBtn").click(function(){
		cstSubmit();
		
	})
	function cstSubmit(){
		if($("#csrIdentifer").val()==''){
			$("#tab1").click();
			$("#csrIdentifer").focus();
			return;
		}
		if($("#csrName").val()==''){
			$("#tab1").click();
			$("#csrName").focus();
			return;
		}
		if($("#csrType").val()==''){
			$("#tab1").click();
			$("#csrType").focus();
			return;
		}

		if($("#ownDeclareTime").val()==''){
			$("#tab2").click();
			$("#ownDeclareTime").focus();
			return;
		}
		if($("#ownTaxRate").val()==''){
			$("#tab2").click();
			$("#ownTaxRate").focus();
			return;
		}
		if($("#addTaxDeclareTime").val()==''){
			$("#tab2").click();
			$("#addTaxDeclareTime").focus();
			return;
		}
		if($("#addTaxRate").val()==''){
			$("#tab2").click();
			$("#addTaxRate").focus();
			return;
		}
		$("#csrAddForm").attr("action","customer!addCustomer.do");
		$("#csrAddForm").submit();
	}
	
	/**新增收费信息**/
	$("#feeAddBtn").click(function(){
		$("#feeAddForm").attr("action","customer!addFee.do");
		$("#feeAddForm").submit();
	})
	
	/**搜索**/
	$("#searchBtn").click(function(){
		if($("#keyword").val()==''){
			$("#keyword").focus();
			return;
		}
		$("#searchFrom").attr("action","customer!list.do");
		$("#searchFrom").submit();
	})
	
	/**新增回访信息**/
	$("#visitAddBtn").click(function(){
		if($("#visit_customer").val()==''){
			$("#visit_customer").focus();
			return;
		}
		$("#visitAddForm").attr("action","customer!addVisit.do");
		$("#visitAddForm").submit();
	})
	/**新增投诉信息**/
	$("#complainAddBtn").click(function(){
		if($("#complain_cnTheme").val()==''){
			$("#complain_cnTheme").focus();
			return;
		}
		$("#complainAddForm").attr("action","customer!addComplain.do");
		$("#complainAddForm").submit();
	})
	/**新增质量赔付信息**/
	$("#imyAddBtn").click(function(){
		if($("#cstImy_cid").val()==''){
			$("#cstImy_cid").focus();
			return;
		}
		$("#imyAddForm").attr("action","customer!addImy.do");
		$("#imyAddForm").submit();
	})
})

/**收费**/
	function fee(id){
		$("#fee_cid").val(id);
		$("#fee_nid").val($("#cst_acc_"+id).val());
		$("#fee_csrName").text($("#cst_csrName_"+id).val());
		$("#fee_csrOwner").text($("#cst_csrOwner_"+id).val());
		$("#fee_htbh").text($("#cst_acc_"+id).val());
		$(".total5").css("display","block");	
	}
/**回访**/
function visit(id){
	$("#visit_cnIdentifer").val($("#cst_csrIdentifer_"+id).val());
	$("#tab_hf").click();
	$("#tab_hf").show();
	$("#tab_ts").hide();
	$("#tab_zlpf").hide();	
	$(".total1").css("display","block");
}
/**投诉**/
function complain(id){
	$("#complain_cnIdentifer").val($("#cst_csrIdentifer_"+id).val());
	$("#tab_ts").click();
	$("#tab_ts").show();
	$("#tab_hf").hide();
	$("#tab_zlpf").hide();	
	$(".total1").css("display","block");
}
/**质量赔付**/
function imy(id){
	$("#imy_cnIdentifer").val($("#cst_csrIdentifer_"+id).val());
	$("#cstImy_cid").html($("#cst_ac_"+id).html());
	$("#tab_zlpf").click();	
	$("#tab_zlpf").show();
	$("#tab_ts").hide();
	$("#tab_hf").hide();	
	$(".total1").css("display","block");
}