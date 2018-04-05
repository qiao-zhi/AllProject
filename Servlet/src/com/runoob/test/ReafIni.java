package com.runoob.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.FileInfo;

/**
 * Servlet implementation class ReafIni
 */
@WebServlet("/ReafIni")
public class ReafIni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReafIni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /******************第一中
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/database.properties");//第一个/代表工程目录
    Properties pro=new Properties();
    pro.load(in);     
    System.out.println(pro.getProperty("driver"));
    System.out.println(pro.getProperty("url"));
    System.out.println(pro.getProperty("username"));
    System.out.println(pro.getProperty("password"));
    ***************/

		
		
		//读取资源绝对路径
		String realPath=this.getServletContext().getRealPath("/database.properties");
		System.out.println(realPath);
		
		//读取资源名字
		String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		FileInputStream in= new FileInputStream(realPath);
		Properties pros=new Properties();
				pros.load(in);
		System.out.println(pros.getProperty("url"));
									
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}