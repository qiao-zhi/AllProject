<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>已评审项目查看</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/already_review.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<script type="text/javascript" src="js/experts/pastProject.js"></script>
</head>
<body style="background-color: #EEEEEE;">

	<jsp:include page="/admin/home/header.jsp" />
	<a href="javaScript:void(0)" id="sidebar_btn_show" class=""> <i
		class="glyphicon glyphicon-forward"></i>
	</a>
	<a href="javaScript:void(0)" id="sidebar_btn_hide"> <i
		class="glyphicon glyphicon-backward"></i>
	</a>
	
	<div class="html_middle" style="margin-bottom:31.4%">

		<div class="menu_modal">
			<jsp:include page="/admin/home/menu.jsp" />
		</div>
		<div style="display:none">
			<input type="text" id="expertId" value="${param.specialistId}" />
		</div>
		<div style="background-color: #F5F5F5;">
			<div class="container">
				<ol class="breadcrumb experts_ol_left">
					<li class="active">系统管理</li>
					<li><a href="admin/specialist/specialist.jsp">专家管理</a></li>
					<li class="active">已评审项目</li>
				</ol>
			</div>
		</div>

		<div class="reviewed_search">
			<input type="text" placeholder="已评审项目查询功能正在扩充实现中..." /> <i class="glyphicon glyphicon-search"></i>
			<button>search</button>
		</div>

		<div class="reviewed_table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>申请单位</th>
						<th>所属领域</th>
						<%-- <th>意见|操作</th> --%>
					</tr>
				</thead>
				<tbody id="t_project"></tbody>
			</table>
		</div>
		<div class="clear"></div>
	</div>
	</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="/admin/home/footer.jsp" />
</body>
</html>