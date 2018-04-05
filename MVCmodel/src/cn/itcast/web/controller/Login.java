package cn.itcast.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BussinessService;
import cn.itcast.service.imp.BussinesServiceImp;
import cn.itcast.web.utils.ServiceMD5;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		BussinessService bs=new BussinesServiceImp(); 
		User user=bs.login(username, password);
		if(user!=null){
			//存在Session域里面（会话域，关闭会话时摧毁）
			request.getSession().setAttribute("user", user);
			System.out.println("登录成功！");
			response.sendRedirect("/MVCmodel/index.jsp");
			return;
		}
		
	     	//如果执行到下面则证明用户不为空
			request.setAttribute("message", "用户名或者密码错误！");
			request.getRequestDispatcher("/JSP/message.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
