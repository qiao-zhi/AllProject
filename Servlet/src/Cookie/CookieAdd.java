package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 cookie增加通过respone，读取通过request
 */
@WebServlet("/CookieAdd")
public class CookieAdd extends HttpServlet {
	private static final long userCookie = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
       out.write("Seee");
//		  Enumeration cookieName=request.getParameterNames();
//	  	while(cookieName.hasMoreElements()){
//			String name=(String)cookieName.nextElement();
//			String url=(String) request.getParameter(name);
//			response.getWriter().write("添加的cookie：\n"+"名字:"+name+"\t值:"+url);
//			Cookie cookie=new Cookie(name, url);
//			cookie.setMaxAge(60*24*24);
//			response.addCookie(cookie);
//			response.getWriter().write("\n成功添加cookie");
//		}
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		
			
        Cookie cookie=new Cookie("user"+this.userCookie,s.format(d));
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
       
        out.write("新设置的Cookie：\n"+"user"+this.userCookie+"\t"+cookie.getValue());
        
        
        
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
