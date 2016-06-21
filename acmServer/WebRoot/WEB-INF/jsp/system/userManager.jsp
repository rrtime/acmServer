<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
<link rel="stylesheet" href="../css/rest.css"/>
<link rel="stylesheet" href="../css/dialog.css"/>
<link rel="stylesheet" href="../css/easyTree.css"/>
<link rel="stylesheet" href="../css/userManager.css"/>
<script type="text/javascript">
   //根据cpCode查询组
   function findzu(){
      $.ajax({
				type : "POST",
				url : "../xl/user!queryzuBycpCode.do",
				data : {},
				async : false,
				success : function(json) {//调用成功的话
						var jsonData = JSON.parse(json); 
						var array = jsonData.jsonlist;
						$("#zu").empty();
						for(var i=0;i<array.length;i++){
							$("#zu").append("<option value="+array[i].id+">"+array[i].iname+"</option>");
						}
				}
			});
   }
   //根据cpCode查询代账公司的部门
   function finddept(){
      $.ajax({
				type : "POST",
				url : "../xl/org!querydeptBycpCode.do",
				data : {},
				async : false,
				success : function(json) {//调用成功的话
						var jsonData = JSON.parse(json); 
						var array = jsonData.jsonlist;
						$("#dept").empty();
						for(var i=0;i<array.length;i++){
							$("#dept").append("<option value="+array[i].id+">"+array[i].gname+" "+array[i].rname+" "+array[i].orgName+"</option>");
						}
				}
			});
   }
   function save(){
       document.getElementById("userform").submit();
   }
   function delte(){
      var ids =  document.getElementsByName("id");
      var idvalues="";
      for(var i=1;i<ids.length;i++){
        if(ids[i].checked){
          //alert(ids[i].value);
          idvalues = ids[i].value+","+idvalues;
        }  
      }
      //alert(idvalues.substring(0,idvalues.lastIndexOf(",")));
      $("#ids").val(idvalues.substring(0,idvalues.lastIndexOf(",")));
      document.getElementById("idsform").submit();
   }
   function check(){
      var checkall = document.getElementById("CheckAll");
      var ids =  document.getElementsByName("id");
      if(checkall.checked){
          for(var i=0;i<ids.length;i++){
             ids[i].checked="ture";
          }
      }else if(!checkall.checked){
          for(var i=0;i<ids.length;i++){
             ids[i].checked="";
          }
      }
   }
   function delteone(obj){
		var url ="../xl/user!delete.do?atUser.id="+obj;
		window.location.href=url;	
   }
   function modify(obj){
      $.ajax({
				type : "POST",
				url : "../xl/user!findById.do?atUser.id="+obj,
				data : {},
				async : false,
				success : function(json) {//调用成功的话
						var jsonData = JSON.parse(json); 
						$(".shadow-bg").css("display","block");
	                    $(".grxxsz").css("display","block");
	                    $("#savebt").show(); 
	                    $("#username").attr("readonly",false);
						$("#email").attr("readonly",false);
						$("#telno").attr("readonly",false);
						$("#iname").attr("readonly",false);
						$("#workerNo").attr("readonly",false);
						$("#jobDuty").attr("readonly",false);
						$("#loginPwd").attr("readonly",false);
						$("#remark").attr("readonly",false);
	                    $("#atUserId").val(jsonData.atUserId);
	                    $("#username").val(jsonData.username);
	                    $("#email").val(jsonData.email);
	                    $("#telno").val(jsonData.telno);
	                    $("#iname").val(jsonData.iname);
	                    $("#workerNo").val(jsonData.workerNo);
	                    $("#jobDuty").val(jsonData.jobDuty);
	                    $("#loginPwd").val(jsonData.loginPwd);
	                    $("#remark").val(jsonData.remark);
	                    var sexobj =  document.getElementsByName("atUser.sex");
	                    for(var i=0;i<sexobj.length;i++){
	                         if(sexobj[i].value==jsonData.sex){
	                           sexobj[i].checked="ture";
	                         }
          				}
          				var array = jsonData.orglist;
						$("#zu").empty();
						for(var i=0;i<array.length;i++){
						    if(array[i].id==jsonData.parentId){
						        $("#zu").append("<option value="+array[i].id+" selected='selected'>"+array[i].iname+"</option>");
						    }else{
						        $("#zu").append("<option value="+array[i].id+">"+array[i].iname+"</option>");
 						    }
						}
						var array1 = jsonData.deptlist;
						$("#dept").empty();
						for(var i=0;i<array1.length;i++){
						    if(array1[i].id==jsonData.oid){
						       $("#dept").append("<option value="+array1[i].id+" selected='selected'>"+array1[i].gname+" "+array1[i].rname+" "+array1[i].orgName+"</option>");
						    }else{
						       $("#dept").append("<option value="+array1[i].id+">"+array1[i].gname+" "+array1[i].rname+" "+array1[i].orgName+"</option>");
						    }
						}
				}
			});
   }
   function find(obj){
      modify(obj);
      $("#username").attr("readonly","readonly");
	  $("#email").attr("readonly","readonly");
	  $("#telno").attr("readonly","readonly");
	  $("#iname").attr("readonly","readonly");
	  $("#workerNo").attr("readonly","readonly");
	  $("#jobDuty").attr("readonly","readonly");
	  $("#loginPwd").attr("readonly","readonly");
	  $("#remark").attr("readonly","readonly");
	  $("#savebt").hide(); 
   }
   function search(){
     var username = $("#name").val();
     var url="../xl/user!queryByUsername.do?atUser.userName="+username;
     window.location.href=url;
   }
   function findByOrgId(obj,obj1){
     var url="../xl/user!findByOrgId.do?atUser.oid="+obj1+"&org.oid="+obj;
     window.location.href=url;
   }
   function savedept(){
      var oid = $("#sjdept").val(); 
      var orgName = $("#orgName").val();
      var orgDesc = $("#orgDesc").val(); 
      var orgId = $("#orgId").val();
      var url="../xl/user!insertOrg.do?org.orgName="+orgName+"&org.orgDesc="+orgDesc+"&org.id="+orgId+"&org.oid="+oid;
      window.location.href=url;
   }
   function editorg(){
      var orgId = $("#sysorgId").val();
      $.ajax({
				type : "POST",
				url : "../xl/org!orgDetail.do?aso.id="+orgId,
				data : {},
				async : false,
				success : function(json) {//调用成功的话
						var jsonData = JSON.parse(json); 
						$("#orgName").val(jsonData.orgName);
                        $("#orgDesc").val(jsonData.orgDesc);
                        $("#orgId").val(jsonData.orgId);
				}
			});
   }
   function deletedept(){
      var orgId = $("#sysorgId").val();
      var url="../xl/user!deleteOrg.do?org.id="+orgId;
      window.location.href=url;
   }
   function queryorgId(obj,obj1,obj2){
      $("#sysoId").val(obj);
	  $("#sysorgId").val(obj1);
      $.ajax({
				type : "POST",
				url : "../xl/org!juniorlist.do?aso.oid="+$("#sysoId").val()+"&aso.id="+$("#sysorgId").val(),//obj
				data : {},
				async : false,
				success : function(json) {//调用成功的话
						var jsonData = JSON.parse(json); 
						//$("#sysorgId").val(obj1);
						if(jsonData.status=="0"){
						   var array = jsonData.jsonlist;
							$("#sjdept").empty();
							var oid =  $("#sysoId").val();
							for(var i=0;i<array.length;i++){
								  if(obj2=="1"){//编辑状态
								      if(oid==array[i].id){
								         $("#sjdept").append("<option value="+array[i].id+" selected='selected'>"+array[i].orgName+"</option>");
								      }else{
								         $("#sjdept").append("<option value="+array[i].id+">"+array[i].orgName+"</option>");
								      }
								  }else{
								     $("#sjdept").append("<option value="+array[i].id+">"+array[i].orgName+"</option>");
								  }
							}
						}else{
						   $("#sjdept").empty();
						   $("#sjdept").append("<option value='0'>公司组织架构</option>");
						}
				}
			});
   }
</script>
</head>
<body>
<!--total-role start-->
<div class="total-role">
	<div class="role-definite">
    	<h2 class="role-word">部门管理</h2>
        <div class="opera">
        	<div class="opera-button clearfix">
        	    <input type="hidden" id="sysorgId" value="${orgId}"/>
        	    <input type="hidden" id="sysoId" value="${oid}"/>
            	<a class="add-bg" href="#">新增</a>
                <a class="edit-bg" href="#">编辑</a>
                <a class="del-bg" href="#">删除</a>
            </div>
            
            <!--tree-modal start-->
            <div class="tree-modal">
            	<div class="system-role">
                	<img src="../images/dotted.png" alt=""/>
                    <a href="#">公司组织架构</a>
                </div>
                <div class="tree-box easy-tree">
                    <ul class="tree-list">
                        <!--<li><a href="#">系统角色</a></li>-->
                        <li>
                            <ul class="sort-a">
                                 <s:iterator value="#request.orglist" id="orglist" status="st">
                                     <s:if test="#orglist.oid==0">
	                                     <li><a href="#" onclick="queryorgId('<s:property value="#orglist.oid"/>','<s:property value="#orglist.id"/>','0')"><s:property value="#orglist.orgName"/></a>
	                                       <ul>
	                                          <s:iterator value="#request.orglist" id="orglist2" status="st">
	                                              <s:if test="#orglist2.oid==#orglist.id">
	                                                  <li><a href="#" onclick="queryorgId('<s:property value="#orglist2.oid"/>','<s:property value="#orglist2.id"/>','0')"><s:property value="#orglist2.orgName"/></a>
	                                                     <ul>
	                                                        <s:iterator value="#request.orglist" id="orglist3" status="st">
	                                                            <s:if test="#orglist3.oid==#orglist2.id">
	                                                               <li><a href="#" onclick="findByOrgId('<s:property value="#orglist3.oid"/>','<s:property value="#orglist3.id"/>')"><s:property value="#orglist3.orgName"/></a></li>
	                                                            </s:if>
	                                                        </s:iterator>
	                                                     </ul>
	                                                  </li>
	                                              </s:if>
	                                          </s:iterator>
	                                       </ul>
	                                     </li>
                                     </s:if>
                                 </s:iterator>
                                <!--  <li><a href="#">管理员</a>
                                    <ul>
                                        <li><a href="#">员工</a>
                                        	<ul>
                                            	<li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">经理</a></li>
                                        <li><a href="#">出纳</a></li>
                                        <li><a href="#">记账员</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">经理</a></li>
                                <li><a href="#">出纳</a></li>
                                <li><a href="#">记账员</a></li>-->
                            </ul>
                        </li>
                    </ul>
            </div>
            </div>
          <!--tree-modal end-->
            
        </div>
     </div>
 
    <!--右部-->
    <div class="role-list">
    	<div class="find-opera">
        	<input class="add-button" id="add" type="button" value="新增" />
        	<input class="del-button" type="button" value="删除" />
        	<div class="search">
        		<ul>
        			<li>姓名：</li>
        			<li><input type="text" id="name" value=""/></li>
        			<li><input type="button"  value="查询" onclick="search()"/></li>
        		</ul>
        	</div>
        	
        </div>
        <div style="clear:both;"></div>
        <table class="table">
        	<tr>
            	<th><input type="checkbox" id="CheckAll" onclick="check()"/></th>
                <th>姓名</th>
                <th>性别</th>
                <th>登陆账号</th>
                <th>邮箱</th>
                <th>手机号码</th>
                <th>部门</th>
                <th>岗位职务</th>
                <th>操作</th>
            </tr>
            
             <s:iterator value="#request.list" id="asoList" status="st">
                <tr>
                    <td><input type="checkbox" name="id" value="${id}"/></td>
	                <td><s:property value="#asoList.userName"/></td>
	                <td><c:if test="${sex eq '1' }">男</c:if><c:if test="${sex eq '2' }">女</c:if></td>
	                <td><s:property value="#asoList.iname"/></td>
	                <td><s:property value="#asoList.email"/></td>
	                <td><s:property value="#asoList.telno"/></td>
	                <td><s:property value="#asoList.orgName"/></td>
	                <td><s:property value="#asoList.jobDuty"/></td>
	                <td><img src="../images/pic15.png" style="cursor: hand" onclick="modify('${id}')"/><img src="../images/pic16.png" style="cursor: hand" onclick="find('${id}')"/><img src="../images/pic17.png" style="cursor: hand" onclick="delteone('${id}')"/></td>
                </tr>
             </s:iterator>
             
        </table>
        <!--底部-->
        <div class="footer">
            <input type="button" value="首页">
            <input type="button" value="上一页">
            <span class="span">1</span>
            <input type="button" value="下一页">
            <input type="button" value="尾页">
            <b>总1条，共1页，每页</b>
            <select name="">
                <option value="">25</option>
                <option value="">50</option>
                <option value="">100</option>
            </select>
            <b>到第</b>
            <span>2</span>
            <input class="button"type="button" value="确定">
        </div>
    </div>
</div>
<!--total-role end-->
<!--弹窗-->
<div class="shadow-bg"></div>
<div class="add-word">
    <h1>新增部门<span class="close-button right"></span></h1>
    <div class="bor">
   
        <div class="intt inf">
             <label class="lable class="lables">上级部门：</label>
            <select class="required" id="sjdept">
               <!--   <option value="1">January</option>
                <option value="2">February</option>
                <option value="3">March</option>
                <option value="4">April</option>
                <option value="5">May</option>
                <option value="6">June</option>
                <option value="7">July</option>
                <option value="8">August</option>
                <option value="9">September </option>
                <option value="10">October </option>
                <option value="11">November</option>
                <option value="12">December </option>-->
            </select>
        </div> 
        <div class="intt indd">
        <input type="hidden" id="orgId" value=""/>
            <label class="lables"><span>*</span>部门名称：</label>
            <input type="text" id="orgName" class="dz" value=""/>
        </div>
        <div class="intt indd inss">
            <label class="lables"><span>*</span>部门描述：</label>
            <input type="text" id="orgDesc" class="dz" value=""/>
            <div class="banner">
                <img src="../images/pic12.png"/><p>不能为空</p>
            </div>
        </div>
    </div>
    <input class="submit"type="button" value="保存" onclick="savedept()"/>
    <input class="reset"type="reset" value="取消"/>
    </div>
<!---->
<div class="mian">
    <form id="idsform" action="../xl/user!deletemore.do">
    <input type="hidden" id="ids" name="ids" value=""/>
    <h1 class="mian-title">提示<span class="close-button right"></span></h1>
    <div class="delete">
        <img src="../images/pic14.png"/>
    <p>你确定要删除吗?</p>
    </div>
    <input class="submit1" type="button" value="确定" onclick="delte()"/>
    <input class="reset1"type="reset" value="取消"/>
    </form>
</div>

<div class="mian" id="mian">
    <h1 class="mian-title">提示<span class="close-button right"></span></h1>
    <div class="delete">
        <img src="../images/pic14.png"/>
    <p>你确定要删除吗?</p>
    </div>
    <input class="submit1" type="button" value="确定" onclick="deletedept()"/>
    <input class="reset1"type="reset" value="取消"/>
</div>

<div class="grxxsz">
				<h1>个人信息设置<span class="close-button right mr18"></span></h1>
				<ul>
					<li class="current">用户信息</li>
					<!--  <li>人事信息</li>  -->
				</ul>
				<div class="con" style="display: block;">
					<form id="userform" action="../xl/user!insertUser.do">
						<div class="content">
								<table class="tab" >
									<tbody>
										<tr>
											<th align="right"><span style="color:#ff0000;">*</span>姓名：</th>
											<td><input type="hidden" id="atUserId" name="atUserId" value=""/><input id ="username" name="atUser.userName" type="text" value="" /></td>
										</tr>
										<tr >
											<th align="right">性别：</th>
											<td class="td"><input type="radio" name="atUser.sex" value="1"/><span>男</span><input type="radio" name="atUser.sex" value="2"><span>女</span></td>			
										</tr>
										<tr>
											<th align="right">E-mail：</th>
											<td><input id="email" class="email" name="atUser.email" type="text" value="" /></td>
										</tr>
										<tr>
											<th align="right">联系电话：</th>
											<td><input class="tel" id="telno" name="atUser.telno" type="text" /></td>
										</tr>
										<tr>
											<th align="right">部门：</th>
											<td><select class="required" id="dept" name="atUser.oid"></select></td>
										</tr>
									</tbody>
								</table>
								<table class="tab">
									<tbody>
										<tr>
											<th align="right"><span style="color:#ff0000;">*</span>登陆账号：</th>
											<td><input id ="iname" name="atUser.iname" class="xm" type="text" value="" /></td>
										</tr>
										<tr>
											<th align="right">员工编号：</th>
											<td><input type="text" id="workerNo" name="atUser.workerNo" value=""/></td>
										</tr>
										<tr>
											<th align="right">岗位职务：</th>
											<td><input  type="text" id="jobDuty" name="atUser.jobDuty" value="" /></td>
										</tr>
										<tr class="tab-tr">
											<th align="right">登录密码：</th>
											<td><input class="tab-pw" style="width:200px; height:30px; line-height:30px; overflow:hidden; border:1px solid #d5d5d5;"  type="password" id="loginPwd" name="atUser.loginPwd" value=""/></td>
										</tr>
										<tr>
											<th align="right">备注：</th>
											<td><input type="text" id="remark" name="atUser.remark" value=""/></td>
										</tr>				
									</tbody>
								</table>
								<div style="clear:both"></div>
								 <div class="int">
							        <label >联系地址:</label>
							        <input type="text"  class="dz" />
							    </div>
							    <div class="int ind">
							        <label >用户组:</label>
							         <select class="required" id="zu" name="augl.gid">
							         <!-- 
									     <option value="1">January</option>
									     <option value="2">February</option>
									     <option value="3">March</option>
									     <option value="4">April</option>
									     <option value="5">May</option>
									     <option value="6">June</option>
									     <option value="7">July</option>
									     <option value="8">August</option>
									     <option value="9">September  </option>
									     <option value="10">October </option>
									     <option value="11">November</option>
									     <option value="12">December </option> -->
									  </select>
							    </div>
						</div>
						<input calss="submit" type="button" id="savebt" value="保存" onclick="save()"/>
						<input type="reset" value="重置"/>
					</form>
				</div>
				<!--  <div class="con">
				<form action="">
				<div class="content">
                <table class="tab">
                    <tbody>

                        <tr>
                            <th align="right"><span style="color:#ff0000;">*</span>姓名：</th>
                            <td><input id "username" type="text" placeholder="  姚先慧" /></td>
                        </tr>
                        <tr>
                            <th align="right">性别：</th>
                                <td class="td"><input type="radio" /><span>男</span><input type="radio" checked="checked"><span>女</span></td>			
                        </tr>
                        <tr>
                            <th align="right">E-mail：</th>
                            <td><input id="email" class="email" type="text" placeholder=" xiaoli233434@hotmail.com" /></td>
                        </tr>
                        <tr>
                            <th align="right">联系电话：</th>
                            <td><input class="tel" type="text" /></td>
                        </tr>
                        <tr>
                            <th align="right">部门：</th>
                            <td><input class="email" type="text" placeholder=" xiaoli233434@hotmail.com" /></td>
                        </tr>
                    </tbody>
                </table>
                <table class="tab">
                    <tbody>
                        <tr>
                            <th align="right"><span style="color:#ff0000;">*</span>登陆账号：</th>
                            <td><input id "username" class="xm" type="text" placeholder="  410454543" /></td>
                        </tr>
                        <tr>
                            <th align="right">出生日期：</th>
                            <td><input class="tel" type="text" />
                        </tr>
                        <tr>
                            <th align="right">手机：</th>
                            <td><input  type="text" placeholder="13632683556" /></td>
                        </tr>
                        <tr>
                            <th align="right">qq：</th>
                            <td><input  type="text" /></td>
                        </tr>
                        <tr>
                            <th align="right">备注：</th>
                            <td><input type="text"  /></td>
                        </tr>
                    </tbody>
                </table>
				<div style="clear:both"></div>
                     <div class="int">
                        <label >联系地址:</label>
                        <input type="text"  class="dz" />
                    </div>
                    <div class="int ind">
                        <label >用户组:</label>
                         <select class="required">
                             <option value="1">January</option>
                             <option value="2">February</option>
                             <option value="3">March</option>
                             <option value="4">April</option>
                             <option value="5">May</option>
                             <option value="6">June</option>
                             <option value="7">July</option>
                             <option value="8">August</option>
                             <option value="9">September  </option>
                             <option value="10">October </option>
                             <option value="11">November</option>
                             <option value="12">December </option>
                          </select>
                    </div>
				</div>
						<input calss="submit"type="submit" value="保存"/>
						<input type="reset" value="重置"/>
					</form>
				</div>-->
			</div>
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/dialog.js"></script>
<script src="../js/easyTree.js"></script>
</body>
</html>

