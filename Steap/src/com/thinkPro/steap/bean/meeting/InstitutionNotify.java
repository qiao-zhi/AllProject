package com.thinkPro.steap.bean.meeting;

/**
 * 通知机构相关人员
 * 仅用于显示数据
 */
public class InstitutionNotify {

	private String notifyId;// 通知编号
	private String meetingId;// 会议编号
	private String institutionName;// 机构名称
	private String contactPerson;// 企业联系人
	private String notifier;// 通知人
	private String notifyDate;// 通知日期
	private String notifyMethod;// 通知方法
	private String notifyResult;//通知结果

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getNotifier() {
		return notifier;
	}

	public void setNotifier(String notifier) {
		this.notifier = notifier;
	}

	public String getNotifyDate() {
		return notifyDate;
	}

	public void setNotifyDate(String notifyDate) {
		this.notifyDate = notifyDate;
	}

	public String getNotifyMethod() {
		return notifyMethod;
	}

	public void setNotifyMethod(String notifyMethod) {
		this.notifyMethod = notifyMethod;
	}

	public String getNotifyResult() {
		return notifyResult;
	}

	public void setNotifyResult(String notifyResult) {
		this.notifyResult = notifyResult;
	}

	@Override
	public String toString() {
		return "InstitutionNotify [notifyId=" + notifyId + ", meetingId="
				+ meetingId + ", institutionName=" + institutionName
				+ ", contactPerson=" + contactPerson + ", notifier=" + notifier
				+ ", notifyDate=" + notifyDate + ", notifyMethod="
				+ notifyMethod + ", notifyResult=" + notifyResult + "]";
	}

}
