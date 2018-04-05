package util;
import java.net.URI;
/******导入数据库驱动程序，选中项目，点击右键，选择‘Build Path’,然后选择‘Configure Build Path’
 ，在弹出的对话框中选择‘libraries’中的‘ADD External TARS’，选择jdbc后点击ok**********
 数据库中可以编写带参数的存储过程，直接通过call或者select调用时指明参数*/
import java.sql.*;
//import java.io.FileInputStream;
//import java.net.URL;
//import java.util.*;
public class  DataBaseConnection{
	private Connection con=null;
//	private String driver;
//	private String url;
//	private String username;
//	private String userpassword;
	
	
private void initiate(){try{
	//String dataIni = run.class.getResource("../util/DataBase.ini").getFile();
    //FileInputStream fin=new FileInputStream(dataIni); // 打开文件,从根目录开始寻找
//	FileInputStream fin=new FileInputStream("src/util/DataBase.ini"); // 打开文件,从根目录开始寻找
//	Properties props=new Properties();                 // 建立属性类，读取ini文件
//	props.load(fin);                        
//	driver=props.getProperty("driver");         //根据键读取值
//	url=props.getProperty("url");
//	username=props.getProperty("username");
//	userpassword=props.getProperty("userpassword");
	}
	catch(Exception e){e.printStackTrace();}
	}
	

	/**************获取连接的时候连接数据库****/
public  Connection getconnection(){
		try{
		initiate();
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softconstruct","sa","123456");
		System.out.println("Success链接");}
		catch(Exception e){e.printStackTrace();}
		
		return con;		
	
	
	}

	
	/******关闭连接函数*********/
	public void closeConn(Connection conn){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	
	
	

}



