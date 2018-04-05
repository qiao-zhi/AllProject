<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

上传成功


<div style="margin:0px auto;text-align: center;">
		<table border="1px" cellspacing="0px" align="center" cellpadding="0px">
			<tr>
				<th>题干</th>
				<th>类型</th>
				<th>A</th>
				<th>B</th>
				<th>C</th>
				<th>D</th>
				<th>答案</th>
				<th>解析</th>
			</tr>
		<c:forEach items="${list }" var="ques">
			<tr>
				<th>${ques.timu}</th>
				<th>${ques.leixing}</th>
				<th>${ques.axuanxiang}</th>
				<th>${ques.bxuanxiang}</th>
				<th>${ques.cxuanxiang}</th>
				<th>${ques.dxuanxiang}</th>
				<th>${ques.daan}</th>
				<th>${ques.jiexi}</th>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>