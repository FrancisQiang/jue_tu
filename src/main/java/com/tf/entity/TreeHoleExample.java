package com.tf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreeHoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TreeHoleExample() {
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

        public Criteria andTreeHoleUserIdIsNull() {
            addCriterion("tree_hole_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdIsNotNull() {
            addCriterion("tree_hole_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdEqualTo(Integer value) {
            addCriterion("tree_hole_user_id =", value, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdNotEqualTo(Integer value) {
            addCriterion("tree_hole_user_id <>", value, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdGreaterThan(Integer value) {
            addCriterion("tree_hole_user_id >", value, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_user_id >=", value, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdLessThan(Integer value) {
            addCriterion("tree_hole_user_id <", value, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("tree_hole_user_id <=", value, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdIn(List<Integer> values) {
            addCriterion("tree_hole_user_id in", values, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdNotIn(List<Integer> values) {
            addCriterion("tree_hole_user_id not in", values, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_user_id between", value1, value2, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tree_hole_user_id not between", value1, value2, "treeHoleUserId");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeIsNull() {
            addCriterion("tree_hole_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeIsNotNull() {
            addCriterion("tree_hole_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeEqualTo(Date value) {
            addCriterion("tree_hole_create_time =", value, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeNotEqualTo(Date value) {
            addCriterion("tree_hole_create_time <>", value, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeGreaterThan(Date value) {
            addCriterion("tree_hole_create_time >", value, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tree_hole_create_time >=", value, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeLessThan(Date value) {
            addCriterion("tree_hole_create_time <", value, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("tree_hole_create_time <=", value, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeIn(List<Date> values) {
            addCriterion("tree_hole_create_time in", values, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeNotIn(List<Date> values) {
            addCriterion("tree_hole_create_time not in", values, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeBetween(Date value1, Date value2) {
            addCriterion("tree_hole_create_time between", value1, value2, "treeHoleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTreeHoleCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("tree_hole_create_time not between", value1, value2, "treeHoleCreateTime");
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