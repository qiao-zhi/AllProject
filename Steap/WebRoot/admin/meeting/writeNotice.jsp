<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
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
	<meta charset="GB2312">
	<base href="<%=basePath%>">
	<title>编写会议通知</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/commitModal.css" />
	<link rel="stylesheet" href="css/role1/modal.css" />
	
	<link rel="stylesheet" href="controls/kindeditor/themes/default/default.css" />
	<script type="text/javascript" charset="gb2312" src="controls/kindeditor/kindeditor-min.js" ></script>
	<script type="text/javascript" charset="gb2312"  src="controls/kindeditor/zh-CN.js" ></script>
	<script type="text/javascript" charset="gb2312"  src="controls/kindeditor/themes/default/default.png" ></script>
	
	<link rel="stylesheet" charset="gb2312" href="controls/kindeditor/prettify.css" />
	<script charset="gb2312" src="controls/kindeditor/prettify.js"></script>
	
	<script type="text/javascript" src="js/public/main.js"></script>
	<script>
		window.onload=function(){
			var btn=document.getElementById("select");
			btn.onclick=function(){
				window.location="admin/meeting/createTemplate.jsp";
			}
		}
	</script>
	<script type="text/javascript">
	$(document).ready(function () {
		var sel=document.getElementById("selectTemplate");
		  
		 sel.onchange=function(){
            
	         
				$.ajax({
					type : "post",
					dataType : "json",
					url : "getTemplate.action",
					data:{
						"meetingTemplate.templateId":sel.options[sel.selectedIndex].value,
					},
			    	success:function(htmlContent){
			    		
			    		   var editor;
			    	        KindEditor.ready(function(K) {
			    	          editor = K.create('textarea[name="content"]', {
			    	              allowFileManager:true,
			    	          });
			    	       //   KindEditor.instances[0].html("");
			    	       
			    	          editor.html(htmlContent);
			    	          location.reload(); 
			    	          });
			    	       
			    		 
			    	}
			   	    	
				});
				
		    	
		    }
		
		
	});
	
	</script>
	<script type="text/javascript">
      var editor;
      KindEditor.ready(function(K) {
          editor = K.create('textarea[name="content"]', {
              allowFileManager:true,
          });
         
          K('#save').click(function (e){
        	 // alert(editor.html());
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
		  <li><a href="#">验收会前准备</a></li>
		   <li><a href="#">验收会议管理</a></li>
		  <li class="active">起草会议通知</a></li>
		</ol>	
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="" >会议信息</label>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议时间</label>
				<label class="label_right none_border_radius">${meeting.meetingTime }</label>
				<div class="clear"></div>
			</div>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议地点</label>
				<label class="label_right none_border_radius">${meeting.meetingPlace }</label>
				<div class="clear"></div>
			</div>
		</div>
		<%-- <div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议备注</label>
				<label class="label_right none_border_radius">${meeting.remark}</label>
				<div class="clear"></div>
			</div>
		</div> --%>
		<div class="clear"></div>
	</div>

	<div class="table_box outside_box">
		<div class="strong">
			<label for="">创建议程模板</label>
		</div>
		<div class="control">
			<button class="btn btn-primary floatR" id="save">保存</button>
			<button class="btn btn-primary floatR" id="select">创建会议模板</button>
			
			<select class="form-control floatR" id="selectTemplate" >
			<option>选择会议模板</option>
			<c:forEach var="template" items="${templateList}">
				
				<option value="${template.templateId }">${template.templateName}</option>
				
				</c:forEach>
			</select>
			<div class="clear"></div>
		</div>
		<form>
		    <textarea name="content" style="width:100%;height:600px" visibility:hidden;"></textarea>
		</form>
	</div>
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>