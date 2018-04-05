/*package test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import Bean.Menu;
import Bean.Role;
import Bean.RoleMenu;
import Bean.User;
import Bean.UserRole;
import DaoImpl.MenuDaoImpl;
import DaoImpl.RoleDaoImpl;
import DaoImpl.UserDaoImpl;
import Utils.DataSourceUtils;

public class testClass {


	@Test
	public void test1() {
		// 准备所有商品的数据 ---- List<Product>
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		try {
			userList = runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			log.error("查用户时出错！");
		}

	}
	

}
*/