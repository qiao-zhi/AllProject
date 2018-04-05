package com.runoob.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDb {
private static Connection con; 
//	private static Properties pro=new Properties();
//	static{
//		//第一种方法，通过类装载器读取资源文件，只在类加载时读取，不能读取到更新后的文件（直接读取）
////		InputStream in=RedDb.class.getClassLoader().getResourceAsStream("db.properties");
////		Properties po=new Properties();
////		po.load(in);
////		System.out.println(po.getProperty("url"));
////		System.out.println(po.getProperty("username"));
//
//		
//		//第二种读取方法，通过类加载器读取到资源路径，再通过路径读取文件，可以读取到更新后的文件（先读取路径再读取文件）
//		//包名为X.Y.Z，经过编译后变为文件夹X/Y/Z

	
	
	
	public static  Connection getconnection() throws SQLException, ClassNotFoundException{
		
		
		try {
			String path=ConnectDb.class.getClassLoader().getResource("/database.properties").getPath();
			FileInputStream file = new FileInputStream(path);
			Properties pro=new Properties();
				pro.load(file);
			String driver=pro.getProperty("driver");
			String url=pro.getProperty("url");
			String username=pro.getProperty("username");
			String password=pro.getProperty("password");
			System.out.println(driver+"\n"+url+"\n"+username+"\n"+ password);
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Seccess conn");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
				
	
	}
	
	
}
