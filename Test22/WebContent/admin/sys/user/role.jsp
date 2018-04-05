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

<title>角色管理</title>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/sys/user/role.css" />
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="css/public/main2.css" />
<script type="text/javascript" src="js/sys/user/role.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="js/zTree/jquery.ztree.excheck-3.5.js"></script>
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
	<div class="bread">
		<ol class="breadcrumb">
			<li class="active">系统管理</li>
			<li class="active">角色管理</li>
		</ol>
	</div>
	<div class="search_bar">
			<div class="input-group search_bar_input floatL">
				<span class="input-group-addon">角色名称</span> 
				<input type="text" class="form-control" placeholder="" id="nameCon">
			</div>
			<button class="btn btn-primary search_bar_button floatR" id="selectInfo">
				查询<span class=" glyphicon glyphicon-search  span_icon"></span>
			</button>

			<div class="clear"></div>
	</div>
	<div class="table_box outside_box">
		<div class="box_title word_center" style="font-size:22px" >
			<h3>角色管理</h3>
		</div>
		<div class="hr" style=""></div>
		<div class="btn_box">
			<div>
				<%-- <button class="btn btn-primary floatL" id="">导出 <span class=" glyphicon glyphicon-print "></span></button> --%>
				<button class="btn btn-primary floatR " id="create" data-toggle="modal" data-target="#roleInfo">添加角色</button>
				<button class="btn btn-primary floatR " id="deleteInfo">批量删除</button>
			</div>
			<div class="clear"></div>
		</div>
		<div>
			<table class="table table-bordered" id="showRole">
				<thead>
					<tr>
						<th>选择</th>
						<th>序号</th>
						<th>角色名称</th>
						<th>是否启用</th>
						<th>描述</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
	</div>
	</div>
	<div class="clear"></div>
	</div>
	
	<!--添加角色-->
	<div class="modal fade" id="roleInfo" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">角色管理</h4>
				</div>
				<div class="modal-body">
					<div class="register_modal_body">
					<div class="input_info_group hidden">
							<div class="group_left"></div>
							<div class="group_right">
								<input type="hidden" class="form-control" name="role.roleId" id="id">
							</div>
							<div class="clear"></div>
						</div>
						<div class="input_info_group">
							<div class="group_left">角色名称</div>
							<div class="group_right">
								<input type="text" class="form-control" name="role.roleName" id="roleName">
							</div>
							<div class="floatL " style="color:red;font-size:12px;line-height:34px;margin-left:8px; display:none;" id="roleNameCheck" >不能为空</div>
							<div class="clear"></div>
						</div>
						<div class="input_info_group">
							<div class="group_left">启用</div>
							<div class="group_right">
								<input type="radio" name="role.use" value="true"><span>启用</span> 
								<input type="radio" name="role.use" value="false"><span>禁用</span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="input_info_group">
							<div class="group_left">描述</div>
							<div class="group_right">
							<input type="text" class="form-control" name="role.description" id="description">
							</div>
							<div class="clear"></div>
						</div>
						<div class="input_info_group">
							<div class="group_left">备注</div>
							<div class="group_right">
								<input type="text" class="form-control" name="role.remark" id="remark">
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary modal_btn" id="multiple">保存</button>
					<button type="button" class="btn btn-default modal_btn" data-dismiss="modal" id="closeRoleInfo">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--权限管理-->
	<div class="modal fade" id="roleManage" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header word_center my_modal_title">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">权限管理</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" id="tempRoleId"/>
					<ul id="moduleTree" class="ztree"></ul>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary modal_btn" id="saveModule">保存</button>
					<button type="button" class="btn btn-default modal_btn" data-dismiss="modal" id="closeRoleManage">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>