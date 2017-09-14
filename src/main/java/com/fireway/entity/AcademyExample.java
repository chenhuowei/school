package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class AcademyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AcademyExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
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

        public Criteria andOfficTelIsNull() {
            addCriterion("OFFIC_TEL is null");
            return (Criteria) this;
        }

        public Criteria andOfficTelIsNotNull() {
            addCriterion("OFFIC_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andOfficTelEqualTo(String value) {
            addCriterion("OFFIC_TEL =", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelNotEqualTo(String value) {
            addCriterion("OFFIC_TEL <>", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelGreaterThan(String value) {
            addCriterion("OFFIC_TEL >", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelGreaterThanOrEqualTo(String value) {
            addCriterion("OFFIC_TEL >=", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelLessThan(String value) {
            addCriterion("OFFIC_TEL <", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelLessThanOrEqualTo(String value) {
            addCriterion("OFFIC_TEL <=", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelLike(String value) {
            addCriterion("OFFIC_TEL like", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelNotLike(String value) {
            addCriterion("OFFIC_TEL not like", value, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelIn(List<String> values) {
            addCriterion("OFFIC_TEL in", values, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelNotIn(List<String> values) {
            addCriterion("OFFIC_TEL not in", values, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelBetween(String value1, String value2) {
            addCriterion("OFFIC_TEL between", value1, value2, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficTelNotBetween(String value1, String value2) {
            addCriterion("OFFIC_TEL not between", value1, value2, "officTel");
            return (Criteria) this;
        }

        public Criteria andOfficAddressIsNull() {
            addCriterion("OFFIC_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andOfficAddressIsNotNull() {
            addCriterion("OFFIC_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andOfficAddressEqualTo(String value) {
            addCriterion("OFFIC_ADDRESS =", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressNotEqualTo(String value) {
            addCriterion("OFFIC_ADDRESS <>", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressGreaterThan(String value) {
            addCriterion("OFFIC_ADDRESS >", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressGreaterThanOrEqualTo(String value) {
            addCriterion("OFFIC_ADDRESS >=", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressLessThan(String value) {
            addCriterion("OFFIC_ADDRESS <", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressLessThanOrEqualTo(String value) {
            addCriterion("OFFIC_ADDRESS <=", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressLike(String value) {
            addCriterion("OFFIC_ADDRESS like", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressNotLike(String value) {
            addCriterion("OFFIC_ADDRESS not like", value, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressIn(List<String> values) {
            addCriterion("OFFIC_ADDRESS in", values, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressNotIn(List<String> values) {
            addCriterion("OFFIC_ADDRESS not in", values, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressBetween(String value1, String value2) {
            addCriterion("OFFIC_ADDRESS between", value1, value2, "officAddress");
            return (Criteria) this;
        }

        public Criteria andOfficAddressNotBetween(String value1, String value2) {
            addCriterion("OFFIC_ADDRESS not between", value1, value2, "officAddress");
            return (Criteria) this;
        }

        public Criteria andManAmountIsNull() {
            addCriterion("MAN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andManAmountIsNotNull() {
            addCriterion("MAN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andManAmountEqualTo(Integer value) {
            addCriterion("MAN_AMOUNT =", value, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountNotEqualTo(Integer value) {
            addCriterion("MAN_AMOUNT <>", value, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountGreaterThan(Integer value) {
            addCriterion("MAN_AMOUNT >", value, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAN_AMOUNT >=", value, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountLessThan(Integer value) {
            addCriterion("MAN_AMOUNT <", value, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountLessThanOrEqualTo(Integer value) {
            addCriterion("MAN_AMOUNT <=", value, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountIn(List<Integer> values) {
            addCriterion("MAN_AMOUNT in", values, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountNotIn(List<Integer> values) {
            addCriterion("MAN_AMOUNT not in", values, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountBetween(Integer value1, Integer value2) {
            addCriterion("MAN_AMOUNT between", value1, value2, "manAmount");
            return (Criteria) this;
        }

        public Criteria andManAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("MAN_AMOUNT not between", value1, value2, "manAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountIsNull() {
            addCriterion("STUDENT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andStudentAmountIsNotNull() {
            addCriterion("STUDENT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andStudentAmountEqualTo(Integer value) {
            addCriterion("STUDENT_AMOUNT =", value, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountNotEqualTo(Integer value) {
            addCriterion("STUDENT_AMOUNT <>", value, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountGreaterThan(Integer value) {
            addCriterion("STUDENT_AMOUNT >", value, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("STUDENT_AMOUNT >=", value, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountLessThan(Integer value) {
            addCriterion("STUDENT_AMOUNT <", value, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountLessThanOrEqualTo(Integer value) {
            addCriterion("STUDENT_AMOUNT <=", value, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountIn(List<Integer> values) {
            addCriterion("STUDENT_AMOUNT in", values, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountNotIn(List<Integer> values) {
            addCriterion("STUDENT_AMOUNT not in", values, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountBetween(Integer value1, Integer value2) {
            addCriterion("STUDENT_AMOUNT between", value1, value2, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andStudentAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("STUDENT_AMOUNT not between", value1, value2, "studentAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountIsNull() {
            addCriterion("TEACHER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountIsNotNull() {
            addCriterion("TEACHER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountEqualTo(Integer value) {
            addCriterion("TEACHER_AMOUNT =", value, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountNotEqualTo(Integer value) {
            addCriterion("TEACHER_AMOUNT <>", value, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountGreaterThan(Integer value) {
            addCriterion("TEACHER_AMOUNT >", value, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TEACHER_AMOUNT >=", value, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountLessThan(Integer value) {
            addCriterion("TEACHER_AMOUNT <", value, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountLessThanOrEqualTo(Integer value) {
            addCriterion("TEACHER_AMOUNT <=", value, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountIn(List<Integer> values) {
            addCriterion("TEACHER_AMOUNT in", values, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountNotIn(List<Integer> values) {
            addCriterion("TEACHER_AMOUNT not in", values, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountBetween(Integer value1, Integer value2) {
            addCriterion("TEACHER_AMOUNT between", value1, value2, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andTeacherAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("TEACHER_AMOUNT not between", value1, value2, "teacherAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountIsNull() {
            addCriterion("CLASS_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andClassAmountIsNotNull() {
            addCriterion("CLASS_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andClassAmountEqualTo(Integer value) {
            addCriterion("CLASS_AMOUNT =", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountNotEqualTo(Integer value) {
            addCriterion("CLASS_AMOUNT <>", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountGreaterThan(Integer value) {
            addCriterion("CLASS_AMOUNT >", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLASS_AMOUNT >=", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountLessThan(Integer value) {
            addCriterion("CLASS_AMOUNT <", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountLessThanOrEqualTo(Integer value) {
            addCriterion("CLASS_AMOUNT <=", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountLike(Integer value) {
            addCriterion("CLASS_AMOUNT like", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountNotLike(Integer value) {
            addCriterion("CLASS_AMOUNT not like", value, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountIn(List<Integer> values) {
            addCriterion("CLASS_AMOUNT in", values, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountNotIn(List<Integer> values) {
            addCriterion("CLASS_AMOUNT not in", values, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountBetween(Integer value1, Integer value2) {
            addCriterion("CLASS_AMOUNT between", value1, value2, "classAmount");
            return (Criteria) this;
        }

        public Criteria andClassAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("CLASS_AMOUNT not between", value1, value2, "classAmount");
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