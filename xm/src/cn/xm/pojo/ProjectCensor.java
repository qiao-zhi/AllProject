package cn.xm.pojo;

import java.util.Date;

public class ProjectCensor {
    private String censorid;

    private String projectid;

    private Date censordate;

    private String censorperson;

    private String censorresult;

    public String getCensorid() {
        return censorid;
    }

    public void setCensorid(String censorid) {
        this.censorid = censorid == null ? null : censorid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public Date getCensordate() {
        return censordate;
    }

    public void setCensordate(Date censordate) {
        this.censordate = censordate;
    }

    public String getCensorperson() {
        return censorperson;
    }

    public void setCensorperson(String censorperson) {
        this.censorperson = censorperson == null ? null : censorperson.trim();
    }

    public String getCensorresult() {
        return censorresult;
    }

    public void setCensorresult(String censorresult) {
        this.censorresult = censorresult == null ? null : censorresult.trim();
    }
}