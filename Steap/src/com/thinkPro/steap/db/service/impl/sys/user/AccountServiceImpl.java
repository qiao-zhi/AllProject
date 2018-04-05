package com.thinkPro.steap.db.service.impl.sys.user;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.sys.user.UserAccount;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.sys.user.IAccountMapper;
import com.thinkPro.steap.db.service.sys.user.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Resource
	private IAccountMapper accountMapper ;

	public int addAccount(UserAccount useraccount) throws SQLException {
		if(useraccount != null) {
			return accountMapper.addAccount(useraccount);
		}
		return 0;
		
	}

	public UserAccount selectAccount(Map<String, Object> useracc) throws SQLException {
		if(useracc!=null && useracc.size()>0) {
			return accountMapper.selectAccount(useracc);
		}
		return null;
	}
	
	public int deleteAccount (String u_id) throws SQLException{
		if(ValidateCheck.isNotNull(u_id)) {
			return accountMapper.deleteAccount(u_id);
		}
		return 0;
	}
	
	public UserAccount selectAccountById(String u_id) throws SQLException{
		if(ValidateCheck.isNotNull(u_id)) {
			return accountMapper.selectAccountById(u_id);
		}
		return null;
	}
	
	/**
	 * 根据用户Id变更系统登录密码
	 * @param user_account 用户ID + 账户密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateAccountPass(Map<String, Object> user_account) throws SQLException {
		if(user_account.size() != 0 && user_account.size() == 2) {
			return accountMapper.updateAccountPass(user_account);
		}
		return 0;
	}
	
	/**
	 * 根据用户Id查询系统登录密码
	 * @param userId 用户编号
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPassByUserId(String userId) throws SQLException {
		if(ValidateCheck.isNotNull(userId)) {
			return accountMapper.getPassByUserId(userId);
		}
		return null;
	}
}
