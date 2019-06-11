package com.xuxx.ms.mall.seller.api.factories;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.seller.api.SellerService;
import com.xuxx.ms.mall.seller.api.fallback.SellerServiceFallbackImpl;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 9, 2019 9:47:19 PM
 *
 */
@Component
public class SellerServiceFallbackFactory implements FallbackFactory<SellerService> {
	@Override
	public SellerService create(Throwable throwable) {
		SellerServiceFallbackImpl sellerServiceFallback = new SellerServiceFallbackImpl();
		sellerServiceFallback.setCause(throwable);
		return sellerServiceFallback;
	}
}
