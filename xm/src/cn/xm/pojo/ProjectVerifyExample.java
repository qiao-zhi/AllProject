package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectVerifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectVerifyExample() {
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

        public Criteria andVerifyidIsNull() {
            addCriterion("verifyId is null");
            return (Criteria) this;
        }

        public Criteria andVerifyidIsNotNull() {
            addCriterion("verifyId is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyidEqualTo(Integer value) {
            addCriterion("verifyId =", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidNotEqualTo(Integer value) {
            addCriterion("verifyId <>", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidGreaterThan(Integer value) {
            addCriterion("verifyId >", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("verifyId >=", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidLessThan(Integer value) {
            addCriterion("verifyId <", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidLessThanOrEqualTo(Integer value) {
            addCriterion("verifyId <=", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidIn(List<Integer> values) {
            addCriterion("verifyId in", values, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidNotIn(List<Integer> values) {
            addCriterion("verifyId not in", values, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidBetween(Integer value1, Integer value2) {
            addCriterion("verifyId between", value1, value2, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidNotBetween(Integer value1, Integer value2) {
            addCriterion("verifyId not between", value1, value2, "verifyid");
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

        public Criteria andVerifyfilenumIsNull() {
            addCriterion("verifyFileNum is null");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumIsNotNull() {
            addCriterion("verifyFileNum is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumEqualTo(Integer value) {
            addCriterion("verifyFileNum =", value, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumNotEqualTo(Integer value) {
            addCriterion("verifyFileNum <>", value, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumGreaterThan(Integer value) {
            addCriterion("verifyFileNum >", value, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("verifyFileNum >=", value, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumLessThan(Integer value) {
            addCriterion("verifyFileNum <", value, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumLessThanOrEqualTo(Integer value) {
            addCriterion("verifyFileNum <=", value, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumIn(List<Integer> values) {
            addCriterion("verifyFileNum in", values, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumNotIn(List<Integer> values) {
            addCriterion("verifyFileNum not in", values, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumBetween(Integer value1, Integer value2) {
            addCriterion("verifyFileNum between", value1, value2, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifyfilenumNotBetween(Integer value1, Integer value2) {
            addCriterion("verifyFileNum not between", value1, value2, "verifyfilenum");
            return (Criteria) this;
        }

        public Criteria andVerifypersonIsNull() {
            addCriterion("verifyPerson is null");
            return (Criteria) this;
        }

        public Criteria andVerifypersonIsNotNull() {
            addCriterion("verifyPerson is not null");
            return (Criteria) this;
        }

        public Criteria andVerifypersonEqualTo(String value) {
            addCriterion("verifyPerson =", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonNotEqualTo(String value) {
            addCriterion("verifyPerson <>", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonGreaterThan(String value) {
            addCriterion("verifyPerson >", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonGreaterThanOrEqualTo(String value) {
            addCriterion("verifyPerson >=", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonLessThan(String value) {
            addCriterion("verifyPerson <", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonLessThanOrEqualTo(String value) {
            addCriterion("verifyPerson <=", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonLike(String value) {
            addCriterion("verifyPerson like", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonNotLike(String value) {
            addCriterion("verifyPerson not like", value, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonIn(List<String> values) {
            addCriterion("verifyPerson in", values, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonNotIn(List<String> values) {
            addCriterion("verifyPerson not in", values, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonBetween(String value1, String value2) {
            addCriterion("verifyPerson between", value1, value2, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifypersonNotBetween(String value1, String value2) {
            addCriterion("verifyPerson not between", value1, value2, "verifyperson");
            return (Criteria) this;
        }

        public Criteria andVerifydateIsNull() {
            addCriterion("verifyDate is null");
            return (Criteria) this;
        }

        public Criteria andVerifydateIsNotNull() {
            addCriterion("verifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andVerifydateEqualTo(Date value) {
            addCriterionForJDBCDate("verifyDate =", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("verifyDate <>", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateGreaterThan(Date value) {
            addCriterionForJDBCDate("verifyDate >", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("verifyDate >=", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateLessThan(Date value) {
            addCriterionForJDBCDate("verifyDate <", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("verifyDate <=", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateIn(List<Date> values) {
            addCriterionForJDBCDate("verifyDate in", values, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("verifyDate not in", values, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("verifyDate between", value1, value2, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("verifyDate not between", value1, value2, "verifydate");
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