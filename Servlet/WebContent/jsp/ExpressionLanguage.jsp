<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>El表达式测试</title>
</head>
<body>

<%request.setAttribute("username", "nicai"); %>
<%request.setAttribute("age", "50"); %>

${username}
<br/>-------------<br/>
姓名：${requestScope.username}<br/>
年龄：${requestScope.age+1}     <%//输出年龄为51 %>

</body>
</html>