package com.xuxx.ms.mall.itemcat.api.factories;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.itemcat.api.ItemCatService;
import com.xuxx.ms.mall.itemcat.api.fallback.ItemCatServiceFallback;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 9, 2019 9:47:19 PM
 *
 */
@Component
public class SellerServiceFallbackFactory implements FallbackFactory<ItemCatService> {
	
	@Override
	public ItemCatService create(Throwable throwable) {
		ItemCatServiceFallback itemCatServiceFallback = new ItemCatServiceFallback();
		itemCatServiceFallback.setCause(throwable);
		return itemCatServiceFallback;
	}
}
