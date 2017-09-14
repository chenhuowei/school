package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultsStatisticalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ResultsStatisticalExample() {
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

        public Criteria andRequestCreditsIsNull() {
            addCriterion("REQUEST_CREDITS is null");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsIsNotNull() {
            addCriterion("REQUEST_CREDITS is not null");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsEqualTo(Double value) {
            addCriterion("REQUEST_CREDITS =", value, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsNotEqualTo(Double value) {
            addCriterion("REQUEST_CREDITS <>", value, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsGreaterThan(Double value) {
            addCriterion("REQUEST_CREDITS >", value, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsGreaterThanOrEqualTo(Double value) {
            addCriterion("REQUEST_CREDITS >=", value, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsLessThan(Double value) {
            addCriterion("REQUEST_CREDITS <", value, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsLessThanOrEqualTo(Double value) {
            addCriterion("REQUEST_CREDITS <=", value, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsIn(List<Double> values) {
            addCriterion("REQUEST_CREDITS in", values, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsNotIn(List<Double> values) {
            addCriterion("REQUEST_CREDITS not in", values, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsBetween(Double value1, Double value2) {
            addCriterion("REQUEST_CREDITS between", value1, value2, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestCreditsNotBetween(Double value1, Double value2) {
            addCriterion("REQUEST_CREDITS not between", value1, value2, "requestCredits");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointIsNull() {
            addCriterion("REQUEST_AVERAGE_POINT is null");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointIsNotNull() {
            addCriterion("REQUEST_AVERAGE_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointEqualTo(Double value) {
            addCriterion("REQUEST_AVERAGE_POINT =", value, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointNotEqualTo(Double value) {
            addCriterion("REQUEST_AVERAGE_POINT <>", value, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointGreaterThan(Double value) {
            addCriterion("REQUEST_AVERAGE_POINT >", value, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointGreaterThanOrEqualTo(Double value) {
            addCriterion("REQUEST_AVERAGE_POINT >=", value, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointLessThan(Double value) {
            addCriterion("REQUEST_AVERAGE_POINT <", value, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointLessThanOrEqualTo(Double value) {
            addCriterion("REQUEST_AVERAGE_POINT <=", value, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointIn(List<Double> values) {
            addCriterion("REQUEST_AVERAGE_POINT in", values, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointNotIn(List<Double> values) {
            addCriterion("REQUEST_AVERAGE_POINT not in", values, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointBetween(Double value1, Double value2) {
            addCriterion("REQUEST_AVERAGE_POINT between", value1, value2, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andRequestAveragePointNotBetween(Double value1, Double value2) {
            addCriterion("REQUEST_AVERAGE_POINT not between", value1, value2, "requestAveragePoint");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsIsNull() {
            addCriterion("TOTAL_CREADITS is null");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsIsNotNull() {
            addCriterion("TOTAL_CREADITS is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsEqualTo(Double value) {
            addCriterion("TOTAL_CREADITS =", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsNotEqualTo(Double value) {
            addCriterion("TOTAL_CREADITS <>", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsGreaterThan(Double value) {
            addCriterion("TOTAL_CREADITS >", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_CREADITS >=", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsLessThan(Double value) {
            addCriterion("TOTAL_CREADITS <", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_CREADITS <=", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsIn(List<Double> values) {
            addCriterion("TOTAL_CREADITS in", values, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsNotIn(List<Double> values) {
            addCriterion("TOTAL_CREADITS not in", values, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsBetween(Double value1, Double value2) {
            addCriterion("TOTAL_CREADITS between", value1, value2, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_CREADITS not between", value1, value2, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalPointIsNull() {
            addCriterion("TOTAL_POINT is null");
            return (Criteria) this;
        }

        public Criteria andTotalPointIsNotNull() {
            addCriterion("TOTAL_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPointEqualTo(Double value) {
            addCriterion("TOTAL_POINT =", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotEqualTo(Double value) {
            addCriterion("TOTAL_POINT <>", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointGreaterThan(Double value) {
            addCriterion("TOTAL_POINT >", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_POINT >=", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointLessThan(Double value) {
            addCriterion("TOTAL_POINT <", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_POINT <=", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointIn(List<Double> values) {
            addCriterion("TOTAL_POINT in", values, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotIn(List<Double> values) {
            addCriterion("TOTAL_POINT not in", values, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointBetween(Double value1, Double value2) {
            addCriterion("TOTAL_POINT between", value1, value2, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_POINT not between", value1, value2, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointIsNull() {
            addCriterion("AVERAGE_POINT is null");
            return (Criteria) this;
        }

        public Criteria andAveragePointIsNotNull() {
            addCriterion("AVERAGE_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePointEqualTo(Double value) {
            addCriterion("AVERAGE_POINT =", value, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointNotEqualTo(Double value) {
            addCriterion("AVERAGE_POINT <>", value, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointGreaterThan(Double value) {
            addCriterion("AVERAGE_POINT >", value, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointGreaterThanOrEqualTo(Double value) {
            addCriterion("AVERAGE_POINT >=", value, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointLessThan(Double value) {
            addCriterion("AVERAGE_POINT <", value, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointLessThanOrEqualTo(Double value) {
            addCriterion("AVERAGE_POINT <=", value, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointIn(List<Double> values) {
            addCriterion("AVERAGE_POINT in", values, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointNotIn(List<Double> values) {
            addCriterion("AVERAGE_POINT not in", values, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointBetween(Double value1, Double value2) {
            addCriterion("AVERAGE_POINT between", value1, value2, "averagePoint");
            return (Criteria) this;
        }

        public Criteria andAveragePointNotBetween(Double value1, Double value2) {
            addCriterion("AVERAGE_POINT not between", value1, value2, "averagePoint");
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