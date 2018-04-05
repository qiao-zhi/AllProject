package cn.xm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EnterpriseInspectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseInspectExample() {
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

        public Criteria andInspectpersonIsNull() {
            addCriterion("inspectPerson is null");
            return (Criteria) this;
        }

        public Criteria andInspectpersonIsNotNull() {
            addCriterion("inspectPerson is not null");
            return (Criteria) this;
        }

        public Criteria andInspectpersonEqualTo(String value) {
            addCriterion("inspectPerson =", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonNotEqualTo(String value) {
            addCriterion("inspectPerson <>", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonGreaterThan(String value) {
            addCriterion("inspectPerson >", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonGreaterThanOrEqualTo(String value) {
            addCriterion("inspectPerson >=", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonLessThan(String value) {
            addCriterion("inspectPerson <", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonLessThanOrEqualTo(String value) {
            addCriterion("inspectPerson <=", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonLike(String value) {
            addCriterion("inspectPerson like", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonNotLike(String value) {
            addCriterion("inspectPerson not like", value, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonIn(List<String> values) {
            addCriterion("inspectPerson in", values, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonNotIn(List<String> values) {
            addCriterion("inspectPerson not in", values, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonBetween(String value1, String value2) {
            addCriterion("inspectPerson between", value1, value2, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectpersonNotBetween(String value1, String value2) {
            addCriterion("inspectPerson not between", value1, value2, "inspectperson");
            return (Criteria) this;
        }

        public Criteria andInspectdateIsNull() {
            addCriterion("inspectDate is null");
            return (Criteria) this;
        }

        public Criteria andInspectdateIsNotNull() {
            addCriterion("inspectDate is not null");
            return (Criteria) this;
        }

        public Criteria andInspectdateEqualTo(Date value) {
            addCriterionForJDBCDate("inspectDate =", value, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("inspectDate <>", value, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateGreaterThan(Date value) {
            addCriterionForJDBCDate("inspectDate >", value, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("inspectDate >=", value, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateLessThan(Date value) {
            addCriterionForJDBCDate("inspectDate <", value, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("inspectDate <=", value, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateIn(List<Date> values) {
            addCriterionForJDBCDate("inspectDate in", values, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("inspectDate not in", values, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("inspectDate between", value1, value2, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andInspectdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("inspectDate not between", value1, value2, "inspectdate");
            return (Criteria) this;
        }

        public Criteria andIsauditIsNull() {
            addCriterion("isAudit is null");
            return (Criteria) this;
        }

        public Criteria andIsauditIsNotNull() {
            addCriterion("isAudit is not null");
            return (Criteria) this;
        }

        public Criteria andIsauditEqualTo(Boolean value) {
            addCriterion("isAudit =", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotEqualTo(Boolean value) {
            addCriterion("isAudit <>", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditGreaterThan(Boolean value) {
            addCriterion("isAudit >", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isAudit >=", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditLessThan(Boolean value) {
            addCriterion("isAudit <", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditLessThanOrEqualTo(Boolean value) {
            addCriterion("isAudit <=", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditIn(List<Boolean> values) {
            addCriterion("isAudit in", values, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotIn(List<Boolean> values) {
            addCriterion("isAudit not in", values, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditBetween(Boolean value1, Boolean value2) {
            addCriterion("isAudit between", value1, value2, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isAudit not between", value1, value2, "isaudit");
            return (Criteria) this;
        }

        public Criteria andInspectstatusIsNull() {
            addCriterion("inspectStatus is null");
            return (Criteria) this;
        }

        public Criteria andInspectstatusIsNotNull() {
            addCriterion("inspectStatus is not null");
            return (Criteria) this;
        }

        public Criteria andInspectstatusEqualTo(String value) {
            addCriterion("inspectStatus =", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusNotEqualTo(String value) {
            addCriterion("inspectStatus <>", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusGreaterThan(String value) {
            addCriterion("inspectStatus >", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusGreaterThanOrEqualTo(String value) {
            addCriterion("inspectStatus >=", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusLessThan(String value) {
            addCriterion("inspectStatus <", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusLessThanOrEqualTo(String value) {
            addCriterion("inspectStatus <=", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusLike(String value) {
            addCriterion("inspectStatus like", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusNotLike(String value) {
            addCriterion("inspectStatus not like", value, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusIn(List<String> values) {
            addCriterion("inspectStatus in", values, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusNotIn(List<String> values) {
            addCriterion("inspectStatus not in", values, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusBetween(String value1, String value2) {
            addCriterion("inspectStatus between", value1, value2, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andInspectstatusNotBetween(String value1, String value2) {
            addCriterion("inspectStatus not between", value1, value2, "inspectstatus");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverIsNull() {
            addCriterion("enterpriseReceiver is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverIsNotNull() {
            addCriterion("enterpriseReceiver is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverEqualTo(String value) {
            addCriterion("enterpriseReceiver =", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverNotEqualTo(String value) {
            addCriterion("enterpriseReceiver <>", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverGreaterThan(String value) {
            addCriterion("enterpriseReceiver >", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseReceiver >=", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverLessThan(String value) {
            addCriterion("enterpriseReceiver <", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverLessThanOrEqualTo(String value) {
            addCriterion("enterpriseReceiver <=", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverLike(String value) {
            addCriterion("enterpriseReceiver like", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverNotLike(String value) {
            addCriterion("enterpriseReceiver not like", value, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverIn(List<String> values) {
            addCriterion("enterpriseReceiver in", values, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverNotIn(List<String> values) {
            addCriterion("enterpriseReceiver not in", values, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverBetween(String value1, String value2) {
            addCriterion("enterpriseReceiver between", value1, value2, "enterprisereceiver");
            return (Criteria) this;
        }

        public Criteria andEnterprisereceiverNotBetween(String value1, String value2) {
            addCriterion("enterpriseReceiver not between", value1, value2, "enterprisereceiver");
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