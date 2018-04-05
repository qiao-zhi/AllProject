package response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* @author: qlq
* @date :  2017年7月5日下午5:57:47
* @description:设置响应行
 */
@WebServlet("/sxiangyinghang")
public class sxiangyinghang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public sxiangyinghang() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置响应行的状态码为404
		response.setStatus(500);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
