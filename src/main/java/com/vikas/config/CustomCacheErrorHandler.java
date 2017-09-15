package com.vikas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import org.springframework.cache.interceptor.CacheErrorHandler;

import lombok.extern.slf4j.Slf4j;


public class CustomCacheErrorHandler implements CacheErrorHandler {

    
	private static final Logger logger = LoggerFactory.getLogger(CustomCacheErrorHandler.class);
	
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
    	logger.error("Cache {} is down to search for key :{} with exception :{}",
                cache.getName(), key, exception.getMessage());
    }

    
    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key,
            Object value) {
    	logger.error("Cache {} is down to put for key :{} with exception :{}",
                cache.getName(), key, exception.getMessage());
    }

   
    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache,
            Object key) {
    	logger.error("Cache {} is down to evict for key :{} with exception :{}",
                cache.getName(), key, exception.getMessage());
    }

    
    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
    	logger.error("Cache {} is down to clear with exception :{}", cache.getName(),
                exception.getMessage());
    }
}
