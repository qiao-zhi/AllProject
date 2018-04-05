<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>查看评审意见</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/meeting_host/all_review_input.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />
<link rel="stylesheet" href="css/meeting_host/evaluation_review.css" />
<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
<script type="text/javascript" src="js/host_meeting/evaluation_review.js"></script>
</head>
<body style="background:#C6EDE8">
	<jsp:include page="evaluation_nav.jsp" />
	
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/evaluation/specialist_evaluation.jsp">首页</a></li>
			  	<li><a href="admin/evaluation/evaluatedProject.jsp">待评审项目</a></li>
			  	<li class="active">专家评审意见查看</li>
			</ol>
		</div>
	</div>
	
	<div class="project_information">
		<div><label class="header_info">项目基本信息</label></div>
		<input type="hidden" id="projectId" value="${param.projectId }"/>
		<div class="info_show">
			<label class="show_left">项目名称</label>
			<label class="show_rigth" id="projectName"></label>
			<label class="show_left">承担单位</label>
			<label class="show_rigth" id="applicant"></label>
			<div class="clear"></div>
		</div>
		<div class="info_show">
			<label class="show_left">项目负责人</label>
			<label class="show_rigth" id="name"></label>
			<label class="show_left">经费金额</label>
			<label class="show_rigth" id="projectFunds"></label>
			<div class="clear"></div>
		</div>
		<div></div>
	</div>
	<div class="personal_idea">
		<div>
			<label class="header_info">专家个人意见</label>
		</div>
		<div class="experts_personal">
			<div class="info_show">
				<label class="show_left">专家姓名</label>
				<label class="show_rigth name"></label>
				<label class="show_left">工作单位</label>
				<label class="show_rigth workUnit"></label>
				<div class="clear"></div>
				<div class="title_label" style="height:34px;line-height:34px;">
					<span >专家意见</span>
				</div>
				<textarea class="opinion_modal jqte_name evaluationInfo" readonly="readonly"></textarea>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(".jqte_name").jqte();
		$(".jqte_toolbar").css("display", "none");
		$(".jqte").css({
			"margin": "0",
			"border": "#ccc"
		});
		$(".jqte_editor").prop("contenteditable", "false");
	</script>
</body>
</html>
