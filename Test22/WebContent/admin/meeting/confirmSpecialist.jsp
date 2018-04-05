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
	<base href="<%=basePath %>">
	<title>确定专家</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/zhuanjia.css" />
	<link rel="stylesheet" href="css/role1/modal.css" />
    <script src="js/meeting/confirmSpecialist.js"></script>
    <script type="text/javascript" src="js/public/main.js"></script>
    <script type="text/javascript" src="controls/myPage/jquery.myPagination6.0.js"></script>
	<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
	<link rel="stylesheet" href="controls/myPage/msgbox.css" />
	<link rel="stylesheet" href="controls/myPage/page.css" />
	<link rel="stylesheet" href="controls/myPage/pageStyle.css" />

    
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
		   <li class="active">确定专家</li>
		</ol>	
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">会议信息</label>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议时间</label>
				<input type="hidden" name="meetingId" value="${meeting.meetingId}"/>
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
			<label for="">选择项目</label>
		</div>
		<table id="engineer" class="table table-hover table-bordered mytable">
			<thead>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>申请验收单位</th>
					<th>所属领域</th>
					<th>经费(万元)</th>
					<!-- <th>企业推荐专家</th> -->
				</tr>
			</thead>
			<tbody class="word_center">
				<c:forEach var="project" varStatus="status"
					items="${projectList}">
					<tr>
						<td><c:out value="${status.index+1}" /></td>						
						<td>${project.projectName}</td>
						<td>${project.applicant}</td>
						<td>${project.domain}</td>
						<td>${project.projectFunds}</td>						
						
					<%--   <td>	
					  <input type="hidden" value="${project.projectId}" name="useProjectId"/>				
						<!-- <a   href="javaScript:void(0)" name="lookSpecialist" data-toggle="modal"  data-target="#look" >查看</a> -->
						 <a href="javaScript:void(0)" name="lookSpecialist" class="operation_icon" data-toggle="modal" data-target="#look" data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a> 												
						</td>  --%>	 
						
					
					</tr>
				</c:forEach> 
				
			</tbody>
		</table>
	</div>
	
	
	
	<!-- 验收专家组名单-->
	<div class="outside_box table_box" id="zhuanjiazu">
		<div class="strong">
			<label for="">验证专家组名单</label>
		</div>
		<div class="select">
			<!-- <button class="btn btn-default floatR word_center" id="tuijian" class="enterTuiJian" data-toggle="modal" data-target="#tuijianModal">企业推荐专家</button> -->
			<button class="btn btn-primary floatR word_center" id="chouqu"  data-toggle="modal" data-target="#chouquModal">抽取专家</button>
			<div class="clear"></div>
		</div>
		<table id="yanshou" class="table table-bordered table-hover mytable">
			<thead>
			 	<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>单位</th>
					<th>专业</th>
					<th>职务</th>
					<th>职称</th>
					<th>联系方式</th>
					<!-- <th>来源</th> -->
					<th>操作</th>
			 	</tr>
			</thead>
			<tbody class="word_center">
				<c:forEach var="specialist" varStatus="status"
					items="${showInitSpecialist}">
					<tr>
					
						<td ><c:out value="${status.index+1}" />			      	     
						</td>						
						<td> <input type="hidden" name="source"value="${specialist.source}"/> <input type="hidden" name="specialistId" value="${specialist.specialistId}"/>${specialist.name}</td>
						<td>${specialist.workUnit}</td>
						<td>${specialist.engageDomain}</td>
						<td>${specialist.duty}</td>	
						<td>${specialist.title}</td>	
						<td>${specialist.telephone}</td>	
						<%-- <td>${specialist.source}</td>	 --%>					
						<td>
						<!-- <a href="javaScript:void(0)" name="delYanShou">删除</a> -->
						<a href="javaScript:void(0)" class="delYanShou"  class="operation_icon" data-toggle="tooltip" data-placement="bottom" value="删除"><i class="glyphicon glyphicon-trash"></i></a>
						</td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		<div class="btn_box commit" >
			<button class="btn btn-default floatR modal_btn" id="quxiao">返回</button>
			<button class="btn btn-primary floatR modal_btn"  id="baocun">保存</button>
			<div class="clear"></div>
		</div>
		
	</div>
	</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	
	<!-- 企业推荐全部专家 -->
	<div class="modal fade" id="tuijianModal" tabindex="-1" role="dialog" aria-labelledby="tuijianLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
  			<div class="modal-header word_center my_modal_title">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">企业推荐专家</h4>
		    </div>
  			<div class="modal-body">
				 <div class="outside_box table_box recommend">
					<div class="strong">
						<label for="">会议信息</label>
					</div>
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius">会议时间</label>
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
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius pub_border_none">会议备注</label>
							<label class="label_right none_border_radius pub_border_none">${meeting.remark}</label>
							<div class="clear"></div>
						</div >
					</div>
					<div class="clear"></div>
				</div>
				<div class="mytable">
					<table id="engineer" class="table table-hover table-bordered mytable">
						<thead>
							<tr>
								<th>全选</th>
								<th>序号</th>
								<th>姓名</th>
								<th>单位</th>
								<th>专业</th>
								<th>职务</th>
								<th>职称</th>
								<th>联系方式</th>
								<th>推荐企业</th>
							</tr>
						</thead>
						<tbody class="word_center">
							 <c:forEach var="specialist" varStatus="status"
					items="${enterSpecialist}">
					<tr>
					
						
						<td><input id="${specialist.specialistId}" type="checkbox" name="checkId"
				        			  value="${specialist.specialistId},
				        			  ${specialist.name},
				        			  ${specialist.workUnit},
				        			  ${specialist.engageDomain},
				        			  ${specialist.duty},
				        			  ${specialist.title},
				        			  ${specialist.telephone},
				        			  ${specialist.source},"
				        			/>
				         </td>	
				         <td><c:out value="${status.index+1}" />			
					  <input type="hidden" name="specialist.source" value="${specialist.source}"/>
	        	      <input type="hidden" id="" name="specialist.specialistId" value="${specialist.specialistId}"/>
						</td>					
						<td>${specialist.name}</td>
						<td>${specialist.workUnit}</td>
						<td>${specialist.engageDomain}</td>
						<td>${specialist.duty}</td>	
						<td>${specialist.title}</td>	
						<td>${specialist.telephone}</td>	
						<td>${specialist.source}</td>						
						<!-- <td><a name="delTuiJian" href="javaScript:void(0)" class="delSpec">删除</a></td> -->
					</tr>
				</c:forEach> 
						</tbody>
					</table>
				</div>
 			</div>		
		    <div class="modal-footer">
		        
		        <button id="queding" type="button" class="btn btn-primary modal_btn" data-dismiss="modal">确定</button>
		    <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>
		     </div>
		</div>
		</div>
</div>
<!-- 抽取专家 -->
	<div class="modal fade" id="chouquModal" tabindex="-1" role="dialog" aria-labelledby="chouquLabel" aria-hidden="false">
  	<div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header word_center my_modal_title">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">抽取验收专家</h4>
	      </div>
	      <div class="modal-body">
	          
	     		<div class="search_bar modal_bar">
	     		
					<div class="input-group search_bar_input floatL">
					 	<span class="input-group-addon">专家姓名</span>
					  	<input type="text" name="name" class="form-control">		  		
					</div>
					<div class="input-group search_bar_input floatL">
					  	<span class="input-group-addon">所属领域</span>
					  	  <select id="domainList" class="form-control" name="domain">
					  	  	<option></option>
					         <c:forEach var="domain" items="${domainList}">
	
						      <option> ${domain}</option>
	
					         </c:forEach>
			    	      </select> 
					  	<!--  <select id="domainList" class="form-control" name="domain">
					  		<option>交通运输领域</option>
					  		<option>领域二</option>
					  		<option>领域三</option>
					  		<option>领域四</option>
					  	</select>	 -->
					</div>
					<button id="searSpec" class="btn btn-default search_bar_button float_right">查询&nbsp;&nbsp;<span class=" glyphicon glyphicon-search span_icon"></span></button>			
					<div class="clear"></div>
					
				</div>
				
	      		<div class="mytable">
	      			<table id="specialist2" class="table table-bordered table-hover">
	      				<thead>
	      					<tr>
	      						<th>全选</th>
	      						<th>序号</th>
	      						<th>姓名</th>
	      						<th>单位</th>
	      						<th>专业</th>
	      						<th>职务</th>
	      						<th>职称</th>
	      						<th>联系方式</th>
	      					</tr>
	      				</thead>
	      				<tbody class="word_center">
	      				
	      				</tbody>
	      			</table>
	      		</div>
	       </div>
	       
	       <nav class="word_center">
	
		
			<input id="submitSearch" type="hidden"/>	
			
				<div id="demo1">
			</nav>
	       
	      	<div class="modal-footer">
		       
		        <button type="button" class="btn btn-primary modal_btn" data-dismiss="modal"  id="save">确定</button>
	       <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>
	      	</div>
	    </div>
 	</div>
</div>


<!-- 查看单个项目专家模块 -->

<div class="modal fade" id="look" tabindex="-1" role="dialog" aria-labelledby="tuijianLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
  			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">企业推荐专家</h4>
		      </div>
  			<div class="modal-body">   
				 <div class="modal-body">
  				<div class="commits ">
     				<h4 class="modal-title" id="myModalLabel">会议信息</h4>
 					<div class="hang">
 					<div class="block">
			           <label class="label_left none_border_radius">会议时间</label>
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
     			</div>
 			</div>
 			<div id="recommended">
				<table id="chakan" class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>单位</th>
							<th>专业</th>
							<th>职务</th>
							<th>职称</th>
							<th>联系方式</th>
							<th>推荐企业</th>
						</tr>
					</thead>
					<tbody>
				
					</tbody>
				</table>
 			</div>
		    <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">返回</button>
		     </div>
		</div>
		</div>
</div>



</body>
</html>
