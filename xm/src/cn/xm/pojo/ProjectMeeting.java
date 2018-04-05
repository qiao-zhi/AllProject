package cn.xm.pojo;

import java.util.Date;

public class ProjectMeeting extends ProjectMeetingKey {
    private Date notifydate;

    private String notifymethod;

    public Date getNotifydate() {
        return notifydate;
    }

    public void setNotifydate(Date notifydate) {
        this.notifydate = notifydate;
    }

    public String getNotifymethod() {
        return notifymethod;
    }

    public void setNotifymethod(String notifymethod) {
        this.notifymethod = notifymethod == null ? null : notifymethod.trim();
    }
}