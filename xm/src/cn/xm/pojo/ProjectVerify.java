package cn.xm.pojo;

import java.util.Date;

public class ProjectVerify {
    private Integer verifyid;

    private String projectid;

    private Integer verifyfilenum;

    private String verifyperson;

    private Date verifydate;

    private String remark;

    public Integer getVerifyid() {
        return verifyid;
    }

    public void setVerifyid(Integer verifyid) {
        this.verifyid = verifyid;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public Integer getVerifyfilenum() {
        return verifyfilenum;
    }

    public void setVerifyfilenum(Integer verifyfilenum) {
        this.verifyfilenum = verifyfilenum;
    }

    public String getVerifyperson() {
        return verifyperson;
    }

    public void setVerifyperson(String verifyperson) {
        this.verifyperson = verifyperson == null ? null : verifyperson.trim();
    }

    public Date getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(Date verifydate) {
        this.verifydate = verifydate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}