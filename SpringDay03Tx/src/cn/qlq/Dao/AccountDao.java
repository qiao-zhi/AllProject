package cn.qlq.Dao;

public interface AccountDao {

	//加钱
	void addMoney(Integer id,Double money);
	//减钱
	void minusMoney(Integer id,Double money);
	
}
