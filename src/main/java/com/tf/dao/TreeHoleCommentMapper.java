package com.tf.dao;

import com.tf.entity.TreeHoleComment;
import com.tf.entity.TreeHoleCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeHoleCommentMapper {
    long countByExample(TreeHoleCommentExample example);

    int deleteByExample(TreeHoleCommentExample example);

    int deleteByPrimaryKey(Integer treeHoleCommentId);

    int insert(TreeHoleComment record);

    int insertSelective(TreeHoleComment record);

    List<TreeHoleComment> selectByExampleWithBLOBs(TreeHoleCommentExample example);

    List<TreeHoleComment> selectByExample(TreeHoleCommentExample example);

    TreeHoleComment selectByPrimaryKey(Integer treeHoleCommentId);

    int updateByExampleSelective(@Param("record") TreeHoleComment record, @Param("example") TreeHoleCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") TreeHoleComment record, @Param("example") TreeHoleCommentExample example);

    int updateByExample(@Param("record") TreeHoleComment record, @Param("example") TreeHoleCommentExample example);

    int updateByPrimaryKeySelective(TreeHoleComment record);

    int updateByPrimaryKeyWithBLOBs(TreeHoleComment record);

    int updateByPrimaryKey(TreeHoleComment record);
}