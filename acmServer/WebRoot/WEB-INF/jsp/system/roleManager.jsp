<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="utf-8"><!doctype html>
<title>角色管理</title>
<link rel="stylesheet" href="../css/rest.css"/>
<link rel="stylesheet" href="../css/dialog.css"/>
<link rel="stylesheet" href="../css/easyTree.css"/>
<link rel="stylesheet" href="../css/roleManager.css"/>
</head>
<body>
<!--total-role start-->
<div class="total-role clearfix">
	<div class="role-definite">
    	<h2 class="role-word">角色定义</h2>
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
    <div class="role-list">
    	<div class="find-opera clearfix">
        	<a class="save-btn" href="#">保 存</a>
        </div>
        <table class="table-diction" border="1" cellspacing="0">
        	<tr>
            	<th>一级菜单</th>
                <th>二级菜单</th>
                <th>三级菜单</th>
                <th>四级菜单</th>
                <th>五级菜单</th>
            </tr>
            <tr>
            	<td rowspan="4">
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                    <div class="data-item">
                            <span class=" empty-box check-bg mr10"></span>
                            <span class="check-word">系统角色</span>
                        </div>
                </td>
                <td></td>
                <td>
                	<div class="data-item">
                    	<span class="empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td rowspan="2">
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">操作员管理</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td>
                	<div class="data-item">
                            <span class=" empty-box check-bg mr10"></span>
                            <span class="check-word">系统角色</span>
                        </div>
                </td>
                <td>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>	
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td rowspan="5">
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                    <div class="data-item">
                                <span class=" empty-box check-bg mr10"></span>
                                <span class="check-word">系统角色</span>
                            </div>
                </td>
                <td></td>
                <td>
                	<div class="data-item">
                            <span class=" empty-box check-bg mr10"></span>
                            <span class="check-word">系统角色</span>
                        </div>
                    <div class="data-item">
                            <span class=" empty-box check-bg mr10"></span>
                            <span class="check-word">系统角色</span>
                        </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td></td>
                <td>
                	<div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td></td>
                <td>
                	<div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td></td>
                <td>
                	<div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
            <tr>
            	<td>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td></td>
                <td>
                	<div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                    <div class="data-item">
                        <span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">系统角色</span>
                    </div>
                </td>
                <td>
                	<div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">新增</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">编辑</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">删除</span>
                    </div>
                    <div class="data-item">
                    	<span class=" empty-box check-bg mr10"></span>
                        <span class="check-word">查询</span>
                    </div>
                </td>
            </tr>
        </table>
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
<div class="shadow-bg"></div>
<div class="add-word add-word-role">
    <h1>新增角色<span class="close-button right"></span></h1>
    <div class="bor">
        <!--<div class="intt inf">
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
        </div>-->
        <div class="intt indd mt35">
            <label class="lables">角色名：</label>
            <input type="text" class="dz" />
        </div>
        <div class="intt indd inss">
            <label class="lables"><span>*</span>备注：</label>
            <textarea class="textarea"></textarea>
            <div class="banner">
                <img src="../images/pic12.png"/><p>不能为空</p>
            </div>
        </div>
    </div>
    <input class="submit"type="submit" value="保存"/>
    <input class="reset"type="reset" value="取消"/>
    </div>
    
    <!--删除-->
    <div class="mian">
    <h1 class="mian-title">提示<span class="close-button right"></span></h1>
    <div class="delete">
        <img src="../images/pic14.png"/>
    <p>你确定要删除吗?</p>
    </div>
    <input class="submit1"type="submit" value="确定"/>
    <input class="reset1"type="reset" value="取消"/>
</div>
    
</body>
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/dialog.js"></script>
<script src="../js/easyTree.js"></script>
</html>
