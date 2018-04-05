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

<title>接收，审查验收资料</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/public/dictionary.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="js/receiveMaterial/getInvestigate.js"></script>
<script type="text/javascript" src="js/receive_report_data/logging.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
	<script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet" href="css/receive_report_data/logging_data.css" />
<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
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
				<li class="active">资料记录</li>
			</ol>
		</div>
		<div>
			<div class="search_bar">

				<!------------------------条件查询----------------------------->
				<!-- <form action="searchProject2F.action" method="post"> -->
					<div class="input-group search_bar_input floatL">
						<span class="input-group-addon">项目名称</span> <input type="text"
							class="form-control" placeholder="" id="projectNameSearch"
							name="condition.projectName">
							<input type="hidden" id="userId" value="${session.userId }">
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
					<input type="hidden" id="currentPages" name="currentPages" value="${currentPages }">
					<input type="hidden" id="totalPage" value="${totalPage}">
					<input name="currentPage" id="currentP" type="hidden"> <input
						type="submit" class="hidden" id="submitSearch">
				<!-- </form> -->
				<!------------------------条件查询----------------------------->

				<div class="clear"></div>
			</div>
		</div>
		<div class="table_box outside_box">
			<div class="box_title word_center">
				<h3>领取审查验收资料</h3>
			</div>

			<div class="hr"></div>

			<div class="btn_box">
				<div class="floatL">
					<button class="btn btn-primary" id="printOut">
						导出<span class=" glyphicon glyphicon-print span_icon"></span>
					</button>
				</div>
				<div class="floatR btn_middle">
					<button class="btn btn-primary " id="receive_btn"
						data-toggle="modal" data-target="#receive_modal" disabled="disabled">领取验收资料</button>
					<button class="btn btn-primary " id="censor_btn"
						data-toggle="modal" data-target="#censor_modal" disabled="disabled">审查验收资料</button>
				</div>

				<div class="clear"></div>
			</div>
			<div class="box_middle">
				<table border="" cellspacing="" cellpadding=""
					class="table table-bordered" id="projectTable">
					<colgroup>
						<col width="4%">
						<col width="16%">
						<col width="10%">
						<col width="10%">
						<col width="11%">
						
						<col width="10%">
						<col width="12%">
						<col width="12%">
						<col width="10%">
						<col width="4%">	
					</colgroup>
					<thead>
						<tr>
							<th>序号</th>
							<th id="project_name_th">项目名称</th>
							<th id="project_num_th">项目编号</th>
							<th id="apply_unit_th">申请验收单位</th>
							<th id="apply_data_th" class="hidden">项目经费</th>
							<th id="field_belong_th">所属领域</th>
							<th id="register_data_th">登记日期</th>
							<th id="register_man_th" class="hidden">登记人</th>
							<th id="destribution_date_th">确定负责部门时间</th>
							<th class="hidden" id="responsible_department_th">负责部门</th>
							<th class="hidden" id="responsible_man_th">负责人</th>
							<th class="hidden" id="receive_man_th">领取验收资料人</th>
							<th id="receive_date_th">领取验收资料时间</th>
							<th id="receive_result_th" class="hidden">领取资料结果</th>
							<th class="hidden" id="censor_man_th">审查人</th>
							<th id="censor_date_th">审查时间</th>
							<th class="hidden" id="censor_result_th">审查结果</th>
							<th id="project_status_th" class="hidden">项目操作</th>
							<th>项目状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<!-- <tr>
							<td>2</td>
							<td>煤矿灾害预警分析平台</td>
							<td>TY201501001</td>
							<td>太原理工大学1</td>
							<td class="hidden">2013-01-12</td>
							<td>煤矿安全</td>
							<td>2016-05-10</td>
							<td class="hidden">张志刚</td>
							<td>2016-06-10</td>
							<td class="hidden">评估部</td>
							<td class="hidden">李权良</td>
							<td class="hidden">王鹏飞</td>
							<td></td>
							<td class="hidden">李权良</td>
							<td></td>
							<td><a href="#check_modal" data-toggle="modal"
								class="operation_icon" data-toggle="tooltip"
								data-placement="bottom" title="查看"><i
									class="glyphicon glyphicon-search"></i></a> <a href="#check_modal"
								data-toggle="modal" class="operation_icon" data-toggle="tooltip"
								data-placement="bottom" title="编辑"><i
									class="glyphicon glyphicon-pencil"></i></a> <a href="###"
								class="operation_icon" data-toggle="tooltip"
								data-placement="bottom" title="删除"><i
									class="glyphicon glyphicon-remove"></i></a></td>
						</tr> -->

						<c:forEach var="resul" varStatus="statu" items="${result}">
							<tr>
								<td>${ statu.index + 1}</td>
								<td>${resul.projectName }</td>
								<td>${resul.projectId }</td>
								<td>${resul.applicant }</td>
								<td class="hidden">申请时间</td>
								<td>${resul.domain }</td>
								<td>${resul.projectRecord.recordDate }</td>
								<td class="hidden">${resul.projectRecord.recordPerson }</td>
								<td>${resul.projectCharge.destributionDate }</td>
								<td class="hidden">${resul.projectCharge.chargeUnit }</td>
								<td class="hidden">${resul.projectCharge.chargePerson }</td>
								<td class="hidden">${resul.projectReceive.receivePerson }</td>
								<td>${resul.projectReceive.receiveDate }</td>
								<td class="hidden">${resul.projectCensor.censorPerson }</td>
								<td>${resul.projectCensor.censorDate }</td>
								<td class="hidden">${resul.projectCensor.censorResult }</td>
								<td><a href="#check_modal" data-toggle="modal"
									class="operation_icon" data-toggle="tooltip"
									data-placement="bottom" title="查看"><i
										class="glyphicon glyphicon-search"></i></a></td>
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
					<li><a href="#"><span aria-hidden="true">&lt;</span></a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">...</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#"><span aria-hidden="true">&gt;</span></a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul> --%>
				<div id="demo1">
			</nav>

		</div>

	</div>
	</div>
	<div class="clear"></div>

	<!--领取验收资料-->
	<div class="modal fade" id="receive_modal" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header my_modal_title word_center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" id="hiddenModel">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title center">领取验收资料</h4>
				</div>
				<div class="modal-body">
					<div class="receive_modal_show_body">
						<div class="show_info_group"
							style="border-bottom: 1px solid #CCCCCC;">
							<div class="group_left">项目名称</div>
							<div class="group_right" id="projectNameD">456798</div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">项目编号</div>
							<div class="group_right" id="projectIdD"></div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="hr"></div>

					<!-----------------------保存领取验收资料人------------------------------>
					<form action="getMaterial.action" method="post" id="receive_form">
						<input type="text" value="" name="projectReceive.projectId"
							id="projectIdS" class="hidden">

						<div class="register_modal_body">
							<div class="input_info_group">
								<div class="group_left">领取验收资料人</div>
								<div class="group_right">
									<!-- <input type="text" name="projectReceive.receivePerson"
										class="form-control" /> -->
									<!-- 二级联动，查询员工 -->
									<select id="unitSele" class="level-menu" >
										<option value="">--请选择部门--</option>
									</select >
								
									<select id="userSele" name="projectReceive.receivePerson" class="level-menu">
										<option value="">--请选择员工--</option>
									</select>  
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">领取验收资料时间</div>
								<div class="group_right">
									<input class="datainp form-control" id="calendar_reivce"
										name="projectReceive.receiveDate" type="text"
										placeholder="请选择" readonly>
									<div id="dd" class="date_margin"></div>
								</div>
								<div class="clear"></div>
							</div>

							<div class="input_info_group censor_modal_textarea">
								<div class="group_left">资料领取情况</div>
								<div class="group_right" style="height:100px">
									<textarea class="form-control" name="projectReceive.receiveResult"></textarea>
								</div>
								<div class="clear"></div>
							</div>

							<input type="reset" id="resetMe" class="hidden">
							<input type="submit" id="submitGetMateria" class="hidden">
					</form>
					<!-----------------------保存领取验收资料人------------------------------>


				</div>
			</div>
			<div class="modal-footer ">
				<button type="button" class="btn btn-primary modal_btn" id="saveGetMaterial">保存</button>
				<button type="button" class="btn btn-default modal_btn"
					data-dismiss="modal">取消</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--审查项目验收资料-->
	<div class="modal fade" id="censor_modal" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header my_modal_title word_center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" style="color: white;" id="hiddenModel2">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title center">审查项目验收资料</h4>
				</div>
				<div class="modal-body">
					<div class="receive_modal_show_body">
						<div class="show_info_group"
							style="border-bottom: 1px solid #CCCCCC;">
							<div class="group_left">项目名称</div>
							<div class="group_right" id="projectNameLa2"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">项目编号</div>
							<div class="group_right" id="projectIdLa2"></div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="hr"></div>

					<!-------------------------保存审查信息------------------------>
					<form action="getInvestiogateM.action" method="post" id="censor_form">
						<input type="hidden" name="projectCensor.projectId"
							id="projectIdI">
						<input type="hidden" name="isUpdate" id="isUpdate">

						<div class="register_modal_body">
							<div class="input_info_group">
								<div class="group_left">审查人</div>
								<div class="group_right">
									<!-- <input type="text" class="form-control"
										name="projectCensor.censorPerson" /> -->
									<!-- 二级联动，查询员工 -->
									<select id="unitSele2" class="level-menu" >
										<option value="">--请选择部门--</option>
									</select >
								
									<select id="userSele2" name="projectCensor.censorPerson" class="level-menu" >
										<option value="">--请选择员工--</option>
									</select> 
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">审查时间</div>
								<div class="group_right">
									<input class="datainp form-control" id="calendar2" type="text"
										name="projectCensor.censorDate" placeholder="请选择" readonly>
									<div id="dd2" class="date_margin"></div>
									<!--<input type="text" id="register_time" placeholder="trigger calendar" class="form-control">
			        				<input type="text" class="form-control" placeholder="点击选择时间" id="register_time"/> 
			        				<div id="register_data_time"></div>-->
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group censor_modal_textarea">
								<div class="group_left">审查结果</div>
								<div class="group_right" style="height:100px">
									<textarea class="form-control" id="censor_result"
										name="projectCensor.censorResult"></textarea>
								</div>
								<div class="clear"></div>
							</div>

							<input type="submit" id="submitInvestigate" class="hidden">
							<input type="reset" id="resetMe2" class="hidden">
					</form>
					<!-------------------------保存审查信息------------------------>

				</div>
			</div>
			<div class="modal-footer ">
				<button type="button" class="btn btn-primary modal_btn" id="saveInvestigate">保存</button>
				<button type="button" class="btn btn-default modal_btn"
					data-dismiss="modal">取消</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--查看modal-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" id="check_modal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header  word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">项目详细信息</h4>
				</div>
				<div class="modal-body ">
					<div class="check_modal_body">
						<div class="show_info_group">
							<div class="group_left">项目名称</div>
							<div class="group_right" id="project_name"></div>
							<div class="group_left">申请单位</div>
							<div class="group_right" id="apply_unit"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">所属领域</div>
							<div class="group_right" id="field_belong"></div>
							<div class="group_left">项目经费</div>
							<div class="group_right" id="apply_data"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">登记日期</div>
							<div class="group_right" id="register_data"></div>
							<div class="group_left">登记人</div>
							<div class="group_right" id="register_man"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">负责部门</div>
							<div class="group_right" id="responsible_department"></div>
							<div class="group_left">负责人</div>
							<div class="group_right" id="responsible_man"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group">
							<div class="group_left">领取验收资料人</div>
							<div class="group_right" id="receive_man"></div>
							<div class="group_left">领取验收资料时间</div>
							<div class="group_right" id="receive_date"></div>
							<div class="clear"></div>
						</div>
						<div class="show_info_group"
							style="border-bottom: 1px solid #CCCCCC;">
							<div class="group_left">审查人</div>
							<div class="group_right" id="censor_man"></div>
							<div class="group_left">审查时间</div>
							<div class="group_right" id="censor_date"></div>
							<div class="clear"></div>
						</div>
					</div>


					<div class="">
						<div style="margin: 15px 0 0 0;">
							<label>审查结果:</label>
						</div>
						<textarea class="modal_textarea" readonly="readonly"
							id="censor_result2"></textarea>
					</div>
				</div>
				<div class="modal-footer "></div>
			</div>
		</div>
	</div>

	<script>
		jeDate({
			dateCell : "#calendar_reivce",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
			isToday:true,
			isinitVal:true,
			maxDate : jeDate.now(0)
		});
		jeDate({
			dateCell : "#calendar2",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
			isToday:true,
			isinitVal:true,
			maxDate : jeDate.now(0)
		});
		
	</script>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
