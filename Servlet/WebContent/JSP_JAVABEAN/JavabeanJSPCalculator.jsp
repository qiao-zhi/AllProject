<%@page import="javabean.Calculator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>简单的计算器</title>
</head>
<body style="text-align: center;">
    <%--封装对象，根据表单的参数直接封装给对象 --%>
   <jsp:useBean id="calculatorBean" class="javabean.Calculator" scope="page"/>
   <jsp:setProperty name="calculatorBean" property="*"/> 
   <% 
   try{calculatorBean.calculate();
   }
   catch(Exception e){
	   out.write(e.getMessage());}
   %>
    


    <%--处理接收的请求表单封装为Calculator对象计算结果 --%>
    <br/>--------------------------------------------------------------------<br/>
  计算结果:
    <jsp:getProperty name="calculatorBean" property="firstNum"/>
        <jsp:getProperty name="calculatorBean" property="operator"/>
        <jsp:getProperty name="calculatorBean" property="secondNum"/> 
        =
        <jsp:getProperty name="calculatorBean" property="result"/>                 
     <br/>--------------------------------------------------------------------<br/>
    
    <form action="/Servlet/JSP_JAVABEAN/Calculator(JSP+JavaBean).jsp">
    <table width="40%" border="1" height="60%" style="margin-left: 400px;margin-top: 50px;">
    
    <tr>
       <td colspan="2">
              简单的计算器
       </td> 
     </tr>
     <tr>
       <td>
                         第一个参数：
       </td> 
       <td>
           <input type="text" name="firstNum">
       </td>
     </tr>
     
    <tr>
       <td>
                      操作符
       </td> 
       <td>
       <select name="operator">
       <option value="+">+</option>
       <option value="-">-</option>
       <option value="*">*</option>
       <option value="/">/</option>
       </select >
       </td>
     </tr>
 
     <tr>
       <td>
                         第二个参数：
       </td> 
       <td>
           <input type="text" name="secondNum">
       </td>
     </tr>        
     
     <tr>
       <td colspan="2">
           <input type="submit" value="计算"/>
       </td>
     </tr>        
          
     
    </table>
    </form>
    
</body>
</html>