package cn.itcast.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.omg.CORBA.PUBLIC_MEMBER;

public class DBUtils {
 
	/*****����ģʽ��ֻ���������������ݿ�
	 * 1.���췽����˽�л�
	 * 2.�ڲ�����һ������
	 * 3.����һ����̬������¶�������
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
			System.out.println("���ӳɹ���");
		} catch (Exception e) {
             System.out.println("�������ݿ��쳣��");
		}


	}
	
	
	/******������¶����********/
	public static DBUtils getDBUtils(){
		return dbu;
	}
	
	
	/*********����һ�����ݿ�����*/
	public Connection getConnection(){
		return con;
	}
	
	
	
	
}
