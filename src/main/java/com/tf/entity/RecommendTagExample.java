package com.tf.entity;

import java.util.ArrayList;
import java.util.List;

public class RecommendTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendTagExample() {
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

        public Criteria andRecommendTagIdIsNull() {
            addCriterion("recommend_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdIsNotNull() {
            addCriterion("recommend_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdEqualTo(Integer value) {
            addCriterion("recommend_tag_id =", value, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdNotEqualTo(Integer value) {
            addCriterion("recommend_tag_id <>", value, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdGreaterThan(Integer value) {
            addCriterion("recommend_tag_id >", value, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_tag_id >=", value, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdLessThan(Integer value) {
            addCriterion("recommend_tag_id <", value, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_tag_id <=", value, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdIn(List<Integer> values) {
            addCriterion("recommend_tag_id in", values, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdNotIn(List<Integer> values) {
            addCriterion("recommend_tag_id not in", values, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdBetween(Integer value1, Integer value2) {
            addCriterion("recommend_tag_id between", value1, value2, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_tag_id not between", value1, value2, "recommendTagId");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameIsNull() {
            addCriterion("recommend_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameIsNotNull() {
            addCriterion("recommend_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameEqualTo(String value) {
            addCriterion("recommend_tag_name =", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameNotEqualTo(String value) {
            addCriterion("recommend_tag_name <>", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameGreaterThan(String value) {
            addCriterion("recommend_tag_name >", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_tag_name >=", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameLessThan(String value) {
            addCriterion("recommend_tag_name <", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameLessThanOrEqualTo(String value) {
            addCriterion("recommend_tag_name <=", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameLike(String value) {
            addCriterion("recommend_tag_name like", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameNotLike(String value) {
            addCriterion("recommend_tag_name not like", value, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameIn(List<String> values) {
            addCriterion("recommend_tag_name in", values, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameNotIn(List<String> values) {
            addCriterion("recommend_tag_name not in", values, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameBetween(String value1, String value2) {
            addCriterion("recommend_tag_name between", value1, value2, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagNameNotBetween(String value1, String value2) {
            addCriterion("recommend_tag_name not between", value1, value2, "recommendTagName");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionIsNull() {
            addCriterion("recommend_tag_description is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionIsNotNull() {
            addCriterion("recommend_tag_description is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionEqualTo(String value) {
            addCriterion("recommend_tag_description =", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionNotEqualTo(String value) {
            addCriterion("recommend_tag_description <>", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionGreaterThan(String value) {
            addCriterion("recommend_tag_description >", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_tag_description >=", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionLessThan(String value) {
            addCriterion("recommend_tag_description <", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionLessThanOrEqualTo(String value) {
            addCriterion("recommend_tag_description <=", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionLike(String value) {
            addCriterion("recommend_tag_description like", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionNotLike(String value) {
            addCriterion("recommend_tag_description not like", value, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionIn(List<String> values) {
            addCriterion("recommend_tag_description in", values, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionNotIn(List<String> values) {
            addCriterion("recommend_tag_description not in", values, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionBetween(String value1, String value2) {
            addCriterion("recommend_tag_description between", value1, value2, "recommendTagDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTagDescriptionNotBetween(String value1, String value2) {
            addCriterion("recommend_tag_description not between", value1, value2, "recommendTagDescription");
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