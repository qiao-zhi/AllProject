package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	/******增加用户**/
	void add(User user);

	/******查找用户，根据用户名与密码，登录时候使用*/
	User find(String username, String password);

	/*******根据用户名查找判断用户名是否存在，注册时候使用**/
	boolean find(String username);

}