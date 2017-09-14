package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ClassesExample() {
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

        public Criteria andGradeIsNull() {
            addCriterion("GRADE is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("GRADE =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("GRADE <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("GRADE >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("GRADE >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("GRADE <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("GRADE <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("GRADE like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("GRADE not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("GRADE in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("GRADE not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("GRADE between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("GRADE not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("NUMBER =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("NUMBER <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("NUMBER >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("NUMBER >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("NUMBER <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("NUMBER <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("NUMBER like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("NUMBER not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("NUMBER in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("NUMBER not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("NUMBER between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("NUMBER not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("MAJOR =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("MAJOR <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("MAJOR >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("MAJOR <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("MAJOR <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("MAJOR like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("MAJOR not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("MAJOR in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("MAJOR not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("MAJOR between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("MAJOR not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeIsNull() {
            addCriterion("ACADEMIC_DEGREE is null");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeIsNotNull() {
            addCriterion("ACADEMIC_DEGREE is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeEqualTo(String value) {
            addCriterion("ACADEMIC_DEGREE =", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeNotEqualTo(String value) {
            addCriterion("ACADEMIC_DEGREE <>", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeGreaterThan(String value) {
            addCriterion("ACADEMIC_DEGREE >", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("ACADEMIC_DEGREE >=", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeLessThan(String value) {
            addCriterion("ACADEMIC_DEGREE <", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeLessThanOrEqualTo(String value) {
            addCriterion("ACADEMIC_DEGREE <=", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeLike(String value) {
            addCriterion("ACADEMIC_DEGREE like", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeNotLike(String value) {
            addCriterion("ACADEMIC_DEGREE not like", value, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeIn(List<String> values) {
            addCriterion("ACADEMIC_DEGREE in", values, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeNotIn(List<String> values) {
            addCriterion("ACADEMIC_DEGREE not in", values, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeBetween(String value1, String value2) {
            addCriterion("ACADEMIC_DEGREE between", value1, value2, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicDegreeNotBetween(String value1, String value2) {
            addCriterion("ACADEMIC_DEGREE not between", value1, value2, "academicDegree");
            return (Criteria) this;
        }

        public Criteria andAcademicYearIsNull() {
            addCriterion("ACADEMIC_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andAcademicYearIsNotNull() {
            addCriterion("ACADEMIC_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicYearEqualTo(Integer value) {
            addCriterion("ACADEMIC_YEAR =", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotEqualTo(Integer value) {
            addCriterion("ACADEMIC_YEAR <>", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearGreaterThan(Integer value) {
            addCriterion("ACADEMIC_YEAR >", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACADEMIC_YEAR >=", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearLessThan(Integer value) {
            addCriterion("ACADEMIC_YEAR <", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearLessThanOrEqualTo(Integer value) {
            addCriterion("ACADEMIC_YEAR <=", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearIn(List<Integer> values) {
            addCriterion("ACADEMIC_YEAR in", values, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotIn(List<Integer> values) {
            addCriterion("ACADEMIC_YEAR not in", values, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearBetween(Integer value1, Integer value2) {
            addCriterion("ACADEMIC_YEAR between", value1, value2, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotBetween(Integer value1, Integer value2) {
            addCriterion("ACADEMIC_YEAR not between", value1, value2, "academicYear");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("CAPACITY is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("CAPACITY is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("CAPACITY =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("CAPACITY <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("CAPACITY >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("CAPACITY <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("CAPACITY in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("CAPACITY not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andHeadIsNull() {
            addCriterion("HEAD is null");
            return (Criteria) this;
        }

        public Criteria andHeadIsNotNull() {
            addCriterion("HEAD is not null");
            return (Criteria) this;
        }

        public Criteria andHeadEqualTo(String value) {
            addCriterion("HEAD =", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotEqualTo(String value) {
            addCriterion("HEAD <>", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThan(String value) {
            addCriterion("HEAD >", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD >=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThan(String value) {
            addCriterion("HEAD <", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThanOrEqualTo(String value) {
            addCriterion("HEAD <=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLike(String value) {
            addCriterion("HEAD like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotLike(String value) {
            addCriterion("HEAD not like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadIn(List<String> values) {
            addCriterion("HEAD in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotIn(List<String> values) {
            addCriterion("HEAD not in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadBetween(String value1, String value2) {
            addCriterion("HEAD between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotBetween(String value1, String value2) {
            addCriterion("HEAD not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNumIsNull() {
            addCriterion("HEAD_NUM is null");
            return (Criteria) this;
        }

        public Criteria andHeadNumIsNotNull() {
            addCriterion("HEAD_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andHeadNumEqualTo(String value) {
            addCriterion("HEAD_NUM =", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumNotEqualTo(String value) {
            addCriterion("HEAD_NUM <>", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumGreaterThan(String value) {
            addCriterion("HEAD_NUM >", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_NUM >=", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumLessThan(String value) {
            addCriterion("HEAD_NUM <", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumLessThanOrEqualTo(String value) {
            addCriterion("HEAD_NUM <=", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumLike(String value) {
            addCriterion("HEAD_NUM like", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumNotLike(String value) {
            addCriterion("HEAD_NUM not like", value, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumIn(List<String> values) {
            addCriterion("HEAD_NUM in", values, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumNotIn(List<String> values) {
            addCriterion("HEAD_NUM not in", values, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumBetween(String value1, String value2) {
            addCriterion("HEAD_NUM between", value1, value2, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadNumNotBetween(String value1, String value2) {
            addCriterion("HEAD_NUM not between", value1, value2, "headNum");
            return (Criteria) this;
        }

        public Criteria andHeadMobileIsNull() {
            addCriterion("HEAD_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andHeadMobileIsNotNull() {
            addCriterion("HEAD_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andHeadMobileEqualTo(String value) {
            addCriterion("HEAD_MOBILE =", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileNotEqualTo(String value) {
            addCriterion("HEAD_MOBILE <>", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileGreaterThan(String value) {
            addCriterion("HEAD_MOBILE >", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_MOBILE >=", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileLessThan(String value) {
            addCriterion("HEAD_MOBILE <", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileLessThanOrEqualTo(String value) {
            addCriterion("HEAD_MOBILE <=", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileLike(String value) {
            addCriterion("HEAD_MOBILE like", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileNotLike(String value) {
            addCriterion("HEAD_MOBILE not like", value, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileIn(List<String> values) {
            addCriterion("HEAD_MOBILE in", values, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileNotIn(List<String> values) {
            addCriterion("HEAD_MOBILE not in", values, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileBetween(String value1, String value2) {
            addCriterion("HEAD_MOBILE between", value1, value2, "headMobile");
            return (Criteria) this;
        }

        public Criteria andHeadMobileNotBetween(String value1, String value2) {
            addCriterion("HEAD_MOBILE not between", value1, value2, "headMobile");
            return (Criteria) this;
        }

        public Criteria andAcademyIdIsNull() {
            addCriterion("ACADEMY_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcademyIdIsNotNull() {
            addCriterion("ACADEMY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcademyIdEqualTo(String value) {
            addCriterion("ACADEMY_ID =", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdNotEqualTo(String value) {
            addCriterion("ACADEMY_ID <>", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdGreaterThan(String value) {
            addCriterion("ACADEMY_ID >", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACADEMY_ID >=", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdLessThan(String value) {
            addCriterion("ACADEMY_ID <", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdLessThanOrEqualTo(String value) {
            addCriterion("ACADEMY_ID <=", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdLike(String value) {
            addCriterion("ACADEMY_ID like", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdNotLike(String value) {
            addCriterion("ACADEMY_ID not like", value, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdIn(List<String> values) {
            addCriterion("ACADEMY_ID in", values, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdNotIn(List<String> values) {
            addCriterion("ACADEMY_ID not in", values, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdBetween(String value1, String value2) {
            addCriterion("ACADEMY_ID between", value1, value2, "academyId");
            return (Criteria) this;
        }

        public Criteria andAcademyIdNotBetween(String value1, String value2) {
            addCriterion("ACADEMY_ID not between", value1, value2, "academyId");
            return (Criteria) this;
        }
        public Criteria andAcademyNameIsNull() {
        	addCriterion("ACADEMY_NAME is null");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameIsNotNull() {
        	addCriterion("ACADEMY_NAME is not null");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameEqualTo(String value) {
        	addCriterion("ACADEMY_NAME =", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameNotEqualTo(String value) {
        	addCriterion("ACADEMY_NAME <>", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameGreaterThan(String value) {
        	addCriterion("ACADEMY_NAME >", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameGreaterThanOrEqualTo(String value) {
        	addCriterion("ACADEMY_NAME >=", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameLessThan(String value) {
        	addCriterion("ACADEMY_NAME <", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameLessThanOrEqualTo(String value) {
        	addCriterion("ACADEMY_NAME <=", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameLike(String value) {
        	addCriterion("ACADEMY_NAME like", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameNotLike(String value) {
        	addCriterion("ACADEMY_NAME not like", value, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameIn(List<String> values) {
        	addCriterion("ACADEMY_NAME in", values, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameNotIn(List<String> values) {
        	addCriterion("ACADEMY_NAME not in", values, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameBetween(String value1, String value2) {
        	addCriterion("ACADEMY_NAME between", value1, value2, "academyName");
        	return (Criteria) this;
        }
        
        public Criteria andAcademyNameNotBetween(String value1, String value2) {
        	addCriterion("ACADEMY_NAME not between", value1, value2, "academyName");
        	return (Criteria) this;
        }

        public Criteria andSyllabusIdIsNull() {
            addCriterion("SYLLABUS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdIsNotNull() {
            addCriterion("SYLLABUS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdEqualTo(String value) {
            addCriterion("SYLLABUS_ID =", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdNotEqualTo(String value) {
            addCriterion("SYLLABUS_ID <>", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdGreaterThan(String value) {
            addCriterion("SYLLABUS_ID >", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYLLABUS_ID >=", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdLessThan(String value) {
            addCriterion("SYLLABUS_ID <", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdLessThanOrEqualTo(String value) {
            addCriterion("SYLLABUS_ID <=", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdLike(String value) {
            addCriterion("SYLLABUS_ID like", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdNotLike(String value) {
            addCriterion("SYLLABUS_ID not like", value, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdIn(List<String> values) {
            addCriterion("SYLLABUS_ID in", values, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdNotIn(List<String> values) {
            addCriterion("SYLLABUS_ID not in", values, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdBetween(String value1, String value2) {
            addCriterion("SYLLABUS_ID between", value1, value2, "syllabusId");
            return (Criteria) this;
        }

        public Criteria andSyllabusIdNotBetween(String value1, String value2) {
            addCriterion("SYLLABUS_ID not between", value1, value2, "syllabusId");
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