package com.tf.entity;

public class RecommendTag {
    private Integer recommendTagId;

    private String recommendTagName;

    private String recommendTagDescription;

    public Integer getRecommendTagId() {
        return recommendTagId;
    }

    public void setRecommendTagId(Integer recommendTagId) {
        this.recommendTagId = recommendTagId;
    }

    public String getRecommendTagName() {
        return recommendTagName;
    }

    public void setRecommendTagName(String recommendTagName) {
        this.recommendTagName = recommendTagName == null ? null : recommendTagName.trim();
    }

    public String getRecommendTagDescription() {
        return recommendTagDescription;
    }

    public void setRecommendTagDescription(String recommendTagDescription) {
        this.recommendTagDescription = recommendTagDescription == null ? null : recommendTagDescription.trim();
    }
}