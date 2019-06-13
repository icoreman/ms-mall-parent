package com.xuxx.ms.mall.goods.api.factories;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.goods.api.GoodsService;
import com.xuxx.ms.mall.goods.api.fallback.GoodsServiceFallbackImpl;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 12, 2019 3:21:44 PM 
 *
 */
@Component
public class GoodsServiceFallbackFactory implements FallbackFactory<GoodsService> {
	@Override
	public GoodsService create(Throwable throwable) {
		GoodsServiceFallbackImpl goodsServiceFallback = new GoodsServiceFallbackImpl();
		goodsServiceFallback.setCause(throwable);
		
		return goodsServiceFallback;
	}
}
