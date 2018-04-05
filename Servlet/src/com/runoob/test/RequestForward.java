package com.runoob.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestForward")
public class RequestForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RequestForward() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data="data";
		request.setAttribute("name", data);
		request.getRequestDispatcher("/RequestForward.jsp").forward(request, response);
		
		
		
		
//		luanMa(request, response);
				
		
	}


	private void luanMa(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		//该方法防止method=post乱码，对get方法无效
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String method=request.getMethod();
		
		
//1和2共同使用防止中文乱码，3单独使用即可防止中文乱码（防止GET方法乱码）
//		response.setContentType("text/html;chatser=utf-8");              //1
//		response.setCharacterEncoding("utf-8");                          //2
		response.setHeader("content-type", "text/html;charset=utf-8");  //3
		response.getWriter().write(new String(name.getBytes("iso8859-1"),"UTF-8"));
		response.getWriter().write(method);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
