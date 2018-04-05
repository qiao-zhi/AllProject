<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC >
<html>
<head>
<base href="<%=basePath%>">

<title>登记验收资料</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/public/dictionary.js"></script>
<script type="text/javascript"
	src="js/receiveMaterial/registerConfirm.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>

<style>
.jedateym .prev, .jedateym .next{
	padding-top:12px;
}
</style>
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
				<li class="active">接收验收资料</li>
				<li class="active">登记验收资料</li>
			</ol>
		</div>
		<div class="search_bar">

			<!------------------------条件查询----------------------------->
			<!-- <form action="searchProjectF.action" method="post"> -->
				<div class="input-group search_bar_input floatL">
					<span class="input-group-addon">项目名称</span> <input type="text"
						class="form-control" placeholder="" id="projectNameSearch"
						name="condition.projectName">
				</div>
				<div class="input-group search_bar_input floatL">
					<span class="input-group-addon">申请单位</span> <input type="text"
						class="form-control" placeholder="" name="condition.applicant"
						id="applicantSearch" aria-describedby>
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
				<input type="hidden" id="currentPages" name="currentPages" value="${currentPages }">
				<input type="hidden" id="totalPage" value="${totalPage}">
			<!-- </form> -->
			<!------------------------条件查询----------------------------->

			<div class="clear"></div>
		</div>

		<div class="table_box outside_box">

			<div class="box_title word_center">
				<h3>项目验收资料登记</h3>
			</div>
			<div class="hr" style=""></div>
			<div class="btn_box">
				<div>
					<button class="btn btn-primary floatL" id="printOut">
						导出 <span class=" glyphicon glyphicon-print span_icon"></span>
					</button>

					<button class="btn btn-primary floatR " id="" data-toggle="modal"
						data-target="#register_modal" style="width: 150px">登记</button>
				</div>
				<a href='#destribution_modal' data-toggle='modal' class='hidden'
				 data-toggle='tooltip' data-placement='bottom' id="openConfirmM"></a>
				<div class="clear"></div>
			</div>

			<div class="">
				<table class="table table-bordered  table-hover"id="projectTable">
					<thead>
						<tr>
							<th>序号</th>
							<th>项目名称</th>
							<th>项目编号</th>
							<th>申请验收单位</th>
							<th>所属领域</th>
							<th>开始日期</th>
							<th>联系人</th>
							<th>联系电话</th>
							<th class="hidden">负责人</th>
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
							<td>张子枫</td>
							<td>137037687909</td>
							<td><a href=".bs-example-modal-lg" data-toggle="modal"
								class="operation_icon" data-toggle="tooltip"
								data-placement="bottom" title="查看"><i
									class="glyphicon glyphicon-search"></i></a> <a href="#"
								data-toggle="modal" class="operation_icon" data-toggle="tooltip"
								data-placement="bottom" title="编辑"><i
									class="glyphicon glyphicon-pencil"></i></a> <a href="###"
								class="operation_icon" data-toggle="tooltip"
								data-placement="bottom" title="删除"><i
									class="glyphicon glyphicon-remove"></i></a></td>
						</tr> -->

						<c:forEach var="project" varStatus="statu" items="${projects}">
							<tr>
								<td>${ statu.index + 1}</td>
								<td>${project.projectName }</td>
								<td>${project.projectId }</td>
								<td>${project.applicant }</td>
								<td>${project.domain }</td>
								<td>${project.applicationDate }</td>
								<td>${project.contactPerson }</td>
								<td>${project.telephone }</td>
								<td class="hidden">${project.recordPerson }</td>

								<td><c:if test="${project.status=='查看' }">
										<a href=".bs-example-modal-lg" data-toggle="modal"
											class="operation_icon" data-toggle="tooltip"
											data-placement="bottom" title="查看"><i
											class="glyphicon glyphicon-search"></i></a>
									</c:if> <c:if test="${project.status=='确定负责部门' }">
										<a href="#destribution_modal" data-toggle="modal"
											class="operation_icon" data-toggle="tooltip"
											data-placement="bottom" title="编辑"><i
											class="glyphicon glyphicon-pencil"></i></a>
									</c:if></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			<nav class="word_center">
				<%-- <ul class="pagination">
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
				</ul> --%>
				<div id="demo1">
			</nav>

		</div>
		<div class="clear"></div>

	</div>
	
	<div class="clear"></div>
	
	</div>


	<!--登记验收资料-->
	<div class="modal fade" id="register_modal" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" id="hiddenModel">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">登记验收资料</h4>
				</div>
				<div class="modal-body">
					<div class="register_modal_body">
						<!-----------------------------这是保存验收资料的 form表单-------------------------------------------------->
						<form action="saveMaterial.action" method="post" id="register_form">
							<div class="input_info_group">
								<div class="group_left">项目名称</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="project.projectName" id="projectNameF" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">项目编号</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="project.projectId" id="projectIdF" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">开始日期</div>
								<div class="group_right">
									<input class="datainp form-control" id="calendar_register2"
										type="text" name="project.applicationDate" placeholder="请选择"
										 readonly>
									<div id="dd" style="margin-left: 30px;"></div>
								</div>
								<div class="clear"></div>
							</div>
							
							<div class="input_info_group">
								<div class="group_left">结束日期</div>
								<div class="group_right">
									<input class="datainp form-control" id="calendar_register3"
										type="text" name="project.endDate" placeholder="请选择"
										 readonly>
									<div id="dd" style="margin-left: 30px;"></div>
								</div>
								<div class="clear"></div>
							</div>
							
							<div class="input_info_group">
								<div class="group_left">登记时间</div>
								<div class="group_right">
									<input class="datainp form-control" id="calendar_register"
										type="text" name="projectRecord.recordDate" placeholder="请选择"
										readonly>
									<div id="dd" style="margin-left: 30px;"></div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">申请验收单位</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="project.applicant" id="applicantF" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">经费</div>
								<div class="group_right input-group">								
									<input type="text" class="form-control"
										name="project.projectFunds" id="projectFundsF" />
									<label class="input-group-addon">万元</label>
								</div>
								
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">所属领域</div>
								<div class="group_right">
									<select class="form-control input_width" name="project.domain" id="domainF">
										<!-- <option value="信息领域">信息领域</option>
										<option value="计算机">计算机</option>
										<option value="机械">机械</option> -->
									</select>
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">联系人</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="project.contactPerson" id="contactPersonF" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">联系电话</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="project.telephone" id="telephoneF"
										onkeyup="value=value.replace(/[^\d\-\/]/ig,'')"
										onafterupdate="value=value.replace(/[^\d\-\/]/ig,'')" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">登记人</div>
								<div class="group_right">
									<!-- <input type="text" class="form-control"
										name="projectRecord.recordPerson" id="recordPersonF" /> -->
									<!-- 二级联动，查询员工 -->
									<select id="unitSele" class="level-menu">
										<option>--请选择部门--</option>
									</select >
								
									<select id="userSele" name="projectRecord.recordPerson" class="level-menu">
										<option>--请选择员工--</option>
									</select>  
									
								</div>
								<div class="clear"></div>
							</div>
							<input type="submit" class="hidden" id="submitRegist">
							<input type="reset" id="resetMe" class="hidden">
						</form>
						<!-----------------------------这是保存验收资料的 form表单-------------------------------------------------->

					</div>

				</div>
				<div class="modal-footer ">
					<button type="button" class="btn btn-primary modal_btn"
						id="saveRegist">保存</button>
					<button type="button" class="btn btn-default modal_btn"
						data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!--确定负责部门-->
	<div class="modal fade" id="destribution_modal" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog" style="width: 700px;">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" hiddenModel id="closeConfirmDepart">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">确定负责部门</h4>
				</div>
				<div class="modal-body">
					<div class="destribution_modal_body">
						<div class="show_info_group">
							<div class="group_left">项目名称</div>
							<div class="group_right" id="projectNameL"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">申请单位</div>
							<div class="group_right" id="applicantL"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">所属领域</div>
							<div class="group_right" id="domainL"></div>
							<div class="clear"></div>
						</div>
					</div>

					<form action="saveDepartment.action" method="post" id="saveDepart">
						<input type="hidden" id="getProjectId" value=""
							name="projectCharge.projectId"> <input type="hidden"
							id="getProjectUnit" value="" name="projectCharge.chargeUnit">
						<input type="hidden" id="getPerson2" value=""
							name="projectCharge.chargePerson"> <input type="submit"
							class="hidden" id="submitDepart">
					</form>

					<div class="destribution_table">
						<div class="show_info_group">
							<div class="group_left">负责部门</div>
							<div class="group_right" id="getProjectUnit2"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">负责人</div>
							<div class="group_right" id="getPerson3"></div>
							<div class="clear"></div>
						</div>
						<div class="floatL destribution_table_left">

							<!-----------------------------------这是添加ztree的div----------------------------->
							<div class="panel-group" id="accordion" role="tablist"
								aria-multiselectable="true">
								<ul id="treeDemo" class="ztree"></ul>
							</div>

						</div>
						<div class="floatR destribution_table_right">
							<table class="table table-bordered" id="departmentTable">
								<thead>
									<tr>
										<th>序号</th>
										<th>姓名</th>
										<th>职务</th>
										<th id="user_id" class="hidden">员工编号</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary modal_btn"
						id="saveDepartB">保存</button>
					<button type="button" class="btn btn-default modal_btn"
						data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--check_modal-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-hidden="true" id="">
		<div class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal" id="closeBasicModal"
						aria-label="Close">
						<span aria-hidden="true" id="closeBasicView">&times;</span>
					</button>
					<h4 class="modal-title">基本信息查看</h4>
				</div>
				<div class="modal-body">
					<div style="margin: 10px auto;">
						<div class="register_check_modal_body" style="border-radius: 4px;">
							<div class="show_info_group">
								<div class="group_left">项目名称</div>
								<div class="group_right" id="projectNameS"></div>
								<div class="clear"></div>
							</div>
							<input type="hidden" id="projectIdS">
							<div class="show_info_group">
								<div class="group_left">申请单位</div>
								<div class="group_right" id="applicantS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">所属领域</div>
								<div class="group_right" id="domainS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">登记人</div>
								<div class="group_right" id="recordPersonS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">登记时间</div>
								<div class="group_right" id="recordDateS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">联系方式</div>
								<div class="group_right" id="contactPersonS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">负责部门</div>
								<div class="group_right" id="chargeUnitS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">负责人</div>
								<div class="group_right" id="chargePersonS"></div>
								<div class="clear"></div>
							</div>
							<div class="show_info_group">
								<div class="group_left">确定负责部门时间</div>
								<div class="group_right" id="destributionDateS"></div>
								<div class="clear"></div>
							</div>
							<div >
								<button class="btn btn-default" style="margin-left: 56%;margin-top: 5px" id="modifyConfirmB">修改项目负责人</button>
							</div>
						</div>

					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<script>
		jeDate({
			dateCell : "#calendar_register",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
			isinitVal:true
		});
		jeDate({
			dateCell : "#calendar_register2",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
		});
		jeDate({
			dateCell : "#calendar_register3",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
		});
		
		
	</script>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
