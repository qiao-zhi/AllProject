package cn.qlq.c_proxy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import cn.qlq.service.UserService;
import cn.qlq.service.UserServiceImpl;

public class UserSeviceProxyFactoryTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
//	测试JDK动态代理
	public void test() throws Exception {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true" );
		UserServiceImpl us = new UserServiceImpl();   
		UserSeviceProxyFactory usProxyFactory = new UserSeviceProxyFactory(us);
//		调用动态代理对象工厂产生动态代理对象
		UserService usProxy = usProxyFactory.getUserServiceImpl();
//		调用动态代理对象的方法，已经进行过增强事务处理
		usProxy.save("1");
	}
	
	@Test
//	测试Cglib动态代理
	public void test1() {
		
		UserSeviceProxyFactory2 usProxyFactory = new UserSeviceProxyFactory2();
//		调用动态代理对象工厂产生动态代理对象
		UserService usProxy = usProxyFactory.getUserServiceImpl();
//		调用动态代理对象的方法，已经进行过增强事务处理
		usProxy.delete();
	}

}
