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
<title>待主持会议</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/public/jquery.form.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/wait_review_project.css" />
<script type="text/javascript" src="js/host_meeting/host_meeting.js" ></script>
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />
<script type="text/javascript" src="js/public/dictionary.js"></script>
<script type="text/javascript" src="js/host_meeting/hostedMeeting.js"></script>

<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
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
	<!--start  -->
	<div class="main_body">
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/host/host_meeting.jsp">首页</a></li>
			  	<li><a href="admin/host/conveneMeeting.jsp">召开会议</a></li>
			  	<li class="active">待主持会议</li>
			</ol>
		</div>
	</div>
	
	<div class="wait_review">
		<div class="meeting_info">
				<div><label class="strong">会议信息</label></div>					
				<div class="meeting_information">		
					<input type="hidden" id="meetingId" value=""/>
					<div>
						<label class="experts_label_left label_left none_border_radius">会议名称</label>
						<label class="experts_label_right label_right none_border_radius" id="meetingName"></label>
						<div class="clear"></div>
					</div>							
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
				<button class="btn btn-default sign_btn" id="finishMeeting" title="结束当前已经完成全部项目评审的会议">结束会议</button>
				<button class="btn btn-default sign_btn" id="printSignInfo">打印签到表</button>
				<button class="btn btn-default sign_btn" id="set_headman" data-toggle="modal" data-target="#set_specialist_leader">设置组长</button>
				<button class="btn btn-default sign_btn" style="width:140px;" id="export_specialist_account">导出专家账户信息</button>
				<!-- <button class="btn btn-default sign_btn" id="generatePass" title="为企业推荐专家设定登录密码" data-toggle="modal" data-target="#rs_generate_pass">生成密码</button> -->
			</div>
			<div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th>序号</th>
							<th>姓名</th>
							<th>单位</th>
							<th>专业</th>
							<th>职称</th>
							<th>签到时间</th>
							<th>专家组职务</th>
						</tr>
					</thead>
					<tbody id="t_specialist"></tbody>
				</table>
			</div>
			<div>
				
			</div>
		</div>
		<div class="waiting_review_porject">
			<div>
				<label class="strong">待评审项目</label>
				<a href="javascript:void(0)" data_title="admin/host/evaluation_review.jsp" id="viewOpinion"><button class="btn btn-default sign_btn viewOpinionInfo" >查看专家意见</button></a>
				<a href="javascript:void(0)" data_title="admin/host/host_main.jsp" id="entryResult"><button class="btn btn-default sign_btn entryResultInfo">查看评审结果</button></a>
			</div>
			<div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th></th>
							<th>序号</th>
							<th>项目名称</th>
							<th>申请验收单位</th>
							<th>项目负责人</th>
							<th>所属领域</th>
							<th>经费（万元）</th>
							<th>项目状态</th>
						</tr>
					</thead>
					<tbody id="t_project"></tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	<div class="clear"></div>
	
	</div>
	<!-- end -->
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<%-- <div class="modal fade" id="rs_generate_pass">
		 <div class="modal-dialog">
			   <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title">企业推荐专家登录密码</h4>
			      	</div>
		      		<div class="modal-body" >
			        	<div class="generatePass_modal_body">
			        		<table class="table table-bordered table-hover">
								<thead>
				        			<tr>
				        				<th>专家姓名</th>
				        				<th>手机号</th>
				        				<th>密码</th>
				        			</tr>								
								</thead>
								<tbody id="t_spec"></tbody>
			        		</table>
		     	 		</div>
			      	 	<div class="modal-footer">
			        		<button type="button" class="btn btn-default modal_btn" data-dismiss="modal">关闭</button>		        
			      	 	</div>
		     	 	</div>
	   	  	   </div>/.modal-content
	   	  </div>/.modal-dialog
	</div>/.modal --%>
	<div class="modal fade" id="set_specialist_leader">
		 <div class="modal-dialog">
			   <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title">设置专家组长</h4>
			      	</div>
					<form id="s_leader_form" action="setLeaderAction.action" method="post">
			      		<div class="modal-body" >
				        	<div class="sleader_modal_body">
					      		<div class="input_info_group">
					      			<div class="group_left" style="margin-left:80px;">组长职务</div>
					      			<div class="group_right" style="margin-left:90px; paddding-right: 30px">
					      				<input type="radio" name="specialistLeader.leader" class="s_leader" checked="checked" value="组长"/>
					      				<label class="leader_label">组长</label>
					      				<input type="radio" name="specialistLeader.leader" class="s_leader" value="副组长"/>
					      				<label class="leader_label">副组长</label>
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group" style="display:none">
					      			<div class="group_left" style="margin-left:80px;"></div>
					      			<div class="group_right" style="margin-left:90px; paddding-right: 30px">
					      				<input type="text" value="" class="s_meetingId" name="meetingId"/>
					      				<input type="text" value="" class="s_newSpecialistId" name="specialistLeader.newSpecialistId"/>
					      				<input type="text" value="" class="s_oldSpecialistId" name="specialistLeader.oldSpecialistId"/>
					      			</div>
					      			<div class="clear"></div>
					      		</div>					      		
			     	 		</div>
				      	 	<div class="modal-footer">
				      	 		<button type="button" class="btn btn-default modal_btn set_meeting_leader">保存</button>
				        		<button type="button" class="btn btn-default modal_btn set_leader_close" data-dismiss="modal">关闭</button>		        
				      	 	</div>
			     	 	</div>					
					</form>
	   	  	   </div><!-- /.modal-content -->
	   	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->			
</body>
</html>
