package cn.xm.pojo;

import java.util.Date;

public class EnterpriseInspect {
    private String inspectid;

    private String projectid;

    private String inspectperson;

    private Date inspectdate;

    private Boolean isaudit;

    private String inspectstatus;

    private String enterprisereceiver;

    private String inspectresult;

    public String getInspectid() {
        return inspectid;
    }

    public void setInspectid(String inspectid) {
        this.inspectid = inspectid == null ? null : inspectid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getInspectperson() {
        return inspectperson;
    }

    public void setInspectperson(String inspectperson) {
        this.inspectperson = inspectperson == null ? null : inspectperson.trim();
    }

    public Date getInspectdate() {
        return inspectdate;
    }

    public void setInspectdate(Date inspectdate) {
        this.inspectdate = inspectdate;
    }

    public Boolean getIsaudit() {
        return isaudit;
    }

    public void setIsaudit(Boolean isaudit) {
        this.isaudit = isaudit;
    }

    public String getInspectstatus() {
        return inspectstatus;
    }

    public void setInspectstatus(String inspectstatus) {
        this.inspectstatus = inspectstatus == null ? null : inspectstatus.trim();
    }

    public String getEnterprisereceiver() {
        return enterprisereceiver;
    }

    public void setEnterprisereceiver(String enterprisereceiver) {
        this.enterprisereceiver = enterprisereceiver == null ? null : enterprisereceiver.trim();
    }

    public String getInspectresult() {
        return inspectresult;
    }

    public void setInspectresult(String inspectresult) {
        this.inspectresult = inspectresult == null ? null : inspectresult.trim();
    }
}