package com.tf.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
    void hset(String key, Object field, Object value);

    /**
     * hash获取
     * @param key 键
     * @param field 键
     * @param clazz 类
     * @param <T> 泛型
     * @return 值
     */
    <T> T hget(String key, Object field, Class<T> clazz);

    /**
     * list range操作
     * @param key 键
     * @param l 左索引
     * @param r 又索引
     * @param clazz 类
     * @param <T> 泛型
     * @return list
     */
    <T> List<T> lrange(String key, long l, long r, Class<T> clazz);

    /**
     * 获取所有列表
     * @param key 键
     * @param clazz 类型
     * @param <T> 泛型
     * @return 列表
     */
    <T> List<T> lrangeAll(String key, Class<T> clazz);

    /**
     *
     * @param key
     * @param value
     */
    void rpush(String key, Object value);

    /**
     * 设置键的超时时间
     * @param key 键
     * @param timeout 超时时长
     * @param timeUnit 单位
     */
    void expire(String key, long timeout, TimeUnit timeUnit);

    /**
     * 删除指定key
     * @param key 键
     * @return true则代表删除成功
     */
    Boolean del(String key);

    /**
     * 获取列表长度
     * @param key 键
     * @return 长度
     */
    Long llen(String key);

    /**
     * 给有序列表添加元素
     * @param key 键
     * @param value 值 唯一
     * @param score 分数 用于排行
     * @return 是否添加成功
     */
    Boolean zadd(String key, String value, double score);

    /**
     * 获取有序列表指定范围
     * @param key 键
     * @param start 开始位置
     * @param end 结束位置
     * @return String集合
     */
    Set<String> zrange(String key, long start, long end);

    /**
     * 获取有序列表长度
     * @param key 键
     * @return 长度
     */
    Long zlen(String key);

    /**
     * 获取有序列表指定范围 倒序
     * @param key 键
     * @param start 开始位置
     * @param end 结束位置
     * @return String集合
     */
    Set<String> zrevrange(String key, long start, long end);

}
