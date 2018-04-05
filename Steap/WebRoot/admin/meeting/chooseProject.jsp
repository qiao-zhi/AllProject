<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>   
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
	<base href="<%=basePath%>">
	<title>创建会议</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<!-- <link rel="stylesheet" href="css/public/register_search_bar.css" /> -->
	<link rel="stylesheet" href="css/role1/modal.css" />
	<link rel="stylesheet" href="css/role1/createCommit.css" />
	<script src="js/meeting/chooseProject.js"></script>
	<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
	<script type="text/javascript" src="js/public/jquery.validate.js"></script>

   <script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
	<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
	<link rel="stylesheet" href="controls/myPage/msgbox.css" />
	<link rel="stylesheet" href="controls/myPage/page.css" />
	<link rel="stylesheet" href="controls/myPage/pageStyle.css" />
	
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
		  <li class="active">创建会议</li>
		</ol>	
	</div>
		<div class="search_bar">
		<!-- <form action="searchProjectInfo2.action" method="post"> -->
		    <div class="input-group search_bar_input width floatL">
				<span class="input-group-addon" id="sizing-addon3">项目名称</span>
		  		<input name="projectCondition.projectName" type="text" class="form-control" placeholder="项目名称" aria-describedby="sizing-addon3">
	  		</div>
	  		<div class="input-group search_bar_input width floatL"> 
				<span class="input-group-addon" id="sizing-addon3">申请单位</span>
		  		<input name="projectCondition.applicant" type="text" class="form-control" placeholder="申请单位" aria-describedby="sizing-addon3">
	  		</div>
	  		<div class="input-group search_bar_input width floatL">
				<span class="input-group-addon" id="sizing-addon3">所属领域</span>
				<!-- <input name="projectCondition.domain" type="text" class="form-control" placeholder="所属领域" aria-describedby="sizing-addon3"> -->
				<select class="form-control" id=Domain"  name="projectCondition.domain" >
					<option >不限</option>
				<c:forEach var="domain" varStatus="status" items="${domainList}">
				
				 	<option >${domain}</option>
					
				
				</c:forEach>
				</select>
				
	  		</div>
	  		<div class="input-group search_bar_input floatL">
				<span class="input-group-addon" id="sizing-addon3">项目经费</span>
				<select class="form-control"  name="projectCondition.projectFunds"  >
					<option value="">全部</option>
					<option value="2">小于50万</option>
					<option value="1">大于50万(包括50万)</option>
				</select>
	  		</div>
	  		 <button id="searchProject" type="submit" class="btn  btn-primary search_bar_button floatR">
	  			查询&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
			</button>
			
			
			<div class="clear"></div>
			<!-- </form> -->
		</div>
		<div class="outside_box table_box">
			<div class="btn_box" >
			<!-- btn btn-default floatL -->
				<button class="btn btn-primary floatL" id="create2"  style="margin-bottom: 5px;">创建验收会议</button>
				<button id="export" class="btn btn-primary floatR">导出</button>
		 	</div>
			<table id="huiyiTab" class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>选择</th>
							<th>序号</th>
							<th>项目名称</th>
							<th>项目编号</th>
							<th>申请验收单位</th>
							<th>所属领域</th>
							<th>登记日期</th>
							<th>经费(万元)</th>
							<th>考察日期</th>
							<th>项目状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="word_center">
						 <c:forEach var="projectInfo" varStatus="status"
					items="${projectInfoResultList}">
					<tr>
						
						<td><input type="checkbox"
							value="${projectInfo.projectId},${projectInfo.projectName},${projectInfo.applicant},${projectInfo.domain},${projectInfo.projectFunds}"
							name="chooseBox" /></td>
						<td><c:out value="${status.index+1}"></c:out> </td>
						<td>${projectInfo.projectName}</td>
						<td>${projectInfo.projectId}</td>
						<td>${projectInfo.applicant}</td>
						<td>${projectInfo.domain}</td>
						<td>${projectInfo.recordDate}</td>
						<td>${projectInfo.projectFunds}</td>
						<td>${projectInfo.inspectDate}</td>
					    <td title="已现场考察">已考察</td>
						
					<td><a href="LookProjectInfo.action?projectId=${projectInfo.projectId}" class="operation_icon" data-toggle="tooltip" data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a></td>
					
					</tr>
				</c:forEach>
					</tbody>
			</table>
			
			<nav class="word_center">
	
	<input type="hidden" value="${totalPage }"  id="totalPage"/>
	<input type="hidden" value="${currentPages }" id="currentPages"/>
	<input id="submitSearch" type="hidden"/>	
	
		<div id="demo1">
	</nav>
		</div>	
	<!-- </div> -->
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	
	<form id="meeting_form" method="post">
	<!-- 模态框 会议录入-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
	   	 <div class="modal-content">
		      <div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">项目验收会议信息录入</h4>
		      </div>
		      <div class="modal-body">
		      		 <div id="projects">
		      			<div class="strong">
						<label for="">项目信息</label>
						</div>
		      			<table id="mytable"  class="table table-bordered table-hover">
		      				<thead>
								<tr>
									<th>序号</th>
									<th>项目名称</th>
									<th>申请验收单位</th>
									<th>所属领域</th>
									<th>经费</th>
									<th>操作</th>
								</tr>
		      				</thead>
		      				<tbody class="word_center">
							
		      				</tbody>
		      			</table>
		      		</div> 
		      		<div class="hr"></div>
		      		
		      		
		      		
		      		<div class="putIn">
		      			<div class="strong">
						<label for="">会议信息</label>
						</div>
		      			<div class="put_in_group"> 
		      			<div class="input_info_group">
								<div class="group_left">会议主持人</div>
								<div class="group_right" style="min-height:72px;" >
								<!--class="group_right" <input type="text" class="form-control" name="meeting.hostId"> -->
								<select class="form-control"  name="meeting.hostId2" id="unitSele" style="margin-bottom:2px;" >
											<option>请选择部门</option>		
								</select>
								
								<select class="form-control"  name="meeting.hostId" id="userSele" >
										<option>请选择主持人</option>		
								</select>
								</div>
								<div class="clear"></div>
							</div>
		      			<div class="input_info_group">
		      				<div class="group_left " >会议时间</div>
		      				<div class="group_right ">
		      					<!-- <input type="text" class="form-control" name="meeting.meetingTime"/> -->
		      				  <input name="meeting.meetingTime" class="datainp form-control" id="dateinfo" type="text" placeholder="请选择"  readonly/>
		      				</div>
		      				<div class="clear"></div>
				  		</div>
				  		<div class="input_info_group"> 
		      				<div class="group_left">会议地点</div>
		      				<div class="group_right">
		      					<input type="text" class="form-control"  name="meeting.meetingPlace"/>
		      				</div>
		      				<div class="clear"></div>
				  		</div>
				  		<div class="input_info_group"> 
		      				<div class="group_left">会议名称</div>
		      				<div class="group_right">
		      					<input type="text" class="form-control" name="meeting.meetingName"/>
		      				</div>
		      				<div class="clear"></div>
				  		</div>
				  		<!-- <div class="input_info_group"> 
		      				<div class="group_left outer">会议主持人</div>
		      				<div class="group_right inner">
		      					<input type="text" class="form-control" name="meeting.hostId">
		      				</div>
		      				<div class="clear"></div> -->
				  		<!-- </div> -->
				  		<div class="input_info_group">
							<div class="group_left">会议备注</div>
							<div class="group_right_textarea">
								<textarea  name="meeting.remark" placeholder="可选填"></textarea>
							</div>
							<div class="clear"></div>
				  		</div>
		      		</div>		      			      		
		      <div class="modal-footer">
		      	<button type="submit" class="btn btn-primary modal_btn"  class="saveHuiYi" id="save">保存</button>
		        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>		        
		      </div>
	    </div>
 	</div>
       </div>
   </div>
   
   
   </form>
   
   <script type="text/javascript">  
        jeDate({
		dateCell:"#dateinfo",
		isinitVal:true,
		isTime:true, //isClear:false,
		/* minDate:"2014-09-19 00:00:00" */
		})
		$(function(){
			$("#meeting_form").validate({
			
                rules: { 
                	'meeting.hostId':{required: true,}, // 
                	'meeting.meetingPlace':{required:true,},
                	'meeting.meetingName':{required:true,},
                },
                messages: {
                    'meeting.hostId':{required: '不能为空' ,}, //
                    'meeting.meetingPlace':{required:'不能为空',},
                    'meeting.meetingName':{required:'不能为空',},
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
