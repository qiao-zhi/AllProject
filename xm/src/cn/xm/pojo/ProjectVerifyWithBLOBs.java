package cn.xm.pojo;

public class ProjectVerifyWithBLOBs extends ProjectVerify {
    private String completedescription;

    private String verifyresult;

    public String getCompletedescription() {
        return completedescription;
    }

    public void setCompletedescription(String completedescription) {
        this.completedescription = completedescription == null ? null : completedescription.trim();
    }

    public String getVerifyresult() {
        return verifyresult;
    }

    public void setVerifyresult(String verifyresult) {
        this.verifyresult = verifyresult == null ? null : verifyresult.trim();
    }
}