package com.tf.service.impl;

import com.alibaba.fastjson.JSON;
import com.tf.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author lgq
 * @date 2020/1/22
 */
@Service
public class RedisServiceImpl implements RedisService {


    private final StringRedisTemplate stringRedisTemplate;

    private final RedisTemplate redisTemplate;

    private static int AUTO_INCREMENT = 1;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(String key, Object value) {
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        stringValueOperations.set(key, JSON.toJSONString(value));
    }

    @Override
    public void setex(String key, Object value, long time) {
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        stringValueOperations.set(key, JSON.toJSONString(value), time);
    }

    @Override
    public Long incr(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.increment(key);
    }

    @Override
    public Long decr(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.decrement(key);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String string = valueOperations.get(key);
        if (string != null) {
            return JSON.parseObject(string, clazz);
        }
        return null;
    }

    @Override
    public <T> T getset(String key, Object newValue, Class<T> clazz) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String oldValue = valueOperations.getAndSet(key, JSON.toJSONString(newValue));
        if (oldValue != null) {
            return JSON.parseObject(oldValue, clazz);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void hset(Object key, Object field, Object value) {
        if (key instanceof String && field instanceof String
            && value instanceof String) {
            redisTemplate.opsForHash().put(key, field, value);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T hget(Object key, Object field, Class<T> clazz) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        return (T)hashOperations.get(key, field);
    }
}
