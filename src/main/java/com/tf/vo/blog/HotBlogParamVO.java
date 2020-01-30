package com.tf.vo.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lgq
 * @date 2020/1/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotBlogParamVO {

    @NotNull
    private Integer pageIndex;

    @NotNull
    private Integer days;

}
