package cn.xm.pojo;

import java.util.Date;

public class EvaluationResult {
    private String evaluateresultid;

    private String projectid;

    private String specialistid;

    private String remark;

    private Date checkdate;

    private String evaluateresult;

    public String getEvaluateresultid() {
        return evaluateresultid;
    }

    public void setEvaluateresultid(String evaluateresultid) {
        this.evaluateresultid = evaluateresultid == null ? null : evaluateresultid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getSpecialistid() {
        return specialistid;
    }

    public void setSpecialistid(String specialistid) {
        this.specialistid = specialistid == null ? null : specialistid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getEvaluateresult() {
        return evaluateresult;
    }

    public void setEvaluateresult(String evaluateresult) {
        this.evaluateresult = evaluateresult == null ? null : evaluateresult.trim();
    }
}