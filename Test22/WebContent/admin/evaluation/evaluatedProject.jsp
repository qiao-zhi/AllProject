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
<title>待评审项目</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/wait_review_project.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<script type="text/javascript" src="js/experts/evaluatedProject.js"></script>
</head>
<body style="background-color: #EEEEEE;">
	<jsp:include page="evaluation_nav.jsp" />
	
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/evaluation/specialist_evaluation.jsp">首页</a></li>
			  	<li class="active">待评审项目</li>
			</ol>
		</div>
	</div>
	
	<div class="wait_review">
		<div class="meeting_info">
			<div><label class="strong">会议信息</label></div>					
			<div style="display:none"><input type="text" id="meetingId" value=""/></div>
			<div class="meeting_information">				
				<div>
					<label class="experts_label_left label_left none_border_radius">会议时间</label>
					<label class="experts_label_right label_right none_border_radius" id="meetingTime"></label>
					<div class="clear"></div>
				</div>
				<div>
					<label class="experts_label_left label_left none_border_radius">会议地点</label>
					<label class="experts_label_right label_right none_border_radius" id="meetingPlace"></label>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<div class="experts_list">
			<div>
				<label class="strong">专家组名单</label>
				<button data_title="admin/evaluation/signCommitment.jsp" class="btn btn-default sign_btn" id="signCommitment">签署承若书</button>
				<button class="btn btn-default sign_btn" id="view_meeting_agenda">查看会议议程</button>
			</div>
			<div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>单位</th>
							<th>专业</th>
							<!-- <th>职务</th> -->
							<th>职称</th>
							<th>专家组职务</th>
							<!-- <th>联系方式</th> -->
						</tr>
					</thead>
					<tbody id="t_specialist"></tbody>
				</table>
			</div>
			<div></div>
		</div>
		<div class="waiting_review_porject">
			<div id="group_leader_new_element">
				<label class="strong">待评审项目</label>
				<button class="btn btn-default sign_btn floatR" style="margin-left: 10px; width: 140px;" id="specialist_opinion_review">查看专家评审意见</button>
			</div>
			<div>
				<table class="table table-bordered">
					<colgroup>
						<col/>
						<col width="6%" />
						<col align="left"/>
						<col/>
						<col width="13%"/>
						<col/>
						<col width="12%"/>
						<col width="8%" valign="bottom"/>
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>序号</th>
							<th>项目名称</th>
							<th>申请验收单位</th>
							<th>项目负责人</th>
							<th>所属领域</th>
							<th>经费（万元）</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="t_project"></tbody>
				</table>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<div style="display:none;"><button id="triggerCheck"></button></div>
	<script type="text/javascript">
	</script>
</body>
</html>
