
package com.vikas.config;

/**
 * @author vikas.sivaravindran
 *
 */


import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {

   
    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        return new CustomCacheErrorHandler();
    }
    
    @Bean
    public JedisConnectionFactory jedisConnectionFactory()
    {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("127.0.0.1");
        jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }
    
    
    @Bean
    public RedisTemplate<Object, Object> redisTemplate()
    {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setExposeConnection(true);
        return redisTemplate;
    }
    
    
    @Bean
    public RedisCacheManager cacheManager()
    {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        redisCacheManager.setTransactionAware(true);
        redisCacheManager.setLoadRemoteCachesOnStartup(false);
        redisCacheManager.setUsePrefix(true);
        return redisCacheManager;
    }
    
    
    
}
