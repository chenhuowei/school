package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserExample() {
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

        public Criteria andUserNumIsNull() {
            addCriterion("U_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andUserNumIsNotNull() {
            addCriterion("U_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andUserNumEqualTo(String value) {
            addCriterion("U_NUMBER =", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotEqualTo(String value) {
            addCriterion("U_NUMBER <>", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumGreaterThan(String value) {
            addCriterion("U_NUMBER >", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumGreaterThanOrEqualTo(String value) {
            addCriterion("U_NUMBER >=", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLessThan(String value) {
            addCriterion("U_NUMBER <", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLessThanOrEqualTo(String value) {
            addCriterion("U_NUMBER <=", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLike(String value) {
            addCriterion("U_NUMBER like", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotLike(String value) {
            addCriterion("U_NUMBER not like", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumIn(List<String> values) {
            addCriterion("U_NUMBER in", values, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotIn(List<String> values) {
            addCriterion("U_NUMBER not in", values, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumBetween(String value1, String value2) {
            addCriterion("U_NUMBER between", value1, value2, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotBetween(String value1, String value2) {
            addCriterion("U_NUMBER not between", value1, value2, "userNum");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPassword2IsNull() {
            addCriterion("PASSWORD2 is null");
            return (Criteria) this;
        }

        public Criteria andPassword2IsNotNull() {
            addCriterion("PASSWORD2 is not null");
            return (Criteria) this;
        }

        public Criteria andPassword2EqualTo(String value) {
            addCriterion("PASSWORD2 =", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotEqualTo(String value) {
            addCriterion("PASSWORD2 <>", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2GreaterThan(String value) {
            addCriterion("PASSWORD2 >", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2GreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD2 >=", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2LessThan(String value) {
            addCriterion("PASSWORD2 <", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2LessThanOrEqualTo(String value) {
            addCriterion("PASSWORD2 <=", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2Like(String value) {
            addCriterion("PASSWORD2 like", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotLike(String value) {
            addCriterion("PASSWORD2 not like", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2In(List<String> values) {
            addCriterion("PASSWORD2 in", values, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotIn(List<String> values) {
            addCriterion("PASSWORD2 not in", values, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2Between(String value1, String value2) {
            addCriterion("PASSWORD2 between", value1, value2, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotBetween(String value1, String value2) {
            addCriterion("PASSWORD2 not between", value1, value2, "password2");
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

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Boolean value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Boolean value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Boolean value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Boolean value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Boolean value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Boolean> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Boolean> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Boolean value1, Boolean value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("BIRTH is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("BIRTH is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(String value) {
            addCriterion("BIRTH =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(String value) {
            addCriterion("BIRTH <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(String value) {
            addCriterion("BIRTH >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTH >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(String value) {
            addCriterion("BIRTH <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(String value) {
            addCriterion("BIRTH <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLike(String value) {
            addCriterion("BIRTH like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotLike(String value) {
            addCriterion("BIRTH not like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<String> values) {
            addCriterion("BIRTH in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<String> values) {
            addCriterion("BIRTH not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(String value1, String value2) {
            addCriterion("BIRTH between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(String value1, String value2) {
            addCriterion("BIRTH not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andHomeTelIsNull() {
            addCriterion("HOME_TEL is null");
            return (Criteria) this;
        }

        public Criteria andHomeTelIsNotNull() {
            addCriterion("HOME_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTelEqualTo(String value) {
            addCriterion("HOME_TEL =", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotEqualTo(String value) {
            addCriterion("HOME_TEL <>", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelGreaterThan(String value) {
            addCriterion("HOME_TEL >", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelGreaterThanOrEqualTo(String value) {
            addCriterion("HOME_TEL >=", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelLessThan(String value) {
            addCriterion("HOME_TEL <", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelLessThanOrEqualTo(String value) {
            addCriterion("HOME_TEL <=", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelLike(String value) {
            addCriterion("HOME_TEL like", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotLike(String value) {
            addCriterion("HOME_TEL not like", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelIn(List<String> values) {
            addCriterion("HOME_TEL in", values, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotIn(List<String> values) {
            addCriterion("HOME_TEL not in", values, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelBetween(String value1, String value2) {
            addCriterion("HOME_TEL between", value1, value2, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotBetween(String value1, String value2) {
            addCriterion("HOME_TEL not between", value1, value2, "homeTel");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("ID_CARD is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("ID_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("ID_CARD =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("ID_CARD <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("ID_CARD >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("ID_CARD <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("ID_CARD like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("ID_CARD not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("ID_CARD in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("ID_CARD not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("ID_CARD between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("ID_CARD not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNull() {
            addCriterion("JOIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNotNull() {
            addCriterion("JOIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDateEqualTo(String value) {
            addCriterion("JOIN_DATE =", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotEqualTo(String value) {
            addCriterion("JOIN_DATE <>", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThan(String value) {
            addCriterion("JOIN_DATE >", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThanOrEqualTo(String value) {
            addCriterion("JOIN_DATE >=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThan(String value) {
            addCriterion("JOIN_DATE <", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThanOrEqualTo(String value) {
            addCriterion("JOIN_DATE <=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLike(String value) {
            addCriterion("JOIN_DATE like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotLike(String value) {
            addCriterion("JOIN_DATE not like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIn(List<String> values) {
            addCriterion("JOIN_DATE in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotIn(List<String> values) {
            addCriterion("JOIN_DATE not in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateBetween(String value1, String value2) {
            addCriterion("JOIN_DATE between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotBetween(String value1, String value2) {
            addCriterion("JOIN_DATE not between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andRegisTimeIsNull() {
            addCriterion("REGIS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegisTimeIsNotNull() {
            addCriterion("REGIS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegisTimeEqualTo(String value) {
            addCriterion("REGIS_TIME =", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeNotEqualTo(String value) {
            addCriterion("REGIS_TIME <>", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeGreaterThan(String value) {
            addCriterion("REGIS_TIME >", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REGIS_TIME >=", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeLessThan(String value) {
            addCriterion("REGIS_TIME <", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeLessThanOrEqualTo(String value) {
            addCriterion("REGIS_TIME <=", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeLike(String value) {
            addCriterion("REGIS_TIME like", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeNotLike(String value) {
            addCriterion("REGIS_TIME not like", value, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeIn(List<String> values) {
            addCriterion("REGIS_TIME in", values, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeNotIn(List<String> values) {
            addCriterion("REGIS_TIME not in", values, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeBetween(String value1, String value2) {
            addCriterion("REGIS_TIME between", value1, value2, "regisTime");
            return (Criteria) this;
        }

        public Criteria andRegisTimeNotBetween(String value1, String value2) {
            addCriterion("REGIS_TIME not between", value1, value2, "regisTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(String value) {
            addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(String value) {
            addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(String value) {
            addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(String value) {
            addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLike(String value) {
            addCriterion("LAST_LOGIN_TIME like", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotLike(String value) {
            addCriterion("LAST_LOGIN_TIME not like", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<String> values) {
            addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<String> values) {
            addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("LOGIN_IP like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "loginIp");
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