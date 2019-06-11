package com.xuxx.ms.mall.typetemplate.api.factories;

import com.xuxx.ms.mall.typetemplate.api.TypeTemplateService;
import com.xuxx.ms.mall.typetemplate.api.fallback.TypeTemplateServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author: xuxx
 * Date: Jun 9, 2019 9:47:19 PM
 *
 */
@Component
public class TypeTemplateServiceFallbackFactory implements FallbackFactory<TypeTemplateService> {
	@Override
	public TypeTemplateService create(Throwable throwable) {
		TypeTemplateServiceFallbackImpl typeTemplateServiceFallback = new TypeTemplateServiceFallbackImpl();
		typeTemplateServiceFallback.setCause(throwable);
		return typeTemplateServiceFallback;
	}
}
