<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath %>">
		<title>专家意见修改审核</title>
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/public/main2.css" />
		<link rel="stylesheet" href="css/accepted/aduit_porject_data.css" />
		<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js" ></script>
		<script type="text/javascript" src="js/meeting/updateExpertOpinion.js"></script>
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
			  	<li class="active">验收后管理</li>	
			  	<li><a href="admin/meeting/ProjectSearch.jsp">审核完善资料</a></li>	
			  	<li class="active">审核完善资料录入</li>
			</ol>				
		</div>
		<div style="padding-left: 30px;padding-right: 30px;">
			<div class="outside_box table_box box_padding">
				<div class="span_tips">
					<span >资料完善说明</span>
				</div>
				<div>
				 <input type="hidden" name="projectVerify.verifyId" value="${verifyInfo['verifyId']}"/>
					<textarea readonly="readonly" class="aduit_textarea">针对专家提出的意见，进行了如下的修改：&#13;&#10;${verifyInfo["completeDescription"]}
					</textarea>										
				</div>
				<a class="btn btn-default floatR" style="margin-top:4px;display:block;" href="admin/meeting/evaluation_review.jsp?projectId=${projectId }">查看专家个人意见</a>
				<div class="clear"></div>
			</div>
			
			<div class="hr"></div>
			<%-- <a href="admin/host/evaluation_review.jsp?projectId=${projectId }">查看专家个人意见</a> --%>
			<div class="outside_box table_box box_padding">
				<div class="span_tips">
					<span >完善资料</span>
				</div>
				<table id="box" class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>文件名称</th>
							<th>上传日期</th>
							<th>大小</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<input type="hidden" name="projectId" value="${projectId }"/>
				<c:forEach var="material" varStatus="status"
					items="${materialList}">
					<tr>
					    <td><c:out value="${status.index+1}" /></td>	
                            <td><input type="hidden" name="fileId" value="${material.fileId }"/>${material.originalName }</td>
							<td>${material.uploadTime }</td>
							<td>${material.fileSize }</td>
							<td>
								<a href="${material.currentName }" target="_blank"  data-toggle="modal" class="operation_icon" data-toggle="tooltip" data-placement="bottom" title="下载">
								<i class="glyphicon glyphicon-search"></i></a>									
								
							</td>
						

					</tr>
				</c:forEach>
						
					
					</tbody>
				</table>
			</div>
			<div class="hr"></div>
			<form method="post" id="ExpertOpinion">
			<div class="outside_box table_box box_padding">
				<div  class="span_tips">
					<span >审核信息</span>
				</div>
				<div class="hr"></div>
				<div class="aduit_input_info">
					<div class="input_info_group">
						<div class="group_left">审核人</div>
						
						<div class="group_right" style="min-height:72px">
							
							 <input type="hidden" id="verifyPerson" class="form-control" name="projectVerify.verifyPerson" value="${verifyInfo['verifyPerson']}"/> 
							<select class="form-control"  id="unitSele" style="margin-bottom:2px">
						             <option>请选择部门</option> 
							</select>
								
								
							<select class="form-control"  name="projectVerify.verifyPerson"  id="userSele" >
									 <option value="a">请选择审核人</option>	
							</select>
						</div>
						<div class="clear"></div>
					</div>
					<div class="input_info_group">
						<div class="group_left">审核时间</div>
						<div class="group_right">
							<input class="datainp form-control" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" value="${verifyInfo['verifyDate']}" name="projectVerify.verifyDate" id="calendar_reg" type="text" placeholder="请选择"  readonly/>							
						</div>
						<div class="clear"></div>
					</div>	
					<div class="input_info_group">
					<div class="group_left">修改意见</div>
					<div class="group_right">
					  <select id="updateStatus"　>
					    <option >同意</option>
					    <option>不同意</option>
					  </select>
					</div>
					
					</div>				
					<div class="clear"></div>
				</div>
				<div class="" style="width: 80%; margin-left: 11%;margin-top: 10px;">
					<span>审核结果</span>
					<div>
						<textarea class="result_textarea"  name="projectVerify.verifyResult">${verifyInfo['verifyResult']}</textarea>
					</div>
				</div>
				<div style="margin-right: 9%;margin-top: 10px;">
					<button type="submit" class="btn btn-primary modal_btn floatR" id="saveVerify">保存</button>
					<div class="clear"></div>
				</div>
				
			</div>
			</form>
		</div>
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<script>
	 jeDate({
		dateCell:"#calendar_reg",//isinitVal:true,
		format:"YYYY-MM-DD",
		isTime:false, //isClear:false,
		/* minDate:"2014-09-19 00:00:00" */
	})
	$(function(){
			$("#ExpertOpinion").validate({
			
                rules: { 
                	'projectVerify.verifyPerson':{required: true,}, // 
                },
                messages: {
                    'projectVerify.verifyPerson':{required: '不能为空' ,}, //
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
