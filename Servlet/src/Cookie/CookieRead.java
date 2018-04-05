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
 * Servlet implementation class CookieRead
 */
@WebServlet("/CookieRead")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieRead() {
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
	Cookie cookie;
	response.getWriter().write("\n\n第1次读取cookie，看是否有cookie");
	for(int i=0;i<cookies.length;i++)
	{
		cookie=cookies[i];
		String s=cookie.getName();
		String value=cookie.getValue();
		if(s.equals("user1")){
			response.getWriter().write("你上次访问的时间是"+value);
			Date d=new Date();
			SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			cookie.setValue(ss.format(d));
			cookie.setMaxAge(60*60*60);
			response.addCookie(cookie);
			
		}
}
//	ReadAndDeleteCookie(request, response);
//	
//		
		
		
	}

	private void ReadAndDeleteCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie cookies[];
		Cookie cookie;
		cookies=request.getCookies();
		for(int i=0;i<cookies.length;i++)
		{
			cookie=cookies[i];
			String s=cookie.getName();
			String value=cookie.getValue();
			response.getWriter().write("名字："+s+"\t值："+value+"\n");
			//删除名字为name的cooie
		if(s.equals("name")){
			cookie.setMaxAge(0);
		 response.addCookie(cookie);
		 response.getWriter().write("成功刪除名為name的Cookie\n");
		
		                 	}
		}
		
		
		//第二次读取cookie，看是否成功删除名为name的Cookie
		Cookie cookies1[];
		Cookie cookie1;
		cookies1=request.getCookies();
		response.getWriter().write("\n\n第二次读取cookie，看是否删除cookie");
		for(int i=0;i<cookies1.length;i++)
		{
			cookie1=cookies1[i];
			String s=cookie1.getName();
			String value=cookie1.getValue();
			response.getWriter().write("名字："+s+"\t值："+value+"\n");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
