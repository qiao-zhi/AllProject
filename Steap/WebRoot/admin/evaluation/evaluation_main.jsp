<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>评估项目</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="controls/pdfobject/pdfobject.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/review_opinion.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
<script type="text/javascript" src="js/experts/evaluation_main.js"></script>
<script type="text/javascript" src="js/experts/screenfull.js"></script>
<link rel="stylesheet" href="css/experts/evaluation_main.css" />
<!-- <script type="text/javascript" src="js/public/discopy.js"></script> -->
<style type="text/css">
	.exit-full-size {
		width: 630px;
		height: 909px;
	}
	.jqte {
		margin-top: 5px;
	}
</style>
</head>
<body>
	<jsp:include page="evaluation_nav.jsp" />
	
	<div style="background-color: #F5F5F5;">
	<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/evaluation/specialist_evaluation.jsp">首页</a></li>
			  	<li><a href="admin/evaluation/evaluatedProject.jsp">待评审项目</a></li>
			  	<li class="active">评审项目</li>
			</ol>
		</div>
	</div>
				
	<div class="review_check">
		<div class="project_check">
			<div class="project_base_info">
				
				<div>
					<label style="font-size: 18px;">项目基本信息</label>
				</div>
				<div>
					<label class="left_info_label label_left none_border_radius">项目名称</label>
					<label class="right_info_label label_right none_border_radius">${project['projectName'] }</label>
					<label class="left_info_label label_left none_border_radius">项目负责人</label>
					<label class="right_info_label label_right none_border_radius">${project['name'] }</label>
					
					<div class="clear"></div>
				</div>
				<div>
					<label class="left_info_label label_left none_border_radius">承办单位</label>
					<label class="right_info_label label_right none_border_radius">${project['applicant'] }</label>
					<label class="left_info_label label_left none_border_radius">经费金额（万元）</label>
					<label class="right_info_label label_right none_border_radius">${project['projectFunds'] }</label>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<div class="file_report pdfContainer">
			<div class="choose_tree">
				<ul>
					<li class="level1">
						<a style="font-size: 20px;margin-bottom: 5px; background-color:#5CA7BA ;	color: white;">科技项目验收申请书</a>
						<ul class="level2">
							<!--字体闪烁，背景颜色深色点就好了-->
<!-- 							<li><a href="javascript:void(0)" class="level2_active">科技项目验收技术资料</a></li>							
							<li><a href="javascript:void(0)">计划任务书</a></li>
							<li><a href="javascript:void(0)">项目实施工作总结报告</a></li>
							<li><a href="javascript:void(0)">项目实施技术总结报告</a></li>
							<li><a href="javascript:void(0)">项目立项后相关证明材料</a></li>
							<li><a href="javascript:void(0)">科技项目验收财务资料</a></li>
							<li><a href="javascript:void(0)">承诺书</a></li> -->
							<c:if test="${not empty request.materialTree }">
								<c:forEach var="material" items="${request.materialTree }" varStatus="status">
									<li><a href="javascript:void(0)" class="level2_active filePath" data_title="${material['currentName'] }">${material['dictionaryOptionName'] }</a></li>							
								</c:forEach>
							</c:if>							
						</ul>
					
					</li>
				</ul>					
			</div>
			<div class="file_pic full" id="pdf">
				<div id="fullScreenContainer" style="display:none;">
					<button id="fullScreenView" class="btn btn-default btn-lg full-screen" style="float: right;">
						<i class="glyphicon glyphicon-resize-full"></i>全屏查看
					</button>
				</div>
				<div id="pdfViewer"></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="file_report">
			<form id="reviewInfo" action="entryEvaluationInfoAction.action" method="post">
				<input type="hidden" id="meetingId" class="form-control none_border_radius" name="meetingId" value="${param.meetingId }"/>
				<c:if test="${not empty request.project }">
					<input id="projectId" type="hidden" class="form-control none_border_radius" name="specialistEvaluation.projectId" value="${param.projectId }"/>
					<input id="specialistId" type="hidden" class="form-control none_border_radius" name="specialistEvaluation.specialistId" value="" >
				</c:if>
				<input type="hidden" id="reviewSuggestion" class="form-control none_border_radius" name="specialistEvaluation.reviewSuggestion" value="">
				<input type="hidden" id="opinion" class="form-control none_border_radius" name="specialistEvaluation.opinion" value="">				
				<input type="hidden" id="operationType" class="form-control none_border_radius" name="operationType" value="">
			</form>
			<div>
				<label style="font-size: 18px;">专家评审意见</label>
			</div>
			<textarea id="jqte_name" form="reviewInfo"></textarea>
			<button class="btn btn-default file_report_btn save_review">提交</button>
			<button class="btn btn-default file_report_btn only_save_review">保存</button>
			<div class="clear"></div>
		</div>
	</div>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<script>
		$('#jqte_name').jqte();
	</script>
</body>
</html>
