package cn.xm.jwxt.bean.system;

public class Role {
    private String roleid;

    private String rolename;

    private String rolestatus;

    private String description;

    private String insituteid;

    private String remark;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(String rolestatus) {
        this.rolestatus = rolestatus == null ? null : rolestatus.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getInsituteid() {
        return insituteid;
    }

    public void setInsituteid(String insituteid) {
        this.insituteid = insituteid == null ? null : insituteid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}