package com.fireway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentsExample() {
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andReplyTimeIsNull() {
            addCriterion("REPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("REPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("REPLY_TIME =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("REPLY_TIME <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("REPLY_TIME >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REPLY_TIME >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("REPLY_TIME <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("REPLY_TIME <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("REPLY_TIME in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("REPLY_TIME not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("REPLY_TIME between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("REPLY_TIME not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyManIsNull() {
            addCriterion("REPLY_MAN is null");
            return (Criteria) this;
        }

        public Criteria andReplyManIsNotNull() {
            addCriterion("REPLY_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andReplyManEqualTo(String value) {
            addCriterion("REPLY_MAN =", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManNotEqualTo(String value) {
            addCriterion("REPLY_MAN <>", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManGreaterThan(String value) {
            addCriterion("REPLY_MAN >", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManGreaterThanOrEqualTo(String value) {
            addCriterion("REPLY_MAN >=", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManLessThan(String value) {
            addCriterion("REPLY_MAN <", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManLessThanOrEqualTo(String value) {
            addCriterion("REPLY_MAN <=", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManLike(String value) {
            addCriterion("REPLY_MAN like", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManNotLike(String value) {
            addCriterion("REPLY_MAN not like", value, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManIn(List<String> values) {
            addCriterion("REPLY_MAN in", values, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManNotIn(List<String> values) {
            addCriterion("REPLY_MAN not in", values, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManBetween(String value1, String value2) {
            addCriterion("REPLY_MAN between", value1, value2, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManNotBetween(String value1, String value2) {
            addCriterion("REPLY_MAN not between", value1, value2, "replyMan");
            return (Criteria) this;
        }

        public Criteria andReplyManNumIsNull() {
            addCriterion("REPLY_MAN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andReplyManNumIsNotNull() {
            addCriterion("REPLY_MAN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andReplyManNumEqualTo(Integer value) {
            addCriterion("REPLY_MAN_NUM =", value, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumNotEqualTo(Integer value) {
            addCriterion("REPLY_MAN_NUM <>", value, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumGreaterThan(Integer value) {
            addCriterion("REPLY_MAN_NUM >", value, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPLY_MAN_NUM >=", value, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumLessThan(Integer value) {
            addCriterion("REPLY_MAN_NUM <", value, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumLessThanOrEqualTo(Integer value) {
            addCriterion("REPLY_MAN_NUM <=", value, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumIn(List<Integer> values) {
            addCriterion("REPLY_MAN_NUM in", values, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumNotIn(List<Integer> values) {
            addCriterion("REPLY_MAN_NUM not in", values, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumBetween(Integer value1, Integer value2) {
            addCriterion("REPLY_MAN_NUM between", value1, value2, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManNumNotBetween(Integer value1, Integer value2) {
            addCriterion("REPLY_MAN_NUM not between", value1, value2, "replyManNum");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileIsNull() {
            addCriterion("REPLY_MAN_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileIsNotNull() {
            addCriterion("REPLY_MAN_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileEqualTo(String value) {
            addCriterion("REPLY_MAN_MOBILE =", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileNotEqualTo(String value) {
            addCriterion("REPLY_MAN_MOBILE <>", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileGreaterThan(String value) {
            addCriterion("REPLY_MAN_MOBILE >", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileGreaterThanOrEqualTo(String value) {
            addCriterion("REPLY_MAN_MOBILE >=", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileLessThan(String value) {
            addCriterion("REPLY_MAN_MOBILE <", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileLessThanOrEqualTo(String value) {
            addCriterion("REPLY_MAN_MOBILE <=", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileLike(String value) {
            addCriterion("REPLY_MAN_MOBILE like", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileNotLike(String value) {
            addCriterion("REPLY_MAN_MOBILE not like", value, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileIn(List<String> values) {
            addCriterion("REPLY_MAN_MOBILE in", values, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileNotIn(List<String> values) {
            addCriterion("REPLY_MAN_MOBILE not in", values, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileBetween(String value1, String value2) {
            addCriterion("REPLY_MAN_MOBILE between", value1, value2, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andReplyManMobileNotBetween(String value1, String value2) {
            addCriterion("REPLY_MAN_MOBILE not between", value1, value2, "replyManMobile");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIsNull() {
            addCriterion("OPINION_ID is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIsNotNull() {
            addCriterion("OPINION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionIdEqualTo(Integer value) {
            addCriterion("OPINION_ID =", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotEqualTo(Integer value) {
            addCriterion("OPINION_ID <>", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdGreaterThan(Integer value) {
            addCriterion("OPINION_ID >", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPINION_ID >=", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLessThan(Integer value) {
            addCriterion("OPINION_ID <", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLessThanOrEqualTo(Integer value) {
            addCriterion("OPINION_ID <=", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIn(List<Integer> values) {
            addCriterion("OPINION_ID in", values, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotIn(List<Integer> values) {
            addCriterion("OPINION_ID not in", values, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdBetween(Integer value1, Integer value2) {
            addCriterion("OPINION_ID between", value1, value2, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OPINION_ID not between", value1, value2, "opinionId");
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