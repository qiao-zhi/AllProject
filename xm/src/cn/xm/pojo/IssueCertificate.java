package cn.xm.pojo;

import java.util.Date;

public class IssueCertificate {
    private String issueid;

    private String projectid;

    private String issueperson;

    private Date issuedate;

    private String remark;

    private String holder;

    private String holderphone;

    private Date holddate;

    public String getIssueid() {
        return issueid;
    }

    public void setIssueid(String issueid) {
        this.issueid = issueid == null ? null : issueid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getIssueperson() {
        return issueperson;
    }

    public void setIssueperson(String issueperson) {
        this.issueperson = issueperson == null ? null : issueperson.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder == null ? null : holder.trim();
    }

    public String getHolderphone() {
        return holderphone;
    }

    public void setHolderphone(String holderphone) {
        this.holderphone = holderphone == null ? null : holderphone.trim();
    }

    public Date getHolddate() {
        return holddate;
    }

    public void setHolddate(Date holddate) {
        this.holddate = holddate;
    }
}