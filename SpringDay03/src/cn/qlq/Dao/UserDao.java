package cn.qlq.Dao;

import java.util.List;

import cn.qlq.bean.User;

public interface UserDao {
//	增删改
	void save(User u);
	void deleteById(int i);
	void update(User u);
	
//	查询单个
	User findById(int  id);
//	查询所有
	List<User> findAll();
//	查询巨鹿数，用于分页
	int  getTotalCount();

}
