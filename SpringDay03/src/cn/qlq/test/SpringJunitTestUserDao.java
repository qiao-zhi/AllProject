package cn.qlq.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import cn.qlq.Dao.UserDao;
import cn.qlq.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunitTestUserDao {
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun1(){
		ud.save(new User(6,"大话"));
	}
	@Test
	public void fun2(){
		ud.deleteById(6);
	}
	@Test
	public void fun3(){
		ud.update(new User(1,"WJY"));
	}
	@Test
	public void fun4(){
		User user = ud.findById(1);
		System.out.println(user);
		
	}
	@Test
	public void fun5(){
		List<User> list = ud.findAll();
		System.out.println(list);
	}
	@Test
	public void fun6(){
		System.out.println(ud.getTotalCount());
	}
	
}
