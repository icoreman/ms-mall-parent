package com.xuxx.ms.mall.brand.api.factories;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.brand.api.BrandService;
import com.xuxx.ms.mall.brand.api.fallback.BrandServiceFallbackImpl;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 9, 2019 9:47:19 PM
 *
 */
@Component
public class BrandServiceFallbackFactory implements FallbackFactory<BrandService> {
	@Override
	public BrandService create(Throwable throwable) {
		BrandServiceFallbackImpl brandServiceFallback = new BrandServiceFallbackImpl();
		brandServiceFallback.setCause(throwable);
		return brandServiceFallback;
	}
}
