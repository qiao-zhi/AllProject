package cn.xm.pojo;

import java.util.Date;

public class ProjectAccept {
    private String acceptid;

    private String projectid;

    private Date recorddate;

    private String recordperson;

    private String chargeunit;

    private String chargeperson;

    private Date distributiondate;

    private Date receivedate;

    private String receiveperson;

    private String remark1;

    private String remark2;

    private String remark3;

    private String receiveresult;

    public String getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(String acceptid) {
        this.acceptid = acceptid == null ? null : acceptid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getRecordperson() {
        return recordperson;
    }

    public void setRecordperson(String recordperson) {
        this.recordperson = recordperson == null ? null : recordperson.trim();
    }

    public String getChargeunit() {
        return chargeunit;
    }

    public void setChargeunit(String chargeunit) {
        this.chargeunit = chargeunit == null ? null : chargeunit.trim();
    }

    public String getChargeperson() {
        return chargeperson;
    }

    public void setChargeperson(String chargeperson) {
        this.chargeperson = chargeperson == null ? null : chargeperson.trim();
    }

    public Date getDistributiondate() {
        return distributiondate;
    }

    public void setDistributiondate(Date distributiondate) {
        this.distributiondate = distributiondate;
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public String getReceiveperson() {
        return receiveperson;
    }

    public void setReceiveperson(String receiveperson) {
        this.receiveperson = receiveperson == null ? null : receiveperson.trim();
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

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getReceiveresult() {
        return receiveresult;
    }

    public void setReceiveresult(String receiveresult) {
        this.receiveresult = receiveresult == null ? null : receiveresult.trim();
    }
}