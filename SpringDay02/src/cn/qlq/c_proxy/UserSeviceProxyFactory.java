package cn.qlq.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.qlq.service.UserService;
import cn.qlq.service.UserServiceImpl;


//JDK动态代理
public class UserSeviceProxyFactory implements InvocationHandler{
	private UserService us;
	//调用构造方法时传入对象
	protected UserSeviceProxyFactory(UserService us) {
		super();
		this.us = us;
	}
	//产生动态代理对象
	public UserService getUserServiceImpl(){
		
		//动态代理产生接口的对象
		 UserService us = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
				   								UserServiceImpl.class.getInterfaces(),
				   								this);
		 return us;
	}

	@Override
//	对方法进行增强，即方法前面与后面进行统一处理
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//第一个参数代表调用的对象，第二个参数代表方法名字，第三个参数代表方法参数
		
		System.out.println("打开事务~~~~~~~~~~");  //方法前面增强的语句
		Object invoke = method.invoke(us, args);
		System.out.println("提交事务~~~~~~~~~~");  //方法后面增强的语句
		
		return invoke;
	}
}
