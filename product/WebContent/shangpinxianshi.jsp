<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>从数据库读取路径显示图片</title>
</head>
<body style="text-align: center;padding: auto;">

<%--items用于迭代的变量，var代表每次迭代之后存放名字 --%>

	<div style="margin:0px auto;text-align: center;">
		<table border="1px" cellspacing="0px" align="center" cellpadding="0px">
			<tr>
				<th>id</th>
				<th>姓名:</th>
				<th>图片</th>
				<th>密码</th>
			</tr>
		<c:forEach items="${userList }" var="user">
			<tr>
				<th>${user.id}</th>
				<th>${user.name}</th>
				<th><img alt="" src="${path}${user.picture}" style="width: 180px; height: 120px"></th>
				<th>${user.password}</th>
			</tr>
			
		</c:forEach>

		</table>

    </div>
</body>
</html>