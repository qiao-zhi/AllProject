package com.thinkPro.steap.bean.project;

public class IssueCertificate {
	private String issueId;
	private String projectId;
	private String issuePerson;
	private String issueDate;

	/**
	 * @modifier yachao
	 * @time 2016/02/02
	 * @description 增加证书领取人、联系方式、领取时间字段
	 */
	private String holder;
	private String holderPhone;
	private String holdDate;

	private String remark;

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getIssuePerson() {
		return issuePerson;
	}

	public void setIssuePerson(String issuePerson) {
		this.issuePerson = issuePerson;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getRemark() {
		return remark;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getHolderPhone() {
		return holderPhone;
	}

	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}

	public String getHoldDate() {
		return holdDate;
	}

	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "IssueCertificate [issueId=" + issueId + ", projectId=" + projectId + ", issuePerson=" + issuePerson
				+ ", issueDate=" + issueDate + ", holder=" + holder + ", holderPhone=" + holderPhone + ", holdDate="
				+ holdDate + ", remark=" + remark + "]";
	}

}
