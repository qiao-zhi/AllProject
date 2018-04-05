package cn.itcast.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.html")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false);//加false如果没有不会创建session
		if(session!=null){
			session.removeAttribute("user");
		}
		request.setAttribute("message", "注销成功，浏览器将在3秒后跳转到首页，如果没有跳转...<meta http-equiv='refresh' content='10;url="+request.getContextPath()+"/index.jsp'/>");
		request.getRequestDispatcher("/JSP/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
