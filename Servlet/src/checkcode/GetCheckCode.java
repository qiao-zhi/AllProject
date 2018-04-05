package checkcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCheckCode
 */
@WebServlet("/GetCheckCode")
public class GetCheckCode extends HttpServlet {
public GetCheckCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		request.setCharacterEncoding("UTF-8");
		String c_checkcode=request.getParameter("checkcode");
		String s_checkcode=(String) request.getSession(false).getAttribute("checkcode");
		System.out.println(c_checkcode);
		System.out.println(s_checkcode);
		if(c_checkcode!=null && s_checkcode!=null && c_checkcode.equals(s_checkcode)){
			System.out.println("正在注册。。。。。。");
		
		}else System.out.println("验证码错误！");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
