package com.runoob.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runoob.dao.UserDao;


//需要把驱动包放入tomcat服务器下的lib文件夹内

@WebServlet("/ConnectDB")
public class ConnectDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConnectDB() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().write("SSSSSSSS");
		UserDao user=new UserDao();
	user.find();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
