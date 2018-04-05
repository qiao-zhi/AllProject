package cn.qlq.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.qlq.service.UserService;

//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用的配置文件
@ContextConfiguration("classpath:cn/qlq/XMLaspect/applicationContext.xml")
public class SpringXMLAopTest {

	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun1(){
		us.save();
	}
	
}
