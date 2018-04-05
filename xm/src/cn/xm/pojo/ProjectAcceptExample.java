package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectAcceptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectAcceptExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAcceptidIsNull() {
            addCriterion("acceptId is null");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNotNull() {
            addCriterion("acceptId is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptidEqualTo(String value) {
            addCriterion("acceptId =", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotEqualTo(String value) {
            addCriterion("acceptId <>", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThan(String value) {
            addCriterion("acceptId >", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThanOrEqualTo(String value) {
            addCriterion("acceptId >=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThan(String value) {
            addCriterion("acceptId <", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThanOrEqualTo(String value) {
            addCriterion("acceptId <=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLike(String value) {
            addCriterion("acceptId like", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotLike(String value) {
            addCriterion("acceptId not like", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIn(List<String> values) {
            addCriterion("acceptId in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotIn(List<String> values) {
            addCriterion("acceptId not in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidBetween(String value1, String value2) {
            addCriterion("acceptId between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotBetween(String value1, String value2) {
            addCriterion("acceptId not between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectId is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectId is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(String value) {
            addCriterion("projectId =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(String value) {
            addCriterion("projectId <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(String value) {
            addCriterion("projectId >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(String value) {
            addCriterion("projectId >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(String value) {
            addCriterion("projectId <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(String value) {
            addCriterion("projectId <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLike(String value) {
            addCriterion("projectId like", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotLike(String value) {
            addCriterion("projectId not like", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<String> values) {
            addCriterion("projectId in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<String> values) {
            addCriterion("projectId not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(String value1, String value2) {
            addCriterion("projectId between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(String value1, String value2) {
            addCriterion("projectId not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andRecorddateIsNull() {
            addCriterion("recordDate is null");
            return (Criteria) this;
        }

        public Criteria andRecorddateIsNotNull() {
            addCriterion("recordDate is not null");
            return (Criteria) this;
        }

        public Criteria andRecorddateEqualTo(Date value) {
            addCriterionForJDBCDate("recordDate =", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("recordDate <>", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateGreaterThan(Date value) {
            addCriterionForJDBCDate("recordDate >", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recordDate >=", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateLessThan(Date value) {
            addCriterionForJDBCDate("recordDate <", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recordDate <=", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateIn(List<Date> values) {
            addCriterionForJDBCDate("recordDate in", values, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("recordDate not in", values, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recordDate between", value1, value2, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recordDate not between", value1, value2, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecordpersonIsNull() {
            addCriterion("recordPerson is null");
            return (Criteria) this;
        }

        public Criteria andRecordpersonIsNotNull() {
            addCriterion("recordPerson is not null");
            return (Criteria) this;
        }

        public Criteria andRecordpersonEqualTo(String value) {
            addCriterion("recordPerson =", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonNotEqualTo(String value) {
            addCriterion("recordPerson <>", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonGreaterThan(String value) {
            addCriterion("recordPerson >", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonGreaterThanOrEqualTo(String value) {
            addCriterion("recordPerson >=", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonLessThan(String value) {
            addCriterion("recordPerson <", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonLessThanOrEqualTo(String value) {
            addCriterion("recordPerson <=", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonLike(String value) {
            addCriterion("recordPerson like", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonNotLike(String value) {
            addCriterion("recordPerson not like", value, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonIn(List<String> values) {
            addCriterion("recordPerson in", values, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonNotIn(List<String> values) {
            addCriterion("recordPerson not in", values, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonBetween(String value1, String value2) {
            addCriterion("recordPerson between", value1, value2, "recordperson");
            return (Criteria) this;
        }

        public Criteria andRecordpersonNotBetween(String value1, String value2) {
            addCriterion("recordPerson not between", value1, value2, "recordperson");
            return (Criteria) this;
        }

        public Criteria andChargeunitIsNull() {
            addCriterion("chargeUnit is null");
            return (Criteria) this;
        }

        public Criteria andChargeunitIsNotNull() {
            addCriterion("chargeUnit is not null");
            return (Criteria) this;
        }

        public Criteria andChargeunitEqualTo(String value) {
            addCriterion("chargeUnit =", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotEqualTo(String value) {
            addCriterion("chargeUnit <>", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitGreaterThan(String value) {
            addCriterion("chargeUnit >", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitGreaterThanOrEqualTo(String value) {
            addCriterion("chargeUnit >=", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitLessThan(String value) {
            addCriterion("chargeUnit <", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitLessThanOrEqualTo(String value) {
            addCriterion("chargeUnit <=", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitLike(String value) {
            addCriterion("chargeUnit like", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotLike(String value) {
            addCriterion("chargeUnit not like", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitIn(List<String> values) {
            addCriterion("chargeUnit in", values, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotIn(List<String> values) {
            addCriterion("chargeUnit not in", values, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitBetween(String value1, String value2) {
            addCriterion("chargeUnit between", value1, value2, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotBetween(String value1, String value2) {
            addCriterion("chargeUnit not between", value1, value2, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargepersonIsNull() {
            addCriterion("chargePerson is null");
            return (Criteria) this;
        }

        public Criteria andChargepersonIsNotNull() {
            addCriterion("chargePerson is not null");
            return (Criteria) this;
        }

        public Criteria andChargepersonEqualTo(String value) {
            addCriterion("chargePerson =", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotEqualTo(String value) {
            addCriterion("chargePerson <>", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonGreaterThan(String value) {
            addCriterion("chargePerson >", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonGreaterThanOrEqualTo(String value) {
            addCriterion("chargePerson >=", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonLessThan(String value) {
            addCriterion("chargePerson <", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonLessThanOrEqualTo(String value) {
            addCriterion("chargePerson <=", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonLike(String value) {
            addCriterion("chargePerson like", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotLike(String value) {
            addCriterion("chargePerson not like", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonIn(List<String> values) {
            addCriterion("chargePerson in", values, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotIn(List<String> values) {
            addCriterion("chargePerson not in", values, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonBetween(String value1, String value2) {
            addCriterion("chargePerson between", value1, value2, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotBetween(String value1, String value2) {
            addCriterion("chargePerson not between", value1, value2, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andDistributiondateIsNull() {
            addCriterion("distributionDate is null");
            return (Criteria) this;
        }

        public Criteria andDistributiondateIsNotNull() {
            addCriterion("distributionDate is not null");
            return (Criteria) this;
        }

        public Criteria andDistributiondateEqualTo(Date value) {
            addCriterionForJDBCDate("distributionDate =", value, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateNotEqualTo(Date value) {
            addCriterionForJDBCDate("distributionDate <>", value, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateGreaterThan(Date value) {
            addCriterionForJDBCDate("distributionDate >", value, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("distributionDate >=", value, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateLessThan(Date value) {
            addCriterionForJDBCDate("distributionDate <", value, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("distributionDate <=", value, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateIn(List<Date> values) {
            addCriterionForJDBCDate("distributionDate in", values, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateNotIn(List<Date> values) {
            addCriterionForJDBCDate("distributionDate not in", values, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("distributionDate between", value1, value2, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andDistributiondateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("distributionDate not between", value1, value2, "distributiondate");
            return (Criteria) this;
        }

        public Criteria andReceivedateIsNull() {
            addCriterion("receiveDate is null");
            return (Criteria) this;
        }

        public Criteria andReceivedateIsNotNull() {
            addCriterion("receiveDate is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedateEqualTo(Date value) {
            addCriterionForJDBCDate("receiveDate =", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("receiveDate <>", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateGreaterThan(Date value) {
            addCriterionForJDBCDate("receiveDate >", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("receiveDate >=", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateLessThan(Date value) {
            addCriterionForJDBCDate("receiveDate <", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("receiveDate <=", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateIn(List<Date> values) {
            addCriterionForJDBCDate("receiveDate in", values, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("receiveDate not in", values, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("receiveDate between", value1, value2, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("receiveDate not between", value1, value2, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivepersonIsNull() {
            addCriterion("receivePerson is null");
            return (Criteria) this;
        }

        public Criteria andReceivepersonIsNotNull() {
            addCriterion("receivePerson is not null");
            return (Criteria) this;
        }

        public Criteria andReceivepersonEqualTo(String value) {
            addCriterion("receivePerson =", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonNotEqualTo(String value) {
            addCriterion("receivePerson <>", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonGreaterThan(String value) {
            addCriterion("receivePerson >", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonGreaterThanOrEqualTo(String value) {
            addCriterion("receivePerson >=", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonLessThan(String value) {
            addCriterion("receivePerson <", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonLessThanOrEqualTo(String value) {
            addCriterion("receivePerson <=", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonLike(String value) {
            addCriterion("receivePerson like", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonNotLike(String value) {
            addCriterion("receivePerson not like", value, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonIn(List<String> values) {
            addCriterion("receivePerson in", values, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonNotIn(List<String> values) {
            addCriterion("receivePerson not in", values, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonBetween(String value1, String value2) {
            addCriterion("receivePerson between", value1, value2, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andReceivepersonNotBetween(String value1, String value2) {
            addCriterion("receivePerson not between", value1, value2, "receiveperson");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}