package com.thinkPro.steap.db.service.sys.user;

import java.sql.SQLException;
import java.util.Map;

import com.thinkPro.steap.bean.sys.user.UserAccount;

public interface AccountService {

	public int addAccount(UserAccount useraccount) throws SQLException;

	public UserAccount selectAccount(Map<String, Object> useracc) throws SQLException;
	
	public int deleteAccount (String u_id) throws SQLException;
	
	public UserAccount selectAccountById(String u_id) throws SQLException;
	
	/**
	 * 根据用户Id变更系统登录密码
	 * @param user_account 用户ID + 账户密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateAccountPass(Map<String, Object> user_account) throws SQLException;
	
	/**
	 * 根据用户Id查询系统登录密码
	 * @param userId 用户编号
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPassByUserId(String userId) throws SQLException;
}
