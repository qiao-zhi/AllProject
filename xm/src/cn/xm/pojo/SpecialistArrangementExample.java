package cn.xm.pojo;

import java.util.ArrayList;
import java.util.List;

public class SpecialistArrangementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecialistArrangementExample() {
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

        public Criteria andSpecialistidIsNull() {
            addCriterion("specialistId is null");
            return (Criteria) this;
        }

        public Criteria andSpecialistidIsNotNull() {
            addCriterion("specialistId is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialistidEqualTo(String value) {
            addCriterion("specialistId =", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidNotEqualTo(String value) {
            addCriterion("specialistId <>", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidGreaterThan(String value) {
            addCriterion("specialistId >", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidGreaterThanOrEqualTo(String value) {
            addCriterion("specialistId >=", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidLessThan(String value) {
            addCriterion("specialistId <", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidLessThanOrEqualTo(String value) {
            addCriterion("specialistId <=", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidLike(String value) {
            addCriterion("specialistId like", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidNotLike(String value) {
            addCriterion("specialistId not like", value, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidIn(List<String> values) {
            addCriterion("specialistId in", values, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidNotIn(List<String> values) {
            addCriterion("specialistId not in", values, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidBetween(String value1, String value2) {
            addCriterion("specialistId between", value1, value2, "specialistid");
            return (Criteria) this;
        }

        public Criteria andSpecialistidNotBetween(String value1, String value2) {
            addCriterion("specialistId not between", value1, value2, "specialistid");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andIsagreeIsNull() {
            addCriterion("isAgree is null");
            return (Criteria) this;
        }

        public Criteria andIsagreeIsNotNull() {
            addCriterion("isAgree is not null");
            return (Criteria) this;
        }

        public Criteria andIsagreeEqualTo(Boolean value) {
            addCriterion("isAgree =", value, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeNotEqualTo(Boolean value) {
            addCriterion("isAgree <>", value, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeGreaterThan(Boolean value) {
            addCriterion("isAgree >", value, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isAgree >=", value, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeLessThan(Boolean value) {
            addCriterion("isAgree <", value, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeLessThanOrEqualTo(Boolean value) {
            addCriterion("isAgree <=", value, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeIn(List<Boolean> values) {
            addCriterion("isAgree in", values, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeNotIn(List<Boolean> values) {
            addCriterion("isAgree not in", values, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeBetween(Boolean value1, Boolean value2) {
            addCriterion("isAgree between", value1, value2, "isagree");
            return (Criteria) this;
        }

        public Criteria andIsagreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isAgree not between", value1, value2, "isagree");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andIspromiseIsNull() {
            addCriterion("isPromise is null");
            return (Criteria) this;
        }

        public Criteria andIspromiseIsNotNull() {
            addCriterion("isPromise is not null");
            return (Criteria) this;
        }

        public Criteria andIspromiseEqualTo(Boolean value) {
            addCriterion("isPromise =", value, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseNotEqualTo(Boolean value) {
            addCriterion("isPromise <>", value, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseGreaterThan(Boolean value) {
            addCriterion("isPromise >", value, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isPromise >=", value, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseLessThan(Boolean value) {
            addCriterion("isPromise <", value, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseLessThanOrEqualTo(Boolean value) {
            addCriterion("isPromise <=", value, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseIn(List<Boolean> values) {
            addCriterion("isPromise in", values, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseNotIn(List<Boolean> values) {
            addCriterion("isPromise not in", values, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseBetween(Boolean value1, Boolean value2) {
            addCriterion("isPromise between", value1, value2, "ispromise");
            return (Criteria) this;
        }

        public Criteria andIspromiseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isPromise not between", value1, value2, "ispromise");
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