package util;
import java.net.URI;
/******�������ݿ���������ѡ����Ŀ������Ҽ���ѡ��Build Path��,Ȼ��ѡ��Configure Build Path��
 ���ڵ����ĶԻ�����ѡ��libraries���еġ�ADD External TARS����ѡ��jdbc����ok**********
 ���ݿ��п��Ա�д�������Ĵ洢���̣�ֱ��ͨ��call����select����ʱָ������*/
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
    //FileInputStream fin=new FileInputStream(dataIni); // ���ļ�,�Ӹ�Ŀ¼��ʼѰ��
//	FileInputStream fin=new FileInputStream("src/util/DataBase.ini"); // ���ļ�,�Ӹ�Ŀ¼��ʼѰ��
//	Properties props=new Properties();                 // ���������࣬��ȡini�ļ�
//	props.load(fin);                        
//	driver=props.getProperty("driver");         //���ݼ���ȡֵ
//	url=props.getProperty("url");
//	username=props.getProperty("username");
//	userpassword=props.getProperty("userpassword");
	}
	catch(Exception e){e.printStackTrace();}
	}
	

	/**************��ȡ���ӵ�ʱ���������ݿ�****/
public  Connection getconnection(){
		try{
		initiate();
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softconstruct","sa","123456");
		System.out.println("Success����");}
		catch(Exception e){e.printStackTrace();}
		
		return con;		
	
	
	}

	
	/******�ر����Ӻ���*********/
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



