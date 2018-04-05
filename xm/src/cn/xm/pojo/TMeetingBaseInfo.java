package cn.xm.pojo;

import java.util.Date;

public class TMeetingBaseInfo {
    private String meetingid;

    private String hostid;

    private String meetingname;

    private Date meetingtime;

    private String meetingplace;

    private String meetingnotice;

    private String meetingstatus;

    private String remark;

    public String getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(String meetingid) {
        this.meetingid = meetingid == null ? null : meetingid.trim();
    }

    public String getHostid() {
        return hostid;
    }

    public void setHostid(String hostid) {
        this.hostid = hostid == null ? null : hostid.trim();
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname == null ? null : meetingname.trim();
    }

    public Date getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(Date meetingtime) {
        this.meetingtime = meetingtime;
    }

    public String getMeetingplace() {
        return meetingplace;
    }

    public void setMeetingplace(String meetingplace) {
        this.meetingplace = meetingplace == null ? null : meetingplace.trim();
    }

    public String getMeetingnotice() {
        return meetingnotice;
    }

    public void setMeetingnotice(String meetingnotice) {
        this.meetingnotice = meetingnotice == null ? null : meetingnotice.trim();
    }

    public String getMeetingstatus() {
        return meetingstatus;
    }

    public void setMeetingstatus(String meetingstatus) {
        this.meetingstatus = meetingstatus == null ? null : meetingstatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}