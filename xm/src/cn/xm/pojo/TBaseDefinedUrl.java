package cn.xm.pojo;

public class TBaseDefinedUrl {
    private String id;

    private String moduleid;

    private String modulename;

    private String moduleurl;

    private String memo1;

    private String momo2;

    private Boolean inuse;

    private Integer sortno;

    private Integer menuclass;

    private Integer flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getModuleurl() {
        return moduleurl;
    }

    public void setModuleurl(String moduleurl) {
        this.moduleurl = moduleurl == null ? null : moduleurl.trim();
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1 == null ? null : memo1.trim();
    }

    public String getMomo2() {
        return momo2;
    }

    public void setMomo2(String momo2) {
        this.momo2 = momo2 == null ? null : momo2.trim();
    }

    public Boolean getInuse() {
        return inuse;
    }

    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Integer getMenuclass() {
        return menuclass;
    }

    public void setMenuclass(Integer menuclass) {
        this.menuclass = menuclass;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}