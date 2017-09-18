package org.superbiz.moviefun.cachedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;



@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class CacheServiceApplication {
    public static void main(String... args) {
        SpringApplication.run(CacheServiceApplication.class, args);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    RedisCacheManager cacheManager() {
        return new RedisCacheManager(redisTemplate);
    }
}
