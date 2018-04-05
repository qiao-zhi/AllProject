package com.runoob.thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SingleSelectionModel;

/**
 * 线程安全问题,不用编写web.xml文件，加注解
 */
@WebServlet(urlPatterns = { "/threadSafe2" })
public class threadSafe2 extends HttpServlet implements SingleThreadModel{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	int i = 0;
    public threadSafe2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		
		
		//单线程访问，this代表这个类对象即threadSafe
		
			
			
			i++;
			response.setCharacterEncoding("GBK");
			
//			//第一种向浏览器输出方式，只能单独使用输出一次
//		response.getOutputStream().write((i+"第一种方法").getBytes());
		
		try {
			Thread.sleep(1000*4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			//第二种方法输出到浏览器
			response.getWriter().write("第二种方法\n");
			
			
			//第三种方法，可以同第二种一起使用
	     	PrintWriter out=response.getWriter();
			out.println(i+"  "+"线程安全"+"第三种方法");
			
			
		}
		
	
		
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
