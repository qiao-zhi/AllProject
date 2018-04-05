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
<title>专家评审主界面</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<script type="text/javascript" src="js/public/main.js" ></script>
<link rel="stylesheet" href="css/iframe/index.css" />
<script type="text/javascript" src="js/experts/specialist_evaluation.js"></script>
</head>
<body style="background-color: #C6EDE8;">
	<jsp:include page="evaluation_nav.jsp" />
	
	<div class="back_pic">
		<div class="main_operation">
			<div class="personal_info_keep">
				<div class="big_icon">
					<a href="admin/evaluation/specialistInfo.jsp"><img src="img/load/u21.png" class=""/></a>
				</div>
				<div class="icon_describe word_center">
					<label>个人信息维护</label><br />
					<label>对个人的签名，联系方式等进行修改</label>
				</div>
				<div class="icon_btn">
					<a href="admin/evaluation/specialistInfo.jsp">修改
						<span class="line line-top"></span>
						<span class="line line-right"></span>
						<span class="line line-bottom"></span>
						<span class="line line-left"></span>
					</a>
					
				</div>
			</div>
			<div class="personal_info_keep">
				<div class="big_icon">
					<a href="admin/evaluation/evaluatedProject.jsp"><img src="img/load/u23.png" /></a>
				</div>
				<div class="icon_describe word_center">
					<label>待评审项目</label><a href="#"><span class="badge" style="color:red;background-color: white;font-weight: 900"></span></a><br />
					<label>还未提交评审意见的项目</label>
					
				</div>
				<div class="icon_btn">
					<a href="admin/evaluation/evaluatedProject.jsp">评审
						<span class="line line-top"></span>
						<span class="line line-right"></span>
						<span class="line line-bottom"></span>
						<span class="line line-left"></span>
					</a>
					
				</div>
			</div>
<!-- 			<div class="personal_info_keep">
				<div class="big_icon">
					<a href="admin/evaluation/pastProject.jsp"><img src="img/load/u29.png" /></a>
				</div>
				<div class="icon_describe word_center">
					<label>已评审项目</label><br />
					<label>以前所评审过的项目</label>
				</div>
				<div class="icon_btn">
					<a class="" href="admin/evaluation/pastProject.jsp">查看
						<span class="line line-top"></span>
						<span class="line line-right"></span>
						<span class="line line-bottom"></span>
						<span class="line line-left"></span>
					</a>
				</div>
			</div>
			<div class="clear"></div> -->
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
