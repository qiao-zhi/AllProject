package cn.qlq.core.test;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.qlq.core.dao.SelectUser;
import cn.qlq.pojo.User;


public class 测试是否可用mybatis {

	private SqlSessionFactory  sqlSessionFactory;
	
	//每个方法执行时都会执行Before中声明的
	@Before
	public void setUp() throws Exception {
		//将全局配置文件作为一个流
				String resource="SqlMapConfig.xml";
				String realPath = this.getClass().getClassLoader().getResource("SqlMapConfig.xml").getPath();
				URL realPath2 = Resources.getResourceURL("SqlMapConfig.xml");
			    System.out.println(realPath);
				System.out.println(realPath2);
				InputStream inputStream=Resources.getResourceAsStream(resource);
				
				//建立一个SqlSession工厂
				 sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		//获取mapper接口的代理对象
		SelectUser slectUser = (SelectUser) session.getMapper(SelectUser.class);
		//调用代理对象方法
		List<User> list = slectUser.findUser();
		System.out.println(list);
		//关闭session
		session.close();
		
	}
	
	
	


}
