package 测试包;

import java.sql.*;


public class Test {

	public static void main(String[] args) throws Exception, SQLException {
		/***********连接数据库*************/
		System.out.println("sssssss");
		//Connection con=null;
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Test","sa","123456");
		System.out.println("Success Connection!");
		
		
		/******执行插入语句**********************
		QueryRunner  qr=new QueryRunner();
		String sql = "insert into Student(Sname,sex,age) values (?,?,?)";
		//Student s=new Student("201420020123","男",20);
		Object ins[]={"201588488888","ss",22};
		qr.update(con,sql,ins);
		System.out.println("插入成功！");
		*********/
	
		
		/*********查询****
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "select * from Student where Sname=?";
	    Student ss=qr_1.query(con, sql_1, "201420020128", new BeanHandler<Student>(Student.class));
	    System.out.println(ss.getSname());
	    System.out.println(ss.getAge());
	    System.out.println(ss.getSex());*****/
	    
	    /**********查询多条记录并输出****
	    String sql_2 = "select * from Student";
	    List<Student> s_11=new ArrayList<Student>();
	    s_11=new QueryRunner().query(con, sql_2,new BeanListHandler<Student>(Student.class));
	    for(Student sss:s_11){
	    	System.out.println(sss.getSname()+"\t"+sss.getAge()+"\t"+sss.getSex());
	    	    }****/
		
	    /********删除可以成功执行****
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "delete  from Student where Sname=? and sex=? and age=?";
		Object []dele={"201420020125","男",25};
	    qr_1.update(con,sql_1,dele);
	    System.out.println("删除成功");
	    **/
	    
	    
	    /********修改可以成功执行问题*****
		QueryRunner  qr=new QueryRunner();
		String sql = "update Student set age=? where Sname=? and sex=? and age=?";
		Object []dele={26,"201420020126","男",25};
	    qr.update(con,sql,dele);
	    System.out.println("修改成功");
           *****/

	}


}
