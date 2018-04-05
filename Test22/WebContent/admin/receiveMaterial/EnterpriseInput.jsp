<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>企业考察记录</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript"
	src="js/receiveMaterial/EnterpriseInput.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet"
	href="css/receive_report_data/inspection_input.css" />
<link rel="stylesheet" href="css/receive_report_data/logging_data.css" />
<link rel="stylesheet" href="css/public/lightbox.css" />
<link rel="stylesheet" href="controls/upload/webuploader.css" />
<link rel="stylesheet" href="controls/upload/webuploader.css" />
<link rel="stylesheet" href="controls/upload/style.css" />
<link rel="stylesheet" href="controls/upload/style2.css" />
<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
<style>
.jedateym .prev,.jedateym .next {
	padding-top: 12px;
}

.datainp {
	background-color: #FFFFFF;
}

.outside-modal {
	position: relative;
	width: 180px;
	height: 220px;
	border: 2px solid #EEEEEE;
	border-radius: 4px;
	text-align: center;
	float: left;
}

.outside-modal-a {
	width: 100%;
}

.img-class {
	width: 100%;
}

.delete-icon {
	position: absolute;
	top: 0;
	right: 0;
	height: 22px;
	width: 22px;
	text-align: right;
	background: rgba(0, 0, 0, 0.8);
	color: #FFFFFF;
	border-bottom-left-radius: 100%;
}

.delete-icon:hover {
	background: rgba(0, 0, 0, 0.2);
	border: 1px solid #EEEEEE;
	color: #000000;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						if (${projectAccept.projectFunds } >= 50) {
							$("#upload2").empty();
							console.log("start");
							var $link = "<script type='text/javascript' src='controls/upload/upload2.js'/>";
							$($link).appendTo("body");
							console.log("ok");
						}
					});
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






			<ol class="breadcrumb ol_nav">
				<li class="active">接收验收资料</li>
				<li><a href="admin/receiveMaterial/EnterpriseInvestigate.jsp">企业现场考察</a></li>
				<li class="active">录入企业考察信息</li>
			</ol>

			<div>
				<div class="base_info">
					<div class="info_modal">
						<div class="base_info_modal">
							<div class="info_backg">
								<div class="info_box_inspection">
									<span>项目基本信息</span>
								</div>
								<div class="project_table_box">
									<div class="hr"></div>
									<div class="project_pub_info_show">
										<div class="show_info_group pub_info_show_top_border">
											<div class="group_left">项目名称</div>
											<div class="group_right">${projectAccept.projectName }</div>
											<input type="hidden" value="${projectAccept.projectId}"
												id="EnProjectId">
											<div class="group_left">申请单位</div>
											<div class="group_right">${projectAccept.applicant }</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="project_pub_info_show">
										<div class="show_info_group">
											<div class="group_left">所属领域</div>
											<div class="group_right">${projectAccept.domain }</div>
											<div class="group_left">经费(万元)</div>
											<div class="group_right" id="projectFund">${projectAccept.projectFunds }</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="project_pub_info_show">
										<div class="show_info_group">
											<div class="group_left">登记人</div>
											<div class="group_right">${projectAccept.projectRecord.recordPerson }</div>
											<div class="group_left">登记日期</div>
											<div class="group_right">${projectAccept.projectRecord.recordDate }</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="project_pub_info_show">
										<div class="show_info_group">
											<div class="group_left">负责部门</div>
											<div class="group_right">${projectAccept.projectCharge.chargeUnit }</div>
											<div class="group_left">负责人</div>
											<div class="group_right">${projectAccept.projectCharge.chargePerson }</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="project_pub_info_show">
										<div class="show_info_group">
											<div class="group_left">领取验收资料人</div>
											<div class="group_right">${projectAccept.projectReceive.receivePerson }</div>
											<div class="group_left">领取验收资料时间</div>
											<div class="group_right">${projectAccept.projectReceive.receiveDate }</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="project_pub_info_show">
										<div class="show_info_group">
											<div class="group_left">审查人</div>
											<div class="group_right">${projectAccept.projectCensor.censorPerson }</div>
											<div class="group_left">审查时间</div>
											<div class="group_right">${projectAccept.projectCensor.censorDate }</div>
											<div class="clear"></div>
										</div>
									</div>
									<div>
										<div class="project_tab_pane_title">
											<div class="text-info-title">审查结果</div>
										</div>
										<textarea readonly="readonly"
											class="project_base_info_textarea">${projectAccept.projectCensor.censorResult }</textarea>
									</div>

								</div>
							</div>
						</div>
					</div>

					<div class="recommend_expert">
						<div class="info_modal">
							<div class="recommend_expert_info_modal">
								<div class="info_backg">
									<%-- <div class="experts_table_box">
										<div class="info_box_inspection">
											<span class="float-left">企业推荐的专家</span>
											<!--<div class="float-right" style="display: inline-block;"><a href="#" class="btn btn-default">打印</a></div>-->
											<a href="#" class="btn btn-default " style="float: right;"
												data-toggle="modal" data-target="#add_modal">添加</a>
											<!--<a href="#" class="btn btn-default " style="float: right;>打印</a>-->
											<div class="clear"></div>
											<button class="hidden" id="createModel" data-toggle="modal"
												data-target="#experts_info" style="width: 150px">
										</div>

										<!-------------------------------------------保存所有企业考察的文字信息---------------------------------------------->
										<form action="enterpriseInvestigate.action" method="post"
											id="enterpriseInvestigate_form" name="enterpriseAction">
											<input type="hidden" value="${projectAccept.projectId}"
												name="projectIdT"> <input type="hidden"
												value="${projectAccept.projectId}" name="sourceT"> <input
												type="hidden" value="${projectAccept.projectFunds}"
												name="projectFundsT">

											<table class="table table-hover table-bordered"
												id="specialistTable">
												<thead>
													<tr>
														<th>序号</th>
														<th>姓名</th>
														<th>工作单位</th>
														<th>从事专业</th>
														<th>职务</th>
														<th>职称</th>
														<th>联系方式</th>
														<th>操作</th>
														<th>录入专家库</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="Specialist" varStatus="status"
														items="${listSpecialist}">
														<tr>
															<td>${status.index+1}</td>
															<td>${Specialist.name}</td>
															<td class="hidden">${Specialist.sex}</td>
															<td class="hidden">${Specialist.birthday}</td>
															<td>${Specialist.workUnit}</td>
															<td>${Specialist.engageDomain}</td>
															<td>${Specialist.duty}</td>
															<td>${Specialist.title}</td>
															<td>${Specialist.telephone}</td>
															<td class="hidden">${Specialist.email}</td>
															<td><a href='javaScript:void(0)' class='specialist'>删除</td>
															<td><a href='javaScript:void(0)'
																class='addSpecialistLibrary'>录入专家库</td>
															<td class="hidden">${Specialist.specialistId}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
									</div> --%>
									
									<form action="enterpriseInvestigate.action" method="post"
											id="enterpriseInvestigate_form" name="enterpriseAction">
											
									<input type="hidden" value="${projectAccept.projectId}"
										name="projectIdT"> <input type="hidden"
										value="${projectAccept.projectId}" name="sourceT"> <input
										type="hidden" value="${projectAccept.projectFunds}"
										name="projectFundsT">

									<div class="input_box " style="margin-bottom:5px;">
										<div class="floatL input-group" style="width:35%">
										
											<span class="input-group-addon">考察人</span> <input
												class="datainp form-control" 
												value="${projectInfoOfPrepared.enterpriseInspect.inspectPerson }"
												name="enterpriseInspect.inspectPerson" type="text"
												placeholder="请输入考察人，人名之间以‘，’分割" >
											<%-- <div style="width:75%" class="floatL">
												<input id="inspectPer"
													value="${projectInfoOfPrepared.enterpriseInspect.inspectPerson }">
											</div> --%>
										</div>
										
										<div class="floatL input-group" style="width:35%">
											<span class="input-group-addon">企业接待人</span> <input
												class="datainp form-control" 
												value="${projectInfoOfPrepared.enterpriseInspect.enterpriseReceiver }"
												name="enterpriseInspect.enterpriseReceiver" type="text"
												placeholder="请输入企业接待人，人名以‘，’分割" >
										</div>
										
										<div class="floatR input-group" style="width:30%">
											<span class="input-group-addon">考察时间</span> <input
												class="datainp form-control" id="calendar_send"
												value="${projectInfoOfPrepared.enterpriseInspect.inspectDate}"
												name="enterpriseInspect.inspectDate" type="text"
												placeholder="请选择时间" readonly>
										</div>
										<div class="clear"></div>
									</div>
									<script type="text/javascript">
										jeDate({
											dateCell : "#calendar_send",//isinitVal:true,
											format : "YYYY-MM-DD",
											isTime : true, //isClear:false,
											isinitVal:true
										});
									</script>

									<div style="margin:0 20px">
										<div
											style="text-align:center;background:#EEEEEE;border:1px solid #CCCCCC;border-bottom:none;height:32px;line-height:32px;">
											<label>考察结果</label>
										</div>
										<!-- <label class="name_info_area input-group-addon">考察结果</label> -->
										<textarea class="base_info_textarea" placeholder="在这里输入..."
											name="enterpriseInspect.inspectResult">${projectInfoOfPrepared.enterpriseInspect.inspectResult}</textarea>
									</div>

								</div>
							</div>
						</div>
					</div>

					<div class="base_info">
						<div class="info_modal">
							<div class="base_info_modal">
								<div class="info_backg">
									<div class="pic_box">
										<div style="border: 1px solid #CCCCCC;">
											<div id="uploader">
												<div class="queueList">
													<div id="dndArea" class="placeholder">
														<div id="filePicker"></div>

														<p style="margin-bottom: 20px;">考察照片，文件上传</p>
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
													</div>
												</div>
											</div>
										</div>

										<div>
											<%-- <span>企业考察照片</span> --%>
										</div>
										<div class="row pic_row">

											<c:forEach var="picture" items="${pictureList}">
												<%-- <a href="img/yaowei/img_2.jpg" data-lightbox="yaowei"
											class="box_size" data-title="second pic"> <img
											src="img/yaowei/img_2.jpg" /> <span class="pic_info">忘得人</span>
										</a> --%>
												<%-- <a href="${picture.currentName}" data-lightbox="yaowei"
													class="box_size" data-title="second pic"> <img
													src="${picture.currentName}" /> <span class="pic_info">${picture.originalName}</span>
												</a> --%>

												<div class="outside-modal">
													<div class="delete-icon">
														<i class="glyphicon glyphicon-remove" title="删除"></i>
													</div>
													<a href="${picture.currentName}"
														data-lightbox="example-set" class="outside-modal-a"> <img
														src="${picture.currentName}" class="img-class" />
													</a>
												</div>

											</c:forEach>

										</div>

									</div>
									<div class="btn_box" style="float: right;">
										<!-- <button type="button" id="check_chufa" >check</button> -->
										<button type="button" class=" btn btn-default "
											id="saveMostInfo">保存</button>
										<button type="button" class=" btn btn-default "
											id="submitMostInfo">提交</button>
										<button type="button" class=" btn btn-default float-right"
											style="float: right; background-color:#FFFFFF;color:#000000;"
											id="cancelMostInfo">取消</button>

									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>

					<div class="audit_report ">
						<div class="info_modal">
							<div class="audit_report_info_modal">
								<div class="info_backg">
									<div class="info_box_inspection">
										<span>审计信息录入</span>
									</div>
									<div class="input-group input_box">
										<!--表单的验证？-->
										<span class="input-group-addon">财务审计单位</span> <input
											type="text" class="form-control" name="auditInfo.financeUnit"
											value="${projectInfoOfPrepared.auditInfo.financeUnit}"
											id="financeUnit"> <span class="input-group-addon">审计人员</span>
										<input type="text" class="form-control"
											name="auditInfo.auditingPerson"
											value="${projectInfoOfPrepared.auditInfo.auditingPerson}"
											id="auditingPerson"> 
									</div>
									
									<div class="input-group input_box">
										<!--表单的验证？-->
										<span class="input-group-addon">企业接待人</span> <input
												class="datainp form-control" 
												value="${projectInfoOfPrepared.auditInfo.enterpriseReceiver2 }"
												name="auditInfo.enterpriseReceiver2" type="text"
												placeholder="请输入企业接待人，人名以‘，’分割" >
										
										 <span class="input-group-addon">审计时间</span>
										<input class="datainp form-control" id="calendar_logging_time"
											name="auditInfo.auditDate" type="text" placeholder="请选择时间"
											value="${projectInfoOfPrepared.auditInfo.auditDate}" readonly>
									</div>
									
									<script type="text/javascript">
										jeDate({
											dateCell : "#calendar_logging_time",//isinitVal:true,
											format : "YYYY-MM-DD",
											isTime : false, //isClear:false,
											isinitVal:true
										});
									</script>

									<div class="pic_box">
										<div style="border: 1px solid #CCCCCC;">
											<div id="up">
												<div class="up_queueList">
													<div id="up_dndArea" class="up_placeholder">
														<div id="filePicker3"></div>
														<p style="margin-bottom: 20px;">审计照片，文件上传</p>
													</div>
												</div>
												<div class="up_statusBar" style="display:none;">
													<div class="up_progress">
														<span class="text">0%</span> <span class="percentage"></span>
													</div>
													<div class="up_info"></div>
													<div class="up_btns">
														<div id="file_Picker2"></div>
														<div class="up_uploadBtn">开始上传</div>
													</div>
												</div>
											</div>
										</div>

										
										<div class="row pic_row">

											<c:forEach var="picture" items="${pictureList2}">
												<%-- <a href="${picture.currentName}" data-lightbox="yaowei"
													class="box_size" data-title="second pic"> <img
													src="${picture.currentName}" /> <span class="pic_info">${picture.originalName}</span>
												</a> --%>

												<div class="outside-modal">
													<div class="delete-icon">
														<i class="glyphicon glyphicon-remove" title="删除"></i>
													</div>
													<a href="${picture.currentName}"
														data-lightbox="example-set" class="outside-modal-a"> <img
														src="${picture.currentName}" class="img-class" />
													</a>
												</div>
											</c:forEach>

										</div>

									</div>
									<div class="btn_box" style="float: right;">
										<button type="button" class=" btn btn-default float-left"
											id="saveAllInfo">保存</button>
										<button type="button" class=" btn btn-default "
											id="submitAllInfo">提交</button>
										<button type="button" class=" btn btn-default float-right"
											style="float: right;background-color:#FFFFFF;color:#000000;"
											id="cancelAllInfo">取消</button>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
					<!---->
					<input type="hidden" value="save" id="isSubmit" name="isSubmit">
					<input type="button" id="submitAll" class="hidden" onclick="enterpriseAction.submit()">
					</form>

					<!-------------------------------------------保存所有企业考察的文字信息---------------------------------------------->


				</div>



			</div>

		</div>
		<div class="clear"></div>
	</div>

	<jsp:include page="/admin/home/footer.jsp"></jsp:include>

	<!--添加modal-->
	<div class="modal fade" id="add_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" id="closeSpecialist">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">企业推荐专家</h4>
				</div>
				<!-- ********************* -->
				<form id="add_modal_form">
					<div class="modal-body">

						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>姓名</label>
							</div>
							<div class="add_experts_class_right">
								<input type="text" class="form-control" id="sName" name="sName" />
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>性别</label>
							</div>
							<div class="add_experts_class_right">
								<input type="radio" name="sex" checked="checked" value="男" /> <label>男</label>
								<input type="radio" name="sex" value="女" /> <label>女</label>
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>出生年月</label>
							</div>
							<div class="add_experts_class_right">
								<input class="datainp form-control" id="sBirthday" type="text"
									placeholder="请选择" readonly name="sBirthday">
							</div>
							<script type="text/javascript">
								jeDate({
									dateCell : "#sBirthday",//isinitVal:true,
									format : "YYYY-MM-DD",
									isTime : false, //isClear:false,
								});
							</script>

							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>工作单位</label>
							</div>
							<div class="add_experts_class_right">
								<input type="text" class="form-control" id="sWorkUnit"
									name="sWorkUnit" />
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>从事领域</label>
							</div>
							<div class="add_experts_class_right">
								<!-- <input type="text" class="form-control" id="sEngageDomain" name="sEngageDomain" /> -->
								<select class="form-control " name="sEngageDomain"
									id="sEngageDomain">
								</select>
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>职务</label>
							</div>
							<div class="add_experts_class_right">
								<input type="text" class="form-control" id="sDuty" name="sDuty" />
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>职称</label>
							</div>
							<div class="add_experts_class_right">
								<input type="text" class="form-control" id="sTitle"
									name="sTitle" />
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>联系方式</label>
							</div>
							<div class="add_experts_class_right">
								<input type="text" class="form-control" id="sTelephone"
									name="sTelephone" onkeyup="value=value.replace(/[^\d\-\/]/ig,'')" onafterupdate="value=value.replace(/[^\d\-\/]/ig,'')"/>
							</div>
							<div class="clear"></div>
						</div>
						<div class="add_experts_class">
							<div class="add_experts_class_left">
								<label>邮箱</label>
							</div>
							<div class="add_experts_class_right">
								<input type="email" class="form-control" id="sEmail"
									name="sEmail" />
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary save_btn_width"
							id="saveSpecial">保存</button>
						<button type="button" class="btn btn-default save_btn_width"
							data-dismiss="modal" id="cancelButton">取消</button>
					</div>
					<input type="reset" id="resetMe" class="hidden"> <input
						type="submit" id="submitSpecialist" class="hidden">
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!--将专家保存到专家库-->
	<div class="modal fade" id="experts_info" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" id="hiddenModel2">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">确认专家信息</h4>
				</div>

				<form id="specialist_form" method="post"
					action="addSpecialistLib.action">
					<div class="modal-body">
						<div class="register_modal_body">
							<div class="input_info_group hidden">
								<div class="group_left"></div>
								<div class="group_right">
									<input type="hidden" class="form-control"
										name="specialist.specialistId" id="id">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.name"
										id="nameq">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</div>
								<div class="group_right">
									<input type="radio" name="specialist.sex" value="男" id="sexq"
										class="sexq" /><label style="margin-right:10px">男</label> <input
										type="radio" name="specialist.sex" value="女" class="sexq" /><label
										style="margin-right:10px">女</label>
									<!-- <input type="text" class="form-control" name="specialist.sex" id="sex"> -->
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">出生日期</div>
								<div class="group_right">
									<!-- <input type="text" class="form-control" name="specialist.birthday" id="birthday"> -->
									<input class="datainp form-control" id="birthdayq"
										name="specialist.birthday" type="text" placeholder="请选择日期"
										readonly>
								</div>
								<script type="text/javascript">
									jeDate({
										dateCell : "#birthdayq",//isinitVal:true,
										format : "YYYY-MM-DD",
										isTime : false, //isClear:false,
									/* minDate : "2004-09-19 00:00:00" */
									});
								</script>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">工作单位</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="specialist.workUnit" id="workUnitq">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">所属领域</div>
								<div class="group_right">
									<select class="form-control " name="specialist.engageDomain"
										id="engageDomainq">
									</select>
									<!-- <input type="text" class="form-control" id="engageDomainq" name="specialist.engageDomain" /> -->
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.duty"
										id="dutyq">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.title"
										id="titleq">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">联系电话</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="specialist.telephone" id="telephoneq" onkeyup="value=value.replace(/[^\d\-\/]/ig,'')" onafterupdate="value=value.replace(/[^\d\-\/]/ig,'')">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">电子邮箱</div>
								<div class="group_right">
									<input type="email" class="form-control"
										name="specialist.email" id="emailq">
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<!-- <button type="submit">submit</button> -->
						<button type="submit" class="btn  btn-primary modal_btn"
							id="multiple">保存</button>
						<button type="button" class="btn btn-default modal_btn"
							data-dismiss="modal" id="close">取消</button>
					</div>

					<input type="reset" id="resetMe2" class="hidden">
				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<div class="clear"></div>


	<script type="text/javascript" src="js/public/lightbox.js"></script>
	<script type="text/javascript" src="controls/upload/webuploader.js"></script>
	<script type="text/javascript" src="controls/upload/upload.js" />
	<%-- <script type="text/javascript" src="controls/upload/upload2.js"></script> --%>


	<script>
		/* //单个不为空验证
		function checkForm(content){			
			if(content.val() == ""){
				content.addClass("validate_error");	
			}else{
				content.removeClass("validate_error");
			}
		}	
		
		//自定义不为空验证
		$(function(){			
		  	$("#check_chufa").click(function(){
		  		console.log("check!");
		  		checkForm($("#inspectPerson"));
		  		checkForm($("#calendar_send"));
		  		checkForm($("#financeUnit"));
		  		checkForm($("#auditingPerson"));
		  		checkForm($("#calendar_logging_time"));
		  	})
		  	
			
		}) */

		/* jeDate({
			dateCell : "#calendar_send",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
			minDate : "2014-09-19 00:00:00"
		});

		jeDate({
			dateCell : "#calendar_logging_time",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
			minDate : "2014-09-19 00:00:00"
		});

		jeDate({
			dateCell : "#sBirthday",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
			minDate : "2014-09-19 00:00:00"
		}); */
	</script>
</body>
</html>
