package cn.qlq.core.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.qlq.core.dao.TUserMapper;
import cn.qlq.pojo.TUser;
import cn.qlq.pojo.TUserExample;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TAccountExampleTest {
	@Resource(name="TUserMapper")
	private TUserMapper tUserMapper;

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectByExample() {
		TUserExample itemsExample = new TUserExample();
		//通过criteria构造查询条件
		TUserExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("qlqq");
		//可能返回多条记录
		List<TUser> list = tUserMapper.selectByExample(itemsExample);
		
		System.out.println(list);
		
	}
	
	
	@Test
	public void testSelectByPrimaryKey() {
		TUser tUser = tUserMapper.selectByPrimaryKey(1);
		System.out.println(tUser);
	}

	
	@Test
	public void testInsert() {
		//构造 items对象
		TUser items = new TUser();
		items.setName("手机");
		tUserMapper.insert(items);
	}

	
	@Test
	public void testUpdateByPrimaryKey() {
		
		//对所有字段进行更新，需要先查询出来再更新
		TUser items = tUserMapper.selectByPrimaryKey(1);
		
		items.setName("水杯");
		
		tUserMapper.updateByPrimaryKey(items);
		//如果传入字段不空为才更新，在批量更新中使用此方法，不需要先查询再更新
		//itemsMapper.updateByPrimaryKeySelective(record);
		
	}

/*	public void test(){
		TUser items = new TUser();
		
		items.setName("水杯");
		items.setId(2);
		
		tUserMapper.updateByPrimaryKeySelective(items);
	}*/

}
