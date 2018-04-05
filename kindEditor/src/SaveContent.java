
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

/**
 * @author liqiang  
 * @version 创建时间：2017年7月12日  下午4:27:15
 * tags
 */
@WebServlet("/SaveContent")
public class SaveContent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		获取用户的输入数据
		String values = request.getParameter("test");
		System.out.println(values);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into ceshi values(?,null)";
		try {
			runner.update(sql, values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Read.jsp").forward(request, response);
//		response.getWriter().write(request.getParameter("test"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}