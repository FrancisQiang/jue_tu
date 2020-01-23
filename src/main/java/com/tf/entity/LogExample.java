package com.tf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdIsNull() {
            addCriterion("log_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdIsNotNull() {
            addCriterion("log_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdEqualTo(Integer value) {
            addCriterion("log_admin_id =", value, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdNotEqualTo(Integer value) {
            addCriterion("log_admin_id <>", value, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdGreaterThan(Integer value) {
            addCriterion("log_admin_id >", value, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_admin_id >=", value, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdLessThan(Integer value) {
            addCriterion("log_admin_id <", value, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_admin_id <=", value, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdIn(List<Integer> values) {
            addCriterion("log_admin_id in", values, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdNotIn(List<Integer> values) {
            addCriterion("log_admin_id not in", values, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("log_admin_id between", value1, value2, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_admin_id not between", value1, value2, "logAdminId");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpIsNull() {
            addCriterion("log_operate_ip is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpIsNotNull() {
            addCriterion("log_operate_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpEqualTo(String value) {
            addCriterion("log_operate_ip =", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpNotEqualTo(String value) {
            addCriterion("log_operate_ip <>", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpGreaterThan(String value) {
            addCriterion("log_operate_ip >", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpGreaterThanOrEqualTo(String value) {
            addCriterion("log_operate_ip >=", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpLessThan(String value) {
            addCriterion("log_operate_ip <", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpLessThanOrEqualTo(String value) {
            addCriterion("log_operate_ip <=", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpLike(String value) {
            addCriterion("log_operate_ip like", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpNotLike(String value) {
            addCriterion("log_operate_ip not like", value, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpIn(List<String> values) {
            addCriterion("log_operate_ip in", values, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpNotIn(List<String> values) {
            addCriterion("log_operate_ip not in", values, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpBetween(String value1, String value2) {
            addCriterion("log_operate_ip between", value1, value2, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateIpNotBetween(String value1, String value2) {
            addCriterion("log_operate_ip not between", value1, value2, "logOperateIp");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeIsNull() {
            addCriterion("log_operate_type is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeIsNotNull() {
            addCriterion("log_operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeEqualTo(Byte value) {
            addCriterion("log_operate_type =", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeNotEqualTo(Byte value) {
            addCriterion("log_operate_type <>", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeGreaterThan(Byte value) {
            addCriterion("log_operate_type >", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("log_operate_type >=", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeLessThan(Byte value) {
            addCriterion("log_operate_type <", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("log_operate_type <=", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeIn(List<Byte> values) {
            addCriterion("log_operate_type in", values, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeNotIn(List<Byte> values) {
            addCriterion("log_operate_type not in", values, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeBetween(Byte value1, Byte value2) {
            addCriterion("log_operate_type between", value1, value2, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("log_operate_type not between", value1, value2, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtIsNull() {
            addCriterion("log_operate_at is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtIsNotNull() {
            addCriterion("log_operate_at is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtEqualTo(Date value) {
            addCriterion("log_operate_at =", value, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtNotEqualTo(Date value) {
            addCriterion("log_operate_at <>", value, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtGreaterThan(Date value) {
            addCriterion("log_operate_at >", value, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("log_operate_at >=", value, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtLessThan(Date value) {
            addCriterion("log_operate_at <", value, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtLessThanOrEqualTo(Date value) {
            addCriterion("log_operate_at <=", value, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtIn(List<Date> values) {
            addCriterion("log_operate_at in", values, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtNotIn(List<Date> values) {
            addCriterion("log_operate_at not in", values, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtBetween(Date value1, Date value2) {
            addCriterion("log_operate_at between", value1, value2, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateAtNotBetween(Date value1, Date value2) {
            addCriterion("log_operate_at not between", value1, value2, "logOperateAt");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentIsNull() {
            addCriterion("log_operate_comment is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentIsNotNull() {
            addCriterion("log_operate_comment is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentEqualTo(String value) {
            addCriterion("log_operate_comment =", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentNotEqualTo(String value) {
            addCriterion("log_operate_comment <>", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentGreaterThan(String value) {
            addCriterion("log_operate_comment >", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentGreaterThanOrEqualTo(String value) {
            addCriterion("log_operate_comment >=", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentLessThan(String value) {
            addCriterion("log_operate_comment <", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentLessThanOrEqualTo(String value) {
            addCriterion("log_operate_comment <=", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentLike(String value) {
            addCriterion("log_operate_comment like", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentNotLike(String value) {
            addCriterion("log_operate_comment not like", value, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentIn(List<String> values) {
            addCriterion("log_operate_comment in", values, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentNotIn(List<String> values) {
            addCriterion("log_operate_comment not in", values, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentBetween(String value1, String value2) {
            addCriterion("log_operate_comment between", value1, value2, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateCommentNotBetween(String value1, String value2) {
            addCriterion("log_operate_comment not between", value1, value2, "logOperateComment");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableIsNull() {
            addCriterion("log_operate_table is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableIsNotNull() {
            addCriterion("log_operate_table is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableEqualTo(String value) {
            addCriterion("log_operate_table =", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableNotEqualTo(String value) {
            addCriterion("log_operate_table <>", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableGreaterThan(String value) {
            addCriterion("log_operate_table >", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableGreaterThanOrEqualTo(String value) {
            addCriterion("log_operate_table >=", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableLessThan(String value) {
            addCriterion("log_operate_table <", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableLessThanOrEqualTo(String value) {
            addCriterion("log_operate_table <=", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableLike(String value) {
            addCriterion("log_operate_table like", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableNotLike(String value) {
            addCriterion("log_operate_table not like", value, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableIn(List<String> values) {
            addCriterion("log_operate_table in", values, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableNotIn(List<String> values) {
            addCriterion("log_operate_table not in", values, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableBetween(String value1, String value2) {
            addCriterion("log_operate_table between", value1, value2, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOperateTableNotBetween(String value1, String value2) {
            addCriterion("log_operate_table not between", value1, value2, "logOperateTable");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentIsNull() {
            addCriterion("log_opeate_content is null");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentIsNotNull() {
            addCriterion("log_opeate_content is not null");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentEqualTo(String value) {
            addCriterion("log_opeate_content =", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentNotEqualTo(String value) {
            addCriterion("log_opeate_content <>", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentGreaterThan(String value) {
            addCriterion("log_opeate_content >", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentGreaterThanOrEqualTo(String value) {
            addCriterion("log_opeate_content >=", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentLessThan(String value) {
            addCriterion("log_opeate_content <", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentLessThanOrEqualTo(String value) {
            addCriterion("log_opeate_content <=", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentLike(String value) {
            addCriterion("log_opeate_content like", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentNotLike(String value) {
            addCriterion("log_opeate_content not like", value, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentIn(List<String> values) {
            addCriterion("log_opeate_content in", values, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentNotIn(List<String> values) {
            addCriterion("log_opeate_content not in", values, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentBetween(String value1, String value2) {
            addCriterion("log_opeate_content between", value1, value2, "logOpeateContent");
            return (Criteria) this;
        }

        public Criteria andLogOpeateContentNotBetween(String value1, String value2) {
            addCriterion("log_opeate_content not between", value1, value2, "logOpeateContent");
            return (Criteria) this;
        }
    }

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