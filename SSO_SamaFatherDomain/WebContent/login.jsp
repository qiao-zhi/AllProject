<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="qlq">
  <meta name="Keywords" content="">
  <meta name="Description" content="单点登录的界面">
  <title>登录界面</title>
 </head>
 <body>
	<center>
		<h3>请登录</h3>
		<form action="http://check.x.com:8080/sso/login.action"  method="post">
			用户名:<input type="text" name="username" value="user"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			密码:<input type="password" name="password" value="123"/>
			<input type="hidden" name="gotoUrl" value="${gotoUrl}"/>
			<input type="submit" value="登录"/>
		</form>
	</center>
 </body>
</html>

