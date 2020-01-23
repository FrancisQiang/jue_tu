package com.tf.dao;

import com.tf.entity.RecommendTag;
import com.tf.entity.RecommendTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendTagMapper {
    long countByExample(RecommendTagExample example);

    int deleteByExample(RecommendTagExample example);

    int deleteByPrimaryKey(Integer recommendTagId);

    int insert(RecommendTag record);

    int insertSelective(RecommendTag record);

    List<RecommendTag> selectByExample(RecommendTagExample example);

    RecommendTag selectByPrimaryKey(Integer recommendTagId);

    int updateByExampleSelective(@Param("record") RecommendTag record, @Param("example") RecommendTagExample example);

    int updateByExample(@Param("record") RecommendTag record, @Param("example") RecommendTagExample example);

    int updateByPrimaryKeySelective(RecommendTag record);

    int updateByPrimaryKey(RecommendTag record);
}