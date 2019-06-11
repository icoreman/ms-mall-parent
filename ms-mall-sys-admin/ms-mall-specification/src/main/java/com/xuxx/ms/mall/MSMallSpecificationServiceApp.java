package com.xuxx.ms.mall;

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
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@EnableFeignClients
@EnableSwagger2
public class MSMallSpecificationServiceApp implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MSMallSpecificationServiceApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>> 商城系统 规格管理 service 启动完成<<<<<<<<<<<<<");
	}
}
