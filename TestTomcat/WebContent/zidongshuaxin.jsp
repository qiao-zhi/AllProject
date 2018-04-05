<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>自动刷新实例</title>
</head>
<body>

<h2>自动刷新实</h2>
<%
   // 设置每隔5秒刷新一次
   response.setIntHeader("Refresh", 1);
   // 获取当前时间
   Calendar calendar = Calendar.getInstance();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("当前时间为: " + CT + "\n");
   
   Date d=new Date();
   String s="ss";
   String ss=String.format("%1$tT ",d);
   out.print("<br/>"+ss);
   
%>

</body>
</html>