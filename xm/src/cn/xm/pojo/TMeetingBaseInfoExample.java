package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMeetingBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMeetingBaseInfoExample() {
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

        public Criteria andHostidIsNull() {
            addCriterion("hostId is null");
            return (Criteria) this;
        }

        public Criteria andHostidIsNotNull() {
            addCriterion("hostId is not null");
            return (Criteria) this;
        }

        public Criteria andHostidEqualTo(String value) {
            addCriterion("hostId =", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotEqualTo(String value) {
            addCriterion("hostId <>", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidGreaterThan(String value) {
            addCriterion("hostId >", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidGreaterThanOrEqualTo(String value) {
            addCriterion("hostId >=", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLessThan(String value) {
            addCriterion("hostId <", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLessThanOrEqualTo(String value) {
            addCriterion("hostId <=", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLike(String value) {
            addCriterion("hostId like", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotLike(String value) {
            addCriterion("hostId not like", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidIn(List<String> values) {
            addCriterion("hostId in", values, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotIn(List<String> values) {
            addCriterion("hostId not in", values, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidBetween(String value1, String value2) {
            addCriterion("hostId between", value1, value2, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotBetween(String value1, String value2) {
            addCriterion("hostId not between", value1, value2, "hostid");
            return (Criteria) this;
        }

        public Criteria andMeetingnameIsNull() {
            addCriterion("meetingName is null");
            return (Criteria) this;
        }

        public Criteria andMeetingnameIsNotNull() {
            addCriterion("meetingName is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingnameEqualTo(String value) {
            addCriterion("meetingName =", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameNotEqualTo(String value) {
            addCriterion("meetingName <>", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameGreaterThan(String value) {
            addCriterion("meetingName >", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameGreaterThanOrEqualTo(String value) {
            addCriterion("meetingName >=", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameLessThan(String value) {
            addCriterion("meetingName <", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameLessThanOrEqualTo(String value) {
            addCriterion("meetingName <=", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameLike(String value) {
            addCriterion("meetingName like", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameNotLike(String value) {
            addCriterion("meetingName not like", value, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameIn(List<String> values) {
            addCriterion("meetingName in", values, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameNotIn(List<String> values) {
            addCriterion("meetingName not in", values, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameBetween(String value1, String value2) {
            addCriterion("meetingName between", value1, value2, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingnameNotBetween(String value1, String value2) {
            addCriterion("meetingName not between", value1, value2, "meetingname");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeIsNull() {
            addCriterion("meetingTime is null");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeIsNotNull() {
            addCriterion("meetingTime is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeEqualTo(Date value) {
            addCriterion("meetingTime =", value, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeNotEqualTo(Date value) {
            addCriterion("meetingTime <>", value, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeGreaterThan(Date value) {
            addCriterion("meetingTime >", value, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meetingTime >=", value, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeLessThan(Date value) {
            addCriterion("meetingTime <", value, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeLessThanOrEqualTo(Date value) {
            addCriterion("meetingTime <=", value, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeIn(List<Date> values) {
            addCriterion("meetingTime in", values, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeNotIn(List<Date> values) {
            addCriterion("meetingTime not in", values, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeBetween(Date value1, Date value2) {
            addCriterion("meetingTime between", value1, value2, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingtimeNotBetween(Date value1, Date value2) {
            addCriterion("meetingTime not between", value1, value2, "meetingtime");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceIsNull() {
            addCriterion("meetingPlace is null");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceIsNotNull() {
            addCriterion("meetingPlace is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceEqualTo(String value) {
            addCriterion("meetingPlace =", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceNotEqualTo(String value) {
            addCriterion("meetingPlace <>", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceGreaterThan(String value) {
            addCriterion("meetingPlace >", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceGreaterThanOrEqualTo(String value) {
            addCriterion("meetingPlace >=", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceLessThan(String value) {
            addCriterion("meetingPlace <", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceLessThanOrEqualTo(String value) {
            addCriterion("meetingPlace <=", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceLike(String value) {
            addCriterion("meetingPlace like", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceNotLike(String value) {
            addCriterion("meetingPlace not like", value, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceIn(List<String> values) {
            addCriterion("meetingPlace in", values, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceNotIn(List<String> values) {
            addCriterion("meetingPlace not in", values, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceBetween(String value1, String value2) {
            addCriterion("meetingPlace between", value1, value2, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingplaceNotBetween(String value1, String value2) {
            addCriterion("meetingPlace not between", value1, value2, "meetingplace");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeIsNull() {
            addCriterion("meetingNotice is null");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeIsNotNull() {
            addCriterion("meetingNotice is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeEqualTo(String value) {
            addCriterion("meetingNotice =", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeNotEqualTo(String value) {
            addCriterion("meetingNotice <>", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeGreaterThan(String value) {
            addCriterion("meetingNotice >", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeGreaterThanOrEqualTo(String value) {
            addCriterion("meetingNotice >=", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeLessThan(String value) {
            addCriterion("meetingNotice <", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeLessThanOrEqualTo(String value) {
            addCriterion("meetingNotice <=", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeLike(String value) {
            addCriterion("meetingNotice like", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeNotLike(String value) {
            addCriterion("meetingNotice not like", value, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeIn(List<String> values) {
            addCriterion("meetingNotice in", values, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeNotIn(List<String> values) {
            addCriterion("meetingNotice not in", values, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeBetween(String value1, String value2) {
            addCriterion("meetingNotice between", value1, value2, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingnoticeNotBetween(String value1, String value2) {
            addCriterion("meetingNotice not between", value1, value2, "meetingnotice");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusIsNull() {
            addCriterion("meetingStatus is null");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusIsNotNull() {
            addCriterion("meetingStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusEqualTo(String value) {
            addCriterion("meetingStatus =", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusNotEqualTo(String value) {
            addCriterion("meetingStatus <>", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusGreaterThan(String value) {
            addCriterion("meetingStatus >", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusGreaterThanOrEqualTo(String value) {
            addCriterion("meetingStatus >=", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusLessThan(String value) {
            addCriterion("meetingStatus <", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusLessThanOrEqualTo(String value) {
            addCriterion("meetingStatus <=", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusLike(String value) {
            addCriterion("meetingStatus like", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusNotLike(String value) {
            addCriterion("meetingStatus not like", value, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusIn(List<String> values) {
            addCriterion("meetingStatus in", values, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusNotIn(List<String> values) {
            addCriterion("meetingStatus not in", values, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusBetween(String value1, String value2) {
            addCriterion("meetingStatus between", value1, value2, "meetingstatus");
            return (Criteria) this;
        }

        public Criteria andMeetingstatusNotBetween(String value1, String value2) {
            addCriterion("meetingStatus not between", value1, value2, "meetingstatus");
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