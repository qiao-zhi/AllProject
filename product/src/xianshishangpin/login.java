package xianshishangpin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
/**
 * 
* @author: qlq
* @date :  2017年7月6日上午10:19:37
* @description: chuli denglu
 */



@WebServlet("/login")
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+"\t"+password);
		
		//准备所有商品的数据 ---- List<Product>
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where name='"+name+"' and password = '"+password+"'";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user!=null){
			System.out.println(user.getName()+user.getPassword());
			request.getRequestDispatcher("/xianshishangpin").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/login.html").forward(request, response);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}