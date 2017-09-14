package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class SchoolMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SchoolMessageExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("CONTEXT =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("CONTEXT <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("CONTEXT >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("CONTEXT >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("CONTEXT <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("CONTEXT <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("CONTEXT like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("CONTEXT not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("CONTEXT in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("CONTEXT not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("CONTEXT between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("CONTEXT not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("SEND_TIME like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("SEND_TIME not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("AUTHOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("AUTHOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(String value) {
            addCriterion("AUTHOR_ID =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(String value) {
            addCriterion("AUTHOR_ID <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(String value) {
            addCriterion("AUTHOR_ID >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHOR_ID >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(String value) {
            addCriterion("AUTHOR_ID <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(String value) {
            addCriterion("AUTHOR_ID <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLike(String value) {
            addCriterion("AUTHOR_ID like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotLike(String value) {
            addCriterion("AUTHOR_ID not like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<String> values) {
            addCriterion("AUTHOR_ID in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<String> values) {
            addCriterion("AUTHOR_ID not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(String value1, String value2) {
            addCriterion("AUTHOR_ID between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(String value1, String value2) {
            addCriterion("AUTHOR_ID not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("AUTHOR =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("AUTHOR <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("AUTHOR >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHOR >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("AUTHOR <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("AUTHOR <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("AUTHOR like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("AUTHOR not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("AUTHOR in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("AUTHOR not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("AUTHOR between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("AUTHOR not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNumIsNull() {
            addCriterion("AUTHOR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNumIsNotNull() {
            addCriterion("AUTHOR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNumEqualTo(String value) {
            addCriterion("AUTHOR_NUM =", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotEqualTo(String value) {
            addCriterion("AUTHOR_NUM <>", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumGreaterThan(String value) {
            addCriterion("AUTHOR_NUM >", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHOR_NUM >=", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumLessThan(String value) {
            addCriterion("AUTHOR_NUM <", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumLessThanOrEqualTo(String value) {
            addCriterion("AUTHOR_NUM <=", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumLike(String value) {
            addCriterion("AUTHOR_NUM like", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotLike(String value) {
            addCriterion("AUTHOR_NUM not like", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumIn(List<String> values) {
            addCriterion("AUTHOR_NUM in", values, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotIn(List<String> values) {
            addCriterion("AUTHOR_NUM not in", values, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumBetween(String value1, String value2) {
            addCriterion("AUTHOR_NUM between", value1, value2, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotBetween(String value1, String value2) {
            addCriterion("AUTHOR_NUM not between", value1, value2, "authorNum");
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

        public Criteria andValidTimeIsNull() {
            addCriterion("VALID_TIME is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("VALID_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(String value) {
            addCriterion("VALID_TIME =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(String value) {
            addCriterion("VALID_TIME <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(String value) {
            addCriterion("VALID_TIME >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(String value) {
            addCriterion("VALID_TIME >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(String value) {
            addCriterion("VALID_TIME <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(String value) {
            addCriterion("VALID_TIME <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLike(String value) {
            addCriterion("VALID_TIME like", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotLike(String value) {
            addCriterion("VALID_TIME not like", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<String> values) {
            addCriterion("VALID_TIME in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<String> values) {
            addCriterion("VALID_TIME not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(String value1, String value2) {
            addCriterion("VALID_TIME between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(String value1, String value2) {
            addCriterion("VALID_TIME not between", value1, value2, "validTime");
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

        public Criteria andSendStatusIsNull() {
            addCriterion("SEND_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("SEND_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            addCriterion("SEND_STATUS =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            addCriterion("SEND_STATUS <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            addCriterion("SEND_STATUS >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_STATUS >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Integer value) {
            addCriterion("SEND_STATUS <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_STATUS <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            addCriterion("SEND_STATUS in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            addCriterion("SEND_STATUS not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            addCriterion("SEND_STATUS between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_STATUS not between", value1, value2, "sendStatus");
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