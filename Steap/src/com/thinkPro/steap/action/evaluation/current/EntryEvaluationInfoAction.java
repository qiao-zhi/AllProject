package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.evaluation.SpecialistEvaluation;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.EvaluationService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class EntryEvaluationInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(EntryEvaluationInfoAction.class);

	private String meetingId;
	private SpecialistEvaluation specialistEvaluation;
	private String operationType;
	private Map<String, Object> result;

	@Resource
	private SpecialistService specialistService;
	@Resource
	private EvaluationService evaluationService;
	@Resource
	private ProjectService projectService;
	
	private static final String SAVE = "0"; // 保存操作
	private static final String SUBMIT = "1"; // 提交操作

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			log.info("---------------------------------------------");
			log.info("specialistEvaluation: " + specialistEvaluation);
			log.info("---------------------------------------------");
			
			if (specialistEvaluation != null && operationType != null) {
				
				/* 进行检测进行录入操作还是进行更新操作*/
				Map<String, Object> evaluationInfo = new HashMap<String, Object>();
				evaluationInfo.put("specialistId", specialistEvaluation.getSpecialistId());
				evaluationInfo.put("projectId", specialistEvaluation.getProjectId());
				
				if("提交".equals(operationType)) {
					specialistEvaluation.setRemark(SUBMIT);
				} else if("保存".equals(operationType)) {
					specialistEvaluation.setRemark(SAVE);
				}
				
				String specialist_evaluation = evaluationService.getSpecialistEvaluation(evaluationInfo);
				int insertRows = -1;
				if(specialist_evaluation == null) {
					insertRows = evaluationService.insertSpecialistEvaluation(specialistEvaluation);
					log.info("Insert specialist evaluation info is ok! insertRows = " + insertRows);
					
				} else { // 当已经录入过专家评审意见时，只能更新评审意见
					insertRows = evaluationService.updateSpecialistEvaluation(specialistEvaluation);
					log.info("Update specialist evaluation info is ok! updateRows = " + insertRows);
				}
				
				if(insertRows > 0) {
					Map<String, Object> project_remark = new HashMap<String, Object>();
					project_remark.put("projectId", specialistEvaluation.getProjectId());
					project_remark.put("remark", SUBMIT);
					int evaluationCount = evaluationService.getEntryEvaluationCount(project_remark); // 当前项目已提交的评审意见数
					int specialistCount = specialistService.getMeetingSpecialistCount(meetingId); // 当前项目评审专家数
					
					if (evaluationCount == specialistCount) {
						Map<String, Object> projectStatus = new HashMap<String, Object>();
						projectStatus.put("projectId", specialistEvaluation.getProjectId());
						projectStatus.put("projectStatus", "已评审");
						
						int updateRows = projectService.updateProjectCurrentStatus(projectStatus);
						log.info("Updating project status is ok! UpdateRows = " + updateRows);
					}
				}
				
				boolean insert = insertRows > 0 ? true : false;
				result.put("insert", insert);
			}
		} catch (SQLException ex) {
			result.put("insert", false);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public SpecialistEvaluation getSpecialistEvaluation() {
		return specialistEvaluation;
	}

	public void setSpecialistEvaluation(SpecialistEvaluation specialistEvaluation) {
		this.specialistEvaluation = specialistEvaluation;
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

}
