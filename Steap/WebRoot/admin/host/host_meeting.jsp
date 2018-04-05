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
<title>会议主持人主界面</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />		
<link rel="stylesheet" href="css/iframe/index.css" />

<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
</head>
<body>
	<%-- <jsp:include page="host_nav.jsp" /> --%>
	
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
	<div style="background-color: #0154A2;">
		<div class="banner_bg">
			<div class="host_box host_box_left" >
				<div class="big_icon">
					<a href="admin/host/conveneMeeting.jsp"><img src="img/load/u23.png" /></a>
				</div>
				<div class="icon_describe word_center">
					<label>召开会议</label><br />
					<label>选择要主持召开的会议</label>
					
				</div>
				<div class="icon_btn">
					<a href="admin/host/conveneMeeting.jsp">召开
						<span class="line line-top"></span>
						<span class="line line-right"></span>
						<span class="line line-bottom"></span>
						<span class="line line-left"></span>
					</a>
					
				</div>
			</div>
			<div class="host_box host_box_right" >
				<div class="big_icon">
					<a href="admin/host/pastMeeting.jsp"><img src="img/load/u29.png" /></a>
				</div>
				<div class="icon_describe word_center">
					<label>已主持会议</label><br />
					<label>已经完成项目评审的会议</label>
				</div>
				<div class="icon_btn">
					<a class="" href="admin/host/pastMeeting.jsp">查看
						<span class="line line-top"></span>
						<span class="line line-right"></span>
						<span class="line line-bottom"></span>
						<span class="line line-left"></span>
					</a>
					
				</div>
			</div>
		</div>
	</div>
	
	</div>
	<div class="clear"></div>
	
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
