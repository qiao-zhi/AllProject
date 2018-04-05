package 测试包;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dto.majorDTO;

public class mysql操作JavaBean {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("sssssss");
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String  url="jdbc:mysql://localhost:3306/softconstruct";
		String  user="root";
		String  pass="123456";
		
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Success Connection!");
		
		
//		QueryRunner  qr=new QueryRunner();
//		String sql = "insert into major(major_id,major_name) values (?,?)";
//		//Student s=new Student("201420023","男",20);
//		Object ins[]={"20159","ss"};
//		qr.update(con,sql,ins);
//		System.out.println("插入成功！");
		
		QueryRunner  qr_1=new QueryRunner();
		String sql_1 = "select * from major";
		//Student s=new Student("201420023","男",20);
//		Object ins[]={"20159","ss"};
		majorDTO mm=qr_1.query(con, sql_1, new BeanHandler<majorDTO>(majorDTO.class));
		System.out.print(mm.getMajor_id()+"\t"+mm.getMajor_name());
		
//		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().height);
//		System.out.print(Toolkit.getDefaultToolkit().getScreenSize().width);
	}

}
