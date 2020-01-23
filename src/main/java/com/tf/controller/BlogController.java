package com.tf.controller;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.exception.GlobalException;
import com.tf.service.impl.BlogServiceImpl;
import com.tf.vo.blog.BlogAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lgq
 * @date 2020/1/23
 */
@RestController
@RequestMapping(value = "/blog")
@CrossOrigin
public class BlogController {

    private final BlogServiceImpl blogService;

    private final JwtUtil jwtUtil;

    @Autowired
    public BlogController(BlogServiceImpl blogService, JwtUtil jwtUtil) {
        this.blogService = blogService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "")
    public void addBlog(@RequestBody BlogAddVO blogAddVO) throws GlobalException {
        String userId = jwtUtil.getUserId();
        blogService.addBlog(Integer.valueOf(userId), blogAddVO);
    }


}
