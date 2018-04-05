package it.qlq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import javax.management.RuntimeErrorException;

//单例模式
public class DBUtils {
	private static Connection connection=null;
	private static String username;
	private static String password;
	private static String driver;
	private static String url;
	// 定义sql语句的执行对象
	private PreparedStatement pstmt;

	// 定义查询返回的结果集合
	private ResultSet resultSet;
	
	static{
		loadConfig();  //编译时加载，只执行一次
	}

	
	private DBUtils() {
		
	}

	public static void loadConfig(){
		System.out.println(DBUtils.class.getClassLoader().getResource("JDBC.properties").getPath());
		InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("JDBC.properties");
		Properties props=new Properties();             
		try {
			props.load(in);
			username = props.getProperty("username");
			password = props.getProperty("password");
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			System.out.println(username+password);			
		} catch (IOException e) {
			System.out.println("CCCC1");
			throw new RuntimeException(e);
	
		}
	}

	

	public static Connection getConnection(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		try {
			connection=DriverManager.getConnection(url,username,password);
			System.out.println("Success Connection");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public List<Map<String, Object>> findResult(String sql, List<?> params)
			throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}
/*
	
	public static void main(String[] args) {
		getConnection();
	}*/
	
}
