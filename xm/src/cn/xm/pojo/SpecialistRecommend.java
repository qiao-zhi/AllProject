package cn.xm.pojo;

import java.util.Date;

public class SpecialistRecommend {
    private String specialistid;

    private String projectid;

    private String name;

    private String sex;

    private String password;

    private String signaturepass;

    private Date birthday;

    private String engagedomain;

    private String duty;

    private String title;

    private String telephone;

    private String email;

    private String signature;

    private Date lastlogintime;

    private String workunit;

    public String getSpecialistid() {
        return specialistid;
    }

    public void setSpecialistid(String specialistid) {
        this.specialistid = specialistid == null ? null : specialistid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSignaturepass() {
        return signaturepass;
    }

    public void setSignaturepass(String signaturepass) {
        this.signaturepass = signaturepass == null ? null : signaturepass.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEngagedomain() {
        return engagedomain;
    }

    public void setEngagedomain(String engagedomain) {
        this.engagedomain = engagedomain == null ? null : engagedomain.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit == null ? null : workunit.trim();
    }
}