package cn.qlq.core.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.qlq.pojo.User;


//原始DAO开发需要实现类 ，且需要继承SqlSessionDaoSupport
public class SelectUserImpl extends SqlSessionDaoSupport implements SelectUser {

	@Override
	public List<User> findUser() {
		SqlSession sqlSession = this.getSqlSession();
		
		List<User> list =  sqlSession.selectList("test.findUser");

		System.out.println(list);
		
		return list;
	}

}
