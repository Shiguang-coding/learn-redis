package com.shiguang.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class OrderService {
    public static final String ORDER_KEY = "order:";

    @Resource
    private RedisTemplate redisTemplate;

    // 使用StringRedisTemplate 可以解决序列化乱码问题
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;

    public void addOrder() {
        int keyId = ThreadLocalRandom.current().nextInt(1000) + 1;
        String orderNo = UUID.randomUUID().toString();
        String key = ORDER_KEY + keyId;
        String value = "京东订单" + orderNo;
        redisTemplate.opsForValue().set(key, value);
        log.info("key:{}",key);
        log.info("value:{}",value);
    }

    public String getOrderById(Integer id) {
        return (String) redisTemplate.opsForValue().get(ORDER_KEY + id);
    }
}