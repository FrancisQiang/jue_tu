package com.tf.service;

import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.treehole.TreeHoleCommentDTO;
import com.tf.dto.treehole.TreeHoleDetailMessageDTO;
import com.tf.dto.treehole.TreeHoleListInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.vo.TreeHoleCommentVO;

import java.util.List;

public interface TreeHoleService {

    /**
     * description: 获取树洞消息列表
     * @author: Wei Yuyang
     * @time: 2020.01.31
     */
    PageInfoDTO<TreeHoleListInfoDTO> list(Integer pageIndex);

    /**
     * description: 获取树洞详细信息
     * @author: Wei Yuyang
     * @time: 2020.02.01
     */
    TreeHoleDetailMessageDTO detailMessage(Integer treeHoleId) throws GlobalException;

    /**
     * description: 搜索指定树洞id的评论信息
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    List<TreeHoleCommentDTO> commentInfo(Integer treeholeId);

    /**
     * description: 新增树洞
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    boolean addNewTreeHole(Integer userId,String content);

    /**
     * description: 新增树洞评论
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.02.04
     */
    boolean addNewTreeHoleComment(TreeHoleCommentVO treeHoleCommentVO,Integer userId);
}
