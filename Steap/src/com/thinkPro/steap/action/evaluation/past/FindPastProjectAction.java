package com.thinkPro.steap.action.evaluation.past;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.project.ProjectService;

/**
 * 查询专家已经评审过的项目
 * 
 * @author yachao
 * 
 */
@SuppressWarnings("serial")
@Component
public class FindPastProjectAction extends ActionSupport {
	Logger log = Logger.getLogger(FindPastProjectAction.class);
	
	private String specialistId;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
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
		try {
			
			System.out.println("specialistId: " + specialistId);
			if(ValidateCheck.isNotNull(specialistId)) {
				List<Map<String, Object>> projects = projectService.getPastProjectsBySpecialistId(specialistId);
				
				result.put("projects", projects);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
