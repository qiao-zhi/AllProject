package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectMeetingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectMeetingExample() {
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

        public Criteria andMeetingidIsNull() {
            addCriterion("meetingId is null");
            return (Criteria) this;
        }

        public Criteria andMeetingidIsNotNull() {
            addCriterion("meetingId is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingidEqualTo(String value) {
            addCriterion("meetingId =", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotEqualTo(String value) {
            addCriterion("meetingId <>", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidGreaterThan(String value) {
            addCriterion("meetingId >", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidGreaterThanOrEqualTo(String value) {
            addCriterion("meetingId >=", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidLessThan(String value) {
            addCriterion("meetingId <", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidLessThanOrEqualTo(String value) {
            addCriterion("meetingId <=", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidLike(String value) {
            addCriterion("meetingId like", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotLike(String value) {
            addCriterion("meetingId not like", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidIn(List<String> values) {
            addCriterion("meetingId in", values, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotIn(List<String> values) {
            addCriterion("meetingId not in", values, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidBetween(String value1, String value2) {
            addCriterion("meetingId between", value1, value2, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotBetween(String value1, String value2) {
            addCriterion("meetingId not between", value1, value2, "meetingid");
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

        public Criteria andNotifydateIsNull() {
            addCriterion("notifyDate is null");
            return (Criteria) this;
        }

        public Criteria andNotifydateIsNotNull() {
            addCriterion("notifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andNotifydateEqualTo(Date value) {
            addCriterionForJDBCDate("notifyDate =", value, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("notifyDate <>", value, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateGreaterThan(Date value) {
            addCriterionForJDBCDate("notifyDate >", value, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notifyDate >=", value, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateLessThan(Date value) {
            addCriterionForJDBCDate("notifyDate <", value, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notifyDate <=", value, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateIn(List<Date> values) {
            addCriterionForJDBCDate("notifyDate in", values, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("notifyDate not in", values, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notifyDate between", value1, value2, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notifyDate not between", value1, value2, "notifydate");
            return (Criteria) this;
        }

        public Criteria andNotifymethodIsNull() {
            addCriterion("notifyMethod is null");
            return (Criteria) this;
        }

        public Criteria andNotifymethodIsNotNull() {
            addCriterion("notifyMethod is not null");
            return (Criteria) this;
        }

        public Criteria andNotifymethodEqualTo(String value) {
            addCriterion("notifyMethod =", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodNotEqualTo(String value) {
            addCriterion("notifyMethod <>", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodGreaterThan(String value) {
            addCriterion("notifyMethod >", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodGreaterThanOrEqualTo(String value) {
            addCriterion("notifyMethod >=", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodLessThan(String value) {
            addCriterion("notifyMethod <", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodLessThanOrEqualTo(String value) {
            addCriterion("notifyMethod <=", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodLike(String value) {
            addCriterion("notifyMethod like", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodNotLike(String value) {
            addCriterion("notifyMethod not like", value, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodIn(List<String> values) {
            addCriterion("notifyMethod in", values, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodNotIn(List<String> values) {
            addCriterion("notifyMethod not in", values, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodBetween(String value1, String value2) {
            addCriterion("notifyMethod between", value1, value2, "notifymethod");
            return (Criteria) this;
        }

        public Criteria andNotifymethodNotBetween(String value1, String value2) {
            addCriterion("notifyMethod not between", value1, value2, "notifymethod");
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