package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InspectAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspectAuditExample() {
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

        public Criteria andAuditidIsNull() {
            addCriterion("auditId is null");
            return (Criteria) this;
        }

        public Criteria andAuditidIsNotNull() {
            addCriterion("auditId is not null");
            return (Criteria) this;
        }

        public Criteria andAuditidEqualTo(String value) {
            addCriterion("auditId =", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotEqualTo(String value) {
            addCriterion("auditId <>", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidGreaterThan(String value) {
            addCriterion("auditId >", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidGreaterThanOrEqualTo(String value) {
            addCriterion("auditId >=", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLessThan(String value) {
            addCriterion("auditId <", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLessThanOrEqualTo(String value) {
            addCriterion("auditId <=", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLike(String value) {
            addCriterion("auditId like", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotLike(String value) {
            addCriterion("auditId not like", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidIn(List<String> values) {
            addCriterion("auditId in", values, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotIn(List<String> values) {
            addCriterion("auditId not in", values, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidBetween(String value1, String value2) {
            addCriterion("auditId between", value1, value2, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotBetween(String value1, String value2) {
            addCriterion("auditId not between", value1, value2, "auditid");
            return (Criteria) this;
        }

        public Criteria andInspectidIsNull() {
            addCriterion("inspectId is null");
            return (Criteria) this;
        }

        public Criteria andInspectidIsNotNull() {
            addCriterion("inspectId is not null");
            return (Criteria) this;
        }

        public Criteria andInspectidEqualTo(String value) {
            addCriterion("inspectId =", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidNotEqualTo(String value) {
            addCriterion("inspectId <>", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidGreaterThan(String value) {
            addCriterion("inspectId >", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidGreaterThanOrEqualTo(String value) {
            addCriterion("inspectId >=", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidLessThan(String value) {
            addCriterion("inspectId <", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidLessThanOrEqualTo(String value) {
            addCriterion("inspectId <=", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidLike(String value) {
            addCriterion("inspectId like", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidNotLike(String value) {
            addCriterion("inspectId not like", value, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidIn(List<String> values) {
            addCriterion("inspectId in", values, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidNotIn(List<String> values) {
            addCriterion("inspectId not in", values, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidBetween(String value1, String value2) {
            addCriterion("inspectId between", value1, value2, "inspectid");
            return (Criteria) this;
        }

        public Criteria andInspectidNotBetween(String value1, String value2) {
            addCriterion("inspectId not between", value1, value2, "inspectid");
            return (Criteria) this;
        }

        public Criteria andFinanceunitIsNull() {
            addCriterion("financeUnit is null");
            return (Criteria) this;
        }

        public Criteria andFinanceunitIsNotNull() {
            addCriterion("financeUnit is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceunitEqualTo(String value) {
            addCriterion("financeUnit =", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitNotEqualTo(String value) {
            addCriterion("financeUnit <>", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitGreaterThan(String value) {
            addCriterion("financeUnit >", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitGreaterThanOrEqualTo(String value) {
            addCriterion("financeUnit >=", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitLessThan(String value) {
            addCriterion("financeUnit <", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitLessThanOrEqualTo(String value) {
            addCriterion("financeUnit <=", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitLike(String value) {
            addCriterion("financeUnit like", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitNotLike(String value) {
            addCriterion("financeUnit not like", value, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitIn(List<String> values) {
            addCriterion("financeUnit in", values, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitNotIn(List<String> values) {
            addCriterion("financeUnit not in", values, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitBetween(String value1, String value2) {
            addCriterion("financeUnit between", value1, value2, "financeunit");
            return (Criteria) this;
        }

        public Criteria andFinanceunitNotBetween(String value1, String value2) {
            addCriterion("financeUnit not between", value1, value2, "financeunit");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonIsNull() {
            addCriterion("auditingPerson is null");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonIsNotNull() {
            addCriterion("auditingPerson is not null");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonEqualTo(String value) {
            addCriterion("auditingPerson =", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonNotEqualTo(String value) {
            addCriterion("auditingPerson <>", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonGreaterThan(String value) {
            addCriterion("auditingPerson >", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonGreaterThanOrEqualTo(String value) {
            addCriterion("auditingPerson >=", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonLessThan(String value) {
            addCriterion("auditingPerson <", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonLessThanOrEqualTo(String value) {
            addCriterion("auditingPerson <=", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonLike(String value) {
            addCriterion("auditingPerson like", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonNotLike(String value) {
            addCriterion("auditingPerson not like", value, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonIn(List<String> values) {
            addCriterion("auditingPerson in", values, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonNotIn(List<String> values) {
            addCriterion("auditingPerson not in", values, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonBetween(String value1, String value2) {
            addCriterion("auditingPerson between", value1, value2, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditingpersonNotBetween(String value1, String value2) {
            addCriterion("auditingPerson not between", value1, value2, "auditingperson");
            return (Criteria) this;
        }

        public Criteria andAuditdateIsNull() {
            addCriterion("auditDate is null");
            return (Criteria) this;
        }

        public Criteria andAuditdateIsNotNull() {
            addCriterion("auditDate is not null");
            return (Criteria) this;
        }

        public Criteria andAuditdateEqualTo(Date value) {
            addCriterionForJDBCDate("auditDate =", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("auditDate <>", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateGreaterThan(Date value) {
            addCriterionForJDBCDate("auditDate >", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auditDate >=", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateLessThan(Date value) {
            addCriterionForJDBCDate("auditDate <", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("auditDate <=", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateIn(List<Date> values) {
            addCriterionForJDBCDate("auditDate in", values, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("auditDate not in", values, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auditDate between", value1, value2, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("auditDate not between", value1, value2, "auditdate");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2IsNull() {
            addCriterion("enterpriseReceiver2 is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2IsNotNull() {
            addCriterion("enterpriseReceiver2 is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2EqualTo(String value) {
            addCriterion("enterpriseReceiver2 =", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2NotEqualTo(String value) {
            addCriterion("enterpriseReceiver2 <>", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2GreaterThan(String value) {
            addCriterion("enterpriseReceiver2 >", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2GreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseReceiver2 >=", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2LessThan(String value) {
            addCriterion("enterpriseReceiver2 <", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2LessThanOrEqualTo(String value) {
            addCriterion("enterpriseReceiver2 <=", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2Like(String value) {
            addCriterion("enterpriseReceiver2 like", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2NotLike(String value) {
            addCriterion("enterpriseReceiver2 not like", value, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2In(List<String> values) {
            addCriterion("enterpriseReceiver2 in", values, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2NotIn(List<String> values) {
            addCriterion("enterpriseReceiver2 not in", values, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2Between(String value1, String value2) {
            addCriterion("enterpriseReceiver2 between", value1, value2, "enterprisereceiver2");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiver2NotBetween(String value1, String value2) {
            addCriterion("enterpriseReceiver2 not between", value1, value2, "enterprisereceiver2");
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