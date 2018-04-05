<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath %>">
	<title>通知人员</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/modal.css" />
	<link rel="stylesheet" href="css/role1/informPerson.css" />
	<link rel="stylesheet" href="css/role2/qiye.css" />
	<script type="text/javascript" src="js/public/jquery.validate.js"></script>
    <script src="js/meeting/institutionNotify.js"></script>
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
		  <li class="active">验收会前准备</li>
		   <li><a href="toMeetingManagePage.action">验收会议管理</a></li>
		  <li class="active">通知相关人员</a></li>
		</ol>	
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">会议信息</label>
		</div>
		<div class="hang">
			<div class="block">
			<input type="hidden" value="${meeting.meetingId}" id="metId"/>
				<label class="label_left none_border_radius ">会议时间</label>
				<label class="label_right none_border_radius">${meeting.meetingTime}</label>
				<div class="clear"></div>
			</div>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">会议地点</label>
				<label class="label_right none_border_radius pub_border_none">${meeting.meetingPlace}</label>
				<div class="clear"></div>
			</div>
		</div>
		<%-- <div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">会议备注</label>
				<label class="label_right none_border_radius pub_border_none">${meeting.remark}</label>
				<div class="clear"></div>
			</div>
		</div> --%>
		<div class="clear"></div>
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label>通知信息</label>
		</div>
		
		<div style="margin: 10px 20px;">
				<button class="btn btn-default floatR modal_btn" data-toggle="modal" data-target="#inform" id="add" style="margin-right:129px; margin-left: 10px;">添加</button>
					<button id="bc" class="btn btn-primary save floatR modal_btn">保存</button>
				<div class="clear"></div>
			</div>			
		<!-- <button class="btn btn-default floatR" data-toggle="modal" data-target="#inform" id="add">添加</button>
		<div class="clear"></div> -->
		<table id="person"   class="table table-bordered table-hover mytable">
			<thead>
				<tr>
					<th>序号</th>
					<th>部门</th>
					<th>通知人</th>
					<th>联系人</th>
					<th>通知日期</th>
					<th>通知方式</th>
					<th>通知结果</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="word_center">
				<form id="myform">
			 <c:forEach var="institutionNotify" varStatus="status"
					items="${institutionNotifyList}">
					<tr>
						<td id="biaoHao"><c:out value="${status.index+1}" />
						<%-- <input type="hidden" name="info" value="${institutionNotify.notifyId},
						${institutionNotify.institutionName},${institutionNotify.notifier},
							${institutionNotify.contactPerson}, 
							${institutionNotify.notifyDate},
							${institutionNotify.notifyMethod},
							${institutionNotify.notifyResult}
						
						"/> --%>
						
						</td>
						
						<td class="hidden"><input name="deleteNotifyId" value="${institutionNotify.notifyId}">${institutionNotify.notifyId}</td>
						
						<td name="institutionName">${institutionNotify.institutionName}
						</td>
						<td name="notifier">${institutionNotify.notifier}
						</td>
						<td name="contactPerson">
						${institutionNotify.contactPerson}
						</td>
						<td name="notifyDate">
							 ${institutionNotify.notifyDate}
						</td>
						<td name="notifyMethod">${institutionNotify.notifyMethod}
						</td>
						<td name="notifyResult">${institutionNotify.notifyResult}</td>
						<!-- <td>
						
						<a href="javaScript:void(0)" class="seeNotice" class="operation_icon" data-toggle="modal" data-target="#chakan" data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a>
						</td> -->
						<td><a href="javaScript:void(0)" class="deleteNotifydata" title="删除该条记录"><i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
				</c:forEach>
					
				</form>
			</tbody>
		</table>
		
		
		<!-- <div class="commit">
		
		
			<button id="bc" class="btn btn-default save floatR">保存</button>
		</div>
		
		<div class="clear"></div> -->
	</div>
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	
<!-- 添加通知 -->
<form method="post" id="addInform">
<div class="modal" id="inform" tabindex="0" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
    	<div class="modal-content">
     		<div class="modal-header word_center my_modal_title">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="myModalLabel">通知相关人员信息录入</h4>
      		</div>
     		<div class="modal-body">
    			<!-- <div class="outside_box table_box"> -->
					<!-- <div class="strong">
						<label for="">会议信息</label>
					</div> -->
					<%-- <div class="inform_info">
						<div class="show_info_group pub_info_show_top_border">
							<label class="group_left none_border_radius">会议时间</label>
							<label class="group_right none_border_radius">${meeting.meetingTime }</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="inform_info">
						<div class="show_info_group ">
							<label class="group_left none_border_radius pub_border_none">会议地点</label>
							<label class="group_right none_border_radius pub_border_none">${meeting.meetingPlace }</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="inform_info">
						<div class="show_info_group">
							<label class="group_left none_border_radius pub_border_none">会议备注</label>
							<label class="group_right none_border_radius pub_border_none">${meeting.remark }</label>
							<div class="clear"></div>
						</div>
					</div> --%>
					
					<div class="clear"></div>
				<!-- </div> -->
				<!-- <div class="strong" style="margin-top: 8px;">
		      		<label>项目信息</label>
		      	</div> -->
				 	<div class="inform_info" style="margin: 20px auto;">
				 	
				 	<div class="input_info_group"> 
			      				<div class="group_left">通知人</div>
			      				<div class="group_right" style="min-height:72px;">
			      				<!-- class="group_right"	<input type="text" id="notifier" name="notifier" class="form-control"> -->
			      			    <select class="form-control"   id="unitSele" style="margin-bottom:2px;">
											  <option>请选择部门</option>
								</select>
								
								<select class="form-control"  name="notifier" id="userSele" >
										<option value="a">请选择通知人</option>		
								</select>
			      				</div>
			      				<div class="clear"></div>
					  		</div>
				 	<div class="input_info_group" style="margin-bottom: 10px;" > 
			      				<div class="group_left  ">通知时间</div>
			      				<div class="group_right ">
			      				<input class="datainp form-control" id="calendar_no_name" type="text" placeholder="请选择"  readonly/>							
			      					<!-- <input type="text" id="time" class="form-control"> -->
			      				</div>
			      				<div class="clear"></div>
					  		</div>
			      			<div class="input_info_group"> 
			      				<div class="group_left">部门名称</div>
			      				<div class="group_right">
			      					<input type="text" id="mingcheng" name="mingcheng" class="form-control" list="mingchengSelect"/>
										<datalist id="mingchengSelect">
										<c:forEach var="institution" varStatus="status" items="${institution}">
									     <option value="${institution }">										
										</c:forEach>
										</datalist>
			      				</div>
			      				<div class="clear"></div>
					  		</div>
					  	<!-- 	<datalist id="data">
					  			<option>
					  			<option>
					  		</datalist> -->
					  		
					  		<div class="input_info_group"> 
			      				<div class="group_left ">联系人</div>
			      				<div class="group_right">
			      					<input type="text" id="conectPerson" name="conectPerson" class="form-control"/>
			      				</div>
			      				<div class="clear"></div>
					  		</div>
					  		
					  		<div class="input_info_group"> 
			      				<div class="group_left ">通知结果</div>
			      				<div class="group_right">
			      					<input type="text" id="result" name="notifyResult" class="form-control"/>
			      				</div>
			      				<div class="clear"></div>
					  		</div>
					  		
					  		<div class="input_info_group"> 
			      				<div class="group_left ">通知方式</div>
			      				<div class="group_right" >
			      				<!-- name="method" -->
			      					<input  class="danxuan" type="checkbox"  name="tongxin" value="电话" checked/><span>电话</span>
			      					<input  class="danxuan" type="checkbox" name="tongxin" value="email"/><span>email</span>
			      					<input  class="danxuan" type="checkbox" name="tongxin" value="QQ"/><span>qq</span>
			      					<input  class="danxuan" type="checkbox" name="tongxin" value="微信"/><span>微信</span>
			      					<input  class="danxuan" type="checkbox" name="tongxin" value="短信"/><span>短信</span>
			      				</div>
			      				<div class="clear"></div>
					  		</div>
		      		</div> 	
    		</div>
      		<div class="modal-footer">
      		<!-- id="saveNotice" id="saveNoticeToFace"-->
		       
		     <button type="submit" class="btn btn-primary modal_btn" data-dismiss="modal" id="saveNoticeToFace">保存</button>
      		 <button id="cancel" type="button" class="btn btn-default modal_btn"  data-dismiss="modal">取消</button>
      		</div>
   		</div>
  	</div>
</div>
<form>
<!-- 查看人员 -->
 <div class="modal" id="chakan" tabindex="0" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
    	<div class="modal-content">
     		<div class="modal-header word_center my_modal_title">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="myModalLabel">通知相关人员信息录入</h4>
      		</div>
     		<div class="modal-body">
     			<div class="commits">
     				<h4>会议信息</h4>
 					<div class="inform_info">
						<div class="show_info_group pub_info_show_top_border">
							<label class="group_left none_border_radius">会议时间</label>
							<label class="group_right none_border_radius">${meeting.meetingTime }</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="inform_info">
						<div class="show_info_group ">
							<label class="group_left none_border_radius pub_border_none">会议地点</label>
							<label class="group_right none_border_radius pub_border_none">${meeting.meetingPlace }</label>
							<div class="clear"></div>
						</div>
					</div>
					<%-- <div class="inform_info">
						<div class="show_info_group">
							<label class="group_left none_border_radius pub_border_none">会议备注</label>
							<label class="group_right none_border_radius pub_border_none">${meeting.remark }</label>
							<div class="clear"></div>
						</div>
					</div> --%>
     			</div>
     			
     			
     			 <table id="oneNotice" class="table table-bordered table-hover"  style="margin-top:10px">
     		    <thead>
				   <tr>
				 	<th>部门名称</th>
					<th>通知人</th>
					<th>企业联系人</th>
					<th>通知时间</th>
					
					<th>通知方式</th>
					
				  </tr>
				
			   </thead>
			       <tbody></tbody>
     			
     			
     			</table>
     			
     			<!-- <div class="commits">
     				<div class="rows">
 						<span class="biaoti">部门名称</span><span class="neirong">研发部</span>
 					</div>
 					<div class="rows">
 						<span class="biaoti">通知人</span><span class="neirong">黄芳</span>
 					</div>
 					<div class="rows">
 						<span class="biaoti">通知时间</span><span class="neirong">2016-05-20</span>
 					</div>
 					<div class="rows">
 						<span class="biaoti">通知方式</span><span class="neirong">手机</span>
 					</div>
     			</div>		 -->		  	
    		</div>
      		<div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">返回</button>
      		</div>
   		</div>
  	</div>
</div> 
<script>
	jeDate({
			dateCell:"#calendar_no_name",//isinitVal:true,
			format:"YYYY-MM-DD",
			isTime:false, //isClear:false,
			/* minDate:"2014-09-19 00:00:00" */
		})
		$(function(){
			$("#addInform").validate({
			
                rules: { 
                	'mingcheng':{required: true,}, // 
                	'notifier':{required:true,},
                	'conectPerson':{required:true,},
                },
                messages: {
                    'mingcheng':{required: '不能为空' ,}, //
                    'notifier':{required:'不能为空',},
                    'conectPerson':{required:'不能为空',},
                },
                errorClass: "error",
                success: 'valid',
                unhighlight: function (element, errorClass, validClass) { //验证通过
                    $(element).tooltip('destroy').removeClass(errorClass);
                },
                errorPlacement: function (label, element) {
                    $(element).tooltip('destroy'); /*必需*/
                    $(element).attr('title', $(label).text()).attr("data-placement","bottom").tooltip('show');                  
                },
                submitHandler: function (form) {
                    
                }
        	})
		})
	
</script>
</body>
</html>
