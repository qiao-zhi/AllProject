<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>从数据库读取路径显示图片</title>
</head>
<body>
<%--items用于迭代的变量，var代表每次迭代之后存放名字 --%>
<c:forEach items="${userList }" var="user"> 
  <img alt="" src="${path}${user.picture}" style="width:120px;height:100px">
</c:forEach>


</body>
</html>