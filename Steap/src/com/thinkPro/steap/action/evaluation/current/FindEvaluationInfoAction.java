package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.EvaluationService;

@SuppressWarnings("serial")
@Component
public class FindEvaluationInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(FindEvaluationInfoAction.class);

	private String projectId;
	private String specialistId;
	private Map<String, Object> result;
	
	@Resource
	private EvaluationService evaluationService;
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

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
			log.info("projectId: " + projectId);
			log.info("specialistId: " + specialistId);
			if(ValidateCheck.isNotNull(projectId) && ValidateCheck.isNotNull(specialistId)) {
				Map<String, Object> evaluationInfo = new HashMap<String, Object>();
			    evaluationInfo.put("projectId", projectId);
				evaluationInfo.put("specialistId", specialistId);		
				try {
					Map<String, Object> rsAndState = evaluationService.getEvaluationAndState(evaluationInfo);
					if(rsAndState.size() > 0) {
						result.put("rsAndState", rsAndState);
					}
				} catch(NullPointerException ex) {
					result.put("rsAndState", null);
//					log.error(ex.getMessage(), ex);
				}
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
