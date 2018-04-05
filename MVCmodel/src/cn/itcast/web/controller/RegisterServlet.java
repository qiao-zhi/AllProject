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
import cn.itcast.web.formbean.RegisterForm;
import cn.itcast.web.utils.WebUtil;

@WebServlet("/Servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
       

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.对数据进行合法性校验(formBean),把表单数据封装到form
		request.setCharacterEncoding("UTF-8");
		RegisterForm form=WebUtil.request2bean(request, RegisterForm.class);
		boolean isOK=form.validate();
//		System.out.println("form-------------"+form.getBirthday());
//		System.out.println("form-------------"+form.getEmail());
		//2.如果校验失败，返回到注册页面，回显失败信息
		System.out.println("校验成功！"+isOK);
		if(!isOK){

			request.setAttribute("form", form);
			request.getRequestDispatcher("/JSP/register.jsp").forward(request, response);
			return ;
		}
		
		//3.校验成功，则调用Servlet处理注册请求(需要将表单数据封装到User里面)
		User user=new User();
		BussinessService bsi=new BussinesServiceImp();
		try {
		WebUtil.copyBean( user,form);
		System.out.println("复制后User----"+user.getBirthday());
		bsi.register(user);	
		
		} catch (UserExistException e) {
			//4.如果Servlet处理不成功原因是用户已存在，返回到注册界面提示用户注册用户已存在
			form.getErrors().put("username", "用户名已存在！");
			request.setAttribute("form", form);
			System.out.println("用户已存在注册出错！！！！！！！");
			request.getRequestDispatcher("/JSP/register.jsp").forward(request, response);
			return ;			
		}catch(Exception e){
			//5.如果Servlet处理不成功原因是其他问题，跳转到全局消息页面，为用户显示消息提示
			request.setAttribute("message", "对不起，服务器内部出错了！");
			request.getRequestDispatcher("/JSP/message.jsp").forward(request, response);
			return ;
		}
		

		

				
		//6.处理成功，跳转到全局页面提醒用户注册成功
		
		request.setAttribute("message", "<meta http-equiv='Refresh'  content='5;url="+request.getServletContext().getContextPath()+"/index.jsp' >注册成功，本页面将在三秒后跳转到主页，如果没有跳转，请点击<a href='"+request.getServletContext().getContextPath()+"/index.jsp'>首页</a>");
		request.getRequestDispatcher("/JSP/message.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
