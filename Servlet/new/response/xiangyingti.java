package response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* @author: qlq
* @date :  2017年7月5日下午6:42:12
* @description:设置响应体，也就是输出内容
 */

@WebServlet("/xiangyingti")
public class xiangyingti extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置response查询的码表
		//response.setCharacterEncoding("UTF-8");
		
		//通过一个头 Content-Type 告知客户端使用何种码表
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
//		这句与上句等价，开发中只用写这句，tomcat自动设置第一句
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		//writer.write("hello response!!!");
		writer.write("你好");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
