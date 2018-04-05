package cn.qlq.injection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

	@After
	public void tearDown() throws Exception {
	}

	//测试Set注入
	@Test
	public void test() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/injection/applicationContext.xml");
		//
		User user = (User) ac.getBean("user");
		
		System.out.println(user);
	}
	
	//测试构造方法注入
	@Test
	public void test1() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/injection/applicationContext.xml");
		//
		User user = (User) ac.getBean("user1");
		
		System.out.println(user);
	}
	
	
	//测试p名称命名空间方法注入
	@Test
	public void test2() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/injection/applicationContext.xml");
		//
		User user = (User) ac.getBean("user2");
		
		System.out.println(user);
	}
	
	//测试p名称命名空间方法注入
	@Test
	public void test3() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/injection/applicationContext.xml");
		//
		User user = (User) ac.getBean("user3");
		
		System.out.println(user);
	}
	
	//测试集合属性的注入
	@Test
	public void test4() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/injection/applicationContext.xml");
		//
		CollectionBean cb = (CollectionBean) ac.getBean("cb");
		
		System.out.println(cb);
	}

}
