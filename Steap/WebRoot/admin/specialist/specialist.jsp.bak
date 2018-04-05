<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>专家管理</title>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/specialist/specialist.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript"
	src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
<script type="text/javascript" src="js/public/main.js"></script>
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
			<ol class="breadcrumb">
				<li class="active">系统管理</li>
				<li class="active">专家管理</li>
			</ol>
			<div class="search_bar">
				<div class="input-group search_bar_input floatL" style="width: 12%">
					<span class="input-group-addon">姓名</span>
					 <input type="text" class="form-control" placeholder="" id="nameCon">
				</div>

				<div class="input-group search_bar_select floatL" style="width: 20%">
					<span class="input-group-addon">领域</span>
					 <select
						class="form-control " id="domainCon" name="engageDomain">
						<option>请选择</option>
					</select>
				</div>

				<div class="input-group search_bar_input floatL" style="width: 16%">
					<span class="input-group-addon">单位</span> <input type="text"
						class="form-control" placeholder="" id="workUnitCon">
				</div>

				<div class="input-group search_bar_input floatL" style="width: 16%">
					<span class="input-group-addon">职务</span> <input type="text"
						class="form-control" placeholder="" id="dutyCon">
				</div>

				<div class="input-group search_bar_input floatL" style="width: 16%">
					<span class="input-group-addon">职称</span> <input type="text"
						class="form-control" placeholder="" id="titleCon">
				</div>
				<%-- <div class="input-group search_bar_select floatL">
					<span class="input-group-addon">设置初始密码</span> <select
						class="form-control " id="initialPass">
						<option>请选择</option>
						<option>已设置</option>
						<option>未设置</option>
					</select>
				</div> --%>

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
			<div class="table_box outside_box">
				<div class="box_title word_center header_show">
					<h3>专家管理</h3>
				</div>
				<div class="hr" style=""></div>
				<div class="btn_box">
					<div>
						<%-- <button class="btn btn-primary floatL" id="">
							导出 <span class=" glyphicon glyphicon-print "></span>
						</button> --%>

						<button class="btn btn-primary floatR " id="deleteInfo"
							style="width: 150px">批量删除</button>
						<button class="btn btn-primary floatR " id="backupSignature"
							style="width: 150px">备份专家签名</button>
						<!-- <button class="btn btn-primary floatR " id="setPassword"
							style="width: 150px">设置初始密码</button> -->
						<button class="btn btn-primary floatR " id="resetPassword"
							style="width: 150px">重置密码</button>
						<button class="btn btn-primary floatR " id="create"
							data-toggle="modal" data-target="#experts_info"
							style="width: 150px">添加专家</button>
						<button class="btn btn-primary floatR" id="account_add"
							data-toggle="modal" data-target="" style="width: 150px">创建账户</button>
					</div>
					<div class="clear"></div>
				</div>
				<div>
					<table class="table table-bordered" id="showSpecialist">
						<thead>
							<tr>
								<th>选择</th>
								<!-- <th>序号</th> -->
								<th>姓名</th>
								<th class="hidden">性别</th>
								<th class="hidden">出生日期</th>
								<th>工作单位</th>
								<th>从事领域</th>
								<th>职务</th>
								<th>职称</th>
								<th>所学专业</th>
								<th>从事专业</th>
								<th>联系电话</th>
								<th class="hidden">电子邮箱</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
					<div id="page"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div class="clear"></div>
	</div>

	<!--添加专家-->
	<div class="modal fade" id="experts_info" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">专家信息</h4>
				</div>

				<form id="specialist_form" method="post">
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
										id="name">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</div>
								<div class="group_right">
									<input type="radio" name="specialist.sex" value="男"
										checked="checked" /><label style="margin-right: 10px">男</label>
									<input type="radio" name="specialist.sex" value="女" /><label
										style="margin-right: 10px">女</label>
									<!-- <input type="text" class="form-control" name="specialist.sex" id="sex"> -->
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">出生日期</div>
								<div class="group_right">
									<!-- <input type="text" class="form-control" name="specialist.birthday" id="birthday"> -->
									<input class="datainp form-control" id="birthday"
										name="specialist.birthday" type="text" placeholder="请选择日期"
										readonly>
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">工作单位</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="specialist.workUnit" id="workUnit">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">所属领域</div>
								<div class="group_right">
									<select class="form-control " name="specialist.engageDomain"
										id="engageDomain">
										<option>请选择</option>
									</select>
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="specialist.degree" id="degree">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.major"
										id="major">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">从事专业</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.ZJZY"
										id="ZJZY">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.duty"
										id="duty">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.title"
										id="title">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">联系电话</div>
								<div class="group_right">
									<input type="text" class="form-control"
										name="specialist.telephone" id="telephone">
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">电子邮箱</div>
								<div class="group_right">
									<input type="text" class="form-control" name="specialist.email"
										id="email">
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<!-- <button type="submit">submit</button> -->
						<button type="submit" class="btn  btn-primary modal_btn" id="save">保存</button>
						<button type="button" class="btn btn-primary modal_btn"
							data-dismiss="modal" id="close">取消</button>
					</div>

				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!--设置初始密码-->
	<div class="modal fade" id="password_info" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">设置密码</h4>
				</div>
				<form id="password_form" method="post">
					<div class="modal-body">
						<div class="input_info_group">
							<div class="group_left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</div>
							<div class="group_right">
								<input type="password" class="form-control" name="setPassword">
							</div>
							<div class="clear"></div>
						</div>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn  btn-primary modal_btn"
							id="savePassword">保存</button>
						<button type="button" class="btn btn-primary modal_btn"
							data-dismiss="modal" id="closePass">取消</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 给专家创建账户 -->
	<div class="modal fade" id="create_account" style="margin-top: 100px;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">创建账户</h4>
				</div>
				<form name="acc" id="form_a">
					<div class="modal-body">
						<div class="register_modal_body">
							<div class="input_info_group">
								<div class="group_left">专家编号</div>
								<div class="group_right">
									<input type="text" class="form-control" id="accountId"
										name="useracc.u_id" readonly="readonly" /><span
										id="check-tip" style="color: red;"></span>
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">账户</div>
								<div class="group_right">
									<input type="text" class="form-control _acc" id="account"
										name="useracc.userName" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="input_info_group">
								<div class="group_left">密码</div>
								<div class="group_right">
									<input type="password" class="form-control _acc" id="key"
										name="useracc.password" />
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" id="trigger_save_account"
							class="btn btn-primary modal_btn">保存</button>
						<button type="button" id="save_account"
							class="btn btn-primary modal_btn" style="display: none;">提交</button>
						<button type="button" id="cancel_save_account"
							class="btn btn-primary modal_btn" data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script>
		jeDate({
			dateCell : "#birthday",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : false, //isClear:false,
		/* minDate : "2004-09-19 00:00:00" */
		});

		$(function() {
			$("#specialist_form")
					.validate(
							{
								rules : {
									'specialist.name' : {
										required : true,
									}, //	specialist.name
									'specialist.birthday' : {
										required : true,
									}, //	specialist.name
									'specialist.workUnit' : {
										required : true,
									}, //	specialist.workUnit
									'specialist.engageDomain' : {
										required : true,
									}, //	specialist.engageDomain
									'specialist.degree' : {
										required : true,
									}, //	specialist.name
									'specialist.major' : {
										required : true,
									}, //	specialist.name
									'specialist.ZJZY' : {
										required : true,
									}, //	specialist.name
									'specialist.duty' : {
										required : true,
									}, //	specialist.name
									'specialist.title' : {
										required : true,
									}, //	specialist.title
									'specialist.telephone' : {
										required : true,
									}, //	specialist.name
									'specialist.email' : {
										required : true,
										email : true
									}, //specialist.email
								},
								messages : {
									'specialist.name' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.birthday' : {
										required : '请选择',
									}, //	specialist.name
									'specialist.workUnit' : {
										required : '不能为空',
									}, //	specialist.workUnit
									'specialist.engageDomain' : {
										required : '不能为空',
									}, //	specialist.engageDomain
									'specialist.degree' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.major' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.ZJZY' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.duty' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.title' : {
										required : '不能为空',
									}, //	specialist.title
									'specialist.telephone' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.email' : {
										required : '不能为空',
										email : '请输入正确的email格式'
									}, //specialist.email
								},
								errorClass : "error",
								success : 'valid',
								unhighlight : function(element, errorClass,
										validClass) { //
									$(element).tooltip('destroy').removeClass(
											errorClass);
								},
								errorPlacement : function(label, element) {
									$(element).tooltip('destroy'); /*必需*/
									$(element).attr('title', $(label).text())
											.attr("data-placement", "right")
											.tooltip('show');
								},
								submitHandler : function(form) {
									if (choose == 1) {
										isLibrarySpecialist();
									} else if (choose == 2) {
										updateSpecialist();
									}
									var offs = 39;
									console.log("start");
									withHeight($(".menu_modal"),
											$(".main_body"), offs);
									console.log("start");
								}
							});

			$("#form_a")
					.validate(
							{

								rules : {
									'useracc.userName' : {
										required : true,
									},
									'useracc.password' : {
										required : true,
										maxlength : 16,
										minlength : 6
									},
								},
								messages : {
									'useracc.userName' : {
										required : '不能为空',
									},
									'useracc.password' : {
										required : '不能为空',
										maxlength : '最长为16位',
										minlength : '最短为6位'
									},
								},
								errorClass : "error",
								success : 'valid',
								unhighlight : function(element, errorClass,
										validClass) { //验证通过
									$(element).tooltip('destroy').removeClass(
											errorClass);
								},
								errorPlacement : function(label, element) {
									$(element).tooltip('destroy'); /*必需*/
									$(element).attr('title', $(label).text())
											.attr("data-placement", "right")
											.tooltip('show');
								},
								submitHandler : function(form) {
									$("#save_account").trigger("click");
								}

							});
		});
		$("#password_form").validate(
				{
					rules : {
						'setPassword' : {
							required : true,
							minlength : 6,
							maxlength : 16
						},
					},
					messages : {
						'setPassword' : {
							required : '不能为空',
							minlength : '长度为6-16位',
							maxlength : '长度为6-16位'
						}, //	ssetPassword
					},
					errorClass : "error",
					success : 'valid',
					unhighlight : function(element, errorClass, validClass) { //
						$(element).tooltip('destroy').removeClass(errorClass);
					},
					errorPlacement : function(label, element) {
						$(element).tooltip('destroy'); /*必需*/
						$(element).attr('title', $(label).text()).attr(
								"data-placement", "right").tooltip('show');
					},
					submitHandler : function(form) {
						setPass();
						var offs = 39;
						console.log("start");
						withHeight($(".menu_modal"), $(".main_body"), offs);
						console.log("start");
					}
				});
	</script>

	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>

<!-- 
</body>
</html> -->