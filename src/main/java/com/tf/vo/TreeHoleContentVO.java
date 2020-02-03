package com.tf.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Wei yuyaung
 * @date 2020.02.03 23:08
 */
@Data
public class TreeHoleContentVO {
    @NotNull(message = "内容不能为空")
    private String content;
}
