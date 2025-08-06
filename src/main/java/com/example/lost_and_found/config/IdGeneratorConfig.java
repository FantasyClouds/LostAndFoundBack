package com.example.lost_and_found.config;

import com.example.lost_and_found.util.IdGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDate;

/**
 * 用于配置ID生成器
 */
// 更新IdGenerator配置类
@Configuration
public class IdGeneratorConfig {

    // 明确指定使用longRedisTemplate
    @Bean
    public IdGenerator idGenerator(
            @Qualifier("longRedisTemplate") RedisTemplate<String, Long> redisTemplate) {

        LocalDate epochDate = LocalDate.of(2023, 1, 1);
        long minDayOffset = (long) Math.ceil(1e9 /
                (1L << (IdGenerator.getTypeBits() + IdGenerator.getSeqBits())));

        return new IdGenerator(epochDate, (int)minDayOffset, redisTemplate);
    }
}