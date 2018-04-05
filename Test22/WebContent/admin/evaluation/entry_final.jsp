<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>录入最终评审结果</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
<script type="text/javascript" src="controls/print/jquery.print.js"></script>
<script type="text/javascript" src="controls/print/jquery-migrate-1.1.0.min.js"></script>
<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
<link rel="stylesheet" href="css/meeting_host/all_review_input.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/meeting_host/meetingUI.css" />
<script type="text/javascript" src="js/experts/entry_final.js"></script>
</head>
<body style="background:#C6EDE8">
	<jsp:include page="evaluation_nav.jsp" />
	
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="javascript:window.history.go(-1);">首页</a></li>
			  	<li class="active">待评审项目</li>
			</ol>
		</div>
	</div>
		
	<div>
		<div class="project_information">
			<div>
				<h4>项目基本信息</h4>
			</div>
			<div class="info_show">
				<label class="show_left">项目名称</label>
				<label class="show_rigth" id="projectName"></label>
				<label class="show_left">承担单位</label>
				<label class="show_rigth" id="applicant"></label>
				<div class="clear"></div>
			</div>
			<div class="info_show">
				<label class="show_left">项目负责人</label>
				<label class="show_rigth" id="name"></label>
				<label class="show_left">经费金额</label>
				<label class="show_rigth" id="projectFunds"></label>
				<div class="clear"></div>
			</div>
			<div></div>
		</div>
		<div class="idea_input">
			<div>
				<button class="btn btn-default save_btn_width saveResult">提交</button>
				<button class="btn btn-default save_btn_width onlySaveResult">保存</button>
				<div class="clear"></div>
			</div>
			<form id="resultInfo" action="entryEvaluationResultAction.action" method="post">
				<input type="hidden" id="specialistId" class="form-control none_border_radius" name="evaluationResult.specialistId" value="${param.expertId }"/>
				<input type="hidden" id="projectId" class="form-control none_border_radius" name="evaluationResult.projectId" value="${param.projectId }"/>
				<input type="hidden" id="evaluation_result" class="form-control none_border_radius" name="evaluationResult.evaluateResult" value="">
				<input type="hidden" id="operationType" class="form-control none_border_radius" name="operationType" value="" >
			</form>
			<div class="print-info">
				<h4>项目最终评审结果</h4>
			</div>			
			<textarea id="all_idea"></textarea>
		</div>
	</div>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<script>
		$("#all_idea").jqte();
		$(".jqte").css({
			"margin-top" : "15px"
		});
	</script>
</body>
</html>
