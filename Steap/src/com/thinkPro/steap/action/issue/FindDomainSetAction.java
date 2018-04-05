package com.thinkPro.steap.action.issue;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class FindDomainSetAction extends ActionSupport {
	
	Logger log = Logger.getLogger(FindDomainSetAction.class);

	private List<String> domains;
	private Map<String, Object> result;
	
	@Resource
	private DictionaryService dictionaryService;

	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try{
			domains = dictionaryService.getDomain("领域");
			
			result.put("domains", domains);
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
