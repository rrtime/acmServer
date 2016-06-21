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
	//$("#queryfrom").submit();
	var username = $("#name").val();
    var url="../xl/user!queryByUsername.do?atUser.userName="+username+"&page.currentPage="+$("#currentPage").val();
    window.location.href=url;
}

//分页查询js(费率策略指定开发者和套餐专用)
function mSubDev(type)
{
	var curpage = 0;
	if($("#currentPage1").val() != "")
	{
		curpage = $("#currentPage1").val();
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
		var top = $("#totalPage1").val();
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
		var top = $("#totalPage1").val();
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
	$("#currentPage1").val(curpage);
	$("#queryDevfrom").submit();
}

/**  
 * 检查输入对象的值是否符合端口号格式  
 */  
function check_port(obj)   
{   
    var re =  /^([0-9]|[1-9]\d|[1-9]\d{2}|[1-9]\d{3}|[1-5]\d{4}|6[0-4]\d{3}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])$/;      
    if (!re.test(obj))   
    {   
        Ext.Msg.show(   
        {   
            title:'提示',    
            msg:"上报端口请输入0到65535的整数",   
            buttons:Ext.Msg.OK,   
            icon:Ext.Msg.INFO   
        });   
        return false;   
    }   
} 

