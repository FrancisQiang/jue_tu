package com.tf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreeHoleCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TreeHoleCommentExample() {
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

        public Criteria andTreeHoleCommentIdIsNull() {
            addCriterion("tree_hole_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdIsNotNull() {
            addCriterion("tree_hole_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdEqualTo(Integer value) {
            addCriterion("tree_hole_comment_id =", value, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdNotEqualTo(Integer value) {
            addCriterion("tree_hole_comment_id <>", value, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdGreaterThan(Integer value) {
            addCriterion("tree_hole_comment_id >", value, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_comment_id >=", value, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdLessThan(Integer value) {
            addCriterion("tree_hole_comment_id <", value, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_comment_id <=", value, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdIn(List<Integer> values) {
            addCriterion("tree_hole_comment_id in", values, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdNotIn(List<Integer> values) {
            addCriterion("tree_hole_comment_id not in", values, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_comment_id between", value1, value2, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_comment_id not between", value1, value2, "treeHoleCommentId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidIsNull() {
            addCriterion("tree_hole_comment_pid is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidIsNotNull() {
            addCriterion("tree_hole_comment_pid is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidEqualTo(Integer value) {
            addCriterion("tree_hole_comment_pid =", value, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidNotEqualTo(Integer value) {
            addCriterion("tree_hole_comment_pid <>", value, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidGreaterThan(Integer value) {
            addCriterion("tree_hole_comment_pid >", value, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_comment_pid >=", value, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidLessThan(Integer value) {
            addCriterion("tree_hole_comment_pid <", value, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidLessThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_comment_pid <=", value, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidIn(List<Integer> values) {
            addCriterion("tree_hole_comment_pid in", values, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidNotIn(List<Integer> values) {
            addCriterion("tree_hole_comment_pid not in", values, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_comment_pid between", value1, value2, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentPidNotBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_comment_pid not between", value1, value2, "treeHoleCommentPid");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdIsNull() {
            addCriterion("tree_hole_comment_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdIsNotNull() {
            addCriterion("tree_hole_comment_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdEqualTo(Integer value) {
            addCriterion("tree_hole_comment_user_id =", value, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdNotEqualTo(Integer value) {
            addCriterion("tree_hole_comment_user_id <>", value, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdGreaterThan(Integer value) {
            addCriterion("tree_hole_comment_user_id >", value, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_comment_user_id >=", value, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdLessThan(Integer value) {
            addCriterion("tree_hole_comment_user_id <", value, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_comment_user_id <=", value, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdIn(List<Integer> values) {
            addCriterion("tree_hole_comment_user_id in", values, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdNotIn(List<Integer> values) {
            addCriterion("tree_hole_comment_user_id not in", values, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_comment_user_id between", value1, value2, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_comment_user_id not between", value1, value2, "treeHoleCommentUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeIsNull() {
            addCriterion("tree_hole_comment_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeIsNotNull() {
            addCriterion("tree_hole_comment_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeEqualTo(Date value) {
            addCriterion("tree_hole_comment_create_time =", value, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeNotEqualTo(Date value) {
            addCriterion("tree_hole_comment_create_time <>", value, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeGreaterThan(Date value) {
            addCriterion("tree_hole_comment_create_time >", value, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tree_hole_comment_create_time >=", value, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeLessThan(Date value) {
            addCriterion("tree_hole_comment_create_time <", value, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("tree_hole_comment_create_time <=", value, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeIn(List<Date> values) {
            addCriterion("tree_hole_comment_create_time in", values, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeNotIn(List<Date> values) {
            addCriterion("tree_hole_comment_create_time not in", values, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeBetween(Date value1, Date value2) {
            addCriterion("tree_hole_comment_create_time between", value1, value2, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCommentCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("tree_hole_comment_create_time not between", value1, value2, "treeHoleCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdIsNull() {
            addCriterion("tree_hole_id is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdIsNotNull() {
            addCriterion("tree_hole_id is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdEqualTo(Integer value) {
            addCriterion("tree_hole_id =", value, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdNotEqualTo(Integer value) {
            addCriterion("tree_hole_id <>", value, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdGreaterThan(Integer value) {
            addCriterion("tree_hole_id >", value, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_id >=", value, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdLessThan(Integer value) {
            addCriterion("tree_hole_id <", value, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_id <=", value, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdIn(List<Integer> values) {
            addCriterion("tree_hole_id in", values, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdNotIn(List<Integer> values) {
            addCriterion("tree_hole_id not in", values, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_id between", value1, value2, "treeHoleId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_id not between", value1, value2, "treeHoleId");
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