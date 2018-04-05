package cn.xm.pojo;

public class TUnitBaseInfo {
    private String unitid;

    private String unitname;

    private String upunitid;

    private String description;

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getUpunitid() {
        return upunitid;
    }

    public void setUpunitid(String upunitid) {
        this.upunitid = upunitid == null ? null : upunitid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}