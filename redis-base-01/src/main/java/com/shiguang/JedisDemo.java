package com.shiguang;


import redis.clients.jedis.Jedis;

import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Set;

/**
 * Created By Shiguang On 2024/9/12 20:38
 */
public class JedisDemo {
    public static void main(String[] args) {
        // 1、获取连接,通过指定ip和端口
        Jedis jedis =  new Jedis("192.168.10.66",6379);

        // 2、指定访问服务器的密码
        jedis.auth("shiguang");

        // 3、获得了jedis客户端,可以像JDBC一样访问Redis
        System.out.println(jedis.ping()); // 返回 PONG 代表连接成功


        // key2
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        // String
        String set = jedis.set("key1", "val1");
        System.out.println(set);
        System.out.println(jedis.get("key1"));

        // list
        jedis.lpush("list", "Java", "Python", "Go");
        List<String> list = jedis.lrange("list", 0, -1);
        for (String element : list) {
            System.out.println(element);
        }


    }

}
