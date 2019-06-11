package com.xuxx.ms.mall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类,接受其它微服务注册进来
public class MSMallEurekaServerApp implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MSMallEurekaServerApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>> 商城系统 Eureka Server 组件 启动完成<<<<<<<<<<<<<");
	}
}
