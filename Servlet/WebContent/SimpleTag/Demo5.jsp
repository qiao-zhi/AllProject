<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.Date" %>
  <%@ taglib uri="/WEB-INF/SimpleTag.tld"  prefix="sitcast"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>带属性的标签(一个标签可带好几个属性)</title>
</head>
<body>
<sitcast:Demo5 count="5" date="<%=new Date() %>">77777<br/></sitcast:Demo5>


</body>
</html>