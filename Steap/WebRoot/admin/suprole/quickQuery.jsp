<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC >
<html>
<head>
<base href="<%=basePath%>">

<title>项目综合查询</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/public/dictionary.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript"
	src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/suprole/suprole.css" />
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="js/suprole/quickQuery.js"></script>
<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>

<style>
.jedateym .prev, .jedateym .next {
	padding-top: 12px;
}
</style>
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
					<li class="active">系统管理</li>
					<li class="active">项目综合查询</li>
				</ol>
			</div>
			<div class="search_bar">

				<!------------------------条件查询----------------------------->
				<div class="input-group search_bar_text floatL">
					<span class="input-group-addon">项目编号</span> <input type="text"
						class="form-control" placeholder="" id="projectNumberSearch" >
				</div>
				<div class="input-group search_bar_text floatL">
					<span class="input-group-addon">项目名称</span> <input type="text"
						class="form-control" placeholder="" 
						id="projectNameSearch" aria-describedby>
				</div>
				<div class="input-group search_bar_text floatL">
				<span class="input-group-addon">开始日期</span>
				 <input type="text" class="form-control" placeholder="" 
						id="startTime" aria-describedby readonly>
				</div>
				<div class="input-group search_bar_text floatL">
				<span class="input-group-addon">结束日期</span>
				 <input type="text" class="form-control" placeholder="" 
						id="endTime" aria-describedby readonly>
				</div>
				<div class="input-group search_bar_text floatL" style="width:17%">
					<span class="input-group-addon">申请验收单位</span> <input type="text"
						class="form-control" placeholder="" id="applicationSearch" >
				</div>
				
				<div class="floatL search_bar_date" style="margin-top:10px">
					<select class="form-control " id="projectStatusSearch">
						<option value="">-项目状态（不限）-</option>

					</select>
				</div>
				<div class="floatL search_bar_date" style="margin-top:10px">
					<select class="form-control " id="porjectDomainSearch">
						<option value="">-项目领域（不限）-</option>

					</select>
				</div>
				<div class="floatL search_bar_date" style="margin-top:10px">
					<select class="form-control " id="projectStandardSearch">
						<option value="0">-项目经费（全部）-</option>
						<option value="1">大于50万（包括50万）</option>
						<option value="2">小于50万</option>
					</select>
				</div>

				<div class="btn-group search_bar_buttons floatR" style="margin-top:10px">
					<button class="btn btn-default  " id="clearButton">
						清空<span class=" glyphicon glyphicon-repeat span_icon"></span>
					</button>
					<button class="btn btn-primary  " id="searchButton">
						查询<span class=" glyphicon glyphicon-search span_icon"></span>
					</button>
				</div>
				<input type="hidden" id="currentPages" name="currentPages"
					value="${currentPages }"> <input type="hidden"
					id="totalPage" value="${totalPage}">
				<!-- </form> -->
				<!------------------------条件查询----------------------------->

				<div class="clear"></div>
			</div>

			<div class="table_box outside_box">

				<div class="box_title word_center">
					<h3>项目综合查询</h3>
				</div>
				<div class="hr" style=""></div>
				<div class="btn_box">
					<div>
						<button class="btn btn-primary floatL" id="printOut">
							导出 <span class=" glyphicon glyphicon-print span_icon"></span>
						</button>

						<!-- 		<button class="btn btn-primary floatR " id="" data-toggle="modal"
						data-target="#register_modal" style="width: 150px">登记</button> -->
					</div>
					<a href='#destribution_modal' data-toggle='modal' class='hidden'
						data-toggle='tooltip' data-placement='bottom' id="openConfirmM"></a>
					<div class="clear"></div>
				</div>

				<div class="">
					<table class="table table-bordered  table-hover" id="projectTable">
						<thead>
							<tr>
								<th>序号</th>
								<th>项目名称</th>
								<th>项目编号</th>
								<th>申请验收单位</th>
								<th>所属领域</th>
								<th>项目负责人</th>
								<th>会议主持人</th>
								<th>项目费用(万元)</th>
								<th>项目状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>

				<nav class="word_center">
					
					<div id="demo1">
				</nav>

			</div>
			<div class="clear"></div>

		</div>

		<div class="clear"></div>
	</div>

		<script>
		jeDate({
			dateCell : "#startTime",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
		});	
		jeDate({
			dateCell : "#endTime",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
		});	
		var starTime = document.getElementById('startTime');
		var endTime = document.getElementById('endTime');
		//startTime.on()
	
	</script>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
