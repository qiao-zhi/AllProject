
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
		<title>企业现场考察信息</title>
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/public/main.js"></script>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/public/main2.css" />
		<link rel="stylesheet" href="css/receive_report_data/inspection_input.css" />
		<link rel="stylesheet" href="css/receive_report_data/logging_data.css" />
		<link rel="stylesheet" href="css/public/lightbox.css" />				
		<!--<script type="text/javascript" src="../../jeDate-gh-pages/jedate/jedate.js" ></script>-->
	</head>
	<script type="text/javascript">
		$(function(){
			if($("#auditP").text() == ""){
				$("#audir_rep").empty();
			}
		});
	</script>
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
			

					<ol class="breadcrumb ol_nav">
						<!--需要么？-->
						<!--<li><a href="#">返回</a></li>-->
					 	<li class="active">查看企业考察信息</li>				 	
					</ol>
	
					<div>
						<div class="base_info">
							<div class="info_modal">
								<div class="base_info_modal">
									<div class="info_backg">
										<div class="info_box_inspection"><span>项目基本信息</span></div>
										<div class="project_table_box">
										
												<div class="project_pub_info_show">
													<div class="show_info_group pub_info_show_top_border">	
														<div class="group_left">项目名称</div>
														<div class="hidden" id="auditP">${projectInfoOfPrepared.auditInfo.auditingPerson }</div>
														<div class="group_right">${projectInfoOfPrepared.projectName }</div>
														<div class="group_left">申请单位</div>
														<div class="group_right">${projectInfoOfPrepared.applicant }</div>
														<div class="clear"></div>
													</div>
												</div>
												<div class="project_pub_info_show">
													<div class="show_info_group">
														<div class="group_left">所属领域</div>
														<div class="group_right">${projectInfoOfPrepared.domain }</div>
														<div class="group_left">申请验收日期</div>
														<div class="group_right">${projectInfoOfPrepared.applicationDate }</div>
														<div class="clear"></div>
												
													</div>
												</div>
												<div class="project_pub_info_show">
													<div class="show_info_group">
														<div class="group_left">登记人</div>
														<div class="group_right">${projectInfoOfPrepared.projectRecord.recordPerson}</div>
														<div class="group_left">登记日期</div>
														<div class="group_right">${projectInfoOfPrepared.projectRecord.recordDate}</div>
														<div class="clear"></div>
													</div>
												</div>
												<div class="project_pub_info_show">
												<div class="show_info_group">
													<div class="group_left">负责部门</div>
													<div class="group_right">${projectInfoOfPrepared.projectCharge.chargeUnit}</div>
													<div class="group_left">负责人</div>
													<div class="group_right">${projectInfoOfPrepared.projectCharge.chargePerson}</div>
													<div class="clear"></div>
												</div>
												</div>
												<div class="project_pub_info_show">
													<div class="show_info_group">
														<div class="group_left">领取验收资料人</div>
														<div class="group_right">${projectInfoOfPrepared.projectReceive.receivePerson}</div>
														<div class="group_left">领取验收资料时间</div>
														<div class="group_right">${projectInfoOfPrepared.projectReceive.receiveDate}</div>
														<div class="clear"></div>
													</div>
												</div>
												<div class="project_pub_info_show">
												<div class="show_info_group">
													<div class="group_left">审查人</div>
													<div class="group_right">${projectInfoOfPrepared.projectCensor.censorPerson}</div>
													<div class="group_left">审查时间</div>
													<div class="group_right">${projectInfoOfPrepared.projectCensor.censorDate}</div>
													<div class="clear"></div>
												</div>
												</div>
											<div>
											    <div class="project_tab_pane_title">								
													<span>审查结果</span>
												<textarea readonly="readonly" class="project_base_info_textarea">${projectInfoOfPrepared.projectCensor.censorResult}</textarea>
											   </div>
										  	 </div>
										  
											  <%--   <div class="table_label_box input-group ">								
													<label class="name_info_area textarea_label">审查结果</label>
													<textarea class="base_info_textarea word_center " placeholder="" readonly="readonly">${projectInfoOfPrepared.projectCensor.censorResult}</textarea>
													<div class="clear"></div>
												</div>  --%>
										</div>
										
										
									</div>
								</div>					
							</div>
						</div>
			
						<div class="recommend_expert">
							<div class="info_modal">
								<div class="recommend_expert_info_modal">
									<div class="info_backg">
										<div class="project_pub_info_show" style="padding-left:20px;padding-right:20px">
											<div class="info_box_inspection" style="margin-left:0px"><span>企业考察信息</span></div>										
												<div class="show_info_group pub_info_show_top_border">
													<div class="group_left">考察人</div>
													<div class="group_right">
														${projectInfoOfPrepared.enterpriseInspect.inspectPerson}
													</div>
													<div class="group_left ">考察时间</div>
													<div class="group_right">
													${projectInfoOfPrepared.enterpriseInspect.inspectDate}		
													</div>
													<div class="clear"></div>
												</div>																
										</div>					
						
										<div>
										    <div class="project_tab_pane_title" style="padding-left:20px;padding-right:20px">								
												<span>考察结果</span>
											<textarea readonly="readonly" class="project_base_info_textarea">${projectInfoOfPrepared.enterpriseInspect.inspectResult}</textarea>
										   </div>
									  	 </div>
										
									</div>
								</div>
							</div>
						</div>
						
						<div class="base_info">
							<div class="info_modal">
								<div class="base_info_modal">
									<div class="info_backg">
										<div class="pic_box">
											<div>
												<span>企业考察照片</span>
											</div>
											<div class="row pic_row">
											 	<c:forEach var="picture" items="${pictureList}">
											 		<a href="${picture.currentName }" picture" data-lightbox = "yaowei" class="box_size" data-title="second pic">
												 		<img src="${picture.currentName }" />
												 		<span class="pic_info">${picture.originalName }</span>
											 		</a>
											 	</c:forEach>
											</div>
											
										</div>							
									
										<div class="clear"></div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="audit_report " id="audir_rep">
							<div class="info_modal">
								<div class="audit_report_info_modal">
									<div class="info_backg">
										<div class="info_box_inspection"><span>审计信息录入</span></div>
											<div class="project_pub_info_show" style="padding-left:20px;padding-right:20px">
												<div class="show_info_group pub_info_show_top_border">
											  		<div class="group_left">审计单位</div>
											  	<div class="group_right">${projectInfoOfPrepared.auditInfo.financeUnit}</div>
											  	<div class="group_left">审计时间</div>
											  	<div class="group_right">${projectInfoOfPrepared.auditInfo.auditDate}</div>
											  	<div class="clear"></div>
											 </div>
											 </div>
										  	
										<div class="pic_box">
											<div>
												<span>廉洁承诺书</span>
											</div>
											<div class="row pic_row">
											 	<c:forEach var="picture" items="${pictureList2}">
											 		<a href="${picture.currentName }" data-lightbox = "yaowei" class="box_size" data-title="second pic">
												 		<img src="${picture.currentName }" />
												 		<span class="pic_info">${picture.originalName }</span>
											 		</a>
											 	</c:forEach>
											 	
											 	
											</div>
											
										</div>	
										<div class="clear"></div>
									</div>
								</div>
							</div>
						</div>
						<!---->
						
						
					</div>					
				
		</div>
		
		</div>
		<div class="clear"></div>
	</div>
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
		
		<script type="text/javascript" src="js/public/lightbox.js" ></script>
	</body>
</html>
