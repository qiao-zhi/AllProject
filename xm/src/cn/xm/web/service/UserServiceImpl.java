package cn.xm.web.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void findUserById(int id) {
		System.out.println("这是ServiceImpl方法");

	}

}
