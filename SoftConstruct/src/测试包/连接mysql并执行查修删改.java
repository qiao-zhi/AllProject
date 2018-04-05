package 测试包;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class 连接mysql并执行查修删改{

	public static void main(String[] args) throws Exception, SQLException {
		/***********连接数据库*************/
		System.out.println("sssssss");
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String  url="jdbc:mysql://localhost:3306/test";
		String  user="root";
		String  pass="123456";
		
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Success Connection!");

	    
		/******执行插入语句***************************
		QueryRunner  qr=new QueryRunner();
		String sql = "insert into student(name,sex,age) values (?,?,?)";
		//Student s=new Student("201420023","男",20);
		Object ins[]={"20159","ss",22};
		qr.update(con,sql,ins);
		System.out.println("插入成功！");	****/
	
	
		
		/*********查询*****	
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "select * from student where name=?";
	    Student ss=(Student)qr_1.query(con, sql_1,new BeanHandler<Student>(Student.class),"20159");
	    System.out.println(ss.getName());
	    System.out.println(ss.getAge());
	    System.out.println(ss.getSex());****/	

	    
	    /**********查询多条记录并输出**
	    String sql_2 = "select * from student";
	    List<Student> s_11=new ArrayList<Student>();
	    s_11=new QueryRunner().query(con, sql_2,new BeanListHandler<Student>(Student.class));
	    for(Student sss:s_11){
	    	System.out.println(sss.getName()+"\t"+sss.getAge()+"\t"+sss.getSex());
	    	    }******/
		
	    /********删除可以成功执行**** 
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "delete  from Student where name=? and sex=? and age=?";
		Object []dele={"20158","ss",22};
	    qr_1.update(con,sql_1,dele);
	    System.out.println("删除成功");**/
	   
	    
	    
	    /********修改可以成功执行问题******* 
		QueryRunner  qr_3=new QueryRunner();
		String sql_3 = "update Student set age=? where name=? and sex=? and age=?";
		Object []dele={29,"20158","ss",22};
	    qr_3.update(con,sql_3,dele);
	    System.out.println("修改成功");  ***/ 
       

	}


}
