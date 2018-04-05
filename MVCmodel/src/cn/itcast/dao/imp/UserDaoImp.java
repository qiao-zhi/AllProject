package cn.itcast.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.web.utils.DBUtils;

public class UserDaoImp implements UserDao {
	/******增加用户**/
	public void add(User user){
		Connection con=DBUtils.getDBUtils().getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "insert into user values (?,?,?,?,?)";
		Object ins[]={user.getUsername(),user.getPassword(),user.getEmail(),user.getBirthday(),user.getNickname()};
		try {
			qr.update(con,sql,ins);
			System.out.println("插入成功！");	
		} catch (SQLException e) {
              System.out.println("插入数据库错误");
		}
	}
	
	
	/******查找用户，根据用户名与密码，登录时候使用*/
	public User find(String username,String password){
		Connection con=DBUtils.getDBUtils().getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "select * from user where username=? and password=?";
	    try {
			User user=(User)qr.query(con, sql,new BeanHandler<User>(User.class),username,password);
			if(user==null){
				System.out.println("UserDapImp没查出来");
			}
			else System.out.println(user);
			return user;
		} catch (SQLException e) {
               System.out.println(e.getMessage());
               throw new RuntimeException();
		}
	
	}
	
	
	/*******根据用户名查找判断用户名是否存在，注册时候使用**/
	public boolean find(String username){
		
		Connection con=DBUtils.getDBUtils().getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "select * from user where username=?";
	    try {
			User user=(User)qr.query(con, sql,new BeanHandler<User>(User.class),username);
            if(user==null){
            	System.out.println("未找到");
            	return false;
            }
            System.out.println(user);
            return true;
		} catch (SQLException e) {
               System.out.println("查询出错!");
               throw new RuntimeException();
		}
	}
	
	
	
	
}
