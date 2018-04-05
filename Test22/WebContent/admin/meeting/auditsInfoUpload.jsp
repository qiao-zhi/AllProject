<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>审计信息上传</title>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<script type="text/javascript" src="js/public/main.js"></script>
	<link rel="stylesheet" href="controls/upload/webuploader.css" />
	<link rel="stylesheet" href="controls/upload/style.css" />
	<link rel="stylesheet" href="css/public/lightbox.css" />
	<script type="text/javascript">
	 $(document).ready(function(){
		 
		 $("#pic2pdf").click(function(){
			
			 $.ajax({
				   type:"post",
				   url:"pictureToPdf.action",
				   dataType:"json",
				   
				   data:{"projectId":$("#projectId").val()},
				   success:function(pdfPath){
					   if(pdfPath!=null){
						 
						 
						   window.location.href="DownloadAuditReport?pdfPath= "+pdfPath;
						
					   }
					   
				   },
				   error:function(){
					   alert("出错啦");
				   }
				   
			 
		 });
		 
	 });
	 });
	
	</script>
  </head>
  
  <body>
    <input type="hidden" value="" name="pdfPath" id="pdfPath"/>
 
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
		<div class="title-info-box">
			<div class="col-md-3">
				<div class="title-box-left">
					项目名称
				</div>
				<div class="title-box-right" title="123456">
				<input type="hidden" value="<%= request.getParameter("projectId") %> " id="projectId"/>
				<%= request.getParameter("projectName") %> 
				</div>
			</div>
			<div class="col-md-3">
				<div class="title-box-left">
					申请验收单位
				</div>
				<div class="title-box-right" title="123456">
				<%= request.getParameter("applicant") %> 
				</div>
			</div>
			<div class="col-md-3">
				<div class="title-box-left">
					所属领域
				</div>
				<div class="title-box-right" title="123456">
				<%= request.getParameter("domain") %> 
				</div>
			</div>
			<div class="col-md-3">
				<div class="title-box-left">
					经费(万元)
				</div>
				<div class="title-box-right" title="123456">
				<%= request.getParameter("projectFunds") %> 
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div style="background-color:#FFFFFF;padding:20px 0;min-height:650px; ">
			<div id="uploader">
				<div class="queueList">
					<div id="dndArea" class="placeholder">
						<div id="filePicker"></div>
	
						<p style="margin-bottom: 20px;">审计照片上传</p>
					</div>
				</div>
				<div class="statusBar" style="display:none;">
					<div class="progress">
						<span class="text">0%</span> <span class="percentage"></span>
					</div>
					<div class="info"></div>
					<div class="btns">
						<div id="filePicker2"></div>
						<div class="uploadBtn">开始上传</div>
						<a id="pic2pdf" href="javaScript:void(0)" class="pic-to-pdf">图片转pdf</a>>
						<style>
							.pic-to-pdf{
								height:42px;
								margin-left:6px;
								border-radius:4px;
								border:none;
								width:85px;
								background:#00b7ee;
								color:#FFFFFF;
							}
							.pic-to-pdf:hover{
								background:#CCCCCC;
							}
						</style>
					</div>
				</div>
			</div>
			
			<div class="row pic_row">
		
				<!-- <a href="img/56cac22885f5a_1024.jpg" data-lightbox="yaowei"
						class="box_size" data-title="second pic"> <img
						src="img/56cac22885f5a_1024.jpg" /> <span class="pic_info">忘得人</span>
				</a>
				
				<a href="img/56cac22885f5a_1024.jpg" data-lightbox="yaowei"
						class="box_size" data-title="second pic"> <img
						src="img/56cac22885f5a_1024.jpg" /> <span class="pic_info">忘得人</span>
				</a> -->
				
				<c:forEach var="picture" items="${pictureList}">
					
					<a href="${picture.currentName}" data-lightbox="yaowei"
						class="box_size" data-title="second pic"> <img
						src="${picture.currentName}" /> <span class="pic_info">${picture.originalName}</span>
					</a>
					
				</c:forEach>
			
			</div>
			
		</div>
		
		</div>
		
		<div class="clear"></div>
	</div>
	
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
  	
  	<script type="text/javascript" src="js/public/lightbox.js"></script>
  	<script type="text/javascript" src="controls/upload/webuploader.js"></script>
	<script type="text/javascript" src="controls/upload/upload3.js"></script>
  </body>
  
</html>
