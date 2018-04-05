package Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class lOGIN2
 */
@WebServlet("/lOGIN2")
public class lOGIN2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lOGIN2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //判断带过的随机数是否有效
		boolean isValied=isTokenValid(request);
		
		if(!isValied){System.out.println("无效，请不要重复提交！"); return ;}
		
		
		request.getSession().removeAttribute("rand");
		System.out.println("正在提交。。。。。。。。。");
		
		
		
	}

	private boolean isTokenValid(HttpServletRequest request) {
	

	//服务器端带随机数
	String ser_hid=(String) request.getSession().getAttribute("rand");
	
	//客户端带过来带随机数
	String cli_hid=request.getParameter("hid");
	System.out.println(ser_hid+"         "+cli_hid+"    5");
		if(cli_hid==null){return false;}
		if(ser_hid==null){return false;}
		if(!cli_hid.equals(ser_hid)){return false;}
		return true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
