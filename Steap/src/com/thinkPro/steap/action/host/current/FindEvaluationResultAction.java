package com.thinkPro.steap.action.host.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.specialist.EvaluationService;

@SuppressWarnings("serial")
@Component
public class FindEvaluationResultAction extends ActionSupport {
	Logger log = Logger.getLogger(FindEvaluationResultAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private EvaluationService evaluationService;
	@Resource
	private FileService fileService;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
			if(ValidateCheck.isNotNull(projectId)) {
				Map<String, Object> erAndState = evaluationService.getEvaluationResultByProjectId(projectId);
				
				result.put("success", true);
				
				if (erAndState == null) {
					Map<String, Object> condition = new HashMap<String, Object>();
					condition.put("projectId", projectId);
					condition.put("fileType", "验收意见初稿");
					
					Material material = fileService.getFile(condition);
					String text = material.getOpinionContent();
					result.put("content", text);
				} else if (erAndState != null) {
					result.put("erAndState", erAndState);
				}
			}
		} catch(SQLException ex) {
			result.put("success", false);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
