package com.xuxx.ms.mall.data.redis;


import java.time.Duration;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.lang.Nullable;

/**
 * redis cache 扩展cache name自动化配置
 *
 */
public class RedisAutoCacheManager extends RedisCacheManager {
	private static final String SPLIT_FLAG = "#";
	private static final int CACHE_LENGTH = 2;

	RedisAutoCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration,
						  Map<String, RedisCacheConfiguration> initialCacheConfigurations, boolean allowInFlightCacheCreation) {
		super(cacheWriter, defaultCacheConfiguration, initialCacheConfigurations, allowInFlightCacheCreation);
	}

	@Override
	protected RedisCache createRedisCache(String name, @Nullable RedisCacheConfiguration cacheConfig) {
		if (StringUtils.isBlank(name) || !name.contains(SPLIT_FLAG)) {
			return super.createRedisCache(name, cacheConfig);
		}

		String[] cacheArray = name.split(SPLIT_FLAG);
		if (cacheArray.length < CACHE_LENGTH) {
			return super.createRedisCache(name, cacheConfig);
		}

		if (cacheConfig != null) {
			long cacheAge = Long.parseLong(cacheArray[1]);
			cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(cacheAge));
		}
		return super.createRedisCache(name, cacheConfig);
	}
}
