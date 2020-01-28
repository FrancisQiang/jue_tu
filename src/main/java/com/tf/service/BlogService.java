package com.tf.service;

import com.tf.dto.blog.BlogBriefListDTO;
import com.tf.dto.blog.BlogCommentListDTO;
import com.tf.dto.blog.BlogDetailDTO;
import com.tf.dto.page.PageInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import com.tf.vo.blog.PostBlogCommentVO;

import java.util.List;

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

    /**
     * 获取个人用户的博客简要信息列表
     * @param userId 用户id
     * @param pageIndex 页数
     * @return 博客简要信息列表
     */
    PageInfoDTO<BlogBriefListDTO> getPersonalBlogList(Integer userId, Integer pageIndex);

    /**
     * 获取博客详情
     * @param blogId 博客ID
     * @return 博客详情传输对象
     * @throws GlobalException 全局异常
     */
    BlogDetailDTO getBlogDetail(Integer blogId) throws GlobalException;

    /**
     * 发表评论
     * @param postBlogCommentVO 评论VO
     * @param userId 用户ID
     * @throws GlobalException 全局异常
     */
    void postBlogComment(PostBlogCommentVO postBlogCommentVO, Integer userId) throws GlobalException;

    /**
     * 获取某篇博客的评论列表
     * @param blogId 博客ID
     * @return 博客评论列表
     */
    List<BlogCommentListDTO> getCommentListByBlogId(Integer blogId);

    /**
     * 删除评论内容
     * @param blogCommentId 博客评论id
     * @throws GlobalException 全局异常
     */
    void deleteBlogComment(Integer blogCommentId) throws GlobalException;

}
