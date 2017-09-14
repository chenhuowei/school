package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public StudentTestExample() {
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

        public Criteria andTestRecordIdIsNull() {
            addCriterion("TEST_RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdIsNotNull() {
            addCriterion("TEST_RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdEqualTo(String value) {
            addCriterion("TEST_RECORD_ID =", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdNotEqualTo(String value) {
            addCriterion("TEST_RECORD_ID <>", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdGreaterThan(String value) {
            addCriterion("TEST_RECORD_ID >", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_RECORD_ID >=", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdLessThan(String value) {
            addCriterion("TEST_RECORD_ID <", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdLessThanOrEqualTo(String value) {
            addCriterion("TEST_RECORD_ID <=", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdLike(String value) {
            addCriterion("TEST_RECORD_ID like", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdNotLike(String value) {
            addCriterion("TEST_RECORD_ID not like", value, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdIn(List<String> values) {
            addCriterion("TEST_RECORD_ID in", values, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdNotIn(List<String> values) {
            addCriterion("TEST_RECORD_ID not in", values, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdBetween(String value1, String value2) {
            addCriterion("TEST_RECORD_ID between", value1, value2, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestRecordIdNotBetween(String value1, String value2) {
            addCriterion("TEST_RECORD_ID not between", value1, value2, "testRecordId");
            return (Criteria) this;
        }

        public Criteria andTestNameIsNull() {
            addCriterion("TEST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTestNameIsNotNull() {
            addCriterion("TEST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTestNameEqualTo(String value) {
            addCriterion("TEST_NAME =", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotEqualTo(String value) {
            addCriterion("TEST_NAME <>", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameGreaterThan(String value) {
            addCriterion("TEST_NAME >", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_NAME >=", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLessThan(String value) {
            addCriterion("TEST_NAME <", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLessThanOrEqualTo(String value) {
            addCriterion("TEST_NAME <=", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLike(String value) {
            addCriterion("TEST_NAME like", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotLike(String value) {
            addCriterion("TEST_NAME not like", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameIn(List<String> values) {
            addCriterion("TEST_NAME in", values, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotIn(List<String> values) {
            addCriterion("TEST_NAME not in", values, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameBetween(String value1, String value2) {
            addCriterion("TEST_NAME between", value1, value2, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotBetween(String value1, String value2) {
            addCriterion("TEST_NAME not between", value1, value2, "testName");
            return (Criteria) this;
        }

        public Criteria andTestCodeIsNull() {
            addCriterion("TEST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTestCodeIsNotNull() {
            addCriterion("TEST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTestCodeEqualTo(String value) {
            addCriterion("TEST_CODE =", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotEqualTo(String value) {
            addCriterion("TEST_CODE <>", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeGreaterThan(String value) {
            addCriterion("TEST_CODE >", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_CODE >=", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeLessThan(String value) {
            addCriterion("TEST_CODE <", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeLessThanOrEqualTo(String value) {
            addCriterion("TEST_CODE <=", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeLike(String value) {
            addCriterion("TEST_CODE like", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotLike(String value) {
            addCriterion("TEST_CODE not like", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeIn(List<String> values) {
            addCriterion("TEST_CODE in", values, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotIn(List<String> values) {
            addCriterion("TEST_CODE not in", values, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeBetween(String value1, String value2) {
            addCriterion("TEST_CODE between", value1, value2, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotBetween(String value1, String value2) {
            addCriterion("TEST_CODE not between", value1, value2, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestLocationIsNull() {
            addCriterion("TEST_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andTestLocationIsNotNull() {
            addCriterion("TEST_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andTestLocationEqualTo(String value) {
            addCriterion("TEST_LOCATION =", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationNotEqualTo(String value) {
            addCriterion("TEST_LOCATION <>", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationGreaterThan(String value) {
            addCriterion("TEST_LOCATION >", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_LOCATION >=", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationLessThan(String value) {
            addCriterion("TEST_LOCATION <", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationLessThanOrEqualTo(String value) {
            addCriterion("TEST_LOCATION <=", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationLike(String value) {
            addCriterion("TEST_LOCATION like", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationNotLike(String value) {
            addCriterion("TEST_LOCATION not like", value, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationIn(List<String> values) {
            addCriterion("TEST_LOCATION in", values, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationNotIn(List<String> values) {
            addCriterion("TEST_LOCATION not in", values, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationBetween(String value1, String value2) {
            addCriterion("TEST_LOCATION between", value1, value2, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestLocationNotBetween(String value1, String value2) {
            addCriterion("TEST_LOCATION not between", value1, value2, "testLocation");
            return (Criteria) this;
        }

        public Criteria andTestNumIsNull() {
            addCriterion("TEST_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTestNumIsNotNull() {
            addCriterion("TEST_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTestNumEqualTo(String value) {
            addCriterion("TEST_NUMBER =", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumNotEqualTo(String value) {
            addCriterion("TEST_NUMBER <>", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumGreaterThan(String value) {
            addCriterion("TEST_NUMBER >", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_NUMBER >=", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumLessThan(String value) {
            addCriterion("TEST_NUMBER <", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumLessThanOrEqualTo(String value) {
            addCriterion("TEST_NUMBER <=", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumLike(String value) {
            addCriterion("TEST_NUMBER like", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumNotLike(String value) {
            addCriterion("TEST_NUMBER not like", value, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumIn(List<String> values) {
            addCriterion("TEST_NUMBER in", values, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumNotIn(List<String> values) {
            addCriterion("TEST_NUMBER not in", values, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumBetween(String value1, String value2) {
            addCriterion("TEST_NUMBER between", value1, value2, "testNum");
            return (Criteria) this;
        }

        public Criteria andTestNumNotBetween(String value1, String value2) {
            addCriterion("TEST_NUMBER not between", value1, value2, "testNum");
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

        public Criteria andIsPassIsNull() {
            addCriterion("IS_PASS is null");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNotNull() {
            addCriterion("IS_PASS is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassEqualTo(Boolean value) {
            addCriterion("IS_PASS =", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotEqualTo(Boolean value) {
            addCriterion("IS_PASS <>", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThan(Boolean value) {
            addCriterion("IS_PASS >", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_PASS >=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThan(Boolean value) {
            addCriterion("IS_PASS <", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_PASS <=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassIn(List<Boolean> values) {
            addCriterion("IS_PASS in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotIn(List<Boolean> values) {
            addCriterion("IS_PASS not in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_PASS between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_PASS not between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPaymentIsNull() {
            addCriterion("IS_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andIsPaymentIsNotNull() {
            addCriterion("IS_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsPaymentEqualTo(Boolean value) {
            addCriterion("IS_PAYMENT =", value, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentNotEqualTo(Boolean value) {
            addCriterion("IS_PAYMENT <>", value, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentGreaterThan(Boolean value) {
            addCriterion("IS_PAYMENT >", value, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_PAYMENT >=", value, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentLessThan(Boolean value) {
            addCriterion("IS_PAYMENT <", value, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_PAYMENT <=", value, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentIn(List<Boolean> values) {
            addCriterion("IS_PAYMENT in", values, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentNotIn(List<Boolean> values) {
            addCriterion("IS_PAYMENT not in", values, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_PAYMENT between", value1, value2, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsPaymentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_PAYMENT not between", value1, value2, "isPayment");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessIsNull() {
            addCriterion("IS_REGIS_SUCCESS is null");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessIsNotNull() {
            addCriterion("IS_REGIS_SUCCESS is not null");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessEqualTo(Boolean value) {
            addCriterion("IS_REGIS_SUCCESS =", value, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessNotEqualTo(Boolean value) {
            addCriterion("IS_REGIS_SUCCESS <>", value, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessGreaterThan(Boolean value) {
            addCriterion("IS_REGIS_SUCCESS >", value, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_REGIS_SUCCESS >=", value, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessLessThan(Boolean value) {
            addCriterion("IS_REGIS_SUCCESS <", value, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_REGIS_SUCCESS <=", value, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessIn(List<Boolean> values) {
            addCriterion("IS_REGIS_SUCCESS in", values, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessNotIn(List<Boolean> values) {
            addCriterion("IS_REGIS_SUCCESS not in", values, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_REGIS_SUCCESS between", value1, value2, "isRegisSuccess");
            return (Criteria) this;
        }

        public Criteria andIsRegisSuccessNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_REGIS_SUCCESS not between", value1, value2, "isRegisSuccess");
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