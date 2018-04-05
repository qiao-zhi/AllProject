package cn.qlq.Test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.qlq.Service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AccountServiceImplTest {

	@Value("${aaa}")
	private String jd;
	
	@Resource(name="accountService")
	private AccountService as;
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		as.transfer(1, 2, 100d);
		System.out.println(jd);
		
		
	}

}
