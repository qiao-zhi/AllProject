package com.thinkPro.steap.db.mapper.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.evaluation.EvaluationInfo;
import com.thinkPro.steap.bean.evaluation.EvaluationResult;
import com.thinkPro.steap.bean.evaluation.SpecialistEvaluation;


public interface IEvaluationMapper {
	
	/**
	 * 录入专家评审意见信息
	 * @param specialistEvaluation 专家评审意见
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertSpecialistEvaluation(SpecialistEvaluation specialistEvaluation) throws SQLException;
	
	/**
	 * 修改专家评审意见信息
	 * @param specialistEvaluation
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateSpecialistEvaluation(SpecialistEvaluation specialistEvaluation) throws SQLException;
	
	/**
	 * 根据项目编号和专家编号获取评审意见和评审意见状态
	 * @param evaluationInfo
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getEvaluationAndState(Map<String, Object> evaluationInfo) throws SQLException;
	
	/**
	 * 录入项目评审结果
	 * @param evaluationResult 项目评审结果
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertEvaluationResult(EvaluationResult evaluationResult) throws SQLException;
	
	/**
	 * 修改项目评审结果
	 * @param evaluationResult
	 * @return
	 * @throws SQLException
	 */
	public int updateEvaluationResult(EvaluationResult evaluationResult) throws SQLException;
	
	/**
	 * 根据项目编号查询专家评审信息
	 * @param projectId 项目编号
	 * @return 专家评审信息列表
	 * @throws SQLException
	 */
	public List<EvaluationInfo> getSpecialistEvaluationList(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号和专家编号查询评审意见
	 * @param evaluationInfo 项目编号和专家编号
	 * @return 评审意见
	 * @throws SQLException
	 */
	public String getSpecialistEvaluation(Map<String, Object> evaluationInfo) throws SQLException, NullPointerException;
	
	/**
	 * 根据专家编号和会议状态当前专家获取待评审项目数
	 * @param meeting_specialist 专家编号、会议状态
	 * @return 待评审项目数
	 * @throws SQLException
	 */
	public int getEvaluatedProjectCount(Map<String, Object> meeting_specialist) throws SQLException;
	
	public Map<String, Object> getEvaluationResultByProjectId(String projectId) throws SQLException;
	
	public int getEntryEvaluationCount(Map<String, Object> project_remark) throws SQLException;
	
	public int updateOpinionStatus(Map<String, Object> opinion_status) throws SQLException;
	
	public int getEvaluatingProjectCount(Map<String, Object> specialist_meeting) throws SQLException;
}
