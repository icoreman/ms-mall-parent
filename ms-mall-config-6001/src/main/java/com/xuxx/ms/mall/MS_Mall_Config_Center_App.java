package com.xuxx.ms.mall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class MS_Mall_Config_Center_App implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MS_Mall_Config_Center_App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>> 商城系统 配置中心 组件 启动完成<<<<<<<<<<<<<");
	}
}
