package ���԰�;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class ����mysql��ִ�в���ɾ��{

	public static void main(String[] args) throws Exception, SQLException {
		/***********�������ݿ�*************/
		System.out.println("sssssss");
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String  url="jdbc:mysql://localhost:3306/test";
		String  user="root";
		String  pass="123456";
		
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Success Connection!");

	    
		/******ִ�в������***************************
		QueryRunner  qr=new QueryRunner();
		String sql = "insert into student(name,sex,age) values (?,?,?)";
		//Student s=new Student("201420023","��",20);
		Object ins[]={"20159","ss",22};
		qr.update(con,sql,ins);
		System.out.println("����ɹ���");	****/
	
	
		
		/*********��ѯ*****	
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "select * from student where name=?";
	    Student ss=(Student)qr_1.query(con, sql_1,new BeanHandler<Student>(Student.class),"20159");
	    System.out.println(ss.getName());
	    System.out.println(ss.getAge());
	    System.out.println(ss.getSex());****/	

	    
	    /**********��ѯ������¼�����**
	    String sql_2 = "select * from student";
	    List<Student> s_11=new ArrayList<Student>();
	    s_11=new QueryRunner().query(con, sql_2,new BeanListHandler<Student>(Student.class));
	    for(Student sss:s_11){
	    	System.out.println(sss.getName()+"\t"+sss.getAge()+"\t"+sss.getSex());
	    	    }******/
		
	    /********ɾ�����Գɹ�ִ��**** 
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "delete  from Student where name=? and sex=? and age=?";
		Object []dele={"20158","ss",22};
	    qr_1.update(con,sql_1,dele);
	    System.out.println("ɾ���ɹ�");**/
	   
	    
	    
	    /********�޸Ŀ��Գɹ�ִ������******* 
		QueryRunner  qr_3=new QueryRunner();
		String sql_3 = "update Student set age=? where name=? and sex=? and age=?";
		Object []dele={29,"20158","ss",22};
	    qr_3.update(con,sql_3,dele);
	    System.out.println("�޸ĳɹ�");  ***/ 
       

	}


}
