package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class SubjectArrangementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SubjectArrangementExample() {
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

        public Criteria andTermEqualTo(String value) {
            addCriterion("TERM =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(String value) {
            addCriterion("TERM <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(String value) {
            addCriterion("TERM >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(String value) {
            addCriterion("TERM >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(String value) {
            addCriterion("TERM <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(String value) {
            addCriterion("TERM <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLike(String value) {
            addCriterion("TERM like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotLike(String value) {
            addCriterion("TERM not like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<String> values) {
            addCriterion("TERM in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<String> values) {
            addCriterion("TERM not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(String value1, String value2) {
            addCriterion("TERM between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(String value1, String value2) {
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

        public Criteria andTeacherNameIsNull() {
            addCriterion("TEACHER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("TEACHER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("TEACHER_NAME =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("TEACHER_NAME <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("TEACHER_NAME >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_NAME >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("TEACHER_NAME <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_NAME <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("TEACHER_NAME like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("TEACHER_NAME not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("TEACHER_NAME in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("TEACHER_NAME not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("TEACHER_NAME between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("TEACHER_NAME not between", value1, value2, "teacherName");
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

        public Criteria andWeekTimesIsNull() {
            addCriterion("WEEK_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andWeekTimesIsNotNull() {
            addCriterion("WEEK_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andWeekTimesEqualTo(Integer value) {
            addCriterion("WEEK_TIMES =", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotEqualTo(Integer value) {
            addCriterion("WEEK_TIMES <>", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesGreaterThan(Integer value) {
            addCriterion("WEEK_TIMES >", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEEK_TIMES >=", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLessThan(Integer value) {
            addCriterion("WEEK_TIMES <", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLessThanOrEqualTo(Integer value) {
            addCriterion("WEEK_TIMES <=", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesIn(List<Integer> values) {
            addCriterion("WEEK_TIMES in", values, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotIn(List<Integer> values) {
            addCriterion("WEEK_TIMES not in", values, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesBetween(Integer value1, Integer value2) {
            addCriterion("WEEK_TIMES between", value1, value2, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("WEEK_TIMES not between", value1, value2, "weekTimes");
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