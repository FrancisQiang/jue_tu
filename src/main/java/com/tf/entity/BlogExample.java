package com.tf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryIsNull() {
            addCriterion("blog_summary is null");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryIsNotNull() {
            addCriterion("blog_summary is not null");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryEqualTo(String value) {
            addCriterion("blog_summary =", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryNotEqualTo(String value) {
            addCriterion("blog_summary <>", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryGreaterThan(String value) {
            addCriterion("blog_summary >", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("blog_summary >=", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryLessThan(String value) {
            addCriterion("blog_summary <", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryLessThanOrEqualTo(String value) {
            addCriterion("blog_summary <=", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryLike(String value) {
            addCriterion("blog_summary like", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryNotLike(String value) {
            addCriterion("blog_summary not like", value, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryIn(List<String> values) {
            addCriterion("blog_summary in", values, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryNotIn(List<String> values) {
            addCriterion("blog_summary not in", values, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryBetween(String value1, String value2) {
            addCriterion("blog_summary between", value1, value2, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogSummaryNotBetween(String value1, String value2) {
            addCriterion("blog_summary not between", value1, value2, "blogSummary");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeIsNull() {
            addCriterion("blog_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeIsNotNull() {
            addCriterion("blog_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeEqualTo(Date value) {
            addCriterion("blog_create_time =", value, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeNotEqualTo(Date value) {
            addCriterion("blog_create_time <>", value, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeGreaterThan(Date value) {
            addCriterion("blog_create_time >", value, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_create_time >=", value, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeLessThan(Date value) {
            addCriterion("blog_create_time <", value, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_create_time <=", value, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeIn(List<Date> values) {
            addCriterion("blog_create_time in", values, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeNotIn(List<Date> values) {
            addCriterion("blog_create_time not in", values, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeBetween(Date value1, Date value2) {
            addCriterion("blog_create_time between", value1, value2, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_create_time not between", value1, value2, "blogCreateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeIsNull() {
            addCriterion("blog_update_time is null");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeIsNotNull() {
            addCriterion("blog_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeEqualTo(Date value) {
            addCriterion("blog_update_time =", value, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeNotEqualTo(Date value) {
            addCriterion("blog_update_time <>", value, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeGreaterThan(Date value) {
            addCriterion("blog_update_time >", value, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_update_time >=", value, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeLessThan(Date value) {
            addCriterion("blog_update_time <", value, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_update_time <=", value, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeIn(List<Date> values) {
            addCriterion("blog_update_time in", values, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeNotIn(List<Date> values) {
            addCriterion("blog_update_time not in", values, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("blog_update_time between", value1, value2, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_update_time not between", value1, value2, "blogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlogThumbIsNull() {
            addCriterion("blog_thumb is null");
            return (Criteria) this;
        }

        public Criteria andBlogThumbIsNotNull() {
            addCriterion("blog_thumb is not null");
            return (Criteria) this;
        }

        public Criteria andBlogThumbEqualTo(Integer value) {
            addCriterion("blog_thumb =", value, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbNotEqualTo(Integer value) {
            addCriterion("blog_thumb <>", value, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbGreaterThan(Integer value) {
            addCriterion("blog_thumb >", value, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_thumb >=", value, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbLessThan(Integer value) {
            addCriterion("blog_thumb <", value, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbLessThanOrEqualTo(Integer value) {
            addCriterion("blog_thumb <=", value, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbIn(List<Integer> values) {
            addCriterion("blog_thumb in", values, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbNotIn(List<Integer> values) {
            addCriterion("blog_thumb not in", values, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbBetween(Integer value1, Integer value2) {
            addCriterion("blog_thumb between", value1, value2, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogThumbNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_thumb not between", value1, value2, "blogThumb");
            return (Criteria) this;
        }

        public Criteria andBlogViewIsNull() {
            addCriterion("blog_view is null");
            return (Criteria) this;
        }

        public Criteria andBlogViewIsNotNull() {
            addCriterion("blog_view is not null");
            return (Criteria) this;
        }

        public Criteria andBlogViewEqualTo(Integer value) {
            addCriterion("blog_view =", value, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewNotEqualTo(Integer value) {
            addCriterion("blog_view <>", value, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewGreaterThan(Integer value) {
            addCriterion("blog_view >", value, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_view >=", value, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewLessThan(Integer value) {
            addCriterion("blog_view <", value, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewLessThanOrEqualTo(Integer value) {
            addCriterion("blog_view <=", value, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewIn(List<Integer> values) {
            addCriterion("blog_view in", values, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewNotIn(List<Integer> values) {
            addCriterion("blog_view not in", values, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewBetween(Integer value1, Integer value2) {
            addCriterion("blog_view between", value1, value2, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogViewNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_view not between", value1, value2, "blogView");
            return (Criteria) this;
        }

        public Criteria andBlogReplyIsNull() {
            addCriterion("blog_reply is null");
            return (Criteria) this;
        }

        public Criteria andBlogReplyIsNotNull() {
            addCriterion("blog_reply is not null");
            return (Criteria) this;
        }

        public Criteria andBlogReplyEqualTo(Integer value) {
            addCriterion("blog_reply =", value, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyNotEqualTo(Integer value) {
            addCriterion("blog_reply <>", value, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyGreaterThan(Integer value) {
            addCriterion("blog_reply >", value, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_reply >=", value, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyLessThan(Integer value) {
            addCriterion("blog_reply <", value, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyLessThanOrEqualTo(Integer value) {
            addCriterion("blog_reply <=", value, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyIn(List<Integer> values) {
            addCriterion("blog_reply in", values, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyNotIn(List<Integer> values) {
            addCriterion("blog_reply not in", values, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyBetween(Integer value1, Integer value2) {
            addCriterion("blog_reply between", value1, value2, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_reply not between", value1, value2, "blogReply");
            return (Criteria) this;
        }

        public Criteria andBlogTagIsNull() {
            addCriterion("blog_tag is null");
            return (Criteria) this;
        }

        public Criteria andBlogTagIsNotNull() {
            addCriterion("blog_tag is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTagEqualTo(String value) {
            addCriterion("blog_tag =", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotEqualTo(String value) {
            addCriterion("blog_tag <>", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagGreaterThan(String value) {
            addCriterion("blog_tag >", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagGreaterThanOrEqualTo(String value) {
            addCriterion("blog_tag >=", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagLessThan(String value) {
            addCriterion("blog_tag <", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagLessThanOrEqualTo(String value) {
            addCriterion("blog_tag <=", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagLike(String value) {
            addCriterion("blog_tag like", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotLike(String value) {
            addCriterion("blog_tag not like", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagIn(List<String> values) {
            addCriterion("blog_tag in", values, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotIn(List<String> values) {
            addCriterion("blog_tag not in", values, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagBetween(String value1, String value2) {
            addCriterion("blog_tag between", value1, value2, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotBetween(String value1, String value2) {
            addCriterion("blog_tag not between", value1, value2, "blogTag");
            return (Criteria) this;
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

        public Criteria andBlogCoverIsNull() {
            addCriterion("blog_cover is null");
            return (Criteria) this;
        }

        public Criteria andBlogCoverIsNotNull() {
            addCriterion("blog_cover is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCoverEqualTo(String value) {
            addCriterion("blog_cover =", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotEqualTo(String value) {
            addCriterion("blog_cover <>", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverGreaterThan(String value) {
            addCriterion("blog_cover >", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverGreaterThanOrEqualTo(String value) {
            addCriterion("blog_cover >=", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverLessThan(String value) {
            addCriterion("blog_cover <", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverLessThanOrEqualTo(String value) {
            addCriterion("blog_cover <=", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverLike(String value) {
            addCriterion("blog_cover like", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotLike(String value) {
            addCriterion("blog_cover not like", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverIn(List<String> values) {
            addCriterion("blog_cover in", values, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotIn(List<String> values) {
            addCriterion("blog_cover not in", values, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverBetween(String value1, String value2) {
            addCriterion("blog_cover between", value1, value2, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotBetween(String value1, String value2) {
            addCriterion("blog_cover not between", value1, value2, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendIsNull() {
            addCriterion("blog_recommend is null");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendIsNotNull() {
            addCriterion("blog_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendEqualTo(Boolean value) {
            addCriterion("blog_recommend =", value, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendNotEqualTo(Boolean value) {
            addCriterion("blog_recommend <>", value, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendGreaterThan(Boolean value) {
            addCriterion("blog_recommend >", value, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("blog_recommend >=", value, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendLessThan(Boolean value) {
            addCriterion("blog_recommend <", value, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("blog_recommend <=", value, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendIn(List<Boolean> values) {
            addCriterion("blog_recommend in", values, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendNotIn(List<Boolean> values) {
            addCriterion("blog_recommend not in", values, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("blog_recommend between", value1, value2, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("blog_recommend not between", value1, value2, "blogRecommend");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdIsNull() {
            addCriterion("blog_author_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdIsNotNull() {
            addCriterion("blog_author_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdEqualTo(Integer value) {
            addCriterion("blog_author_id =", value, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdNotEqualTo(Integer value) {
            addCriterion("blog_author_id <>", value, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdGreaterThan(Integer value) {
            addCriterion("blog_author_id >", value, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_author_id >=", value, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdLessThan(Integer value) {
            addCriterion("blog_author_id <", value, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_author_id <=", value, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdIn(List<Integer> values) {
            addCriterion("blog_author_id in", values, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdNotIn(List<Integer> values) {
            addCriterion("blog_author_id not in", values, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_author_id between", value1, value2, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_author_id not between", value1, value2, "blogAuthorId");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarIsNull() {
            addCriterion("blog_author_avatar is null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarIsNotNull() {
            addCriterion("blog_author_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarEqualTo(String value) {
            addCriterion("blog_author_avatar =", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarNotEqualTo(String value) {
            addCriterion("blog_author_avatar <>", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarGreaterThan(String value) {
            addCriterion("blog_author_avatar >", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("blog_author_avatar >=", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarLessThan(String value) {
            addCriterion("blog_author_avatar <", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarLessThanOrEqualTo(String value) {
            addCriterion("blog_author_avatar <=", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarLike(String value) {
            addCriterion("blog_author_avatar like", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarNotLike(String value) {
            addCriterion("blog_author_avatar not like", value, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarIn(List<String> values) {
            addCriterion("blog_author_avatar in", values, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarNotIn(List<String> values) {
            addCriterion("blog_author_avatar not in", values, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarBetween(String value1, String value2) {
            addCriterion("blog_author_avatar between", value1, value2, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorAvatarNotBetween(String value1, String value2) {
            addCriterion("blog_author_avatar not between", value1, value2, "blogAuthorAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameIsNull() {
            addCriterion("blog_author_name is null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameIsNotNull() {
            addCriterion("blog_author_name is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameEqualTo(String value) {
            addCriterion("blog_author_name =", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameNotEqualTo(String value) {
            addCriterion("blog_author_name <>", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameGreaterThan(String value) {
            addCriterion("blog_author_name >", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameGreaterThanOrEqualTo(String value) {
            addCriterion("blog_author_name >=", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameLessThan(String value) {
            addCriterion("blog_author_name <", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameLessThanOrEqualTo(String value) {
            addCriterion("blog_author_name <=", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameLike(String value) {
            addCriterion("blog_author_name like", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameNotLike(String value) {
            addCriterion("blog_author_name not like", value, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameIn(List<String> values) {
            addCriterion("blog_author_name in", values, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameNotIn(List<String> values) {
            addCriterion("blog_author_name not in", values, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameBetween(String value1, String value2) {
            addCriterion("blog_author_name between", value1, value2, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNameNotBetween(String value1, String value2) {
            addCriterion("blog_author_name not between", value1, value2, "blogAuthorName");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexIsNull() {
            addCriterion("blog_rank_index is null");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexIsNotNull() {
            addCriterion("blog_rank_index is not null");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexEqualTo(Double value) {
            addCriterion("blog_rank_index =", value, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexNotEqualTo(Double value) {
            addCriterion("blog_rank_index <>", value, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexGreaterThan(Double value) {
            addCriterion("blog_rank_index >", value, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexGreaterThanOrEqualTo(Double value) {
            addCriterion("blog_rank_index >=", value, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexLessThan(Double value) {
            addCriterion("blog_rank_index <", value, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexLessThanOrEqualTo(Double value) {
            addCriterion("blog_rank_index <=", value, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexIn(List<Double> values) {
            addCriterion("blog_rank_index in", values, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexNotIn(List<Double> values) {
            addCriterion("blog_rank_index not in", values, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexBetween(Double value1, Double value2) {
            addCriterion("blog_rank_index between", value1, value2, "blogRankIndex");
            return (Criteria) this;
        }

        public Criteria andBlogRankIndexNotBetween(Double value1, Double value2) {
            addCriterion("blog_rank_index not between", value1, value2, "blogRankIndex");
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