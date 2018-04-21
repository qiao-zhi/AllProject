package cn.qlq.service;

import org.springframework.stereotype.Service;

import cn.qlq.annotationAOP.MyAnno;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("保存用户。。。无参数");
	}

	@MyAnno(name="自定义注解")
	@Override
	public boolean save(String userId) throws Exception {
		System.out.println("保存用户.....(有参数):"+userId);
		return true;
	}

	@Override
	public void update() {
		System.out.println("更新用户....");
	}

	@Override
	public void delete() {
		System.out.println("删除用户....");
	}

	@Override
	public void find() {
		System.out.println("查找用户");
	}
}
