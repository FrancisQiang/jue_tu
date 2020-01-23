package com.tf.entity;

import java.util.ArrayList;
import java.util.List;

public class BlogCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogCategoryExample() {
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

        public Criteria andBlogCategoryIdIsNull() {
            addCriterion("blog_category_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIsNotNull() {
            addCriterion("blog_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdEqualTo(Integer value) {
            addCriterion("blog_category_id =", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotEqualTo(Integer value) {
            addCriterion("blog_category_id <>", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdGreaterThan(Integer value) {
            addCriterion("blog_category_id >", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_category_id >=", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdLessThan(Integer value) {
            addCriterion("blog_category_id <", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_category_id <=", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIn(List<Integer> values) {
            addCriterion("blog_category_id in", values, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotIn(List<Integer> values) {
            addCriterion("blog_category_id not in", values, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_category_id between", value1, value2, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_category_id not between", value1, value2, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameIsNull() {
            addCriterion("blog_category_name is null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameIsNotNull() {
            addCriterion("blog_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameEqualTo(String value) {
            addCriterion("blog_category_name =", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotEqualTo(String value) {
            addCriterion("blog_category_name <>", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameGreaterThan(String value) {
            addCriterion("blog_category_name >", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("blog_category_name >=", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameLessThan(String value) {
            addCriterion("blog_category_name <", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("blog_category_name <=", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameLike(String value) {
            addCriterion("blog_category_name like", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotLike(String value) {
            addCriterion("blog_category_name not like", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameIn(List<String> values) {
            addCriterion("blog_category_name in", values, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotIn(List<String> values) {
            addCriterion("blog_category_name not in", values, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameBetween(String value1, String value2) {
            addCriterion("blog_category_name between", value1, value2, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotBetween(String value1, String value2) {
            addCriterion("blog_category_name not between", value1, value2, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionIsNull() {
            addCriterion("blog_category_description is null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionIsNotNull() {
            addCriterion("blog_category_description is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionEqualTo(String value) {
            addCriterion("blog_category_description =", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionNotEqualTo(String value) {
            addCriterion("blog_category_description <>", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionGreaterThan(String value) {
            addCriterion("blog_category_description >", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("blog_category_description >=", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionLessThan(String value) {
            addCriterion("blog_category_description <", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionLessThanOrEqualTo(String value) {
            addCriterion("blog_category_description <=", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionLike(String value) {
            addCriterion("blog_category_description like", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionNotLike(String value) {
            addCriterion("blog_category_description not like", value, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionIn(List<String> values) {
            addCriterion("blog_category_description in", values, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionNotIn(List<String> values) {
            addCriterion("blog_category_description not in", values, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionBetween(String value1, String value2) {
            addCriterion("blog_category_description between", value1, value2, "blogCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryDescriptionNotBetween(String value1, String value2) {
            addCriterion("blog_category_description not between", value1, value2, "blogCategoryDescription");
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