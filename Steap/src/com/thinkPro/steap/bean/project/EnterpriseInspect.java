package com.thinkPro.steap.bean.project;


public class EnterpriseInspect {
	private String inspectId; // 考察编号
	private String projectId; // 项目编号
	private String inspectPerson; // 考察人
	private String inspectDate; // 考察日期
	private String inspectResult; // 考察结果
	private boolean isAudit; // 是否审计
	private String inspectStatus;//考察状态
	private String enterpriseReceiver;
	
	public String getEnterpriseReceiver() {
		return enterpriseReceiver;
	}

	public void setEnterpriseReceiver(String enterpriseReceiver) {
		this.enterpriseReceiver = enterpriseReceiver;
	}

	public String getInspectId() {
		return inspectId;
	}

	public void setInspectId(String inspectId) {
		this.inspectId = inspectId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getInspectPerson() {
		return inspectPerson;
	}

	public void setInspectPerson(String inspectPerson) {
		this.inspectPerson = inspectPerson;
	}

	public String getInspectDate() {
		return inspectDate;
	}

	public void setInspectDate(String inspectDate) {
		this.inspectDate = inspectDate;
	}

	public String getInspectResult() {
		return inspectResult;
	}

	public void setInspectResult(String inspectResult) {
		this.inspectResult = inspectResult;
	}

	public boolean isAudit() {
		return isAudit;
	}

	public void setAudit(boolean isAudit) {
		this.isAudit = isAudit;
	}

	public String getInspectStatus() {
		return inspectStatus;
	}

	public void setInspectStatus(String inspectStatus) {
		this.inspectStatus = inspectStatus;
	}

	@Override
	public String toString() {
		return "EnterpriseInspect [inspectId=" + inspectId + ", projectId="
				+ projectId + ", inspectPerson=" + inspectPerson
				+ ", inspectDate=" + inspectDate + ", inspectResult="
				+ inspectResult + ", isAudit=" + isAudit + ", inspectStatus="
				+ inspectStatus + "]";
	}

}
