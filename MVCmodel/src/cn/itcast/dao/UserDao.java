package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	/******�����û�**/
	void add(User user);

	/******�����û��������û��������룬��¼ʱ��ʹ��*/
	User find(String username, String password);

	/*******�����û��������ж��û����Ƿ���ڣ�ע��ʱ��ʹ��**/
	boolean find(String username);

}