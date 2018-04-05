package cn.xm.pojo;

public class CompleteMaterial {
    private String completeid;

    private String projectid;

    private Integer fileid;

    public String getCompleteid() {
        return completeid;
    }

    public void setCompleteid(String completeid) {
        this.completeid = completeid == null ? null : completeid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}