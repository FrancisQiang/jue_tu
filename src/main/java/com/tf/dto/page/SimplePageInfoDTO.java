package com.tf.dto.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lgq
 * @date 2020/1/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePageInfoDTO<T> {

    private Boolean hasNextPage;

    private List<T> list;

}
