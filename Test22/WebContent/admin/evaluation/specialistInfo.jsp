<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<title>专家基本信息修改</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script type="text/javascript" src="controls/fileUpload/ajaxfileupload.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/experts/expert_ui.css" />
<link rel="stylesheet" href="css/iframe/index.css" />
<link rel="stylesheet" href="css/experts/personal_info_fix.css" />
<link rel="stylesheet" href="css/experts/experts.css" />
<script type="text/javascript" src="js/experts/personal_info_fix.js" ></script>

<script type="text/javascript" src="js/experts/specialistInfo.js"></script>
<script type="text/javascript" src="js/public/jquery.validate.js"></script>
<script type="text/javascript"
	src="controls/jeDate-gh-pages/jedate/jedate.js"></script>
</head>

<body>
	<jsp:include page="evaluation_nav.jsp" />
	<div style="background-color: #F5F5F5;">
		<div class="container">
			<ol class="breadcrumb experts_ol_left">
			  	<li><a href="admin/evaluation/specialist_evaluation.jsp">首页</a></li>				  	
			  	<li class="active">个人信息维护</li>
			</ol>
		</div>
	</div>
	<!--个人信息-->
	<form id="specialistBaseInfo" action="updateSpecialistInfoAction.action" method="post">
		<div style="width: 1024px; background-color: #FBFBFB;margin: 0 auto;padding-bottom: 20px;">
				<div class="hr"></div>
				<div class="personal_detail_info">					
					<div class="left_title column">
						<div class="word_box">
							基本信息
						</div>
					</div>
					<div class="right_body column">
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>姓名</label>
							</div>
							<div class="box_margin_right">
								<input type="text" class="form-control none_border_radius" id="name" name="specialist.name" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>性别</label>
							</div>
							<div class="box_margin_right" style="height:;line-height:34px">
								<!-- <input type="text" class="form-control none_border_radius" id="sex" name="specialist.sex" value="" /> -->
								<input type="radio" name="specialist.sex" class="s_sex" value="男"/><label style="margin-left:3px;margin-right:8px;">男</label>
								<input type="radio" name="specialist.sex" class="s_sex" value="女"/><label style="margin-left:3px">女</label>
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>出生年月</label>
							</div>
							<div class="box_margin_right">
							
								<input type="text" id="birthday" maxlength="10" onfocus="$(this).calendar()" name="specialist.birthday"  readonly class=" datainp form-control"/>
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
							
								<label>简介</label>
							</div>
							<div class="box_margin_right">
								<textarea style="border: 1px solid #ccc;" class="box_margin_right_textarea" placeholder="简介内容选填..."></textarea>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="hr"></div>
				<div class="profession_detail_info">
					<div class="left_title column2"><div class="word_box">职业信息</div></div>
					<div class="right_body column2">
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>工作单位</label>
							</div>
							<div class="box_margin_right">
								<input type="text" class="form-control none_border_radius" id="workUnit" name="specialist.workUnit" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>从事专业</label>
							</div>
							<div class="box_margin_right">
								<input type="text" class="form-control none_border_radius" id="engageDomain" name="specialist.engageDomain" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>职务</label>
							</div>
							<div class="box_margin_right">
								<input type="text" class="form-control none_border_radius" id="duty" name="specialist.duty" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>职称</label>
							</div>
							<div class="box_margin_right">
								<input type="text" class="form-control none_border_radius" id="title" name="specialist.title" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="clear"></div>
					
				</div>
				<div class="hr"></div>
				<div class="relation_detail_info">
					<div class="left_title column3"><div class="word_box">联系信息</div> </div>
					<div class="right_body column3">
						<div class="box_margin">
							<div class="box_margin_right">
								<input type="hidden" class="form-control none_border_radius" id="oldResultTip" value="<s:property value='#session.oldResultTip'/>"/>
								<input type="hidden" class="form-control none_border_radius" id="newResultTip" value="<s:property value='#session.newResultTip'/>" />
								<%
									Map<String, Object> sessionMap = ActionContext.getContext().getSession();
									String oldResultTip = (String)sessionMap.get("newResultTip");
									if(oldResultTip != null && !"".equals(oldResultTip)) {
										sessionMap.put("oldResultTip", oldResultTip); 
									} else {
										sessionMap.put("oldResultTip", "信息修改成功!&" + System.currentTimeMillis());
									}
								%>
							</div> 
							<div class="clear"></div>
						</div>					
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>电话号码</label>
							</div>
							<div class="box_margin_right">
								<input type="text" class="form-control none_border_radius" id="telephone" name="specialist.telephone" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_left">
								<em>*</em>
								<label>邮箱</label>
							</div>
							<div class="box_margin_right">
								<input type="email" class="form-control none_border_radius" id="email" name="specialist.email" value="" />
							</div>
							<div class="floatL err_show">
								<span></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="box_margin">
							<div class="box_margin_right">
								<input type="hidden" class="form-control none_border_radius" id="specialistId" name="specialist.specialistId" value="" />
							</div> 
							<div class="clear"></div>
						</div> 
					</div>
					<div class="clear"></div>				
				</div>		
				<button type="submit" class="btn btn-default save_btn_width save_btn_color personal_save_btn save_specialistInfo">保存</button>
		</div>
	</form>
	<div class="hr"></div>
	<div style="width: 1024px; background-color:#FBFBFB;margin: 0 auto;padding-top: 1px;">
		<div class="signature_info">
			<div class="left_title column4"><div class="word_box">签名信息</div></div>
			<div class="right_body column4">
				<div class="fix_hide">
					<div class="signature_pic " id="old_img" >
						<img id="preview" width="370" height="170"/>
					</div> 
					<div class="signature_btn">							
						<button class="btn btn-default save_btn_width" id="fix_pic">修改签名照片</button>
						<button class="btn btn-default save_btn_width" data-toggle="modal" data-target="#fix_password_modal">修改签名密码</button>
					</div>
					<div class="clear"></div>
					<input id="headPortrait" type="file" name="signature" onchange="setImagePreview(1)" accept="image/*" />
					<div style="display:none"><input type="text" id="oldSignatureIndex" /></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="hr"></div>
	</div>
	<div class="hr"></div>
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	<!--修改密码-->
	<div class="modal fade" id="fix_password_modal" aria-hidden="true" data-backdrop="static">
	  	<div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-header word_center my_modal_title ">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">修改签名密码</h4>
		      	</div>
		      	
		      	<div class="modal-body">
		        	<div class="box_margin">
						<div class="box_margin_left">
							<em class="em">*</em>
							<label>原密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="oldPass" name="oldPass" value="" placeholder="无原始密码可不填写" />
						</div>
						<div class="clear"></div>
					</div>
					<div class="box_margin">
						<div class="box_margin_left">	
							<em class="em">*</em>						
							<label>新密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="newPass" name="newPass" value="" />
						</div>
						<div class="clear"></div>
					</div>
					<div class="box_margin">
						<div class="box_margin_left">
							<em class="em">*</em>
							<label>确认新密码</label>
						</div>
						<div class="box_margin_right">
							<input type="password" class="form-control " id="reNewPass" name="reNewPass" value="" />
							<em id="reNewPassTip" style="color:red"></em>
						</div>
						<div class="clear"></div>
					</div>
		      	</div>
		      	<div class="modal-footer">				        
			        <button type="button" class="btn btn-primary modal_btn updatePass" id="send_password">保存</button>
			        <button type="button" class="btn btn-default modal_btn cacelUpdatePass" data-dismiss="modal">取消</button>
		      	</div>
		      
		    </div><!-- /.modal-content -->
	  	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	
	<script>
	jeDate({
		dateCell:"#birthday",//isinitVal:true,
		format:"YYYY-MM-DD",
		isTime:false, //isClear:false,
		
	});
	    
    $(function(){
    	$("#specialistBaseInfo").validate({
		
               rules: { 
               	'specialist.name':{required: true,}, //姓名
               	'specialist.sex':{required: true,}, //性别
               	'specialist.birthday':{required: true,}, //year month        	
               	'specialist.workUnit':{required: true,}, //工作单位
               	'specialist.engageDomain':{required: true,}, //从事专业
               	'specialist.duty':{required: true,}, //职务
               	'specialist.title':{required: true,}, //职称
               	'specialist.telephone':{required: true,	digits:true,minlength:11,maxlength:12}, //电话号码
               	'specialist.email':{required: true,	email:true,}, //邮箱
               },
               messages: {
                   'specialist.name':{required: '不能为空' ,}, //姓名
                   'specialist.sex':{required: '请选择性别',}, //性别
                   'specialist.birthday':{required: '请选择出生年月',}, //year month 
               	'specialist.workUnit':{required: '不能为空',}, //工作单位
               	'specialist.engageDomain':{required: '不能为空',}, //从事专业
               	'specialist.duty':{required: '不能为空',}, //职务
               	'specialist.title':{required: '不能为空',}, //职称
               	'specialist.telephone':{required: '不能为空',	digits:'请输入整数的电话号码',minlength:'请输入正确的号码',maxlength:'请输入正确的号码'}, //电话号码
               	'specialist.email':{required: '不能为空',	email:'请输入正确的email格式',}, //邮箱
               },
               errorClass: "error",
               success: 'valid',
               unhighlight: function (element, errorClass, validClass) { //验证通过
                   $(element).tooltip('destroy').removeClass(errorClass);
               },
               errorPlacement: function (error, element) {               	
               	/* var $error = "" */
               	error.appendTo(element.parent().next().children());                  
               },                      
               submitHandler: function (form) {
               	console.log("Validate for specialist info is starting!");
               	/* $("#specialistBaseInfo").submit(); */  // 不能使用jquery该方式提交表单数据，会造成死循环
               	form.submit();
               	console.log("Updating specialist info is ok!");
               }
       	});
       	
       	/* fix password modal */
       	
    });
	</script>
	</body>
</html>
