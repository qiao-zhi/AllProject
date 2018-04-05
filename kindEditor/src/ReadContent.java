
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.CeShi;

/**
 * @author liqiang  
 * @version 创建时间：2017年7月12日  下午4:27:15
 * tags
 */
@WebServlet("/ReadContent")
public class ReadContent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		获取用户的输入数据
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from ceshi";
		CeShi query = null;
		System.out.println("sssssssss");
		try {
			query = runner.query(sql, new BeanHandler<CeShi>(CeShi.class));
			request.getSession().setAttribute("query", query);
			response.sendRedirect("/kindEditor/kindeditor/jsp/demo1.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}