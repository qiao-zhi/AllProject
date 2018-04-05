package cn.qlq.Test;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.qlq.bean.User;

public class UserTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//向容器要对象
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}

}
