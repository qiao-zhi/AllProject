<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<title>menu_manage</title>
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/public/main2.css" />
		<!-- <link rel="stylesheet" href="css/public/register_search_bar.css" /> -->
		<link rel="stylesheet" href="css/register/register.css" />
		<link rel="stylesheet" href="css/department_manage/department_manage.css" />
		<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
		
		<link rel="stylesheet" type="text/css" media="screen" href="css/zTreeStyle/zTreeStyle.css" />
		<script type="text/javascript" src="js/module/module.js"></script>
		<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript" src="js/jquery.validate-1.13.1.js"></script>
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
				  	<li class="active">系统管理</li>
				  	<li class="active">菜单管理</li>
				</ol>				
			</div>
			
			<div>
				<div class="user_left_tree_info">
					<div class="user_left_tree_info_title">菜单</div>
					<div class="hr"></div>
					<div class="ztree" id="treeDemo"></div>
				</div>
				<div class="floatL" style="width: 80%;">
					<div class="search_bar">
						<div class="input-group search_bar_input floatL">
						  	<span class="input-group-addon">模块编号</span>
						  	<input type="text" class="form-control" id="module_id" placeholder="" >
						</div>
						<div class="input-group search_bar_input floatL">
						  	<span class="input-group-addon">模块名称</span>
						  	<input type="text" class="form-control" id="module_name" placeholder="" aria-describedby>
						</div>						
						<button class="btn btn-primary search_bar_button floatR" id="condition_sub">查询<span class=" glyphicon glyphicon-search span_icon"></span></button>
						
						<div class="clear"></div>
					</div>	
					
					<div class="table_box outside_box">
						
						<div class="box_title word_center header_show" ><h3>菜单管理</h3></div>
						<div class="hr"></div>
						<div>
							
							
							<div class="btn_box">			
								<div>
									<!-- <button class="btn btn-primary floatL" id="">导出 <span class=" glyphicon glyphicon-print span_icon"></span></button> -->											
									<button class="btn btn-primary floatR modal_btn " id="module_delete">删除</button>	
									<button class="btn btn-primary floatR modal_btn " id="module_change" data-toggle="modal" data-target="#fix_menu_modal">修改</button>
									
									    <input type="hidden" value="" id="bt_moduleId"> 
										<input type="hidden" value="" id="bt_moduleName">
										<input type="hidden" value="" id="bt_upModuleId"> 
										<input type="hidden" value="" id="bt_upModuleName">
									
									<button class="btn btn-primary floatR modal_btn " id="module_add" data-toggle="modal" data-target="#add_menu_modal">添加</button>
									<input type="hidden" id="currentId">
									<input type="hidden" id="currentName">
									<input type="hidden" id="currentLine">
								</div>
								<div class="clear"></div>
							</div>
						
							<div>
								<table class="table table-bordered  table-hover" id="moduleTable">
									<thead>
										<tr>
											<th><input type="checkbox" name="allcheckbox" value="" /> </th>
											<th>序号</th>
											<th>模块编号</th>
											<th>模块名称</th>
											<th>模块URL</th>
											<th>memo1</th>
											<th class="hidden">memo2</th>
											<th>是否启用</th>
											<th class="hidden">sortNo</th>
											<th>模块类别</th>
											<th class="hidden">flag</th>
											<th>操作</th>									
										</tr>
									</thead>
								</table>														
								
								
								<%-- <nav class="word_center">
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
								</nav> --%>
							</div>													
							<div class="clear"></div>
						</div>
				</div>
				</div>
				<div class="clear"></div>
			</div>
		
		</div>
		<div class="clear"></div>
		</div>
		
		<!--菜单管理-->
		<!--添加  -->
		<div class="modal fade" id="add_menu_modal" aria-hidden="true" data-backdrop="static">
		  	<div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title">添加菜单</h4>
			      	</div>
			      	<div class="modal-body">
			      		<div class="register_modal_body">
				      		<div class="input_info_group">
				      			<div class="group_left">上级菜单名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="tdap_add_name" readonly="readonly"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">上级菜单编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="tdap_add_id" readonly="readonly"/> </div>
				      			<div class="clear"></div>
				      		</div>				      		
				      		<div class="input_info_group hidden">
				      			<div class="group_left">模块编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__id" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">模块名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__name" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">模块URL</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module_URL" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">memo1</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module_memo1" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">memo2</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module_memo2" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">是否启用</div>
				      			<div class="group_right">
				      				<input type="radio" name="menu_radio" checked="checked" value="true"/><span>启用</span>
				      				<input type="radio" name="menu_radio" value="false" style="margin-left: 20px;"/><span>禁用</span>
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">sortNo</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module_sortNo"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">菜单类别</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module_menuClass"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">flag</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module_flag"/> </div>
				      			<div class="clear"></div>
				      		</div>
			      		</div>
			      					        	
			      	</div>
			      	<div class="modal-footer ">
			     	 	<button type="button" class="btn btn-primary modal_btn" id="tdapartm_add_save">保存</button>
				        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>				        
			     	 </div>
			    </div><!-- /.modal-content -->
		  	</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	
		<!--修改-->
		<div class="modal fade"  aria-hidden="true" data-backdrop="static" id="fix_menu_modal">
		  	<div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title">修改部门</h4>
			      	</div>
			      	<div class="modal-body">
			      		<div class="register_modal_body">
				      		<div class="input_info_group">
				      			<div class="group_left">上级菜单名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="xdap_add_name" readonly="readonly" value="" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">上级菜单编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="xdap_add_id" readonly="readonly" value="" /> </div>
				      			<div class="clear"></div>
				      		</div>				      		
				      		<div class="input_info_group">
				      			<div class="group_left">模块编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module___id" readonly="readonly"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">模块名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module___name"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">模块URL</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__URL"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">memo1</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__memo1"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">memo2</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__memo2"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">是否启用</div>
				      			<div class="group_right">
				      				<input type="radio" class="inUse" name="menu_radio2" id="inUse" value="true"/><span>启用</span>
				      				<input type="radio" class="inUse" name="menu_radio2" id="unUse" value="false" style="margin-left: 20px;"/><span>禁用</span>
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">sortNo</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__sortNo"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">菜单类别</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__menuClass"/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">flag</div>
				      			<div class="group_right"><input type="text" class="form-control" id="module__flag"/> </div>
				      			<div class="clear"></div>
				      		</div>
			      		</div>
			      	</div>
			      	
			      	<div class="modal-footer ">
			     	 	<button type="button" class="btn btn-primary modal_btn" id="xdapartm_add_save">保存</button>
				        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>				        
			     	 </div>
			    </div><!-- /.modal-content -->
		  	</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		

		<script>
			jeDate({
				dateCell:"#calendar_register",//isinitVal:true,
				format:"YYYY-MM-DD",
				isTime:false, //isClear:false,
				/* minDate:"2014-09-19 00:00:00" */
			})
		</script>
		
		<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	</body>
	
</html>