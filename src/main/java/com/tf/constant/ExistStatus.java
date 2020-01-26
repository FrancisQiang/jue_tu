package com.tf.constant;

import lombok.Getter;

/**
 * @author lgq
 * @date 2020/1/27
 */
@Getter
public enum ExistStatus {

    /**
     * 数据库存在状态
     */
    DELETE_STATUS(true),
    EXIST_STATUS(false);

    private boolean deleteFlag;

    ExistStatus(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
