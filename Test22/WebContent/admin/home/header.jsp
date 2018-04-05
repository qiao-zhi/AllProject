<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>header</title>
	<link rel="stylesheet" href="css/home/header.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/experts/experts.css" />
	<script type="text/javascript" src="js/public/jquery.validate.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
    
  </head>
  		<script type="text/javascript">
			function showtime() {
				var today, year, month, day, hour, minute, second, weekday, strDate;
				today = new Date();
				weekday = today.getDay();
				switch (weekday) {
				case 0: {
					strDate = "星期日";
				}
					break;
				case 1: {
					strDate = "星期一";
				}
					break;
				case 2: {
					strDate = "星期二";
				}
					break;
				case 3: {
					strDate = "星期三";
				}
					break;
				case 4: {
					strDate = "星期四";
				}
					break;
				case 5: {
					strDate = "星期五";
				}
					break;
				case 6: {
					strDate = "星期六";
				}
					break;
				}
				year = today.getFullYear();
				month = today.getMonth() + 1;
				day = today.getDate();
				hour = today.getHours();
				minute = today.getMinutes();
				second = today.getSeconds();
				if (month.length < 2)
					month = "0" + month;
				if (day.length < 2)
					day = "0" + day;
				if (hour.length < 2)
					hour = "0" + hour;
				if (minute.length < 2)
					minute = "0" + minute;
				if (second.length < 2)
					second = "0" + second;
				document.getElementById('currentTime').innerHTML = year + "-" + month + "-"
						+ day + " " + strDate + " " + hour + ":" + minute + ":" + second;
		
				setTimeout("showtime()", "1000");
			}
		</script>
  
  <body  onload="showtime();">
	<header>
			<div class="header_pic">				
			</div>
			<div class="header_user">
				<div class="floatL header_user_left">
					<div id="currentTime"></div>
				</div>
				<% 
					Map sessionMap = ActionContext.getContext().getSession();
					String userId = (String) sessionMap.get("userId");
				%>
				<div class="floatR header_user_right">
					<label>欢迎:</label><i class="glyphicon glyphicon-user
					" style="margin:0 5px"></i>
					<label class="user_name">${userName }</label>
					<div style="display:none"><input type="text" id="userId" value="${userId }"/></div>
					<div class="header_alink">
						<a href="#change_password_modal" data-toggle="modal" class="sys_options">修改密码&nbsp;<i class="glyphicon glyphicon-pencil
						"></i></a>&nbsp;&nbsp;
						<a href="logout.action" target="_top"  class="sys_options">退出系统&nbsp; <i class="glyphicon glyphicon-off
						"></i></a>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
		
		<form action="modifyPassW.action" id="change_password" method="post">
		<input type="hidden" value="${userId }" name="userId">
		<!--修改密码-->
		<div class="modal fade" id="change_password_modal">
		  <div class="modal-dialog ">
		    <div class="modal-content" style="width:623px;">
		      <div class="modal-header word_center my_modal_title ">
		        <button type="button" class="close" data-dismiss="modal" id="closePassw"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title">修改密码</h4>
		      </div>
		      <div class="modal-body">
		        <div class="box_margin">
						<div class="box_margin_left">
							<em class="em">*</em>
							<label>原密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="oldLoginPass" name="oldLoginPass" value=""  />
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
							<label>确认密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="reNewLoginPass" name="reNewLoginPass" value="" />
							<em id="reNewPassTip" style="color:red"></em>
						</div>
						<div class="clear"></div>
					</div>
		      </div>
		      <div class="modal-footer">
		        <button type="submit" class="btn btn-primary">保存</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal" id="cancelPassw">取消</button>
		        <input type="reset" id="resetPassw" class="hidden">
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		</form>
		
  </body>
  
  <script>
  $(function() {
	  /* 输入验证 */
		$(function(){				
			$("#change_password").validate({
			
              rules: { 
              	'oldLoginPass':{required: true,maxlength:16,minlength:6}, //项目名称
              	'newLoginPass':{required: true,maxlength:16,minlength:6}, //项目名称
              	'reNewLoginPass':{required: true,maxlength:16,minlength:6,equalTo:"#newLoginPass"}, //项目名称
              },
              messages: {
                 'oldLoginPass':{required: '不能为空',maxlength:'最长为16位',minlength:'最短为6位'}, //项目名称
                 'newLoginPass':{required: '不能为空',maxlength:'最长为16位',minlength:'最短为6位'}, //项目名称
                 'reNewLoginPass':{required: '不能为空',maxlength:'最长为16位',minlength:'最短为6位',equalTo:'输入不一致'}, //项目名称
              },
              errorClass: "error",
              success: 'valid',
              unhighlight: function (element, errorClass, validClass) { //验证通过
                  $(element).tooltip('destroy').removeClass(errorClass);
              },
              errorPlacement: function (label, element) {	                	
                  $(element).tooltip('destroy'); /*必需*/
                  $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show'); 
                  /* $(element).addClass("validate_error"); */
              },
              submitHandler: function (form) {
                  $(form).ajaxSubmit({
						success : function(result){
							alert(result);
							$("#closePassw").trigger("click");
						}, error : function(result){
							alert("保存失败，请重新输入");
							$("#closePassw").trigger("click");
						}                    	
                  });
              }
      	});
		});
	  /* 清空输入框 */
	  $("#cancelPassw").click(function(){
		  $("#resetPassw").trigger("click");
	  });
	  $("#closePassw").click(function(){
		  $("#resetPassw").trigger("click");
	  });
	});
  </script>
</html>
