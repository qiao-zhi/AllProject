package cn.xm.pojo;

import java.util.Date;

public class InstitutionNotify {
    private String notifyid;

    private String meetingid;

    private String institutionname;

    private String notifier;

    private Date notifydate;

    private String notifymethod;

    private String contactperson;

    private String notifyresult;

    public String getNotifyid() {
        return notifyid;
    }

    public void setNotifyid(String notifyid) {
        this.notifyid = notifyid == null ? null : notifyid.trim();
    }

    public String getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(String meetingid) {
        this.meetingid = meetingid == null ? null : meetingid.trim();
    }

    public String getInstitutionname() {
        return institutionname;
    }

    public void setInstitutionname(String institutionname) {
        this.institutionname = institutionname == null ? null : institutionname.trim();
    }

    public String getNotifier() {
        return notifier;
    }

    public void setNotifier(String notifier) {
        this.notifier = notifier == null ? null : notifier.trim();
    }

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

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson == null ? null : contactperson.trim();
    }

    public String getNotifyresult() {
        return notifyresult;
    }

    public void setNotifyresult(String notifyresult) {
        this.notifyresult = notifyresult == null ? null : notifyresult.trim();
    }
}