<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎访问Demo1的主页</title>
</head>
<body>
	欢迎访问Demo1的主页，这是Demo1的主页。~~~~~~~~~~~~~~~~~~
	<!--成功之后隐藏一个设置cookie的连接  -->
	<c:forEach var="url" items="${hiddenurls }">
		<iframe src="${url }" width="0px" height="0px" style="display: none"></iframe>
		${url }
	</c:forEach>
</body>
</html>