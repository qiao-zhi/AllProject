<%@page import="java.text.SimpleDateFormat"%>
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
<title>审核通过项目证书发放</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/issue/issue_main.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/accepted/send_card.css" />

<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript" src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
<script type="text/javascript" src="js/public/main.js"></script>
<style>
	.error-tip {
		border: 1px solid red;
	}
</style>
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
				  	<li><a href="admin/issue/issue_certificate.jsp">证书发放</a></li>	
				  	<li class="active">审核通过项目证书发放</li>
				</ol>				
			</div>
			
			<div class="outside_box table_box box_padding">
				<div class="header_span">
					<span>基本信息</span>
				</div>
				<div class="sendCard_show_info pub_info_show_top_border">
					<div class="show_info_group">
						<div class="group_left">项目名称</div>
						<div class="group_right" id="projectName"></div>
						<div class="group_left">申请验收单位</div>
						<div class="group_right" id="applicant"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="sendCard_show_info">
					<div class="show_info_group">
						<div class="group_left">项目负责人</div>
						<div class="group_right" id="chargePerson"></div>
						<div class="group_left">经费（万元）</div>
						<div class="group_right" id="projectFunds"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="sendCard_show_info">
					<div class="show_info_group">
						<div class="group_left">会议时间</div>
						<div class="group_right" id="meetingTime"></div>
						<div class="group_left">会议地点</div>
						<div class="group_right" id="meetingPlace"></div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			
			<div class="outside_box table_box box_padding">
				<div class="header_span">
					<span>完善资料审核信息</span>
				</div>
				<div class="sendCard_show_info pub_info_show_top_border">
					<div class="show_info_group">
						<div class="group_left">审核人</div>
						<div class="group_right" id="verifyPerson"></div>
						<div class="group_left">审核日期</div>
						<div class="group_right" id="verifyDate"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="sendCard_show_info" style="border: none;">
					<textarea readonly="readonly" id="verifyResult"></textarea>
				</div>
			</div>
			
			<form id="ic_form" action="entryIssueCertificateAction.action" method="post">
				<div class="outside_box table_box box_padding" style="margin-bottom:10px;">
					<div class="header_span">
						<span>证书发放信息</span>
					</div>
					<div class="hr"></div>
					<div class="sendCard_input_info ">
						<div class="input_info_group">
							<div class="group_right" style="display:none">
								<input type="text" class="form-control" id="projectId" name="issueCertificate.projectId" value="${param.projectId }" />
							</div>
							
							<div class="group_left">发放人</div>
							<div class="group_right" style="margin-right:0px;">
								<!-- <input type="text" class="form-control" name="issueCertificate.issuePerson" id="issuePerson"/> -->
								<select id="unit" name="unit" class="form-control">
									<option>-请选择部门-</option>
								</select>
							</div>
							<div class="group_right" style="margin-right: 131px;">
								<select id="issuePerson" name="issueCertificate.issuePerson" class="form-control">
									<option>-请选择证书发放人-</option>
								</select>
							</div>
						  	<!-- <div class="floatL" style="width:230px;height:34px">
								<span style="line-height:34px;color:red;font-size:12px"></span>
							</div> -->
							<div class="group_left">发放日期</div>
							<div class="group_right">
								<input type="text" id="issueDate" name="issueCertificate.issueDate" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" maxlength="10" onfocus="$(this).calendar()" readonly class="form-control"/> 
							</div>
							<!-- <div class="floatL" style="width:230px;height:34px">
								<span style="line-height:34px;color:red;font-size:12px"></span>
							</div> -->
							<div class="clear"></div>
						</div>
						<div class="input_info_group">
							<div style="margin-top: 10px;">
								<div class="group_left">领取人</div>
								<div class="group_right">
									<input type="text" id="holder" name="issueCertificate.holder" value="" class="form-control" placeholder="请输入证书领取人姓名"/> 
								</div>
								<div class="group_left">联系方式</div>
								<div class="group_right">
									<input type="text" id="holderPhone" name="issueCertificate.holderPhone" value="" class="form-control" placeholder="请输入领取人联系电话" />
								</div>
								<div class="group_left">领取日期</div>
								<div class="group_right">
									<input type="text" id="holdDate" name="issueCertificate.holdDate" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" maxlength="10" onfocus="$(this).calendar()" class="form-control" placeholder="请选择日期" readonly="readonly" />
								</div>
								<script>
									jeDate({
										dateCell : "#holdDate",//isinitVal:true,
										format : "YYYY-MM-DD",
										isTime : false, //isClear:false,
									});
								</script>
							</div>
							<div style="display:none"><input id="remark" name="issueCertificate.remark" /></div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="sender">
						<textarea placeholder="备注" id="remarkInfo"></textarea>
					</div>
					<div class="box_padding">
						<!--<button class="btn btn-default save_btn_width floatR">提交</button>-->
						<button class="btn btn-default save_btn_width save_btn_color floatR btnIC" type="button" id="submit_form">保存</button>
						<!-- <button class="btn btn-default save_btn_width save_btn_color floatR btnIC" type="button" id="check" >check</button> -->
						<div class="clear"></div>
					</div>
				</div>
			</form>
				
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="/admin/home/footer.jsp" />
	<script>
		jeDate({
			dateCell : "#issueDate",//isinitVal:true,
			format : "YYYY-MM-DD",
			isTime : true, //isClear:false,
		});
		
			$("#submit_form").click(function(){
				$("#unit").trigger("blur"); 
				$("#issuePerson").trigger("blur"); 
				$("#issueDate").trigger("blur");
				
				$("#holder").trigger('blur');
				$("#holderPhone").trigger('blur');
				$("#holdDate").trigger('blur');
				
				console.log("submit last check");
				if($("#unit").hasClass("error-tip") || $("#issuePerson").hasClass("error-tip") || $("#issueDate").hasClass("error-tip")){
					console.log("验证没通过不能提交");
				}else{
					console.log("可以提交");
					//提交代码
					var remark = $("#remarkInfo").html();
            		$("#remark").val(remark);
                	$("#ic_form").submit();
				}
			});
			
			/* 失去焦点验证 */
			$("#unit").blur(function(){
				$("#unit").removeClass("error-tip");
				$("#issuePerson").removeClass("error-tip");
				if($("#unit option:selected").html() == "-请选择部门-" ){					
					$("#unit").addClass("error-tip");
					$("#issuePerson").addClass("error-tip");
				}
			});
			$("#issuePerson").blur(function(){
				$("#issuePerson").removeClass("error-tip");
				if($("#issuePerson option:selected").html() == "-请选择证书发放人-" ){
					$("#issuePerson").addClass("error-tip");
				}
			});
			$("input#issueDate").blur(function(){
				$("input#issueDate").removeClass("error-tip");
				if($("input#issueDate").val() == "" ){
					console.log("input null");
					$("input#issueDate").addClass("error-tip");
				};
			});
			
			$("#holder").blur(function() {
				$("#holder").removeClass('error-tip');
				if ($("#holder").val() == "") {
					$("#holder").addClass('error-tip');
				}
			});
			
			$("#holderPhone").blur(function() {
				$("#holderPhone").removeClass('error-tip');
				if ($("#holderPhone").val() == "") {
					$("#holderPhone").addClass('error-tip');
				}
			});
			
			$("#holdDate").blur(function() {
				$("#holdDate").removeClass('error-tip');
				if ($("#holdDate").val() == "") {
					$("#holdDate").addClass('error-tip');
				}
			});
		
		/* $(function(){
			$("#ic_form").validate({
				
                rules: { 
                	'issueCertificate.issuePerson':{required: true,}, //发放人 
                	'issueCertificate.issueDate':{required: true,}, //发放日期
                },
                messages: {
                    'issueCertificate.issuePerson':{required: '发放人不能为空' ,}, //发放人 
                    'issueCertificate.issueDate':{required: '请选择日期',}, //发放日期
                },
                errorClass: "error",
                success: 'valid',
                unhighlight: function (element, errorClass, validClass) { //验证通过
                    $(element).tooltip('destroy').removeClass(errorClass);
                	$(element).removeClass("error-tip");
                },
                errorPlacement: function (error, element) {                  
                	 $(element).addClass("error-tip");
                },
                submitHandler: function (form) {
                	var remark = $("#remarkInfo").html();
            		$("#remark").val(remark);
                	form.submit();
                }
        	});
		}); */
	</script>
</body>
</html>
