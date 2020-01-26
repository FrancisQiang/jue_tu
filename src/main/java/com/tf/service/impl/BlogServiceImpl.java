package com.tf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tf.constant.CodeMessage;
import com.tf.constant.ExistStatus;
import com.tf.dao.BlogCommentMapper;
import com.tf.dao.BlogMapper;
import com.tf.dao.UserMapper;
import com.tf.dto.blog.BlogBriefListDTO;
import com.tf.dto.blog.BlogCommentListDTO;
import com.tf.dto.blog.BlogDetailDTO;
import com.tf.dto.page.PageInfoDTO;
import com.tf.entity.*;
import com.tf.exception.GlobalException;
import com.tf.service.BlogService;
import com.tf.utils.StringUtil;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import com.tf.vo.blog.PostBlogCommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    private final UserMapper userMapper;

    private final BlogCommentMapper blogCommentMapper;

    private static final int PAGE_SIZE = 3;

    @Autowired
    @SuppressWarnings("all")
    public BlogServiceImpl(BlogMapper blogMapper, UserMapper userMapper, BlogCommentMapper blogCommentMapper) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
        this.blogCommentMapper = blogCommentMapper;
    }

    @Override
    public void addBlog(Integer userId, BlogAddVO blogAddVO) throws GlobalException {
        User user = userMapper.selectByPrimaryKey(userId);
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogAddVO, blog);
        String blogSummary = blog.getBlogSummary();
        // 首先判断概要是否为空 如果为空则提取博客内容的前200字符作为概要
        if (StringUtil.isNullOrEmpty(blog.getBlogSummary())) {
            blogSummary = blog.getBlogContent().substring(0, 200);
        }
        //剔出<html>的标签
        String summaryContent = blogSummary.replaceAll("</?[^>]+>", StringUtil.EMPTY_STRING);
        //去除字符串中的空格,回车,换行符,制表符
        summaryContent = summaryContent.replaceAll("<a>\\s*|\t|\r|\n</a>", StringUtil.EMPTY_STRING);
        blog.setBlogAuthorId(userId);
        blog.setBlogAuthorAvatar(user.getUserAvatar());
        blog.setBlogSummary(summaryContent);
        if (blogMapper.insertSelective(blog) == 0) {
            throw new GlobalException(CodeMessage.BLOG_ADD_ERROR);
        }
    }

    @Override
    public void deleteBlog(Integer userId, Integer blogId) throws GlobalException {
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andBlogIdEqualTo(blogId).andBlogAuthorIdEqualTo(userId);
        if (blogMapper.deleteByExample(blogExample) == 0) {
            throw new GlobalException(CodeMessage.BLOG_DELETE_ERROR);
        }
    }

    @Override
    public void editBlog(Integer userId, BlogEditVO blogEditVO) throws GlobalException {
        Blog blog = new Blog();
        blog.setBlogAuthorId(userId);
        BeanUtils.copyProperties(blogEditVO, blog);
        if (blogMapper.updateByPrimaryKeySelective(blog) == 0) {
            throw new GlobalException(CodeMessage.BLOG_EDIT_ERROR);
        }
    }

    @Override
    public PageInfoDTO<BlogBriefListDTO> getPersonalBlogList(Integer userId, Integer pageIndex) {
        PageHelper.startPage(pageIndex, PAGE_SIZE, true, true, null);
        List<BlogBriefListDTO> personalBlogList = blogMapper.getPersonalBlogList(userId);
        PageInfo<BlogBriefListDTO> pageInfo = new PageInfo<>(personalBlogList);
        PageInfoDTO<BlogBriefListDTO> pageInfoDTO = new PageInfoDTO<>();
        pageInfoDTO.setCurrentPage(pageInfo.getPageNum());
        pageInfoDTO.setList(pageInfo.getList());
        pageInfoDTO.setTotalPage(pageInfo.getPages());
        pageInfoDTO.setTotal(pageInfo.getTotal());
        pageInfoDTO.setSize(pageInfo.getSize());
        return pageInfoDTO;
    }

    @Override
    public BlogDetailDTO getBlogDetail(Integer blogId) throws GlobalException {
        return blogMapper.getBlogDetailByBlogId(blogId);
    }

    @Override
    @Transactional(rollbackForClassName = "Exception.class")
    public void postBlogComment(PostBlogCommentVO postBlogCommentVO, Integer userId) throws GlobalException {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new GlobalException(CodeMessage.BLOG_COMMENT_ADD_ERROR);
        } else {
            BlogComment blogComment = new BlogComment();
            BeanUtils.copyProperties(postBlogCommentVO, blogComment);
            blogComment.setUserId(user.getUserId());
            blogComment.setUserName(user.getUserName());
            blogComment.setUserAvatar(user.getUserAvatar());
            if (blogCommentMapper.insertSelective(blogComment) == 0) {
                throw new GlobalException(CodeMessage.BLOG_COMMENT_ADD_ERROR);
            }
        }
    }

    @Override
    public List<BlogCommentListDTO> getCommentListByBlogId(Integer blogId) {
        return blogCommentMapper.getCommentByBlogId(blogId);
    }

    @Override
    @Transactional(rollbackForClassName = "Exception.class")
    public void deleteBlogComment(Integer blogCommentId) throws GlobalException{
        BlogComment blogComment = new BlogComment();
        blogComment.setBlogCommentId(blogCommentId);
        blogComment.setBlogCommentDeleteFlag(ExistStatus.DELETE_STATUS.isDeleteFlag());
        if (blogCommentMapper.updateByPrimaryKeySelective(blogComment) == 0) {
            throw new GlobalException(CodeMessage.BLOG_COMMENT_DELETE_ERROR);
        }
        BlogCommentExample blogCommentExample = new BlogCommentExample();
        BlogCommentExample.Criteria criteria = blogCommentExample.createCriteria();
        criteria.andBlogCommentIdEqualTo(blogCommentId);
        criteria.andBlogCommentPidEqualTo(blogCommentId);
        blogComment.setBlogCommentId(null);
        if (blogCommentMapper.updateByExampleSelective(blogComment, blogCommentExample) == 0) {
            throw new GlobalException(CodeMessage.BLOG_COMMENT_DELETE_ERROR);
        }
    }
}
