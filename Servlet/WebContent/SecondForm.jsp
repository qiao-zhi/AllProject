<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Servlet/lOGIN2" method="post">
用户名：<input type="text"><br/><br/>
密码：<input type="password"><br/>
<input type="hidden"  name="hid" value="<%= request.getSession().getAttribute("rand") %>">
<input type="submit" value="提交">



</form>



</body>
</html>