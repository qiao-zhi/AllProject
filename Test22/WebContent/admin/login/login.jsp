<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
  <head>
    <base href="<%=basePath%>">
    <title>登陆界面</title>
    
    <script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/load/load.css" />
	<script type="text/javascript" src="js/public/jquery.validate.js"></script>
	<link rel="prefetch" href="admin/host/host_meeting.jsp" />
    <script type="text/javascript">
    
    $(function(){
    	$("#load_form").validate({
			
            rules: { 
            	'username':{required: true}, //姓名,minlength:4,maxlength:15
            	'password':{required: true,minlength:6,maxlength:16}, //姓名
            },
            messages: {
                'username':{required: '用户名不能为空'}, //姓名	  ,minlength:'长度为4-15个字符',maxlength:'长度为4-15个字符'
                'password':{required: '请输入密码' ,minlength:'长度为6-16个字符',maxlength:'长度为6-16个字符'}, //姓名	 
            },
            errorClass: "error",
            success: 'valid',
            unhighlight: function (element, errorClass, validClass) { //验证通过
                $(element).removeClass(errorClass);
            },
            errorPlacement: function (error, element) {               	
            	/* var $error = "" */
            	error.appendTo(element.parent().next().children());                  
            },                      
            submitHandler: function (form) {
              	form.submit();
            }
    	});
    });
	$(document).ready(
			function() {
				$("#vReset").click(
						function() {
							$("#pcode").val("");
							$("#vImage").attr(
									"src",
									"verify.action?timestamp="
											+ new Date().getTime());
						});
				
				$("#load_save").click(function(){
					alert("哈哈");
				});
				
				var cookies = document.cookie.split(";");
			   	for(var i=0;i<cookies.length;i++) {
			    var cookie = cookies[i];
			    var cookieStr = cookie.split("=");
			    if(cookieStr && cookieStr[0].trim()=="loginName") {
			      var a = decodeURI(cookieStr[1]);
				  $("#username").val(a);
    }
   }
				
			});
</script>
  </head>
  
  <body>
    <div>
			<div class="load_title ">
				<div class="container"><h1>科技项目评估评价及专家会议评审系统</h1></div>
				
			</div> 
			<div class="load_body">
				<div class="container body_content" id="lzw">
					<div class="load_body_right">
						<div></div>
							<form class="load_form" method="post" action="login.action" id="load_form" >
								<div>
									<label>用户账号</label>
									<input type="text" class="form-control" name="username" id="username" value="" />
									
								</div>
								<div style="color:red;height:16px;margin-bottom:3px">
										<%-- <s:actionerror/> --%>
										<span>${session.msg }</span>
									</div>
								<div>
									<label>密码</label>
									<input type="password" class="form-control" name="password" value="${cookie.loginPassw.value }"/>									
								</div>
								<div style="color:red;height:16px;margin-bottom:3px">
										<span></span>
								</div>
								<div class="check_code">
									<span class="float_left">验证码</span>
									<div class="clear"></div>
									<div class="check_code_left">
										<input type="text" class="form-control" name="pCode" id="pcode"/>
									</div>									
									<div class="check_code_right">
										<img src="verify.action" id="vImage" /> 
										<a href="javaScript:void(0)" style="color: #FBFBFB;" id="vReset">看不清楚,换一张</a>
									</div>
									
									<div class="clear"></div>
								</div>
								
								<div class="sub_btn">
									<input type="checkbox" name="isChecked" value="yes" ${cookie.loginPassw.value==null?"":"checked"}/><span>记住密码</span>
									<button type="submit" class="btn btn-lg btn-block" style="background-color:rgb(30,150,200)">登录</button>
									<!-- <a href="#" class="floatL">忘记密码?</a>
									<a href="#" class="floatR">注册</a> -->
								</div>
							</form>
					</div>
				</div>
			</div>
		</div>
		<footer class="foot" >
			<p class="info">Copyright © 2015-2016 ThinkPro. All Rights Reserved.&nbsp;&nbsp;&nbsp;科技项目评估评价及专家会议评审系统   技术支持联系方式：0351-6998011</p>
			<p class="info">版权所有 备案证号：晋ICP备050024564号</p>
		</footer>
	
	
  </body>
  <script>
  window.onload = function(){
				// 获取窗口宽度
				var winWidth;
				if (window.innerWidth)
				winWidth = window.innerWidth;
				else if ((document.body) && (document.body.clientWidth))
				winWidth = document.body.clientWidth;
				// 获取窗口高度
				if (window.innerHeight)
				winHeight = window.innerHeight;
				else if ((document.body) && (document.body.clientHeight))
				winHeight = document.body.clientHeight;
				// 通过深入 Document 内部对 body 进行检测，获取窗口大小
				if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth)
				{
				winHeight = document.documentElement.clientHeight;
				winWidth = document.documentElement.clientWidth;
				}	
				
				document.getElementById("lzw").style.height = winHeight - 350+ 'px';
				var browser=navigator.appName
	  var b_version=navigator.appVersion
	  var version=b_version.split(";");
	  var trim_Version=version[1].replace(/[ ]/g,"");
	  if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE6.0")
	  {
	  alert("IE 6.0");
	  }
	  else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE7.0")
	  {
	  alert("IE 7.0");
	  }
	  else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE8.0")
	  {
	  alert("IE 8.0");
	  }
	  else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0")
	  {
	  alert("IE 9.0");
	  }
				
			}
  </script>
</html>
