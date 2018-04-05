<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<script type="text/javascript">
/************客户端JS防止重复提交表单方法一
 
 var isSubmit=false;
function dosubmit(){
if(!isSubmit){    isSubmit=true;
                  return true;}
else{return false;}
	
}
************/
//第二中方法设置表单的提交按钮点击一次后不能点击,document后面没括号，刷新跟后退同样可以重复提交。
function dosubmit(){
	
    document.getElementById("ss").disabled='disabled';
    alert("HH");
	return true;
}
</script>
</head>
<body>
<form action="/Servlet/lOGIN1"  method="post" onsubmit="return dosubmit()">
用户名 :<input type="text" name="name"><br/><br/>
<input id="ss" type="submit" value="提交" >
</form>
</body>
</html>