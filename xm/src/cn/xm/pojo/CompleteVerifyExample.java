package cn.xm.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompleteVerifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompleteVerifyExample() {
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

        public Criteria andCompleteidIsNull() {
            addCriterion("completeId is null");
            return (Criteria) this;
        }

        public Criteria andCompleteidIsNotNull() {
            addCriterion("completeId is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteidEqualTo(String value) {
            addCriterion("completeId =", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotEqualTo(String value) {
            addCriterion("completeId <>", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidGreaterThan(String value) {
            addCriterion("completeId >", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidGreaterThanOrEqualTo(String value) {
            addCriterion("completeId >=", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidLessThan(String value) {
            addCriterion("completeId <", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidLessThanOrEqualTo(String value) {
            addCriterion("completeId <=", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidLike(String value) {
            addCriterion("completeId like", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotLike(String value) {
            addCriterion("completeId not like", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidIn(List<String> values) {
            addCriterion("completeId in", values, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotIn(List<String> values) {
            addCriterion("completeId not in", values, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidBetween(String value1, String value2) {
            addCriterion("completeId between", value1, value2, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotBetween(String value1, String value2) {
            addCriterion("completeId not between", value1, value2, "completeid");
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