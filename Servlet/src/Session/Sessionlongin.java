package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sessionlongin
 */
@WebServlet("/Sessionlongin")
public class Sessionlongin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sessionlongin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
    String name=request.getParameter("name");
    String password=request.getParameter("password");
    List<User> list=Db1.getAll();
    for(User user:list){
    	if(user.getUsername().equals(name)&&user.getPassword().equals(password)){
    		session.setAttribute("user",new User(name,password));
            response.sendRedirect("/Servlet/loginshouye");
            return;
    	}
    }
    out.println("用户名或者密码错误！");
    
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



//模拟数据库。开始时候初始化用户list，静态代码

class Db1{
	public static List list=new ArrayList();
	static{
		list.add(new User("aaa","123"));
		list.add(new User("bbb","123"));
		list.add(new User("ccc","123"));
		list.add(new User("ddd","123"));
		
	}
	public static List getAll(){
		return list;
	}
}

