package cn.xm.junitTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xm.mapper.TUserBaseInfoMapper;
import cn.xm.pojo.TUserBaseInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class springMybatisTest {
//	注入值
	@Resource(name="TUserBaseInfoMapper")
	private TUserBaseInfoMapper ud;

	
//	与mybatis整合成功
	@Test
	public void fun1(){
		TUserBaseInfo tbi;
		tbi = ud.selectByPrimaryKey("U100001");
		System.out.println(tbi);
		
	}
	
	

}
