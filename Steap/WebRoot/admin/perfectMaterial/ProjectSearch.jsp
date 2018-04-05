<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<base href="<%=basePath%>">

<title>完善项目验收资料</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<script type="text/javascript" src="js/perfectMaterial/projectSearch.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<script type="text/javascript" src="js/public/dictionary.js"></script>
<style type="text/css">
tr th, tr td{
	font-size: 14px;
}
</style>
<script type="text/javascript" src="js/public/main.js"></script>

</head>

<script type="text/javascript">
	$(function() {
	});
</script>

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

			<li class="active">验收项目资料完善</li>
		</ol>
	</div>
	<div class="search_bar">
		
		<!------------------------条件查询----------------------------->
				<!-- <form action="searchProject2F.action" method="post"> -->
					<div class="input-group search_bar_input floatL">
						<span class="input-group-addon">项目名称</span> <input type="text"
							class="form-control" placeholder="" id="projectNameSearch"
							name="condition.projectName">
					</div>
					<div class="input-group search_bar_input floatL">
						<span class="input-group-addon">申请单位</span> <input type="text"
							class="form-control" name="condition.applicant" placeholder=""
							aria-describedby id="applicantSearch">
							<input type="hidden" value="${session.userId }" id="userId">
					</div>
					<div class="floatL search_bar_select">
						<select class="form-control " name="condition.domain"
							id="DomainSearch">
							<option value="">--请选择所属领域--</option>
							<!-- <option value="计算机">计算机</option>
							<option value="信息领域">信息领域</option>
							<option value="煤矿">煤矿</option> -->
						</select>
					</div>
					<div class="floatL search_bar_select">
						<select class="form-control " name="condition.recordDate"
							id="recordDateSearch">
							<option value="">--请选择时间--</option>
							<option value="30">最近一个月</option>
							<option value="60">最近两个月</option>
							<option value="365">最近一年</option>
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
					<input type="hidden" id="currentPages" name="currentPages" value="${currentPages }">
					<input type="hidden" id="totalPage" value="${totalPage}">
					<input name="currentPage" id="currentP" type="hidden"> <input
						type="submit" class="hidden" id="submitSearch">
				<!-- </form> -->
				<!------------------------条件查询----------------------------->

		<div class="clear"></div>
	</div>

	<div class="outside_box table_box">
		<div class="box_title word_center">
			<h3>完善项目验收资料</h3>
		</div>
		<div class="hr" style=""></div>
		<div class="btn_box">
			<div>
				<button class="btn btn-primary floatL" id="printOut">
					导出 <span class=" glyphicon glyphicon-print "></span>
				</button>
				<a href="javaScript:void(0)" class="btn btn-primary floatR " id="perferMa"
					style="width: 150px">完善项目验收资料</a>
				<button id="exportOpinion" class="btn btn-primary floatR" style="margin-right: 10px;">导出专家意见</button>
			</div>
			<div class="clear"></div>
		</div>
		<div>
			<table class="table table-bordered" id="projectTable">
				<thead>
					<tr>
						<th></th>
						<th>项目名称</th>
						<th>项目编号</th>
						<th>申请验收单位</th>
						<th>所属领域</th>
						<th>申请日期</th>
						<th>经费(万)</th>
						<th>联系电话</th>
						<th>项目状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="project" varStatus="statu" items="${projects}">
							<tr>
								<td><input type="radio" name="project_radio_to_perfect" /></td>
								<td>${project.projectName }</td>
								<td>${project.projectId }</td>
								<td>${project.applicant }</td>
								<td>${project.domain }</td>
								<td>${project.applicationDate }</td>
								<td>${project.projectFunds }</td>
								<td>${project.telephone }</td>
								
								<td><a href="javaScript:void(0)" class="search_project"
							data-toggle="tooltip" data-placement="bottom" title="查看"><i
								class="glyphicon glyphicon-search"></i></a></td>

								<%-- <td><c:if test="${project.status=='查看' }">
										<a href=".bs-example-modal-lg" data-toggle="modal"
											class="operation_icon" data-toggle="tooltip"
											data-placement="bottom" title="查看"><i
											class="glyphicon glyphicon-search"></i></a>
									</c:if> <c:if test="${project.status=='确定负责部门' }">
										<a href="#destribution_modal" data-toggle="modal"
											class="operation_icon" data-toggle="tooltip"
											data-placement="bottom" title="编辑"><i
											class="glyphicon glyphicon-pencil"></i></a>
									</c:if></td> --%>
							</tr>
						</c:forEach>
					
				</tbody>
			</table>

			<nav class="word_center">
				<!-- <ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul> -->
				<div id="demo1">
			</nav>
		</div>
	</div>
	
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
