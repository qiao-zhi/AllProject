package com.runoob.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoRefresh
 */
@WebServlet("/AutoRefresh")
public class AutoRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AutoRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Test2(response);
   
		
		//利用ServletContext对象实现跳转，利用html的meta标签模拟一个头。转向message.jsp处理
		String s = "<meta http-equiv='Refresh' content='3;url=/Servlet/1.jsp'>恭喜你，登录成功，三秒后将跳转到首页，如果没有跳转，请<a href=''>点击跳转</a>";
		this.getServletContext().setAttribute("message", s);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		
		
//		ResreshEvery3S(response);
		
	}


	//处理登陆成功之后，跳转到另一个页面
	private void Test2(HttpServletResponse response) throws IOException {
		//假设这是一个登陆处理界面
		
		
		//假设到这里登陆成功了	
		
		//3s后跳转到另一个页面
	    response.setHeader("Refresh", "3;url='/Servlet/1.jsp'");
		String s = "恭喜你，登录成功，三秒后将跳转到首页，如果没有跳转，请<a href=''>点击跳转</a>";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		response.getWriter().write(s);
	}


	private void ResreshEvery3S(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "1");
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
		response.getWriter().write(s.format(d));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
