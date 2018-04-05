package cn.qlq.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.qlq.bean.CollectionBean;
import cn.qlq.bean.User;

//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

	@Resource(name="user")
	private User user;
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void fun2(){
		System.out.println(user);
	}

	@Test
	public void test() {
		//加载配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//
		User user = (User) ac.getBean("user");
/*		User user1 = (User) ac.getBean("user");
		User user2 = (User) ac.getBean("user");
		
		System.out.println(user1==user2);*/
		System.out.println(user);
		ac.close();
	}
	
	
}
