<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>footer</title>
	<!-- <script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" /> -->
	<link rel="stylesheet" href="css/home/footer.css" />

  </head>
  
  <body>
	<footer class="footer">
			<div class="center">Copyright © 2015-2016 Tencent. All Rights Reserved.科技计划项目电子辅助验收及评估平台   技术支持联系方式：0351-6998011</div>
			<div class="center">版权所有 备案证号：晋ICP备050024564号</div>
	</footer>
  </body>
</html>