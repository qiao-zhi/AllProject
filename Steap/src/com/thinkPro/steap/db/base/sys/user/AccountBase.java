package com.thinkPro.steap.db.base.sys.user;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.user.UserAccount;
import com.thinkPro.steap.db.mapper.sys.user.IAccountMapper;

public class AccountBase implements IAccountMapper {

	private ApplicationContext applicationContext;
	private IAccountMapper accountMapper;
	
	
	public AccountBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountMapper = (IAccountMapper) applicationContext.getBean("IAccountMapper");
	}


	@Override
	public int addAccount(UserAccount useraccount) throws SQLException {
		return accountMapper.addAccount(useraccount);
	}


	@Override
	public UserAccount selectAccount(Map<String, Object> useracc)
			throws SQLException {
		return accountMapper.selectAccount(useracc);
	}


	@Override
	public int deleteAccount(String u_id) throws SQLException {
		return accountMapper.deleteAccount(u_id);
	}


	@Override
	public UserAccount selectAccountById(String u_id) throws SQLException {
		return accountMapper.selectAccountById(u_id);
		
	}

	/**
	 * 根据用户Id变更系统登录密码
	 * @param user_account 用户ID + 账户密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateAccountPass(Map<String, Object> user_account) throws SQLException {
		return accountMapper.updateAccountPass(user_account);
	}
	
	/**
	 * 根据用户Id查询系统登录密码
	 * @param userId 用户编号
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPassByUserId(String userId) throws SQLException {
		return accountMapper.getPassByUserId(userId);
	}
}