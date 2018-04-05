<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
<title>会议主持导航</title>
<link rel="stylesheet" href="css/experts/experts.css" />
<script type="text/javascript">
$(function() {
	/* 修改系统登录密码*/
	$(".updateLoginPass").click(function() {
		var oldLoginPass = $("#oldLoginPass").val();
		var newLoginPass = $("#newLoginPass").val();
		var reNewLoginPass = $("#reNewLoginPass").val();
		
		if(oldLoginPass=="" || newLoginPass=="" || reNewLoginPass=="") {
			$("#reNewLoginPassTip").text("密码不能为空!");
			return false;
		}
		
		var params = {
			"hostId"  : $("#hostId").val(),
			"oldLoginPass" : $("#oldLoginPass").val(),
			"newLoginPass" : $("#newLoginPass").val()
		};
		
		$.ajax({
			url: "updateHostLoginPassAction.action",
			type: "post",
			data: params,
			dataType: "json",
			success: function(result) {
				if(result.update) {
					console.log("Updating login password is ok!");
					alert("密码修改成功!");
					$(".cacelUpdateLoginPass").trigger("click");
					$("input[type='password']").val("");
				} else {
					alert("旧密码错误,修改失败!");
				}
			},
			error: function() {
				console.log("Updating login password is error!");
				alert("密码修改失败!");
			}
		});
	});	
	/*修改系统登录密码时的监听事件（保证新密码和重复密码输入值一致）*/
	$("#reNewLoginPass").bind("input propertychange", function() {
		var newLoginPass = $("#newLoginPass").val();
		var reNewLoginPass = $(this).val();
		if(reNewLoginPass != newLoginPass) {
			$("#reNewLoginPassTip").text("与新密码不一致!");
		} else {
			$("#reNewLoginPassTip").text("");
		}
	});
	
	$("#newLoginPass").bind("input propertychange", function() {
		var newLoginPass = $(this).val();
		var reNewLoginPass = $("#reNewLoginPass").val();
		if(reNewLoginPass!="" && reNewLoginPass != newLoginPass) {
			$("#reNewLoginPassTip").text("与新密码不一致!");
		} else {
			$("#reNewLoginPassTip").text("");
		}
	});	
});
</script>
</head>
<body>
	<header>
		<div class="header_pic"></div>
		<div class="header_user">
			<div class="container">
				<div class="header_left">
					<ul class="">
						<li role="presentation" class="active"><a href="admin/host/host_meeting.jsp"><i class="glyphicon glyphicon-home "></i>首页</a></li>
						<li><a href="admin/host/hostedMeeting.jsp"><i class="glyphicon glyphicon-cog "></i>主持会议</a></li>
						<li><a href="admin/host/pastMeeting.jsp"><i class="glyphicon glyphicon-folder-open "></i> 已主持会议</a></li>
					</ul>
				</div>
				<div class="header_right"  >
					<%
						Map<String, Object> sessionMap = ActionContext.getContext().getSession();
						String userId = (String)sessionMap.get("userId");
						String userName = (String) sessionMap.get("userName");
					%>
					<input type="hidden" name="hostId" id="hostId" value="${userId}"/>
					<label>欢迎:</label>
					<span><i class="glyphicon glyphicon-user "></i>会议主持人-${userName}</span>
					<a href="javascript:void(0);" data-toggle="modal" data-target="#fix_login_password_modal">修改密码&nbsp;<i class="glyphicon glyphicon-pencil
						"></i></a>&nbsp;&nbsp;
					<a href="logout.action" target="_top">退出系统&nbsp;<i class="glyphicon glyphicon-off
						"></i></a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</header>
	<!--修改密码-->
	<div class="modal fade" id="fix_login_password_modal" aria-hidden="true" data-backdrop="static">
	  	<div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-header word_center my_modal_title ">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">修改系统登录密码</h4>
		      	</div>
		      	
		      	<div class="modal-body">
		        	<div class="box_margin">
						<div class="box_margin_left">
							<em class="em">*</em>
							<label>原密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="oldLoginPass" name="oldLoginPass" value="" />
						</div>
						<div class="clear"></div>
					</div>
					<div class="box_margin">
						<div class="box_margin_left">	
							<em class="em">*</em>						
							<label>新密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="newLoginPass" name="newLoginPass" value="" />
						</div>
						<div class="clear"></div>
					</div>
					<div class="box_margin">
						<div class="box_margin_left">
							<em class="em">*</em>
							<label>确认新密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="reNewLoginPass" name="reNewLoginPass" value="" />
							<em id="reNewLoginPassTip" style="color:red"></em>
						</div>
						<div class="clear"></div>
					</div>
		      	</div>
		      	<div class="modal-footer">				        
			        <button type="button" class="btn btn-primary modal_btn updateLoginPass" id="save_login_password">保存</button>
			        <button type="button" class="btn btn-default modal_btn cacelUpdateLoginPass" data-dismiss="modal">取消</button>
		      	</div>
		    </div><!-- /.modal-content -->
	  	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->		
</body>
</html>
