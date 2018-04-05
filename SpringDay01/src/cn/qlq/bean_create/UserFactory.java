package cn.qlq.bean_create;

import cn.qlq.bean.User;

public class UserFactory {

	public static User userCreate(){
		System.out.println("调用工厂的静态方法！！！");
		return new User();
	}
	
	
	public  User userCreate1(){
		System.out.println("调用工厂对象的方法！！！");
		return new User();
	}
	public UserFactory(){
		System.out.println("创建UserFactory对象");
	}
}
