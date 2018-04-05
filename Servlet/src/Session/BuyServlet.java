package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//设置session的存活期为30分钟
		String id=request.getParameter("id");
		Book book=(Book) Db.getAll().get(id);
		HttpSession session=request.getSession();
		String sessionid=session.getId();
		Cookie cookie=new Cookie("JSESSIONID",sessionid);
		cookie.setMaxAge(30*60);
		cookie.setPath(request.getContextPath());  //获得WEB工程名字
		response.addCookie(cookie);
		
		
		//从用户的session中得到用户保存书的list
		List list=(List) session.getAttribute("list");
		if(list==null){
			list=new ArrayList();
			session.setAttribute("list",list);   //在用户的session中添加list集合
		}
		list.add(book);
		
		
		//转向时刷新相当于重做当前的事情，会多次购买
//		request.getRequestDispatcher("/Servlet/BuyListCard").forward(request, response);
		
		
		//重定向
		response.sendRedirect("/Servlet/BuyListCard");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
