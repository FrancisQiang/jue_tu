package com.tf.dao;

import com.tf.dto.blog.BlogBriefListDTO;
import com.tf.dto.blog.BlogDetailDTO;
import com.tf.entity.Blog;
import com.tf.entity.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Integer blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Integer blogId);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    List<BlogBriefListDTO> getPersonalBlogList(Integer userId);

    BlogDetailDTO getBlogDetailByBlogId(Integer blogId);

    List<BlogBriefListDTO> getBlogListInTimeRange(Integer days);

    List<BlogBriefListDTO> getRecommendBlogList();
}