<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<title>验收会议管理</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/modal.css" />
	<link rel="stylesheet" href="css/role1/createCommit.css" />
	<script src="js/meeting/meetingManage.js"></script>
	<script type="text/javascript" src="js/public/jquery.validate.js"></script>
	<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
	
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
		  <li class="active">验收会议管理</a></li>
		</ol>	
	</div>
	
	<form action="searchMeetingInfo.action" method="post">
		<div class="search_bar">
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">会议状态</span>
				  	<select class="form-control " name="meetingCondition.meetingStatus" id="meetingStatuSearch">
				  		<option>全部</option>
				  		<option>准备中</option>
				  		<option>召开中</option>
				  		<option>已完成</option>
				  	</select>		
				</div>
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">会议时间</span>
				  	<select class="form-control" name="meetingCondition.meetingTime" id="meetingTimeSearch">
				  	    <option>全部</option>
				  		<option value="30">近一个月</option>
				  		<option value="90">近三个月</option>
				  		<option value="365">近一年</option>
				  		<option value="1095">近三年</option>
				  		
				  	</select>		
				</div>
				<!-- <button class="btn btn-primary search_bar_button float_right">搜索&nbsp;&nbsp;<span class=" glyphicon glyphicon-search span_icon"></span></button> -->			
				<button  class="btn btn-primary search_bar_button floatR">查询&nbsp;&nbsp;<span class=" glyphicon glyphicon-search span_icon"></span></button>	
				<div class="clear">
				
				</div>
		</div>
		</form>
		<div class="outside_box table_box">
			<div class="btn_box">
				<button class="btn btn-primary floatL" id="create" >创建会议</button>
				<button class="btn btn-primary floatL" id="engineer">确定验收专家</button>
				<button class="btn btn-primary floatL" id="tongzhi" class="inform">通知相关人员</button>
				<button class="btn btn-primary floatL" id="write" class="meetingNotify">创建会议议程</button>
				<button id="export" class="btn btn-primary floatR" >导出</button>
				<div class="clear"></div>
		 	</div>
		 		<table id="commitTab" class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>全选</th>
							<th>会议名称</th>
							<th>会议时间</th>
							<th>会议地点</th>
							<th>会议状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="word_center">
						 <c:forEach var="meetingInfo" varStatus="status"
					items="${meetingInfoList}">
					<tr>
						<!-- <td><c:out value="${status.index+1}" /></td> -->
						
						<td><input type="radio" name="oneChoose" value="${meetingInfo.meetingId }">
					
						</td>
						<td>${meetingInfo.meetingName}<input type="hidden"value="${meetingInfo.meetingId }" name="meetingId2"/></td>
						<td>${meetingInfo.meetingTime}</td>
						<td>${meetingInfo.meetingPlace}<input name="meetingRemark" id="meetingRemark" type="hidden" value="${meetingInfo.remark }"/></td>
						<td>${meetingInfo.meetingStatus}</td>
						<td>
						
						<a href="lookMeetingInfo.action?meeting.meetingId=${meetingInfo.meetingId }
						&meeting.meetingName=${meetingInfo.meetingName}
						&meeting.meetingPlace=${meetingInfo.meetingPlace}"  class="operation_icon"   data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a>
						<a href="#myModal" name="updateMeetingInfo2" data-toggle="modal" class="notifyRe">
									<i class="glyphicon glyphicon-pencil"></i></a>
						</td> 
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
		
	
	
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<form id="update_meeting_info" method="post">
	<!-- 修改会议信息-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
	   	 <div class="modal-content">
		      <div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">修改会议信息</h4>
		      </div>
		      <div class="modal-body">
		      		<div class="putIn">
		      			<div class="strong">
						<label for="">会议信息</label>
						</div>
		      			<div class="put_in_group"> 
		      			<div id="meetingBox" class="input_info_group">
								<div class="group_left">会议主持人</div>
								<div class="group_right" style="min-height:72px">
								
								<select class="form-control"  name="meeting.hostId2" id="unitSele" style="margin-bottom:2px">
											<!--  <option>请选择部门</option> -->
								</select>
								
								
								<select class="form-control"  name="meeting.hostId" id="userSele" >
										<!-- <option value="a">请选择主持人</option>	 -->	
								</select>
								
								</div>
								<div class="clear"></div>
						</div>
						<div class="input_info_group">
								<div class="group_left">会议状态</div>
								<div class="group_right">
								<input id="select_id" class="datainp form-control" value="准备中" readonly="readonly"/>
									<!-- <select id="select_id" class="form-control" name="meeting.meetingStatus">
										<option value="200001">准备中</option>
										<option value="200002">召开中</option>
										<option value="200003">已完成</option>
									</select> -->
								</div>
								<div class="clear"></div>
						</div>
		      			<div class="input_info_group">
		      				<div class="group_left " >会议时间</div>
		      				<div class="group_right ">
		      					
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
				  	
				  		<div class="input_info_group">
							<div class="group_left">会议备注</div>
							<div class="group_right_textarea">
								<textarea  name="meeting.remark"></textarea>
							</div>
							<div class="clear"></div>
				  		</div>
		      		</div>		      			      		
		      <div class="modal-footer">
		      	<button type="submit" class="btn btn-primary modal_btn"   id="updateMeetingInfo">保存</button>
		        <button type="button" class="btn btn-primary modal_btn" data-dismiss="modal">取消</button>		        
		      </div>
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
			$("#update_meeting_info").validate({
			
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
