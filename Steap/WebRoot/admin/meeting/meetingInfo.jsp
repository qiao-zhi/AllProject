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
	<title>会议项目安排详情</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/commitItem.css" />
	<link rel="stylesheet" href="css/public/lightbox.css" />
	<script src="js/meeting/meetingInfo.js"></script>
	<script type="text/javascript" src="js/public/main.js"></script>
	<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
	<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
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
		   <li><a href="<%=request.getHeader("Referer") %>" >验收会议管理</a></li>
		  <li class="active">会议详情</a></li>
		</ol>	
	</div>
	<div class="outside_box table_box">
		<h4>会议信息</h4>
		<div class="pro">
			<span class="title pub_info_show_top_border">会议名称</span>
			<span class="content pub_info_show_top_border">${meeting.meetingName}</span>
		</div>
		<div class="pro">
			<span class="title">会议地点</span>
			<span class="content">${meeting.meetingPlace}</span>
		</div>
	</div>
	<div class="table_box outside_box">
		<h4>专家组名单</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>单位</th>
					<th>专业</th>
					<th>职务</th>
					<th>职称</th>
					<th>联系方式</th>
					<!-- <th>来源</th> -->
				</tr>
			</thead>
			<tbody class="word_center">
				<c:forEach var="specialist" varStatus="status"
					items="${listSpecialist}">
					<tr>
						<td><c:out value="${status.index+1}" /></td>						
						<td>${specialist.name}</td>
						<td>${specialist.workUnit}</td>
						<td>${specialist.engageDomain}</td>
						<td>${specialist.duty}</td>
						<td>${specialist.title}</td>
						<td>${specialist.telephone}</td>
						<%-- <td>${specialist.source}</td> --%>
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="table_box outside_box">
		<h4>项目信息</h4>
		<c:forEach var="project" varStatus="status"
					items="${listProjectMaterial}">					
					
		<button name="xiangmu" value="${project.projectId}" class="btn btn-default">项目${status.index+1}</button>					
					
		</c:forEach>
		<div class="union">
			<div id="head">	
				<h5>基本信息</h5>
				<div class="pro">
					<span class="title pub_info_show_top_border">项目名称</span>
					<span class="content pub_info_show_top_border"  name="projectName">${projectInfoOfPrepared.projectName}</span>
					<span class="title pub_info_show_top_border">申请单位</span>
					<span class="content pub_info_show_top_border"  name="applicant">${projectInfoOfPrepared.applicant}</span>
				</div>
				<div class="pro">
					<span class="title">所属领域</span>
					<span class="content" name="domain">${projectInfoOfPrepared.domain}</span>
					<span class="title">申请验收日期</span>
					<span class="content" name="applicationDate">${projectInfoOfPrepared.applicationDate }</span>
				</div>
				<div class="pro">
					<span class="title">登记人</span>
					<span class="content" name="recordPerson">${projectInfoOfPrepared.projectRecord.recordPerson }</span>
					<span class="title">登记日期</span>
					<span class="content" name="recordDate">${projectInfoOfPrepared.projectRecord.recordDate }</span>
				</div>
			</div>
			
			<div id="section">
				<h5>验收意见初稿</h5>
				<textarea id="jqte_name" placeholder="请把验收意见初稿的原件内容录入当前文本区域，并调整好格式..." style="width:96%; resize:none; margin-left:2%; outline:none; height:400px; border-radius:5px; border: 1px solid #CCC;" readonly ></textarea>
				<input type="hidden" value="${material.opinionContent}" id="opinionContent"/>
			</div>
			<!--  -->
			<script type="text/javascript">
				$("#jqte_name").jqte();
				$(".jqte_editor").attr("contenteditable", false);
				$(".jqte_toolbar").remove();
				
				$(function() {
					var opinionContent= document.getElementById("opinionContent").value;
			     	if (opinionContent != "") {
			    		$(".jqte_editor").html(opinionContent); 
			     	}
				});
			</script>
			
			<style>
			.jqte {
				width: 96%;
				margin-left: 2%;
				margin-top: 0px;
				border: 1px solid #CCC;
				-webkit-box-shadow: none;
				-moz-box-shadow: none;
				-o-box-shadow: none;
				box-shadow: none;
			}
			
			.jqte_editor {
				height: 400px;
				resize: none;
			}
			
			.head1{
				padding-bottom:10px;
				width:90%;
				margin:0 auto;
				position:relative;
				padding-top:3%;
				margin-bottom:4%;
				padding-left:2%;
				padding-right:2%;
				background:#EEEEEE;
			}
			.head1 h5{
				position:absolute;
				top:-20px;
				left:30px;
				background:#EEEEEE;
				padding:1%;
				border-radius:4px;
				color:black;
			}
			.head1 .pro{
				width:100%;
				margin:0 auto;
				text-align: center;
				margin-bottom:1px;
			}
			.head1 .pro span{
				display:inline-block;
				border-radius:2px;
				line-height:30px;
				margin-left:-3px;
			}
			.head1 .pro .title{
				width:18%;
				background:#EEEEEE;
			}
			.head1 .pro .content{
				width:32%;
				background:#FFFFFF;
			}		
			</style>
			<div class="head1">
				<h5>企业考察信息</h5>
				<div class="pro">
					<span class="title pub_info_show_top_border">考察人</span>
					<span class="content pub_info_show_top_border"  name="" id="inspectPersonS">${projectInfoOfPrepared.enterpriseInspect.inspectPerson }</span>
					<span class="title pub_info_show_top_border">考察时间</span>
					<span class="content pub_info_show_top_border"  name="" id="inspectDateS">${projectInfoOfPrepared.enterpriseInspect.inspectDate }</span>
				</div>
				 <div class="project_tab_pane_title">								
				 <span>考察结果</span>
				 <textarea readonly="readonly" class="project_base_info_textarea" style="width: 100%;height: 151px;resize: none;" id="inspectResultS">
					${projectInfoOfPrepared.enterpriseInspect.inspectResult }</textarea>
			     </div>
			     
			     <div>
					<span>企业考察照片</span>
				</div>
				<div class="row pic_row" id="">
			 		<div id="enterpriseInspectDiv" class="row auditPicture" style="margin:0 15px">
					 	<c:forEach var="picture" items="${pictureList2}"> 
					 		<a href="${picture.currentName }" data-lightbox = "yaowei" class="box_size thumbnail col-xs-6 col-md-3" data-title="second pic">
						 		<img src="${picture.currentName }" />
						 		<span class="pic_info"></span>
					 		</a>
						 </c:forEach>
    				</div>
				</div>				
			</div>
			
			<div class="head1" style="display:none" id="autitDiv">
				<h5>审计信息录入</h5>
				<div class="pro">
					<span class="title pub_info_show_top_border">审计单位</span>
					<span class="content pub_info_show_top_border"  name="" id="financeUnitS">${projectInfoOfPrepared.auditInfo.financeUnit }</span>
					<span class="title pub_info_show_top_border">审计时间</span>
					<span class="content pub_info_show_top_border"  name="" id="auditDateS">${projectInfoOfPrepared.auditInfo.auditDate }</span>
				</div>
				
				<!-- 审计 廉洁承诺书图片 -->
			 	<div class="row pic_row" id="">
			 		<div id="auditInfoDiv" class="row auditPicture" style="margin:0 15px">
					 	<c:forEach var="picture" items="${pictureList3}"> 
					 		<a href="${picture.currentName }" data-lightbox = "yaowei" class="box_size thumbnail col-xs-6 col-md-3" data-title="second pic">
						 		<img src="${picture.currentName }" />
						 		<span class="pic_info"></span>
					 		</a>
						 </c:forEach>
    				</div>
				</div>
			 	
			 	
			 		
			</div>
			
			<div id="footer">
				<h5>真实性承诺书扫描件</h5>
				<div class="row pic_row" id="">
					
			 		<div id="realPromiDiv" class="row auditPicture" style="margin:0 15px">
					 	 <c:forEach var="picture" items="${pictureList}"> 
					 		<a href="${picture.currentName }" data-lightbox = "yaowei" class="box_size thumbnail col-xs-6 col-md-3" data-title="second pic">
						 		<img src="${picture.currentName }" />
						 		<span class="pic_info"></span>
					 		</a>
						 </c:forEach>
    				</div>
				</div>
			</div>
		</div>
	</div>
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<script type="text/javascript" src="js/public/lightbox.js" ></script>
</body>
</html>