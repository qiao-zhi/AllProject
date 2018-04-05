package JunitTest;

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

	UserDaoImpl usi = new UserDaoImpl();
	RoleDaoImpl rdi=new RoleDaoImpl();
	MenuDaoImpl mdi = new MenuDaoImpl();
	@Test
	public void test1() {
		// 准备所有商品的数据 ---- List<Product>
		Logger log = Logger.getLogger(testClass.class);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		List<User> userList = null;
		try {
			userList = runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			log.error("查用户时出错！");
		}

		// 商品的集合准备好
		// 将数据存到request域 转发给product_list.js进行显示
		for (User u : userList) {
			System.out.println(u.getName()+"    "+u.getPassword()+"    "+u.getUserId());
		}

	}
	
	/**
	 * @throws Exception 
	 *查询用户是否存在 
	 *@throws
	 */
	@Test
	public void test2() throws Exception{
//		查询用户
		User user = usi.findUser("xiaoming", "123456"); 
		System.out.println(user);
		System.out.println("--------------------------------------");
//		查询用户角色
		List<UserRole> findRoleByUserId = usi.findRoleByUserId(user.getUserId());
		System.out.println("--------------------------------------");
		System.out.println(findRoleByUserId);
//		根据用户角色查询用户角色
		List<Role> findRoleByUserRole = rdi.findRoleByUserRole(findRoleByUserId);
		System.out.println("--------------------------------------");
		System.out.println(findRoleByUserRole);
//		查询角色查询角色功能
		List<RoleMenu> findRoleMenuByRole = rdi.findRoleMenuByRole(findRoleByUserRole);
		System.out.println("--------------------------------------");
		System.out.println(findRoleMenuByRole);
//		根据角色功能查询用户的功能及菜单
		List<Menu> findMenuByRoleMenu = findMenuByRoleMenu = mdi.findMenuByRoleMenu(findRoleMenuByRole);
		System.out.println("--------------------------------------");
		System.out.println(findMenuByRoleMenu);
	}
	

}
