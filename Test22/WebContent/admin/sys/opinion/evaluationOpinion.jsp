<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>项目评审意见管理</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<style type="text/css">
</style>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="controls/vue/vue.min.js" ></script> -->
</head>

<body>
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
	
	<div class="main_body" id="projectWrapVM">
		<div>
			<ol class="breadcrumb">
			  	<li class="active">系统管理</li>
			  	<li class="active">评审意见管理</li>		  	
			</ol>				
		</div>
		
		<!------------------------条件查询----------------------------->
		<!-- <div class="search_bar">
			<div class="input-group search_bar_input floatL">
				<span class="input-group-addon">项目名称</span> 
				<input type="text" class="form-control" placeholder="" id="projectNameSearch" name="condition.projectName">
			</div>
			<div class="input-group search_bar_input floatL">
				<span class="input-group-addon">申请单位</span> 
				<input type="text" class="form-control" placeholder="" name="condition.applicant" id="applicantSearch" aria-describedby>
			</div>
			<div class="floatL search_bar_select">
				<select class="form-control " name="condition.domain" id="DomainSearch">
					<option value="">--请选择所属领域--</option>
				</select>
			</div>
			<div class="floatL search_bar_select">
				<select class="form-control " name="condition.recordDate" id="recordDateSearch">
					<option value="">--请选择登记日期--</option>
					<option value="30">最近一个月</option>
					<option value="60">最近两个月</option>
					<option value="365">最近一年</option>
				</select>
			</div>
			<div class="btn-group search_bar_button floatL">
				<button class="btn btn-default  " id="clearButton">清空<span class=" glyphicon glyphicon-repeat span_icon"></span></button>
				<button class="btn btn-primary  " id="searchButton">查询<span class=" glyphicon glyphicon-search span_icon"></span></button>
			</div>
			<div class="clear"></div>
		</div> -->
		<!------------------------条件查询----------------------------->
			
		<div class="table_box outside_box">
			<div class="box_title word_center">
				<h3>专家评审意见管理</h3>
				<label style="display: block; float:left; color: red; font-weight: 700; margin-top: 15px;">注：仅提供查询、显示正在召开会议的项目</label>
			</div>
			<div class="clear"></div>
			<div class="hr" style="margin-top: 5px;"></div>
		
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>项目编号</th>
						<th>申请验收单位</th>
						<th>所属领域</th>
						<th>联系人</th>
						<th>项目状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="projectList"></tbody>
			</table>
		</div>
	</div>
	
	<div class="clear"></div>
	<jsp:include page="/admin/home/footer.jsp" />
	
	<div class="modal fade" id="update_opinion_state">
		 <div class="modal-dialog">
			   <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title">修改专家评审意见状态</h4>
			      	</div>
		      		<div class="modal-body" >
			        	<div class="generatePass_modal_body">
			        		<table class="table table-bordered table-hover">
								<thead>
				        			<tr>
				        				<th>专家编号</th>
				        				<th>姓名</th>
				        				<th>领域</th>
				        				<th>评审意见状态</th>
				        				<th>操作</th>
				        			</tr>								
								</thead>
								<tbody id="specialistList"></tbody>
			        		</table>
		     	 		</div>
			      	 	<div class="modal-footer">
			      	 		<div style="display:none;"><input type="text" id="update_project_id" /></div>
			        		<button type="button" class="btn btn-default modal_btn close_update_modal" data-dismiss="modal">关闭</button>		        
			      	 	</div>
		     	 	</div>
	   	  	   </div>
	   	  </div>
	</div>	
	
	<div class="modal fade" id="confirm_update">
	 	<div class="modal-dialog">
		   <div class="modal-content">
		      	<div class="modal-header word_center my_modal_title">
		        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        	<h4 class="modal-title">修改确认</h4>
		      	</div>
	      		<div class="modal-body" >
		        	<div class="generatePass_modal_body">
		        		<strong style="font-size: 16px; font-family: Arial;">专家评审意见状态一旦修改不可恢复，是否确定修改？</strong>
	     	 		</div>
		      	 	<div class="modal-footer">
		      	 		<button type="button" class="btn btn-default modal_btn confirm_update_btn" data-content="">确定</button>
		        		<button type="button" class="btn btn-default modal_btn" data-dismiss="modal">关闭</button>		        
		      	 	</div>
	     	 	</div>
   	  	   </div>
   	  	</div>
	</div>
	
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url : 'getProjectListByMStatus.action',
				type : 'post',
				dataType : 'json',
				success : function(result) { 
					console.log("Searching for project is ok!");
					var projectList = result;
					
					var t_body = $("#projectList");
					t_body.html("");
					
					$.each(projectList, function(index, project) {
						var _tr = "<tr>";
						_tr += "<td>" + (index + 1) + "</td>"
						_tr += "<td>" + project.projectName + "</td>";
						_tr += "<td>" + project.projectId + "</td>";
						_tr += "<td>" + project.applicant + "</td>";
						_tr += "<td>" + project.domain + "</td>";
						_tr += "<td>" + project.contactPerson + "</td>";
						_tr += "<td>" + project.status + "</td>";
						_tr += "<td><a  href='#update_opinion_state' onclick='show_update_modal(this)' data-content=" + project.projectId + " data-toggle='modal' data-target='#update_opinion_state' class='operation_icon' title='修改专家评审意见'><i class='glyphicon glyphicon-erase'></i></a></td>";
						_tr += "</tr>";
						
						t_body.append($(_tr));
					});
		 		},
				error : function() {
					console.log("Searching for project list is error!");
				}
			});	
		});
		
		function show_update_modal(obj) {
			console.log("obj: ", obj);
			var projectId = $(obj).attr('data-content');
			console.log("projectId: " + projectId);
			
			$.ajax({
				url : 'getSpecialistOpinionListByPId.action',
				type : 'post',
				data : {
					'projectId' : projectId
				},
				dataType : 'json',
				success : function(result) {
					console.log("Searching for opinion is ok!");
					
					var specialistList = result;
					var t_body = $("#specialistList");
					t_body.html("");
					
					$.each(specialistList, function(index, specialist) {
						var _tr = "<tr>";
						_tr += "<td>" + specialist.specialistId + "</td>";
						_tr += "<td>" + specialist.name + "</td>";
						_tr += "<td>" + specialist.domain + "</td>";
						_tr += "<td>" + specialist.remark + "</td>";
						if (specialist.remark == '已提交') {
							_tr += "<td><a data-toggle='modal' onclick='to_confirm_update(this)' data-content=" + specialist.specialistId + " data-target='#confirm_update' href='#confirm_update'>修改评审意见状态</a></td>";
						} else {
							_tr += "<td>-</td>";
						}
						_tr += "</td>";
						
						t_body.append($(_tr));
					});
					
					$("#update_project_id").val(projectId);
				},
				error : function() {
					console.log("Searching for opinion is error!");
				}
			});
		}
		
		function to_confirm_update(obj) {
			var specialistId = $(obj).attr('data-content');
			$(".confirm_update_btn").attr('data-content', specialistId);			
		}
		
		$(".confirm_update_btn").click(function() {
			var specialistId = $(this).attr('data-content');
			
			$.ajax({
				url : 'updateOpinionStatus.action',
				type : 'post',
				data : {
					'projectId' : $("#update_project_id").val(),
					'specialistId' : specialistId 
				},
				dataType : "json",
				success : function(resp) {
					console.log("Updating opinion status is ok!");
					
					if (resp.stateNo) {
						alert("专家评审意见状态已修改成功!");
					}
					$("#confirm_update").modal('hide');
					$("#update_opinion_state").modal('hide');
					$(".confirm_update_btn").attr('data-content', '');
					$("#update_project_id").val("");
					
				},
				error : function() {
					console.log('Updating opinion status is error!');	
				}
			});
		});
	</script>
</body>
</html>
