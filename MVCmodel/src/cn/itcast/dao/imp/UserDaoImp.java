package cn.itcast.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.web.utils.DBUtils;

public class UserDaoImp implements UserDao {
	/******�����û�**/
	public void add(User user){
		Connection con=DBUtils.getDBUtils().getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "insert into user values (?,?,?,?,?)";
		Object ins[]={user.getUsername(),user.getPassword(),user.getEmail(),user.getBirthday(),user.getNickname()};
		try {
			qr.update(con,sql,ins);
			System.out.println("����ɹ���");	
		} catch (SQLException e) {
              System.out.println("�������ݿ����");
		}
	}
	
	
	/******�����û��������û��������룬��¼ʱ��ʹ��*/
	public User find(String username,String password){
		Connection con=DBUtils.getDBUtils().getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "select * from user where username=? and password=?";
	    try {
			User user=(User)qr.query(con, sql,new BeanHandler<User>(User.class),username,password);
			if(user==null){
				System.out.println("UserDapImpû�����");
			}
			else System.out.println(user);
			return user;
		} catch (SQLException e) {
               System.out.println(e.getMessage());
               throw new RuntimeException();
		}
	
	}
	
	
	/*******�����û��������ж��û����Ƿ���ڣ�ע��ʱ��ʹ��**/
	public boolean find(String username){
		
		Connection con=DBUtils.getDBUtils().getConnection();
		QueryRunner  qr=new QueryRunner();
		String sql = "select * from user where username=?";
	    try {
			User user=(User)qr.query(con, sql,new BeanHandler<User>(User.class),username);
            if(user==null){
            	System.out.println("δ�ҵ�");
            	return false;
            }
            System.out.println(user);
            return true;
		} catch (SQLException e) {
               System.out.println("��ѯ����!");
               throw new RuntimeException();
		}
	}
	
	
	
	
}
