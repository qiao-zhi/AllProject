package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//代表首页的Servlet

@WebServlet("/DetailInfo")
public class DetailInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DetailInfo() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制输出流不乱码
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 1.显示所有商品信息
		String id=request.getParameter("id");
		Book book=(Book)Db.getAll().get(id);
		String name=book.getName();
		String id1=book.getId();
		String author=book.getAuthor();
		String desc=book.getDescription();
	    out.println("<br/>"+name+"<br/>"+author+"<br/>"+desc);
	    

		//构建Cookie，回送给浏览器
	   String cookieValue= buildCookie(id,request);   //构建cookie值
		Cookie cookie=new Cookie("bookHistory",cookieValue);
	    cookie.setMaxAge(60*60*60);
	    cookie.setPath("/Servlet");
	    response.addCookie(cookie);
	    
	    
			}


	private String buildCookie(String id,HttpServletRequest request) {
	//  bookHistory=null     1    1
	//  bookHistory=2,3      1    1,2,3
	//  bookHistory=2,3,4    1    1,2,3
	//  bookHistory=2,3,1    1    1,2,3
		String bookHistory=null;
		Cookie cookies[]=request.getCookies();
		for(int i=0;i<cookies.length&&cookies!=null;i++){
			if(cookies[i].getName().equals("bookHistory")){
				bookHistory=cookies[i].getValue();
			}
			
		}
		
		if(bookHistory==null){return id;}
		LinkedList<String> list=new LinkedList(Arrays.asList(bookHistory.split("\\,")));
		if(list.contains(id)){
			
			list.remove(id);
			list.addFirst(id);
						
		}else{
			if(list.size()>=3){
				
				list.removeLast();
				list.addFirst(id);
			}
			else list.addFirst(id);
			
		}
		
		
		//将List转换为字符串。
	StringBuffer sb=new StringBuffer();	
for(String id1:list){
	sb.append(id1+",");
}
	return	sb.deleteCharAt(sb.length()-1).toString();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
