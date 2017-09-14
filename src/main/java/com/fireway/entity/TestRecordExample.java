package com.fireway.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TestRecordExample() {
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

        public Criteria andUdpateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeEqualTo(String value) {
            addCriterion("UPDATE_TIME =", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotEqualTo(String value) {
            addCriterion("UPDATE_TIME <>", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeGreaterThan(String value) {
            addCriterion("UPDATE_TIME >", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME >=", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeLessThan(String value) {
            addCriterion("UPDATE_TIME <", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME <=", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeLike(String value) {
            addCriterion("UPDATE_TIME like", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotLike(String value) {
            addCriterion("UPDATE_TIME not like", value, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeIn(List<String> values) {
            addCriterion("UPDATE_TIME in", values, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotIn(List<String> values) {
            addCriterion("UPDATE_TIME not in", values, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "udpateTime");
            return (Criteria) this;
        }

        public Criteria andUdpateTimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "udpateTime");
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

        public Criteria andTestTimeIsNull() {
            addCriterion("TEST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTestTimeIsNotNull() {
            addCriterion("TEST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTestTimeEqualTo(String value) {
            addCriterion("TEST_TIME =", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotEqualTo(String value) {
            addCriterion("TEST_TIME <>", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeGreaterThan(String value) {
            addCriterion("TEST_TIME >", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_TIME >=", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLessThan(String value) {
            addCriterion("TEST_TIME <", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLessThanOrEqualTo(String value) {
            addCriterion("TEST_TIME <=", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLike(String value) {
            addCriterion("TEST_TIME like", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotLike(String value) {
            addCriterion("TEST_TIME not like", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeIn(List<String> values) {
            addCriterion("TEST_TIME in", values, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotIn(List<String> values) {
            addCriterion("TEST_TIME not in", values, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeBetween(String value1, String value2) {
            addCriterion("TEST_TIME between", value1, value2, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotBetween(String value1, String value2) {
            addCriterion("TEST_TIME not between", value1, value2, "testTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeIsNull() {
            addCriterion("REGIS_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeIsNotNull() {
            addCriterion("REGIS_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeEqualTo(String value) {
            addCriterion("REGIS_START_TIME =", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeNotEqualTo(String value) {
            addCriterion("REGIS_START_TIME <>", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeGreaterThan(String value) {
            addCriterion("REGIS_START_TIME >", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REGIS_START_TIME >=", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeLessThan(String value) {
            addCriterion("REGIS_START_TIME <", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeLessThanOrEqualTo(String value) {
            addCriterion("REGIS_START_TIME <=", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeLike(String value) {
            addCriterion("REGIS_START_TIME like", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeNotLike(String value) {
            addCriterion("REGIS_START_TIME not like", value, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeIn(List<String> values) {
            addCriterion("REGIS_START_TIME in", values, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeNotIn(List<String> values) {
            addCriterion("REGIS_START_TIME not in", values, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeBetween(String value1, String value2) {
            addCriterion("REGIS_START_TIME between", value1, value2, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisStartTimeNotBetween(String value1, String value2) {
            addCriterion("REGIS_START_TIME not between", value1, value2, "regisStartTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeIsNull() {
            addCriterion("REGIS_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeIsNotNull() {
            addCriterion("REGIS_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeEqualTo(String value) {
            addCriterion("REGIS_END_TIME =", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeNotEqualTo(String value) {
            addCriterion("REGIS_END_TIME <>", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeGreaterThan(String value) {
            addCriterion("REGIS_END_TIME >", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REGIS_END_TIME >=", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeLessThan(String value) {
            addCriterion("REGIS_END_TIME <", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeLessThanOrEqualTo(String value) {
            addCriterion("REGIS_END_TIME <=", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeLike(String value) {
            addCriterion("REGIS_END_TIME like", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeNotLike(String value) {
            addCriterion("REGIS_END_TIME not like", value, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeIn(List<String> values) {
            addCriterion("REGIS_END_TIME in", values, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeNotIn(List<String> values) {
            addCriterion("REGIS_END_TIME not in", values, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeBetween(String value1, String value2) {
            addCriterion("REGIS_END_TIME between", value1, value2, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andRegisEndTimeNotBetween(String value1, String value2) {
            addCriterion("REGIS_END_TIME not between", value1, value2, "regisEndTime");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY not between", value1, value2, "money");
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