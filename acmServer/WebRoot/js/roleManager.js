$("#saveRoleBtn").click(function () {
	$("#functionForm").submit();
});
$("#addRoldBtn").click(function () {
	if($("#roleName").val()==''){
		$("#addTipText").text('请输入角色名称!');
		$("#addTip").css("display","block");
		$("#roleName").focus();
		return;
	}
	$("#roleAddForm").submit();
});
$("#roleName").keyup(function(){
	$("#addTip").css("display","none");
});
$("#all").click(function(){    
    if(this.checked){    
        $("#list :checkbox").attr("checked", true);   
    }else{    
        $("#list :checkbox").attr("checked", false); 
    }    
});
function check(id){
	if($("#"+id+"").prop("checked")){    
        $("#tb_"+id+" :checkbox").prop("checked", true);   
    }else{    
        $("#tb_"+id+" :checkbox").prop("checked", false); 
    }    
}
function check1(id){
	if($("#"+id+"").prop("checked")){    
        $("#tb1_"+id+" :checkbox").prop("checked", true);  
        $("#tb2_"+id+" :checkbox").prop("checked", true);
    }else{    
        $("#tb1_"+id+" :checkbox").prop("checked", false); 
        $("#tb2_"+id+" :checkbox").prop("checked", false); 
    }    
}