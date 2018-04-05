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
* @date :  2017年7月5日下午6:18:55
* @description:设置响应头
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Header() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
//		add是增加响应头，有多个时增加，不会覆盖
/*		response.addHeader("name", "www");
		response.addHeader("name", "www");
		response.addIntHeader("age", 25);
		response.addDateHeader("时间", date.getTime());*/
		
//		set是修改，不会增加
		response.setHeader("name", "wangwu");
		response.setHeader("name", "zhaoliu");
		response.setIntHeader("age",58);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
