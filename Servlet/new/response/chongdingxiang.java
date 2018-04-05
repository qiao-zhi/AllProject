package response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
* @author: qlq
* @date :  2017年7月5日下午6:28:12
* @description:response重定向
 */
@WebServlet("/chongdingxiang")
public class chongdingxiang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public chongdingxiang() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setStatus(302);
		response.setHeader("Location", "/Servlet/Header");*/
		
//		2.方法二，使用封装后的重定向方法
		response.sendRedirect("/Servlet/Header");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
