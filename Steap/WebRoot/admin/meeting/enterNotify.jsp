<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/role1/modal.css" />
<link rel="stylesheet" href="css/role2/qiye.css" />
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>


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
	
		<div class="main_body">
	<div class="bread">
		<ol class="breadcrumb">
			<li class="active">验收会前准备</li>
			<li><a href="toMeetingManagePage2.action">验收会议管理</a></li>
			<li class="active">通知企业</a></li>
		</ol>
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">会议信息</label>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议时间</label> <label
					class="label_right none_border_radius">${meeting.meetingTime}</label>
				<div class="clear"></div>
			</div>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">会议地点</label>
				<label class="label_right none_border_radius pub_border_none">${meeting.meetingPlace}</label>
				<div class="clear"></div>
			</div>
		</div>
		<%-- <div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">会议备注</label>
				<label class="label_right none_border_radius pub_border_none">${meeting.remark}</label>
				<div class="clear"></div>
			</div>
		</div> --%>
		<div class="clear"></div>
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label>选择项目</label>
		</div>
		<table id="informTab" class="table table-bordered table-hover mytable">
			<thead>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>申请验收单位</th>
					<th>所属领域</th>
					<th>经费(万元)</th>
					<th class="hidden" id="project_th">项目编号</th>
					<th>通知日期</th>
					<th>通知方式</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="word_center">
				<c:forEach var="enterpriseNotify" varStatus="status"
					items="${enterpriseNotifyList}">
					<tr>
						<td><c:out value="${status.index+1}" /></td>
						<td>${enterpriseNotify.projectName}</td>
						<td>${enterpriseNotify.applicant}</td>
						<td>${enterpriseNotify.domain}</td>
						<td>${enterpriseNotify.projectFunds}</td>
						<td class="hidden">${enterpriseNotify.projectId }</td>
						<td>${enterpriseNotify.notifyDate}</td>
						<td>${enterpriseNotify.notifyMethod}</td>
						<!-- <td><a href="#" id="writeEnter" data-toggle="modal"></a><a
							href="#" class="operation_icon" data-toggle="modal"
							data-placement="bottom" title="查看"><i
								class="glyphicon glyphicon-search"></i></a></td> -->

						<!-------------循環判斷------------------------->
						 <td><c:if test="${enterpriseNotify.notifyMethod eq null}">
								<a href="#myModal" data-toggle="modal" class="notifyRe"><i
									class="glyphicon glyphicon-pencil"></i></a>
							</c:if> <c:if test="${enterpriseNotify.notifyMethod ne null }">
								<a title="已登记" class="notifyRe"><i class="glyphicon glyphicon-check"></i></a>
							</c:if></td>
						<!-------------循環判斷------------------------->
					</tr>
				</c:forEach>
				<!------------------------------------------>
				
			</tbody>
		</table>
	</div>
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>

	<script type="text/javascript">
	$(document).ready(function(){
		var rowNum;
		$(".notifyRe").click(function() {
			rowNum = $(this).parent().parent().prevAll().length + 1;
			$("label[name='enterName']").text($(this).parents("tr").children("td:eq(2)").text());
			$("label[name='yanshouxiangmu']").text($(this).parents("tr").children("td:eq(1)").text());
			var $project_th = $("#project_th").index();
			var project_id = $(this).parents("tr").children().eq($project_th).text();
			
			$("#projectT").val(project_id);
		});
		
		/* 保存到表格中 */
		/* $("#saveNoticeToFace").click(function(){
			$("tr:eq("+rowNum+") td:eq(6)").text($("#calendar_inform_time").val());
			$("tr:eq("+rowNum+") td:eq(7)").text($("input[name='tongxin']:checked").val());
			
			//$("#calendar_inform_time").val("");
		}); */
		 
		/* 保存通知方式 */
		$("#saveNoticeToFace").click(function(){
		
		/* 得到通知方式的多选框所有的值 */
		var content = "";
		$("input:checkbox[name='tongxin']:checked").each(function() {
			content += $(this).val() + "/";
		});
		content = content.substr(0, content.length - 1);
			
			$.ajax({
				type : "post",
				datatype : "json",
				url : "saveNotice.action",
				data : {
					meetingId : $("#meetingId").val(),
					projectId : $("#projectT").val(),
					notifyDate : $("#calendar_inform_time").val(),
					notifyMethod : content
				},success : function(saveNotice){
					alert("保存成功");
					$("#calendar_inform_time").val("");
					window.location.reload();
				}
			});
		});
	})
		</script>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">企业通知录入</h4>
				</div>
				<div class="modal-body">
					<!--  <div class="outside_box table_box">  -->
					<div class="strong">
						<label for="">会议信息</label>
					</div>
					<div class="inform_info">
						<div class="show_info_group pub_info_show_top_border">
							<label class="group_left">会议名称</label> <label class="group_right">${meeting.meetingName}</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="inform_info">
						<div class="show_info_group">
						<input type="hidden" id="meetingId" value="${meeting.meetingId}">
							<label class="group_left">会议时间</label> <label class="group_right">${meeting.meetingTime}</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="inform_info">
						<div class="show_info_group">
							<label class="group_left">会议地点</label> <label class="group_right">${meeting.meetingPlace}</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="strong" style="margin-top: 8px;">
						<label>项目信息</label>
					</div>
					<!-- </div> -->
					<div class="inform_info">
						<div class="show_info_group pub_info_show_top_border">
							<div class="group_left ">企业名称</div>
							<div class="group_right">
							<label name="enterName" class="group_right"></label>
								<!-- <input type="text" id="mingcheng" class="form-control"> -->
							</div>
							<div class="clear"></div>
						</div>
						<div class="inform_info">
							<div class="show_info_group">
								<div class="group_left ">验收项目</div>
								<div class="group_right ">
									<label name="yanshouxiangmu" class="group_right"></label>
								</div>
								<div class="clear"></div>
								<input type="hidden" id="projectT"/>
							</div>
						</div>
						<div class="inform_info" style="margin: 20px auto">
							<div class="input_info_group" style="margin-bottom: 10px;">
								<div class="group_left ">通知时间</div>
								<div class="group_right ">
									<input class="datainp form-control" id="calendar_inform_time"
										type="text" placeholder="请选择" readonly />

									<!-- <input type="text" id="time" class="form-control"> -->
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<div class="inform_info">
							<div class="input_info_group">
								<div class="group_left ">通知方式</div>
								<div class="group_right " style="color:black">
									<input class="danxuan" type="checkbox" name="tongxin" value="电话" checked><span>电话</span>
									<input class="danxuan" type="checkbox" name="tongxin" value="email"><span>email</span> 
									<input class="danxuan" type="checkbox" name="tongxin" value="qq"><span>qq</span>
									<input class="danxuan" type="checkbox" name="tongxin" value="微信"><span>微信</span>
									<input class="danxuan" type="checkbox" name="tongxin" value="短信"><span>短信</span>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary modal_btn"
						id="saveNoticeToFace" data-dismiss="modal">保存</button>
					<button type="button" class="btn btn-default modal_btn"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		jeDate({
			dateCell : "#calendar_inform_time",//isinitVal:true,
			format : "YYYY-MM-DD",
			isinitVal:true,
			isTime : false, //isClear:false,
			/* minDate : "2014-09-19 00:00:00" */
		})
	</script>

</body>
</html>