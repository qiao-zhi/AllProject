package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SetSession")
public class SetSession extends HttpServlet {
       
 
    public SetSession() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setHeader("content-type", "text/html;charset=utf-8");
		HttpSession session=request.getSession();
		
		
		//设置Session生命期为30分钟
		String sessionid=session.getId();                  //获取session的id
		Cookie cookie=new Cookie("JSESSIONID",sessionid);  //覆盖原来的Cookie
		cookie.setMaxAge(30*60);            //S位单位，设置为30min  
		response.addCookie(cookie);
     	session.setAttribute("name", "洗衣机");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
