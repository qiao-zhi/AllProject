<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%

out.println(request.getAttribute("username"));
%>
Success!
<br/>
<form action="http://localhost:8080/SSM/user/user22.action" method="post">
<input type="text" name="name">
<input type="submit" value="tijiao">
</form>
</body>
</html>