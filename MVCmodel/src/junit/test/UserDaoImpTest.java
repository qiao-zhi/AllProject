package junit.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.imp.UserDaoImp;
import cn.itcast.domain.User;

public class UserDaoImpTest {

    @Test
	public void test() throws ParseException {
//    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//    Date d=df.parse("1995-02-03");
//	User u=new User("QLQ3","123456","954318308@qq.com",d,"li×Ó");
	UserDao udt=new UserDaoImp();
	udt.find("QLQ4");
	
	
	}

}
