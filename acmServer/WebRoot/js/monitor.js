//转到添加主机页面js
$(function(){
	 $("#addserverpg").click(function(){
    window.parent.frames["Right"].location.href ="monitorListAction!addserverpage.do";
	}); 
});

//添加主机js
$(function(){
	 $("#addsersub").click(function(){
		if ($("form input[name='mtMonitorList.sServerName']").val() <=0) {alert("Plase Input ServerName"); return false;}
		if ($("form input[name='mtMonitorList.sIp']").val() <=0) {alert("Plase Input ServerIp"); return false;}
		if(!checkIP($("form input[name='mtMonitorList.sIp']").val())){alert("Invalid IP Plese Please input again");return false; };
		if ($("form input[name='mtMonitorList.sLoginName']").val() <=0) {alert("Plase Input ServerLoginName"); return false;}
		if ($("form input[name='mtMonitorList.sLoginPasswd']").val() <=0) {alert("Plase Input ServerLoginPasswd"); return false;}
		if ($("form input[name='mtMonitorList.sConnectPort']").val() <=0) {alert("Plase Input ConnectPort"); return false;}
		var port = $("form input[name='mtMonitorList.sConnectPort']").val();
		if(!(/^(\+|-)?\d+$/.test( port )) || port < 0){alert("ConnectPort for digital ! "); return false;}
		var remark=$("#remark").val();
		if (remark.length >100){ alert("Remark Limits the maximum length of 100");return false; }
		checkaddip();
	 });
});

//修改主机js
$(function(){
	 $("#modifysub").click(function(){
		if ($("form input[name='mtMonitorList.sServerName']").val() <=0) {alert("Plase Input ServerName"); return false;}
		if ($("form input[name='mtMonitorList.sIp']").val() <=0) {alert("Plase Input ServerIp"); return false;}
		if(!checkIP($("form input[name='mtMonitorList.sIp']").val())){alert("Invalid IP Please input again");return false; };
		if ($("form input[name='mtMonitorList.sLoginName']").val() <=0) {alert("Plase Input ServerLoginName"); return false;}
		if ($("form input[name='mtMonitorList.sConnectPort']").val() <=0) {alert("Plase Input ConnectPort"); return false;}
		var port = $("form input[name='mtMonitorList.sConnectPort']").val();
		if(!(/^(\+|-)?\d+$/.test( port )) || port < 0){alert("ConnectPort for digital ! "); return false;}
		if ($("form input[name='mtMonitorList.sLoginPasswd']").val() <=0) {alert("Plase Input ServerLoginPasswd"); return false;}
		if ($("form input[name='ConfirmPasswd']").val() <=0) {alert("Plase Input ConfirmPasswd"); return false;}
		if($("form input[name='mtMonitorList.sLoginPasswd']").val() != $("form input[name='ConfirmPasswd']").val())
		{
			alert("Passwords do not match"); return false; 
		}
		var remark=$("#remark").val();
		if (remark.length >100){ alert("Remark Limits the maximum length of 100");return false; }
		if($("form input[name='mtMonitorList.sIp']").val() != $("#hip").val())
		{
			checkmodip();
		}else{
				if(confirm("Modiry monitor server"))
				{ 
				$("#updateserver").submit();
				}
		}
	 });
});

function checkaddip(){
	$.ajax({
		   url:"monitorListAction!checkip.do?mtMonitorList.sIp="+$("form input[name='mtMonitorList.sIp']").val(),
		   type:"POST",
		   dataType:"text",
		   success:function(data)
		     {
	           if(parseInt(data)==1){
	                        alert("The Ip Exist");
	                        return false;
                           }else{
                       				if(confirm("Confirm add the monitor server"))
                       				{ 
                       					$("#addserver").submit();
                       				}
                                }
             }
     });
}

function checkmodip(){
	$.ajax({
		   url:"monitorListAction!checkip.do?mtMonitorList.sIp="+$("form input[name='mtMonitorList.sIp']").val(),
		   type:"POST",
		   dataType:"text",
		   success:function(data)
		     {
	           if(parseInt(data)==1){
	                        alert("The Ip Exist");
	                        return false;
                           }else{
		                       		if(confirm("Modiry monitor server"))
		                    		{ 
		                    			$("#updateserver").submit();
		                    		}
                                }
             }
     });
}

//判断ip地址合法性
function checkIP(value){
    var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    var reg = value.match(exp);
    if(reg==null)
    {
    return false;
    }return true;
}

//分页查询js
function mSub(type)
{
	var curpage = 0;
	if($("#currentPage").val() != "")
	{
		curpage = $("#currentPage").val();
	}
	else
	{
		curpage = 1;
	}
	// search
	if( 's' == type )
	{
		if( $("#txt2").val() != null && $("#txt2").val() != "")
		{
			if( $("#txt3").val() == null ||$("#txt3").val() == "")
			{
				alert("Please input the query end time");
				return false;
			}
		}
		if( $("#txt3").val() != null && $("#txt3").val() != "")
		{
			if( $("#txt2").val() == null || $("#txt2").val() == "")
			{
				alert("Please input the query start time");
				return false;
			}
		}
		curpage = 1;
	}
	// index
	else if( 'index' == type )
	{
		if( curpage == 1 )
		{
			alert("This page is index.");
			return;
		}
		else
			curpage = 1;
	}
	else if( 'pr' == type )
	{
		if( curpage == 1 )
		{
			alert("This page is index.");
			return;
		}
		else
		{
			curpage = parseInt(curpage) - 1;
		}
	}
	else if( 'next' == type )
	{
		var top = $("#totalPage").val();
		if( curpage == top )
		{
			alert("This page is end.");
			return;
		}
		else
		{
			curpage = parseInt(curpage) + 1;
			
		}
	}
	else if( 'end' == type )
	{
		var top = $("#totalPage").val();
		if( curpage == top )
		{
			alert("This page is end.");
			return;
		}
		else
		{
			curpage = top;
			
		}
	}
	$("#currentPage").val(curpage);
	$("#queryfrom").submit();
}