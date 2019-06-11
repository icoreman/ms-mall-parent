package com.xuxx.ms.mall.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * 
 * @ClassName: LoginController
 *
 * @author xuxx
 * @date 2019-05-14 09:17:56
 * @since JDK 1.8
 *
 */
@RestController
public class LoginController {

	@RequestMapping("/login/name")
	public Map<String, String> name() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", name);

		return map;
	}
}
