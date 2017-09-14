package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentSelectSubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public StudentSelectSubjectExample() {
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

        public Criteria andSelectSubjectIdIsNull() {
            addCriterion("SELECT_SUBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdIsNotNull() {
            addCriterion("SELECT_SUBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdEqualTo(String value) {
            addCriterion("SELECT_SUBJECT_ID =", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdNotEqualTo(String value) {
            addCriterion("SELECT_SUBJECT_ID <>", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdGreaterThan(String value) {
            addCriterion("SELECT_SUBJECT_ID >", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("SELECT_SUBJECT_ID >=", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdLessThan(String value) {
            addCriterion("SELECT_SUBJECT_ID <", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdLessThanOrEqualTo(String value) {
            addCriterion("SELECT_SUBJECT_ID <=", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdLike(String value) {
            addCriterion("SELECT_SUBJECT_ID like", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdNotLike(String value) {
            addCriterion("SELECT_SUBJECT_ID not like", value, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdIn(List<String> values) {
            addCriterion("SELECT_SUBJECT_ID in", values, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdNotIn(List<String> values) {
            addCriterion("SELECT_SUBJECT_ID not in", values, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdBetween(String value1, String value2) {
            addCriterion("SELECT_SUBJECT_ID between", value1, value2, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andSelectSubjectIdNotBetween(String value1, String value2) {
            addCriterion("SELECT_SUBJECT_ID not between", value1, value2, "selectSubjectId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("STUDENT_ID =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("STUDENT_ID <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("STUDENT_ID >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("STUDENT_ID <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("STUDENT_ID like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("STUDENT_ID not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("STUDENT_ID in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("STUDENT_ID not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("STUDENT_ID between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("STUDENT_ID not between", value1, value2, "studentId");
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