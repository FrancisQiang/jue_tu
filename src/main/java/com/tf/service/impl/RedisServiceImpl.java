package com.tf.service.impl;

import com.alibaba.fastjson.JSON;
import com.tf.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author lgq
 * @date 2020/1/22
 */
@Service
@SuppressWarnings("unchecked")
public class RedisServiceImpl implements RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    private static int AUTO_INCREMENT = 1;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
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

    public void hset(String key, Object field, Object value) {
        if (field instanceof String
            && value instanceof String) {
            stringRedisTemplate.opsForHash().put(key, field, value);
        }
    }

    @Override
    public <T> T hget(String key, Object field, Class<T> clazz) {
        HashOperations hashOperations = stringRedisTemplate.opsForHash();
        return (T)hashOperations.get(key, field);
    }

    @Override
    public <T> List<T> lrange(String key, long l, long r, Class<T> clazz) {
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        List<String> range = listOperations.range(key, l, r);
        assert range != null;
        return range.stream().map(item -> JSON.parseObject(item, clazz)).collect(Collectors.toList());
    }

    @Override
    public <T> List<T> lrangeAll(String key, Class<T> clazz) {
        return lrange(key, 0, -1, clazz);
    }

    @Override
    public void rpush(String key, Object value) {
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        listOperations.rightPush(key, JSON.toJSONString(value));
    }

    @Override
    public void expire(String key, long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.expire(key, timeout, timeUnit);
    }

    @Override
    public Boolean del(String key) {
        return stringRedisTemplate.delete(key);
    }

    @Override
    public Long llen(String key) {
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.size(key);
    }

    @Override
    public Boolean zadd(String key, String value, double score) {
        ZSetOperations<String, String> stringZSetOperations = stringRedisTemplate.opsForZSet();
        return stringZSetOperations.add(key, value, score);
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        ZSetOperations<String, String> stringZSetOperations = stringRedisTemplate.opsForZSet();
        return stringZSetOperations.range(key, start, end);
    }

    @Override
    public Long zlen(String key) {
        ZSetOperations<String, String> stringZSetOperations = stringRedisTemplate.opsForZSet();
        return stringZSetOperations.size(key);
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        ZSetOperations<String, String> stringZSetOperations = stringRedisTemplate.opsForZSet();
        return stringZSetOperations.reverseRange(key, start, end);
    }
}
