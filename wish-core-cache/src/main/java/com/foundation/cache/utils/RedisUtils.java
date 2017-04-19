package com.foundation.cache.utils;

import com.foundation.cache.redis.template.JedisTemplate;
import com.foundation.cache.redis.JedisUtils;
import com.foundation.cache.redis.pool.JedisPool;
import com.foundation.cache.redis.pool.JedisPoolBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单的redis缓存模板单利工具类
 * Created by fqh on 2015/12/12
 */
public class RedisUtils {

    private RedisUtils() {
    }

    private static JedisTemplate template;
    static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    static {
        try {
            String redisUrl = PropertiesUtils.getValue("redis.url");
            logger.info("redisUrl=" + redisUrl);
            JedisPool pool = new JedisPoolBuilder().setUrl(redisUrl).buildPool();
            if (!JedisUtils.ping(pool)) {
                throw new RuntimeException("请检查reids连接。ping不通redisredis");
            }
            template = new JedisTemplate(pool);
        } catch (Exception e) {
            logger.error("请检查配置文件reids设置(链接以及访问密码是否设置)");
            throw new RuntimeException("请检查配置文件reids设置(链接以及访问密码是否设置)");
        }
    }

    public static JedisTemplate getTemplate() {
        return template;
    }
}
