package com.tf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tf.constant.CodeMessage;
import com.tf.dao.TreeHoleCommentMapper;
import com.tf.dao.TreeHoleMapper;
import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.treehole.TreeHoleCommentDTO;
import com.tf.dto.treehole.TreeHoleDetailMessageDTO;
import com.tf.dto.treehole.TreeHoleListInfoDTO;
import com.tf.entity.TreeHole;
import com.tf.entity.TreeHoleComment;
import com.tf.entity.TreeHoleCommentExample;
import com.tf.entity.TreeHoleExample;
import com.tf.exception.GlobalException;
import com.tf.service.TreeHoleService;
import com.tf.vo.TreeHoleCommentVO;
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
    private final TreeHoleCommentMapper treeHoleCommentMapper;
    private final DozerBeanMapper dozerBeanMapper;

    @Autowired
    @SuppressWarnings("all")
    public TreeHoleServiceImpl(TreeHoleMapper treeHoleMapper, DozerBeanMapper dozerBeanMapper,TreeHoleCommentMapper treeHoleCommentMapper) {
        this.treeHoleMapper = treeHoleMapper;
        this.dozerBeanMapper = dozerBeanMapper;
        this.treeHoleCommentMapper = treeHoleCommentMapper;
    }


    private static final int PAGE_SIZE = 10;

    @Override
    public PageInfoDTO<TreeHoleListInfoDTO> list(Integer pageIndex) {
        PageHelper.startPage(pageIndex, PAGE_SIZE, true, true, null);
        TreeHoleExample treeHoleExample = new TreeHoleExample();
        treeHoleExample.createCriteria().andTreeHoleCreateTimeLessThanOrEqualTo(new Date());
        List<TreeHole> treeHolesList = treeHoleMapper.selectByExampleWithBLOBs(treeHoleExample);
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

    @Override
    public List<TreeHoleCommentDTO> commentInfo(Integer treeholeId) {
        TreeHoleCommentExample treeHoleCommentExample = new TreeHoleCommentExample();
        treeHoleCommentExample.createCriteria().andTreeHoleIdEqualTo(treeholeId);
        List<TreeHoleComment> treeHoleComments = treeHoleCommentMapper.selectByExample(treeHoleCommentExample);

        if(treeHoleComments.size() == 0){
            return null;
        }

        List<TreeHoleCommentDTO> treeHoleCommentDTO = new ArrayList<>();
        for (TreeHoleComment treeHoleComment :
                treeHoleComments) {
            TreeHoleCommentDTO map = dozerBeanMapper.map(treeHoleComment, TreeHoleCommentDTO.class);
            treeHoleCommentDTO.add(map);
        }
        return treeHoleCommentDTO;
    }

    @Override
    public boolean addNewTreeHole(Integer userId, String content) {
        TreeHole insertInfo = new TreeHole();
        insertInfo.setTreeHoleUserId(userId);
        insertInfo.setTreeHoleContent(content);
        insertInfo.setTreeHoleCreateTime(new Date());
        return treeHoleMapper.insertSelective(insertInfo) > 0;
    }

    @Override
    public boolean addNewTreeHoleComment(TreeHoleCommentVO treeHoleCommentVO, Integer userId) {
        TreeHoleComment insertCommentInfo = new TreeHoleComment();
        insertCommentInfo.setTreeHoleCommentPid(treeHoleCommentVO.getPid());
        insertCommentInfo.setTreeHoleCommentContent(treeHoleCommentVO.getContent());
        insertCommentInfo.setTreeHoleCommentUserId(userId);
        insertCommentInfo.setTreeHoleCommentCreateTime(new Date());

        return treeHoleCommentMapper.insertSelective(insertCommentInfo) > 0;
    }
}
