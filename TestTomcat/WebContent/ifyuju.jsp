<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大杂烩</title>
<link href="ifyuju.css" rel="stylesheet">
</head>
<body>
<p id="p1">这是一个测试if语句的例子。</p>
<%! int i=2; %>
<%if(i==3){
	out.print("<p style=\"color:red\">"+"星期三"+"</p>");	
} else{out.print("<p style=\"color:green\">"+"不是星期三！"+"</p>");}

%>


</body>
</html>