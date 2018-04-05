package ServiceImpl;

import java.util.List;

import Bean.User;
import Bean.UserRole;
import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public  UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	/**
	 * 查询用户
	 *@param name 用户名
	 *@param password 密码
	 *@return 用户
	 */
	@Override
	public User findUser(String name, String password) {
		return userDao.findUser(name, password);
	}

	@Override
	public List<UserRole> findRoleByUserId(int userId) {
		return userDao.findRoleByUserId(userId);
	}

}
