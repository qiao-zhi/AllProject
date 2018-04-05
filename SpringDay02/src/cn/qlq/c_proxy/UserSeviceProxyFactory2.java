package cn.qlq.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.qlq.service.UserService;
import cn.qlq.service.UserServiceImpl;
//官方代码=> Cglib代理
public class UserSeviceProxyFactory2 implements MethodInterceptor{
	//产生动态代理对象
	public UserService getUserServiceImpl(){
		//Cglib的核心类，用于产生动态代理对象
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);//设置对谁进行代理（父类）
		enhancer.setCallback(this);						//设置回调
		UserService us = (UserService) enhancer.create(); //生成代理
		return us;
	}
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy methodProxy) throws Throwable {
		//打开事务
		System.out.println("打开事物~~~~~~~~~~~~~");
		//调用原有方法
		Object invokeSuper = methodProxy.invokeSuper(arg0, arg2);
		//关闭事物
		System.out.println("关闭事物~~~~~~~~~~~");
		return invokeSuper;
	}
		
}
