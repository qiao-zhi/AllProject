package com.thinkPro.steap.action.receiveMeterial;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class FindDomain extends ActionSupport{
	private List<String> domains;
	@Resource
	private DictionaryService dictionaryService;
	
	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}

	/*查询所有的领域*/
	@Override
	public String execute() throws Exception {
 		String dictionaryOptionName = "领域";
 		domains = new ArrayList<String>();
		domains = dictionaryService.getDomain(dictionaryOptionName);

		return SUCCESS;
	}
}
