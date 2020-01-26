package com.tf.controller.blog;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.dto.blog.BlogBriefListDTO;
import com.tf.dto.blog.BlogCommentListDTO;
import com.tf.dto.blog.BlogDetailDTO;
import com.tf.dto.page.PageInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.service.BlogService;
import com.tf.utils.ValidateUtil;
import com.tf.vo.blog.BlogAddVO;
import com.tf.vo.blog.BlogEditVO;
import com.tf.vo.blog.PostBlogCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lgq
 * @date 2020/1/23
 */
@RestController
@RequestMapping(value = "/blog")
@CrossOrigin
public class BlogController {

    private final BlogService blogService;

    private final JwtUtil jwtUtil;

    @Autowired
    public BlogController(BlogService blogService, JwtUtil jwtUtil) {
        this.blogService = blogService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping(value = "/{blogId}")
    public BlogDetailDTO getBlogDetail(@PathVariable("blogId")Integer blogId) throws GlobalException{
        return blogService.getBlogDetail(blogId);
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

    @GetMapping(value = "/list/{pageIndex}")
    public PageInfoDTO<BlogBriefListDTO> getPersonalBlogList(@PathVariable("pageIndex")Integer pageIndex) {
        return blogService.getPersonalBlogList(Integer.valueOf(jwtUtil.getUserId()), pageIndex);
    }

    @GetMapping(value = "/list/{userId}/{pageIndex}")
    public PageInfoDTO<BlogBriefListDTO> getPersonalBlogList(@PathVariable("userId") Integer userId,
            @PathVariable("pageIndex")Integer pageIndex) {
        return blogService.getPersonalBlogList(userId, pageIndex);
    }

    @PostMapping(value = "/comment")
    public void postBlogComment(@RequestBody @Valid PostBlogCommentVO postBlogCommentVO,
                                BindingResult bindingResult) throws GlobalException{
        ValidateUtil.paramValidate(bindingResult);
        blogService.postBlogComment(postBlogCommentVO, Integer.valueOf(jwtUtil.getUserId()));
    }

    @GetMapping(value = "/comment/{blogId}")
    public List<BlogCommentListDTO> getBlogCommentByBlogId(@PathVariable(value = "blogId")
                                                           Integer blogId) {
        return blogService.getCommentListByBlogId(blogId);
    }

    @DeleteMapping(value = "/comment/{blogCommentId}")
    public void deleteBlogComment(@PathVariable(value = "blogCommentId") Integer blogCommentId) throws GlobalException {
        blogService.deleteBlogComment(blogCommentId);
    }

}
