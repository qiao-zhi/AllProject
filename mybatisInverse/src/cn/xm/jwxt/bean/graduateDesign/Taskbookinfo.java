package cn.xm.jwxt.bean.graduateDesign;

import java.util.Date;

public class Taskbookinfo {
    private Integer bookid;

    private String studenttitleresultid;

    private String taskcontent;

    private Date taskedittime;

    private Date tasksendtime;

    private Date taskcompletetime;

    private String thesistitle;

    private String designtargetrequire;

    private String designcontent;

    private String designsubmitfile;

    private String remark;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getStudenttitleresultid() {
        return studenttitleresultid;
    }

    public void setStudenttitleresultid(String studenttitleresultid) {
        this.studenttitleresultid = studenttitleresultid == null ? null : studenttitleresultid.trim();
    }

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent == null ? null : taskcontent.trim();
    }

    public Date getTaskedittime() {
        return taskedittime;
    }

    public void setTaskedittime(Date taskedittime) {
        this.taskedittime = taskedittime;
    }

    public Date getTasksendtime() {
        return tasksendtime;
    }

    public void setTasksendtime(Date tasksendtime) {
        this.tasksendtime = tasksendtime;
    }

    public Date getTaskcompletetime() {
        return taskcompletetime;
    }

    public void setTaskcompletetime(Date taskcompletetime) {
        this.taskcompletetime = taskcompletetime;
    }

    public String getThesistitle() {
        return thesistitle;
    }

    public void setThesistitle(String thesistitle) {
        this.thesistitle = thesistitle == null ? null : thesistitle.trim();
    }

    public String getDesigntargetrequire() {
        return designtargetrequire;
    }

    public void setDesigntargetrequire(String designtargetrequire) {
        this.designtargetrequire = designtargetrequire == null ? null : designtargetrequire.trim();
    }

    public String getDesigncontent() {
        return designcontent;
    }

    public void setDesigncontent(String designcontent) {
        this.designcontent = designcontent == null ? null : designcontent.trim();
    }

    public String getDesignsubmitfile() {
        return designsubmitfile;
    }

    public void setDesignsubmitfile(String designsubmitfile) {
        this.designsubmitfile = designsubmitfile == null ? null : designsubmitfile.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}