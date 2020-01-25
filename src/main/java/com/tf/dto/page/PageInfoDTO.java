package com.tf.dto.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lgq
 * @date 2020/1/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class PageInfoDTO<T> {

    private Integer currentPage;

    private Integer totalPage;

    private Long total;

    private Integer size;

    private List<T> list;
}
