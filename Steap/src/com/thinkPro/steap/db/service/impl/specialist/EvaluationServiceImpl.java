package com.thinkPro.steap.db.service.impl.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.evaluation.EvaluationInfo;
import com.thinkPro.steap.bean.evaluation.EvaluationResult;
import com.thinkPro.steap.bean.evaluation.SpecialistEvaluation;
import com.thinkPro.steap.db.mapper.specialist.IEvaluationMapper;
import com.thinkPro.steap.db.service.specialist.EvaluationService;

@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {
	
	@Resource
	private IEvaluationMapper evaluationMapper;

	/**
	 * 录入专家评审意见信息
	 * @param specialistEvaluation 专家评审意见
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertSpecialistEvaluation(SpecialistEvaluation specialistEvaluation) throws SQLException {
		if(specialistEvaluation != null) {
			return evaluationMapper.insertSpecialistEvaluation(specialistEvaluation);
		}
		return 0;
	}

	/**
	 * 修改专家评审意见信息
	 * @param specialistEvaluation
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateSpecialistEvaluation(SpecialistEvaluation specialistEvaluation) throws SQLException { 
		if(specialistEvaluation != null) {
			return evaluationMapper.updateSpecialistEvaluation(specialistEvaluation);
		}
		return 0;
	}	
	
	/**
	 * 录入项目评审结果
	 * @param evaluationResult 项目评审结果
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertEvaluationResult(EvaluationResult evaluationResult) throws SQLException {
		if(evaluationResult != null) {
			return evaluationMapper.insertEvaluationResult(evaluationResult);
		}
		return 0;
	}
	
	/**
	 * 修改项目评审结果
	 * @param evaluationResult
	 * @return
	 * @throws SQLException
	 */
	public int updateEvaluationResult(EvaluationResult evaluationResult) throws SQLException {
		if(evaluationResult != null) {
			return evaluationMapper.updateEvaluationResult(evaluationResult);
		}
		return 0;
	}
	
	/**
	 * 根据项目编号查询专家评审信息
	 * @param projectId 项目编号
	 * @return 专家评审信息列表
	 * @throws SQLException
	 */
	public List<EvaluationInfo> getSpecialistEvaluationList(String projectId) throws SQLException {
		if(projectId != null && !"".equals(projectId)) {
			return evaluationMapper.getSpecialistEvaluationList(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目编号和专家编号查询评审意见
	 * @param evaluationInfo 项目编号和专家编号
	 * @return 评审意见
	 * @throws SQLException
	 */
	public String getSpecialistEvaluation(Map<String, Object> evaluationInfo) throws SQLException,NullPointerException {
		if(evaluationInfo != null && evaluationInfo.size() != 0) {
			return evaluationMapper.getSpecialistEvaluation(evaluationInfo);
		}
		return null;
	}
	
	/**
	 * 根据项目编号和专家编号获取评审意见和评审意见状态
	 * @param evaluationInfo
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getEvaluationAndState(Map<String, Object> evaluationInfo) throws SQLException {
		if(evaluationInfo != null && evaluationInfo.size() > 0 && evaluationInfo.size() == 2) {
			return evaluationMapper.getEvaluationAndState(evaluationInfo);
		}
		return null;
	}
	
	/**
	 * 根据专家编号和会议状态当前专家获取待评审项目数
	 * @param meeting_specialist 专家编号、会议状态
	 * @return 待评审项目数
	 * @throws SQLException
	 */
	public int getEvaluatedProjectCount(Map<String, Object> meeting_specialist) throws SQLException {
		if(meeting_specialist != null && meeting_specialist.size() != 0) {
			return evaluationMapper.getEvaluatedProjectCount(meeting_specialist);
		}
		return 0;
	}
	
	public Map<String, Object> getEvaluationResultByProjectId(String projectId) throws SQLException {
		if(projectId != null && !"".equals(projectId)) {
			return evaluationMapper.getEvaluationResultByProjectId(projectId);
		}
		return null;
	}
	
	public int getEntryEvaluationCount(Map<String, Object> project_remark) throws SQLException {
		if(project_remark != null && project_remark.size() > 0 && project_remark.size() == 2) {
			return evaluationMapper.getEntryEvaluationCount(project_remark);
		}
		return 0;
	}
	
	public int updateOpinionStatus(Map<String, Object> opinion_status) throws SQLException {
		if (opinion_status.size() > 0) {
			return evaluationMapper.updateOpinionStatus(opinion_status);
		}
		return 0;
	}

	@Override
	public int getEvaluatingProjectCount(Map<String, Object> specialist_meeting) throws SQLException {
		if (specialist_meeting != null && specialist_meeting.size() > 0) {
			return evaluationMapper.getEvaluatingProjectCount(specialist_meeting);
		}
		return 0;
	}
}
