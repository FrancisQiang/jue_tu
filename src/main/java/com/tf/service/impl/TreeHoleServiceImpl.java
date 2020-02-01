package com.tf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tf.constant.CodeMessage;
import com.tf.dao.TreeHoleMapper;
import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.treehole.TreeHoleDetailMessageDTO;
import com.tf.dto.treehole.TreeHoleListInfoDTO;
import com.tf.entity.TreeHole;
import com.tf.entity.TreeHoleExample;
import com.tf.exception.GlobalException;
import com.tf.service.TreeHoleService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.01.31 18:00
 */
@Service
public class TreeHoleServiceImpl implements TreeHoleService {
    private final TreeHoleMapper treeHoleMapper;
    private final DozerBeanMapper dozerBeanMapper;

    @Autowired
    @SuppressWarnings("all")
    public TreeHoleServiceImpl(TreeHoleMapper treeHoleMapper, DozerBeanMapper dozerBeanMapper) {
        this.treeHoleMapper = treeHoleMapper;
        this.dozerBeanMapper = dozerBeanMapper;
    }


    private static final int PAGE_SIZE = 10;

    @Override
    public PageInfoDTO<TreeHoleListInfoDTO> list(Integer pageIndex) {
        PageHelper.startPage(pageIndex, PAGE_SIZE, true, true, null);
        TreeHoleExample treeHoleExample = new TreeHoleExample();
        treeHoleExample.createCriteria().andTreeHoleCreateTimeLessThanOrEqualTo(new Date());
        List<TreeHole> treeHolesList = treeHoleMapper.selectByExample(treeHoleExample);
        List<TreeHoleListInfoDTO> infoList = new ArrayList<>();
        for (TreeHole treeHole:
             treeHolesList) {
            TreeHoleListInfoDTO treeHoleListInfoDTO = dozerBeanMapper.map(treeHole, TreeHoleListInfoDTO.class);
            infoList.add(treeHoleListInfoDTO);
        }
        PageInfo<TreeHoleListInfoDTO> pageInfoList = new PageInfo<>(infoList);
        PageInfoDTO<TreeHoleListInfoDTO> pageInfoDTO = new PageInfoDTO<>();
        pageInfoDTO.setCurrentPage(pageInfoList.getPageNum());
        pageInfoDTO.setList(pageInfoList.getList());
        pageInfoDTO.setTotalPage(pageInfoList.getPages());
        pageInfoDTO.setTotal(pageInfoList.getTotal());
        pageInfoDTO.setSize(pageInfoList.getSize());
        return pageInfoDTO;
    }

    @Override
    public TreeHoleDetailMessageDTO detailMessage(Integer treeHoleId) throws GlobalException {
        TreeHole treeHole = treeHoleMapper.selectByPrimaryKey(treeHoleId);
        if(treeHole == null){
            throw new GlobalException(CodeMessage.TREE_HOLE_MESSAGE_ERROR);
        }
        return dozerBeanMapper.map(treeHole, TreeHoleDetailMessageDTO.class);
    }
}
