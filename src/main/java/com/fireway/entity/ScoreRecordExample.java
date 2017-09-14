package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ScoreRecordExample() {
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("UPDATE_TIME like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("UPDATE_TIME not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOperatorNumIsNull() {
            addCriterion("OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNumIsNotNull() {
            addCriterion("OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNumEqualTo(String value) {
            addCriterion("OPERATOR_ID =", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumNotEqualTo(String value) {
            addCriterion("OPERATOR_ID <>", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumGreaterThan(String value) {
            addCriterion("OPERATOR_ID >", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_ID >=", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumLessThan(String value) {
            addCriterion("OPERATOR_ID <", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_ID <=", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumLike(String value) {
            addCriterion("OPERATOR_ID like", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumNotLike(String value) {
            addCriterion("OPERATOR_ID not like", value, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumIn(List<String> values) {
            addCriterion("OPERATOR_ID in", values, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumNotIn(List<String> values) {
            addCriterion("OPERATOR_ID not in", values, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumBetween(String value1, String value2) {
            addCriterion("OPERATOR_ID between", value1, value2, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorNumNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_ID not between", value1, value2, "operatorNum");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("OPERATOR =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("OPERATOR <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("OPERATOR >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("OPERATOR <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("OPERATOR like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("OPERATOR not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("OPERATOR in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("OPERATOR not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("OPERATOR between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("OPERATOR not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIsNull() {
            addCriterion("SCHOOL_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIsNotNull() {
            addCriterion("SCHOOL_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearEqualTo(String value) {
            addCriterion("SCHOOL_YEAR =", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotEqualTo(String value) {
            addCriterion("SCHOOL_YEAR <>", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearGreaterThan(String value) {
            addCriterion("SCHOOL_YEAR >", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOL_YEAR >=", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLessThan(String value) {
            addCriterion("SCHOOL_YEAR <", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLessThanOrEqualTo(String value) {
            addCriterion("SCHOOL_YEAR <=", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearLike(String value) {
            addCriterion("SCHOOL_YEAR like", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotLike(String value) {
            addCriterion("SCHOOL_YEAR not like", value, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIn(List<String> values) {
            addCriterion("SCHOOL_YEAR in", values, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotIn(List<String> values) {
            addCriterion("SCHOOL_YEAR not in", values, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearBetween(String value1, String value2) {
            addCriterion("SCHOOL_YEAR between", value1, value2, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNotBetween(String value1, String value2) {
            addCriterion("SCHOOL_YEAR not between", value1, value2, "schoolYear");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("TERM is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("TERM is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Integer value) {
            addCriterion("TERM =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Integer value) {
            addCriterion("TERM <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Integer value) {
            addCriterion("TERM >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("TERM >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Integer value) {
            addCriterion("TERM <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Integer value) {
            addCriterion("TERM <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Integer> values) {
            addCriterion("TERM in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Integer> values) {
            addCriterion("TERM not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Integer value1, Integer value2) {
            addCriterion("TERM between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Integer value1, Integer value2) {
            addCriterion("TERM not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("SUBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("SUBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(String value) {
            addCriterion("SUBJECT_ID =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(String value) {
            addCriterion("SUBJECT_ID <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(String value) {
            addCriterion("SUBJECT_ID >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_ID >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(String value) {
            addCriterion("SUBJECT_ID <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_ID <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLike(String value) {
            addCriterion("SUBJECT_ID like", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotLike(String value) {
            addCriterion("SUBJECT_ID not like", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<String> values) {
            addCriterion("SUBJECT_ID in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<String> values) {
            addCriterion("SUBJECT_ID not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(String value1, String value2) {
            addCriterion("SUBJECT_ID between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_ID not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesIsNull() {
            addCriterion("SUBJECT_VOLUMES is null");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesIsNotNull() {
            addCriterion("SUBJECT_VOLUMES is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesEqualTo(String value) {
            addCriterion("SUBJECT_VOLUMES =", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesNotEqualTo(String value) {
            addCriterion("SUBJECT_VOLUMES <>", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesGreaterThan(String value) {
            addCriterion("SUBJECT_VOLUMES >", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_VOLUMES >=", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesLessThan(String value) {
            addCriterion("SUBJECT_VOLUMES <", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_VOLUMES <=", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesLike(String value) {
            addCriterion("SUBJECT_VOLUMES like", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesNotLike(String value) {
            addCriterion("SUBJECT_VOLUMES not like", value, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesIn(List<String> values) {
            addCriterion("SUBJECT_VOLUMES in", values, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesNotIn(List<String> values) {
            addCriterion("SUBJECT_VOLUMES not in", values, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesBetween(String value1, String value2) {
            addCriterion("SUBJECT_VOLUMES between", value1, value2, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectVolumesNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_VOLUMES not between", value1, value2, "subjectVolumes");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNull() {
            addCriterion("SUBJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNotNull() {
            addCriterion("SUBJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEqualTo(String value) {
            addCriterion("SUBJECT_NAME =", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotEqualTo(String value) {
            addCriterion("SUBJECT_NAME <>", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThan(String value) {
            addCriterion("SUBJECT_NAME >", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_NAME >=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThan(String value) {
            addCriterion("SUBJECT_NAME <", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_NAME <=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLike(String value) {
            addCriterion("SUBJECT_NAME like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotLike(String value) {
            addCriterion("SUBJECT_NAME not like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIn(List<String> values) {
            addCriterion("SUBJECT_NAME in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotIn(List<String> values) {
            addCriterion("SUBJECT_NAME not in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameBetween(String value1, String value2) {
            addCriterion("SUBJECT_NAME between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_NAME not between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeIsNull() {
            addCriterion("SUBJECT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeIsNotNull() {
            addCriterion("SUBJECT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeEqualTo(String value) {
            addCriterion("SUBJECT_CODE =", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotEqualTo(String value) {
            addCriterion("SUBJECT_CODE <>", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeGreaterThan(String value) {
            addCriterion("SUBJECT_CODE >", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_CODE >=", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeLessThan(String value) {
            addCriterion("SUBJECT_CODE <", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_CODE <=", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeLike(String value) {
            addCriterion("SUBJECT_CODE like", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotLike(String value) {
            addCriterion("SUBJECT_CODE not like", value, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeIn(List<String> values) {
            addCriterion("SUBJECT_CODE in", values, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotIn(List<String> values) {
            addCriterion("SUBJECT_CODE not in", values, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeBetween(String value1, String value2) {
            addCriterion("SUBJECT_CODE between", value1, value2, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectCodeNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_CODE not between", value1, value2, "subjectCode");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredIsNull() {
            addCriterion("SUBJECT_ISREQUIRED is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredIsNotNull() {
            addCriterion("SUBJECT_ISREQUIRED is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredEqualTo(Boolean value) {
            addCriterion("SUBJECT_ISREQUIRED =", value, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredNotEqualTo(Boolean value) {
            addCriterion("SUBJECT_ISREQUIRED <>", value, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredGreaterThan(Boolean value) {
            addCriterion("SUBJECT_ISREQUIRED >", value, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("SUBJECT_ISREQUIRED >=", value, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredLessThan(Boolean value) {
            addCriterion("SUBJECT_ISREQUIRED <", value, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredLessThanOrEqualTo(Boolean value) {
            addCriterion("SUBJECT_ISREQUIRED <=", value, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredIn(List<Boolean> values) {
            addCriterion("SUBJECT_ISREQUIRED in", values, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredNotIn(List<Boolean> values) {
            addCriterion("SUBJECT_ISREQUIRED not in", values, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredBetween(Boolean value1, Boolean value2) {
            addCriterion("SUBJECT_ISREQUIRED between", value1, value2, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectIsRequiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("SUBJECT_ISREQUIRED not between", value1, value2, "subjectIsRequired");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsIsNull() {
            addCriterion("SUBJECT_CREDITS is null");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsIsNotNull() {
            addCriterion("SUBJECT_CREDITS is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsEqualTo(Double value) {
            addCriterion("SUBJECT_CREDITS =", value, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsNotEqualTo(Double value) {
            addCriterion("SUBJECT_CREDITS <>", value, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsGreaterThan(Double value) {
            addCriterion("SUBJECT_CREDITS >", value, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsGreaterThanOrEqualTo(Double value) {
            addCriterion("SUBJECT_CREDITS >=", value, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsLessThan(Double value) {
            addCriterion("SUBJECT_CREDITS <", value, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsLessThanOrEqualTo(Double value) {
            addCriterion("SUBJECT_CREDITS <=", value, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsIn(List<Double> values) {
            addCriterion("SUBJECT_CREDITS in", values, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsNotIn(List<Double> values) {
            addCriterion("SUBJECT_CREDITS not in", values, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsBetween(Double value1, Double value2) {
            addCriterion("SUBJECT_CREDITS between", value1, value2, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andSubjectCreditsNotBetween(Double value1, Double value2) {
            addCriterion("SUBJECT_CREDITS not between", value1, value2, "subjectCredits");
            return (Criteria) this;
        }

        public Criteria andCommonScoreIsNull() {
            addCriterion("COMMON_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andCommonScoreIsNotNull() {
            addCriterion("COMMON_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andCommonScoreEqualTo(Double value) {
            addCriterion("COMMON_SCORE =", value, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreNotEqualTo(Double value) {
            addCriterion("COMMON_SCORE <>", value, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreGreaterThan(Double value) {
            addCriterion("COMMON_SCORE >", value, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("COMMON_SCORE >=", value, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreLessThan(Double value) {
            addCriterion("COMMON_SCORE <", value, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreLessThanOrEqualTo(Double value) {
            addCriterion("COMMON_SCORE <=", value, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreIn(List<Double> values) {
            addCriterion("COMMON_SCORE in", values, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreNotIn(List<Double> values) {
            addCriterion("COMMON_SCORE not in", values, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreBetween(Double value1, Double value2) {
            addCriterion("COMMON_SCORE between", value1, value2, "commonScore");
            return (Criteria) this;
        }

        public Criteria andCommonScoreNotBetween(Double value1, Double value2) {
            addCriterion("COMMON_SCORE not between", value1, value2, "commonScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreIsNull() {
            addCriterion("TEST_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andTestScoreIsNotNull() {
            addCriterion("TEST_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andTestScoreEqualTo(Double value) {
            addCriterion("TEST_SCORE =", value, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreNotEqualTo(Double value) {
            addCriterion("TEST_SCORE <>", value, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreGreaterThan(Double value) {
            addCriterion("TEST_SCORE >", value, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("TEST_SCORE >=", value, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreLessThan(Double value) {
            addCriterion("TEST_SCORE <", value, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreLessThanOrEqualTo(Double value) {
            addCriterion("TEST_SCORE <=", value, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreIn(List<Double> values) {
            addCriterion("TEST_SCORE in", values, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreNotIn(List<Double> values) {
            addCriterion("TEST_SCORE not in", values, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreBetween(Double value1, Double value2) {
            addCriterion("TEST_SCORE between", value1, value2, "testScore");
            return (Criteria) this;
        }

        public Criteria andTestScoreNotBetween(Double value1, Double value2) {
            addCriterion("TEST_SCORE not between", value1, value2, "testScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("TOTAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("TOTAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Double value) {
            addCriterion("TOTAL_SCORE =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Double value) {
            addCriterion("TOTAL_SCORE <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Double value) {
            addCriterion("TOTAL_SCORE >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_SCORE >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Double value) {
            addCriterion("TOTAL_SCORE <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_SCORE <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Double> values) {
            addCriterion("TOTAL_SCORE in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Double> values) {
            addCriterion("TOTAL_SCORE not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Double value1, Double value2) {
            addCriterion("TOTAL_SCORE between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_SCORE not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("POINT is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("POINT is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(Double value) {
            addCriterion("POINT =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(Double value) {
            addCriterion("POINT <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(Double value) {
            addCriterion("POINT >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(Double value) {
            addCriterion("POINT >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(Double value) {
            addCriterion("POINT <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(Double value) {
            addCriterion("POINT <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<Double> values) {
            addCriterion("POINT in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<Double> values) {
            addCriterion("POINT not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(Double value1, Double value2) {
            addCriterion("POINT between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(Double value1, Double value2) {
            addCriterion("POINT not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andIsRebuildIsNull() {
            addCriterion("IS_REBUILD is null");
            return (Criteria) this;
        }

        public Criteria andIsRebuildIsNotNull() {
            addCriterion("IS_REBUILD is not null");
            return (Criteria) this;
        }

        public Criteria andIsRebuildEqualTo(Boolean value) {
            addCriterion("IS_REBUILD =", value, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildNotEqualTo(Boolean value) {
            addCriterion("IS_REBUILD <>", value, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildGreaterThan(Boolean value) {
            addCriterion("IS_REBUILD >", value, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_REBUILD >=", value, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildLessThan(Boolean value) {
            addCriterion("IS_REBUILD <", value, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_REBUILD <=", value, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildIn(List<Boolean> values) {
            addCriterion("IS_REBUILD in", values, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildNotIn(List<Boolean> values) {
            addCriterion("IS_REBUILD not in", values, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_REBUILD between", value1, value2, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andIsRebuildNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_REBUILD not between", value1, value2, "isRebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreIsNull() {
            addCriterion("REBUILD_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreIsNotNull() {
            addCriterion("REBUILD_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreEqualTo(Double value) {
            addCriterion("REBUILD_SCORE =", value, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreNotEqualTo(Double value) {
            addCriterion("REBUILD_SCORE <>", value, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreGreaterThan(Double value) {
            addCriterion("REBUILD_SCORE >", value, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("REBUILD_SCORE >=", value, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreLessThan(Double value) {
            addCriterion("REBUILD_SCORE <", value, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreLessThanOrEqualTo(Double value) {
            addCriterion("REBUILD_SCORE <=", value, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreIn(List<Double> values) {
            addCriterion("REBUILD_SCORE in", values, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreNotIn(List<Double> values) {
            addCriterion("REBUILD_SCORE not in", values, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreBetween(Double value1, Double value2) {
            addCriterion("REBUILD_SCORE between", value1, value2, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andRebuildScoreNotBetween(Double value1, Double value2) {
            addCriterion("REBUILD_SCORE not between", value1, value2, "rebuildScore");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNull() {
            addCriterion("STUDENT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNotNull() {
            addCriterion("STUDENT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumEqualTo(String value) {
            addCriterion("STUDENT_NUM =", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotEqualTo(String value) {
            addCriterion("STUDENT_NUM <>", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThan(String value) {
            addCriterion("STUDENT_NUM >", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_NUM >=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThan(String value) {
            addCriterion("STUDENT_NUM <", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_NUM <=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLike(String value) {
            addCriterion("STUDENT_NUM like", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotLike(String value) {
            addCriterion("STUDENT_NUM not like", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumIn(List<String> values) {
            addCriterion("STUDENT_NUM in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotIn(List<String> values) {
            addCriterion("STUDENT_NUM not in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumBetween(String value1, String value2) {
            addCriterion("STUDENT_NUM between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotBetween(String value1, String value2) {
            addCriterion("STUDENT_NUM not between", value1, value2, "studentNum");
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

        public Criteria andTeacherNumIsNull() {
            addCriterion("TEACHER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumIsNotNull() {
            addCriterion("TEACHER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumEqualTo(String value) {
            addCriterion("TEACHER_NUM =", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumNotEqualTo(String value) {
            addCriterion("TEACHER_NUM <>", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumGreaterThan(String value) {
            addCriterion("TEACHER_NUM >", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_NUM >=", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumLessThan(String value) {
            addCriterion("TEACHER_NUM <", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_NUM <=", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumLike(String value) {
            addCriterion("TEACHER_NUM like", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumNotLike(String value) {
            addCriterion("TEACHER_NUM not like", value, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumIn(List<String> values) {
            addCriterion("TEACHER_NUM in", values, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumNotIn(List<String> values) {
            addCriterion("TEACHER_NUM not in", values, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumBetween(String value1, String value2) {
            addCriterion("TEACHER_NUM between", value1, value2, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherNumNotBetween(String value1, String value2) {
            addCriterion("TEACHER_NUM not between", value1, value2, "teacherNum");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("TEACHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("TEACHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("TEACHER_ID =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("TEACHER_ID <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("TEACHER_ID >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("TEACHER_ID <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("TEACHER_ID like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("TEACHER_ID not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("TEACHER_ID in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("TEACHER_ID not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("TEACHER_ID between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("TEACHER_ID not between", value1, value2, "teacherId");
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