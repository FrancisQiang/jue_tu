package com.tf.service;

import com.tf.exception.GlobalException;
import com.tf.vo.blog.BlogAddVO;
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


}
