<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>pageContext隐式对象</title>
</head>
<body>

<% request.setAttribute("data", "name"); %>
   <h2>${data}</h2><!-- el表达式，直接取域中名字为data对象 -->
<br/>

<%--使用pageContext访问其他域中的对象,引入和包含其他资源 --%>>
<% out.write((String)pageContext.findAttribute("data")); %>
<%pageContext.include("/1.jsp"); %>
<%pageContext.forward("/1.jsp"); %>


</body>
</html>