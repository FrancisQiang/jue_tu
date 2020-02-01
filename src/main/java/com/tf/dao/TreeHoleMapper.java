package com.tf.dao;

import com.tf.entity.TreeHole;
import com.tf.entity.TreeHoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeHoleMapper {
    long countByExample(TreeHoleExample example);

    int deleteByExample(TreeHoleExample example);

    int deleteByPrimaryKey(Integer treeHoleId);

    int insert(TreeHole record);

    int insertSelective(TreeHole record);

    List<TreeHole> selectByExampleWithBLOBs(TreeHoleExample example);

    List<TreeHole> selectByExample(TreeHoleExample example);

    TreeHole selectByPrimaryKey(Integer treeHoleId);

    int updateByExampleSelective(@Param("record") TreeHole record, @Param("example") TreeHoleExample example);

    int updateByExampleWithBLOBs(@Param("record") TreeHole record, @Param("example") TreeHoleExample example);

    int updateByExample(@Param("record") TreeHole record, @Param("example") TreeHoleExample example);

    int updateByPrimaryKeySelective(TreeHole record);

    int updateByPrimaryKeyWithBLOBs(TreeHole record);

    int updateByPrimaryKey(TreeHole record);
}