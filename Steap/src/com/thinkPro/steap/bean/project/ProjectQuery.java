package com.thinkPro.steap.bean.project;

public class ProjectQuery {
	private String projectId;  // 项目编号
	private String projectName; // 项目名称
	private String domain; // 领域
	private String projectFunds; // 经费
	private String startDate; //开始事件
	private String endDate; //结束事件
	private String applicant; //申请单位
	private String status; //项目状态

	private int pageSize; //每页记录数
	private int pageBegin;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getProjectFunds() {
		return projectFunds;
	}
	public void setProjectFunds(String projectFunds) {
		this.projectFunds = projectFunds;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	@Override
	public String toString() {
		return "ProjectQuery [projectId=" + projectId + ", projectName=" + projectName + ", domain=" + domain
				+ ", projectFunds=" + projectFunds + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", applicant=" + applicant + ", status=" + status + ", pageSize=" + pageSize + ", pageBegin="
				+ pageBegin + "]";
	}
	
}
