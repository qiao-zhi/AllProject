<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<body>
<%
application.setAttribute("basePath", application.getContextPath());
%>
<form action="${basePath}/fileUpload.action" enctype="multipart/form-data" method="post">
 <input type="file" name="imageUpload">
 <input type="file" name="imageUpload">
 <input type="file" name="imageUpload">
 <input type="submit" value="上传">

</form>


</body>
</html>