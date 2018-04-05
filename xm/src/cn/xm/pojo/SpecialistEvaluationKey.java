package cn.xm.pojo;

public class SpecialistEvaluationKey {
    private String specialistid;

    private String projectid;

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
}