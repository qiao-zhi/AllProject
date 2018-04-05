package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IssueCertificateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IssueCertificateExample() {
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

        public Criteria andIssueidIsNull() {
            addCriterion("issueId is null");
            return (Criteria) this;
        }

        public Criteria andIssueidIsNotNull() {
            addCriterion("issueId is not null");
            return (Criteria) this;
        }

        public Criteria andIssueidEqualTo(String value) {
            addCriterion("issueId =", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidNotEqualTo(String value) {
            addCriterion("issueId <>", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidGreaterThan(String value) {
            addCriterion("issueId >", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidGreaterThanOrEqualTo(String value) {
            addCriterion("issueId >=", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidLessThan(String value) {
            addCriterion("issueId <", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidLessThanOrEqualTo(String value) {
            addCriterion("issueId <=", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidLike(String value) {
            addCriterion("issueId like", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidNotLike(String value) {
            addCriterion("issueId not like", value, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidIn(List<String> values) {
            addCriterion("issueId in", values, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidNotIn(List<String> values) {
            addCriterion("issueId not in", values, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidBetween(String value1, String value2) {
            addCriterion("issueId between", value1, value2, "issueid");
            return (Criteria) this;
        }

        public Criteria andIssueidNotBetween(String value1, String value2) {
            addCriterion("issueId not between", value1, value2, "issueid");
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

        public Criteria andIssuepersonIsNull() {
            addCriterion("issuePerson is null");
            return (Criteria) this;
        }

        public Criteria andIssuepersonIsNotNull() {
            addCriterion("issuePerson is not null");
            return (Criteria) this;
        }

        public Criteria andIssuepersonEqualTo(String value) {
            addCriterion("issuePerson =", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotEqualTo(String value) {
            addCriterion("issuePerson <>", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonGreaterThan(String value) {
            addCriterion("issuePerson >", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonGreaterThanOrEqualTo(String value) {
            addCriterion("issuePerson >=", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonLessThan(String value) {
            addCriterion("issuePerson <", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonLessThanOrEqualTo(String value) {
            addCriterion("issuePerson <=", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonLike(String value) {
            addCriterion("issuePerson like", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotLike(String value) {
            addCriterion("issuePerson not like", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonIn(List<String> values) {
            addCriterion("issuePerson in", values, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotIn(List<String> values) {
            addCriterion("issuePerson not in", values, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonBetween(String value1, String value2) {
            addCriterion("issuePerson between", value1, value2, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotBetween(String value1, String value2) {
            addCriterion("issuePerson not between", value1, value2, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNull() {
            addCriterion("issueDate is null");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNotNull() {
            addCriterion("issueDate is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedateEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate =", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate <>", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThan(Date value) {
            addCriterionForJDBCDate("issueDate >", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate >=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThan(Date value) {
            addCriterionForJDBCDate("issueDate <", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate <=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIn(List<Date> values) {
            addCriterionForJDBCDate("issueDate in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("issueDate not in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issueDate between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issueDate not between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andHolderIsNull() {
            addCriterion("holder is null");
            return (Criteria) this;
        }

        public Criteria andHolderIsNotNull() {
            addCriterion("holder is not null");
            return (Criteria) this;
        }

        public Criteria andHolderEqualTo(String value) {
            addCriterion("holder =", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotEqualTo(String value) {
            addCriterion("holder <>", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderGreaterThan(String value) {
            addCriterion("holder >", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderGreaterThanOrEqualTo(String value) {
            addCriterion("holder >=", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderLessThan(String value) {
            addCriterion("holder <", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderLessThanOrEqualTo(String value) {
            addCriterion("holder <=", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderLike(String value) {
            addCriterion("holder like", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotLike(String value) {
            addCriterion("holder not like", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderIn(List<String> values) {
            addCriterion("holder in", values, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotIn(List<String> values) {
            addCriterion("holder not in", values, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderBetween(String value1, String value2) {
            addCriterion("holder between", value1, value2, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotBetween(String value1, String value2) {
            addCriterion("holder not between", value1, value2, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderphoneIsNull() {
            addCriterion("holderPhone is null");
            return (Criteria) this;
        }

        public Criteria andHolderphoneIsNotNull() {
            addCriterion("holderPhone is not null");
            return (Criteria) this;
        }

        public Criteria andHolderphoneEqualTo(String value) {
            addCriterion("holderPhone =", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneNotEqualTo(String value) {
            addCriterion("holderPhone <>", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneGreaterThan(String value) {
            addCriterion("holderPhone >", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneGreaterThanOrEqualTo(String value) {
            addCriterion("holderPhone >=", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneLessThan(String value) {
            addCriterion("holderPhone <", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneLessThanOrEqualTo(String value) {
            addCriterion("holderPhone <=", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneLike(String value) {
            addCriterion("holderPhone like", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneNotLike(String value) {
            addCriterion("holderPhone not like", value, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneIn(List<String> values) {
            addCriterion("holderPhone in", values, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneNotIn(List<String> values) {
            addCriterion("holderPhone not in", values, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneBetween(String value1, String value2) {
            addCriterion("holderPhone between", value1, value2, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolderphoneNotBetween(String value1, String value2) {
            addCriterion("holderPhone not between", value1, value2, "holderphone");
            return (Criteria) this;
        }

        public Criteria andHolddateIsNull() {
            addCriterion("holdDate is null");
            return (Criteria) this;
        }

        public Criteria andHolddateIsNotNull() {
            addCriterion("holdDate is not null");
            return (Criteria) this;
        }

        public Criteria andHolddateEqualTo(Date value) {
            addCriterionForJDBCDate("holdDate =", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("holdDate <>", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateGreaterThan(Date value) {
            addCriterionForJDBCDate("holdDate >", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("holdDate >=", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateLessThan(Date value) {
            addCriterionForJDBCDate("holdDate <", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("holdDate <=", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateIn(List<Date> values) {
            addCriterionForJDBCDate("holdDate in", values, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("holdDate not in", values, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("holdDate between", value1, value2, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("holdDate not between", value1, value2, "holddate");
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