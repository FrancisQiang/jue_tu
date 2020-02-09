package com.tf.dao;

import com.tf.entity.ThumbUserBlog;
import com.tf.entity.ThumbUserBlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThumbUserBlogMapper {
    long countByExample(ThumbUserBlogExample example);

    int deleteByExample(ThumbUserBlogExample example);

    int deleteByPrimaryKey(Integer thumbUserBlogId);

    int insert(ThumbUserBlog record);

    int insertSelective(ThumbUserBlog record);

    List<ThumbUserBlog> selectByExample(ThumbUserBlogExample example);

    ThumbUserBlog selectByPrimaryKey(Integer thumbUserBlogId);

    int updateByExampleSelective(@Param("record") ThumbUserBlog record, @Param("example") ThumbUserBlogExample example);

    int updateByExample(@Param("record") ThumbUserBlog record, @Param("example") ThumbUserBlogExample example);

    int updateByPrimaryKeySelective(ThumbUserBlog record);

    int updateByPrimaryKey(ThumbUserBlog record);
}