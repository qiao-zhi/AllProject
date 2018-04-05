package it.qlq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlq.Utils.Constant;
import it.qlq.javabean.Pager;
import it.qlq.javabean.Student;
import it.qlq.service.StudentServiceImpl;


public class sublistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sublistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取页号
		int pageNum = Constant.DEFAULT_PAGE_NUM;
		String pageNumStr = request.getParameter("pageNum");
        if(pageNumStr!=null&&!pageNumStr.trim().equals("")){
        	pageNum = Integer.parseInt(pageNumStr);
        	System.out.println(pageNum);
        }
		
		//
		int pageSize = Constant.DEFAULT_PAGE_SIZE;
		Pager<Student> result = (new StudentServiceImpl()).findStudent(pageNum, pageSize);
		//返回结果
		request.setAttribute("result", result);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
