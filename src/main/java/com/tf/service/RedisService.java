package com.tf.service;

import org.springframework.stereotype.Service;

/**
 * @author lgq
 * @date 2020/1/22
 */
public interface RedisService {

    /**
     * 设置
     * @param key 键
     * @param value 值
     */
    void set(String key, Object value);

    /**
     * 设置
     * @param key 键
     * @param value 值
     * @param time 过期时间
     */
    void setex(String key, Object value, long time);

    /**
     * 自增
     * @param key 键
     * @return 自增后的值
     */
    Long incr(String key);

    /**
     * 自减
     * @param key 键
     * @return 自检后的值
     */
    Long decr(String key);

    /**
     * 获取数据
     * @param key 键
     * @param clazz 返回对象烈性
     * @param <T>  泛型
     * @return value
     */
    <T> T get(String key, Class<T> clazz);

    /**
     * 设置值并返回旧值
     * @param key 键
     * @param newValue 新值
     * @param clazz 类对象
     * @param <T> 泛型
     * @return 旧值
     */
    <T> T getset(String key, Object newValue, Class<T> clazz);

    /**
     * hash设置
     * @param key 键
     * @param field 键
     * @param value 值
     */
    void hset(Object key, Object field, Object value);

    /**
     * hash获取
     * @param key 键
     * @param field 键
     * @param clazz 类
     * @param <T> 泛型
     * @return 值
     */
    <T> T hget(Object key, Object field, Class<T> clazz);

}
