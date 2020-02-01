package com.tf.controller.treehole;


import com.tf.dto.page.PageInfoDTO;
import com.tf.dto.treehole.TreeHoleDetailMessageDTO;
import com.tf.dto.treehole.TreeHoleListInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.service.TreeHoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.01.30 22:57
 */
@RestController
@RequestMapping("/treehole")
public class TreeHoleController {

    private final TreeHoleService treeHoleService;

    @Autowired
    public TreeHoleController(TreeHoleService treeHoleService) {
        this.treeHoleService = treeHoleService;
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

}
