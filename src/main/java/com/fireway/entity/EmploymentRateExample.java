package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class EmploymentRateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public EmploymentRateExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAcademyIsNull() {
            addCriterion("ACADEMY is null");
            return (Criteria) this;
        }

        public Criteria andAcademyIsNotNull() {
            addCriterion("ACADEMY is not null");
            return (Criteria) this;
        }

        public Criteria andAcademyEqualTo(String value) {
            addCriterion("ACADEMY =", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyNotEqualTo(String value) {
            addCriterion("ACADEMY <>", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyGreaterThan(String value) {
            addCriterion("ACADEMY >", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyGreaterThanOrEqualTo(String value) {
            addCriterion("ACADEMY >=", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyLessThan(String value) {
            addCriterion("ACADEMY <", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyLessThanOrEqualTo(String value) {
            addCriterion("ACADEMY <=", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyLike(String value) {
            addCriterion("ACADEMY like", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyNotLike(String value) {
            addCriterion("ACADEMY not like", value, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyIn(List<String> values) {
            addCriterion("ACADEMY in", values, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyNotIn(List<String> values) {
            addCriterion("ACADEMY not in", values, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyBetween(String value1, String value2) {
            addCriterion("ACADEMY between", value1, value2, "academy");
            return (Criteria) this;
        }

        public Criteria andAcademyNotBetween(String value1, String value2) {
            addCriterion("ACADEMY not between", value1, value2, "academy");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateIsNull() {
            addCriterion("EMPLOYMENT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateIsNotNull() {
            addCriterion("EMPLOYMENT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateEqualTo(Double value) {
            addCriterion("EMPLOYMENT_RATE =", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateNotEqualTo(Double value) {
            addCriterion("EMPLOYMENT_RATE <>", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateGreaterThan(Double value) {
            addCriterion("EMPLOYMENT_RATE >", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateGreaterThanOrEqualTo(Double value) {
            addCriterion("EMPLOYMENT_RATE >=", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateLessThan(Double value) {
            addCriterion("EMPLOYMENT_RATE <", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateLessThanOrEqualTo(Double value) {
            addCriterion("EMPLOYMENT_RATE <=", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateIn(List<Double> values) {
            addCriterion("EMPLOYMENT_RATE in", values, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateNotIn(List<Double> values) {
            addCriterion("EMPLOYMENT_RATE not in", values, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateBetween(Double value1, Double value2) {
            addCriterion("EMPLOYMENT_RATE between", value1, value2, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateNotBetween(Double value1, Double value2) {
            addCriterion("EMPLOYMENT_RATE not between", value1, value2, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIsNull() {
            addCriterion("SCHOO_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIsNotNull() {
            addCriterion("SCHOO_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearEqualTo(String value) {
            addCriterion("SCHOO_YEAR =", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotEqualTo(String value) {
            addCriterion("SCHOO_YEAR <>", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearGreaterThan(String value) {
            addCriterion("SCHOO_YEAR >", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOO_YEAR >=", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLessThan(String value) {
            addCriterion("SCHOO_YEAR <", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLessThanOrEqualTo(String value) {
            addCriterion("SCHOO_YEAR <=", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLike(String value) {
            addCriterion("SCHOO_YEAR like", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotLike(String value) {
            addCriterion("SCHOO_YEAR not like", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIn(List<String> values) {
            addCriterion("SCHOO_YEAR in", values, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotIn(List<String> values) {
            addCriterion("SCHOO_YEAR not in", values, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearBetween(String value1, String value2) {
            addCriterion("SCHOO_YEAR between", value1, value2, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotBetween(String value1, String value2) {
            addCriterion("SCHOO_YEAR not between", value1, value2, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearIsNull() {
            addCriterion("GRADUATION_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andGraduationYearIsNotNull() {
            addCriterion("GRADUATION_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationYearEqualTo(String value) {
            addCriterion("GRADUATION_YEAR =", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearNotEqualTo(String value) {
            addCriterion("GRADUATION_YEAR <>", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearGreaterThan(String value) {
            addCriterion("GRADUATION_YEAR >", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearGreaterThanOrEqualTo(String value) {
            addCriterion("GRADUATION_YEAR >=", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearLessThan(String value) {
            addCriterion("GRADUATION_YEAR <", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearLessThanOrEqualTo(String value) {
            addCriterion("GRADUATION_YEAR <=", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearLike(String value) {
            addCriterion("GRADUATION_YEAR like", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearNotLike(String value) {
            addCriterion("GRADUATION_YEAR not like", value, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearIn(List<String> values) {
            addCriterion("GRADUATION_YEAR in", values, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearNotIn(List<String> values) {
            addCriterion("GRADUATION_YEAR not in", values, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearBetween(String value1, String value2) {
            addCriterion("GRADUATION_YEAR between", value1, value2, "graduationYear");
            return (Criteria) this;
        }

        public Criteria andGraduationYearNotBetween(String value1, String value2) {
            addCriterion("GRADUATION_YEAR not between", value1, value2, "graduationYear");
            return (Criteria) this;
        }
    }

    /**
     */
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