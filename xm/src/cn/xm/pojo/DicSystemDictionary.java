package cn.xm.pojo;

public class DicSystemDictionary {
    private String dictionaryoptionid;

    private String dictionaryoptionname;

    private String updictionaryoptionid;

    private Boolean isuse;

    private String description;

    private Integer sortno;

    private Integer flag;

    private String englishname;

    private String datatype;

    private String remark1;

    private String remark2;

    public String getDictionaryoptionid() {
        return dictionaryoptionid;
    }

    public void setDictionaryoptionid(String dictionaryoptionid) {
        this.dictionaryoptionid = dictionaryoptionid == null ? null : dictionaryoptionid.trim();
    }

    public String getDictionaryoptionname() {
        return dictionaryoptionname;
    }

    public void setDictionaryoptionname(String dictionaryoptionname) {
        this.dictionaryoptionname = dictionaryoptionname == null ? null : dictionaryoptionname.trim();
    }

    public String getUpdictionaryoptionid() {
        return updictionaryoptionid;
    }

    public void setUpdictionaryoptionid(String updictionaryoptionid) {
        this.updictionaryoptionid = updictionaryoptionid == null ? null : updictionaryoptionid.trim();
    }

    public Boolean getIsuse() {
        return isuse;
    }

    public void setIsuse(Boolean isuse) {
        this.isuse = isuse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }
}