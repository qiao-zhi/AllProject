package com.runoob.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;


@WebServlet("/RequestMethod")
public class RequestMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RequestMethod() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());   //资源名称
		System.out.println(request.getRequestURL());  //完整d互联网资源
		System.out.println(request.getQueryString());  //参数部分
		System.out.println(request.getRemoteAddr());   //客户机的ip
		System.out.println(request.getRemoteHost());   //客户机d 完整主机名
		System.out.println(request.getRemotePort());//请求时
		System.out.println(request.getLocalAddr());//服务器Ip地址
		System.out.println(request.getLocalName());//服务器完整名字（DNS注册过，未注册为ip地址）
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
