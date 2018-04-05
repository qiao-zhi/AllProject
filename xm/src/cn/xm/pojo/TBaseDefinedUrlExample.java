package cn.xm.pojo;

import java.util.ArrayList;
import java.util.List;

public class TBaseDefinedUrlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBaseDefinedUrlExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andModuleidIsNull() {
            addCriterion("moduleId is null");
            return (Criteria) this;
        }

        public Criteria andModuleidIsNotNull() {
            addCriterion("moduleId is not null");
            return (Criteria) this;
        }

        public Criteria andModuleidEqualTo(String value) {
            addCriterion("moduleId =", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotEqualTo(String value) {
            addCriterion("moduleId <>", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidGreaterThan(String value) {
            addCriterion("moduleId >", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidGreaterThanOrEqualTo(String value) {
            addCriterion("moduleId >=", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLessThan(String value) {
            addCriterion("moduleId <", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLessThanOrEqualTo(String value) {
            addCriterion("moduleId <=", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLike(String value) {
            addCriterion("moduleId like", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotLike(String value) {
            addCriterion("moduleId not like", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidIn(List<String> values) {
            addCriterion("moduleId in", values, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotIn(List<String> values) {
            addCriterion("moduleId not in", values, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidBetween(String value1, String value2) {
            addCriterion("moduleId between", value1, value2, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotBetween(String value1, String value2) {
            addCriterion("moduleId not between", value1, value2, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModulenameIsNull() {
            addCriterion("moduleName is null");
            return (Criteria) this;
        }

        public Criteria andModulenameIsNotNull() {
            addCriterion("moduleName is not null");
            return (Criteria) this;
        }

        public Criteria andModulenameEqualTo(String value) {
            addCriterion("moduleName =", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotEqualTo(String value) {
            addCriterion("moduleName <>", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameGreaterThan(String value) {
            addCriterion("moduleName >", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameGreaterThanOrEqualTo(String value) {
            addCriterion("moduleName >=", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLessThan(String value) {
            addCriterion("moduleName <", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLessThanOrEqualTo(String value) {
            addCriterion("moduleName <=", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLike(String value) {
            addCriterion("moduleName like", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotLike(String value) {
            addCriterion("moduleName not like", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameIn(List<String> values) {
            addCriterion("moduleName in", values, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotIn(List<String> values) {
            addCriterion("moduleName not in", values, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameBetween(String value1, String value2) {
            addCriterion("moduleName between", value1, value2, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotBetween(String value1, String value2) {
            addCriterion("moduleName not between", value1, value2, "modulename");
            return (Criteria) this;
        }

        public Criteria andModuleurlIsNull() {
            addCriterion("moduleURL is null");
            return (Criteria) this;
        }

        public Criteria andModuleurlIsNotNull() {
            addCriterion("moduleURL is not null");
            return (Criteria) this;
        }

        public Criteria andModuleurlEqualTo(String value) {
            addCriterion("moduleURL =", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlNotEqualTo(String value) {
            addCriterion("moduleURL <>", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlGreaterThan(String value) {
            addCriterion("moduleURL >", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlGreaterThanOrEqualTo(String value) {
            addCriterion("moduleURL >=", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlLessThan(String value) {
            addCriterion("moduleURL <", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlLessThanOrEqualTo(String value) {
            addCriterion("moduleURL <=", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlLike(String value) {
            addCriterion("moduleURL like", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlNotLike(String value) {
            addCriterion("moduleURL not like", value, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlIn(List<String> values) {
            addCriterion("moduleURL in", values, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlNotIn(List<String> values) {
            addCriterion("moduleURL not in", values, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlBetween(String value1, String value2) {
            addCriterion("moduleURL between", value1, value2, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andModuleurlNotBetween(String value1, String value2) {
            addCriterion("moduleURL not between", value1, value2, "moduleurl");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNull() {
            addCriterion("memo1 is null");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNotNull() {
            addCriterion("memo1 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo1EqualTo(String value) {
            addCriterion("memo1 =", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotEqualTo(String value) {
            addCriterion("memo1 <>", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThan(String value) {
            addCriterion("memo1 >", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThanOrEqualTo(String value) {
            addCriterion("memo1 >=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThan(String value) {
            addCriterion("memo1 <", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThanOrEqualTo(String value) {
            addCriterion("memo1 <=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Like(String value) {
            addCriterion("memo1 like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotLike(String value) {
            addCriterion("memo1 not like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1In(List<String> values) {
            addCriterion("memo1 in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotIn(List<String> values) {
            addCriterion("memo1 not in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Between(String value1, String value2) {
            addCriterion("memo1 between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotBetween(String value1, String value2) {
            addCriterion("memo1 not between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMomo2IsNull() {
            addCriterion("momo2 is null");
            return (Criteria) this;
        }

        public Criteria andMomo2IsNotNull() {
            addCriterion("momo2 is not null");
            return (Criteria) this;
        }

        public Criteria andMomo2EqualTo(String value) {
            addCriterion("momo2 =", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2NotEqualTo(String value) {
            addCriterion("momo2 <>", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2GreaterThan(String value) {
            addCriterion("momo2 >", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2GreaterThanOrEqualTo(String value) {
            addCriterion("momo2 >=", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2LessThan(String value) {
            addCriterion("momo2 <", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2LessThanOrEqualTo(String value) {
            addCriterion("momo2 <=", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2Like(String value) {
            addCriterion("momo2 like", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2NotLike(String value) {
            addCriterion("momo2 not like", value, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2In(List<String> values) {
            addCriterion("momo2 in", values, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2NotIn(List<String> values) {
            addCriterion("momo2 not in", values, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2Between(String value1, String value2) {
            addCriterion("momo2 between", value1, value2, "momo2");
            return (Criteria) this;
        }

        public Criteria andMomo2NotBetween(String value1, String value2) {
            addCriterion("momo2 not between", value1, value2, "momo2");
            return (Criteria) this;
        }

        public Criteria andInuseIsNull() {
            addCriterion("inUse is null");
            return (Criteria) this;
        }

        public Criteria andInuseIsNotNull() {
            addCriterion("inUse is not null");
            return (Criteria) this;
        }

        public Criteria andInuseEqualTo(Boolean value) {
            addCriterion("inUse =", value, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseNotEqualTo(Boolean value) {
            addCriterion("inUse <>", value, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseGreaterThan(Boolean value) {
            addCriterion("inUse >", value, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("inUse >=", value, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseLessThan(Boolean value) {
            addCriterion("inUse <", value, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseLessThanOrEqualTo(Boolean value) {
            addCriterion("inUse <=", value, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseIn(List<Boolean> values) {
            addCriterion("inUse in", values, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseNotIn(List<Boolean> values) {
            addCriterion("inUse not in", values, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseBetween(Boolean value1, Boolean value2) {
            addCriterion("inUse between", value1, value2, "inuse");
            return (Criteria) this;
        }

        public Criteria andInuseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("inUse not between", value1, value2, "inuse");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNull() {
            addCriterion("sortNo is null");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNotNull() {
            addCriterion("sortNo is not null");
            return (Criteria) this;
        }

        public Criteria andSortnoEqualTo(Integer value) {
            addCriterion("sortNo =", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotEqualTo(Integer value) {
            addCriterion("sortNo <>", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThan(Integer value) {
            addCriterion("sortNo >", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortNo >=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThan(Integer value) {
            addCriterion("sortNo <", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThanOrEqualTo(Integer value) {
            addCriterion("sortNo <=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoIn(List<Integer> values) {
            addCriterion("sortNo in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotIn(List<Integer> values) {
            addCriterion("sortNo not in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoBetween(Integer value1, Integer value2) {
            addCriterion("sortNo between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotBetween(Integer value1, Integer value2) {
            addCriterion("sortNo not between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andMenuclassIsNull() {
            addCriterion("menuClass is null");
            return (Criteria) this;
        }

        public Criteria andMenuclassIsNotNull() {
            addCriterion("menuClass is not null");
            return (Criteria) this;
        }

        public Criteria andMenuclassEqualTo(Integer value) {
            addCriterion("menuClass =", value, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassNotEqualTo(Integer value) {
            addCriterion("menuClass <>", value, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassGreaterThan(Integer value) {
            addCriterion("menuClass >", value, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuClass >=", value, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassLessThan(Integer value) {
            addCriterion("menuClass <", value, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassLessThanOrEqualTo(Integer value) {
            addCriterion("menuClass <=", value, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassIn(List<Integer> values) {
            addCriterion("menuClass in", values, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassNotIn(List<Integer> values) {
            addCriterion("menuClass not in", values, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassBetween(Integer value1, Integer value2) {
            addCriterion("menuClass between", value1, value2, "menuclass");
            return (Criteria) this;
        }

        public Criteria andMenuclassNotBetween(Integer value1, Integer value2) {
            addCriterion("menuClass not between", value1, value2, "menuclass");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
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