package Dao;

import java.util.List;

import Bean.Role;
import Bean.User;
import Bean.UserRole;

public interface UserDao {
	/**
	 * 查询用户
	 *@param name  用户名
	 *@param password  密码
	 *@return   用户
	 *@throws
	 */
	public User findUser(String name,String password);
	/**
	 * 查询用户id查询用户角色
	 *@param userId  用户id
	 *@return   用户角色集合
	 *@throws
	 */
	public List<UserRole> findRoleByUserId(int userId);

}
