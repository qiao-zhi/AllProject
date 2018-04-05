package listener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAttribute
 */
@WebServlet("/TestAttribute")
public class TestAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestAttribute() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		增加
		request.getServletContext().setAttribute("name", "tom");
//		修改
		request.getServletContext().setAttribute("name","lucy");
//		删除
		request.getServletContext().removeAttribute("name");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
