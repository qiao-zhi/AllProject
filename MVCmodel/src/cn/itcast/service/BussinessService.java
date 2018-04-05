package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface BussinessService {

	//为web层提供登录服务,用户不存在就注册，存在就抛一个用户存在异常
	void register(User user) throws UserExistException;

	User login(String username, String password);

}