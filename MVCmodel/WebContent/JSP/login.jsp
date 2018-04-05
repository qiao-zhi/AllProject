<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8">
		<title></title>
	        <link type="text/css" rel="stylesheet" href="/MVCmodel/JSP/CSS/login.css"/>
	</head>
	<body>
		<div id="container">
              
              
              <div id="loginForm">
            
                  	
                  <br/> <br/> <br/>
                  
                  <form action="${pageContext.request.contextPath }/Login" method="post">
                  <span>用户名:</span> <input type="text" name="username" id="username" value="" /><br/><br/>
                    <span>密&nbsp;&nbsp;&nbsp;码: </span> 	<input type="password" name="password" id="" value="" /><br/><br/>
                      <span>验证码:</span> <input  type="text" name="checkcode" id="checkcode" value="" /><br/><br/>
                   <input type="submit"  class="btn" value="登录" />
                   <input type="button"  class="btn" value="注册" onclick="window.location='${pageContext.request.contextPath}/JSP/register.jsp'"/><br/><br/>
                 </form>
                    <span id="footer">如果没有账号请先注册！</span>
             
              </div>

              
              

		</div>								
	</body>
</html>