<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="utf-8">
<!doctype html>
<title>角色管理</title>
<link rel="stylesheet" href="<%=path%>/css/rest.css" />
<link rel="stylesheet" href="<%=path%>/css/dialog.css" />
<link rel="stylesheet" href="<%=path%>/css/easyTree.css" />
<link rel="stylesheet" href="<%=path%>/css/roleManager.css" />
<link rel="stylesheet" href="<%=path%>/css/public.css" />
</head>
<body>
	<!--total-role start-->
	<div class="total-role clearfix">
		<div class="role-definite">
			<h2 class="role-word">角色定义</h2>
			<div class="opera">
				<div class="opera-button clearfix">
					<a class="add-bg" href="#">新增</a> <a class="edit-bg" href="#">编辑</a>
					<a class="del-bg" href="#">删除</a>
				</div>

				<!--tree-modal start-->
				<div class="tree-modal">
					<div class="system-role">
						<img src="<%=path%>/images/dotted.png" alt="" /> <a href="#">系统角色</a>
					</div>
					<div class="tree-box easy-tree">
						<ul class="tree-list">
							<li>
								<ul class="sort-a">
									<s:iterator value="#request.userList" id="listGroup">
										<s:if test="#listGroup.itype==2"><li>
											<s:if test="#listGroup.id==roleId">
												<a class="se" href="role!getRole.do?roleId=<s:property value="#listGroup.id"/>"><s:property value="#listGroup.iname"/></a>
											</s:if>
											<s:else>
												<a href="role!getRole.do?roleId=<s:property value="#listGroup.id"/>"><s:property value="#listGroup.iname"/></a>
											</s:else>
											</li>
										</s:if>
									</s:iterator>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<!--tree-modal end-->

			</div>


		</div>
		
		<form id="functionForm" method="post" action="role!saveRoleStatus.do">
		<input type="hidden" name="roleId" value='<s:property value="roleId"/>' />
		<div class="role-list">
			<div class="find-opera clearfix">
				<s:if test="menuList!=null && menuList.size() > 0">
				<input id="saveRoleBtn" class="save-btn" style="background:#438ee4;color:#fff;border:1px solid #438ee4;height:25px;font-size: 12px;padding:2px 5px;margin-top:5px;margin-bottom:5px;" type="button" value="保存" />
				</s:if>
			</div>
			<table class="table-diction">   
				<tr>
					<th colspan="5">权限菜单</th>
				</tr>
				<s:iterator value="#request.menuList" id="menuList">
				<s:if test="#menuList.parentId==0">
				<tr>
					<td style="width:120px;">
						<div class="data-item">
							<div class="check-box">
							<input class="chk_1" onclick="check('level1_<s:property value="#menuList.id"/>')" type="checkbox" style="float:left" id='level1_<s:property value="#menuList.id"/>' name="funIds" value='<s:property value="#menuList.id"/>' />
							<label for='level1_<s:property value="#menuList.id"/>'></label>
							</div>
							<span	class="check-word"><s:property value="#menuList.mtitle"/></span>
						</div>
					</td> 
					<td style="padding-left:0px;">
						<table id='tb_level1_<s:property value="#menuList.id"/>' style="border-left:0px;">
						<s:iterator value="#request.menuList" id="menuList1">
						 		<s:if test="#menuList1.parentId==#menuList.id">
						 			<tr><td style="width:180px">
						 				<div class="data-item">
											<div class="check-box">
											<input class="chk_1" onclick="check('level2_<s:property value="#menuList1.id"/>')" type="checkbox" style="float:left" id='level2_<s:property value="#menuList1.id"/>' value='<s:property value="#menuList1.id"/>' />
											<label for='level2_<s:property value="#menuList1.id"/>'></label>
											</div>
											<span class="check-word"><s:property value="#menuList1.mtitle"/></span>
										</div>
						 			</td>
						 			<td style="padding-left:0px;">				 					
						 				<table id='tb_level2_<s:property value="#menuList1.id"/>'>
						 					<s:iterator value="#request.functionList" id="functionList2">
													<s:if test="#functionList2.treeId==#menuList1.id">
								 					<tr><td style="width:180px">
								 						<s:if test="#functionList2.showIndex != -1">
										 				<div class="data-item">
															<div class="check-box">
															<input class="chk_1" onclick="check1('level3_<s:property value="#functionList2.id"/>')" type="checkbox" style="float:left" id='level3_<s:property value="#functionList2.id"/>' value='<s:property value="#functionList2.id"/>' /> 
															<label for='level3_<s:property value="#functionList2.id"/>'></label>
															</div>
															<span class="check-word"><s:property value="#functionList2.mname"/></span>
														</div>
														</s:if>
										 			</td>
										 			<td style="padding-left:0px;width:180px">
										 				<table style="width:100%;" id='tb1_level3_<s:property value="#functionList2.id"/>'>
										 					<s:iterator value="#request.fieldDictList" id="fieldDictList" status='st'>
																	<s:if test="#fieldDictList.menuCode==#functionList2.menuCode">
												 					<tr><td>
														 				<div class="data-item">
														 					<div class="check-box">
																			<input class="chk_1" type="checkbox" id='field_id_<s:property value="#fieldDictList.id"/>' name="fieldIds" value='<s:property value="#fieldDictList.id"/>' />
														 					<label for='field_id_<s:property value="#fieldDictList.id"/>'></label>
																			</div>
														 					<s:iterator value="#request.fieldRelList" id="fieldRelList">
																				<s:if test="#fieldRelList.menuCode==#fieldDictList.menuCode && #fieldRelList.fid==#fieldDictList.id">
																					<script>document.getElementById('field_id_'+<s:property value="#fieldDictList.id"/>).checked=true;
																					</script>
																				</s:if>
																			</s:iterator>
																			<span class="check-word"><s:property value="#fieldDictList.ftitle"/></span>
																		</div>
														 			</td>
														 			</tr>
																	</s:if>
																	</s:iterator>
														</table>
										 			</td>
										 			<td style="padding-left:0px;">
										 				<table id='tb2_level3_<s:property value="#functionList2.id"/>' style="border-left:0px;">
										 					<s:iterator value="#request.modelFunctionList" id="modelFunctionList" status="status">
																	<s:if test="#modelFunctionList.menuCode==#functionList2.menuCode">
												 					<tr><td style="width:180px">
														 				<div class="data-item">
														 					<div class="check-box">
																			<input class="chk_1" type="checkbox" style="float:left" id='idfunction_<s:property value="#modelFunctionList.id"/>' name="funIds" value='<s:property value="#modelFunctionList.id"/>' />
														 					<label for='idfunction_<s:property value="#modelFunctionList.id"/>'></label>
																			</div>
														 					<s:iterator value="#request.holdFunctionList" id="holdFunctionList">
																				<s:if test="#holdFunctionList.menuCode==#modelFunctionList.menuCode && #holdFunctionList.funId==#modelFunctionList.id">
																					<script>document.getElementById('idfunction_'+<s:property value="#modelFunctionList.id"/>).checked=true;
																					</script>
																				</s:if>
																			</s:iterator>
																			<span class="check-word"><s:property value="#modelFunctionList.fname"/></span>
																		</div>
														 			</td>
														 			</tr>
																	</s:if>
																	</s:iterator>
														</table>
														
										 			</td>
										 			</tr>
													</s:if>
											</s:iterator>
										</table>
						 			</td>
						 			</tr>	
						 		</s:if>
						</s:iterator>
						</table>
					</td>
					<td></td>
					
				</tr>
				</s:if>
				</s:iterator>
				
				
				
				
			</table>
		</div>
	</form>
	</div>
	<!--total-role end-->
	<div class="shadow-bg"></div>
	<form id="roleAddForm" method="post">
	<input type="hidden" name="atUser.id" value='<s:property value="roleId"/>' />
	<input type="hidden" name="roleId" value='<s:property value="roleId"/>' />
	<div class="add-word add-word-role">
		<h1>
			新增角色<span class="close-button right"></span>
		</h1>
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
				<label class="lables">角色名：</label> <input type="text" id="roleName" name="atUser.iname" value='<s:property value="atUser.iname"/>' class="dz" />
			</div>
			<div class="intt indd inss">
				<label class="lables"><span>*</span>备注：</label>
				<textarea id="roleDesc" name="atUser.remark" class="textarea"><s:property value="atUser.remark"/></textarea>
				<div style="height:12px">
				<div id="addTip" class="banner">
					<img src="<%=path%>/images/pic12.png" />
					<p id="addTipText">不能为空</p>
				</div>
			</div>
			</div>
		</div>
		<input id="addRoldBtn" class="submit" type="button" value="保存" /> <input class="reset"
			type="reset" value="取消" />
	</div>
	</form>
	
	<!--删除-->
	<form id="roleDelForm" method="post" action="role!deleteRole.do">
	<input type="hidden" name="roleId" value='<s:property value="roleId"/>' />
	<div class="mainDel">
		<h1 class="mian-title">
			提示<span class="close-button right"></span>
		</h1>
		<div class="delete">
			<img src="<%=path%>/images/pic14.png" />
			<p>你确定要删除角色[<s:property value="atUser.iname"/>]吗?</p>
		</div>
		<input class="submit1" type="submit" value="确定" /> <input
			class="reset1" type="reset" value="取消" />
	</div>
	</form>
	
	<!-- 提示消息 -->
	<div class="answer">
		<ul>
			<li><img src="<%=path%>/images/pic20.png"/><span></span></li>			
		</ul>
	</div>
	<div class="fault">
		<ul>
			<li><img src="<%=path%>/images/pic21.png"/><span></span></li>
		</ul>
	</div>
</body>
<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
<script src="<%=path%>/js/dialog.js"></script>
<script src="<%=path%>/js/easyTree.js"></script>
<script src="<%=path%>/js/show.js"></script>
<script src="<%=path%>/js/roleManager.js"></script>
<s:if test="null != msg && msg.length() > 0">
<script>
show(1,'<s:property value="msg"/>');
setTimeout("codefans()",2000);//2秒
</script>
</s:if>
</html>