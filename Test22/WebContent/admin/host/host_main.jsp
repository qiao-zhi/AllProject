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
<title>查看最终评审结果</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
<script type="text/javascript" src="controls/print/jquery.print.js"></script>
<script type="text/javascript" src="controls/print/jquery-migrate-1.1.0.min.js"></script>
<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
<link rel="stylesheet" href="css/meeting_host/all_review_input.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />
<script type="text/javascript" src="js/host_meeting/host_main.js"></script>
</head>
<body style="background:#C6EDE8">
<%-- 	<jsp:include page="host_nav.jsp" />
 --%>	
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
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="javascript:window.history.go(-1);">首页</a></li>
			  	<li><a href="admin/host/hostedMeeting.jsp">待主持会议</a></li>
			  	<li class="active">查看最终评审结果</li>
			</ol>
		</div>
	</div>
		
	<div>
		<div class="project_information">
			<div>
				<h4>项目基本信息</h4>
			</div>
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
		<div class="idea_input">
			<div>
				<input type="hidden" id="projectId" class="form-control none_border_radius" name="evaluationResult.projectId" value="${param.projectId }"/>
				<button class="btn btn-default save_btn_width printResult">打印</button>
				<div class="clear"></div>
			</div>
			<div class="print-info">
				<h4>项目最终评审结果</h4>
			</div>			
			<textarea id="all_idea"></textarea>
		</div>
	</div>
	</div>
	<div class="clear"></div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<script>
		$("#all_idea").jqte();
		$(".jqte").css({
			"margin-top" : "15px"
		});
	</script>
</body>
</html>
