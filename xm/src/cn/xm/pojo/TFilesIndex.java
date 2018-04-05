package cn.xm.pojo;

import java.util.Date;

public class TFilesIndex {
    private Integer fileid;

    private String filetype;

    private String originalname;

    private String currentname;

    private Date uploadtime;

    private String filesize;

    private Boolean remark;

    private String opinioncontent;

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname == null ? null : originalname.trim();
    }

    public String getCurrentname() {
        return currentname;
    }

    public void setCurrentname(String currentname) {
        this.currentname = currentname == null ? null : currentname.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize == null ? null : filesize.trim();
    }

    public Boolean getRemark() {
        return remark;
    }

    public void setRemark(Boolean remark) {
        this.remark = remark;
    }

    public String getOpinioncontent() {
        return opinioncontent;
    }

    public void setOpinioncontent(String opinioncontent) {
        this.opinioncontent = opinioncontent == null ? null : opinioncontent.trim();
    }
}