package com.xuxx.ms.mall.specification.api.factories;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.specification.api.SpecificationService;
import com.xuxx.ms.mall.specification.api.fallback.SpecificationServiceFallbackImpl;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 9, 2019 9:47:19 PM
 *
 */
@Component
public class SpecificationServiceFallbackFactory implements FallbackFactory<SpecificationService> {
	@Override
	public SpecificationService create(Throwable throwable) {
		SpecificationServiceFallbackImpl brandServiceFallback = new SpecificationServiceFallbackImpl();
		brandServiceFallback.setCause(throwable);
		return brandServiceFallback;
	}
}
