package cn.xm.pojo;

import java.util.Date;

public class InspectAudit {
    private String auditid;

    private String inspectid;

    private String financeunit;

    private String auditingperson;

    private Date auditdate;

    private String enterprisereceiver2;

    public String getAuditid() {
        return auditid;
    }

    public void setAuditid(String auditid) {
        this.auditid = auditid == null ? null : auditid.trim();
    }

    public String getInspectid() {
        return inspectid;
    }

    public void setInspectid(String inspectid) {
        this.inspectid = inspectid == null ? null : inspectid.trim();
    }

    public String getFinanceunit() {
        return financeunit;
    }

    public void setFinanceunit(String financeunit) {
        this.financeunit = financeunit == null ? null : financeunit.trim();
    }

    public String getAuditingperson() {
        return auditingperson;
    }

    public void setAuditingperson(String auditingperson) {
        this.auditingperson = auditingperson == null ? null : auditingperson.trim();
    }

    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    public String getEnterprisereceiver2() {
        return enterprisereceiver2;
    }

    public void setEnterprisereceiver2(String enterprisereceiver2) {
        this.enterprisereceiver2 = enterprisereceiver2 == null ? null : enterprisereceiver2.trim();
    }
}