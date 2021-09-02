package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.impl.BrandServiceImpl;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

	@Autowired
	private BrandService brandService;

	@Test
	void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("da品牌");
////		boolean save = brandService.save(brandEntity);
//		boolean b = brandService.updateById(brandEntity);
//
//		System.out.println(b);
////		System.out.println(save);
		BrandEntity one = brandService.getOne(null);
		System.out.println(one);
	}

}
