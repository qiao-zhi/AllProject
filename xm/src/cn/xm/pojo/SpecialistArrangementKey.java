package cn.xm.pojo;

public class SpecialistArrangementKey {
    private String meetingid;

    private String specialistid;

    public String getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(String meetingid) {
        this.meetingid = meetingid == null ? null : meetingid.trim();
    }

    public String getSpecialistid() {
        return specialistid;
    }

    public void setSpecialistid(String specialistid) {
        this.specialistid = specialistid == null ? null : specialistid.trim();
    }
}