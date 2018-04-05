package com.runoob.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class writeData
 */
@WebServlet("/writeData")
public class writeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//设置response码表，控制response以什么码表向浏览器输出信息
	response.setCharacterEncoding("utf-8");
	
	//控制浏览器以什么码表打开数据，一下两种二选一
	response.setHeader("content-type", "text/html;charset=utf-8");
	
	
	
	//这个可以单独使用，代替以上两种
//	response.setContentType("text/html;charset=utf-8");
	String data="中国";
	//字符流，只能输出字符，不能输出视频等
	PrintWriter out=response.getWriter();
	out.write(data);
	out.write(data);
	
//	字节流需变为字节，能输出视频等
//	response.getOutputStream().write(data.getBytes("utf-8"));  //需要编码格式
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
