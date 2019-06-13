package com.xux.ms.mall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.xuxx.ms.mall" })
@EnableSwagger2
public class MS_Mall_Type_Template_Service_App implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MS_Mall_Type_Template_Service_App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>> 商城系统 类型模板 service 启动完成<<<<<<<<<<<<<");
	}
}
