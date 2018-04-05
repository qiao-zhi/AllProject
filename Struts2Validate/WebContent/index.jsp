<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<s:fielderror></s:fielderror>
<form action="/Struts2Validate/user/user_login.action" method="post">
姓名:<input type="text" name="username" />
<br/>
密码:<input type="password" name="password"/>
<br/>
电话:<input type="text" name="mobile" />
<br/>
<input type="submit" value="登录"/>
</form>
<br/>
<a href="/Struts2Validate/user/user_update.action">update</a>
</body>
</html>