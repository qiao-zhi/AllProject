package com.runoob.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServletConfig
 */
@WebServlet(
		urlPatterns = { "/TestServletConfig" }, 
		initParams = { 
				@WebInitParam(name = "Data", value = "XXXX"), 
				@WebInitParam(name = "Data1", value = "YYYY")
		})
public class TestServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private ServletConfig servletConfig;
    public TestServletConfig() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getOutputStream().write(("SS").getBytes());
		Enumeration e=this.getServletConfig().getInitParameterNames();
		System.out.println("SSSS"+this.getServletConfig().getInitParameter("Data"));
		System.out.println("SSSS"+this.getServletConfig().getInitParameter("Data1"));
		while(e.hasMoreElements()){
			System.out.println("SSSS");
			String Name=(String) e.nextElement();
			System.out.println(Name);
			String Value=this.getServletConfig().getInitParameter(Name);
			System.out.println(Value);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	
	

}
