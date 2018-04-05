<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>用户管理</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/public/trim.js"></script>
<script type="text/javascript" src="js/sys/user/user.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/register/register.css" />
<script type="text/javascript" src="js/public/jquery.validate.js"></script>

<script type="text/javascript"
	src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />

<script type="text/javascript" src="js/public/main.js"></script>

<script>
$(function(){
	
	$("#form_a").validate({
		
		rules: { 
        	'useracc.userName':{required: true,}, 
        	'useracc.password':{required: true,maxlength:16,minlength:6},
        },
        messages: {
        	'useracc.userName':{required: '不能为空',}, 	
        	'useracc.password':{required: '不能为空',maxlength:'最长为16位',minlength:'最短为6位'},	
        },
        errorClass: "error",
        success: 'valid',
        unhighlight: function (element, errorClass, validClass) { //验证通过
            $(element).tooltip('destroy').removeClass(errorClass);
        },
        errorPlacement: function (label, element) {
            $(element).tooltip('destroy'); /*必需*/
            $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show'); 
        },
        submitHandler: function (form) {
        	$("#save_account").trigger("click");
        }
       
	});
	
	$("#form1").validate({
		
        rules: { 
        	'user_name':{required: true,}, //user_name	
        	'user_duty':{required: true,}, //user_duty	
        	'user_telephone':{required: true,digits:true,minlength:11,maxlength:12}, //user_name	
        },
        messages: {
        	'user_name':{required: '不能为空',}, //user_name	
        	'user_duty':{required: '不能为空',}, //user_duty	
        	'user_telephone':{required: '不能为空',digits:'号码为数字',minlength:'请输入正确的号码',maxlength:'请输入正确的号码'}, //user_name
        },
        errorClass: "error",
        success: 'valid',
        unhighlight: function (element, errorClass, validClass) { //验证通过
            $(element).tooltip('destroy').removeClass(errorClass);
        },
        errorPlacement: function (label, element) {
            $(element).tooltip('destroy'); /*必需*/
            $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show'); 
        },
        submitHandler: function (form) {
        	$(".submitToDB").trigger("click");
        }
	});
	
	$("#updateUserInfo").validate({
			
	        rules: { 
	        	'u_name':{required: true,}, //user_name	
	        	'u_duty':{required: true,}, //user_duty	
	        	'u_telephone':{required: true,digits:true,minlength:11,maxlength:12}, //user_name	
	        },
	        messages: {
	        	'u_name':{required: '不能为空',}, //user_name	
	        	'u_duty':{required: '不能为空',}, //user_duty	
	        	'u_telephone':{required: '不能为空',digits:'号码为数字',minlength:'请输入正确的号码',maxlength:'请输入正确的号码'}, //user_name
	        },
	        errorClass: "error",
	        success: 'valid',
	        unhighlight: function (element, errorClass, validClass) { //验证通过
	            $(element).tooltip('destroy').removeClass(errorClass);
	        },
	        errorPlacement: function (label, element) {
	            $(element).tooltip('destroy'); /*必需*/
	            $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show'); 
	        },
	        submitHandler: function (form) {
	        	$(".updateUserInfoToDB").trigger("click");
	        }
		});
});
</script>
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
		  	<li class="active">系统管理</li>
		  	<li class="active">用户管理</li>		  	
		</ol>				
	</div>
	<div>
		<div class="user_left_tree_info">
			<div class="user_left_tree_info_title">部门</div>
			<div class="hr"></div>
			<!-- 这是添加zTree的div -->
			<div aria-multiselectable="true">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
		<div class="floatL" style="width: 80%;">
			<div class="search_bar">
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">用户姓名</span>
				  	<input type="text" id="user_name_condition" class="form-control" placeholder="" >
				</div>
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">用户职务</span>
				  	<input type="text"  id="user_duty_condition" class="form-control" placeholder="" aria-describedby>
				</div>
				
				<button class="btn btn-primary search_bar_button floatR" id="condition_sub">查询<span class=" glyphicon glyphicon-search span_icon"></span></button>
				
				<div class="clear"></div>
			</div>
			
								
				<div class="table_box outside_box">
					
					<div class="box_title word_center"><h3>用户管理</h3></div>
					<div class="hr" style=""></div>
					<div class="btn_box">			
						<div>
							<!-- <button class="btn btn-primary floatL" id="">导出 <span class=" glyphicon glyphicon-print span_icon"></span></button> -->	
							<button class="btn btn-primary floatR modal_btn" id="reset_password" data-toggle="modal" data-target="">重置密码</button>
							<button class="btn btn-primary floatR modal_btn" id="user_delete" data-toggle="modal" data-target="#register_modal">批量删除</button>
							<button class="btn btn-primary floatR modal_btn" id="user_add" data-toggle="modal" data-target="#user_add_modal">添加</button>
							<button class="btn btn-primary floatR modal_btn" id="account_add" data-toggle="modal" data-target="">创建账户</button>
							<button class="btn btn-primary floatR modal_btn" id="view_account" data-toggle="modal" data-target="">查看账户</button>
							<input type="hidden" value="" id="bt_unitId"> 
							<input type="hidden" value="" id="bt_unitName">
							<input type="hidden" value="" id="table_row">	
							<input type="hidden" value="" id="selectedRow" />
						</div>
						<div class="clear"></div>
					</div>
					
					<div class="">
						<table class="table table-bordered  table-hover">
							<thead>
								<tr>
									<th><input type="checkbox" name="all" id="all"/></th>
									<th>序号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>部门</th>
									<th>职务</th>
									<th>电话</th>										
									<th>角色</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="userTable"></tbody>
						</table>
						<div id="page"></div>
					</div>
					
<!-- 					<nav class="word_center">
					  	<ul class="pagination">
						    <li>
						      	<a href="#" aria-label="Previous">
						        	<span aria-hidden="true">&laquo;</span>
						      	</a>
						    </li>
						    <li><a href="#">1</a></li>
						    <li><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li>
						      	<a href="#" aria-label="Next">
						        	<span aria-hidden="true">&raquo;</span>
						      	</a>
						    </li>
					  	</ul>
					</nav> -->

			</div>

				
		</div>
		
		<div class="clear"></div>
	</div>
	
	</div>
	<div class="clear"></div>
	</div>
	
	<!-- 查看账户 -->
	<div class="modal fade" id="view_account_modal" style="margin-top: 100px;">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">查看用户账户信息</h4>
		      </div>
		      <form name="acc" id="form_a" >
			       	<div class="modal-body">
			        <div class="register_modal_body">
			      		<div class="input_info_group">
			      			<div class="group_left">员工编号</div>
			      			<div class="group_right">
			      				<input type="text" class="form-control _acc" id="u_account_userId" readonly="readonly" /></span> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">员工姓名</div>
			      			<div class="group_right">
			      				<input type="text" class="form-control _acc" id="u_account_name" readonly="readonly" /></span> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">账户</div>
			      			<div class="group_right">
			      				<input type="text" class="form-control _acc" id="u_account" readonly="readonly"/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">密码</div>
			      			<div class="group_right">
			      				<input type="password" class="form-control _acc" id="u_password" readonly="readonly"/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
				    </div>
			      </div>
			      <div class="modal-footer">	    
			      	<button type="button" class="btn btn-primary modal_btn" id="view_account_password">密码明文</button>    
			        <button type="button" class="btn btn-default modal_btn" id="close_account_view" data-dismiss="modal">关闭</button>
			      </div>
	     	 </form>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	
	
	<!--员工添加-->
	<div class="modal fade" id="create_account" style="margin-top: 100px;">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">创建账户</h4>
		      </div>
		      <form name="acc" id="form_a" >
			       	<div class="modal-body">
			        <div class="register_modal_body">
			      		<div class="input_info_group">
			      			<div class="group_left">员工编号</div>
			      			<div class="group_right">
			      				<input type="text" class="form-control" id="user_id" name="useracc.u_id" readonly="readonly" /><span id="check-tip" style="color:red;"></span> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">账户</div>
			      			<div class="group_right">
			      				<input type="text" class="form-control _acc" id="account" name="useracc.account"/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">密码</div>
			      			<div class="group_right">
			      				<input type="password" class="form-control _acc" id="key" name="useracc.password"/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
				    </div>
			      </div>
			      <div class="modal-footer">	        
			      	<button type="button" style="display:none" id="save_account" class="btn btn-primary modal_btn">real_save_account</button>
			        <button type="submit" class="btn btn-primary modal_btn">保存</button>
			        <button type="button" id="cancel_save_account" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>
			      </div>
	     	 </form>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		
	<!--addModal-->
	<div class="modal fade" id="user_add_modal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">添加用户信息</h4>
		      </div>
		      <form name="form1" id="form1" action="">
			      <div class="modal-body">
			        <div class="register_modal_body">
			      		<div class="input_info_group">
			      			<div class="group_left">部门名称</div>
			      			<div class="group_right">
			      				<input type="text" id="dap_add_name" class="form-control" readonly="readonly" value=""/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">部门编号</div>
			      			<div class="group_right">
			      				<input type="text" id="dap_add_id" class="form-control" readonly="readonly" value=""/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>				      		
			      		<div class="input_info_group">
			      			<div class="group_left">姓名</div>
			      			<div class="group_right">
			      				<input type="text" id="user_name" class="form-control" placeholder="请输入您的姓名..." name="user_name" /> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
<!-- 			      		<div class="input_info_group">
			      			<div class="group_left">用户编号</div>
			      			<div class="group_right">
			      				<input type="text" id="user_id" class="form-control"/>
			      			</div>
			      		</div> -->
			      		<div class="input_info_group">
			      			<div class="group_left">性别</div>
			      			<div class="group_right">
			      				<input type="radio" class="user_sex" name="user_sex" checked="checked" value="男"/>
			      				<label class="sex_label">男</label>
			      				<input type="radio" class="user_sex" name="user_sex" value="女"/>
			      				<label class="sex_label">女</label>
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">职务</div>
			      			<div class="group_right">
			      				<input type="text" id="user_duty" class="form-control" name="user_duty" />
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">电话</div>
			      			<div class="group_right">
			      				<input type="text" id="user_telephone" class="form-control" name="user_telephone" /> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
		      		</div>
			      </div>
			      <div class="modal-footer">
			      	<input type="reset" id="btn_add_reset" style="display:none;" />
			      	<button type="button" style="display:none" class="submitToDB">submit</button>
			      	<button type="submit" id="user_add_save" class="btn btn-primary modal_btn">保存</button>
			        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>		        
			      </div>
		      </form>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

	<!--重置密码-->
	<div class="modal fade" id="user_reset_pasw" style="margin-top: 100px;">
	  <div class="modal-dialog">
	    <div class="modal-content">
	       <div class="modal-body">
	        <div class="register_modal_body">
	      		<div class="input_info_group">
	      			<div class="group_left">新密码</div>
	      			<div class="group_right">
	      				<input type="password" class="form-control" id="rePass" /> 
	      			</div>
	      			<div class="clear"></div>
	      		</div>
		    </div>
	      </div>
	      <div class="modal-footer">	        
	        <button type="button" class="btn btn-primary modal_btn savePass">保存</button>
	        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!--修改用户信息modal-->
	<div class="modal fade" id="user_fix_modal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">修改用户信息</h4>
		      </div>
		      <form action="" id="updateUserInfo" method="post">
			      <div class="modal-body">
			        <div class="register_modal_body">
			      		<div class="input_info_group">
			      			<div class="group_left">部门名称</div>
			      			<div class="group_right">
			      				<input type="text" id="u_unitName" class="form-control" readonly="readonly" value=""/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">部门编号</div>
			      			<div class="group_right">
			      				<input type="text" id="u_unitId" class="form-control" readonly="readonly" value=""/> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>				      		
			      		<div class="input_info_group">
			      			<div class="group_left">姓名</div>
			      			<div class="group_right">
			      				<input type="text" id="u_name" class="form-control" name="u_name" /> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">用户编号</div>
			      			<div class="group_right">
			      				<input type="text" id="u_id" class="form-control" readonly="readonly" />
			      			</div>
			      		</div>			      		
			      		<div class="input_info_group">
			      			<div class="group_left">性别</div>
			      			<div class="group_right">
			      				<input type="radio" class="u_sex" name="u_sex" value="男"/>
			      				<label class="sex_label">男</label>
			      				<input type="radio" class="u_sex" name="u_sex" value="女"/>
			      				<label class="sex_label">女</label>
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">职务</div>
			      			<div class="group_right">
			      				<input type="text" id="u_duty" class="form-control" name="u_duty" />
			      			</div>
			      			<div class="clear"></div>
			      		</div>
			      		<div class="input_info_group">
			      			<div class="group_left">电话</div>
			      			<div class="group_right">
			      				<input type="text" id="u_telephone" class="form-control" name="u_telephone" /> 
			      			</div>
			      			<div class="clear"></div>
			      		</div>
		      		</div>
			      </div>
			      <div class="modal-footer">
			      	<input type="reset" id="btn_update_reset" style="display:none;" />
			      	<button type="button" style="display:none" class="updateUserInfoToDB">123</button>
			      	<button type="submit" class="btn btn-primary modal_btn btn_update_userInfo">保存</button>
			        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>		        
			      </div>
		      </form>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	
	<!--用户角色修改-->
	<div class="modal fade" id="user_roles_manage">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header word_center my_modal_title">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">用户管理</h4>
	      </div>
	      <div class="modal-body">
	       		<div class="roles_choose">
	       			<div>
	       				<label class="roles_choose_tip">角色</label>
	       			</div>
		  	       	<div style="margin-top:10px">
		   				<button class="allchecked">全选</button>
		   				<button class="nochecked">反选</button>
			       	</div>  	       			
      				<form name="form_role" id="form_role" action=""></form>
	       		</div>
		  </div>
	      <div class="modal-footer">    
	        <button type="button" id="save_role_to_user" class="btn btn-primary modal_btn">保存</button>
	        <button type="button" id="cancel_save_role" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	
	<!--------------------------------------------------------------------------------------->
	<!-- 这是新加入的部门管理模块 上面的改善版 -->
	<!--------------------------------------------------------------------------------------->
	<script>
	//check form

	var isAdd = false;		//全局变量，用于判断当前的操作是添加还是修改
	var isChange = false;	//全局变量，用于判断当前的操作是添加还是修改
	var alterRow;			//正在修改的表中的那一行的Id
	var userIdForRole;		//正在分配权限的用户的编号
	/**
	 * 单条删除用户
	 */
	function del_tr(id){
		
		var tr = document.getElementById("tr_"+id); //得到触发删除按钮的那一行
		
	    var userIds = tr.cells[2].innerHTML+",";	//得到要删除的用户的编号
	    
	    console.log("del_tr/>userIds: " + userIds);
	    //删除用户
	   	$.ajax({
	   		type : "post",
	   		dataType : "json",
	   		url : "<%=basePath%>deleteUserById.action",
			data : {
				deleteIds : userIds,
			},
			success : function() {
				alert("删除成功");
				tr.parentNode.removeChild(tr);	//数据库删除了的话，表格中将同步删除
				alterNoOfTable();				//修改删除之后的表的序号
			},
			error : function() {
				alert("删除失败");
			}
		});
	}
	
	/**
	 *修改用户数据
	 */
	function alt_tr(id) {
	
		isAdd = false;		
		isChange = true;		//设置当前的操作是修改
		alterRow = "tr_" + id;	//修改的那一行的id
		var tr = document.getElementById(alterRow);
		setChangInfoModal(tr);	//显示要修改的用户的原始信息
	}
	/**
	 * 显示要修改的用户的原始信息
	 */
	function setChangInfoModal(tr) {
		//填充上级级用户的值 （即当前点击的树节点,对于添加而言）
		//表从0开始
		//document.getElementById("user_telephone").readOnly=true;   //电话信息不能修改
		$("#u_unitId").val(tr.cells[4].innerHTML);
		$("#u_unitName").val(tr.cells[6].innerHTML);
		//设置性别
		if (tr.cells[5].innerHTML == "男") {
			$("input[name='u_sex']:first").attr("checked", true);
		} else {
			$("input[name='u_sex']:last").attr("checked", true);//女
		}
		//填充用户的信息
		$("#u_id").val($(tr).find("td:eq(2)").text());
		$("#u_name").val(tr.cells[3].innerHTML);
		$("#u_duty").val(tr.cells[7].innerHTML);
		$("#u_telephone").val(tr.cells[8].innerHTML);
	}
	
	/**
	 *删除对应的行后，修改表的序号
	 */
	function alterNoOfTable() {
		var len = $("#userTable tr").length;
		for (var i = 0; i < len; i++) {
			$("#userTable tr:eq(" + i + ") td:eq(1)").html((i + 1));
		}
	}
	
	/**
	 *角色管理
	 */
	function role_tr(id) {
		alterRow = "tr_" + id;	  //点击角色管理的那一行的id
		$("#selectedRow").val(alterRow);
		$("#form_role").html("<input type='hidden' value='' id='user_id_for_role'>");//用于保存用户的id
		var tr = document.getElementById("tr_" + id);
		var userId = tr.cells[2].innerHTML;     //得到用户的id
		$("#user_id_for_role").val(userId);     //保存用户的id
		userIdForRole = userId;
		console.log("userIdForRole: " + userIdForRole);
		
		getAllInUseRolesByUserId(userIdForRole);
	}
	
	
	function getAllInUseRolesByUserId(userId) {
		$.post("findRoleSetAction.action", {
			"userId" : userId
		}, function(result) {
			var roles = result.roles;
			if(roles != null) {
				var size = roles.length;
				for (var i = 0; i < size; i++) {
					if(roles[i].own) {
						$("#form_role").append("<div class='roleWrap'><input type='checkbox' name='role' class='roles' checked='checked' value='" + roles[i].roleId + "'/><label class='roleName'>" + roles[i].roleName + "</label></div>");
					} else {
						$("#form_role").append("<div class='roleWrap'><input type='checkbox' name='role' class='roles' value='" + roles[i].roleId + "'/><label class='roleName'>" + roles[i].roleName + "</label></div>");
					}
				}
			}
		});
	}
	
	/**
	 *保存用户分配到的角色（前提是先删除原来的）
	 */
	$("#save_role_to_user").click(function() {
		var userId = $("#user_id_for_role").val(); //获得用户id
		var roleIds = "";
		var roleNames = "";
		$("#form_role input:checked").each(function() {
			//得到分配给用户的角色的id
			roleIds += $(this).val() + ",";
			roleNames += $(this).parent(".roleWrap").find(".roleName").text() + " & ";
		});
		roleIds = roleIds.substring(0, roleIds.length - 1);  //去掉最后一个逗号
		roleNames = roleNames.substring(0, roleNames.length - 3);
		
		console.log("userId: " + userId + " , roleIds: " + roleIds);
		
		saveUserRoles(userId, roleIds, roleNames);
	});
	
	function saveUserRoles(userId, roleIds, roleNames) {
		$.ajax({
			url : "saveUserRoleAction.action",
			type: "post",
			data: {
				"userId" : userId,
				"roleIds" : roleIds
			},
			dataType: "text",
			success: function(result) {
				console.log("Saving user role is ok!");
				
				if(result) {
					alert("保存成功!");	
					$("#user_roles_manage").modal("hide");
					var _tr = document.getElementById($("#selectedRow").val());
					_tr.cells[9].innerHTML = roleNames;
				} else {
					alert("服务内部错误，保存失败!");
				}
			},
			error: function() {
				console.log("Saving user role is error!");
			}
		});
	}
	
	function del_account(index){
		var u_Id = $("#tr_" + index).find("td:eq(2)").text();
		isExist(u_Id);
		
	}
	
	function isExist(u_id){
		$.ajax({
			url : "selectAccountById.action",
			type : "post",
			data : {
				"u_id" : u_id,
			},
			dataType : "json",
			success : function(result){
				if(result.exist){
					d_account(u_id);
				}else{
					alert("账户不存在");
				}
			}
		});
		
	}
		
	function d_account(u_Id){
		if(confirm("确定删除当前账户吗？")) {
			$.ajax({
				url : "deleteAccount.action",
				type : "post",
				data : {
					"u_id" : u_Id,
				},
				dataType : "json",
				success : function(result){
					if(result.del){
						alert("删除成功！");
					}else{
						alert("删除失败！")
					}
				}
			
			});
		}
	}
	
	</script>	
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
</body>
</html>
