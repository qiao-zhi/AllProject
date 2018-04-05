package com.runoob.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * Servlet implementation class ReadProperties
 */
@WebServlet("/ReadProperties")
public class ReadProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadProperties() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    InputStream in=this.getServletContext().getResourceAsStream("db.properties");//第一个/代表工程目录
    Properties pro=new Properties();
    pro.load(in); 
    
    System.out.println(pro.getProperty("driver"));
    System.out.println(pro.getProperty("url"));
    System.out.println(pro.getProperty("username"));
    System.out.println(pro.getProperty("password"));


									
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
