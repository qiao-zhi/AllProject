package cn.qlq.service;

import java.sql.SQLException;

public interface UserService {

	void save();
	boolean save(String userId)throws Exception;
	void update();
	void delete();
	void find();
}
