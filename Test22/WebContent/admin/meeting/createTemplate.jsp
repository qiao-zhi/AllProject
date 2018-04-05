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
	<base href="<%=basePath%>"/>
	<title>创建会议模板</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />

	<link rel="stylesheet" href="controls/kindeditor/themes/default/default.css" />
	<script type="text/javascript" charset="utf-8" src="controls/kindeditor/kindeditor-min.js" ></script>
	<script type="text/javascript" charset="utf-8"  src="controls/kindeditor/zh-CN.js" ></script>
	<script type="text/javascript" charset="utf-8"  src="controls/kindeditor/themes/default/default.png" ></script>
	<script type="text/javascript" src="js/public/main.js"></script>
	<link rel="stylesheet" charset="utf-8" href="controls/kindeditor/prettify.css" />
	<script charset="utf-8" src="controls/kindeditor/prettify.js"></script>
	
	<script type="text/javascript">
      var editor;
      KindEditor.ready(function(K) {
          editor = K.create('textarea[name="content"]', {
              allowFileManager:true,
          });
          K('#save').click(function (e){
        	  $.ajax({

          		type : "post",
      			dataType : "json",
      			url : "saveMeetingNotice.action",
      			data:{
      				"htmlContent":editor.html(),
      			},
      			success:function(status){
      				if(status){
      					alert("保存成功");
      					location.reload(); 
      				}
      			}
        		  
        		  
        	  });
        	  //alert(editor.html());
             //document.write(editor.html());
          });
      });
  	</script>
</head>
<body >

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
		  <li><a href="#">验收会前准备</a></li>
		   <li><a href="#">验收会议管理</a></li>
		  <li class="active">会议模板管理</a></li>
		</ol>	
	</div>
	<div class="container table_box outside_box ">
	<div class="strong">
			<label for="">创建会议模板</label>
		</div>
		<div class="table_box outside_box">
			<button class="btn btn-primary" id="save" style="margin-left:1016px;">保存</button>
			<form style="margin-top: 5px;">
		    	<textarea name="content" style="width:100%;height:600px;resize: none;"></textarea>
			</form>
		</div>
	</div>
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>