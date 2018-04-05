<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>签订承诺书</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/wait_review_project.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<script type="text/javascript" src="js/experts/signCommitment.js"></script>
<style>
	.page-title{
		background: ;
		border: 1px solid #CCCCCC;
		width: 800px;
		padding: 10px 70px 0 70px;
		text-indent: 2em;
		font-size: 18px;
		line-height:1.8em; 
		margin: 0 auto;
	}
	.page-input{
		border: none;
		text-indent: 0;
	}
	h2{
		text-align: center;
		line-height:1.2em; 
		font-weight: 500;
		margin-bottom: 30px;
	}
	.person-signatrue{
		background: #EEEEEE;
		width: 400px;
		height: 180px;
		float: right;
	}
	.page-date{
		text-align: right;
		margin-top:20px;
	}
	img {
		width:400px;
		height:180px;
		float:left;
	}
</style>
</head>

<body>
	<jsp:include page="evaluation_nav.jsp" />
	
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/evaluation/specialist_evaluation.jsp">首页</a></li>
			  	<li><a href="admin/evaluation/evaluatedProject.jsp">待评审项目</a></li>
			  	<li class="active">签署承诺书</li>
			</ol>
		</div>
	</div>

	<div class="sign_commit">
		<article class="page-title">
			<h2>验收专家廉洁自律承诺书</h2>
			<p>
				作为“<label id="projectNames" class="page-input"></label>”项目的验收专家组成员，
				谨在此郑重承诺：
			</p>
			<p>
				1.严格遵守《中华人民共和国保密法》、《太原市科技计划项目验收管理办法》、《太原市科技计划项目经费管理办法》等国家、省、市科技项目管理的法律法规。
			</p>
			<p>
				2.客观、公正地履行职责，遵守职业道德，严格按照科技项目管理等相关的法律、法规和《太原市科技项目计划任务书》中的主要指标进行评审评价。
			</p>
			<p>
				3.履行相关的保密义务，遵守评估纪律，不私下接触项目承担单位和个人，不收受他人的财物或其他好处，不泄露项目单位的技术内容或其他情况。
			</p>
			<p>
				4.如有违反上述承诺的行为发生，自愿接受有关部门处理。
			</p>
			<p>
				特此承诺！
			</p>
			
			<div>
				承诺人（签名）：
				<div class="person-signatrue">
					<img id="autonomy-signature"/>
				</div>
				<br clear="all" />
			</div>
			<p class="page-date">承诺日期:&nbsp;<%=sdf.format(new Date(System.currentTimeMillis())) %></p>
		</article>
		<div class="hidden-info" style="width: 800px;margin-left: 58px;margin-top: 20px; margin-bottom:15px;">
			<form id="signForm" action="signCommitmentAction.action" method="post">
				<input type="hidden" id="meetingId" name="meetingId" value="${param.meetingId }"/>
				<input type="hidden" id="specialistId" name="specialistId" value="${param.specialistId }"/>
				<input type="hidden" name="isPromise" id="promise"/>	
				<input type="radio" class="agreement_sign_ok" id="agreement_sign_ok1" style="margin-left:0px;" name="isAgree" value="1" checked="checked"/><span><strong>同意 我已认真阅读相关规定</strong></span>
				<input class="no_agreement_sign" type="radio"  id="no_agreement_sign1" name="isAgree" value="0"/><span><strong>不同意 我已认真阅读相关规定</strong></span>
			</form>
		</div>
		<!--回避承诺书-->
		<article class="page-title">
			<h2>验收专家回避承诺书</h2>
			<p>本人担任“<label id="projectNameSet" class="page-input"></label>”项目的验收专家组成员。本人郑重承诺，有下列情形之一的，应主动申请回避，如有违反，同意取消本人验收专家资格，并承担相应的法律责任：</p>
			<p>1.项目承担单位主要负责人的近亲属；</p>
			<p>2.项目主管部门或监督管理部门的人员；</p>
			<p>3.与项目承担单位有其他社会关系或者经济利益关系，可能影响对验收公正评审的；</p>
			<p>4.其他依法应当回避的人员。</p>
			<p>
				特此承诺！
			</p>
			
			<div>
				承诺人（签名）：
				<div class="person-signatrue">
					<img id="promise-signature"/>
				</div>
				<br clear="all" />
			</div>
			<p class="page-date">承诺日期:&nbsp;<%=sdf.format(new Date(System.currentTimeMillis())) %></p>
		</article>
		<div class="hidden-info" style="width: 800px;margin-left: 58px;margin-top: 20px;">
			<input class="agreement_sign_ok" id="agreement_sign_ok2" type="radio"  style="margin-left:0px;" name="promise" value="1" checked="checked" /><span><strong>同意 我已认真阅读相关规定</strong></span>
			<input class="no_agreement_sign" id="no_agreement_sign2" type="radio"  name="promise" value="0"/><span><strong>不同意 我已认真阅读相关规定</strong></span>
		</div>
		<div class="margin-info">
			<button class="btn btn-default save_btn_width floatR saveSign" style="margin-right:58px;" id="sign_commit_ok">签订</button>
			<button class="btn btn-default save_btn_width floatR backToLast">返回</button>
			<div class="clear"></div>
		</div>
	</div>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>

	<div class="modal fade" id="input_signature_pass">
		 <div class="modal-dialog">
			   <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title">请输入签名密码</h4>
			      	</div>
		      		<div class="modal-body">
			        	<div class="sleader_modal_body"  style="margin-bottom:10px;">
				      		<div class="input_info_group">
				      			<div class="group_left" style="margin-left:80px;">签名密码</div>
				      			<div class="group_right" style="margin-left:90px; paddding-right: 30px">
				      				<input type="password" id="enter_signature_pass" class="clear_content" value=""/>
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<!-- 隐藏域 -->
				      		<div class="input_info_group" style="display:none">
				      			<div class="group_left" style="margin-left:80px;">专家设置的签名密码</div>
				      			<div class="group_right" style="margin-left:90px; paddding-right: 30px">
				      				<input type="text" id="real_signature_pass" class="clear_content" value=""/>
				      			</div>
				      			<div class="clear"></div>
				      		</div>				      		
		     	 		</div>
			      	 	<div class="modal-footer">
			      	 		<button type="button" class="btn btn-default modal_btn check_signature_pass">确定</button>
			        		<button type="button" class="btn btn-default modal_btn signature_pass_close" data-dismiss="modal">关闭</button>		        
			      	 	</div>
		     	 	</div>					
	   	  	   </div><!-- /.modal-content -->
	   	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	
</body>
</html>
