package cn.qlq.core.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import cn.qlq.Service.TestZhuJie;
import cn.qlq.core.dao.SelectUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class springMybatisTest {
//	注入值
	@Resource(name="selectUser")
	private SelectUser ud;
	@Resource(name="testZhuJie")
	private TestZhuJie zj;
	@Test
//	原始的mybatisDao实现测试
	public void fun1(){
		System.out.println("------------这是原始dao开发整合------------");
		System.out.println(ud.findUser());
		
	}
	
//	mapper代理测试
	@Test
	public void test2(){
		System.out.println("-------这是mapper代理整合---------");
		System.out.println(ud.findUser());
	}

//	测试注解扫描
	@Test
	public void test3(){
		zj.test();
	}
}
