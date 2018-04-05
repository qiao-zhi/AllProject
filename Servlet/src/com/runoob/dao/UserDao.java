package com.runoob.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

	public void find() {
		try {
			Connection con=ConnectDb.getconnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
