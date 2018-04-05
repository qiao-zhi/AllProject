package cn.qlq.Test;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.qlq.bean.User;

public class BeanCreateTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/bean_create/applicationContext.xml");
		//向容器要对象
		User user1 = (User) ac.getBean("user");
		User user2 = (User) ac.getBean("user");
		User user3 = (User) ac.getBean("user");
		User user4 = (User) ac.getBean("user");
		System.out.println(user1);
		System.out.println(user1==user2);
	}
	
	
	
	//第二种创建bean的方法测试:工厂的静态方法创建
	@Test
	public void test2() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/bean_create/applicationContext.xml");
		//向容器要对象
		User user = (User) ac.getBean("user2");
		System.out.println(user);
	}
	
	
	//第三种创建bean的方法测试:工厂对象的方法创建
	@Test
	public void test3() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/bean_create/applicationContext.xml");
		//向容器要对象
		User user = (User) ac.getBean("user3");
		System.out.println(user);
	}
	
	
	//测试对象的初始化和销毁方法
	@Test
	public void test4() {
		//加载配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/qlq/bean_create/applicationContext.xml");
		//向容器要对象
		User user = (User) ac.getBean("user3");
		System.out.println(user);
		ac.close();
	}

}
