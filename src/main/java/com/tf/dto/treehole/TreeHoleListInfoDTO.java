package com.tf.dto.treehole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Wei yuyaung
 * @date 2020.01.31 17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeHoleListInfoDTO {
    private String treeholeId;
    private String content;
    private Date createTime;
}
