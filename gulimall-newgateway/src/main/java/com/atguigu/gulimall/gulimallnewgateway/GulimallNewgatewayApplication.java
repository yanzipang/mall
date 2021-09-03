package com.atguigu.gulimall.gulimallnewgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、开启服务注册发现
 * (nacos注册中心地址配置)
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GulimallNewgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallNewgatewayApplication.class, args);
	}

}
