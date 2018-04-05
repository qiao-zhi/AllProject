package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.AccountService;

@Component
public class DeleteAccountAction extends ActionSupport{
	Logger log = Logger.getLogger(DeleteAccountAction.class);
	
	private static final long serialVersionUID = 1L;

	private String u_id;
	
	private Map<String, Object> result;
	
	@Resource
	private AccountService accountService;
	
	
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		
		try{
			
			if (ValidateCheck.isNotNull(u_id)){
				int deleteRows = accountService.deleteAccount(u_id);
				
				if(deleteRows !=0){
					result.put("del", true);
				}else{
					result.put("del", false);
				}
			}
				
		}catch(SQLException ex){
			log.error(ex.getMessage(), ex);
			
		}
		return SUCCESS;
	}

	

	public Map<String, Object> getResult() {
		return result;
	}



	public void setResult(Map<String, Object> result) {
		this.result = result;
	}



	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
}

