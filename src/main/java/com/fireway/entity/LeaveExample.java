package com.fireway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LeaveExample() {
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

        public Criteria andApplicantTimeIsNull() {
            addCriterion("APPLICANT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeIsNotNull() {
            addCriterion("APPLICANT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeEqualTo(Date value) {
            addCriterion("APPLICANT_TIME =", value, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeNotEqualTo(Date value) {
            addCriterion("APPLICANT_TIME <>", value, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeGreaterThan(Date value) {
            addCriterion("APPLICANT_TIME >", value, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLICANT_TIME >=", value, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeLessThan(Date value) {
            addCriterion("APPLICANT_TIME <", value, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLICANT_TIME <=", value, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeIn(List<Date> values) {
            addCriterion("APPLICANT_TIME in", values, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeNotIn(List<Date> values) {
            addCriterion("APPLICANT_TIME not in", values, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeBetween(Date value1, Date value2) {
            addCriterion("APPLICANT_TIME between", value1, value2, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLICANT_TIME not between", value1, value2, "applicantTime");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("APPLICANT is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("APPLICANT is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("APPLICANT =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("APPLICANT <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("APPLICANT >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("APPLICANT <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("APPLICANT like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("APPLICANT not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("APPLICANT in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("APPLICANT not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("APPLICANT between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("APPLICANT not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNumIsNull() {
            addCriterion("APPLICANT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andApplicantNumIsNotNull() {
            addCriterion("APPLICANT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantNumEqualTo(String value) {
            addCriterion("APPLICANT_NUM =", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumNotEqualTo(String value) {
            addCriterion("APPLICANT_NUM <>", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumGreaterThan(String value) {
            addCriterion("APPLICANT_NUM >", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT_NUM >=", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumLessThan(String value) {
            addCriterion("APPLICANT_NUM <", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT_NUM <=", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumLike(String value) {
            addCriterion("APPLICANT_NUM like", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumNotLike(String value) {
            addCriterion("APPLICANT_NUM not like", value, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumIn(List<String> values) {
            addCriterion("APPLICANT_NUM in", values, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumNotIn(List<String> values) {
            addCriterion("APPLICANT_NUM not in", values, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumBetween(String value1, String value2) {
            addCriterion("APPLICANT_NUM between", value1, value2, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andApplicantNumNotBetween(String value1, String value2) {
            addCriterion("APPLICANT_NUM not between", value1, value2, "applicantNum");
            return (Criteria) this;
        }

        public Criteria andResonIsNull() {
            addCriterion("RESON is null");
            return (Criteria) this;
        }

        public Criteria andResonIsNotNull() {
            addCriterion("RESON is not null");
            return (Criteria) this;
        }

        public Criteria andResonEqualTo(String value) {
            addCriterion("RESON =", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotEqualTo(String value) {
            addCriterion("RESON <>", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonGreaterThan(String value) {
            addCriterion("RESON >", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonGreaterThanOrEqualTo(String value) {
            addCriterion("RESON >=", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonLessThan(String value) {
            addCriterion("RESON <", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonLessThanOrEqualTo(String value) {
            addCriterion("RESON <=", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonLike(String value) {
            addCriterion("RESON like", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotLike(String value) {
            addCriterion("RESON not like", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonIn(List<String> values) {
            addCriterion("RESON in", values, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotIn(List<String> values) {
            addCriterion("RESON not in", values, "reson");
            return (Criteria) this;
        }

        public Criteria andResonBetween(String value1, String value2) {
            addCriterion("RESON between", value1, value2, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotBetween(String value1, String value2) {
            addCriterion("RESON not between", value1, value2, "reson");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("REQUEST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("REQUEST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("REQUEST_TIME =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("REQUEST_TIME <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("REQUEST_TIME >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REQUEST_TIME >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("REQUEST_TIME <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("REQUEST_TIME <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("REQUEST_TIME in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("REQUEST_TIME not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("REQUEST_TIME between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("REQUEST_TIME not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andApproverIsNull() {
            addCriterion("APPROVER is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("APPROVER is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(String value) {
            addCriterion("APPROVER =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(String value) {
            addCriterion("APPROVER <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(String value) {
            addCriterion("APPROVER >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(String value) {
            addCriterion("APPROVER <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(String value) {
            addCriterion("APPROVER <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLike(String value) {
            addCriterion("APPROVER like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotLike(String value) {
            addCriterion("APPROVER not like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<String> values) {
            addCriterion("APPROVER in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<String> values) {
            addCriterion("APPROVER not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(String value1, String value2) {
            addCriterion("APPROVER between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(String value1, String value2) {
            addCriterion("APPROVER not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNumIsNull() {
            addCriterion("APPROVER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andApproverNumIsNotNull() {
            addCriterion("APPROVER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andApproverNumEqualTo(String value) {
            addCriterion("APPROVER_NUM =", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumNotEqualTo(String value) {
            addCriterion("APPROVER_NUM <>", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumGreaterThan(String value) {
            addCriterion("APPROVER_NUM >", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER_NUM >=", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumLessThan(String value) {
            addCriterion("APPROVER_NUM <", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumLessThanOrEqualTo(String value) {
            addCriterion("APPROVER_NUM <=", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumLike(String value) {
            addCriterion("APPROVER_NUM like", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumNotLike(String value) {
            addCriterion("APPROVER_NUM not like", value, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumIn(List<String> values) {
            addCriterion("APPROVER_NUM in", values, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumNotIn(List<String> values) {
            addCriterion("APPROVER_NUM not in", values, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumBetween(String value1, String value2) {
            addCriterion("APPROVER_NUM between", value1, value2, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApproverNumNotBetween(String value1, String value2) {
            addCriterion("APPROVER_NUM not between", value1, value2, "approverNum");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("APPROVAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("APPROVAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("APPROVAL_TIME =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("APPROVAL_TIME <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("APPROVAL_TIME >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPROVAL_TIME >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("APPROVAL_TIME <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPROVAL_TIME <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("APPROVAL_TIME in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("APPROVAL_TIME not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("APPROVAL_TIME between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPROVAL_TIME not between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionIsNull() {
            addCriterion("LEADER_OPINION is null");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionIsNotNull() {
            addCriterion("LEADER_OPINION is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionEqualTo(String value) {
            addCriterion("LEADER_OPINION =", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotEqualTo(String value) {
            addCriterion("LEADER_OPINION <>", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionGreaterThan(String value) {
            addCriterion("LEADER_OPINION >", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("LEADER_OPINION >=", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionLessThan(String value) {
            addCriterion("LEADER_OPINION <", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionLessThanOrEqualTo(String value) {
            addCriterion("LEADER_OPINION <=", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionLike(String value) {
            addCriterion("LEADER_OPINION like", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotLike(String value) {
            addCriterion("LEADER_OPINION not like", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionIn(List<String> values) {
            addCriterion("LEADER_OPINION in", values, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotIn(List<String> values) {
            addCriterion("LEADER_OPINION not in", values, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionBetween(String value1, String value2) {
            addCriterion("LEADER_OPINION between", value1, value2, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotBetween(String value1, String value2) {
            addCriterion("LEADER_OPINION not between", value1, value2, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkIsNull() {
            addCriterion("IS_CHECK_OK is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkIsNotNull() {
            addCriterion("IS_CHECK_OK is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkEqualTo(Boolean value) {
            addCriterion("IS_CHECK_OK =", value, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkNotEqualTo(Boolean value) {
            addCriterion("IS_CHECK_OK <>", value, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkGreaterThan(Boolean value) {
            addCriterion("IS_CHECK_OK >", value, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_CHECK_OK >=", value, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkLessThan(Boolean value) {
            addCriterion("IS_CHECK_OK <", value, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_CHECK_OK <=", value, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkIn(List<Boolean> values) {
            addCriterion("IS_CHECK_OK in", values, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkNotIn(List<Boolean> values) {
            addCriterion("IS_CHECK_OK not in", values, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CHECK_OK between", value1, value2, "isCheckOk");
            return (Criteria) this;
        }

        public Criteria andIsCheckOkNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CHECK_OK not between", value1, value2, "isCheckOk");
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