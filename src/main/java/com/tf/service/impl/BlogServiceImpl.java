package com.tf.service.impl;

import com.qiniu.util.StringUtils;
import com.tf.constant.CodeMessage;
import com.tf.dao.BlogMapper;
import com.tf.dao.UserMapper;
import com.tf.dto.blog.BlogBriefListDTO;
import com.tf.entity.Blog;
import com.tf.entity.BlogExample;
import com.tf.entity.User;
import com.tf.exception.GlobalException;
import com.tf.service.BlogService;
import com.tf.utils.StringUtil;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    private final UserMapper userMapper;

    @Autowired
    @SuppressWarnings("all")
    public BlogServiceImpl(BlogMapper blogMapper, UserMapper userMapper) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
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
    public List<BlogBriefListDTO> getPersonalBlogList(Integer userId, Integer pageIndex) {
        Integer firstLimit = (pageIndex - 1) * 10;
        return blogMapper.getPersonalBlogList(userId,firstLimit);
    }
}
