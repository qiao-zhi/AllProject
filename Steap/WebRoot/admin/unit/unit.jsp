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
		<title>department_manage</title>
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/public/main2.css" />
		<!-- <link rel="stylesheet" href="css/public/register_search_bar.css" /> -->
		<link rel="stylesheet" href="css/register/register.css" />
		<link rel="stylesheet" href="css/department_manage/department_manage.css" />
		<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
		
		<link rel="stylesheet" type="text/css" media="screen" href="css/zTreeStyle/zTreeStyle.css" />
		<script type="text/javascript" src="js/unit/unit.js"></script>
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
			  	<li class="active">部门管理</li>		  	
			</ol>				
		</div>
		<div>
		
			<div class="user_left_tree_info">
				<div class="user_left_tree_info_title">部门</div>
				<div class="hr"></div>
				<div class="ztree" id="treeDemo"></div>
			</div>
			
			<div class="floatL" style="width: 80%;">				
				<div class="search_bar">
					<div class="input-group search_bar_input floatL">
					  	<span class="input-group-addon">部门名称</span>
					  	<input type="text" class="form-control" id="unit_name" placeholder="" >
					</div>
					<div class="input-group search_bar_input floatL">
					  	<span class="input-group-addon">部门编号</span>
					  	<input type="text" class="form-control" id="unit_id" placeholder="" aria-describedby>
					</div>						
					<button class="btn btn-primary search_bar_button floatR" id="condition_sub">查询<span class=" glyphicon glyphicon-search span_icon"></span></button>
					
					<div class="clear"></div>
				</div>
					
				<div class="table_box outside_box">
						
					<div class="box_title word_center header_show" ><h3>部门管理</h3></div>
					<div class="hr"></div>
						
					
					<div class="btn_box">			
						<div>
							<!-- <button class="btn btn-primary floatL" id="">导出 <span class=" glyphicon glyphicon-print span_icon"></span>
							</button> -->
							<button class="btn btn-primary floatR modal_btn " id="unit_delete">删 除</button>											
							<button class="btn btn-primary floatR modal_btn " id="unit_change"  data-toggle="modal" 
							data-target="#department_fix_modal">修改</button>
							
							<input type="hidden" value="" id="bt_unitId"> 
							<input type="hidden" value="" id="bt_unitName">
							<input type="hidden" value="" id="bt_upUnitId"> 
							<input type="hidden" value="" id="bt_upUnitName">
							<input type="hidden" value="" id="table_row">	
							
							<button class="btn btn-primary floatR modal_btn " id="unit_add"  data-toggle="modal" 
							data-target="#add_modal">添加</button>
						</div>
						<div class="clear"></div>
					</div>
					
					<div>
						<table class="table table-bordered  table-hover" id="unitTable">
							<thead>
								<tr>
									<th>序号</th>
									<th>部门编号</th>
									<th>部门名称</th>
									<th>上级部门编号</th>
									<th>描述</th>
								</tr>
							</thead>
							<!-- <tbody>
								<tr>	
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<a href=".bs-example-modal-lg" data-toggle="modal" class="operation_icon" data-toggle="tooltip" data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a>									
										<a href="#department_fix_modal" data-toggle="modal" class="operation_icon" id="unit_change" data-toggle="tooltip" 
										data-placement="bottom"  title="编辑" data-target="#department_fix_modal">
										<i class="glyphicon glyphicon-pencil"></i></a>
										
										<a href="###" class="operation_icon" data-toggle="tooltip" 
										data-placement="bottom" title="删除" id="unit_delete">
										<i class="glyphicon glyphicon-trash"></i></a>
									</td>
								</tr>
							</tbody> -->
						</table>														
						
						<nav class="word_center">
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
						</nav>																									
					</div>
			
				<div class="clear"></div>
				</div>
			</div>
		</div>
		
		</div>
		<div class="clear"></div>
		</div>
		
		<!--部门管理-->
		<!--添加-->
		<div class="modal fade" aria-hidden="true" data-backdrop="static" id="add_modal">
		  	<div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" >添加部门</h4>
			      	</div>
			      	<div class="modal-body">
			      		<div class="register_modal_body">
				      		<div class="input_info_group">
				      			<div class="group_left">上级部门名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="tdap_add_name" readonly="readonly"/></div>
				      			<div class="clear"></div>
				      		</div>
				      		
				      		<!-- <tr>
								<td>上级部门名称</td>
								<td style="text-align:center disabled"><span id="tdap_add_name"></span></td>
							</tr> -->
				      		
				      		<div class="input_info_group">
				      			<div class="group_left">上级部门编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="tdap_add_id" readonly="readonly"/></div>
				      			<div class="clear"></div>
				      		</div>	
							
				      		<div class="input_info_group hidden">
				      			<div class="group_left">部门编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="unit__id" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">部门名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="unit__name" /> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">描述</div>
				      			<div class="group_right"><input type="text" class="form-control" id="unit_description" /> </div>
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
		<div class="modal fade" aria-hidden="true" data-backdrop="static" id="department_fix_modal">
		  	<div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" >修改部门</h4>
			      	</div>
			      	<div class="modal-body">
			      		<div class="register_modal_body">
				      		<div class="input_info_group">
				      			<div class="group_left">上级部门名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="xdap_add_name" readonly="readonly" value=""/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">上级部门编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="xdap_add_id" readonly="readonly" value=""/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group hidden">
				      			<div class="group_left">部门编号</div>
				      			<div class="group_right"><input type="text" class="form-control" id="unit___id" value=""/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">部门名称</div>
				      			<div class="group_right"><input type="text" class="form-control" id="unit___name" value=""/> </div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">描述</div>
				      			<div class="group_right"><input type="text" class="form-control" id="unit__description" value=""/> </div>
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