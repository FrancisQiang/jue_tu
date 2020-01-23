package com.tf.service.impl;

import com.tf.constant.CodeMessage;
import com.tf.dao.BlogMapper;
import com.tf.dao.UserMapper;
import com.tf.entity.Blog;
import com.tf.entity.User;
import com.tf.exception.GlobalException;
import com.tf.service.BlogService;
import com.tf.vo.blog.BlogAddVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        blog.setBlogAuthorId(userId);
        blog.setBlogAuthorAvatar(user.getUserAvatar());
        if (blogMapper.insertSelective(blog) == 0) {
            throw new GlobalException(CodeMessage.BLOG_ADD_ERROR);
        }
    }

}
