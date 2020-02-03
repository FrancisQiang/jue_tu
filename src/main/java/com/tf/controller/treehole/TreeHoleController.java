package com.tf.controller.treehole;


import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.constant.CodeMessage;
import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.treehole.TreeHoleCommentDTO;
import com.tf.dto.treehole.TreeHoleDetailMessageDTO;
import com.tf.dto.treehole.TreeHoleListInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.service.TreeHoleService;
import com.tf.utils.ValidateUtil;
import com.tf.vo.TreeHoleCommentVO;
import com.tf.vo.TreeHoleContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**TODO 权限尚未分配
 * @author Wei yuyaung
 * @date 2020.01.30 22:57
 */
@RestController
@RequestMapping("/treehole")
public class TreeHoleController {

    private final TreeHoleService treeHoleService;
    private final JwtUtil jwtUtil;

    @Autowired
    public TreeHoleController(TreeHoleService treeHoleService, JwtUtil jwtUtil) {
        this.treeHoleService = treeHoleService;
        this.jwtUtil = jwtUtil;
    }

    /**
     * description: 获取树洞列表
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.30
     */
    @GetMapping("/list/{pageIndex}")
    public PageInfoDTO<TreeHoleListInfoDTO> list(@PathVariable Integer pageIndex){
        return treeHoleService.list(pageIndex);
    }

    /**
     * description: 根据树洞id获取详细信息
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.31
     */
    @GetMapping("/detail/{treeholeId}")
    public TreeHoleDetailMessageDTO detailMessage(@PathVariable Integer treeholeId) throws GlobalException {
        return treeHoleService.detailMessage(treeholeId);
    }

    /**
     * description: 获取树洞评论
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    @GetMapping("/comment/{treeholeId}")
    public List<TreeHoleCommentDTO> comments(@PathVariable Integer treeholeId){
        List<TreeHoleCommentDTO> treeHoleCommentDTOS = treeHoleService.commentInfo(treeholeId);
        if(treeHoleCommentDTOS == null){
            return new ArrayList<>();
        }else {
            return treeHoleCommentDTOS;
        }
    }
    
    /**
     * description: 发布树洞消息
     * @return: 
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    @PostMapping("")
    public String publishTreeHole(@RequestBody @Valid TreeHoleContentVO treeHoleContentVO, BindingResult results) throws GlobalException {
        ValidateUtil.paramValidate(results);
        boolean success = treeHoleService.addNewTreeHole(Integer.valueOf(jwtUtil.getUserId()), treeHoleContentVO.getContent());
        if(success){
            return "";
        }else {
            throw new GlobalException(CodeMessage.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * description: 评论树洞
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    @PostMapping("/comment")
    public String addComment(@RequestBody @Valid TreeHoleCommentVO treeHoleCommentVO,BindingResult results) throws GlobalException {
        ValidateUtil.paramValidate(results);
        boolean success = treeHoleService.addNewTreeHoleComment(treeHoleCommentVO, Integer.valueOf(jwtUtil.getUserId()));
        if(success){
            return "";
        }else {
            throw new GlobalException(CodeMessage.INTERNAL_SERVER_ERROR);
        }

    }


}
