package cn.qlq.test;

import java.beans.PropertyVetoException;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestJdbcTemplet {

	@Test
	public void fun1() throws PropertyVetoException{
//		1.准备连接池（会读配置文件）
		ComboPooledDataSource  dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
		dataSource.setUser("sa");
		dataSource.setPassword("123456");
		System.out.println("1");
		
//		2.创建JDBC模板
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		
//		3.书写sql语句并执行
		String sql = "INSERT INTO `spring`.`t_user` (`id`, `name`) VALUES (null, 'WW')";
		jt.update(sql);
		
	}
	
	
}
