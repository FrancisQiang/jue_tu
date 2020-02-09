package com.tf.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tf.constant.CodeMessage;
import com.tf.constant.Constant;
import com.tf.constant.ExistStatus;
import com.tf.constant.RedisKey;
import com.tf.dao.BlogCommentMapper;
import com.tf.dao.BlogMapper;
import com.tf.dao.ThumbUserBlogMapper;
import com.tf.dao.UserMapper;
import com.tf.dto.blog.BlogBriefListDTO;
import com.tf.dto.blog.BlogCommentListDTO;
import com.tf.dto.blog.BlogDetailDTO;
import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.page.SimplePageInfoDTO;
import com.tf.entity.*;
import com.tf.exception.GlobalException;
import com.tf.service.BlogService;
import com.tf.service.RedisService;
import com.tf.utils.StringUtil;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import com.tf.vo.blog.PostBlogCommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    private final UserMapper userMapper;

    private final BlogCommentMapper blogCommentMapper;

    private final RedisService redisService;

    private final ThumbUserBlogMapper thumbUserBlogMapper;

    @Autowired
    @SuppressWarnings("all")
    public BlogServiceImpl(BlogMapper blogMapper, UserMapper userMapper, BlogCommentMapper blogCommentMapper,
                           RedisService redisService, ThumbUserBlogMapper thumbUserBlogMapper) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
        this.blogCommentMapper = blogCommentMapper;
        this.redisService = redisService;
        this.thumbUserBlogMapper = thumbUserBlogMapper;
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
        PageHelper.startPage(pageIndex, (int)Constant.PER_PAGE_NUM_TEN, true, true, null);
        List<BlogBriefListDTO> personalBlogList = blogMapper.getPersonalBlogList(userId);
        PageInfo<BlogBriefListDTO> pageInfo = new PageInfo<>(personalBlogList);
        PageInfoDTO<BlogBriefListDTO> pageInfoDTO = new PageInfoDTO<>();
        pageInfoDTO.setHasNextPage(pageInfo.isHasNextPage());
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
    public void deleteBlogComment(Integer blogCommentId) throws GlobalException {
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

    @Override
    public SimplePageInfoDTO<BlogBriefListDTO> getHotBlogList(Integer days, Integer pageIndex) {
        // 固定查询时间
        int decideDays = decideDays(days);
        // 首先从 Redis 缓存中获取 使用 rage 实现 redis 分页
        SimplePageInfoDTO<BlogBriefListDTO> blogBriefListDTOSimplePageInfoDTO = null;
        // 首先从缓存中查询
        if (decideDays == Constant.ONE_DAY) {
            blogBriefListDTOSimplePageInfoDTO = queryBlogListFromCache(RedisKey.HOT_BLOG_LIST_ONE_DAY, pageIndex);
        } else if (decideDays == Constant.THREE_DAY) {
            blogBriefListDTOSimplePageInfoDTO = queryBlogListFromCache(RedisKey.HOT_BLOG_LIST_THREE_DAY, pageIndex);
        } else {
            blogBriefListDTOSimplePageInfoDTO = queryBlogListFromCache(RedisKey.HOT_BLOG_LIST_SEVEN_DAY, pageIndex);
        }
        if (blogBriefListDTOSimplePageInfoDTO != null) {
            return blogBriefListDTOSimplePageInfoDTO;
        }
        // 首先获取指定天数内的所有博客列表
        if (decideDays == Constant.ONE_DAY) {
            return queryHotBlogFromDb(RedisKey.HOT_BLOG_LIST_ONE_DAY, Constant.ONE_DAY, pageIndex);
        } else if (decideDays == Constant.THREE_DAY) {
            return queryHotBlogFromDb(RedisKey.HOT_BLOG_LIST_THREE_DAY, Constant.THREE_DAY, pageIndex);
        } else {
            return queryHotBlogFromDb(RedisKey.HOT_BLOG_LIST_SEVEN_DAY, Constant.SEVEN_DAY, pageIndex);
        }
    }

    /**
     * 固定查询时间，使查询时间合理化
     *
     * @param days 用户输入的
     * @return 合理化之后的天数
     */
    private int decideDays(int days) {
        if (days <= Constant.ONE_DAY) {
            return Constant.ONE_DAY;
        } else if (days <= Constant.THREE_DAY) {
            return Constant.THREE_DAY;
        } else {
            return Constant.SEVEN_DAY;
        }
    }

    /**
     * 从数据库中查询热榜
     *
     * @param redisKey  redis键 主要涉及到哪一时间范围的值 查询后需要存入Redis
     * @param days      时间范围
     * @param pageIndex 分页
     * @return 分页列表
     */
    private SimplePageInfoDTO<BlogBriefListDTO> queryHotBlogFromDb(String redisKey, int days, int pageIndex) {
        List<BlogBriefListDTO> blogListInTimeRange = blogMapper.getBlogListInTimeRange(days);
        blogListInTimeRange = blogListInTimeRange.stream()
                // 设定比较规则 需要注意全局影响
                .sorted(Comparator.comparingDouble(blog -> blog.getBlogThumb() + (blog.getBlogView() + 1) / 100.00))
                .collect(Collectors.toList());
        // 存入 Redis 中 并设置10分钟超时时长
        blogListInTimeRange.forEach(item -> redisService.rpush(redisKey, item));
        redisService.expire(redisKey, 120, TimeUnit.SECONDS);
        if (blogListInTimeRange.size() <= (int) Constant.PER_PAGE_NUM_TEN * pageIndex
                && blogListInTimeRange.size() >= (int) Constant.PER_PAGE_NUM_TEN * (pageIndex - 1)) {
            return new SimplePageInfoDTO<>(false,
                    blogListInTimeRange.subList((int) Constant.PER_PAGE_NUM_TEN * (pageIndex - 1), blogListInTimeRange.size()));
        } else if (blogListInTimeRange.size() < (int) Constant.PER_PAGE_NUM_TEN * pageIndex) {
            return null;
        }
        return new SimplePageInfoDTO<>(true,
                blogListInTimeRange.subList((int) Constant.PER_PAGE_NUM_TEN * (pageIndex - 1),
                        (int) Constant.PER_PAGE_NUM_TEN * pageIndex));
    }

    /**
     * 从缓存中查询指定博客列表
     *
     * @param redisKey  redis键 主要涉及到哪一时间范围的值
     * @param pageIndex 分页
     * @return 分页列表
     */
    private SimplePageInfoDTO<BlogBriefListDTO> queryBlogListFromCache(String redisKey,
                                                                       int pageIndex) {
        List<BlogBriefListDTO> cacheList = null;
        long length = redisService.llen(redisKey);
        if (Constant.PER_PAGE_NUM_TEN * pageIndex >= length
                && length >= Constant.PER_PAGE_NUM_TEN * (pageIndex - 1)) {
            cacheList = redisService.lrange(redisKey, Constant.PER_PAGE_NUM_TEN * (pageIndex - 1),
                    length - 1, BlogBriefListDTO.class);
            if (cacheList != null && cacheList.size() > 0) {
                return new SimplePageInfoDTO<>(false, cacheList);
            }
            return null;
        } else if (Constant.PER_PAGE_NUM_TEN * pageIndex > length) {
            return null;
        } else {
            cacheList = redisService.lrange(redisKey, Constant.PER_PAGE_NUM_TEN * (pageIndex - 1),
                    Constant.PER_PAGE_NUM_TEN * pageIndex - 1, BlogBriefListDTO.class);
            if (cacheList != null && cacheList.size() > 0) {
                return new SimplePageInfoDTO<>(true, cacheList);
            }
            return null;
        }
    }

    @Override
    public SimplePageInfoDTO<BlogBriefListDTO> getRecommendBlogList(Integer pageIndex) throws GlobalException{
        // 首先去缓存中查询 这个时候返回的是集合
        Set<String> cacheList = null;
        // 获取集合长度来判断分页
        Long length = redisService.zlen(RedisKey.RECOMMEND_BLOG_LIST);
        if (Constant.PER_PAGE_NUM_TEN * pageIndex >= length
                && length >= Constant.PER_PAGE_NUM_TEN * (pageIndex - 1)) {
            cacheList = redisService.zrevrange(RedisKey.RECOMMEND_BLOG_LIST, Constant.PER_PAGE_NUM_TEN * (pageIndex - 1),
                    length - 1);
            if (cacheList != null && cacheList.size() > 0) {
                List<BlogBriefListDTO> list = cacheList.stream()
                                .map(item -> JSON.parseObject(item, BlogBriefListDTO.class))
                        .collect(Collectors.toList());
                return new SimplePageInfoDTO<>(false, list);
            }
        } else if (Constant.PER_PAGE_NUM_TEN * pageIndex <= length){
            cacheList = redisService.zrevrange(RedisKey.RECOMMEND_BLOG_LIST, Constant.PER_PAGE_NUM_TEN * (pageIndex - 1),
                    Constant.PER_PAGE_NUM_TEN * pageIndex - 1);
            if (cacheList != null && cacheList.size() > 0) {
                List<BlogBriefListDTO> list = cacheList.stream()
                        .map(item -> JSON.parseObject(item, BlogBriefListDTO.class))
                        .collect(Collectors.toList());
                return new SimplePageInfoDTO<>(true, list);
            }
        }
        // 如果缓存中没有则去数据中查询
        PageHelper.startPage(pageIndex, (int)Constant.PER_PAGE_NUM_TEN, true, true, null);
        List<BlogBriefListDTO> recommendBlogList = blogMapper.getRecommendBlogList();
        PageInfo<BlogBriefListDTO> pageInfo = new PageInfo<>(recommendBlogList);
        List<BlogBriefListDTO> resultList = pageInfo.getList();
        // 将查询结果放入缓存中
        resultList.forEach(item -> redisService.zadd(
                RedisKey.RECOMMEND_BLOG_LIST,
                JSON.toJSONString(item),
                item.getBlogRankIndex()));
        SimplePageInfoDTO<BlogBriefListDTO> simplePageInfoDTO = new SimplePageInfoDTO<>();
        simplePageInfoDTO.setList(resultList);
        simplePageInfoDTO.setHasNextPage(pageInfo.isHasNextPage());
        return simplePageInfoDTO;
    }

    @Override
    public SimplePageInfoDTO<BlogBriefListDTO> getLatestBlogList(Integer pageIndex) throws GlobalException {
        // 首先从缓存中查询
        SimplePageInfoDTO<BlogBriefListDTO> blogCacheList
                = queryBlogListFromCache(RedisKey.LATEST_BLOG_LIST, pageIndex);
        if (blogCacheList != null) {
            return blogCacheList;
        }
        return queryHotBlogFromDb(RedisKey.LATEST_BLOG_LIST, Constant.SEVEN_DAY, pageIndex);
    }

    @Override
    public void thumbBlog(Integer userId, Integer blogId) throws GlobalException{
        // 首先查看是否已经点过赞
        ThumbUserBlogExample example = new ThumbUserBlogExample();
        ThumbUserBlogExample.Criteria criteria = example.createCriteria();
        criteria.andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);
        List<ThumbUserBlog> thumbUserBlogList = thumbUserBlogMapper.selectByExample(example);
        if (thumbUserBlogList == null || thumbUserBlogList.size() == 0) {
            // 进行点赞
            ThumbUserBlog thumbUserBlog = new ThumbUserBlog();
            thumbUserBlog.setBlogId(blogId);
            thumbUserBlog.setUserId(userId);
            if (thumbUserBlogMapper.insertSelective(thumbUserBlog) == 0) {
                throw new GlobalException(CodeMessage.ADD_THUMB_ERROR);
            }
        } else {
            // 取消点赞
            if (thumbUserBlogMapper.deleteByPrimaryKey(thumbUserBlogList.get(0).getThumbUserBlogId()) == 0) {
                throw new GlobalException(CodeMessage.DELETE_THUMB_ERROR);
            }
        }
    }
}
