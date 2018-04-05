<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=iso-8859-1" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
 <base href="<%=basePath%>">
<title>print</title>

</head>

<body>
			
		<%   
			 out.clear();
			 out = pageContext.pushBody();
			 
			 response.setContentType("application/x-download");
			 response.setCharacterEncoding("iso-8859-1");
			 String filedownload = request.getParameter("pdfPath");
			  
			 
			 String filedisplay = "审计.pdf";
			 filedisplay = URLEncoder.encode(filedisplay,"utf-8");
			 //response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);
			 response.setHeader("Content-Disposition", "attachment;filename=" + filedisplay);
			 
			
			 try
			 {
				File parent = new File(filedownload);
				File[] files = parent.listFiles();
				int size = files.length;
				
				FileInputStream in = null;
				byte[] bytes = new byte[1024];
				int lena = -1;
				OutputStream os = response.getOutputStream();
				for(int i = 0; i < size; i++) {
					in = new FileInputStream(files[i].getName());
					while((lena = in.read(bytes)) != -1) {
						os.write(bytes, 0, lena);
					}
				} 
									 
				/* RequestDispatcher dis = application.getRequestDispatcher(filedownload);
				 
				 if(dis!= null)
				 {
			 		dis.forward(request,response);
			 	 }
				 response.flushBuffer();*/
			 } catch(Exception e) {
			 	e.printStackTrace();	
			 }
		%> 

 
 
</body>
</html>
