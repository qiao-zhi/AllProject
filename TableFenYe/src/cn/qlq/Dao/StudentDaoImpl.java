package cn.qlq.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.Connection;

import cn.qlq.Utils.JdbcUtil;
import it.qlq.javabean.Pager;
import it.qlq.javabean.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Pager<Student> findStudent( int pageNum, int pageSize) {
    List<Student> list = getAllStudent();
	Pager<Student> page = new Pager<Student>(pageNum, pageSize, list);
	return page;
	}
	
	
	public static List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();		
		Connection con = (Connection) JdbcUtil.getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "select * from t_student";
	    try {
			list =qr.query(con, sql,new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {

			throw new RuntimeException("查询出错",e);
		}

	    for(Student stu:list){
	    	System.out.println(stu);
	    }
	    System.out.println(list.size());
		return list;
	}
	
	public static void main(String[] args) {
		getAllStudent();
	}

}
