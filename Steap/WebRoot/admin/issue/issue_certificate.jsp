<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>证书发放</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<script type="text/javascript" src="js/public/dictionary.js"></script>
<script type="text/javascript" src="js/issue/issue_certificate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
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
			<div>
				<ol class="breadcrumb">
				  	<li class="active">验收后管理</li>	
				  	<li class="active">证书发放</li>
				</ol>				
			</div>
			<div class="search_bar">
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">项目名称</span>
				  	<input type="text" class="form-control" id="projectName">
				</div>
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">申请单位</span>
				  	<input type="text" class="form-control" aria-describedby id="applicant">
				</div>
				<div class="floatL search_bar_select">
				  	<select class="form-control " id="domain">
				  		<option>-领域-</option>
				  	</select>					  	
				</div>
				<div class="floatL search_bar_select">
				  	<select class="form-control " id="projectStandard">
				  		<option value="0">-项目经费（全部）-</option>
				  		<option value="1">大于50万（包括50万）</option>
				  		<option value="2">小于50万</option>
				  	</select>					  	
				</div>
				<div class="btn-group search_bar_button floatR">
					<button class="btn btn-default  " id="clearButton">
						清空<span class=" glyphicon glyphicon-repeat span_icon"></span>
					</button>
					<button class="btn btn-primary  " id="searchButton">
						查询<span class=" glyphicon glyphicon-search span_icon"></span>
					</button>
				</div>
				
				<div class="clear"></div>
			</div>
			<div class="hr"></div>
			<div class="outside_box table_box">
				<div class="box_title word_center"><h3>证书发放信息</h3></div>
				<div class="hr" style=""></div>
				<div class="btn_box">			
					<div>
						<button class="btn btn-primary floatL" id="export">导出 <span class=" glyphicon glyphicon-print "></span></button>							
						
						<a href="javascript:void(0)" data_title="admin/issue/issue_main.jsp" class="btn btn-primary floatR " id="issueCertificate" style="width: 150px">发放证书</a>	
					</div>
					<div class="clear"></div>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th>项目名称</th>
							<th>项目编号</th>
							<th>申请验收单位</th>
							<th>所属领域</th>
							<th>登记日期</th>
							<th>验收日期</th>
							<th>会议主持人</th>
							<th>证书是否发放</th>
							<th>项目状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="t_project"></tbody>
				</table>
			</div>
			
			<nav>
				<div id="paging"></div>
				<div style="display:none">
					<input type="text" id="currentPage" class="page_info" value=""/>
					<input type="text" id="pageCount" class="page_info" value=""/>
					<input type="text" id="pageSize" value="8"/>
				</div>
			</nav>
		</div>

		<div class="clear"></div>
	</div>
	
	
	<jsp:include page="/admin/home/footer.jsp" />
</body>
</html>
