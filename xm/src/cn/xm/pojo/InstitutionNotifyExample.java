package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InstitutionNotifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstitutionNotifyExample() {
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

        public Criteria andNotifyidIsNull() {
            addCriterion("notifyId is null");
            return (Criteria) this;
        }

        public Criteria andNotifyidIsNotNull() {
            addCriterion("notifyId is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyidEqualTo(String value) {
            addCriterion("notifyId =", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotEqualTo(String value) {
            addCriterion("notifyId <>", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidGreaterThan(String value) {
            addCriterion("notifyId >", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidGreaterThanOrEqualTo(String value) {
            addCriterion("notifyId >=", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidLessThan(String value) {
            addCriterion("notifyId <", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidLessThanOrEqualTo(String value) {
            addCriterion("notifyId <=", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidLike(String value) {
            addCriterion("notifyId like", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotLike(String value) {
            addCriterion("notifyId not like", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidIn(List<String> values) {
            addCriterion("notifyId in", values, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotIn(List<String> values) {
            addCriterion("notifyId not in", values, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidBetween(String value1, String value2) {
            addCriterion("notifyId between", value1, value2, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotBetween(String value1, String value2) {
            addCriterion("notifyId not between", value1, value2, "notifyid");
            return (Criteria) this;
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

        public Criteria andInstitutionnameIsNull() {
            addCriterion("institutionName is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameIsNotNull() {
            addCriterion("institutionName is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameEqualTo(String value) {
            addCriterion("institutionName =", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotEqualTo(String value) {
            addCriterion("institutionName <>", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameGreaterThan(String value) {
            addCriterion("institutionName >", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameGreaterThanOrEqualTo(String value) {
            addCriterion("institutionName >=", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameLessThan(String value) {
            addCriterion("institutionName <", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameLessThanOrEqualTo(String value) {
            addCriterion("institutionName <=", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameLike(String value) {
            addCriterion("institutionName like", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotLike(String value) {
            addCriterion("institutionName not like", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameIn(List<String> values) {
            addCriterion("institutionName in", values, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotIn(List<String> values) {
            addCriterion("institutionName not in", values, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameBetween(String value1, String value2) {
            addCriterion("institutionName between", value1, value2, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotBetween(String value1, String value2) {
            addCriterion("institutionName not between", value1, value2, "institutionname");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNull() {
            addCriterion("notifier is null");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNotNull() {
            addCriterion("notifier is not null");
            return (Criteria) this;
        }

        public Criteria andNotifierEqualTo(String value) {
            addCriterion("notifier =", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotEqualTo(String value) {
            addCriterion("notifier <>", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThan(String value) {
            addCriterion("notifier >", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThanOrEqualTo(String value) {
            addCriterion("notifier >=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThan(String value) {
            addCriterion("notifier <", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThanOrEqualTo(String value) {
            addCriterion("notifier <=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLike(String value) {
            addCriterion("notifier like", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotLike(String value) {
            addCriterion("notifier not like", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierIn(List<String> values) {
            addCriterion("notifier in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotIn(List<String> values) {
            addCriterion("notifier not in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierBetween(String value1, String value2) {
            addCriterion("notifier between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotBetween(String value1, String value2) {
            addCriterion("notifier not between", value1, value2, "notifier");
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

        public Criteria andContactpersonIsNull() {
            addCriterion("contactPerson is null");
            return (Criteria) this;
        }

        public Criteria andContactpersonIsNotNull() {
            addCriterion("contactPerson is not null");
            return (Criteria) this;
        }

        public Criteria andContactpersonEqualTo(String value) {
            addCriterion("contactPerson =", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotEqualTo(String value) {
            addCriterion("contactPerson <>", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonGreaterThan(String value) {
            addCriterion("contactPerson >", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonGreaterThanOrEqualTo(String value) {
            addCriterion("contactPerson >=", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLessThan(String value) {
            addCriterion("contactPerson <", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLessThanOrEqualTo(String value) {
            addCriterion("contactPerson <=", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLike(String value) {
            addCriterion("contactPerson like", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotLike(String value) {
            addCriterion("contactPerson not like", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonIn(List<String> values) {
            addCriterion("contactPerson in", values, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotIn(List<String> values) {
            addCriterion("contactPerson not in", values, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonBetween(String value1, String value2) {
            addCriterion("contactPerson between", value1, value2, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotBetween(String value1, String value2) {
            addCriterion("contactPerson not between", value1, value2, "contactperson");
            return (Criteria) this;
        }

        public Criteria andNotifyresultIsNull() {
            addCriterion("notifyResult is null");
            return (Criteria) this;
        }

        public Criteria andNotifyresultIsNotNull() {
            addCriterion("notifyResult is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyresultEqualTo(String value) {
            addCriterion("notifyResult =", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultNotEqualTo(String value) {
            addCriterion("notifyResult <>", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultGreaterThan(String value) {
            addCriterion("notifyResult >", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultGreaterThanOrEqualTo(String value) {
            addCriterion("notifyResult >=", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultLessThan(String value) {
            addCriterion("notifyResult <", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultLessThanOrEqualTo(String value) {
            addCriterion("notifyResult <=", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultLike(String value) {
            addCriterion("notifyResult like", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultNotLike(String value) {
            addCriterion("notifyResult not like", value, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultIn(List<String> values) {
            addCriterion("notifyResult in", values, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultNotIn(List<String> values) {
            addCriterion("notifyResult not in", values, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultBetween(String value1, String value2) {
            addCriterion("notifyResult between", value1, value2, "notifyresult");
            return (Criteria) this;
        }

        public Criteria andNotifyresultNotBetween(String value1, String value2) {
            addCriterion("notifyResult not between", value1, value2, "notifyresult");
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