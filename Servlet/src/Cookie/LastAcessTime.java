package Cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAcessTime
 */
@WebServlet("/LastAcessTime")
public class LastAcessTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastAcessTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		Cookie cookies[];
		cookies=request.getCookies();
		
		response.getWriter().write("你上次访问的时间是：<br/>大师好！");
		//获取名字为LastAcessTime的Cookie
		for(int i=0;cookies!=null&&i<cookies.length;i++)
		{  Cookie cookie;
			cookie=cookies[i];
			String s=cookie.getName();
			String value=cookie.getValue();
			if(s.equals("LastAcessTime")){
				response.getWriter().write(value);
							
			}
	}
		
		Date d=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		Cookie cookie=new Cookie("LastAcessTime",ss.format(d));
		cookie.setMaxAge(60*60*60);
		cookie.setPath("/Servlet");
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
