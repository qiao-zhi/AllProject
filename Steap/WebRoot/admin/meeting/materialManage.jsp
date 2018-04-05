<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath %>">
	<title>资料编制</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/modal.css" />
	<link rel="stylesheet" href="css/role2/ziliaobianzhi.css" />
	
	<link rel="stylesheet" href="css/public/fileinput.css" />
	<script type="text/javascript" src="js/public/fileinput.js" ></script>
	<script type="text/javascript" src="controls/fileUpload/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/meeting/materialManage.js"></script>
    <script type="text/javascript" src="js/public/main.js"></script>
	

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
	
	<div class="bread">
		<ol class="breadcrumb">
		  <li class="active">验收会前准备</li>
		  <li><a href="toMeetingManagePage2.action">验收会议管理</a></li>
		  <li class="active">资料编制</a></li>
		</ol>	
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">会议信息</label>
		</div>	       
		 <div class="hang">	       
			<div class="block">
				<label class="label_left none_border_radius">会议时间</label>
				<label class="label_right none_border_radius">${meeting.meetingTime}</label>
				<div class="clear"></div>
			</div>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议地点 </label>
				<label  class="label_right none_border_radius">${meeting.meetingPlace}</label>
				<div class="clear"></div>
			</div>
		</div> 
	</div>
	
	
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">项目信息</label>
			 
			   <%--  <select id="selectPro" name="material.projectId">
				   <c:forEach var="project" varStatus="status" items="${enterInfo}">

					<option value="${project.projectId}">${project.projectName}</option>

				</c:forEach>
			</select> --%>
			
		</div>
		<div style="margin :10px 0 10px 8%;">
			<div>
				<label style="font-size: 16px;">选择项目:</label>
			</div>
			<div style="width: 30%;margin-top: 5px;">				
				<select class="form-control" id="selectPro" name="material.projectId">
				   <c:forEach var="project" varStatus="status" items="${enterInfo}">

					<option value="${project.projectId}">${project.projectName}</option>

				</c:forEach>
			</select>
			</div>
			
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">承担企业</label>
				<label class="label_right none_border_radius" name="applicant">${enterInfo[0].applicant }</label>
				<div class="clear"></div>
			</div>
		</div>
			<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">验收项目</label>
				<label class="label_right none_border_radius pub_border_none" name="projectName">${enterInfo[0].projectName }</label>
				<div class="clear"></div>
			</div>
		</div>
			<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">项目负责人</label>
				<label class="label_right none_border_radius pub_border_none" name="chargePerson">${enterInfo[0].chargePerson }</label>
				<div class="clear"></div>
			</div>
		</div>
			<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">经费</label>
				<label class="label_right none_border_radius pub_border_none" name="projectFunds">${enterInfo[0].projectFunds }</label>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="table_box outside_box">
		<div class="strong" style="margin-bottom:20px">
			<label for="">上传项目验收资料
			</label>
		</div>
		<input type="hidden" id="fileType1" value="">
		<select  id="myfileType" class="form-control floatL selectfile">
     
			<c:forEach var="fileClass" varStatus="status" items="${fileClass}">

				<option value="${fileClass['dictionaryOptionName']}">${fileClass["dictionaryOptionName"]}</option>

			</c:forEach>

		</select>
		
	 <!--<iframe src="admin/meeting/upload.jsp" id="hiddenIframe" name="hiddenIframe"  frameborder='2'></iframe> -->
		 <!--  <div class="table_box outside_box uploader">
			<input id="input-1a"  type="file" class="file" data-show-preview="false" placeholder="系统自动将上传的Word文档转换为PDF文档"/>
		</div> -->
				<label style="color: red; font-weight: 700; float: left; margin-right: 1%; margin-left: 25.5%; margin-top: 5px;">仅支持上传PDF文件,要求文件名格式为*.pdf</label>
				<input class="" id="material" type="file" name="materialFile" accept=".pdf" style="margin-left: 0;float:left;height:36px;line-height:36px;border:1px solid #CCCCCC;"/>
		    	<input class="btn btn-primary  " id="uploadMaterial" type="button" value="上传" style="height:36px;border-radius:0" />
			    <div class="clear">
			    </div>
		<table id="fileTable" class="table table-bordered  table-hover mytable" style="margin-top:5px;">
			<thead>
				<tr>
					<th>序号</th>
					<th>类型</th>
					<th>文件名称</th>
					<th>上传日期</th>
					<th>大小</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="word_center">
				<c:forEach var="material" varStatus="status" items="${materialList}">
					<tr>
						<td><c:out value="${status.index+1}" /></td>

						<td>${material.fileType}<input name="materialId"
							type="hidden" value="${material.fileId }" /></td>
						<td>${material.originalName}</td>
						<td>${material.uploadTime}</td>
						<td>${material.fileSize}</td>

						<td><!-- <a href="">查看</a>&nbsp;&nbsp;<a href="javaScript:void(0)"
							name="delFile">删除</a> -->
							<input type="hidden" value="${material.currentName }" name="pdfPath"/>
							<a href="${material.currentName }"  target="_blank" class='operation_icon' data-toggle='tooltip' data-placement='bottom' title="查看"><i class="glyphicon glyphicon-search"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a class='delFile' href="javaScript:void(0)" class="operation_icon" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
							
							</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>	
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>