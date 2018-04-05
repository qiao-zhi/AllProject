package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.UserAccount;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.AccountService;

@SuppressWarnings("serial")
@Component
public class CreateAccountAction extends ActionSupport {
	Logger log = Logger.getLogger(CreateAccountAction.class);

	private UserAccount useracc = new UserAccount();
	private Map<String, Object> result;
	
	@Resource
	private AccountService accountService;
	
	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try{
			if(useracc != null) {
				if(ValidateCheck.isNotNull(useracc.getAccount()) && ValidateCheck.isNotNull(useracc.getPassword())) {
					Map<String, Object> us=new HashMap<String, Object>();
					us.put("account", useracc.getAccount());
					
					UserAccount uac = accountService.selectAccount(us);
					
					if(uac == null){
						int insertRows = accountService.addAccount(useracc);
						result.put("insertRows",insertRows);
					}
				}
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(), ex);
			
		}
		return SUCCESS;
	}

	public UserAccount getUseracc() {
		return useracc;
	}

	public void setUseracc(UserAccount useracc) {
		this.useracc = useracc;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}


}
