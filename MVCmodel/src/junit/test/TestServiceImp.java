package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BussinessService;
import cn.itcast.service.imp.BussinesServiceImp;

public class TestServiceImp {

	@Test 
	public void testRegister() throws ParseException{
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	    Date d=df.parse("1995-02-03");
		BussinessService bs=new BussinesServiceImp();
		User u=new User("QLQ5","123456","954318308@qq.com",d,"li��");
		try {
			bs.register(u);
			System.out.println("ע��ɹ�");//δ�׳��쳣��֤��ע��ɹ�
		} catch (UserExistException e) {
            System.out.println("�û��Ѵ���");
		}
	}
	
	
	
	@Test 
	public void testLogin() {

	  BussinessService bs=new BussinesServiceImp();
      User user=bs.login("QLQ5", "123456");
	  System.out.println(user);
	}
	
	
	
	
	
	
	

}
