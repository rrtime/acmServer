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

/**合同提交**/
$("#contractAddBtn").click(function(){
	if($("#contract_serviceFee").val()==''){
		$("#contract_serviceFee").focus();
		return;
	}
	if($("#contract_payCycle").val()==1 && $("#contract_payDay").val()==''){
		$("#contract_payDay").focus();
		return;
	}
	$.ajax({ 
		url: "customer!updContract.do?"+$('#contractAddForm').serialize(), 
		type:"post",
		async: false,
		cache : false, 
		success: function(msg){
			alert(msg);
		},
		error: function(msg) {
            alert(msg);
        }
	});
	$.ajax({ 
		url: "customer!getContractHis.do?csrBasic.csrIdentifer="+$("#contract_cnIdentifer").val(), 
		cache: true,
		type:"get",
		async: false,
		dataType: 'json',
		success: function(data){
			$("#contractHisTable").html('');
			var html='<tr>';
			html+='<th align="left">业务类别</th>';
			html+='<th align="left">服务起始时间</th>';
			html+='<th align="left">服务截止时间</th>';
			html+='<th align="left">服务费</th>';
			html+='<th align="left">理票约定</th>';
			html+='</tr>';
			
			$.each(data,function(i,item){
				html+='<tr onclick="updCurContact('+item.id+')">'; 
				if(item.serviceType == 1){
					html+='<td align="left">代理记账、纳税申报</td>';
				}else if(item.serviceType == 2){
					html+='<td align="left">所得税汇算</td>';
				}else if(item.serviceType == 3){
					html+='<td align="left">咨询筹划</td>';
				}else if(item.serviceType == 4){
					html+='<td align="left">税务局沟通</td>';
				}else if(item.serviceType == 5){
					html+='<td align="left">上市服务</td>';
				}else if(item.serviceType == 6){
					html+='<td align="left">企业清算</td>';
				}else if(item.serviceType == 7){
					html+='<td align="left">企业重组</td>';
				}else if(item.serviceType == 8){
					html+='<td align="left">财产损失</td>';
				}else{
					html+='<td align="left"></td>';
				}
				html+='<td align="left">'+item.startTime+'</td>'; 
				html+='<td align="left">'+item.endTime+'</td>'; 
				html+='<td align="left">'+item.serviceFee+'</td>'; 
				if(item.sortType == 1){
					html+='<td align="left">自行理票</td>';
				}else if(item.sortType == 2){
					html+='<td align="left">我方理票</td>';
				}else{
					html+='<td align="left"></td>';
				}
				html+='</tr>'; 
			});
			$("#contractHisTable").append(html);
		},
		error: function() {
            alert("载入合同失败!");
        }
	});
	$("#contract_id").val('');
	$("#contract_serviceFee").val('');
})

/**收费历史**/
function fee_his(id){
	$.ajax({ 
		url: "customer!getFeeHis.do?cstFee.cid="+id, 
		cache: true,
		type:"get",
		async: false,
		dataType: 'json',
		success: function(data){
			$("#feeHisName").html($("#cst_csrName_"+id).val());
			$("#feeHisTable").html('');
			var html='<tr>';
			html+='<th align="left">收费时间</th>';
			html+='<th align="left">收费金额</th>';
			html+='<th align="left">服务起始时间</th>';
			html+='<th align="left">服务截止时间</th>';
			html+='<th align="left">收款人</th>';
			html+='</tr>';
			
			$.each(data,function(i,item){
				html+='<tr>'; 
				html+='<td align="left">'+item.feeTimeStr+'</td>'; 
				html+='<td align="left">'+item.feeSum+'</td>'; 
				html+='<td align="left">'+item.startTimeStr+'</td>'; 
				html+='<td align="left">'+item.endTimeStr+'</td>'; 
				html+='<td align="left">'+item.operator+'</td>';
				html+='</tr>'; 
			});
			$("#feeHisTable").append(html);
			$(".total3").css("display","block");
		},
		error: function() {
            alert("载入收费历史失败!");
        }
	});
	
}

/**合同历史**/
function contract_his(id,indentifer){
	//清空之前的数据
	$("#contract_id").val('');
	$("#contract_serviceFee").val('');
	$.ajax({ 
		url: "customer!getContractHis.do?csrBasic.csrIdentifer="+indentifer, 
		cache: true,
		type:"get",
		async: false,
		dataType: 'json',
		success: function(data){
			$("#contract_cnIdentifer").val(indentifer);
			$("#contract_csrName").text($("#cst_csrName_"+id).val());
			$("#contractHisTable").html('');
			var html='<tr>';
			html+='<th align="left">业务类别</th>';
			html+='<th align="left">服务起始时间</th>';
			html+='<th align="left">服务截止时间</th>';
			html+='<th align="left">服务费</th>';
			html+='<th align="left">理票约定</th>';
			html+='</tr>';
			
			$.each(data,function(i,item){
				html+='<tr onclick="updCurContact('+item.id+')">'; 
				if(item.serviceType == 1){
					html+='<td align="left">代理记账、纳税申报</td>';
				}else if(item.serviceType == 2){
					html+='<td align="left">所得税汇算</td>';
				}else if(item.serviceType == 3){
					html+='<td align="left">咨询筹划</td>';
				}else if(item.serviceType == 4){
					html+='<td align="left">税务局沟通</td>';
				}else if(item.serviceType == 5){
					html+='<td align="left">上市服务</td>';
				}else if(item.serviceType == 6){
					html+='<td align="left">企业清算</td>';
				}else if(item.serviceType == 7){
					html+='<td align="left">企业重组</td>';
				}else if(item.serviceType == 8){
					html+='<td align="left">财产损失</td>';
				}else{
					html+='<td align="left"></td>';
				}
				html+='<td align="left">'+item.startTime+'</td>'; 
				html+='<td align="left">'+item.endTime+'</td>'; 
				html+='<td align="left">'+item.serviceFee+'</td>'; 
				if(item.sortType == 1){
					html+='<td align="left">自行理票</td>';
				}else if(item.sortType == 2){
					html+='<td align="left">我方理票</td>';
				}else{
					html+='<td align="left"></td>';
				}
				html+='</tr>'; 
			});
			$("#contractHisTable").append(html);
			$(".total6").css("display","block");	
		},
		error: function() {
            alert("载入合同失败!");
        }
	});
	
}

/**根据合同ID查询合同信息**/
function updCurContact(id){
	$.ajax({ 
		url: "customer!getContractById.do?cstContract.id="+id, 
		cache: true,
		type:"get",
		async: false,
		dataType: 'json',
		success: function(data){
			$.each(data,function(i,item){
				$("#contract_id").val(item.id);
				$("#contract_cnIdentifer").val(item.csrIdentifer);
				$("#contract_serviceType").val(item.serviceType);
				$("#contract_serviceFee").val(item.serviceFee);
				$("#contract_startTime").val(item.startTime);
				$("#contract_endTime").val(item.endTime);
				$("#contract_payCycle").val(item.payCycle);
				$("#contract_payDay").val(item.payDay);
				$("#contract_sortType").val(item.sortType);
				$("#contract_remark").val(item.remark);
			})
		},
		error: function() {
            alert("载入合同失败!");
        }
	});
	
}

/**客户和税务提交**/
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