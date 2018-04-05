<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
<a href="/Struts/user/helloword.action?message=helloQQQ">helloword.action</a><br/>
<a href="/Struts/user/demo1.action">demo1.action</a><br/>
<a href="/Struts/user/forward.action">转发</a><br/>
<a href="/Struts/user/redirect.action">重定向</a><br/>
<a href="/Struts/user/redirectAction1.action">重定向到本命名空间</a><br/>
<a href="/Struts/user/redirectAction2.action">重定向到另外一个命名空间</a><br/>
<a href="/Struts/user/source.action">查看页面源码</a><br/>
<a href="/Struts/user/global1.action">跳到全局页面</a><br/>
<a href="/Struts/user/global2.action">跳到自己优先级高的页面</a><br/>
<a href="/Struts/product/product_add.action">product_Add</a><br/>
<a href="/Struts/product/product_delete.action">product_Delete</a><br/>
<a href="/Struts/product/product1!add.action">product1_Add(!)</a><br/>
<a href="/Struts/product/product1!delete.action">product1_Delete(!)</a><br/>
<form action="/Struts/product/getAttr1.action" method="post">
名字:<input type="text" name="user.username" value="${username}"/><br/>
密码:<input type="password" name="user.password" value="${password}"/><br/>
年龄:<input type="text" name="user.age" value="${age}"/><br/>
生日:<input type="text" name="user.birthday" value="${birthday}"/><br/>
<input type="submit" value="提交"/><br/>

</form>

</body>
</html>