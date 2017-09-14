package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassSubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ClassSubjectExample() {
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

        public Criteria andClassIdIsNull() {
            addCriterion("CLASS_ID is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("CLASS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(String value) {
            addCriterion("CLASS_ID =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(String value) {
            addCriterion("CLASS_ID <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(String value) {
            addCriterion("CLASS_ID >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_ID >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(String value) {
            addCriterion("CLASS_ID <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(String value) {
            addCriterion("CLASS_ID <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLike(String value) {
            addCriterion("CLASS_ID like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotLike(String value) {
            addCriterion("CLASS_ID not like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<String> values) {
            addCriterion("CLASS_ID in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<String> values) {
            addCriterion("CLASS_ID not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(String value1, String value2) {
            addCriterion("CLASS_ID between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(String value1, String value2) {
            addCriterion("CLASS_ID not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdIsNull() {
            addCriterion("SUBJECT_ARRANGEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdIsNotNull() {
            addCriterion("SUBJECT_ARRANGEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdEqualTo(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID =", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdNotEqualTo(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID <>", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdGreaterThan(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID >", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID >=", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdLessThan(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID <", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID <=", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdLike(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID like", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdNotLike(String value) {
            addCriterion("SUBJECT_ARRANGEMENT_ID not like", value, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdIn(List<String> values) {
            addCriterion("SUBJECT_ARRANGEMENT_ID in", values, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdNotIn(List<String> values) {
            addCriterion("SUBJECT_ARRANGEMENT_ID not in", values, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdBetween(String value1, String value2) {
            addCriterion("SUBJECT_ARRANGEMENT_ID between", value1, value2, "subjectArrangementId");
            return (Criteria) this;
        }

        public Criteria andSubjectArrangementIdNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_ARRANGEMENT_ID not between", value1, value2, "subjectArrangementId");
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