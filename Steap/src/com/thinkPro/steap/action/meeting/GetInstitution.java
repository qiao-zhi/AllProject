package com.thinkPro.steap.action.meeting;

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
public class GetInstitution extends ActionSupport{

	private String institution;
	private List<String> institutionList;
	
	@Resource
	private DictionaryService dictionaryService;
	
	Logger logger = Logger.getLogger(GetInstitution.class);
	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public List<String> getInstitutionList() {
		return institutionList;
	}

	public void setInstitutionList(List<String> institutionList) {
		this.institutionList = institutionList;
	}

	@Override
	public String execute() {
		
		String dictionaryOptionName = "机构";
		Map<String,Object> institutionCon = new HashMap<String,Object>();
		institutionCon.put("dictionaryOptionName", dictionaryOptionName);
		institutionCon.put("institution", institution);
		try {
			institutionList = dictionaryService.getInstitutionList(institutionCon);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return SUCCESS;
	}
}
