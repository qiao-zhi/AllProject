<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% String url2=response.encodeURL("/Servlet/GetSession");
String url1=response.encodeURL("/Servlet/SetSession");
   %>>

<a href='<%=url1 %>'>GOUMAI</a>
<% out.println(); %>>
<a href='<%=url2 %>'>JIEZHANG</a>


</body>
</html>