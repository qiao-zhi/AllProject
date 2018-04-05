package com.thinkPro.steap.action.host.current;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.evaluation.EvaluationResult;
import com.thinkPro.steap.common.DateHandler;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.EvaluationService;

/**
 * 录入评审结果
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class EntryEvaluationResultAction extends ActionSupport {
	Logger log = Logger.getLogger(EntryEvaluationResultAction.class);
	
	private EvaluationResult evaluationResult;
	private String operationType;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;
	@Resource
	private EvaluationService evaluationService;
	
	private static final String SAVE = "0"; // 保存评估结果
	private static final String SUBMIT = "1"; // 提交评估结果

	public EvaluationResult getEvaluationResult() {
		return evaluationResult;
	}

	public void setEvaluationResult(EvaluationResult evaluationResult) {
		this.evaluationResult = evaluationResult;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
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
			if(evaluationResult != null && operationType != null) {
				evaluationResult.setCheckDate(DateHandler.dateToString(new Date()));
				
				boolean isSubmit = false;
				if("提交".equals(operationType)) {
					evaluationResult.setRemark(SUBMIT);
					isSubmit = true;
				} else if("保存".equals(operationType)) {
					evaluationResult.setRemark(SAVE);
				}
				
				/* 录入项目评审结果或修改项目评审结果*/
				int insertRows = -1;
				Map<String, Object> evaAndRemark = evaluationService.getEvaluationResultByProjectId(evaluationResult.getProjectId());
				if(evaAndRemark == null || evaAndRemark.get("evaluateResult") == null) {
					insertRows = evaluationService.insertEvaluationResult(evaluationResult);
					log.info("Insert evaluation result info is ok! insertRows = " + insertRows);
				} else {
					insertRows = evaluationService.updateEvaluationResult(evaluationResult);
					log.info("Update evaluation result info is ok! updateRows = " + insertRows);
				}
					
				/* 修改项目状态*/
				if(insertRows > 0 && isSubmit) {
					Map<String, Object> projectStatus = new HashMap<String, Object>();
					projectStatus.put("projectId", evaluationResult.getProjectId());
					projectStatus.put("projectStatus", "已评估");
					
					int updateRows = projectService.updateProjectCurrentStatus(projectStatus);
					log.info("Updating project status is ok! UpdateRows = " + updateRows);
				}
			}
		} catch(SQLException ex) {
			
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
