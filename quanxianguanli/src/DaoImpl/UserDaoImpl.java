package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import Bean.User;
import Bean.UserRole;
import Dao.UserDao;
import JunitTest.testClass;
import Utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {
	
	@Override
	public User findUser(String name, String password) {
		User user = null;
		// 准备所有商品的数据 ---- List<Product>
		Logger log = Logger.getLogger(testClass.class);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where name = ? and password = ?";
		try {
			user = runner.query(sql, new Object[]{name, password},new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<UserRole> findRoleByUserId(int userId) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * FROM userrole WHERE userid = ?";
		List<UserRole> list = null;
		try {
			list = runner.query(sql, userId, new BeanListHandler<UserRole>(UserRole.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
