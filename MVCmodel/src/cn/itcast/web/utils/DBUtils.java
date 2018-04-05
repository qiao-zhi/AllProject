package cn.itcast.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.omg.CORBA.PUBLIC_MEMBER;

public class DBUtils {
 
	/*****单例模式，只允许这个类操作数据库
	 * 1.构造方法似私有化
	 * 2.内部创建一个对象
	 * 3.公开一个静态方法暴露这个对象
	 * ******/
	private DBUtils() {
		
	}


    private static DBUtils dbu;
	private static Connection con=null;	
	static{
		try {
			dbu=new DBUtils();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MVC","root","123456");
			System.out.println("连接成功！");
		} catch (Exception e) {
             System.out.println("连接数据库异常！");
		}


	}
	
	
	/******公开暴露对象********/
	public static DBUtils getDBUtils(){
		return dbu;
	}
	
	
	/*********返回一个数据库连接*/
	public Connection getConnection(){
		return con;
	}
	
	
	
	
}
