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
</head>
<body>
<!--total-role start-->
<div class="total-role">
	<div class="role-definite">
    	<h2 class="role-word">部门管理</h2>
        <div class="opera">
        	<div class="opera-button clearfix">
            	<a class="add-bg" href="#">新增</a>
                <a class="edit-bg" href="#">编辑</a>
                <a class="del-bg" href="#">删除</a>
            </div>
            
            <!--tree-modal start-->
            <div class="tree-modal">
            	<div class="system-role">
                	<img src="../images/dotted.png" alt=""/>
                    <a href="#">系统角色</a>
                </div>
                <div class="tree-box easy-tree">
                    <ul class="tree-list">
                        <!--<li><a href="#">系统角色</a></li>-->
                        <li>
                            <ul class="sort-a">
                                <li><a href="#">管理员</a>
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
                                <li><a href="#">记账员</a></li>
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
        	<input class="add-button" type="button" value="新增" />
        	<input class="del-button" type="button" value="删除" />
        	<div class="search">
        		<ul>
        			<li>姓名：</li>
        			<li><input type="text" /></li>
        			<li><input type="button"  value="查询"/></li>
        		</ul>
        	</div>
        	
        </div>
        <div style="clear:both;"></div>
        <table class="table">
        	<tr>
            	<th><input type="checkbox" /></th>
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
                    <td><input type="checkbox" checked="checked"/></td>
	                <td><s:property value="#asoList.userName"/></td>
	                <td>男</td>
	                <td><s:property value="#asoList.iname"/></td>
	                <td><s:property value="#asoList.email"/></td>
	                <td><s:property value="#asoList.telno"/></td>
	                <td>业务一部</td>
	                <td>业务员</td>
	                <td><img src="../images/pic15.png"/><img src="../images/pic16.png"/><img src="../images/pic17.png"/></td>
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
            <label class="lable class="lables"">用户组：</label>
            <select class="required">
                <option value="1">January</option>
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
                <option value="12">December </option>
            </select>
        </div>
        <div class="intt indd">
            <label class="lables"><span>*</span>部门编码：</label>
            <input type="text" class="dz" />
        </div>
        <div class="intt indd inss">
            <label class="lables"><span>*</span>部门名称：</label>
            <input type="text" class="dz" />
            <div class="banner">
                <img src="../images/pic12.png"/><p>不能为空</p>
            </div>
        </div>
    </div>
    <input class="submit"type="submit" value="保存"/>
    <input class="reset"type="reset" value="取消"/>
    </div>
<!---->
<div class="mian">
    <h1 class="mian-title">提示<span class="close-button right"></span></h1>
    <div class="delete">
        <img src="../images/pic14.png"/>
    <p>你确定要删除吗?</p>
    </div>
    <input class="submit1"type="submit" value="确定"/>
    <input class="reset1"type="reset" value="取消"/>
</div>

<div class="grxxsz">
				<h1>个人信息设置<span class="close-button right mr18"></span></h1>
				<ul>
					<li class="current">用户信息</li>
					<li>人事信息</li>
				</ul>
				<div class="con" style="display: block;">
					<form action="">
						<div class="content">
								<table class="tab" >
									<tbody>
										<tr>
											<th align="right"><span style="color:#ff0000;">*</span>姓名：</th>
											<td><input id "username" type="text" placeholder="  姚先慧" /></td>
										</tr>
										<tr >
											<th align="right">性别：</th>
											<td class="td"><input type="radio" /><span>男</span><input type="radio" checked="checked"><span>女</span></td>			
										</tr>
										<tr>
											<th align="right">E-mail：</th>
											<td><input id="email"class="email"type="text" placeholder=" xiaoli233434@hotmail.com" /></td>
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
											<td><input type="text" /></td>
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
				</div>
				<div class="con">
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
				</div>
			</div>
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/dialog.js"></script>
<script src="../js/easyTree.js"></script>
</body>
</html>

