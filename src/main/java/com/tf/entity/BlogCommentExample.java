package com.tf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogCommentExample() {
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

        public Criteria andBlogCommentIdIsNull() {
            addCriterion("blog_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdIsNotNull() {
            addCriterion("blog_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdEqualTo(Integer value) {
            addCriterion("blog_comment_id =", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdNotEqualTo(Integer value) {
            addCriterion("blog_comment_id <>", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdGreaterThan(Integer value) {
            addCriterion("blog_comment_id >", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_comment_id >=", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdLessThan(Integer value) {
            addCriterion("blog_comment_id <", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_comment_id <=", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdIn(List<Integer> values) {
            addCriterion("blog_comment_id in", values, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdNotIn(List<Integer> values) {
            addCriterion("blog_comment_id not in", values, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_comment_id between", value1, value2, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_comment_id not between", value1, value2, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidIsNull() {
            addCriterion("blog_comment_pid is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidIsNotNull() {
            addCriterion("blog_comment_pid is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidEqualTo(Integer value) {
            addCriterion("blog_comment_pid =", value, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidNotEqualTo(Integer value) {
            addCriterion("blog_comment_pid <>", value, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidGreaterThan(Integer value) {
            addCriterion("blog_comment_pid >", value, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_comment_pid >=", value, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidLessThan(Integer value) {
            addCriterion("blog_comment_pid <", value, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidLessThanOrEqualTo(Integer value) {
            addCriterion("blog_comment_pid <=", value, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidIn(List<Integer> values) {
            addCriterion("blog_comment_pid in", values, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidNotIn(List<Integer> values) {
            addCriterion("blog_comment_pid not in", values, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidBetween(Integer value1, Integer value2) {
            addCriterion("blog_comment_pid between", value1, value2, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogCommentPidNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_comment_pid not between", value1, value2, "blogCommentPid");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIsNull() {
            addCriterion("user_avatar is null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIsNotNull() {
            addCriterion("user_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarEqualTo(String value) {
            addCriterion("user_avatar =", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotEqualTo(String value) {
            addCriterion("user_avatar <>", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarGreaterThan(String value) {
            addCriterion("user_avatar >", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("user_avatar >=", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLessThan(String value) {
            addCriterion("user_avatar <", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLessThanOrEqualTo(String value) {
            addCriterion("user_avatar <=", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLike(String value) {
            addCriterion("user_avatar like", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotLike(String value) {
            addCriterion("user_avatar not like", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIn(List<String> values) {
            addCriterion("user_avatar in", values, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotIn(List<String> values) {
            addCriterion("user_avatar not in", values, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarBetween(String value1, String value2) {
            addCriterion("user_avatar between", value1, value2, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotBetween(String value1, String value2) {
            addCriterion("user_avatar not between", value1, value2, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeIsNull() {
            addCriterion("blog_comment_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeIsNotNull() {
            addCriterion("blog_comment_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeEqualTo(Date value) {
            addCriterion("blog_comment_create_time =", value, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeNotEqualTo(Date value) {
            addCriterion("blog_comment_create_time <>", value, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeGreaterThan(Date value) {
            addCriterion("blog_comment_create_time >", value, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_comment_create_time >=", value, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeLessThan(Date value) {
            addCriterion("blog_comment_create_time <", value, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_comment_create_time <=", value, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeIn(List<Date> values) {
            addCriterion("blog_comment_create_time in", values, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeNotIn(List<Date> values) {
            addCriterion("blog_comment_create_time not in", values, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeBetween(Date value1, Date value2) {
            addCriterion("blog_comment_create_time between", value1, value2, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_comment_create_time not between", value1, value2, "blogCommentCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagIsNull() {
            addCriterion("blog_comment_delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagIsNotNull() {
            addCriterion("blog_comment_delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagEqualTo(Boolean value) {
            addCriterion("blog_comment_delete_flag =", value, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagNotEqualTo(Boolean value) {
            addCriterion("blog_comment_delete_flag <>", value, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagGreaterThan(Boolean value) {
            addCriterion("blog_comment_delete_flag >", value, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("blog_comment_delete_flag >=", value, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagLessThan(Boolean value) {
            addCriterion("blog_comment_delete_flag <", value, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("blog_comment_delete_flag <=", value, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagIn(List<Boolean> values) {
            addCriterion("blog_comment_delete_flag in", values, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagNotIn(List<Boolean> values) {
            addCriterion("blog_comment_delete_flag not in", values, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("blog_comment_delete_flag between", value1, value2, "blogCommentDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andBlogCommentDeleteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("blog_comment_delete_flag not between", value1, value2, "blogCommentDeleteFlag");
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