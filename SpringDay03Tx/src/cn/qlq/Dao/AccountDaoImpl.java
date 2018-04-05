package cn.qlq.Dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


//使用JdbcDaoSupport需要在配置文件中注入dataSource才可以直接操作数据库
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void addMoney(Integer id, Double money) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update("update t_account set money=money+? where id=? ",money,id);
	}

	@Override
	public void minusMoney(Integer id, Double money) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update("update t_account set money=money-? where id=? ",money,id);
		
	}



}
