package com.thinkPro.steap.bean.evaluation;

public class EvaluationResult {
	private String evaluateResultId; // 评审结果编号
	private String projectId; // 项目编号
	private String evaluateResult; // 评审结果
	private String checkDate; // 验收日期
	private String specialistId; // 录入最终评审结果的专家编号
	private String remark; // 备注

	public String getEvaluationResultId() {
		return evaluateResultId;
	}

	public void setEvaluationResultId(String evaluateResultId) {
		this.evaluateResultId = evaluateResultId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEvaluateResult() {
		return evaluateResult;
	}

	public void setEvaluateResult(String evaluateResult) {
		this.evaluateResult = evaluateResult;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "EvaluationResult [evaluateResultId=" + evaluateResultId + ", projectId=" + projectId
				+ ", evaluateResult=" + evaluateResult + ", checkDate=" + checkDate + ", specialistId=" + specialistId
				+ ", remark=" + remark + "]";
	}
}
