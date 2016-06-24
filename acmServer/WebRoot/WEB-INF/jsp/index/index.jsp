<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>ACM Index</title>
<link rel="stylesheet" href="../css/rest.css"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-addtabs.css"/>
<link rel="stylesheet" href="../css/index.css"/>
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-addtabs.js"></script>
<script src="../js/myjs.js"></script>
<script src="../js/Marquee.js"></script>

</head>

<body>
<!--banner start-->
    <div class="banner">
    	<div class="wrapper clearfix">
            <a class="logo" href="#"></a>
            <span class="company-name"><s:property value="atCompanyAgent.cpNameAll"/></span>
            <ul class="right information">
         		<li class="li-infor">
                	<div class="message">
                    	<span class="bell"></span>
                        <strong class="num">2</strong>	
                    </div>
                    <ul class="infor-list">
                    	<li><a class="orage-circle" href="#"><strong>销售备货预警</strong><span class="orage-num">2</span></a></li>
                        <li><a class="orage-circle" href="#"><strong>销售备货预警</strong><span class="orage-num">2</span></a></li>
                        <li><a class="orage-circle" href="#"><strong>销售备货预警</strong><span class="orage-num">2</span></a></li>
                    </ul>
                </li>
                <li class="customer">
                	<a class="sevice" href="#">在线客服</a>
                    <ul class="customer-list">
                    	<li><a class="qq" href="#">QQ咨询</a></li>
                        <li><a class="phone" href="#">电话咨询</a></li>
                        <li><a class="person" href="#">人工服务</a></li>
                    </ul>
                </li>
                <li class="welcome">
                	<a class="drop-title clearfix" href="#">
                    	<img class="head-pic left" src="../images/head.png" alt=""/>
                        <span class="welcome-word left">欢迎您${sessionScope.loginUser.iname}</span>
                        <img class="turn-arrow left" src="../images/turnarrow.png" alt=""/>
                        
                    </a>
                     <div class="topbar admin-header">
	           				<div class="topbar-collapse">
	                        	<ul class="set-menu">
		                            <li><a class="set" data-addtab="mail" url="<%=path%>/xl/user!userSet.do" type="button" href="#">设置</a></li>
		                            <li><a class="exit" href="<%=path%>/lg/login!logout.do?cmd=5">退出</a></li>
	                   			</ul>
	                       </div>
	                   </div>
                </li>
            </ul>
        </div>
    </div>
<!--banner end-->
<!--main start-->
<div class="main">
    <div class="topbar admin-header topbar-list">
        <div class="topbar-collapse">
            <!--Button group-->
            <ul class="btn-group" role="group" aria-label="">
              
            <!-- user menu data init start -->
	            <s:iterator value="#request.asoList" id="asoList" status="st"> 
				    <s:if test="#asoList.parentId==0">
				    	<li><a href="#" class="<s:property value="#asoList.showClass"/>"><s:property value="#asoList.mtitle"/><span class="arrow"></span></a>
					 	<ul class="second-level">
					 	
						 	<s:iterator value="#request.asoList" id="asoList2"> 
						 		<s:if test="#asoList2.parentId==#asoList.id">
									<li class="<s:property value="#asoList2.showClass"/>">
									
										<s:if test="#asoList2.mdesc=='1'.toString()">
											<a href="#" type="button">
											<span class="grey-square"></span>
											<s:property value="#asoList2.mtitle"/>
											<!-- 3级菜单特效样式 -->
											<span class="blue-arrow"></span>
										</s:if>
										<s:else>
											<a href="#" type="button" data-addtab="mail<s:property value="#asoList2.id"/>" url="<s:property value="#asoList2.murl"/>">
											<span class="grey-square"></span>
											<s:property value="#asoList2.mtitle"/>
										</s:else>
											</a>
										<ul class="third-level">
											<s:iterator value="#request.asmList" id="asmList"> 
							 				<s:if test="#asmList.treeId==#asoList2.id">
													<li class="<s:property value="#asmList.showClass"/>"><a href="#" type="button" data-addtab="mail<s:property value="#asmList.id"/>" url="<s:property value="#asmList.murl"/>"><s:property value="#asmList.mname"/></a></li>
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
             <!-- user menu data init end -->   
                    
                    
             
            </ul>
            </div>
        </div>
            <div class="content-box">
                
                 <div id="marquee2" class="notice">
                	<ul>
                        <li>最新通知:易嘉财税系统上线了,快来围观</li>
                        <li>1dddddddddddddddddddddddddddddd</li>
                        <li>2ddddddddddddddddddddddddd</li>
                        <li>3ddddddddddddddddddddd</li>
                        <li>45555555555555</li>
                        <li>555555555555555555555</li>
                        <li>65555555555555555555555555555</li>
                        <li>75555555555555555555555555</li>
                        <li>8555555555555555555</li>
                        <li>955555555</li>
                    </ul>
                </div>
                
                <div class="tab-box">
                    <div id="tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active first-tab"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">我的桌面</a></li>                    
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="home">
                                <!--<button type="button" class="btn btn-default" addtabs="save" id="save" url="/admin/save">
                                    <i class="glyphicon glyphicon-floppy-disk"></i>
                                    SAVE                            
                                </button>-->
                                <iframe class="iframeClass" id="docDetail"   onload="JavaScript:ResizeFrame();" style="height:1000px;"  name="box" src="../lg/login!content.do" scrolling="no" frameborder="0" border="0">
                                </iframe>
                            </div>                    
                        </div>
        
                    </div>
                </div>
            </div>
    </div>
<!--main end-->
</body>

</html>

