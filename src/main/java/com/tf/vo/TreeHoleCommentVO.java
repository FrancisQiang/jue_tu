package com.tf.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Wei yuyaung
 * @date 2020.02.04 0:16
 */
@Data
public class TreeHoleCommentVO {
    @NotNull(message = "传入树洞id不可为空")
    private Integer treeholeId;
    @NotNull(message = "传入pid不可为空")
    private Integer pid;
    @NotNull(message = "评论内容不可为空")
    private String content;
}
