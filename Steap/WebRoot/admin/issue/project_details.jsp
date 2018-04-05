<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>项目明细信息</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/issue/project_details.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/accepted/project_details.css" />
<link rel="stylesheet" href="css/public/lightbox.css" />
<link rel="stylesheet" href="css/register/register.css" />
<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
</head>

<body style="overflow-y: scroll;">
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
				  	<li class="active">查看项目详情</li>
				</ol>				
			</div>
			<div>
		
			  <!-- Nav tabs -->
			  <ul class="nav nav-tabs container" role="tablist">
			    <li role="presentation" class="active"><a href="#base_info" data_title="project" data_flag="false" data_load="javascript:getBIProject();" aria-controls="base_info" role="tab" data-toggle="tab">基本信息</a></li>
			    <li role="presentation"><a href="#inspection" data_title="inspect" data_flag="false" data_load="javascript:getBIEInspect();" aria-controls="inspection" role="tab" data-toggle="tab">现场考察</a></li>
			    <li role="presentation"><a href="#ready_meeting" data_title="notify" data_flag="false" data_load="javascript:getBIProjectNotify();" aria-controls="ready_meeting" role="tab" data-toggle="tab">验收会前准备</a></li>
			    <li role="presentation"><a href="#project_data" data_title="material" data_flag="false" data_load="javascript:getBIProjectMaterial();" aria-controls="project_data" role="tab" data-toggle="tab">项目资料</a></li>
			    <li role="presentation"><a href="#project_take_in" data_title="meeting" data_flag="false" data_load="javascript:getBIProjectCheck();" aria-controls="project_take_in" role="tab" data-toggle="tab">项目验收</a></li>
			    <li role="presentation"><a href="#project_data_perf" data_title="complete" data_flag="false" data_load="javascript:getBIProjectComplete();" aria-controls="project_data_perf" role="tab" data-toggle="tab">验收资料完善</a></li>
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			  	<!--项目基本信息-->
			    <div role="tabpanel" class="tab-pane active" id="base_info">
			    	<div class="container tab_pane_color">
			    		<div class="base_info_tab_pane">
			    			<div class="tab_pane_title">
			    				<span>项目基本信息</span>
			    			</div>
			    			<div class="hr"></div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group pub_info_show_top_border">
			    					<div class="group_right" style="display:none"><input type="text" id="projectId" value="${param.projectId }"/></div>
			    					<div class="group_left">项目名称</div>
			    					<div class="group_right" id="projectName"></div>
			    					<div class="group_left">申请单位</div>
			    					<div class="group_right" id="applicant"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group">
			    					<div class="group_left">所属领域</div>
			    					<div class="group_right" id="domain"></div>
			    					<div class="group_left">项目申请日期</div>
			    					<div class="group_right" id="applicationDate"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group">
			    					<div class="group_left">登记人</div>
			    					<div class="group_right" id="recordPerson"></div>
			    					<div class="group_left">登记日期</div>
			    					<div class="group_right" id="recordDate"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group">
			    					<div class="group_left">负责部门</div>
			    					<div class="group_right" id="chargeUnit"></div>
			    					<div class="group_left">负责人</div>
			    					<div class="group_right" id="chargePerson"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group">
			    					<div class="group_left">领取验收资料人</div>
			    					<div class="group_right" id="receivePerson"></div>
			    					<div class="group_left">领取验收资料日期</div>
			    					<div class="group_right" id="receiveDate"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group">
			    					<div class="group_left">审查人</div>
			    					<div class="group_right" id="censorPerson"></div>
			    					<div class="group_left">审查日期</div>
			    					<div class="group_right" id="censorDate"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="base_info_textarea">
			    				<div class="tab_pane_title">
			    					<span>审查结果</span>
			    				</div>
			    				<textarea readonly="readonly" class="show_info_textarea" id="censorResult"></textarea>
			    			</div>
			    		</div>
			    	</div>
			    </div>
			    <!--项目基本信息结束-->
			    <!--现场考察-->
			    <div role="tabpanel" class="tab-pane" id="inspection">
			    	<div class="container tab_pane_color">
			    		<div class="inspection_tab_pane">
			    			<div class="tab_pane_title">
			    				<span>企业现场考察</span>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group pub_info_show_top_border">
			    					<div class="group_left">考察人</div>
			    					<div class="group_right" id="inspectPerson"></div>
			    					<div class="group_left">考察日期</div>
			    					<div class="group_right" id="inspectDate"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="margin_to_top">
			    				<div class="tab_pane_title">
			    					<span>考察结果</span>
			    				</div>
			    				<textarea class="show_info_textarea" readonly="readonly" id="inspectResult"></textarea>
			    			</div>
							<div class="tab_pane_title">
								<span>企业考察照片</span>
		    				</div>	
			    			<div class="margin_to_top pic_padding pic_container_wrapper">
							  	<div class="row inspectPicture">
								    <a href="" class="thumbnail col-xs-6 col-md-2 ip" data-lightbox = "check_pic">
								      	<img src="" alt="" class="">
								    </a>
							  	</div>
			    			</div>
			    			
			    			<div class="hr"></div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group pub_info_show_top_border">
			    					<div class="group_left">审计单位</div>
			    					<div class="group_right" id="financeUnit"></div>
			    					<div class="group_left">审计日期</div>
			    					<div class="group_right" id="auditDate"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>		    			
							<div class="tab_pane_title">
								<span>审计单位廉洁承诺书</span>
		    				</div>		    			
			    			<div class="margin_to_top pic_padding pic_container_wrapper">
			    				<div class="row auditPicture">
			    					<a href="" class="thumbnail col-xs-6 col-md-2 ap" data-lightbox = "commit_letter">
			    						<img src="" alt="" />
			    					</a>
			    				</div>
			    			</div>
			    		</div>
			    		
			    	</div>
			    </div>
			    <!--现场考察结束-->
			    <!--验收会前准备-->
			    <div role="tabpanel" class="tab-pane" id="ready_meeting">
			    	<div class="container tab_pane_color">
			    		<div class="ready_meeting_tab_pane">
			    			<div class="tab_pane_title">
			    				<span>通知企业参会</span>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group pub_info_show_top_border">
			    					<div class="group_left">通知日期</div>
			    					<div class="group_right" id="notifyDate"></div>
			    					<div class="group_left">通知方式</div>
			    					<div class="group_right" id="notifyMethod"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="hr"></div>
			    			<div class="tab_pane_title">
			    				<span>验收意见初稿</span>
			    			</div>
			    			<div>
			    				<textarea id="jqte_name3" class="jqte_name" placeholder="请把验收意见初稿的原件内容录入当前文本区域，并调整好格式..." style="width:100%; resize:none; outline:none; height:400px; border-radius:5px; border: 1px solid #CCC;" readonly ></textarea>
			    			</div>
			    			<div class="hr"></div>
			    			<div class="tab_pane_title" >
			    				<span>真实性承诺书</span>
			    				<div class="margin_to_top pic_padding pic_container_wrapper">
								  	<div class="row realPicture">
									    <a href="" class="thumbnail col-xs-6 col-md-2 rp" data-lightbox = "check_pic">
									      	<img src="" alt="" class="">
									    </a>
								  	</div>
								</div>
			    			</div>
			    			<div>
			    			</div>
			    		</div>
			    	</div>
			    </div>
			    <!--验收会前准备结束-->
			    <!--项目资料-->
			    <div role="tabpanel" class="tab-pane" id="project_data">
			    	<div class="container tab_pane_color">
			    		<div class="project_data_tab_pane">
			    			<div class="tab_pane_title">
			    				<span>基本信息</span>
			    			</div>
			    			<div class="pub_info_show pub_info_show_top_border">
			    				<div class="show_info_group">
			    					<div class="group_left">项目名称</div>
			    					<div class="group_right" id="c_projectName"></div>
			    					<div class="group_left">申请验收单位</div>
			    					<div class="group_right" id="c_applicant"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="pub_info_show">
			    				<div class="show_info_group">
			    					<div class="group_left">项目负责任人</div>
			    					<div class="group_right" id="c_chargePerson"></div>
			    					<div class="group_left">经费（万元）</div>
			    					<div class="group_right" id="c_projectFunds"></div>
			    					<div class="clear"></div>
			    				</div>
			    			</div>
			    			<div class="hr"></div>
			    			<div class="tab_pane_title">
			    				<span>验收资料</span>
			    			</div>
			    			<div>
			    				<table class="table table-bordered">
			    					<thead>
			    						<tr>
			    							<th>序号</th>
			    							<th>类型</th>
			    							<th>文件名称</th>
			    							<th>上传时间</th>
			    							<th>大小</th>
			    							<th>操作</th>
			    						</tr>
			    					</thead>
			    					<tbody id="t_material"></tbody>
			    				</table>
			    			</div>
			    		</div>
			    	</div>
			    </div>
			    <!--项目资料结束-->
			    <!--项目验收-->
		    	<div role="tabpanel" class="tab-pane" id="project_take_in">
		    		<div class="container tab_pane_color">
		    			<div class="project_take_in_tab_pane">
		    				<div class="tab_pane_title">
			    				<span>会议信息</span>
			    			</div>
		    				<div class="project_take_in_show_body">
		    					<div class="show_info_group">
		    						<div class="group_left">会议时间</div>
		    						<div class="group_right"><label id="meetingTime"></label> </div>
		    						<div class="clear"></div>
		    					</div>
		    				</div>
		    				<div class="project_take_in_show_body">
		    					<div class="show_info_group">
		    						<div class="group_left">会议地点</div>
		    						<div class="group_right"><label id="meetingPlace"></label></div>
		    						<div class="clear"></div>
		    					</div>
		    				</div>
		    				<div class="hr"></div>
		    				<div class="tab_pane_title">
		    					<span>专家组名单</span>
		    				</div>
		    				<div>
		    					<table class="table table-bordered">
		    						<thead>
		    							<tr>
		    								<th>序号</th>
		    								<th>姓名</th>
		    								<th>单位</th>
		    								<th>专业</th>
		    								<th>职务</th>
		    								<th>职称</th>
		    								<th>联系方式</th>
		    								<th>签到时间</th>
		    								<th>个人意见</th>
		    							</tr>
		    						</thead>
		    						<tbody id="t_specialistGroup"></tbody>
		    					</table>
		    				</div>
		    				<div class="hr"></div>
		    				<div class="tab_pane_title">
		    					<span>项目评审结果</span>
		    				</div>
		    				<div>
		    					<textarea class="jqte_name project_take_in_textarea out_hei resultInfo"></textarea>
		    				</div>
		    			</div>
		    		</div>
		    	</div>
		    	<!--项目验收结束-->
		    	<!--验收资料完善-->
				    <div role="tabpanel" class="tab-pane" id="project_data_perf">
				    	<div class="container tab_pane_color">
				    		<div class="project_data_perf_tab_pane">
				    			<%-- <div class="tab_pane_title">
				    				<span>资料完善说明</span>
				    			</div>
				    			<div>
				    				<textarea class="show_info_textarea" readonly="readonly" id="completeDescription"></textarea>
				    			</div>
				    			<div class="hr"></div>
				    			<div class="tab_pane_title">
				    				<span>完善的资料</span>
				    			</div>
				    			<div>
				    				<table class="table table-bordered">
				    					<thead>
				    						<tr>
				    							<th>序号</th>
				    							<th>类型</th>
				    							<th>文件名称</th>
				    							<th>上传日期</th>
				    							<th>大小</th>
				    							<th>操作</th>		    							
				    						</tr>
				    					</thead>
				    					<tbody id="t_complete"></tbody>
				    				</table>
				    			</div>
				    			<div class="hr"></div> --%>
				    			<div class="tab_pane_title">
				    				<span>审核信息</span>
				    			</div>
				    			<div class="pub_info_show">
				    				<div class="show_info_group pub_info_show_top_border">
				    					<div class="group_left">审核人</div>
				    					<div class="group_right" id="verifyPerson"></div>
				    					<div class="group_left">审核日期</div>
				    					<div class="group_right" id="verifyDate"></div>
				    					<div class="clear"></div>
				    				</div>
				    			</div>
				    			<div class="margin_to_top">
				    				<div class="tab_pane_title">
				    					<span>审核结果</span>
				    				</div>
				    				<textarea class="show_info_textarea" readonly="readonly" id="verifyResult"></textarea>
				    			</div>
				    			<div class="hr"></div>
				    			
				    			<div style="padding:8px; border:1px solid #CCCCCC;background-color:#FBFBFB">
	
					    			<div class="tab_pane_title">
					    				<span>资料完善说明</span>
					    			</div>
					    			<div>
					    				<textarea class="show_info_textarea" readonly="readonly" id="completeDescription"></textarea>
					    			</div>				    			
					    			<div class="tab_pane_title">
					    				<span>完善的资料</span>
					    			</div>
					    			<div>
					    				<table class="table table-bordered">
					    					<thead>
					    						<tr>
					    							<th>序号</th>
					    							<th>类型</th>
					    							<th>文件名称</th>
					    							<th>上传日期</th>
					    							<th>大小</th>
					    							<th>操作</th>		    							
					    						</tr>
					    					</thead>
					    					<tbody id="t_complete"></tbody>
					    				</table>
					    			</div>
					    			
				    			</div>
				    			
				    			<div class="hr"></div>
				    			
				    			<div class="tab_pane_title">
				    				<span>证书发放信息</span>
				    			</div>
				    			<div class="pub_info_show">
				    				<div class="show_info_group pub_info_show_top_border">
				    					<div class="group_left">发放人</div>
				    					<div class="group_right" id="issuePerson"></div>
				    					<div class="group_left">发放日期</div>
				    					<div class="group_right" id="issueDate"></div>
				    					<div class="clear"></div>
				    				</div>
				    			</div>
				    			<div class="pub_info_show">
				    				<div class="show_info_group pub_info_show_top_border">
				    					<div class="group_left">领取人</div>
				    					<div class="group_right" id="holder"></div>
				    					<div class="group_left">领取日期</div>
				    					<div class="group_right" id="holdDate"></div>
				    					<div class="clear"></div>
				    				</div>
				    			</div>
								<div class="pub_info_show">
				    				<div class="show_info_group pub_info_show_top_border">
				    					<div class="group_left" style="width: 100%;">备注</div>
				    					<div class="clear"></div>
				    				</div>
					    			<textarea id="remark" style="width: 100%; border: 1px solid #CCC; resize: none;" readonly="readonly" rows="8" cols=""></textarea>
				    			</div>
				    		</div>
				    	</div>
				    </div>
				    <!--验收资料完善结束-->
			  </div>
			</div>
			
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="/admin/home/footer.jsp" />	
			<!--project_take_in check-->
			<div class="modal fade" id="project_take_in_check">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header my_modal_title word_center">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">专家个人意见</h4>
			      </div>
			      <div class="modal-body">
			        <div>
			        	<div class="receive_modal_show_body ">
			      			<div class="show_info_group " style="border-bottom: 1px solid #CCCCCC;">
			      				<div class="group_left">项目名称</div>
			      				<div class="group_right" id="sProjectName"></div>
			      				<div class="clear"></div>
			      			</div>
			      			<div class="show_info_group">
			      				<div class="group_left">申请单位</div>
			      				<div class="group_right" id="sApplicant"></div>
			      				<div class="clear"></div>
			      			</div>
			      		</div>
			      		<div class="hr"></div>
			      		<div>
			      			<textarea readonly="readonly" class="jqte_name mod_hei project_take_in_textarea" id="sResult"></textarea>
			      		</div>
			        </div>
			      </div>
			      <div class="modal-footer">		        
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
	
	<script type="text/javascript" src="js/public/lightbox.js" ></script>	
	<script type="text/javascript">
		$(".jqte_name").jqte();
	 	$(".jqte_toolbar").css("display", "none");
		$(".jqte").css({
			"margin": "0",
			"border": "1px solid #EEE",
			"border-radius": '0'
		});
		$(".jqte_editor").prop("contenteditable", "false");
		$(".jqte_editor, jqte_source").css({
			'height': '300px',
			'resize': 'none'
		});
		
		$(".jqte_editor:first").css({
			'height': '400px',
			'resize': 'none'
		});
	</script>
</body>
</html>
