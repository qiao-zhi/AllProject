package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface BussinessService {

	//Ϊweb���ṩ��¼����,�û������ھ�ע�ᣬ���ھ���һ���û������쳣
	void register(User user) throws UserExistException;

	User login(String username, String password);

}