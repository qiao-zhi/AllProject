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
	<base href="<%=basePath%>">
	<title>召开会议</title>
 	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script type="text/javascript" src="js/public/jquery.form.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<script type="text/javascript" src="js/public/main.js"></script>

	<script type="text/javascript" src="js/public/jquery.validate.js"></script>
	<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
	
	<script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
	<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
	<link rel="stylesheet" href="controls/myPage/msgbox.css" />
	<link rel="stylesheet" href="controls/myPage/page.css" />
	<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
	<link rel="stylesheet" href="css/experts/wait_review_project.css" />
	<link rel="stylesheet" href="css/iframe/index.css" />
	<link rel="stylesheet" href="css/experts/expert_ui.css" />
	<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />

	<script type="text/javascript" src="js/host_meeting/reveneMeeting.js"></script>
	
</head>
<body style="background-color: #C6EDE8;">
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
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
				  <li><a href="admin/host/host_meeting.jsp" style="text-decoration: none;">首页</a></li>
				  <li class="active">召开会议</a></li>			
			</ol>
		</div>
	</div>	
	
	<div class="wait_review">
		<div class="outside_box table_box">
			<button  class="btn btn-default search_bar_button" id="convene_meeting" style="margin-bottom:10px;" >召开会议</button>
			<span id="tip_num" style="display:none; color:red; font-weight: bold; margin-left: 20px; font-size: 16px;">目前无待召开会议</span>
	 		<table id="commitTab" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>单选</th>
						<th>会议名称</th>
						<th>会议时间</th>
						<th>会议地点</th>
						<th>会议状态</th>
					</tr>
				</thead>
				<tbody class="word_center" id="t_meeting"></tbody>
			</table>
			
			<nav class="word_center">
				<div id="paging"></div>
				<div style="display:none">
					<input type="text" id="currentPage" class="page_info" value=""/>
					<input type="text" id="pageCount" class="page_info" value=""/>
					<input type="text" id="pageSize" value="8"/>
				</div>
			</nav>		
		</div>	
	</div>
	<div class="clear"></div>	
	</div>
	
	<div class="clear"></div>
	
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	
	<div class="modal fade" id="revene_meeting_modal">
		 <div class="modal-dialog" style="width: 900px;">
			   <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title">会议待完善内容</h4>
			      	</div>
		      		<div class="modal-body" >
			        	<div class="show_unfinished_modal_body">
			        		<table class="table table-bordered table-hover">
								<thead>
				        			<tr>
				        				<th>序号</th>
				        				<th>会议编号</th>
				        				<th>会议名称</th>
				        				<th>未完成事务</th>
				        			</tr>								
								</thead>
								<tbody id="t_meeting_unfinished"></tbody>
			        		</table>
			        		<table class="table table-bordered table-hover">
								<thead>
				        			<tr>
				        				<th>序号</th>
				        				<th>项目编号</th>
				        				<th>项目名称</th>
				        				<th>未完成事务</th>
				        			</tr>								
								</thead>
								<tbody id="t_material_unfinished"></tbody>
			        		</table>
		     	 		</div>
			      	 	<div class="modal-footer">
			        		<button type="button" class="btn btn-default modal_btn" data-dismiss="modal">关闭</button>		        
			      	 	</div>
		     	 	</div>					
	   	  	   </div><!-- /.modal-content -->
	   	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->			
</body>
</html>
