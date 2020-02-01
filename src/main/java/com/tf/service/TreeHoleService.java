package com.tf.service;

import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.treehole.TreeHoleDetailMessageDTO;
import com.tf.dto.treehole.TreeHoleListInfoDTO;
import com.tf.exception.GlobalException;

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
}
