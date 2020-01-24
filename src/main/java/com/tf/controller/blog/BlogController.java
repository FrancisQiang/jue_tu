package com.tf.controller.blog;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.exception.GlobalException;
import com.tf.service.impl.BlogServiceImpl;
import com.tf.util.ValidateUtil;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void addBlog(@RequestBody @Valid BlogAddVO blogAddVO, BindingResult bindingResult) throws GlobalException {
        ValidateUtil.paramValidate(bindingResult);
        blogService.addBlog(Integer.valueOf(jwtUtil.getUserId()), blogAddVO);
    }

    @DeleteMapping(value = "/{blogId}")
    public void deleteBlog(@PathVariable(value = "blogId") Integer blogId) throws GlobalException {
        blogService.deleteBlog(Integer.valueOf(jwtUtil.getUserId()), blogId);
    }

    @PatchMapping(value = "")
    public void editBlog(@RequestBody @Valid BlogEditVO blogEditVO, BindingResult bindingResult) throws GlobalException{
        ValidateUtil.paramValidate(bindingResult);
        blogService.editBlog(Integer.valueOf(jwtUtil.getUserId()), blogEditVO);
    }


}
