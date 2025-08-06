package com.example.lost_and_found.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 */
@Configuration
public class RedisConfig {
    // 配置适用于Long值的RedisTemplate
    @Bean
    public RedisTemplate<String, Long> longRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Long> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // Key序列化器
        template.setKeySerializer(new StringRedisSerializer());

        // Value序列化器
        GenericToStringSerializer<Long> valueSerializer =
                new GenericToStringSerializer<>(Long.class);
        template.setValueSerializer(valueSerializer);

        // HashKey序列化器
        template.setHashKeySerializer(new StringRedisSerializer());

        // HashValue序列化器
        template.setHashValueSerializer(valueSerializer);

        template.afterPropertiesSet();
        return template;
    }

    // 支持常规字符串操作的Template
    @Bean
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }
}


