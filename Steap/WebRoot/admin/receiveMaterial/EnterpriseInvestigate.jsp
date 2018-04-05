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

<title>企业考察</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/public/dictionary.js"></script>
<script type="text/javascript"
	src="js/receiveMaterial/EnterpriseInvestigate.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript"
	src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/register/register.css" />
<script type="text/javascript" src="js/public/main.js"></script>
<script type="text/javascript">
	var errorMassage = "${session.error }";
	if (errorMassage != "") {
		alert(errorMassage);
	}
</script>
</head>

<body>
	<jsp:include page="/admin/home/header.jsp" />
	<a href="javaScript:void(0)" id="sidebar_btn_show" class=""> <i
		class="glyphicon glyphicon-forward"></i>
	</a>
	<a href="javaScript:void(0)" id="sidebar_btn_hide"> <i
		class="glyphicon glyphicon-backward"></i>
	</a>
	<div class="html_middle">
		<div class="menu_modal">
			<jsp:include page="/admin/home/menu.jsp" />
		</div>

		<div class="main_body">

			<div>
				<ol class="breadcrumb">
					<li class="active">接收验收资料</li>
					<li class="active">企业现场考察</li>
				</ol>
			</div>
			<div>
				<div class="search_bar">

					<!------------------------条件查询----------------------------->
					<!-- <form action="searchProject2F.action" method="post"> -->
					<div class="input-group search_bar_input floatL">
						<span class="input-group-addon">项目名称</span> <input type="text"
							class="form-control" placeholder="" id="projectNameSearch"
							name="condition.projectName"> <input type="hidden"
							id="userId" value="${session.userId }">
					</div>
					<div class="input-group search_bar_input floatL">
						<span class="input-group-addon">申请单位</span> <input type="text"
							class="form-control" name="condition.applicant" placeholder=""
							aria-describedby id="applicantSearch">
					</div>
					<div class="floatL search_bar_select">
						<select class="form-control " name="condition.domain"
							id="DomainSearch">
							<option value="">--请选择所属领域--</option>
							<!-- <option value="">不限</option>
							<option value="计算机">计算机</option>
							<option value="信息领域">信息领域</option>
							<option value="煤矿">煤矿</option> -->
						</select>
					</div>
					<div class="floatL search_bar_select">
						<select class="form-control " name="condition.recordDate"
							id="recordDateSearch">
							<option value="">--请选择登记日期--</option>
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
					<input type="hidden" id="currentPages" name="currentPages"
						value="${currentPages }"> <input type="hidden"
						id="totalPage" value="${totalPage}"> <input
						name="currentPage" id="currentP" type="hidden"> <input
						type="submit" class="hidden" id="submitSearch">
					<!-- </form> -->
					<!------------------------条件查询----------------------------->

					<div class="clear"></div>
				</div>
			</div>
			<div class="table_box outside_box">
				<div class="box_title word_center">
					<h3>企业现场考察</h3>
				</div>
				<div class="hr"></div>
				<div class="btn_box">
					<div class="floatL">
						<button class="btn btn-primary" id="printOut" style="margin-bottom:8px">
							导出<span class=" glyphicon glyphicon-print span_icon"></span>
						</button>
					</div>
				</div>
				<div class="box_middle">
					<table class="table table-bordered  table-hover" id="projectTable">
						<thead>
							<tr>
								<th>序号</th>
								<th>项目名称</th>
								<th>项目编号</th>
								<th>申请验收单位</th>
								<th>所属领域</th>
								<th>登记日期</th>
								<th>确定负责部门时间</th>
								<th>项目状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
							<td>1</td>
							<td>煤矿灾害预警分析平台</td>
							<td>TY201501001</td>
							<td>太原理工大学</td>
							<td>煤矿安全</td>
							<td>2016-05-10</td>
							<td>2016-05-14</td>
							<td><a href="../register/inspection_input.html"
								id="check_link">录入|查看</a></td>
						</tr> -->

							<c:forEach var="resul" varStatus="statu" items="${result}">
								<tr>
									<td>${ statu.index + 1}</td>
									<td>${resul.projectName }</td>
									<td>${resul.projectId }</td>
									<td>${resul.applicant }</td>
									<td>${resul.domain }</td>
									<td>${resul.projectRecord.recordDate }</td>
									<td>${resul.projectCharge.destributionDate }</td>

									<td><c:if test="${resul.status=='查看' }">
											<a href="javaScript:void(0)" class="projectStatus" title="查看"><i
												class="glyphicon glyphicon-search"></i></a>
										</c:if> <c:if test="${resul.status=='录入企业考察信息' }">
											<a href="javaScript:void(0)" class="projectStatus"
												title="录入企业考察信息"><i class="glyphicon glyphicon-pencil"></i></a>
										</c:if>
										<c:if test="${resul.status=='继续录入企业考察信息' }">
											<a href="javaScript:void(0)" class="projectStatus"
												title="继续录入企业考察信息"><i class="glyphicon glyphicon-pencil"></i></a>
										</c:if>
										<c:if test="${resul.status=='当前不能操作' }">
											<a href="javaScript:void(0)" class="projectStatus"
												title="当前不能操作"><i class="glyphicon glyphicon-remove"></i></a>
										</c:if></td>

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



	</div>
	<div class="clear"></div>

	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
