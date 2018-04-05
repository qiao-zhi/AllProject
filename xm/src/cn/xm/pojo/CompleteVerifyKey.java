package cn.xm.pojo;

public class CompleteVerifyKey {
    private Integer verifyid;

    private String completeid;

    public Integer getVerifyid() {
        return verifyid;
    }

    public void setVerifyid(Integer verifyid) {
        this.verifyid = verifyid;
    }

    public String getCompleteid() {
        return completeid;
    }

    public void setCompleteid(String completeid) {
        this.completeid = completeid == null ? null : completeid.trim();
    }
}