package com.atguigu.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.atguigu.gulimall.ware.dao")
@EnableDiscoveryClient // 添加Nacos客户端注解
public class GulimallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallWareApplication.class, args);
	}

}
