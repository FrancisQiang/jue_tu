package com.tf.service;

import com.tf.exception.GlobalException;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import org.springframework.stereotype.Service;

/**
 * @author lgq
 * @date 2020/1/23
 */
public interface BlogService {


    /**
     * 添加博客
     * @param blogAddVO 添加博客
     * @param userId 用户id
     * @throws GlobalException 全局异常
     */
    void addBlog(Integer userId, BlogAddVO blogAddVO) throws GlobalException;

    /**
     * 删除博客
     * @param userId 用户id
     * @param blogId 博客id
     * @throws GlobalException 全局异常
     */
    void deleteBlog(Integer userId, Integer blogId) throws GlobalException;

    /**
     * 编辑博客
     * @param userId 用户id
     * @param blogEditVO 编辑VO对象
     * @throws GlobalException 全局异常
     */
    void editBlog(Integer userId, BlogEditVO blogEditVO) throws GlobalException;

}
