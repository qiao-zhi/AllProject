<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<base href="<%=basePath%>">

<title>完善项目资料</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/public/fileinput.css" />
<script type="text/javascript" src="js/public/fileinput.js"></script>
<script type="text/javascript"
	src="controls/fileUpload/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/public/main.js"></script>
<script type="text/javascript" src="js/perfectMaterial/perfectMaterial.js"></script>

</head>

<body>
	
	<jsp:include page="/admin/home/header.jsp"/>
	<a href="javaScript:void(0)" id="sidebar_btn_show" class="">
		<i class="glyphicon glyphicon-forward"></i>
	</a>
	<a href="javaScript:void(0)" id="sidebar_btn_hide">
		<i class="glyphicon glyphicon-backward"></i>
	</a>
	
	<div class="html_middle">
		<div class="menu_modal">		
			<jsp:include page="/admin/home/menu.jsp" />
		</div>
	
		<div class="main_body">

	<div>
		<ol class="breadcrumb">
			<li class="active">验收后管理</li>
			<li><a href="admin/perfectMaterial/ProjectSearch.jsp">验收项目资料完善</a></li>
			<li class="active">完善验收项目资料</li>
		</ol>
	</div>
	
	<div class="outside_box table_box box_padding">
		<div class="header_span">
			<span>上传资料</span>
		</div>
		<div style="margin: 15px 0 10px 0;">
			<div>
				<hr>
					
					<select class="floatL" style="height:34px;line-height:34px;width:25%; border:1px solid #CCCCCC;border-radius: 4px; " id="fileType">
						<!-- <option value="">科技项目验收申请书</option>
						<option value="">承诺书</option>
						<option value="">计划任务书</option>
						<option value="">项目实施工作总结报告</option>
						<option value="">项目实施技术总结报告</option>
						<option value="">项目立项后相关证明材料</option>
						<option value="">科技项目验收财务资料一套</option> -->
						<c:forEach var="fileClass" varStatus="status" items="${fileClass}">

							<option value="${fileClass['dictionaryOptionName']}">${fileClass["dictionaryOptionName"]}</option>

						</c:forEach>
					</select>
					<!-- 这个input file 可以添加一个opacity: 0; 使得中间按钮隐藏 ，选择后提示信息得自己加 -->	
					<input id="material" type="file" name="materialFile" class="floatL btn btn-default" style="padding:2px; margin-left:5%; width:60%;border-top-right-radius:0 ;border-bottom-right-radius:0 ;"/>
			   		<input id="uploadMaterial" type="button" value="上传" class="floatL btn btn-primary" style="width:10%;border-top-left-radius:0 ;border-bottom-left-radius: 0; "/>
			   		
			   		<div class="clear"></div>
			</div>

		</div>
		<div style="min-height:350px;">
			<input type="text" value="${param.projectId}" style="display:none;" id="un_general_projectId" />
			<table class="table table-bordered" id="materialTable">
				<thead>
					<tr>
						<th>序号</th>
						<th>文件名称</th>
						<th>文件类型</th>
						<th>上传日期</th>
						<th class="hidden" id="file_th">fileId</th>
						<th>大小</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="m_tbody">
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="outside_box table_box box_padding" style="margin-bottom:10px;">
		<div class="header_span">
			<span>资料完善说明</span>
		</div>
		<div>
		<form action="savePerfectInfo.action" method="post">
			<input type="hidden" value="${projectId }" name="projectId">
			<input type="hidden" name="completeIdList" id="completeIdList">
			<textarea class="perfect_textarea" name="perfectProjectInfo">${completeDescription}</textarea>
			<button type="submit" class="btn btn-primary floatR" style="margin-top:8px;" >上传完善说明</button>
			<div class="clear"></div>
		</form>
		</div>
	</div>
	
	</div>
		<div class="clear"></div>
	</div>
	
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
