package com.javacode.springboot_program.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Guava缓存
 *
 * @author shkstart
 * @create 2022-01-12 13:28
 */
@Component
public class GuavaCacheUtil {
    /**
     * 十分钟缓存
     */
    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            .initialCapacity(10) //缓存初始值大小
            .maximumSize(100) //缓存最大值
            .concurrencyLevel(5) //并发量
            .expireAfterWrite(600, TimeUnit.SECONDS) //缓存过期时间
            .recordStats() //缓存命中率
            .build(); //构建缓存
    /**
     * 一小时缓存
     */
    private Cache<String, Object> oneHoursCache = CacheBuilder.newBuilder()
            .initialCapacity(10) //缓存初始值大小
            .maximumSize(100) //缓存最大值
            .concurrencyLevel(5) //并发量
            .expireAfterWrite(3600,TimeUnit.SECONDS) //缓存过期时间
            .recordStats() //缓存命中率
            .build(); //构建缓存

    /*get set方法*/

    public Cache<String, Object> getOneHoursCache() {
        return oneHoursCache;
    }

    public void setOneHoursCache(Cache<String, Object> oneHoursCache) {
        this.oneHoursCache = oneHoursCache;
    }

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }
}
