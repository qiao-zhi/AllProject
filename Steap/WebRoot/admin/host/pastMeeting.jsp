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
<title>已主持会议查看</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/already_review.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />
<script type="text/javascript" src="js/host_meeting/pastMeeting.js"></script>

<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
</head>

<body style="background-color: #C6EDE8">

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
	<!--start  -->
	<div class="main_body">
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/host/host_meeting.jsp">首页</a></li>
			  	<li class="active">已主持会议</li>
			</ol>
		</div>
	</div>

	<div class="reviewed_search">
		<input type="text" placeholder="查询功能正在扩充实现中..."/>
		<i class="glyphicon glyphicon-search"></i>
		<button>查找</button>
	</div>
	
	<div class="hosted_meeting_table">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>会议名称</th>
					<th>会议时间</th>
					<th>会议地点</th>
				</tr>	
			</thead>
			<tbody id="t_meeting"></tbody>			
		</table>
		
		<%-- <nav class="word_center">
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav> --%>
	</div>
	</div>
	
	<div class="clear"></div>
	
	</div>
	<!--end  -->
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
