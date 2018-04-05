package com.thinkPro.steap.bean.specialist;

public class Specialist {
	private String specialistId; // 专家编号
	private String name; // 姓名
	private String sex; // 性别
	private String password; // 密码
	private String signaturePass; // 签名密码
	private String birthday; // 出生日期
	private String workUnit;// 工作单位
	private String engageDomain; // 从事领域
	private String duty; // 职务
	private String title; // 职称
	private String telephone; // 联系电话
	private String email; // 电子邮箱
	private String signature;
	/** ------------------------------------- **/
	private String source; // 专家来源
	private String leader;
	private String major;
	private String degree;
	private String ZJZY;

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignaturePass() {
		return signaturePass;
	}

	public void setSignaturePass(String signaturePass) {
		this.signaturePass = signaturePass;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEngageDomain() {
		return engageDomain;
	}

	public void setEngageDomain(String engageDomain) {
		this.engageDomain = engageDomain;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getZJZY() {
		return ZJZY;
	}

	public void setZJZY(String zJZY) {
		ZJZY = zJZY;
	}

	@Override
	public String toString() {
		return "Specialist [specialistId=" + specialistId + ", name=" + name + ", sex=" + sex + ", password=" + password
				+ ", signaturePass=" + signaturePass + ", birthday=" + birthday + ", workUnit=" + workUnit
				+ ", engageDomain=" + engageDomain + ", duty=" + duty + ", title=" + title + ", telephone=" + telephone
				+ ", email=" + email + ", signature=" + signature + ", source=" + source + ", leader=" + leader
				+ ", major=" + major + ", degree=" + degree + ", ZJZY=" + ZJZY + "]";
	}


}